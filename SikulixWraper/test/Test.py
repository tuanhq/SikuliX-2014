'''
Created on May 29, 2017

@author: tuanhq
'''

from org.thq import SikuliWraper
from org.sikuli.script import RunTime
from org.sikuli.android import ADBScreen
from org.sikuli.basics import Settings
from org.thq.SikuliWraper import LocationPy
from org.thq import SikuliLibrary

RunTime.loadLibrary("libopencv_java248")



a  = SikuliLibrary.SikuliLibrary(111)
a.devicePrint()

#tap_on_key("4b133ee0e814924e","HOME")

#SikuliWraper.tap("4b133ee0e814924e", "C:\\tmp\\menu.jpg")
#SikuliWraper.execute_shell("4b133ee0e814924e", "input","keyevent","3")
#SikuliWraper.tap("4b133ee0e814924e", "C:\\tmp\\menu.jpg")
#print SikuliWraper.existImage("4b133ee0e814924e", "C:\\tmp\\menu.jpg")

#Settings.OcrTextRead = True
#Settings.OcrTextSearch = True
#adbS = ADBScreen("0123456789ABCDEF")
# adbS.capture().save("C:\\tmp","pionerr")
# math = adbS.find("C:\\tmp\\firmware.jpg")
# if math != None:
#     print "Exist"
# else:
#     print "Not exist"
#     
# print math.readText() 
#print SikuliWraper.ReadTextRightImage("0123456789ABCDEF","C:\\tmp\\firmware.jpg")
#SikuliWraper.tap("0123456789ABCDEF", "C:\\Users\\tuanhq\\projects\\java\\SikuliX-2014\\HUAutomation\\Images\\Settings\\AVAppIcon2.png")
#SikuliWraper.press_hard_key("0123456789ABCDEF", 14)
#loc = SikuliWraper.get_location_by_text("0123456789ABCDEF", "System information")
#print str(loc.x) +":" +str(loc.y)
#adbS.aTap(loc.x, loc.y)
#SikuliWraper.tap_location("0123456789ABCDEF", loc.x, loc.y)
#SikuliWraper.a_swipe_down_from("0123456789ABCDEF", "C:\\Users\\tuanhq\\projects\\java\SikuliX-2014\\HUAutomation\\Images\\Settings\\Scroolbar.png")
