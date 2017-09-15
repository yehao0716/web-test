package com.ld.services.hbase;

import java.io.File;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

/**
 * Created on 2016/7/11.
 * Initialize the configuration for hbase client. 
 */
public class ConfigurationSample {
  private static Configuration innerConf = null;

  public static Configuration getConfiguration() {
    if(innerConf == null) {
      init();
    }
    return innerConf;
  }

  public static void init() {
    innerConf = HBaseConfiguration.create();
    String confDir = System.getProperty("user.dir");
    String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    
    innerConf.addResource(path.substring(1, path.length()) + "hbase-site.xml");
    innerConf.addResource(path.substring(1, path.length())  + "core-site.xml");
    innerConf.addResource(path.substring(1, path.length()) + "hdfs-site.xml");
  }

}
