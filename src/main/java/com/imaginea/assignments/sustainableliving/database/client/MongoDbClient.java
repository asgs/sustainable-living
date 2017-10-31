package com.imaginea.assignments.sustainableliving.database.client;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 * The client the callers would use to interact with the Mongodb. Typical operations are inserting,
 * updating, reading records on user's demand.
 */
public class MongoDbClient implements GenericDbClient {

  public static final String DB_NAME = "test";
  private MongoClient client;
  private MongoDatabase database;
  private SingleResultCallback<Void> insertCallback =
      (result, throwable) -> {
        if (throwable != null) {
          System.err.println("Error inserting document. cause - " + throwable.getMessage());
        } else {
          System.out.println("Successfully inserted a document. Result - " + result);
        }
      };

  public MongoDbClient(MongoClientSettings settings) {
    client = MongoClients.create(settings);
    database = client.getDatabase(DB_NAME);
  }

  /**
   * Given the JSON document to be persisted under the specified collectionName, this method will
   * insert into Mongodb.
   *
   * @param json - The document
   * @param collectionName - The collection to which the document belongs.
   */
  public void insertContent(String json, String collectionName) {
    MongoCollection collection = database.getCollection(collectionName);
    collection.insertOne(Document.parse(json), insertCallback);
  }

  /**
   * Given a document id, this allows a user to execute a find on the specified collection and
   * execute the callback passed in when the result is available.
   *
   * @param id - The document identifier.
   * @param collectionName - The collection to which the document belongs.
   * @param callback - The callback the caller provides to process the result.
   */
  public void findContentAsyncly(
      String id, String collectionName, SingleResultCallback<Document> callback) {
    MongoCollection collection = database.getCollection(collectionName);
    collection.find(eq("id", id)).first(callback);
  }

  @Override
  public void close() {
    client.close();
    System.out.println("MongoDb client successfully closed.");
  }
}
