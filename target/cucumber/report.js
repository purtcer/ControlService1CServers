$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ServerAuthentication/ServerAuthenticationFormBehaviour");
formatter.feature({
  "line": 1,
  "name": "ServerAuthenticationFormWork",
  "description": "\r\nAs a user\r\nI want to save my settings for server authentication from settings form",
  "id": "serverauthenticationformwork",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Restore settings",
  "description": "",
  "id": "serverauthenticationformwork;restore-settings",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "form settings is not run",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I run form settings",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "app restore settings on form: UserName, UserPass",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsServerAuthenticationFormBehaviour.form_settings_is_not_run()"
});
formatter.result({
  "duration": 190245879,
  "status": "passed"
});
formatter.match({
  "location": "stepsServerAuthenticationFormBehaviour.I_run_form_settings()"
});
formatter.result({
  "duration": 427886397,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "UserName, UserPass",
      "offset": 30
    }
  ],
  "location": "stepsServerAuthenticationFormBehaviour.app_restor_settings_on_form(String\u003e)"
});
formatter.result({
  "duration": 19461647,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Save settings",
  "description": "",
  "id": "serverauthenticationformwork;save-settings",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "notifications settings form is open",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I press save button",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "app save settings on form: UserName, UserPass",
  "keyword": "Then "
});
formatter.match({
  "location": "stepsServerAuthenticationFormBehaviour.notifications_settings_form_is_open()"
});
formatter.result({
  "duration": 16197578,
  "status": "passed"
});
formatter.match({
  "location": "stepsServerAuthenticationFormBehaviour.I_press_save_button()"
});
formatter.result({
  "duration": 5714552,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "UserName, UserPass",
      "offset": 27
    }
  ],
  "location": "stepsServerAuthenticationFormBehaviour.app_save_settings_on_form(String\u003e)"
});
formatter.result({
  "duration": 1985345,
  "status": "passed"
});
});