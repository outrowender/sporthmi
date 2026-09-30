/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.ftp;

import com.ibm.oti.connection.ConnectionUtil;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.connection.DataConnection;
import com.ibm.oti.util.Msg;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

public class Connection
extends DataConnection
implements CreateConnection {
    private String host;
    private String file;
    private String user = "anonymous";
    private String password = "";
    private int access;
    private InputStream ctrlInput;
    private InputStream inputStream;
    private OutputStream ctrlOutput;
    private OutputStream outputStream;
    private boolean streamOpen = false;
    private static final int FTP_DATAOPEN = 125;
    private static final int FTP_OPENDATA = 150;
    private static final int FTP_OK = 200;
    private static final int FTP_USERREADY = 220;
    private static final int FTP_TRANSFEROK = 226;
    private static final int FTP_LOGGEDIN = 230;
    private static final int FTP_FILEOK = 250;
    private static final int FTP_PASWD = 331;
    private static final int FTP_NOTFOUND = 550;

    public void close() throws IOException {
        this.host = null;
        if (!this.streamOpen) {
            if (this.inputStream != null) {
                this.inputStream.close();
            } else {
                this.outputStream.close();
            }
        }
    }

    public InputStream openInputStream() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 1) {
            throw new IOException(Msg.getString("K00a9"));
        }
        this.streamOpen = true;
        return this.inputStream;
    }

    public OutputStream openOutputStream() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 2) {
            throw new IOException(Msg.getString("K00aa"));
        }
        this.streamOpen = true;
        return this.outputStream;
    }

    private void disconnect(StreamConnection streamConnection, StreamConnectionNotifier streamConnectionNotifier) {
        try {
            if (streamConnection != null) {
                streamConnection.close();
            }
        }
        catch (Exception exception) {}
        try {
            if (this.ctrlInput != null) {
                this.ctrlInput.close();
            }
        }
        catch (Exception exception) {}
        try {
            if (this.ctrlOutput != null) {
                this.ctrlOutput.close();
            }
        }
        catch (Exception exception) {}
        try {
            if (streamConnectionNotifier != null) {
                streamConnectionNotifier.close();
            }
        }
        catch (Exception exception) {}
    }

    public javax.microedition.io.Connection setParameters2(String string, int n, boolean bl) throws IOException {
        String[][] stringArray = ConnectionUtil.NO_PARAMETERS;
        int n2 = string.indexOf(59);
        if (n2 != -1) {
            stringArray = ConnectionUtil.getParameters(string.substring(n2 + 1));
            string = string.substring(0, n2);
        }
        this.setParameters(string, stringArray, n, bl);
        return this;
    }

    private void setParameters(String string, String[][] stringArray, int n, boolean bl) throws IOException {
        Object object;
        char c2 = 'I';
        int n2 = 0;
        while (n2 < stringArray.length) {
            char c3;
            object = stringArray[n2][0].toLowerCase();
            if (((String)object).equals("type") && stringArray[n2][1] != null) {
                if (stringArray[n2][1].length() > 1 || (c3 = Character.toUpperCase(stringArray[n2][1].charAt(0))) != 'A' && c3 != 'I') {
                    throw new IllegalArgumentException(Msg.getString("K0089", stringArray[n2][1]));
                }
            } else {
                throw new IllegalArgumentException(Msg.getString("K00a5", stringArray[n2][0]));
            }
            c2 = c3;
            ++n2;
        }
        this.access = n;
        if (n == 3) {
            throw new IllegalArgumentException(Msg.getString("K00b4"));
        }
        if (string.startsWith("//")) {
            n2 = string.indexOf(47, 2);
            if (n2 == -1) {
                throw new IllegalArgumentException(Msg.getString("K00d6"));
            }
            object = string.substring(2, n2);
            this.file = string.substring(n2);
            n2 = ((String)object).indexOf(64);
            if (n2 != -1) {
                String string2 = ((String)object).substring(0, n2);
                object = ((String)object).substring(n2 + 1);
                n2 = string2.indexOf(58);
                if (n2 != -1) {
                    this.user = string2.substring(0, n2);
                    this.password = string2.substring(n2 + 1);
                } else {
                    this.user = string2;
                }
            }
            this.host = ((String)object).indexOf(":") == -1 ? String.valueOf(object) + ":21" : object;
        } else {
            this.host = "localhost:21";
            this.file = string;
        }
        StreamConnection streamConnection = null;
        object = null;
        com.ibm.oti.connection.socket.Connection connection = new com.ibm.oti.connection.socket.Connection();
        connection.setParameters2("//" + this.host, 3, false);
        this.ctrlOutput = connection.openOutputStream();
        this.ctrlInput = new BufferedInputStream(connection.openInputStream());
        try {
            this.login();
            this.setType(c2);
            if (n == 2) {
                this.cd();
            }
            object = new com.ibm.oti.connection.serversocket.Connection();
            ((com.ibm.oti.connection.serversocket.Connection)object).setParameters2("//:0;so_timeout=3000", 1, true);
            this.port(((com.ibm.oti.connection.serversocket.Connection)object).getLocalPort(), connection.getLocalAddress());
            if (n == 1) {
                this.getFile();
            } else {
                this.sendFile();
            }
            streamConnection = ((com.ibm.oti.connection.serversocket.Connection)object).acceptAndOpen();
        }
        catch (RuntimeException runtimeException) {
            this.disconnect(connection, (StreamConnectionNotifier)object);
            throw runtimeException;
        }
        catch (IOException iOException) {
            this.disconnect(connection, (StreamConnectionNotifier)object);
            throw iOException;
        }
        this.disconnect(connection, (StreamConnectionNotifier)object);
        if (n == 1) {
            final InputStream inputStream = streamConnection.openInputStream();
            streamConnection.close();
            this.inputStream = new InputStream(){

                public int available() throws IOException {
                    return inputStream.available();
                }

                public int read() throws IOException {
                    return inputStream.read();
                }

                public int read(byte[] byArray, int n, int n2) throws IOException {
                    return inputStream.read(byArray, n, n2);
                }

                public long skip(long l) throws IOException {
                    return inputStream.skip(l);
                }

                public void close() throws IOException {
                    inputStream.close();
                }
            };
        } else {
            final OutputStream outputStream = streamConnection.openOutputStream();
            streamConnection.close();
            this.outputStream = new OutputStream(){

                public void write(int n) throws IOException {
                    outputStream.write(n);
                }

                public void write(byte[] byArray, int n, int n2) throws IOException {
                    outputStream.write(byArray, n, n2);
                }

                public void close() throws IOException {
                    outputStream.close();
                }
            };
        }
    }

    private int getReply() throws IOException {
        String string = this.readLine();
        if (string.length() >= 4) {
            String string2 = string.substring(0, 3);
            if (string.charAt(3) == '-') {
                while (this.readMultiLine(string2)) {
                }
            }
            try {
                return Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {}
        }
        throw new IOException(Msg.getString("K00dd", string));
    }

    private void login() throws IOException {
        int n = this.getReply();
        if (n != 220) {
            throw new IOException(Msg.getString("K0097", this.host));
        }
        this.write("USER " + this.user + "\r\n");
        n = this.getReply();
        if (n != 331 && n != 230) {
            throw new IOException(Msg.getString("K0098", this.host));
        }
        if (n == 331) {
            this.write("PASS " + this.password + "\r\n");
            n = this.getReply();
            if (n != 200 && n != 220 && n != 230) {
                throw new IOException(Msg.getString("K0098", this.host));
            }
        }
    }

    private String readLine() throws IOException {
        int n;
        StringBuffer stringBuffer = new StringBuffer();
        while ((n = this.ctrlInput.read()) != 10) {
            stringBuffer.append((char)n);
        }
        return stringBuffer.toString();
    }

    private boolean readMultiLine(String string) throws IOException {
        String string2 = this.readLine();
        if (string2.length() < 4) {
            return true;
        }
        return !string2.substring(0, 3).equals(string) || string2.charAt(3) != ' ';
    }

    private void setType(char c2) throws IOException {
        this.write("TYPE " + c2 + "\r\n");
        if (this.getReply() != 200) {
            throw new IOException(Msg.getString("K009b"));
        }
    }

    private void cd() throws IOException {
        int n = this.file.lastIndexOf(47);
        if (n > 0) {
            String string = this.file.substring(0, n);
            this.write("CWD " + string + "\r\n");
            int n2 = this.getReply();
            if (n2 != 250 && string.length() > 0 && string.charAt(0) == '/') {
                this.write("CWD " + string.substring(1) + "\r\n");
                n2 = this.getReply();
            }
            if (n2 != 250) {
                throw new IOException(Msg.getString("K0094"));
            }
        }
    }

    private void sendFile() throws IOException {
        this.write("STOR " + this.file.substring(this.file.lastIndexOf(47) + 1) + "\r\n");
        int n = this.getReply();
        if (n != 150 && n != 200 && n != 125) {
            throw new IOException(Msg.getString("K009a"));
        }
    }

    private void getFile() throws IOException {
        this.write("RETR " + this.file + "\r\n");
        int n = this.getReply();
        if (n == 550 && this.file.length() > 0 && this.file.charAt(0) == '/') {
            this.write("RETR " + this.file.substring(1) + "\r\n");
            n = this.getReply();
        }
        if (n != 150 && n != 226) {
            throw new IOException(Msg.getString("K0096", n));
        }
    }

    private void port(int n, String string) throws IOException {
        string = string.replace('.', ',');
        this.write("PORT " + string + "," + (n >> 8) + ',' + (n & 0xFF) + "\r\n");
        if (this.getReply() != 200) {
            throw new IOException(Msg.getString("K0099"));
        }
    }

    private void write(String string) throws IOException {
        this.ctrlOutput.write(string.getBytes("ISO8859_1"));
    }
}

