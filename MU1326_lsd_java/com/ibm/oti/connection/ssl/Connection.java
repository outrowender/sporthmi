/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.ssl;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.j9.ssl.CipherAlgorithm;
import com.ibm.j9.ssl.CipherSpec;
import com.ibm.j9.ssl.ConnectionState;
import com.ibm.j9.ssl.HandshakeHandler;
import com.ibm.j9.ssl.HandshakeSocket;
import com.ibm.j9.ssl.J9HandshakeException;
import com.ibm.j9.ssl.LimitedX509Certificate;
import com.ibm.j9.ssl.Record;
import com.ibm.j9.ssl.SessionState;
import com.ibm.j9.ssl.StreamQueue;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.Msg;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import javax.microedition.io.SecureConnection;
import javax.microedition.io.SecurityInfo;
import javax.microedition.io.StreamConnection;
import javax.microedition.pki.Certificate;

public class Connection
implements CreateConnection,
StreamConnection,
SecureConnection,
HandshakeSocket {
    com.ibm.oti.connection.socket.Connection socket = null;
    InputStream inputStream = null;
    OutputStream outputStream = null;
    private static final int UNOPENED = 0;
    private static final int OPEN = 1;
    private static final int CLOSED = 2;
    int inputStatus = 0;
    int outputStatus = 0;
    private String host;
    private int port;
    SessionState sessionState = null;
    private ConnectionState readConnectionState = null;
    private ConnectionState writeConnectionState = null;
    private ConnectionState pendingReadConnectionState = null;
    private HandshakeHandler handshakeHandler = new HandshakeHandler(this);
    private static boolean rngInitialised = false;
    private final StreamQueue applicationDataInputQueue = new StreamQueue();
    private SecurityInfo securityInfo = new SecurityInfo(){

        public String getCipherSuite() {
            return new StringBuffer("TLS_").append(Connection.this.sessionState.getCipherSpec().toString()).toString();
        }

        public String getProtocolName() {
            return CipherSpec.getProtocolName(Connection.this.sessionState.getProtocolVersion()).substring(0, 3);
        }

        public String getProtocolVersion() {
            byte[] byArray = Connection.this.sessionState.getProtocolVersion();
            return new StringBuffer(String.valueOf(String.valueOf(byArray[0]))).append(".").append(String.valueOf(byArray[1])).toString();
        }

        public Certificate getServerCertificate() {
            return new LimitedX509Certificate(Connection.this.getCertificate());
        }
    };

    public Connection() {
    }

    public Connection(com.ibm.oti.connection.socket.Connection connection, String string) throws IOException {
        this.host = string;
        this.socket = connection;
        this.connect();
    }

    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(this.openInputStream());
    }

    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(this.openOutputStream());
    }

    public InputStream openInputStream() throws IOException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkConnect(this.getAddress(), this.getPort());
        }
        if (this.inputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.inputStatus = 1;
        return new SSLInputStream(this.applicationDataInputQueue);
    }

    public OutputStream openOutputStream() throws IOException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkConnect(this.getAddress(), this.getPort());
        }
        if (this.outputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.outputStatus = 1;
        return new SSLOutputStream();
    }

    public javax.microedition.io.Connection setParameters2(String string, int n, boolean bl) throws IOException {
        String string2;
        String string3 = null;
        if (!string.startsWith("//")) {
            throw new IllegalArgumentException();
        }
        int n2 = (string = string.substring(2)).indexOf(47);
        string3 = n2 == -1 ? string : string.substring(0, n2);
        n2 = string3.indexOf(58);
        if (n2 != -1) {
            this.host = string3.substring(0, n2);
            string2 = string3.substring(n2 + 1);
            try {
                this.port = Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(Msg.getString("K00b1"));
            }
            if (this.port < 0 || this.port > 65535) {
                throw new IllegalArgumentException(Msg.getString("K0325", this.port));
            }
        } else {
            throw new IllegalArgumentException(Msg.getString("K03a1"));
        }
        string2 = "//" + this.host + ":" + this.port;
        this.socket = new com.ibm.oti.connection.socket.Connection();
        this.socket.setParameters2(string2, 3, bl);
        this.connect();
        return this;
    }

    public void close() throws IOException {
        this.closeConnection();
    }

    void closeConnection() throws IOException {
        this.inputStatus = 2;
        if (this.outputStatus != 2) {
            this.sendAlert((byte)1, (byte)0);
            this.outputStatus = 2;
        }
        if (this.socket != null) {
            if (this.inputStream != null) {
                this.inputStream.close();
                this.inputStream = null;
            }
            if (this.outputStream != null) {
                this.outputStream.close();
                this.outputStream = null;
            }
            this.socket.close();
            this.socket = null;
        }
    }

    private void connect() throws IOException {
        if (this.socket == null) {
            throw new IOException();
        }
        this.inputStream = this.socket.openInputStream();
        this.outputStream = this.socket.openOutputStream();
        SessionState sessionState = new SessionState(this.getHostName());
        ConnectionState connectionState = new ConnectionState();
        connectionState.setSessionState(sessionState);
        this.readConnectionState = connectionState;
        this.writeConnectionState = connectionState;
        if (!rngInitialised) {
            CL3.rng(null, new byte[1], 0, 1);
            rngInitialised = true;
        }
        try {
            this.handshakeHandler.run();
        }
        catch (J9HandshakeException j9HandshakeException) {
            throw new javax.microedition.pki.CertificateException(j9HandshakeException.getMessage(), null, 14);
        }
        catch (IOException iOException) {
            this.closeSocketStreams();
            throw iOException;
        }
    }

    public String getServerCertSubject() {
        if (this.sessionState == null || this.sessionState.getPeerCertificates() == null || this.sessionState.getPeerCertificates().length == 0) {
            return null;
        }
        try {
            X509Certificate x509Certificate = X509Certificate.certificateFromASN1Object(this.sessionState.getPeerCertificates()[0].getEncoded());
            return x509Certificate.getSubjectDN().getName();
        }
        catch (CertificateException certificateException) {
            return null;
        }
    }

    public X509Certificate getCertificate() {
        X509Certificate x509Certificate;
        if (this.sessionState == null || this.sessionState.getPeerCertificates() == null || this.sessionState.getPeerCertificates().length == 0) {
            return null;
        }
        try {
            x509Certificate = X509Certificate.certificateFromASN1Object(this.sessionState.getPeerCertificates()[0].getEncoded());
        }
        catch (CertificateException certificateException) {
            return null;
        }
        return x509Certificate;
    }

    public SecurityInfo getSecurityInfo() throws IOException {
        if (this.inputStatus == 2 && this.outputStatus == 2) {
            throw new IOException();
        }
        return this.securityInfo;
    }

    private void writeRecord(byte[] byArray, byte by) throws IOException {
        byte[] byArray2 = this.writeConnectionState.getCipherAlgorithm() != null ? this.writeConnectionState.getCipherAlgorithm().encipher(byArray, by, this.writeConnectionState.getPadType()) : byArray;
        Record record = new Record(by, this.sessionState.getProtocolVersion(), byArray2);
        record.writeRecord(this.outputStream);
        ++this.writeConnectionState.transmitSequenceNumber;
    }

    protected Record readRecord() throws IOException {
        if (this.inputStream == null) {
            return null;
        }
        Record record = Record.readRecord(this.inputStream);
        if (record == null) {
            try {
                this.inputStream.close();
            }
            catch (IOException iOException) {}
            this.inputStream = null;
        }
        return record;
    }

    public void writeData(byte[] byArray, int n, int n2, byte by) throws IOException {
        if (by == 23 && this.handshakeHandler.shouldHandshake()) {
            this.handshakeHandler.run();
        }
        int n3 = 0;
        while (n3 < n2) {
            byte[] byArray2 = new byte[n2 - n3 < 16384 ? n2 - n3 : 16384];
            System.arraycopy((Object)byArray, n + n3, (Object)byArray2, 0, byArray2.length);
            this.writeRecord(byArray2, by);
            n3 += 16384;
        }
    }

    public boolean readData() throws IOException {
        Record record = this.readRecord();
        if (record == null) {
            return false;
        }
        byte[] byArray = null;
        CipherAlgorithm cipherAlgorithm = this.readConnectionState.getCipherAlgorithm();
        try {
            byArray = cipherAlgorithm != null ? cipherAlgorithm.decipher(record.getData(), record.getContentType(), this.readConnectionState.getPadType()) : record.getData();
        }
        catch (IOException iOException) {
            this.sendAlert((byte)2, (byte)20);
            throw iOException;
        }
        ++this.readConnectionState.receiveSequenceNumber;
        switch (record.getContentType()) {
            case 23: {
                this.applicationDataInputQueue.getWriteStream().write(byArray);
                break;
            }
            case 20: {
                this.handshakeHandler.processQueuedMessages();
                this.handleChangeCipherSpec(byArray);
                break;
            }
            case 21: {
                this.handleAlert(byArray);
                break;
            }
            case 22: {
                this.handshakeHandler.notifyReceived(byArray);
            }
        }
        return true;
    }

    private void handleChangeCipherSpec(byte[] byArray) throws IOException {
        if (this.pendingReadConnectionState == null) {
            throw new IOException(Msg.getString("K01d4"));
        }
        this.readConnectionState = this.pendingReadConnectionState;
    }

    void sendAlert(byte by, byte by2) throws IOException {
        byte[] byArray = new byte[]{by, by2};
        this.writeRecord(byArray, (byte)21);
    }

    public void sendSocketAlert(byte by, byte by2) {
        try {
            this.sendAlert(by, by2);
        }
        catch (IOException iOException) {}
    }

    public String getHostName() {
        return this.host;
    }

    private void handleAlert(byte[] byArray) throws IOException {
        if (byArray[0] == 2) {
            String string = byArray[1] == 42 ? Msg.getString("K01d5") : (byArray[1] == 20 ? Msg.getString("K01d6") : (byArray[1] == 30 ? Msg.getString("K01d7") : (byArray[1] == 40 ? Msg.getString("K01d8") : (byArray[1] == 47 ? Msg.getString("K01d9") : (byArray[1] == 41 ? Msg.getString("K01da") : (byArray[1] == 10 ? Msg.getString("K01db") : Msg.getString("K01dc", byArray[1])))))));
            throw new IOException(Msg.getString("K01dd", string));
        }
    }

    public void setSessionState(SessionState sessionState) {
        this.sessionState = sessionState;
    }

    public void setWriteConnectionState(ConnectionState connectionState) throws IOException {
        this.writeData(new byte[]{1}, 0, 1, (byte)20);
        this.writeConnectionState = connectionState;
    }

    public void setReadPendingConnectionState(ConnectionState connectionState) throws IOException {
        this.pendingReadConnectionState = connectionState;
    }

    public String getLocalAddress() throws IOException {
        if (this.inputStatus == 2 && this.outputStatus == 2) {
            throw new IOException();
        }
        return this.socket.getLocalAddress();
    }

    private void closeSocketStreams() {
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
            if (this.outputStream != null) {
                this.outputStream.close();
            }
        }
        catch (IOException iOException) {}
    }

    public long getTimeoutLength() {
        return this.socket.getTimeout() * 2;
    }

    public String getAddress() throws IOException {
        if (this.inputStatus == 2 && this.outputStatus == 2) {
            throw new IOException();
        }
        return this.socket.getAddress();
    }

    public int getPort() throws IOException {
        if (this.inputStatus == 2 && this.outputStatus == 2) {
            throw new IOException();
        }
        return this.socket.getPort();
    }

    public int getLocalPort() throws IOException {
        if (this.inputStatus == 2 && this.outputStatus == 2) {
            throw new IOException();
        }
        return this.socket.getLocalPort();
    }

    public int getSocketOption(byte by) throws IllegalArgumentException, IOException {
        if (this.inputStatus == 2 && this.outputStatus == 2) {
            throw new IOException();
        }
        return this.socket.getSocketOption(by);
    }

    public void setSocketOption(byte by, int n) throws IllegalArgumentException, IOException {
        if (this.inputStatus == 2 && this.outputStatus == 2) {
            throw new IOException();
        }
        this.socket.setSocketOption(by, n);
    }

    public CipherSpec[] getEnabledCipherSpecs() {
        return CipherSpec.SUPPORTED_SPECS;
    }

    public String[] getEnabledProtocols() {
        String[] stringArray = new String[]{"TLSv1", "SSLv3"};
        return stringArray;
    }

    private final class SSLInputStream
    extends InputStream {
        private final StreamQueue applicationDataInputQueue;

        SSLInputStream(StreamQueue streamQueue) {
            this.applicationDataInputQueue = streamQueue;
        }

        /*
         * Unable to fully structure code
         */
        public int available() throws IOException {
            if (Connection.this.inputStatus == 2) {
                throw new IOException(Msg.getString("K0059"));
            }
            if (this.applicationDataInputQueue.getReadStream().available() != 0 || Connection.this.inputStream != null) ** GOTO lbl7
            return -1;
lbl-1000:
            // 1 sources

            {
                Connection.this.readData();
lbl7:
                // 2 sources

                ** while (this.applicationDataInputQueue.getReadStream().available() == 0 && Connection.this.inputStream != null && Connection.this.inputStream.available() > 0)
            }
lbl8:
            // 1 sources

            return this.applicationDataInputQueue.getReadStream().available();
        }

        /*
         * Unable to fully structure code
         */
        public int read() throws IOException {
            if (Connection.this.inputStatus != 2) ** GOTO lbl5
            throw new IOException(Msg.getString("K0059"));
lbl-1000:
            // 1 sources

            {
                Connection.this.readData();
lbl5:
                // 2 sources

                ** while (this.applicationDataInputQueue.getReadStream().available() == 0 && Connection.this.inputStream != null)
            }
lbl6:
            // 1 sources

            if (this.applicationDataInputQueue.getReadStream().available() == 0 && Connection.this.inputStream == null) {
                return -1;
            }
            return this.applicationDataInputQueue.getReadStream().read();
        }

        /*
         * Unable to fully structure code
         */
        public int read(byte[] var1_1, int var2_2, int var3_3) throws IOException {
            if (Connection.this.inputStatus != 2) ** GOTO lbl5
            throw new IOException(Msg.getString("K0059"));
lbl-1000:
            // 1 sources

            {
                Connection.this.readData();
lbl5:
                // 2 sources

                ** while (this.applicationDataInputQueue.getReadStream().available() == 0 && Connection.this.inputStream != null)
            }
lbl6:
            // 2 sources

            while (Connection.this.inputStream != null && Connection.this.inputStream.available() > 0 && this.applicationDataInputQueue.getReadStream().available() < var3_3) {
                Connection.this.readData();
            }
            if (Connection.this.inputStream == null && this.applicationDataInputQueue.getReadStream().available() == 0) {
                return -1;
            }
            return this.applicationDataInputQueue.getReadStream().read(var1_1, var2_2, var3_3);
        }

        public int read(byte[] byArray) throws IOException {
            return this.read(byArray, 0, byArray.length);
        }

        public void close() throws IOException {
            if (Connection.this.inputStatus != 2) {
                Connection.this.inputStatus = 2;
                if (Connection.this.inputStream != null) {
                    Connection.this.inputStream.close();
                }
                if (Connection.this.outputStatus == 2) {
                    Connection.this.closeConnection();
                }
            }
        }
    }

    private final class SSLOutputStream
    extends OutputStream {
        SSLOutputStream() {
        }

        public void write(byte[] byArray, int n, int n2) throws IOException {
            if (Connection.this.outputStatus == 2) {
                throw new IOException(Msg.getString("K0059"));
            }
            Connection.this.writeData(byArray, n, n2, (byte)23);
        }

        public void write(byte[] byArray) throws IOException {
            if (Connection.this.outputStatus == 2) {
                throw new IOException(Msg.getString("K0059"));
            }
            Connection.this.writeData(byArray, 0, byArray.length, (byte)23);
        }

        public void write(int n) throws IOException {
            if (Connection.this.outputStatus == 2) {
                throw new IOException(Msg.getString("K0059"));
            }
            this.write(new byte[]{(byte)n});
        }

        public void close() throws IOException {
            if (Connection.this.outputStatus != 2) {
                Connection.this.outputStatus = 2;
                Connection.this.outputStream.close();
                if (Connection.this.inputStatus == 2) {
                    Connection.this.closeConnection();
                }
            }
        }
    }
}

