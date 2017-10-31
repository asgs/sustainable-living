package com.imaginea.assignments.sustainableliving.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.imaginea.assignments.sustainableliving.database.client.DatabaseClients;
import com.imaginea.assignments.sustainableliving.database.client.MongoDbClient;
import com.imaginea.assignments.sustainableliving.model.User;

import java.io.IOException;

public class UserManager {
  public static final String USERS_COLLECTION = "users";
  private ObjectMapper objectMapper;
  private MongoDbClient client;

  @Inject
  public UserManager(ObjectMapper objectMapper) throws IOException {
    this.objectMapper = objectMapper;
    client = DatabaseClients.buildMongoClient();
  }

  public void handleUser(User user) throws IOException {
    client.insertContent(objectMapper.writeValueAsString(user), USERS_COLLECTION);
  }
}
