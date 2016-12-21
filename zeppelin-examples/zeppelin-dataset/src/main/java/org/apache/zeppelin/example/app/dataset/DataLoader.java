package org.apache.zeppelin.example.app.dataset;

import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.httpclient.cookie.CookiePolicy;

/**
 * Dataset application. Get data from resource pool and display it
 */
public class DataLoader {

  private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

  public static String url = "http://localhost:8080";
  public String user = "";
  public String password = "";

  public String runParagraph(String noteId, String paraId) throws IOException {
    PostMethod postParagraph = httpPost("/api/notebook/run/" + noteId + "/" + paraId);
    return postParagraph.getResponseBodyAsString();
  }

  public static PostMethod httpPost(String path) throws IOException {
    HttpClient httpClient = new HttpClient();
    String completePath = url + path;
    PostMethod postMethod = new PostMethod(completePath);
    LOG.info("Invoking run paragraph REST call " + completePath);
    postMethod.setRequestBody("");
    postMethod.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
    httpClient.executeMethod(postMethod);
    postMethod.releaseConnection();
    return postMethod;
  }
}
