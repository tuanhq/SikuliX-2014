'''
Created on May 29, 2017

@author: tuanhq
'''
class Person:
    '''
    classdocs    '''

    def __init__(self, name, age):
        '''
        Constructor
        '''
        self.name = name
        self.age =age
        
    def printName(self):
        print self.name    
    def printAge(self):
        print self.age
    def printPerson(self):
        print "Person:"+self.name + "is "+ self.age + "years old"