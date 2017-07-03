from org.sikuli.android import ADBDevice
from org.sikuli.android import ADBScreen
from org.sikuli.basics import Settings
from org.sikuli.script  import Location
from org.sikuli.script import RunTime
from org.sikuli.script import Pattern


# # Prepare config
RunTime.loadLibrary("libopencv_java248")
Settings.OcrTextRead = True
Settings.OcrTextSearch = True

class SikuliWraper(object):

    ROBOT_LIBRARY_SCOPE = 'GLOBAL'
    ROBOT_LIBRARY_VERSION = 1.0
    def __init__(self, serial_id="0123456789ABCDEF"):
        self.serial_id = serial_id
        self.adbScreen = ADBScreen(self.serial_id)
    def connect_to(self, serial_id):
        self.serial_id = serial_id
        self.adbScreen = ADBScreen(self.serial_id)
    def print_device(self):
        print self.serial_id 
    def tap_on_key(self, key_id):       
        if (key_id == 'HOME'):    
            self.adbScreen.aKey(ADBDevice.KEY_HOME)
        elif (key_id == 'BACK'):
            self.adbScreen.aKey(ADBDevice.KEY_BACK)
        elif (key_id == 'MENU'):
            self.adbScreen.aKey(ADBDevice.KEY_MENU)
        elif (key_id == 'POWER'):
            self.adbScreen.aKey(ADBDevice.KEY_POWER)
        else:
            print "nothing to do"
    def tap_location(self, x, y):
          
        self.adbScreen.aTap(x, y)
    def tap(self, image):
        
        self.adbScreen.aTap(image)
    def execute_shell(self, shell_comand, *args):
        
        self.adbScreen.exec1(shell_comand, args)
    def a_swipe(self, image1, image2):
        
        self.adbScreen.aSwipe(image1, image2)
    def a_swipe_down_from_top(self):
        self.adbScreen.aSwipeDownFromTop()
    def a_swipe_down(self):
        
        self.adbScreen.aSwipeDown()
    def a_swipe_up(self):
        
        self.adbScreen.aSwipeUp()
    def a_swipe_left(self):
        
        self.adbScreen.aSwipeLeft()
    def a_swipe_right(self):
        
        self.adbScreen.aSwipeRight()
        
        
    def a_swipe_down_from(self, image):
        
        self.adbScreen.aSwipeDownFrom(image)
    def a_swipe_up_from(self, image):
        
        self.adbScreen.aSwipeUpFrom(image)
    def a_swipe_left_from(self, image):
        
        self.adbScreen.aSwipeLeftFrom(image)
    def a_swipe_right_from(self, image):
        
        self.adbScreen.aSwipeRightFrom(image)
    def exist_image(self, image):
        
        if self.adbScreen.exists(image) != None:
            return True
        else:
            return False
    def exist_image_exact(self, image):
        pattern = Pattern(image)
        if self.adbScreen.exists(pattern.exact()) != None:
            return True
        else:
            return False
    def exist_image_collection(self, image):
        
        if self.adbScreen.existsCollection(image) != None:
            return True
        else:
            return False
    def read_text_right_image(self, image):
            
        match = self.adbScreen.find(image)    
        return match.right().readText()
    def read_text_right_image1(self, image, distance):
            
        match = self.adbScreen.find(image)    
        return match.right(distance).readText()
    def read_text_right1(self, text, distance):
         
        match = self.adbScreen.getMatchByText(text, 1, 3);    
        return match.right(distance).readText()
    def read_text_right(self, text):
         
        match = self.adbScreen.getMatchByText(text, 1, 3);
        return match.right().readText()
    def press_hard_key(self, key_id):
        
        self.adbScreen.eventPressHardKey(int(key_id))
        
    def a_tap_event(self, image):
        
        self.adbScreen.aTapEvent(image)
    def a_tap_event_exact(self, image):
        
        self.adbScreen.aTapEventExact(image)

    def event_long_press(self, image, milis):
        
        self.adbScreen.eventLongPress(image, milis)
        
    def tap_colllection(self, collections):
        
        self.adbScreen.aTapCollection(collections)    
    def capture_screen_and_return_file_name(self, path, name):
        
        return self.adbScreen.saveScreenCaptureAndReturnFileName(path, name)
    def capture_screen(self, path, name):
        
        return self.adbScreen.saveScreenCapture(path, name)
    def tap_text(self, text):        
        self.adbScreen.aTapText(text)
    def tap_word(self,word):
        self.adbScreen.aTapWord(word)
    def tap_text_event(self, text):        
        self.adbScreen.aTapTextEvent(text)
    def tap_word_event(self,word):
        self.adbScreen.aTapWordEvent(word)
    def get_location_by_text(self, text):
        
        loc1 = self.adbScreen.getLocationByText(text)  
        if loc1 == None:
            return None
        else:      
            location = LocationPy(loc1.getX(), loc1.getY())
            return location
    def long_press_text(self, text, miliseconds):
        
        loc = self.adbScreen.getLocationByText(text)
        self.adbScreen.eventLongPress(loc.x, loc.y, int(miliseconds))
    def long_press_target(self, target, miliseconds):
        
        self.adbScreen.eventLongPress(target, int(miliseconds))
        
    def type_text_search(self, str_text, pathImage):
        for char1 in str_text:
            print pathImage + '/Key' + char1.upper() + '.png'
            if(char1 == ' '):                
                self.adbScreen.aTapEvent(pathImage + '/KeySpace.png')
            else:
                self.adbScreen.aTapEventExact(pathImage + '/Key' + char1.upper() + '.png')             
class LocationPy:
    def __init__(self, x, y):
        self.x = x
        self.y = y
