package Notifications;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

public class ServerEvents {

    private static String applicationName;
    private static com.google.api.services.calendar.Calendar client;
    private static HttpTransport httpTransport;
    private static FileDataStoreFactory dataStoreFactory;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static String clientSecretsString;

    private void initCalendarSettings(){
        EventsSettingsStorage settingsStorage = new EventsSettingsStorage();
        String[] eventsSettings = settingsStorage.getEventsSettings();
        applicationName = eventsSettings[0];
        clientSecretsString = "{\n" +
                "  \"installed\": {\n" +
                "    \"client_id\": \"" + eventsSettings[1] + "\",\n" +
                "    \"client_secret\": \"\" + eventsSettings[2] + \"\"\n" +
                "  }\n" +
                "}";
    }

    private static Credential authorize() throws Exception {

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new StringReader(clientSecretsString));
        // set up authorization code flow
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets,
                Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(dataStoreFactory)
                .build();
        // authorize
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    private static void addEvent(Calendar calendar) throws IOException {
        Event event = newEvent();
        Event result = client.events().insert(calendar.getId(), event).execute();
    }

    public ServerEvents(){
        initCalendarSettings();
        try {
            // initialize the transport
            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            Credential credential = authorize();
            client = new com.google.api.services.calendar.Calendar.Builder(httpTransport,
                    JSON_FACTORY, credential).setApplicationName(applicationName).build();
            Calendar calendar = addCalendar();
            addEvent(calendar);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }
    }

    private static Calendar addCalendar() throws IOException {
        Calendar entry = new Calendar();
        entry.setSummary("Работа сервера");
        Calendar result = client.calendars().insert(entry).execute();
        return result;
    }

    private static Event newEvent() {
        Event event = new Event();
        event.setSummary("Ошибка сервера");
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 3600000);
        DateTime start = new DateTime(startDate, TimeZone.getTimeZone("UTC"));
        event.setStart(new EventDateTime().setDateTime(start));
        DateTime end = new DateTime(endDate, TimeZone.getTimeZone("UTC"));
        event.setEnd(new EventDateTime().setDateTime(end));
        return event;
    }
}
