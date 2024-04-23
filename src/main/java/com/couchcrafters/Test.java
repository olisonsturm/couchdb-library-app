package com.couchcrafters;

import org.json.JSONObject;
import org.lightcouch.Response;

public class Test {
    public static void main(String[] args) {

        //com.couchcrafters.Test zum anlegen von Dokumenten

        DBConnect db = new DBConnect("test");


        //Hier wird das json mal generiert
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Elia");
        jsonObject.put("alter", 79);

        //com.couchcrafters.Test

        // Füge das Dokument zur Datenbank hinzu
        Response response = db.getClient().save(jsonObject);

        // Überprüfe die Antwort
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }



        // Schließe die Verbindung zum Client
        db.getClient().shutdown();



    }
}

