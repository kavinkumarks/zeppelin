package org.apache.zeppelin.example.app.dataset;

import java.io.IOException;

import org.apache.zeppelin.conf.ZeppelinConfiguration;
import org.apache.zeppelin.helium.Application;
import org.apache.zeppelin.helium.ApplicationContext;
import org.apache.zeppelin.helium.ApplicationException;
import org.apache.zeppelin.resource.ResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dataset application.
 * Get data from resource pool and display it
 */
public class DatasetApplication extends Application{

  private static final Logger LOG = LoggerFactory.getLogger(DatasetApplication.class);

  public DatasetApplication(ApplicationContext context) {
    super(context);
  }
  
  
  /*
   * Execution of application
   */
  @Override
  public void run(ResourceSet resource) throws ApplicationException, IOException {
    ZeppelinConfiguration conf = ZeppelinConfiguration.create();
    
    LOG.info("Dataset application initiated");
    
    //Factory to create instance of dataExplorer
    ExplorerFactory explorerFactory = new ExplorerFactory();

    //DataExplorer
    DatasetExplorer explorer = explorerFactory.getInstance(Enum.valueOf(Explorer.class, 
            conf.getDatasetResourceType()));

    if (DatasetExplorer.FIRST_PARA.equalsIgnoreCase(context().getParagraphId())) {
      context().getAngularObjectRegistry().add("header", DatasetExplorer.HEADER);

      //FileExplorer URL
      context().getAngularObjectRegistry().add("datasets", explorer
              .getDatasets(conf.getDatasetResourceUrl()));

      //write output to html
      context().out.writeResource("example/app/dataset/dataset.html");

    } else if (DatasetExplorer.SECOND_PARA.equalsIgnoreCase(context().getParagraphId())) {
      context().getAngularObjectRegistry().add("tableheader", DatasetExplorer.TABLE_HEADER);

      //FileExplorer URL
      context().getAngularObjectRegistry().add("datatables", explorer
              .getTables(conf.getDatasetResourceUrl() + "/freebase-deleted-triples"));

      //write output to html
      context().out.writeResource("example/app/dataset/datatable.html");
    }
  }

  /*
   * Cleanup of resources created during the application
   */
  @Override
  public void unload() throws ApplicationException {
    context().getAngularObjectRegistry().remove("header");
    context().getAngularObjectRegistry().remove("datasets");
    context().getAngularObjectRegistry().remove("datatables");
  }

}
