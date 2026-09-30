/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.socket;

import com.ibm.oti.connection.ConnectionUtil;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.connection.socket.Socket;
import com.ibm.oti.connection.socket.SocketHelper;
import com.ibm.oti.util.Msg;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.SocketConnection;

public class Connection
implements CreateConnection,
SocketConnection {
    static final int DEFAULT_TIMEOUT = 8000;
    private static final int UNOPENED = 0;
    private static final int OPEN = 1;
    private static final int CLOSED = 2;
    private String host;
    private int access;
    private int port = 0;
    private int timeout = 0;
    private int inputStatus = 0;
    private int outputStatus = 0;
    private java.net.Socket socket;

    public Connection() {
    }

    public Connection(java.net.Socket socket) {
        this.host = "";
        this.access = 3;
        this.socket = socket;
    }

    public javax.microedition.io.Connection setParameters2(String string, int n, boolean bl) throws IOException {
        if (string.startsWith("//") && (string.length() == 2 || string.length() > 2 && (string.charAt(2) == ':' || string.charAt(2) == ';'))) {
            Class clazz = null;
            try {
                clazz = Class.forName("com.ibm.oti.connection.serversocket.Connection");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new ConnectionNotFoundException(Msg.getString("K0002", "serversocket"));
            }
            boolean bl2 = false;
            CreateConnection createConnection = null;
            try {
                createConnection = (CreateConnection)clazz.newInstance();
            }
            catch (InstantiationException instantiationException) {
                bl2 = true;
            }
            catch (IllegalAccessException illegalAccessException) {
                bl2 = true;
            }
            if (bl2) {
                throw new ConnectionNotFoundException(Msg.getString("K0003", clazz));
            }
            return createConnection.setParameters2(string, n, bl);
        }
        this.setParameters(string, n, bl);
        return this;
    }

    private void setParameters(String string, int n, boolean bl) throws IOException {
        String[][] stringArray = ConnectionUtil.NO_PARAMETERS;
        int n2 = string.indexOf(59);
        if (n2 != -1) {
            stringArray = ConnectionUtil.getParameters(string.substring(n2 + 1));
            string = string.substring(0, n2);
        }
        this.setParameters(string, stringArray, n, bl);
    }

    private void setParameters(String string, String[][] stringArray, int n, boolean bl) throws IOException {
        int[] nArray = new int[1];
        boolean bl2 = false;
        boolean bl3 = false;
        int n2 = -1;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n5 < stringArray.length) {
            String string2;
            String string3 = stringArray[n5][0];
            stringArray[n5][0] = stringArray[n5][0].toLowerCase();
            if (ConnectionUtil.intParam("so_timeout", stringArray[n5], 1, nArray)) {
                this.timeout = nArray[0];
            } else if (ConnectionUtil.intParam("so_linger", stringArray[n5], 1, nArray)) {
                n2 = nArray[0];
                if (n2 > 65535) {
                    n2 = 65535;
                }
            } else if (stringArray[n5][0].equals("tcp_nodelay")) {
                string2 = stringArray[n5][1].toLowerCase();
                if (string2.equals("true")) {
                    bl2 = true;
                } else if (!string2.equals("false")) {
                    throw new IllegalArgumentException(Msg.getString("K00b5", stringArray[n5][1]));
                }
            } else if (stringArray[n5][0].equals("so_keepalive")) {
                string2 = stringArray[n5][1].toLowerCase();
                if (string2.equals("true")) {
                    bl3 = true;
                } else if (!string2.equals("false")) {
                    throw new IllegalArgumentException(Msg.getString("K00b5", stringArray[n5][1]));
                }
            } else if (ConnectionUtil.intParam("so_rcvbuf", stringArray[n5], 2, nArray)) {
                n3 = nArray[0];
            } else if (ConnectionUtil.intParam("so_sndbuf", stringArray[n5], 2, nArray)) {
                n4 = nArray[0];
            } else {
                throw new IllegalArgumentException(Msg.getString("K00a5", string3));
            }
            ++n5;
        }
        if (bl && this.timeout == 0) {
            this.timeout = 8000;
        }
        this.host = string;
        this.access = n;
        if (!this.host.startsWith("//")) {
            throw new IllegalArgumentException(Msg.getString("K01cc"));
        }
        this.host = SocketHelper.parseURL(string, nArray, true, false);
        try {
            this.socket = new java.net.Socket(this.host, nArray[0]);
        }
        catch (UnknownHostException unknownHostException) {
            throw new ConnectionNotFoundException(Msg.getString("K01ce", this.host, unknownHostException.getMessage()));
        }
        catch (IOException iOException) {
            throw new ConnectionNotFoundException(Msg.getString("K01cf", new StringBuffer(String.valueOf(this.host)).append(":").append(nArray[0]).toString(), iOException.getMessage()));
        }
        try {
            if (n3 != 0) {
                this.socket.setReceiveBufferSize(n3);
            }
            if (n4 != 0) {
                this.socket.setSendBufferSize(n4);
            }
            if (n2 != -1) {
                this.socket.setSoLinger(true, n2);
            }
            if (bl2) {
                this.socket.setTcpNoDelay(true);
            }
            if (bl3) {
                this.socket.setKeepAlive(true);
            }
            if (this.timeout != 0) {
                this.socket.setSoTimeout(this.timeout);
            }
        }
        catch (SocketException socketException) {
            if (this.socket != null) {
                this.socket.close();
            }
            throw new IOException(socketException.getMessage());
        }
    }

    public void close() throws IOException {
        this.host = null;
        if (this.inputStatus != 1 && this.outputStatus != 1) {
            this.socket.close();
        }
    }

    public InputStream openInputStream() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 1 && this.access != 3) {
            throw new IOException(Msg.getString("K00a9"));
        }
        if (this.inputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.inputStatus = 1;
        return new InputStream(){
            InputStream stream;
            {
                this.stream = Connection.this.socket.getInputStream();
            }

            public int available() throws IOException {
                if (Connection.this.inputStatus == 2) {
                    throw new IOException(Msg.getString("K0059"));
                }
                return this.stream.available();
            }

            public long skip(int n) throws IOException {
                if (Connection.this.inputStatus == 2) {
                    throw new IOException(Msg.getString("K0059"));
                }
                return this.stream.skip(n);
            }

            public void close() throws IOException {
                if (Connection.this.inputStatus != 2) {
                    Connection.this.inputStatus = 2;
                    if (Connection.this.outputStatus != 1 && Connection.this.host == null) {
                        this.stream.close();
                    }
                }
            }

            public int read(byte[] byArray, int n, int n2) throws IOException {
                if (Connection.this.inputStatus == 2) {
                    throw new IOException(Msg.getString("K0059"));
                }
                int n3 = this.stream.read(byArray, n, n2);
                return n3;
            }

            public int read() throws IOException {
                if (Connection.this.inputStatus == 2) {
                    throw new IOException(Msg.getString("K0059"));
                }
                return this.stream.read();
            }
        };
    }

    public OutputStream openOutputStream() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 2 && this.access != 3) {
            throw new IOException(Msg.getString("K00aa"));
        }
        if (this.outputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.outputStatus = 1;
        return new OutputStream(){
            OutputStream stream;
            {
                this.stream = Connection.this.socket.getOutputStream();
            }

            public void close() throws IOException {
                if (Connection.this.outputStatus != 2) {
                    if ((Socket.getSocketFlags() & 8) == 0 || Connection.this.socket.getSoLinger() == -1) {
                        Connection.this.socket.shutdownOutput();
                    }
                    Connection.this.outputStatus = 2;
                    if (Connection.this.inputStatus != 1 && Connection.this.host == null) {
                        this.stream.close();
                    }
                }
            }

            public void write(int n) throws IOException {
                if (Connection.this.outputStatus == 2) {
                    throw new IOException(Msg.getString("K0059"));
                }
                this.stream.write(n);
            }

            public void write(byte[] byArray, int n, int n2) throws IOException {
                if (Connection.this.outputStatus == 2) {
                    throw new IOException(Msg.getString("K0059"));
                }
                this.stream.write(byArray, n, n2);
            }

            public void flush() throws IOException {
                if (Connection.this.outputStatus == 2) {
                    throw new IOException(Msg.getString("K0059"));
                }
                this.stream.flush();
            }
        };
    }

    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(this.openInputStream());
    }

    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(this.openOutputStream());
    }

    public String getLocalAddress() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return this.socket.getLocalAddress().getHostAddress();
    }

    public int getLocalPort() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return this.socket.getLocalPort();
    }

    public String getAddress() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return this.socket.getInetAddress().getHostAddress();
    }

    public int getPort() throws IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return this.socket.getPort();
    }

    public int getSocketOption(byte by) throws IllegalArgumentException, IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        try {
            switch (by) {
                case 0: {
                    return this.socket.getTcpNoDelay() ? 0 : 1;
                }
                case 2: {
                    return this.socket.getKeepAlive() ? 1 : 0;
                }
                case 1: {
                    int n = this.socket.getSoLinger();
                    return n == -1 ? 0 : n;
                }
                case 3: {
                    return this.socket.getReceiveBufferSize();
                }
                case 4: {
                    return this.socket.getSendBufferSize();
                }
            }
            throw new IllegalArgumentException(Msg.getString("K01c8"));
        }
        catch (IOException iOException) {
            return -1;
        }
    }

    public void setSocketOption(byte by, int n) throws IllegalArgumentException, IOException {
        if (this.host == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K01c9"));
        }
        try {
            switch (by) {
                case 0: {
                    this.socket.setTcpNoDelay(n == 0);
                    break;
                }
                case 2: {
                    this.socket.setKeepAlive(n != 0);
                    break;
                }
                case 1: {
                    this.socket.setSoLinger(n != 0, n);
                    break;
                }
                case 3: {
                    this.socket.setReceiveBufferSize(n);
                    break;
                }
                case 4: {
                    this.socket.setSendBufferSize(n);
                    break;
                }
                default: {
                    throw new IllegalArgumentException(Msg.getString("K01c8"));
                }
            }
        }
        catch (IOException iOException) {}
    }

    public int getTimeout() {
        try {
            return this.socket.getSoTimeout();
        }
        catch (IOException iOException) {
            return 0;
        }
    }
}

