﻿*** Setting ***
Library    SeleniumLibrary






*** Test Cases ***
Test Toy R not Us
    Open Browser    http://128.199.190.215:8080/    gc
    wait until page contains element      xpath=//*[@id="select_2"]

    #Filter
    Choose Target and Option    xpath=//*[@id="select_2"]     xpath=//*[@id="select_option_15"]
    Choose Target and Option    xpath=//*[@id="select_4"]     xpath=//*[@id="select_option_19"]
    click button     name=search-button

    #Detail Page
    click element     xpath=/html/body/ng-view/div/div[2]/table/tbody/tr[2]/td[1]
    Choose Target and Option    id=toy-quantity-select    id=toy-9
    click button     name=add-button

    #Shopping Cart Page
    #Choose Target and Option    xpath=//*[@id="select_value_label_22"]    xpath=//*[@id="select_option_83"] 
    click button    id=check-out-button
    wait until element contains      xpath=/html/body/ng-view/div/table/tbody/tr[2]/td[2]      9
    [Teardown]     Close Browser


    #Choose Target and Option    //*[@id="select_2"]     //*[@id="select_option_7"]
    #Choose Target and Option    //*[@id="select_4"]     //*[@id="select_option_19"]
    #[Teardown]     Close Browser




*** Keyword ***
Choose Target and Option
    [Arguments]    ${target}      ${option}
    Set Selenium Speed      2 seconds
    #wait until page contains element      xpath=${target}
    click element    ${target}
    Set Selenium Speed      0.5 seconds
    #wait until page contains element      xpath=${option}    
    click element    ${option}