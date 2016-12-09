package org.apache.zeppelin.example.app.dataset;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * FileDataset explorer
 * 
 * Class to retrieve the datasets and tables for each dataset from local machine
 */
public class FileDatasetExplorer implements DatasetExplorer  {

  public List<String> getDatasets(String location) {

    File dir = new File(location);
    List<String> fileList = new LinkedList<String>();

    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isDirectory()) {
        fileList.add(file.getName());
      }
    }
    
    return fileList;
  }
  
  public List<String> getTables(String location) {
    
    File dir = new File(location);
    List<String> fileList = new LinkedList<String>();

    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isFile() && file.getName().indexOf("-headers.txt") > -1) {
        fileList.add(file.getName().split("-headers.txt")[0]);
      }
    }

    return fileList;
  }
}
