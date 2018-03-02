*** Setting ***
Library    SeleniumLibrary






*** Test Cases ***
Test Toy R not Us
    Open Browser    http://128.199.190.215:8080/    gc
    wait until page contains element      xpath=//*[@id="select_2"]

    #Filter
    Choose Target and Option    xpath=//*[@id="select_2"]     xpath=//*[@id="select_option_12"]
    Choose Target and Option    xpath=//*[@id="select_4"]     xpath=//*[@id="select_option_18"]
    click button     name=search-button

    #Detail Page
    click element     xpath=/html/body/ng-view/div/div/div[2]/table/tbody/tr[2]/td[1]
    Choose Target and Option    id=toy-quantity-select    id=toy-5
    click button     name=add-button

    #Edit Shopping Cart Page 1
    click element    xpath=//*[@id="go-home"]

    #-------------------------------------------------------------------------------------------------

    #Filter
    wait until page contains element      xpath=//*[@id="select_27"]
    Choose Target and Option    xpath=//*[@id="select_27"]     xpath=//*[@id="select_option_34"]
    Choose Target and Option    xpath=//*[@id="select_29"]     xpath=//*[@id="select_option_43"]
    click button     name=search-button

    #Detail Page
    click element     xpath=/html/body/ng-view/div/div/div[2]/table/tbody/tr[2]/td[1]
    Choose Target and Option    id=toy-quantity-select    id=toy-6
    click button     name=add-button

    #Edit Shopping Cart Page 2
    Choose Target and Option    id=toy-select-quantity    xpath=//*[@id="toy-select0-2"]




    click button    id=check-out-button
    wait until element contains      xpath=/html/body/ng-view/div/h1      Thank you for you shopping
    [Teardown]     Close Browser




*** Keyword ***
Choose Target and Option
    [Arguments]    ${target}      ${option}
    Set Selenium Speed      2 seconds
    #wait until page contains element      xpath=${target}
    click element    ${target}
    Set Selenium Speed      0.5 seconds
    #wait until page contains element      xpath=${option}    
    click element    ${option}

STEP Filter
    [Arguments]    ${target}      ${option}
    Set Selenium Speed      2 seconds
    #wait until page contains element      xpath=${target}
    click element    ${target}
    Set Selenium Speed      0.5 seconds
    #wait until page contains element      xpath=${option}    
    click element    ${option}