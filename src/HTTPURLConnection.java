/*
 * Java Network Programming, Second Edition
 * Merlin Hughes, Michael Shoffner, Derek Hamner
 * Manning Publications Company; ISBN 188477749X
 *
 * http://nitric.com/jnp/
 *
 * Copyright (c) 1997-1999 Merlin Hughes, Michael Shoffner, Derek Hamner;
 * all rights reserved; see license.txt for details.
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class HTTPURLConnection extends URLConnection {
  protected Hashtable requestProperties;
  protected Vector keys;
  protected Hashtable headers;
  
  public HTTPURLConnection (URL url) {
    super (url);
    requestProperties = new Hashtable ();
    keys = new Vector ();
    headers = new Hashtable ();
  }

  public void setRequestProperty (String name, String value) {
    if (connected)
      throw new IllegalStateException ("Already connected.");
    requestProperties.put (name, value);
  }

  public String getRequestProperty (String name) {
    return (String) requestProperties.get (name);
  }

  protected InputStream in;
  
  public synchronized void connect () throws IOException {
    if (!connected) {
      String host = url.getHost ();
      int port = (url.getPort () == -1) ? 80 : url.getPort ();
      Socket socket = new Socket (host, port);
      sendRequest (socket.getOutputStream ());
      in = new BufferedInputStream (socket.getInputStream ());
      readHeaders ();
      connected = true;
    }
  }

  protected void sendRequest (OutputStream out) throws IOException {
    setRequestProperty ("User-Agent", "JNP-HTTP/2e");
    if (ifModifiedSince != 0) {
      Date since = new Date (ifModifiedSince);
      SimpleDateFormat formatter =
        new SimpleDateFormat ("EEE, d MMM yyyy hh:mm:ss z");
      formatter.setTimeZone (TimeZone.getTimeZone ("GMT"));
      setRequestProperty ("If-Modified-Since", formatter.format (since));
    }
    StringBuffer request = new StringBuffer ("GET ");
    request.append (" HTTP/1.0\r\n");
    Enumeration keys = requestProperties.keys ();
    while (keys.hasMoreElements ()) {
      String key = (String) keys.nextElement ();
      request.append (key);
      request.append (": ");
      request.append (requestProperties.get (key));
      request.append ("\r\n");
    }
    request.append ('\n');
    out.write (request.toString ().getBytes ("latin1"));
  }

  protected void readHeaders () throws IOException {
    String header;
    while (((header = readLine ()) != null) &&
           (!header.trim ().equals (""))) {
      int colon = header.indexOf (":");
      if (colon >= 0) {
        String key = header.substring (0, colon).trim ();
        String value = header.substring (colon + 1).trim ();
        keys.addElement (key);
        headers.put (key.toLowerCase (), value);
      }
    }
  }

  protected String readLine () throws IOException {
    StringBuffer result = new StringBuffer ();
    int chr;
    while (((chr = in.read ()) != -1) && (chr != 10) && (chr != 13))
      result.append ((char) chr);
    if ((chr == -1) && (result.length () == 0))
      return null;
    if (chr == 13) {
      in.mark (1);
      if (in.read () != 10)
        in.reset ();
    }
    return result.toString ();
  }

  public InputStream getInputStream () throws IOException {
    if (!doInput)
      throw new IllegalStateException ("Input disabled.");
    connect ();
    return in;
  }

  public String getHeaderFieldKey (int index) {
    if (!connected)
      throw new IllegalStateException ("Not connected.");
    if (index < keys.size ())
      return (String) keys.elementAt (index);
    else
      return null;
  }

  public String getHeaderField (int index) {
    if (!connected)
      throw new IllegalStateException ("Not connected.");
    if (index < keys.size ())
      return getHeaderField ((String) keys.elementAt (index));
    else
      return null;
  }

  public String getHeaderField (String key) {
    if (!connected)
      throw new IllegalStateException ("Not connected.");
    return (String) headers.get (key.toLowerCase ());
  }
}
