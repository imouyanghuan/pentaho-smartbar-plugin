package org.pentaho.samples;

import java.io.OutputStream;
import java.util.Date;

import org.pentaho.platform.api.action.IStreamingAction;

/**
 * We have encapsulated the highly complex business logic involved in echoing a message :)
 * in an IAction.  Best practice is to isolate the business logic in an IAction so it 
 * can be easily unit tested, scheduled, and included as a step in an Action Sequence.
 * 
 * As you will see by looking at the EchoResource and EchoTestServlet, this act simply as 
 * protocols bridges to the IAction.
 * 
 * @author aphillips
 */
public class EchoAction implements IStreamingAction {

  private OutputStream echoResponseOutStream;

  /*
   * This property is the input message and will be spat out in the echoMessage during execute
   */
  private String message;

  /*
   * This is the resulting message. A copy will also be written to the response stream
   */
  private String echoMessage;
  
  public EchoAction() {
  }

  /**
   * Returns the resultant message string
   * @return the resultant message
   */
  public String getEchoMessage() {
    return echoMessage;
  }

  /**
   * Sets the input message which will be included in the resultant message
   * @param message the input message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setOutputStream(OutputStream outputStream) {
    echoResponseOutStream = outputStream;
  }
  
  public void setEchoResponseStream(OutputStream outStream) {
    echoResponseOutStream = outStream;
  }

  public void execute() throws Exception {
    if (message == null) {
      throw new Exception("message is null");
    }
    
    StringBuilder html = new StringBuilder("<html><h1>EchoAction is live at " + new Date().toString()
        + "!  Your message is \"" + message + "\"<h1>");
    html.append("</html>");
    
    /* stage the output for retrieval later through the echoMessage property */
    echoMessage = html.toString();
    
    /* the stream may be null in certain execution contexts (see EchoResource) */
    if(echoResponseOutStream != null) {
      echoResponseOutStream.write(html.toString().getBytes());
    }
  }

  /**
   * If your class implements {@link IStreamingAction}, then you are required to implement
   * this method and return the mime type of the content to be written to the output stream.
   * 
   * {@inheritDoc}
   */
  public String getMimeType(String streamPropertyName) {
    return "text/html";
  }
}