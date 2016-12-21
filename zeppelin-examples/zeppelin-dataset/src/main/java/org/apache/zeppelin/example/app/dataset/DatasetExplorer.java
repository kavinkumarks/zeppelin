package org.apache.zeppelin.example.app.dataset;

import java.util.List;

/**
 * DatasetExplorer
 * Interface for datasetExplorer
 */
public interface DatasetExplorer {

  public static final String HEADER = "List of Datasets available";
  
  public static final String FIRST_PARA = "20161111-174523_224646183";
  
  public static final String SECOND_PARA = "20161111-180024_48827119";
  
  public static final String THIRD_PARA = "20161125-145708_286818081";

  public static final String TABLE_HEADER = "List of tables available";

  public List<String> getDatasets(String name);

  public List<String> getTables(String name);

}
