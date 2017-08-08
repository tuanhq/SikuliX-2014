*** Setting ***
Library    OperatingSystem
Library    DateTime
Library    Libs.SikuliWraper    android    4b133ee0e814924e    WITH NAME    AndroidMB
Library    Libs.SikuliWraper    android    0123456789ABCDEF    WITH NAME    HU
Library    Libs.SikuliWraper    weston    192.168.1.2    22    root    WITH NAME    Weston
Library    Dialogs 
*** Test Cases ***
TC
    #Weston.Capture Screen    C:\\tmp\\trang    Android  
    Weston.Tap    C:\\tmp\\trang\\setup.jpg
    #Sleep    1s    
    #Weston.Capture Screen    C:\\tmp\\trang    Android 
    Weston.Tap Word    Bluetooth
    #Sleep    1s
    #Weston.Capture Screen    C:\\tmp\\trang    Android 
    Weston.Tap Word    Connection  
  
    #Weston.Capture Screen    C:\\tmp\\trang    Android   
    Weston.Release Device
    #AndroidMB.Capture Screen    C:\\tmp\\trang    mymobile
   
   
#Should Be Equal    first    first 
#Should Be Empty    None       
    
