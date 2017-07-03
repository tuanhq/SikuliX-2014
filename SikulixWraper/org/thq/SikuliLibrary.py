'''Created on May 29, 2017

@author: tuanhq
'''
from org.sikuli.android import ADBDevice
from org.sikuli.android import ADBScreen
from org.sikuli.script import RunTime
from org.sikuli.basics import Settings
from org.sikuli.script  import Location
# # Prepare config
RunTime.loadLibrary("libopencv_java248")
Settings.OcrTextRead = True
Settings.OcrTextSearch = True
# end prepare config

def hello_world():
    print "Hello world"         
'''

class SikuliLibrary:
    # ROBOT_LIBRARY_SCOPE = 'TEST SUITE'
    def __init__(self, serial_id):
        self.serial_id  = serial_id    
    def tap_on_key(self, key_id):        
        adbScreen = ADBScreen(self.serial_id)
        if (key_id == 'HOME'):    
            adbScreen.aKey(ADBDevice.KEY_HOME)
        elif (key_id == 'BACK'):
            adbScreen.aKey(ADBDevice.KEY_BACK)
        elif (key_id == 'MENU'):
            adbScreen.aKey(ADBDevice.KEY_MENU)
        elif (key_id == 'POWER'):
            adbScreen.aKey(ADBDevice.KEY_POWER)
        else:
            print "nothing to do"
    def tap_location(self, x, y):
        adbScreen = ADBScreen(self.serial_id)  
        adbScreen.aTap(x, y)
    def tap(self, image):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aTap(image)
    def execute_shell(self, shell_comand, *args):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.exec1(shell_comand, args)
    def a_swipe(self, image1, image2):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipe(image1, image2)
        
    def a_swipe_down(self):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeDown()
    def a_swipe_up(self):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeUp()
    def a_swipe_left(self):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeLeft()()
    def a_swipe_right(self):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeRight()
        
        
    def a_swipe_down_from(self, image):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeDownFrom(image)
    def a_swipe_up_from(self, image):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeUpFrom(image)
    def a_swipe_left_from(self, image):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeLeftFrom(image)
    def a_swipe_right_from(self, image):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aSwipeRightFrom(image)
    def exist_image(self, image):
        adbScreen = ADBScreen(self.serial_id)
        if adbScreen.exists(image) != None:
            return True
        else:
            return False
    def exist_image_collection(self, image):
        adbScreen = ADBScreen(self.serial_id)
        if adbScreen.existsCollection(image) != None:
            return True
        else:
            return False
    def read_text_right_image(self, image):
        adbScreen = ADBScreen(self.serial_id)    
        match = adbScreen.find(image)    
        return match.right().readText()
    def read_text_right_image1(self, image, distance):
        adbScreen = ADBScreen(self.serial_id)    
        match = adbScreen.find(image)    
        return match.right(distance).readText()
    def read_text_right1(self, text, distance):
        adbScreen = ADBScreen(self.serial_id) 
        match = adbScreen.getMatchByText(text, 1, 3);    
        return match.right(distance).readText()
    def read_text_right(self, text):
        adbScreen = ADBScreen(self.serial_id) 
        match = adbScreen.getMatchByText(text, 1, 3);
        return match.right().readText()
    def press_hard_key(self, key_id):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.eventPressHardKey(int(key_id))
        
    def a_tap_event(self, image):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aTapEvent(image)

    def event_long_press(self, image, milis):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.eventLongPress(image, milis)
        
    def tap_colllection(self, collections):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aTapCollection(collections)    
    def capture_screen_and_return_file_name(self, path, name):
        adbScreen = ADBScreen(self.serial_id)
        return adbScreen.saveScreenCaptureAndReturnFileName(path, name)
    def capture_screen(self, path, name):
        adbScreen = ADBScreen(self.serial_id)
        return adbScreen.saveScreenCapture(path, name)
    def tap_text(self, text):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.aTapText(text)
    def get_location_by_text(self, text):
        adbScreen = ADBScreen(self.serial_id)
        loc1 = adbScreen.getLocationByText(text)  
        if loc1 == None:
            return None
        else:      
            location = LocationPy(loc1.getX(), loc1.getY())
            return location
    def long_press_text(self, text, miliseconds):
        adbScreen = ADBScreen(self.serial_id)
        loc = adbScreen.getLocationByText(text)
        adbScreen.eventLongPress(loc.x, loc.y, int(miliseconds))
    def long_press_target(self, target, miliseconds):
        adbScreen = ADBScreen(self.serial_id)
        adbScreen.eventLongPress(target, int(miliseconds))
    
class LocationPy:
    def __init__(self, x, y):
        self.x = x
        self.y = y

'''             
  
    
    
        
        
    
        
