import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

public class DBConnect {
    //Test zum anlegen von Dokumenten
    private CouchDbProperties properties;
    private CouchDbClient dbClient;
    public DBConnect(String DataBaseName){
        properties =    new CouchDbProperties()
                .setDbName(DataBaseName)
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("kirchbergnet.selfhost.co")
                .setPort(5984)
                .setUsername("Peck")
                .setPassword("20112002")
                .setMaxConnections(100)
                .setConnectionTimeout(0);
        dbClient = new CouchDbClient(properties);
    }

    public CouchDbClient getClient() {
        return dbClient;
    }
}