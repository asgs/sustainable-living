package com.imaginea.assignments.sustainableliving.database.client;

import com.mongodb.ServerAddress;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.connection.ClusterSettings;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/** Factory class to instantiate the Database clients for various database types in use. */
public class DatabaseClients {

  public static MongoDbClient buildMongoClient() throws IOException {
    Properties mongoDbProperties = new Properties();
    mongoDbProperties.load(DatabaseClients.class.getResourceAsStream("/mongodb" + ".properties"));
    ClusterSettings clusterSettings =
        ClusterSettings.builder()
            .hosts(
                Arrays.asList(
                    new ServerAddress(
                        mongoDbProperties.getProperty("mongodb.host"),
                        Integer.parseInt(mongoDbProperties.getProperty("mongodb.port")))))
            .build();
    MongoClientSettings mongoClientSettings =
        MongoClientSettings.builder().clusterSettings(clusterSettings).build();
    return new MongoDbClient(mongoClientSettings);
  }
}
