package org.apache.zeppelin.example.app.dataset;

import java.util.List;

/**
 * DatasetExplorer
 * Interface for datasetExplorer
 */
public interface DatasetExplorer {

  public static final String HEADER = "List of Datasets available";  

  public List<String> getDatasets(String name);

  public List<String> getTables(String name);

}
