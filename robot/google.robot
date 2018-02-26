*** Settings ***
Library    SeleniumLibrary

*** Test Cases ***
Search Google
    Open Browser    https://google.com    gc
    Input Text    name=q    bnk48
    Click Button    name=btnK
    Page Should Contain    คุกกี้เสี่ยงทาย