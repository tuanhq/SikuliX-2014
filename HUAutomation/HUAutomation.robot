*** Setting ***
Library    OperatingSystem
Library    DateTime
Library    Libs.SikuliWraper    4d000b1448084069    WITH NAME    AndroidMB
Library    Libs.SikuliWraper    0123456789ABCDEF    WITH NAME    HU

*** Variables ***   
${AndroidMB}    4d000b1448084069
${HU}    0123456789ABCDEF
${BlueToothName}    Galaxy
${SongName}    Ngo Thuy Mien
${dest address}    Dinh Tien Hoang Hanoi
*** Test Cases ***
Change Setting
    ${AV image} =    HU.Exist Image    ${CURDIR}/Images/Settings/AVAppIcon.png
    Run Keyword If    ${AV image}    Run Keywords   Tap AV    Tap SouceOff
    Run Keyword Unless    ${AV image}    Run Keywords    Press Hardkey Home    Tap AV    Tap SouceOff
    HU.Tap Colllection     ${CURDIR}/Images/Settings/SettingBTN    
    ${star image} =    HU.Exist Image Collection     ${CURDIR}/Images/Settings/Star
    Run Keyword If    ${star image}    Run Keyword    HU.Tap Colllection     ${CURDIR}/Images/Settings/Star
    ...        ELSE    Fail And Capture    Not found start image
    Wait Until Keyword Succeeds    3s    1s    HU.Tap Colllection     ${CURDIR}/Images/Settings/Setting
    :FOR    ${i}    IN RANGE    1    5
    \    Log    ${i}    
    \    Run keyword if    ${i}!=1    HU.A Swipe Down From    ${CURDIR}/Images/Settings/Scroolbar.png
    \    ${location} =    HU.Get Location By Text     System Information
    \    log    ${location}
    \    Run Keyword If    "${location}" == "${None}"    Continue For Loop    ELSE    Tap A Location And Exit For    ${location}
    Log    END LOOP
    Wait Until Keyword Succeeds    3s    1s    HU.Tap Text     Firmware Information
    Wait Until Keyword Succeeds    3s    1s    HU.Long Press Target     ${CURDIR}/Images/Settings/FirmwareTitle/FirmwareTitle2.png    4000
    ${firmware version} =    Wait Until Keyword Succeeds    5s    1s    HU.Read Text Right Image     ${CURDIR}/Images/Settings/FirmwareText/Firmware.jpg
    Log  ${firmware version}  
    Run Keyword And Continue On Failure    Should Contain    ${firmware version}    1.040000
    ${Data version} =    Wait Until Keyword Succeeds    5s    1s    HU.Read Text Right     Platform
    Log  ${Data version}  
    Run Keyword And Continue On Failure    Should Contain    ${Data version}    1.040000
    
    Wait Until Keyword Succeeds    5s    1s    HU.Tap Colllection     ${CURDIR}/Images/Settings/ThemeBTN
    Wait Until Keyword Succeeds    3s    1s    HU.Tap     ${CURDIR}/Images/Settings/Clock.jpg
    Wait Until Keyword Succeeds    3s    1s    HU.Tap         ${CURDIR}/Images/Settings/BackBTN.png
    
    Run Keyword    HU.Tap Colllection     ${CURDIR}/Images/Settings/SpeakerBTN
    :FOR    ${i}    IN RANGE    1    4
    \    sleep    2s
    \    HU.A Swipe Down From    ${CURDIR}/Images/Settings/Scroolbar.png
    
    Run Keyword    HU.Tap Colllection     ${CURDIR}/Images/Settings/VideoBTN
    Run Keyword    HU.Tap Colllection     ${CURDIR}/Images/Settings/BluetoothBTN    
    :FOR    ${i}    IN RANGE    1    4
    \    sleep    2s
    \    HU.A Swipe Down From    ${CURDIR}/Images/Settings/Scroolbar.png
Press Eject Icon  
	Press Eject Icon    ${CURDIR}/Images/Settings/DVDEJ.png	
	Press Eject Icon    ${CURDIR}/Images/Settings/DVDEJ2.png	
	Press Eject Icon    ${CURDIR}/Images/Settings/SCardBTN.png 
	
	${image exist} =    HU.Exist Image    ${CURDIR}/Images/Settings/DVDEJ.png
	Run Keyword If    ${image exist}    Press Inc Or Dec Angle
	Run Keyword Unless    ${image exist}    HU.Press Hard Key    13
    Run Keyword Unless    ${image exist}    Sleep    1s 
    Run Keyword Unless    ${image exist}    Press Inc Or Dec Angle
