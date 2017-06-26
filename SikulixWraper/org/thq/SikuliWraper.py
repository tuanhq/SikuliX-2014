'''
Created on May 29, 2017

@author: tuanhq
'''
from org.sikuli.android import ADBDevice
from org.sikuli.android import ADBScreen
from org.sikuli.script import RunTime
from org.sikuli.basics import Settings
from org.sikuli.script  import Location

## Prepare config
RunTime.loadLibrary("libopencv_java248")
Settings.OcrTextRead=True
Settings.OcrTextSearch=True

#end prepare config            
def tap_on_key(serial_id,key_id):        
    adbScreen = ADBScreen(serial_id)
    if (key_id == 'HOME'):    
        adbScreen.aKey(ADBDevice.KEY_HOME)
    elif (key_id == 'BACK' ):
        adbScreen.aKey(ADBDevice.KEY_BACK)
    elif (key_id == 'MENU' ):
        adbScreen.aKey(ADBDevice.KEY_MENU)
    elif (key_id == 'POWER' ):
        adbScreen.aKey(ADBDevice.KEY_POWER)
    else:
        print "nothing to do"
def tap_location(serial_id,x,y):
    adbScreen = ADBScreen(serial_id)  
    adbScreen.aTap(x,y)
def tap(serial_id,image):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aTap(image)
def execute_shell(serial_id,shell_comand,*args):
    adbScreen = ADBScreen(serial_id)
    adbScreen.exec1(shell_comand,args)
def a_swipe(serial_id,image1,image2):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipe(image1, image2)
    
def a_swipe_down(serial_id):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeDown()
def a_swipe_up(serial_id):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeUp()
def a_swipe_left(serial_id):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeLeft()()
def a_swipe_right(serial_id):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeRight()
    
    
def a_swipe_down_from(serial_id,image):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeDownFrom(image)
def a_swipe_up_from(serial_id,image):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeUpFrom(image)
def a_swipe_left_from(serial_id,image):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeLeftFrom(image)
def a_swipe_right_from(serial_id,image):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aSwipeRightFrom(image)
def exist_image(serial_id, image):
    adbScreen = ADBScreen(serial_id)
    if adbScreen.exists(image) != None:
        return True
    else:
        return False
def exist_image_collection(serial_id,image):
    adbScreen = ADBScreen(serial_id)
    if adbScreen.existsCollection(image) != None:
        return True
    else:
        return False
def read_text_right_image(serial_id,image):
    adbScreen = ADBScreen(serial_id)    
    match = adbScreen.find(image)    
    return match.right().readText()
def read_text_right_image1(serial_id,image, distance):
    adbScreen = ADBScreen(serial_id)    
    match = adbScreen.find(image)    
    return match.right(distance).readText()
def read_text_right1(serial_id,text,distance):
    adbScreen = ADBScreen(serial_id) 
    match = adbScreen.getMatchByText(text,1,3);    
    return match.right(distance).readText()
def read_text_right(serial_id,text):
    adbScreen = ADBScreen(serial_id) 
    match = adbScreen.getMatchByText(text,1,3);
    return match.right().readText()
def press_hard_key(serial_id,key_id):
    adbScreen = ADBScreen(serial_id)
    adbScreen.eventPressHardKey(int(key_id))
    
def a_tap_event(serial_id,image):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aTapEvent(image)

def event_long_press(serial_id,image,milis):
    adbScreen = ADBScreen(serial_id)
    adbScreen.eventLongPress(image,milis)
    
def tap_colllection(serial_id,collections):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aTapCollection(collections)    
def capture_screen_and_return_file_name(serial_id,path,name):
    adbScreen = ADBScreen(serial_id)
    return adbScreen.saveScreenCaptureAndReturnFileName(path, name)
def capture_screen(serial_id,path,name):
    adbScreen = ADBScreen(serial_id)
    return adbScreen.saveScreenCapture(path,name)
def tap_text(serial_id,text):
    adbScreen = ADBScreen(serial_id)
    adbScreen.aTapText(text)
def get_location_by_text(serial_id,text):
    adbScreen = ADBScreen(serial_id)
    loc1 = adbScreen.getLocationByText(text)  
    if loc1  == None:
        return None
    else:      
        location = LocationPy(loc1.getX(),loc1.getY())
        return location
def long_press_text(serial_id,text,miliseconds):
    adbScreen = ADBScreen(serial_id)
    loc = adbScreen.getLocationByText(text)
    adbScreen.eventLongPress(loc.x,loc.y, int(miliseconds))
def long_press_target(serial_id,target,miliseconds):
    adbScreen = ADBScreen(serial_id)
    adbScreen.eventLongPress(target, int(miliseconds))
    
class LocationPy:
    def __init__(self,x,y):
        self.x = x
        self.y = y

                  
  
    
    
        
        
    