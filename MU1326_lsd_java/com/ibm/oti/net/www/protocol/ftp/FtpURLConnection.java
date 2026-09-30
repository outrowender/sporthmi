/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.ftp;

import com.ibm.oti.net.www.protocol.ftp.FtpURLInputStream;
import com.ibm.oti.util.Msg;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketPermission;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class FtpURLConnection
extends URLConnection {
    Socket controlSocket;
    Socket dataSocket;
    ServerSocket acceptSocket;
    InputStream ctrlInput;
    InputStream inputStream;
    OutputStream ctrlOutput;
    private String replyCode;
    private String hostName;
    int dataPort;
    private static final int FTP_PORT = 21;
    private String PASSWORD = "";
    private String USERNAME = "anonymous";
    private static final int FTP_DATAOPEN = 125;
    private static final int FTP_OPENDATA = 150;
    private static final int FTP_OK = 200;
    private static final int FTP_USERREADY = 220;
    private static final int FTP_TRANSFEROK = 226;
    private static final int FTP_PASV = 227;
    private static final int FTP_LOGGEDIN = 230;
    private static final int FTP_FILEOK = 250;
    private static final int FTP_PASWD = 331;
    private static final int FTP_DATAERROR = 451;
    private static final int FTP_ERROR = 500;
    private static final int FTP_NOTFOUND = 550;

    protected FtpURLConnection(URL uRL) {
        super(uRL);
        this.hostName = uRL.getHost();
        String string = uRL.getUserInfo();
        if (string != null) {
            int n = string.indexOf(58);
            if (n >= 0) {
                this.USERNAME = string.substring(0, n);
                this.PASSWORD = string.substring(n + 1);
            } else {
                this.USERNAME = string;
            }
        }
    }

    private void cd() throws IOException {
        int n = this.url.getFile().lastIndexOf(47);
        if (n > 0) {
            String string = this.url.getFile().substring(0, n);
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

    public void connect() throws IOException {
        int n = this.url.getPort();
        if (n <= 0) {
            n = 21;
        }
        this.controlSocket = new Socket(this.hostName, n);
        this.connected = true;
        this.ctrlOutput = this.controlSocket.getOutputStream();
        this.ctrlInput = this.controlSocket.getInputStream();
        this.login();
        this.setType();
        if (!this.getDoInput()) {
            this.cd();
        }
        try {
            this.acceptSocket = new ServerSocket(0);
            this.dataPort = this.acceptSocket.getLocalPort();
            this.port();
            this.acceptSocket.setSoTimeout(3000);
            if (this.getDoInput()) {
                this.getFile();
            } else {
                this.sendFile();
            }
            this.dataSocket = this.acceptSocket.accept();
            this.acceptSocket.close();
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new IOException(Msg.getString("K0095"));
        }
        if (this.getDoInput()) {
            this.inputStream = new FtpURLInputStream(new BufferedInputStream(this.dataSocket.getInputStream()), this.controlSocket);
        }
    }

    public String getContentType() {
        String string = FtpURLConnection.guessContentTypeFromName(this.url.getFile());
        if (string == null) {
            return "content/unknown";
        }
        return string;
    }

    private void getFile() throws IOException {
        String string = this.url.getFile();
        this.write("RETR " + string + "\r\n");
        int n = this.getReply();
        if (n == 550 && string.length() > 0 && string.charAt(0) == '/') {
            this.write("RETR " + string.substring(1) + "\r\n");
            n = this.getReply();
        }
        if (n != 150 && n != 226) {
            throw new FileNotFoundException(Msg.getString("K0096", n));
        }
    }

    public InputStream getInputStream() throws IOException {
        if (!this.connected) {
            this.connect();
        }
        return this.inputStream;
    }

    public Permission getPermission() throws IOException {
        int n = this.url.getPort();
        if (n <= 0) {
            n = 21;
        }
        return new SocketPermission(String.valueOf(this.hostName) + ":" + n, "connect, resolve");
    }

    public OutputStream getOutputStream() throws IOException {
        if (!this.connected) {
            this.connect();
        }
        return this.dataSocket.getOutputStream();
    }

    private int getReply() throws IOException {
        byte[] byArray = new byte[3];
        this.ctrlInput.read(byArray, 0, byArray.length);
        this.replyCode = new String(byArray, "ISO8859_1");
        boolean bl = false;
        if (this.ctrlInput.read() == 45) {
            bl = true;
        }
        this.readLine();
        if (bl) {
            while (this.readMultiLine()) {
            }
        }
        return Integer.parseInt(new String(byArray, "ISO8859_1"));
    }

    private void login() throws IOException {
        int n = this.getReply();
        if (n != 220) {
            throw new IOException(Msg.getString("K0097", this.url.getHost()));
        }
        this.write("USER " + this.USERNAME + "\r\n");
        n = this.getReply();
        if (n != 331 && n != 230) {
            throw new IOException(Msg.getString("K0098", this.url.getHost()));
        }
        if (n == 331) {
            this.write("PASS " + this.PASSWORD + "\r\n");
            n = this.getReply();
            if (n != 200 && n != 220 && n != 230) {
                throw new IOException(Msg.getString("K0098", this.url.getHost()));
            }
        }
    }

    private void port() throws IOException {
        this.write("PORT " + this.controlSocket.getLocalAddress().getHostAddress().replace('.', ',') + ',' + (this.dataPort >> 8) + ',' + (this.dataPort & 0xFF) + "\r\n");
        if (this.getReply() != 200) {
            throw new IOException(Msg.getString("K0099"));
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

    private boolean readMultiLine() throws IOException {
        String string = this.readLine();
        if (string.length() < 4) {
            return true;
        }
        return !string.substring(0, 3).equals(this.replyCode) || string.charAt(3) != ' ';
    }

    private void sendFile() throws IOException {
        this.write("STOR " + this.url.getFile().substring(this.url.getFile().lastIndexOf(47) + 1, this.url.getFile().length()) + "\r\n");
        int n = this.getReply();
        if (n != 150 && n != 200 && n != 125) {
            throw new IOException(Msg.getString("K009a"));
        }
    }

    public void setDoInput(boolean bl) {
        if (this.connected) {
            throw new IllegalAccessError();
        }
        this.doInput = bl;
        this.doOutput = !bl;
    }

    public void setDoOutput(boolean bl) {
        if (this.connected) {
            throw new IllegalAccessError();
        }
        this.doOutput = bl;
        this.doInput = !bl;
    }

    private void setType() throws IOException {
        this.write("TYPE I\r\n");
        if (this.getReply() != 200) {
            throw new IOException(Msg.getString("K009b"));
        }
    }

    private void write(String string) throws IOException {
        this.ctrlOutput.write(string.getBytes("ISO8859_1"));
    }
}

