package com.imaginea.assignments.sustainableliving.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.imaginea.assignments.sustainableliving.database.client.DatabaseClients;
import com.imaginea.assignments.sustainableliving.database.client.MongoDbClient;
import com.imaginea.assignments.sustainableliving.model.Home;
import com.imaginea.assignments.sustainableliving.model.User;
import com.mongodb.async.SingleResultCallback;
import org.bson.Document;

import java.io.IOException;

/** Handles user related operations on the database. */
public class UserManager {
  public static final String USERS_COLLECTION = "users";
  // Could possibly do away with handling the direct Json transformation by
  // using an ODM like Morphia.
  private ObjectMapper objectMapper;
  private MongoDbClient client;

  @Inject
  public UserManager(ObjectMapper objectMapper) throws IOException {
    this.objectMapper = objectMapper;
    client = DatabaseClients.buildMongoClient();
  }

  public void registerUser(User user) throws IOException {
    client.insertContent(objectMapper.writeValueAsString(user), USERS_COLLECTION);
  }

  public void generateReportAsyncly(String id) throws IOException {
    SingleResultCallback<Document> callback =
        (document, throwable) -> {
          if (throwable != null) {
            System.err.println("Unable to find the document; cause is " + throwable.getMessage());

          } else {
            System.out.println("Found document from find - " + document);

            try {
              User user = objectMapper.readValue(document.toJson(), User.class);
              Home home = user.getHome();
              System.out.println(
                  home.getResources()
                      .stream()
                      .map(r -> r.getConsumptionDuring())
                      .reduce(0d, (r1, r2) -> r1 + r2));
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }
        };

    client.findContentAsyncly(id, USERS_COLLECTION, callback);
  }
}
