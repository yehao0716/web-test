package com.ld.services.hbase;

import java.util.List;

public interface TableOperation {
  
  //init the parameters
  public void init();
  
  // do the operation in each function
  public List<String> process(String tableNameStr, String col);
  
  // close all connections
  public void close();
}
