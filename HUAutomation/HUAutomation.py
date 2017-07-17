'''
Created on Jul 14, 2017

@author: tuanhq
'''
import xml.etree.ElementTree as et
import os
from os.path import dirname
import shutil
import sys
from subprocess import Popen
from subprocess import call



#org_repos variable
org_repos = "C:\\Users\\tuanhq\\repository"

#get setting file maven
set_file = os.environ['M2_HOME'] + "/conf/settings.xml"

#variable store maven repository
maven_repository = "tmp"


def get_info():
    # read maven repository directory
    global maven_repository
    global set_file
    global org_repos
    rootMv = et.parse(set_file).getroot()
    for local in rootMv.iter('{http://maven.apache.org/SETTINGS/1.0.0}localRepository'):
        maven_repository = local.text
        break

def rewrite_red_file():
    #rewrite red.xml file
    global maven_repository
    global set_file
    global org_repos
    get_info()
    tree = et.parse('red2.xml')
    root = tree.getroot()
    for cp in root.iter("classpath"):
        for path in cp.findall("path"):
            path.set("location",path.get("location").replace(org_repos,maven_repository) )
    tree.write("red4.xml")              

def rewrite_pydev_project_file():
    global maven_repository
    global set_file
    global org_repos
    
    #rewrite pydev proecjt file
    get_info()
    tree2 = et.parse(".pydevproject")
    root2 = tree2.getroot()    
    for cp in root2.iter("path"):
        cp.text = cp.text.replace(org_repos,maven_repository) 
        
    tree2.write(".pydevproject")
    

def export_lib():
    global maven_repository
    global set_file
    global org_repos
    
    load_repository()
    if os.path.exists("./LibExport"):
        shutil.rmtree("./LibExport")
    if not os.path.exists("./LibExport"):
        os.mkdir("./LibExport")
    tree3 = et.parse('red.xml')
    root3 = tree3.getroot()
    for cp in root3.iter("classpath"):
        for path in cp.findall("path"):
            localPath = path.get("location")
            file_name =  os.path.basename(localPath)
            shutil.copy2(localPath, "./LibExport/"+file_name)

def load_repository():
    cur = os.getcwd()
    parent_cur = dirname(cur)
    call("mvn clean install -DskipTests",cwd=parent_cur,shell=True)       

def rewrite_execute_file():
    global maven_repository
    global set_file
    global org_repos
    
    fileBat = open("HUAutomation.bat","w")    
    fileBat.write("@echo off\n")
    fileBat.write("jython -J-cp  ./LibExport/* -m robot.run HUAutomation.robot\n")     

if __name__ == "__main__":   
    for arg in sys.argv[1:]:
        if arg == "run":
            p = Popen("HUAutomation.bat", cwd=os.getcwd())
            stdout, stderr = p.communicate()
            break
        elif arg == "exportAndRun":
            export_lib()
            rewrite_execute_file()
            p = Popen("HUAutomation.bat", cwd=os.getcwd())
            stdout, stderr = p.communicate()
            break
        elif arg == "export":
            export_lib()
            rewrite_execute_file()
            break
        elif arg == "eclipse":
            rewrite_red_file()
            rewrite_pydev_project_file()
            break
        else:
            print arg
            cur = os.getcwd()
            parent_cur = dirname(cur)
            #call("mvn clean install -DskipTests",cwd=parent_cur,shell=True)
            print "OK"
            break                               
        