$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Notifications/EventsSettingsStorageBehaviour");
formatter.feature({
  "line": 1,
  "name": "EventsSettingsStorage",
  "description": "\r\nAs a user\r\nI want to save my settings for notifications",
  "id": "eventssettingsstorage",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Save settings",
  "description": "",
  "id": "eventssettingsstorage;save-settings",
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
  "name": "app save settings: purtcer84@gmail.com, 23912429867-s8or91g0ontvjdt1aeobi4s6uflpsdki.apps.googleusercontent.com, mX9QCErbdXptT5gBUWRWvE7r, Calendar test, 5",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsEventsSettingsStorageBehaviour.application_is_not_run()"
});
formatter.result({
  "duration": 204634351,
  "status": "passed"
});
formatter.match({
  "location": "stepsEventsSettingsStorageBehaviour.I_run_application()"
});
formatter.result({
  "duration": 7614659,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "purtcer84@gmail.com, 23912429867-s8or91g0ontvjdt1aeobi4s6uflpsdki.apps.googleusercontent.com, mX9QCErbdXptT5gBUWRWvE7r, Calendar test, 5",
      "offset": 19
    }
  ],
  "location": "stepsEventsSettingsStorageBehaviour.app_save_settings(String\u003e)"
});
formatter.result({
  "duration": 5118037,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Restore settings",
  "description": "",
  "id": "eventssettingsstorage;restore-settings",
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
  "name": "app restor settings: purtcer84@gmail.com, 23912429867-s8or91g0ontvjdt1aeobi4s6uflpsdki.apps.googleusercontent.com, mX9QCErbdXptT5gBUWRWvE7r, Calendar test, 5",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsEventsSettingsStorageBehaviour.application_is_not_run()"
});
formatter.result({
  "duration": 55102,
  "status": "passed"
});
formatter.match({
  "location": "stepsEventsSettingsStorageBehaviour.I_run_application()"
});
formatter.result({
  "duration": 34439,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "purtcer84@gmail.com, 23912429867-s8or91g0ontvjdt1aeobi4s6uflpsdki.apps.googleusercontent.com, mX9QCErbdXptT5gBUWRWvE7r, Calendar test, 5",
      "offset": 21
    }
  ],
  "location": "stepsEventsSettingsStorageBehaviour.app_restor_settings(String\u003e)"
});
formatter.result({
  "duration": 12635219562,
  "status": "passed"
});
});