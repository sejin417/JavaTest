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

import java.net.*;
import java.io.*;

public class GrabPage {
  public GrabPage (String textURL) throws IOException {
    dissect (textURL);
  }

  protected String host, file;
  protected int port;

  protected void dissect (String textURL) throws MalformedURLException {
    URL url = new URL (textURL);
    host = url.getHost ();
    port = url.getPort ();
    if (port == -1)
      port = 80;
    file = url.getFile ();
  }

  public void grab () throws IOException {
    connect ();
    try {
      fetch ();
    } finally {
      disconnect ();
    }
  }

  protected Writer writer;
  protected BufferedReader reader;

  protected void connect () throws IOException {
    Socket socket = new Socket (host, port);
    OutputStream out = socket.getOutputStream ();
    writer = new OutputStreamWriter (out, "latin1");
    InputStream in = socket.getInputStream ();
    Reader reader = new InputStreamReader (in, "latin1");
    this.reader = new BufferedReader (reader);
  }

  protected void fetch () throws IOException {
    writer.write ("GET " + file + " HTTP/1.1\r\n\n");
    writer.flush ();
    PrintWriter console = new PrintWriter (System.out);
    String input;
    while ((input = reader.readLine ()) != null)
      console.println (input);
    console.flush ();
  }

  protected void disconnect () throws IOException {
    reader.close ();
  }

  public static void main (String[] args) throws IOException {
    Reader kbd = new FileReader (FileDescriptor.in);
    BufferedReader bufferedKbd = new BufferedReader (kbd);
    while (true) {
      String textURL;
      System.out.print ("Enter a URL: ");
      System.out.flush ();
      if ((textURL = bufferedKbd.readLine ()) == null)
        break;

      try {
        GrabPage grabPage = new GrabPage (textURL);
        grabPage.grab ();
      } catch (IOException ex) {
        ex.printStackTrace ();
        continue;
      }
      System.out.println ("- OK -");
    }
    System.out.println ("exit");
  }
}
