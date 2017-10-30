package com.imaginea.assignments.sustainableliving.database.client;

/**
 * Generic interface for what operations a database client could do in the current context. There
 * may not be a lot of operations which could be abstracted away as there are a plethora of Database
 * types and Database engines, so this will be kind of thin.
 */
public interface GenericDbClient {

  /**
   * Indicates the client should close its underlying Database resources upon quitting or when
   * explicitly called by the user.
   */
  void close();
}
