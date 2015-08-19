$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ServersSettings/ServersSettingsStorageBehaviour");
formatter.feature({
  "line": 1,
  "name": "ServerSettingsStorage",
  "description": "\r\nAs a user\r\nI want to save my servers settings",
  "id": "serversettingsstorage",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Save servers settings",
  "description": "",
  "id": "serversettingsstorage;save-servers-settings",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "application is not run",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I run application",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "app save settings",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsServersSettingsStorageBehaviour.application_is_not_run()"
});
formatter.result({
  "duration": 456789264,
  "status": "passed"
});
formatter.match({
  "location": "stepsServersSettingsStorageBehaviour.I_run_application()"
});
formatter.result({
  "duration": 56318,
  "status": "passed"
});
formatter.match({
  "location": "stepsServersSettingsStorageBehaviour.app_save_settings()"
});
formatter.result({
  "duration": 9554622,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Restore servers settings",
  "description": "",
  "id": "serversettingsstorage;restore-servers-settings",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "application is not run",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I run application",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "app restor settings",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsServersSettingsStorageBehaviour.application_is_not_run()"
});
formatter.result({
  "duration": 43758,
  "status": "passed"
});
formatter.match({
  "location": "stepsServersSettingsStorageBehaviour.I_run_application()"
});
formatter.result({
  "duration": 15396,
  "status": "passed"
});
formatter.match({
  "location": "stepsServersSettingsStorageBehaviour.app_restor_settings()"
});
formatter.result({
  "duration": 1702912,
  "status": "passed"
});
});