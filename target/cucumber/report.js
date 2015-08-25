$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("mainTreadBehaviour");
formatter.feature({
  "line": 1,
  "name": "MainTreadsOfApp",
  "description": "",
  "id": "maintreadsofapp",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#  As a user"
    },
    {
      "line": 4,
      "value": "#  I want to see green icon in Windows Tray"
    },
    {
      "line": 5,
      "value": "#  To know that application is run"
    }
  ],
  "line": 7,
  "name": "Add green icon to Windows Tray",
  "description": "",
  "id": "maintreadsofapp;add-green-icon-to-windows-tray",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "application is not run",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I run application",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "in Windows Tray add green icon",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsmainTreadBehaviour.application_is_not_run()"
});
formatter.result({
  "duration": 1650677,
  "status": "passed"
});
formatter.match({
  "location": "stepsmainTreadBehaviour.I_run_application()"
});
formatter.result({
  "duration": 26583597,
  "status": "passed"
});
formatter.match({
  "location": "stepsmainTreadBehaviour.in_Windows_Tray_add_green_icon()"
});
formatter.result({
  "duration": 349978,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 12,
      "value": "#  As a user"
    },
    {
      "line": 13,
      "value": "#  I want to have 4 items in application menu"
    }
  ],
  "line": 15,
  "name": "menu of icon in Windows Tray",
  "description": "",
  "id": "maintreadsofapp;menu-of-icon-in-windows-tray",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "application is not run",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I run application",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "my application have popup menu of 4 items",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsmainTreadBehaviour.application_is_not_run()"
});
formatter.result({
  "duration": 36264,
  "status": "passed"
});
formatter.match({
  "location": "stepsmainTreadBehaviour.I_run_application()"
});
formatter.result({
  "duration": 6244177,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 34
    }
  ],
  "location": "stepsmainTreadBehaviour.my_application_have_popup_menu_of_4_items(int)"
});
formatter.result({
  "duration": 1303778,
  "status": "passed"
});
});