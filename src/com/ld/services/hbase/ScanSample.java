package com.ld.services.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

public class ScanSample extends TableOperationImpl {
  Logger LOG = Logger.getLogger(ScanSample.class);
  
  public ScanSample() {
    super();
  }
  
  public List<String> process(String tableNameStr, String col) {
	List<String> list = new ArrayList<String>();
    // Specify the table name.
    TableName tableName = TableName.valueOf(tableNameStr);
    
    Table table = null;
    // Instantiate a ResultScanner object.
    ResultScanner rScanner = null;
    try {
      // Create the Configuration instance.
      table = connection.getTable(tableName);
      
      // Instantiate a Get object.
      Scan scan = new Scan();
      scan.addColumn(Bytes.toBytes("cf"), Bytes.toBytes(col));
      
      // Set the cache size.
      scan.setCaching(1000);
      
      // Submit a scan request.
      rScanner = table.getScanner(scan);
      
      // Print query results.
      for (Result r = rScanner.next(); r != null; r = rScanner.next()) {
        for (Cell cell : r.rawCells()) {
          LOG.info( Bytes.toString(CellUtil.cloneValue(cell)));
          list.add( Bytes.toString(CellUtil.cloneValue(cell)));
        }
      }
      LOG.info("Scan data successfully.");
    } catch (IOException e) {
      LOG.error("Failed to scan data from " + tableName.getNameAsString() + ".", e);
    } finally {
      if (rScanner != null) {
        // Close the scanner object.
        rScanner.close();
      }
      if (table != null) {
        try {
          // Close the HTable object.
          table.close();
        } catch (IOException e) {
          table = null;
        }
      }
    }
    return list;
  }
  
}