Call Via Bluetooth
    AndroidMB.Tap On Key    HOME
    Sleep    1s
    AndroidMB.A Swipe Down From Top   
    ${image exist2} =    AndroidMB.Exist Image Exact   ${CURDIR}/Images/Phone/AndroidBlueToothDis.png
    Run Keyword If    ${image exist2}    AndroidMB.Tap    ${CURDIR}/Images/Phone/AndroidBlueToothDis.png
    Run Keyword If    ${image exist2}    Sleep    1s
    Run Keyword If    ${image exist2}    AndroidMB.Tap    ${CURDIR}/Images/Phone/AndroidCheckBox.png  
    Sleep    1s 
    AndroidMB.Tap On Key    HOME

    ${AV image} =    HU.Exist Image    ${CURDIR}/Images/Settings/AVAppIcon.png
    Run Keyword Unless    ${AV image}    Press Hardkey Home
    Run Keyword Unless    ${AV image}    Sleep    1s    
    ${image exist2} =    HU.Exist Image Exact   ${CURDIR}/Images/Settings/CallEnaBlue.png
    Run Keyword If    ${image exist2}    HU.Tap    ${CURDIR}/Images/Settings/CallEnaBlue.png
    Run Keyword If    ${image exist2}    HU.Tap Colllection     ${CURDIR}/Images/Phone/HUKeypad
    Run Keyword Unless    ${image exist2}    Connect bluetooth
    Sleep	1s	
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad0.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad9.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad8.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad5.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad6.png
	Sleep	1s
	HU.Tap	${CURDIR}/Images/Phone/HUKeyPad3
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad3.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad4.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad6.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPad9.png
	Sleep	1s
	HU.Tap    ${CURDIR}/Images/Phone/HUKeyPadCall.png
	Sleep	8s
	HU.Tap    ${CURDIR}/Images/Phone/EndCall.png
Android Auto
    Press Hardkey Home
    Sleep    1s
    HU.Tap    ${CURDIR}/Images/Settings/AndroidAutoIC.png
    Sleep    1s
    HU.A Tap Event    ${CURDIR}/Images/Phone/AndroidAutoHomeIcon/AndroidAutoHomeIcon.png    
    Sleep    1s
    HU.A Tap Event    ${CURDIR}/Images/Phone/ListenMusicIcon/ListenMusicIcon.png
    Sleep    1s
    HU.Tap Word Event    Google
    Sleep    1s
    
    HU.Tap Text Event    Recent activity    
    Sleep    1s
    HU.Tap Text Event    ${SongName}
    
    ${image exists} =    HU.Exist Image Exact    ${CURDIR}/Images/Phone/PlayBTN.png
    Log    ${image exists} 
    Run Keyword If    ${image exists}    HU.A Tap Event    ${CURDIR}/Images/Phone/PlayBTN.png
    Sleep    10s 
    
    HU.A Tap Event    ${CURDIR}/Images/Phone/NextBTN.png
    Sleep    10s
    HU.A Tap Event    ${CURDIR}/Images/Phone/NextBTN.png    
    Sleep    10s
    HU.A Tap Event    ${CURDIR}/Images/Phone/PrevButton.png
    Sleep    10s
    HU.A Tap Event    ${CURDIR}/Images/Phone/PrevButton.png
Android Auto 2
    Press Hardkey Home
    Sleep    1s
    HU.Tap    ${CURDIR}/Images/Settings/AndroidAutoIC.png
    Sleep    1s
    HU.A Tap Event    ${CURDIR}/Images/Phone/AndroidAutoHomeIcon/AndroidAutoHomeIcon.png 
    Sleep    1s
    
    HU.A Tap Event    ${CURDIR}/Images/Phone/NaviIcon.png
    Sleep    1s
    HU.A Tap Event    ${CURDIR}/Images/Phone/GGMapSearch.png
    HU.Type Text Search    ${dest address}    ${CURDIR}/Images/HU/keyboard 
    
    HU.A Tap Event    ${CURDIR}/Images/HU/keyboard/KeySearch.png
    HU.A Tap Event Exact    ${CURDIR}/Images/Phone/direct.png
    HU.A Tap Event Exact    ${CURDIR}/Images/Phone/UpArrow.png
    HU.A Tap Event Exact    ${CURDIR}/Images/Phone/RightArrow.png
    :FOR    ${i}    IN RANGE    99
    \    ${image exist}=    HU.Exist Image Exact    ${CURDIR}/Images/Phone/RightArrowBlack.png
    \    Run Keyword If    ${image exist}    HU.A Tap Event Exact     ${CURDIR}/Images/Phone/RightArrowBlack.png
    \    Run Keyword Unless    ${image exist}    Exit For Loop
    HU.A Tap Event Exact    ${CURDIR}/Images/Phone/Recenter.png
    HU.A Tap Event Exact    ${CURDIR}/Images/Phone/Recenter.png
    HU.A Tap Event Exact    ${CURDIR}/Images/Phone/CloseGGMap.png   
             
            
