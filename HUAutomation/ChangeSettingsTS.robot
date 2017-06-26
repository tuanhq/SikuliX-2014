*** Setting ***
Library    OperatingSystem 
Library    SikuliWraper
Library    DateTime
*** Variables ***    
*** Test Cases ***
#Change Setting
#    ${AV image} =    SikuliWraper.Exist Image   0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\AVAppIcon.png
#    Run Keyword If    ${AV image}    Run Keywords   Tap AV    Tap SouceOff
#    Run Keyword Unless    ${AV image}    Run Keywords    Press Hardkey Home    Tap AV    Tap SouceOff
#    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\SettingBTN    
#    ${star image} =    SikuliWraper.Exist Image Collection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\Star
#    Run Keyword If    ${star image}    Run Keyword    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\Star
#    ...        ELSE    Fail And Capture    Not found start image
#    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\Setting
#    :FOR    ${i}    IN RANGE    1    5
#    \    Log    ${i}    
#    \    Run keyword if    ${i}!=1    SikuliWraper.A Swipe Down From   0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\Scroolbar.png
#    \    ${location} =    SikuliWraper.Get Location By Text    0123456789ABCDEF    System Information
#    \    log    ${location}
#    \    Run Keyword If    "${location}" == "${None}"    Continue For Loop    ELSE    Tap A Location And Exit For    ${location}
#    Log    END LOOP
#    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap Text    0123456789ABCDEF    Firmware Information
#    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Long Press Target    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\FirmwareTitle\\FirmwareTitle2.png    4000
#    ${firmware version} =    Wait Until Keyword Succeeds    5s    1s    SikuliWraper.Read Text Right Image    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\FirmwareText\\Firmware.jpg
#    Log  ${firmware version}  
#    Run Keyword And Continue On Failure    Should Contain    ${firmware version}    1.040000
#    ${Data version} =    Wait Until Keyword Succeeds    5s    1s    SikuliWraper.Read Text Right    0123456789ABCDEF    Platform
#    Log  ${Data version}  
#    Run Keyword And Continue On Failure    Should Contain    ${Data version}    1.040000
#    
#    Wait Until Keyword Succeeds    5s    1s    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\ThemeBTN
#    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\Clock.jpg
#    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap    0123456789ABCDEF        ${CURDIR}\\Images\\Settings\\BackBTN.png
#    
#    Run Keyword    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\SpeakerBTN
#    :FOR    ${i}    IN RANGE    1    4
#    \    sleep    2s
#    \    SikuliWraper.A Swipe Down From   0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\Scroolbar.png
#    
#    Run Keyword    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\VideoBTN
#    Run Keyword    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\BluetoothBTN    
#    :FOR    ${i}    IN RANGE    1    4
#    \    sleep    2s
#    \    SikuliWraper.A Swipe Down From   0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\Scroolbar.png
EJECT
#   ${dvd eject}=    SikuliWraper.Exist Image    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DVDEJ.png
#   Run Keyword If    ${dvd eject}    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DVDEJ.png
#   Run Keyword If    ${dvd eject}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
#   Run Keyword Unless    ${dvd eject}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
#   Run Keyword Unless    ${dvd eject}    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DVDEJ.png
#   Run Keyword Unless    ${dvd eject}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
#   ${dvd eject2}=    SikuliWraper.Exist Image    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DVDEJ2.png
#   Run Keyword If    ${dvd eject2}    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DVDEJ2.png
#   Run Keyword If    ${dvd eject2}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
#   Run Keyword Unless    ${dvd eject2}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
#   Run Keyword Unless    ${dvd eject2}    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DVDEJ2.png
#   Run Keyword Unless    ${dvd eject2}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13 
#   ${dvd eject3}=    SikuliWraper.Exist Image    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\SCardBTN.png
#   Run Keyword If    ${dvd eject3}    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\SCardBTN.png
#   Run Keyword If    ${dvd eject3}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
#   Run Keyword Unless    ${dvd eject3}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
#   Run Keyword Unless    ${dvd eject3}    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\SCardBTN.png
#   Run Keyword Unless    ${dvd eject3}    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
    
    ${dvd eject4}=    SikuliWraper.Exist Image    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\IncAngleDis.png
    Run Keyword If    ${dvd eject4}    Tap IncAngleDis 
    Run Keyword Unless    ${dvd eject4}    Tap DecAngleDisable        
*** Keyword ***
Press Hardkey Home
    SikuliWraper.Press Hard Key    0123456789ABCDEF    14
Tap AV
    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\AVAppIcon.png
Tap SouceOff
    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap Colllection    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\SourceOffICon
Fail And Capture
    [Arguments]    ${message}
    Create Directory    ${CURDIR}\\OutputResources
    ${image name} =    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Capture Screen And Return File Name  0123456789ABCDEF    ${CURDIR}\\OutputResources    ${TEST NAME}
    Fail     *HTML*${message} <img src="OutputResources/${image name}" alt="${message}"/>
Tap A Location And Exit For
    [Arguments]    ${location}
    #Log    ${location.x} : ${location.y}
    Wait Until Keyword Succeeds    3s    1s    SikuliWraper.Tap Location    0123456789ABCDEF    ${location.x}    ${location.y}
    Exit For Loop
Tap IncAngleDis
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DecAngleEnable.png
    Sleep    1s
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\IncAngleEnable\\IncAngleEnable.png
    Sleep    1s
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DecAngleEnable.png
    Sleep    1s
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\IncAngleEnable\\IncAngleEnable.png
    Sleep    3s
    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
Tap DecAngleDisable
    SikuliWraper.Press Hard Key    0123456789ABCDEF    13
    Sleep    3s
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\IncAngleEnable\\IncAngleEnable.png
    Sleep    1s
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DecAngleEnable.png
    Sleep    1s
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\IncAngleEnable\\IncAngleEnable.png
    Sleep    1s
    SikuliWraper.Tap    0123456789ABCDEF    ${CURDIR}\\Images\\Settings\\DecAngleEnable.png    
    Sleep    3s
    SikuliWraper.Press Hard Key    0123456789ABCDEF    13