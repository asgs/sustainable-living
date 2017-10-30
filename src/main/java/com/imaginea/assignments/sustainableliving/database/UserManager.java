package com.imaginea.assignments.sustainableliving.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.imaginea.assignments.sustainableliving.database.client.DatabaseClients;
import com.imaginea.assignments.sustainableliving.database.client.MongoDbClient;
import com.imaginea.assignments.sustainableliving.model.User;

import java.io.IOException;

public class UserManager {
  private ObjectMapper objectMapper;

  @Inject
  public UserManager(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public void handleUser(User user) throws IOException {
    MongoDbClient client = DatabaseClients.buildMongoClient();
    client.insertContent(objectMapper.writeValueAsString(user), "users");
  }
}
