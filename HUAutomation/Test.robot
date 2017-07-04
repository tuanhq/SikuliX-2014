*** Setting ***
Library    Libs.SikuliWraper    ${AndroidMB}    WITH NAME    AndroidMB
Library    Libs.SikuliWraper    ${HU}    WITH NAME    HU
Library    Dialogs    
*** Variable ***
${AndroidMB}    4d000b1448084069
${HU}    0123456789ABCDEF
*** Keyword ***
*** Test Cases ***
TC
   HU.Capture Screen    C:\\tmp    HUNEW  
   Execute Manual Step    Connect Mobile with HU and confirm mobile connect success with HU     
    
