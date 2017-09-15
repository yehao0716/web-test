package com.ld.services.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.log4j.Logger;

/**
 * Created on 2016/7/11.
 * This is the parent class implementing TableOperation interface.
 * All function sample will extends this class.
 */
public abstract class TableOperationImpl implements TableOperation {
  Logger LOG = Logger.getLogger(TableOperationImpl.class);
  public static Configuration conf = null;
  public static Connection connection = null;
  public static Admin admin = null;

  public TableOperationImpl() {
    init();
  }

  public void init() {
    conf = ConfigurationSample.getConfiguration();
    try {
      connection = ConnectionFactory.createConnection(conf);
      admin = connection.getAdmin();
    } catch (IOException e) {
      LOG.warn("Can not initialize connection or admin.");
    }
  }

  public void close() {
    if (admin != null) {
      try {
        admin.close();
      } catch (IOException e) {
        LOG.warn("Can not close admin.");
      } finally {
        admin = null;
      }
    }
    if (connection != null) {
      try {
        connection.close();
      } catch (IOException e) {
        LOG.warn("Can not close connection.");
      } finally {
        connection = null;
      }
    }
  }
}
