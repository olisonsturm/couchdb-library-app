import org.json.JSONObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.Response;

public class Test {
    public static void main(String[] args) {

        //Test zum anlegen von Dokumenten
        CouchDbProperties properties = new CouchDbProperties()
                //DBName anpassen und username und password
                .setDbName("nicotest")
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("localhost")
                .setPort(5984)
                .setUsername("HechtJ")
                .setPassword("146069")
                .setMaxConnections(100)
                .setConnectionTimeout(0);

        // Erstelle einen CouchDB-Client
        CouchDbClient dbClient = new CouchDbClient(properties);


        //Hier wird das json mal generiert
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Elia");
        jsonObject.put("alter", 79);



        // Füge das Dokument zur Datenbank hinzu
        Response response = dbClient.save(jsonObject);

        // Überprüfe die Antwort
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }



        // Schließe die Verbindung zum Client
        dbClient.shutdown();



    }
}

