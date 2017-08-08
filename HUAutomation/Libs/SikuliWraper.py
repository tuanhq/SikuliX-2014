from org.sikuli.android import ADBDevice
from org.sikuli.android import ADBScreen
from org.sikuli.basics import Settings
from org.sikuli.script  import Location
from org.sikuli.script import RunTime
from org.sikuli.script import Pattern
from net.sourceforge.tess4j import Word
from org.sikuli.weston import WestonScreen

# # Prepare config
RunTime.loadLibrary("libopencv_java248")
Settings.OcrTextRead = True
Settings.OcrTextSearch = True

class SikuliWraper(object):

    ROBOT_LIBRARY_SCOPE = 'GLOBAL'
    ROBOT_LIBRARY_VERSION = 1.0
    def __init__(self, typeConnect="android", serial_id="0123456789ABCDEF", port="22", user="root", passwd=""):
        self.serial_id = serial_id
        self.typeConnect = typeConnect
        self.host_id = serial_id
        self.port = int(port)
        self.user = user
        self.passwd = passwd
        if typeConnect == "android":
            self.deviceScreen = ADBScreen(self.serial_id)
        elif typeConnect == "weston":
            self.deviceScreen = WestonScreen(self.host_id, self.port, self.user, self.passwd)
        else:
            pass
    def connect_to(self, serial_id):
        self.serial_id = serial_id
        self.deviceScreen = ADBScreen(self.serial_id)
    def print_device(self):
        print self.serial_id 
    def tap_on_key(self, key_id):       
        if (key_id == 'HOME'):    
            self.deviceScreen.aKey(ADBDevice.KEY_HOME)
        elif (key_id == 'BACK'):
            self.deviceScreen.aKey(ADBDevice.KEY_BACK)
        elif (key_id == 'MENU'):
            self.deviceScreen.aKey(ADBDevice.KEY_MENU)
        elif (key_id == 'POWER'):
            self.deviceScreen.aKey(ADBDevice.KEY_POWER)
        else:
            print "nothing to do"
    def tap_location(self, x, y):
          
        self.deviceScreen.aTap(x, y)
    def tap(self, image):        
        self.deviceScreen.aTap(image)
        print self.typeConnect
    def execute_shell(self, shell_comand, *args):
        
        self.deviceScreen.exec1(shell_comand, args)
    def a_swipe(self, image1, image2):
        
        self.deviceScreen.aSwipe(image1, image2)
    def a_swipe_down_from_top(self):
        self.deviceScreen.aSwipeDownFromTop()
    def a_swipe_down(self):
        
        self.deviceScreen.aSwipeDown()
    def a_swipe_up(self):
        
        self.deviceScreen.aSwipeUp()
    
    def a_swipe_left(self,step = "5"):
        self.deviceScreen.aSwipeLeft(int(step))
    def a_swipe_right(self):        
        self.deviceScreen.aSwipeRight()      
        
    def a_swipe_down_from(self, image):
        
        self.deviceScreen.aSwipeDownFrom(image)
    def a_swipe_up_from(self, image):
        
        self.deviceScreen.aSwipeUpFrom(image)
    def a_swipe_left_from(self, image):
        
        self.deviceScreen.aSwipeLeftFrom(image)
    def a_swipe_right_from(self, image):
        
        self.deviceScreen.aSwipeRightFrom(image)
    def exist_text(self,text,order ="1"):
        word = self.deviceScreen.findTextLine(text, int(order))
        if(word == None):
            return False
        else:
            return  True
    def exist_word(self,text,order ="1"):
        word = self.deviceScreen.findWordLine(text, int(order))
        if(word == None):
            return False
        else:
            return  True
    def exist_image(self, image):
        
        if self.deviceScreen.exists(image) != None:
            return True
        else:
            return False
    def exist_image_exact(self, image):
        pattern = Pattern(image)
        if self.deviceScreen.exists(pattern.exact()) != None:
            return True
        else:
            return False
    def type_text(self,text):
        self.deviceScreen.exec1("input text", "'"+text+"'")
    def exist_image_collection(self, image):
        
        if self.deviceScreen.existsCollection(image) != None:
            return True
        else:
            return False
    def read_text_right_image(self, image):
            
        match = self.deviceScreen.find(image)    
        return match.right().readText()
    def read_text_right_image1(self, image, distance):
            
        match = self.deviceScreen.find(image)    
        return match.right(distance).readText()
    def read_text_right1(self, text, distance):
         
        match = self.deviceScreen.getMatchByText(text, 1, 3);    
        return match.right(distance).readText()
    def read_text_right(self, text):
         
        match = self.deviceScreen.getMatchByText(text, 1, 3);
        return match.right().readText()
    def press_hard_key(self, key_id):
        
        self.deviceScreen.eventPressHardKey(int(key_id))
        
    def a_tap_event(self, image):
        
        self.deviceScreen.aTapEvent(image)
    def a_tap_event_exact(self, image):
        
        self.deviceScreen.aTapEventExact(image)

    def event_long_press(self, image, milis):
        
        self.deviceScreen.eventLongPress(image, milis)
        
    def tap_colllection(self, collections):
        
        self.deviceScreen.aTapCollection(collections)    
    def capture_screen_and_return_file_name(self, path, name):
        
        return self.deviceScreen.saveScreenCaptureAndReturnFileName(path, name)
    def capture_screen(self, path, name):
        
        return self.deviceScreen.saveScreenCapture(path, name)
    def tap_text(self, text):        
        self.deviceScreen.aTapText(text)
    def tap_word(self,word):
        self.deviceScreen.aTapWord(word)
    def tap_text_event(self, text):        
        self.deviceScreen.aTapTextEvent(text)
    def tap_word_event(self,word):
        self.deviceScreen.aTapWordEvent(word)
    def get_location_by_text(self, text):
        
        loc1 = self.deviceScreen.getLocationByText(text)  
        if loc1 == None:
            return None
        else:      
            location = LocationPy(loc1.getX(), loc1.getY())
            return location
    def long_press_text(self, text, miliseconds):
        
        loc = self.deviceScreen.getLocationByText(text)
        self.deviceScreen.eventLongPress(loc.x, loc.y, int(miliseconds))
    def long_press_target(self, target, miliseconds):
        
        self.deviceScreen.eventLongPress(target, int(miliseconds))
        
    def type_text_search(self, str_text, pathImage):
        for char1 in str_text:            
            if(char1 == ' '):                
                self.deviceScreen.aTapEvent(pathImage + '/KeySpace.png')
            else:
                self.deviceScreen.aTapEventExact(pathImage + '/Key' + char1.upper() + '.png')
    def type_number_call(self, call_number, pathImage):
        patternNumber = "012345689"
        for char1 in call_number:        
            if(char1 in patternNumber):                
                self.deviceScreen.aTapEvent(pathImage + '/Key'+char1+'.png')
            elif(char1 == '#'):
                self.deviceScreen.aTapEventExact(pathImage + '/KeySharp.png') 
            elif(char1 == '*'):
                self.deviceScreen.aTapEventExact(pathImage + '/KeyStar.png') 
            else:
                continue
    def release_device(self):        
        self.deviceScreen.release()                               
                
class LocationPy:
    def __init__(self, x, y):
        self.x = x
        self.y = y
