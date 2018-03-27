package com.mapr.db.examples;

import com.mapr.db.TableDescriptor;
import org.ojai.Document;
import org.ojai.DocumentStream;
import org.ojai.store.Connection;
import org.ojai.store.DocumentStore;
import org.ojai.store.DriverManager;
import org.ojai.store.Query;
import org.ojai.store.QueryCondition;

import com.mapr.db.Admin;
import com.mapr.db.MapRDB;

import org.apache.hadoop.conf.Configuration;

import java.util.UUID;

public class OJAI_001_YelpSimpleQuery {
  public static final String OJAI_CONNECTION_URL = "ojai:mapr:";

  //Full path including namespace /mapr/<cluster-name>/apps/business
  public static final String TABLE_NAME = "/apps/user";


  public static void main(String[] args) {

    System.out.println("==== Start Application ===");

    Configuration conf = new Configuration();
    String clusterName = "demo.mapr.com";

    String cldb1nodeIP = "10.20.30.147";
    String cldb2nodeIP = "10.20.30.148";
    String cldb3nodeIP = "10.20.30.149";

    conf.setBoolean("fs.mapr.impl.clustername.unique", false);
    conf.set("dfs.nameservices", clusterName);
    conf.set("dfs.ha.namenodes." + clusterName, "cldb1,cldb2,cldb3");
    conf.set("dfs.namenode.rpc-address." + clusterName + ".cldb1", cldb1nodeIP + ":7222");
    conf.set("dfs.namenode.rpc-address." + clusterName + ".cldb2", cldb2nodeIP + ":7222");
    conf.set("dfs.namenode.rpc-address." + clusterName + ".cldb3", cldb3nodeIP + ":7222");

    Admin admin = MapRDB.newAdmin(conf);

    TableDescriptor tableDesc = admin.getTableDescriptor(TABLE_NAME);

    System.out.println(" Table Path : " + tableDesc.getFamilies());


//    System.out.println("Check for FS");
//
//    try {
//
//      FileSystem maprFs = FileSystem.get(conf);
//
//      Path p = new Path("maprfs:/mapr/demo.mapr.com/tmp/test123"
//
//              + System.currentTimeMillis());
//
//      System.out.println("Path: " + p);
//
//      maprFs.create(p);
//
//    } catch (Exception ex) {
//
//      ex.printStackTrace();
//
//    }

//    // Create an OJAI connection to MapR cluster
//    //Connection connection = DriverManager.getConnection(OJAI_CONNECTION_URL);
//    // Get an instance of OJAI
//    DocumentStore store = connection.getStore(TABLE_NAME);
//
//    Query query = connection.newQuery()
//            .select("name", "yelping_since", "support") // projection
//            .where( connection.newCondition().is("support", QueryCondition.Op.EQUAL, "gold").build()    ) // condition
//            .build();
//
//    long startTime = System.currentTimeMillis();
//    int counter = 0;
//    DocumentStream stream = store.findQuery(query);
//    for (Document userDocument : stream) {
//      // Print the OJAI Document
//      System.out.println("\t"+ userDocument.asJsonString());
//      counter++;
//    }
//    long endTime = System.currentTimeMillis();
//
//
//    System.out.println(String.format("\t %d found in %d ms", counter, (endTime-startTime) ));
//
//
//    // Close this instance of OJAI DocumentStore
//    store.close();
//
//    // close the OJAI connection and release any resources held by the connection
//    connection.close();

    System.out.println("==== End Application ===");
  }


}
