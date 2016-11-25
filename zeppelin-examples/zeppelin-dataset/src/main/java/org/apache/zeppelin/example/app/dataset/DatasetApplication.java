package org.apache.zeppelin.example.app.dataset;

import java.io.IOException;

import org.apache.zeppelin.helium.Application;
import org.apache.zeppelin.helium.ApplicationContext;
import org.apache.zeppelin.helium.ApplicationException;
import org.apache.zeppelin.interpreter.dev.ZeppelinApplicationDevServer;
import org.apache.zeppelin.resource.LocalResourcePool;
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
   * 
   */
  @Override
  public void run(ResourceSet args) throws ApplicationException, IOException {
    LOG.info("Dataset application initiated");
    context().getAngularObjectRegistry().add("header", DatasetExplorer.HEADER);
    DatasetExplorer explorer = new FileDatasetExplorer();
    context().getAngularObjectRegistry().add("datasets", explorer
             .getDatasets("/home/rajarajang/Downloads/Learning"));
    context().out.writeResource("example/app/dataset/dataset.html");
  }

  /*
   * Cleanup of resources created during the application
   */
  @Override
  public void unload() throws ApplicationException {
    context().getAngularObjectRegistry().remove("header");
    context().getAngularObjectRegistry().remove("datasets");
  }

}
