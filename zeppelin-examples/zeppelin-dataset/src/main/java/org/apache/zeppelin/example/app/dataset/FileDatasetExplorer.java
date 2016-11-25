package org.apache.zeppelin.example.app.dataset;

import java.io.File;
import java.util.List;
import java.util.LinkedList;

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
  
  public List<String> getTables(String name) {
    return null;
  }
}
