*** Setting ***
Library    Libs.SikuliWraper    ${AndroidMB}    WITH NAME    AndroidMB
Library    Libs.SikuliWraper    ${HU}    WITH NAME    HU
Library    Dialogs 
Library    DateTime    
*** Variable ***
${AndroidMB}    4d000b1448084069
${HU}    0123456789ABCDEF
${bluetooth name}    K7
*** Test Cases ***
Bluetooth connect
    HU.Tap On Key    HOME
    Sleep    1s
    HU.Tap Word    Menus
    Sleep    1s 
    ${word exist}=    HU.Exist Word    Setup
    Run Keyword If    ${word exist}    HU.Tap Word    Setup
    Run Keyword Unless    ${word exist}    HU.A Swipe Left    8
    Run Keyword Unless    ${word exist}    Sleep    1s                           
    Run Keyword Unless    ${word exist}    HU.Tap Word    Setup
    Sleep    1s
    HU.Tap Word    Bluetooth
    Sleep    1s  
    HU.Tap Text    Bluetooth Connection  
    Sleep    1s
     
    
    
    AndroidMB.A Swipe Down From Top
    Sleep    1s
    AndroidMB.Tap    ${CURDIR}/Images/Phone/AndroidSetting3.png
    Sleep    1s
    AndroidMB.Tap Word    Accounts
    Sleep    1s
    AndroidMB.Tap Word    Connectio 
    Sleep    1s
    AndroidMB.Tap Word    Bluetooth
    
    Sleep    1s
    HU.Tap Text    Add New
    Sleep    1s  
    AndroidMB.Tap Word    ${bluetooth name}
    
    
Bluetooth media
    Should Be Equal    first    second
Bluetooth Call
    Should Be Equal    first    second        
    
         
*** Keyword ***