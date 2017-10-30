package com.imaginea.assignments.sustainableliving.database.client;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.*;
import org.bson.Document;

/** */
public class MongoDbClient implements GenericDbClient {

  private MongoClient client;
  private MongoDatabase database = client.getDatabase("test");
  private SingleResultCallback<Void> insertCallback =
      (result, throwable) -> {
        if (throwable != null) {
          System.err.println("Error inserting document. " + throwable.getMessage());
        } else {
          System.out.println("Successfully inserted a json document.");
        }
      };

  public MongoDbClient(MongoClientSettings settings) {
    client = MongoClients.create(settings);
  }

  public void insertContent(String json, String collectionName) {
    MongoCollection collection = database.getCollection(collectionName);
    collection.insertOne(Document.parse(json), insertCallback);
  }

  @Override
  public void close() {
    client.close();
    System.out.println("MongoDb client successfully closed.");
  }
}
