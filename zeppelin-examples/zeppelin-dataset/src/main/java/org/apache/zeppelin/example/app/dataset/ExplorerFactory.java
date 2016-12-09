package org.apache.zeppelin.example.app.dataset;

/** 
 * ExplorerFactory
 * Factory to create new instance of DatasetExplorer
 */
public class ExplorerFactory {

  public DatasetExplorer getInstance(Explorer type) {
    switch (type) {
        case INTERNAL :
          return new FileDatasetExplorer();
        default :
          return null;
    }
  }
}