*** Keyword ***
Connect bluetooth
    ${AV image} =    HU.Exist Image    ${CURDIR}/Images/Settings/AVAppIcon.png
    Run Keyword If    ${AV image}    Run Keywords   Tap AV    Tap SouceOff
    Run Keyword Unless    ${AV image}    Run Keywords    Press Hardkey Home    Tap AV    Tap SouceOff
    Wait Until Keyword Succeeds    2s    1s    HU.Tap Colllection     ${CURDIR}/Images/Settings/SettingBTN    
    
    Run Keyword And Continue On Failure    HU.Tap Colllection     ${CURDIR}/Images/Settings/BluetoothBTN
    HU.Tap Word    Connection
    HU.Tap Text    ${BlueToothName}
    Sleep	2s
    HU.Tap Colllection     ${CURDIR}/Images/Phone/HUKeypad
Press Inc Or Dec Angle
    ${dvd eject4}=    HU.Exist Image     ${CURDIR}/Images/Settings/IncAngleDis.png
    Run Keyword If    ${dvd eject4}    Tap IncAngleDis 
    Run Keyword Unless    ${dvd eject4}    Tap DecAngleDisable

Press Eject Icon
   [Arguments]    ${image path}
   ${image exist}=    HU.Exist Image     ${image path}
   Run Keyword If    ${image exist}    Wait Until Keyword Succeeds    3s    1s    HU.Tap     ${image path}
   Run Keyword If    ${image exist}    Sleep    1s    
   Run Keyword If    ${image exist}    HU.Press Hard Key     13
   Run Keyword If    ${image exist}    Sleep    1s
   Run Keyword Unless    ${image exist}    HU.Press Hard Key    13
   Run Keyword Unless    ${image exist}    Sleep    1s
   Run Keyword Unless    ${image exist}    Wait Until Keyword Succeeds    3s    1s    HU.Tap    ${image path}
   Run Keyword Unless    ${image exist}    Sleep    1s
   Run Keyword Unless    ${image exist}    HU.Press Hard Key     13
   Run Keyword Unless    ${image exist}    Sleep    1s 
    
Press Hardkey Home
    HU.Press Hard Key     14
Tap AV
    Wait Until Keyword Succeeds    3s    1s    HU.Tap     ${CURDIR}/Images/Settings/AVAppIcon.png
Tap SouceOff
    Wait Until Keyword Succeeds    3s    1s    HU.Tap Colllection     ${CURDIR}/Images/Settings/SourceOffICon
Fail And Capture
    [Arguments]    ${message}
    Create Directory    ${CURDIR}/OutputResources
    ${image name} =    Wait Until Keyword Succeeds    3s    1s    HU.Capture Screen And Return File Name  0123456789ABCDEF    ${CURDIR}/OutputResources    ${TEST NAME}
    Fail     *HTML*${message} <img src="OutputResources/${image name}" alt="${message}"/>
Tap A Location And Exit For
    [Arguments]    ${location}
    #Log    ${location.x} : ${location.y}
    Wait Until Keyword Succeeds    3s    1s    HU.Tap Location     ${location.x}    ${location.y}
    Exit For Loop
Tap IncAngleDis
    HU.Tap     ${CURDIR}/Images/Settings/DecAngleEnable.png
    Sleep    1s
    HU.Tap     ${CURDIR}/Images/Settings/IncAngleEnable/IncAngleEnable.png
    Sleep    1s
    HU.Tap     ${CURDIR}/Images/Settings/DecAngleEnable.png
    Sleep    1s
    HU.Tap     ${CURDIR}/Images/Settings/IncAngleEnable/IncAngleEnable.png
    Sleep    3s
    HU.Press Hard Key     13
Tap DecAngleDisable
    HU.Press Hard Key     13
    Sleep    1s
    HU.Tap     ${CURDIR}/Images/Settings/IncAngleEnable/IncAngleEnable.png
    Sleep    1s
    HU.Tap     ${CURDIR}/Images/Settings/DecAngleEnable.png
    Sleep    1s
    HU.Tap     ${CURDIR}/Images/Settings/IncAngleEnable/IncAngleEnable.png
    Sleep    1s
    HU.Tap     ${CURDIR}/Images/Settings/DecAngleEnable.png    
    Sleep    1s
    HU.Press Hard Key     13

    