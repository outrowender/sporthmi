/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.Header;
import com.ibm.oti.util.BASE64Encoder;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.vm.VM;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketPermission;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class HttpURLConnection
extends java.net.HttpURLConnection {
    int httpVersion = 1;
    private final int defaultPort;
    InputStream is;
    private InputStream uis;
    OutputStream socketOut;
    private HttpOutputStream os;
    private boolean sentRequest = false;
    boolean sendChunked = false;
    String proxyName;
    private int hostPort = -1;
    private int readTimeout = -1;
    private boolean updateProxy = true;
    private static Header defaultReqHeader = new Header();
    private Header reqHeader;
    private Header resHeader;
    private Socket currentSocket;
    private static Timer cacheTimer;
    private static Hashtable socketCache;
    private boolean reusingSocket = false;

    protected HttpURLConnection(URL uRL) {
        this(uRL, 80);
    }

    protected HttpURLConnection(URL uRL, int n) {
        super(uRL);
        this.defaultPort = n;
        this.reqHeader = (Header)defaultReqHeader.clone();
    }

    public void connect() throws IOException {
        if (this.connected) {
            return;
        }
        this.openNetworkInterfaceAndUpdateProxyInformation();
        Socket socket = this.openSocket();
        if (this.readTimeout >= 0) {
            socket.setSoTimeout(this.readTimeout);
        }
        this.connected = true;
        try {
            this.socketOut = socket.getOutputStream();
        }
        catch (IOException iOException) {
            if (this.isReusingSocket()) {
                this.connected = false;
                socket.close();
                this.connect();
                return;
            }
            throw iOException;
        }
        this.is = new BufferedInputStream(socket.getInputStream());
    }

    protected Socket openSocket() throws IOException {
        this.currentSocket = HttpURLConnection.getSocketFromCache(this.getHostName(), this.getHostPort());
        if (this.currentSocket == null) {
            this.reusingSocket = false;
            this.currentSocket = new Socket(this.getHostName(), this.getHostPort());
        } else {
            this.reusingSocket = true;
        }
        return this.currentSocket;
    }

    public boolean isReusingSocket() {
        boolean bl = this.reusingSocket;
        return bl;
    }

    private static String getSockDescriptor(String string, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(':');
        stringBuffer.append(n);
        return stringBuffer.toString();
    }

    private static Socket getSocketFromCache(String string, int n) {
        if (socketCache == null) {
            return null;
        }
        CacheEntry cacheEntry = (CacheEntry)socketCache.remove(HttpURLConnection.getSockDescriptor(string, n));
        if (cacheEntry != null) {
            cacheEntry.cancelTimerTask();
            return cacheEntry.getSocket();
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void addSocketToCache(final String string, final int n, int n2, final Socket socket) {
        CacheEntry cacheEntry;
        String string2;
        if (socketCache == null) {
            socketCache = new Hashtable();
        }
        if (cacheTimer == null) {
            cacheTimer = new Timer(true);
        }
        if ((string2 = HttpURLConnection.getSystemProperty("http.keepAlive")) != null && !"true".equalsIgnoreCase(string2)) {
            return;
        }
        String string3 = HttpURLConnection.getSystemProperty("http.maxConnections");
        int n3 = string3 == null ? 5 : Integer.parseInt(string3);
        if (n3 <= 0) {
            return;
        }
        String string4 = HttpURLConnection.getSystemProperty("http.defaultKeepAliveTimeout");
        int n4 = string4 == null ? 15000 : Integer.parseInt(string4) * 1000;
        if (n4 <= 0) {
            return;
        }
        if (n2 > 0) {
            n4 = n2 * 1000;
        }
        Object object = socketCache;
        synchronized (object) {
            if (socketCache.size() >= n3) {
                cacheEntry = (CacheEntry)socketCache.remove(socketCache.keys().nextElement());
                cacheEntry.closeSocket();
            }
        }
        object = new TimerTask(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                boolean bl = false;
                CacheEntry cacheEntry = null;
                String string2 = HttpURLConnection.getSockDescriptor(string, n);
                Hashtable hashtable = socketCache;
                synchronized (hashtable) {
                    cacheEntry = (CacheEntry)socketCache.get(string2);
                    if (cacheEntry != null && cacheEntry.getSocket() == socket) {
                        bl = true;
                        socketCache.remove(string2);
                    }
                }
                if (bl) {
                    cacheEntry.closeSocket();
                }
            }
        };
        cacheTimer.schedule((TimerTask)object, n4);
        cacheEntry = (CacheEntry)socketCache.put(HttpURLConnection.getSockDescriptor(string, n), new CacheEntry(socket, (TimerTask)object));
        if (cacheEntry != null) {
            cacheEntry.closeSocket();
        }
    }

    private boolean canReuseSocket() {
        if (this.resHeader == null || this.resHeader.getStatusLine() == null) {
            return false;
        }
        String string = this.resHeader.get("Connection");
        if ("close".equalsIgnoreCase(string)) {
            return false;
        }
        if (this.resHeader.getStatusLine().startsWith("HTTP/1.0") && !"keep-alive".equalsIgnoreCase(string)) {
            return false;
        }
        if (this.uis == null) {
            return false;
        }
        try {
            if (this.uis.read() != -1) {
                return false;
            }
        }
        catch (IOException iOException) {
            return false;
        }
        return this.currentSocket != null;
    }

    protected void openNetworkInterfaceAndUpdateProxyInformation() {
        if (!this.updateProxy) {
            return;
        }
        this.updateProxy = false;
        String string = HttpURLConnection.getSystemProperty("http.proxyHost");
        String string2 = HttpURLConnection.getSystemProperty("http.proxyPort");
        if (string == null || string2 == null) {
            final String[] stringArray = VM.getHttpProxyParms();
            if (stringArray == null) {
                return;
            }
            this.proxyName = stringArray[0];
            this.hostPort = Integer.parseInt(stringArray[1]);
            AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    Properties properties = System.getProperties();
                    properties.setProperty("http.proxyHost", HttpURLConnection.this.proxyName);
                    properties.setProperty("http.proxyPort", stringArray[1]);
                    return null;
                }
            });
        }
    }

    public void setReadTimeout(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K0036"));
        }
        this.readTimeout = n;
    }

    public void disconnect() {
        try {
            this.closeSocket();
        }
        catch (IOException iOException) {}
    }

    private int getKeepAliveTimeoutFromResponse() {
        String string = this.resHeader.get("Keep-Alive");
        int n = 0;
        if (string != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, "=, ");
            while (stringTokenizer.hasMoreElements()) {
                if (!"timeout".equalsIgnoreCase((String)stringTokenizer.nextElement())) continue;
                try {
                    n = Integer.parseInt((String)stringTokenizer.nextElement());
                }
                catch (NumberFormatException numberFormatException) {
                    n = 0;
                }
            }
        }
        return n;
    }

    void closeSocket() throws IOException {
        if (this.canReuseSocket()) {
            HttpURLConnection.addSocketToCache(this.getHostName(), this.getHostPort(), this.getKeepAliveTimeoutFromResponse(), this.currentSocket);
        } else if (this.is != null) {
            this.is.close();
        }
    }

    void endRequest() throws IOException {
        if (this.os != null) {
            this.os.close();
        }
        this.sentRequest = false;
    }

    public static String getDefaultRequestProperty(String string) {
        return defaultReqHeader.get(string);
    }

    public InputStream getErrorStream() {
        if (this.connected && this.method != "HEAD" && this.responseCode >= 400) {
            return this.uis;
        }
        return null;
    }

    public String getHeaderField(int n) {
        try {
            this.getInputStream();
            return this.resHeader.get(n);
        }
        catch (IOException iOException) {
            if (this.resHeader != null) {
                return this.resHeader.get(n);
            }
            return null;
        }
    }

    public String getHeaderField(String string) {
        try {
            this.getInputStream();
            return this.resHeader.get(string);
        }
        catch (IOException iOException) {
            if (this.resHeader != null) {
                return this.resHeader.get(string);
            }
            return null;
        }
    }

    public String getHeaderFieldKey(int n) {
        try {
            this.getInputStream();
            return this.resHeader.getKey(n);
        }
        catch (IOException iOException) {
            if (this.resHeader != null) {
                return this.resHeader.getKey(n);
            }
            return null;
        }
    }

    public Map getHeaderFields() {
        return this.resHeader.getFieldMap();
    }

    public Map getRequestProperties() {
        return this.reqHeader.getFieldMap();
    }

    public InputStream getInputStream() throws IOException {
        if (!this.doInput) {
            throw new ProtocolException(Msg.getString("K008d"));
        }
        this.doRequest();
        if (this.responseCode >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.uis;
    }

    private InputStream getContentStream() throws IOException {
        if (this.uis != null) {
            return this.uis;
        }
        String string = this.resHeader.get("Transfer-Encoding");
        if (string != null && string.toLowerCase().equals("chunked")) {
            this.uis = new ChunkedInputStream();
            return this.uis;
        }
        String string2 = this.resHeader.get("Content-Length");
        if (string2 != null) {
            try {
                int n = Integer.parseInt(string2);
                this.uis = new LimitedInputStream(n);
                return this.uis;
            }
            catch (NumberFormatException numberFormatException) {}
        }
        this.uis = this.is;
        return this.uis;
    }

    public OutputStream getOutputStream() throws IOException {
        if (!this.doOutput) {
            throw new ProtocolException(Msg.getString("K008e"));
        }
        if (this.sentRequest) {
            throw new ProtocolException(Msg.getString("K0090"));
        }
        if (this.os != null) {
            return this.os;
        }
        if (this.method == "GET") {
            this.setRequestMethod("POST");
        }
        if (this.method != "PUT" && this.method != "POST") {
            throw new ProtocolException(Msg.getString("K008f", this.method));
        }
        int n = -1;
        String string = this.reqHeader.get("Content-Length");
        if (string != null) {
            n = Integer.parseInt(string);
        }
        String string2 = this.reqHeader.get("Transfer-Encoding");
        if (this.httpVersion > 0 && string2 != null && "chunked".equals(string2 = string2.toLowerCase())) {
            this.sendChunked = true;
            n = -1;
        }
        if (this.httpVersion > 0 && this.sendChunked || n >= 0) {
            this.os = new HttpOutputStream(n);
            this.doRequest();
            return this.os;
        }
        this.os = new HttpOutputStream();
        return this.os;
    }

    public Permission getPermission() throws IOException {
        return new SocketPermission(new StringBuffer(String.valueOf(this.getHostName())).append(":").append(this.getHostPort()).toString(), "connect, resolve");
    }

    public String getRequestProperty(String string) {
        if (this.connected) {
            throw new IllegalAccessError(Msg.getString("K0091"));
        }
        return this.reqHeader.get(string);
    }

    /*
     * Unable to fully structure code
     */
    String readln() throws IOException {
        var1_1 = false;
        var2_2 = new StringBuffer(80);
        var3_3 = this.is.read();
        if (var3_3 >= 0) ** GOTO lbl17
        return null;
lbl-1000:
        // 1 sources

        {
            if (var1_1) {
                var2_2.append('\r');
                var1_1 = false;
            }
            if (var3_3 == 13) {
                var1_1 = true;
            } else {
                var2_2.append((char)var3_3);
            }
            var3_3 = this.is.read();
            if (var3_3 < 0) break;
lbl17:
            // 2 sources

            ** while (var3_3 != 10)
        }
lbl18:
        // 2 sources

        return var2_2.toString();
    }

    private String requestString() {
        if (this.usingProxy() || this.proxyName != null) {
            return this.url.toString();
        }
        String string = this.url.getFile();
        if (string == null || string.length() == 0) {
            string = "/";
        }
        return string;
    }

    private boolean sendRequest() throws IOException {
        byte[] byArray = this.createRequest();
        while (true) {
            try {
                if (!this.connected) {
                    this.connect();
                }
                this.socketOut.write(byArray);
                this.sentRequest = true;
                if (this.os != null && this.os.isCached()) {
                    this.socketOut.write(this.os.toByteArray());
                }
                if (this.os == null || this.os.isCached()) {
                    this.readServerResponse();
                    return true;
                }
                return false;
            }
            catch (IOException iOException) {
                if (!this.isReusingSocket()) {
                    throw iOException;
                }
                this.currentSocket = null;
                this.closeSocket();
                this.connected = false;
                this.sentRequest = false;
                if (this.isReusingSocket()) continue;
                return false;
            }
            break;
        }
    }

    void readServerResponse() throws IOException {
        this.socketOut.flush();
        do {
            this.responseCode = -1;
            this.responseMessage = null;
            this.resHeader = new Header();
            String string = this.readln();
            if (string == null && this.isReusingSocket()) {
                this.connected = false;
                this.sentRequest = false;
                this.closeSocket();
                this.sendRequest();
                return;
            }
            if (string == null) continue;
            this.resHeader.setStatusLine(string.trim());
            this.readHeaders();
        } while (this.getResponseCode() == 100);
        if (this.method == "HEAD" || this.responseCode >= 100 && this.responseCode < 200 || this.responseCode == 204 || this.responseCode == 304) {
            this.closeSocket();
            this.uis = new LimitedInputStream(0);
        }
    }

    public int getResponseCode() throws IOException {
        int n;
        this.doRequest();
        if (this.responseCode != -1) {
            return this.responseCode;
        }
        String string = this.resHeader.getStatusLine();
        if (string == null || !string.startsWith("HTTP/")) {
            return -1;
        }
        string.trim();
        int n2 = string.indexOf(" ") + 1;
        if (n2 == 0) {
            return -1;
        }
        if (string.charAt(n2 - 2) != '1') {
            this.httpVersion = 0;
        }
        if ((n = n2 + 3) > string.length()) {
            n = string.length();
        }
        this.responseCode = Integer.parseInt(string.substring(n2, n));
        if (n + 1 <= string.length()) {
            this.responseMessage = string.substring(n + 1);
        }
        return this.responseCode;
    }

    void readHeaders() throws IOException {
        String string;
        while ((string = this.readln()) != null && string.length() > 1) {
            int n = string.indexOf(":");
            if (n < 0) {
                this.resHeader.add("", string.trim());
                continue;
            }
            this.resHeader.add(string.substring(0, n), string.substring(n + 1).trim());
        }
    }

    private byte[] createRequest() throws IOException {
        this.openNetworkInterfaceAndUpdateProxyInformation();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append(this.method);
        stringBuffer.append(' ');
        stringBuffer.append(this.requestString());
        stringBuffer.append(' ');
        stringBuffer.append("HTTP/1.");
        if (this.httpVersion == 0) {
            stringBuffer.append("0\r\n");
        } else {
            stringBuffer.append("1\r\n");
        }
        if (this.reqHeader.get("User-Agent") == null) {
            stringBuffer.append("User-Agent: ");
            String string = HttpURLConnection.getSystemProperty("http.agent");
            if (string == null) {
                stringBuffer.append("Java");
                stringBuffer.append(HttpURLConnection.getSystemProperty("java.version"));
            } else {
                stringBuffer.append(string);
            }
            stringBuffer.append("\r\n");
        }
        if (this.reqHeader.get("Host") == null) {
            stringBuffer.append("Host: ");
            stringBuffer.append(this.url.getHost());
            int n = this.url.getPort();
            if (n > 0 && n != this.defaultPort) {
                stringBuffer.append(':');
                stringBuffer.append(Integer.toString(n));
            }
            stringBuffer.append("\r\n");
        }
        if (this.reqHeader.get("Connection") == null) {
            if (this.httpVersion < 1) {
                stringBuffer.append("Connection: close\r\n");
            } else {
                stringBuffer.append("Connection: keep-alive\r\n");
            }
        }
        if (this.os != null) {
            if (this.reqHeader.get("Content-Type") == null) {
                stringBuffer.append("Content-Type: application/x-www-form-urlencoded\r\n");
            }
            if (this.os.isCached()) {
                if (this.reqHeader.get("Content-Length") == null) {
                    stringBuffer.append("Content-Length: ");
                    stringBuffer.append(Integer.toString(this.os.size()));
                    stringBuffer.append("\r\n");
                }
            } else if (this.os.isChunked()) {
                stringBuffer.append("Transfer-Encoding: chunked\r\n");
            }
        }
        int n = 0;
        while (n < this.reqHeader.length()) {
            String string = this.reqHeader.getKey(n);
            if (string != null) {
                String string2 = string.toLowerCase();
                if (this.os != null && !this.os.isChunked() || !string2.equals("transfer-encoding") && !string2.equals("content-length")) {
                    stringBuffer.append(string);
                    stringBuffer.append(": ");
                    stringBuffer.append(this.reqHeader.get(n));
                    stringBuffer.append("\r\n");
                }
            }
            ++n;
        }
        stringBuffer.append("\r\n");
        return stringBuffer.toString().getBytes("ISO8859_1");
    }

    public static void setDefaultRequestProperty(String string, String string2) {
        defaultReqHeader.add(string, string2);
    }

    public void setIfModifiedSince(long l) throws IllegalAccessError {
        super.setIfModifiedSince(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String string = simpleDateFormat.format(new Date(l));
        this.reqHeader.add("If-Modified-Since", string);
    }

    public void setRequestProperty(String string, String string2) {
        if (this.connected) {
            throw new IllegalAccessError(Msg.getString("K0092"));
        }
        if (string == null) {
            throw new NullPointerException();
        }
        this.reqHeader.set(string, string2);
    }

    public void addRequestProperty(String string, String string2) {
        if (this.connected) {
            throw new IllegalAccessError(Msg.getString("K0092"));
        }
        if (string == null) {
            throw new NullPointerException();
        }
        this.reqHeader.add(string, string2);
    }

    protected int getHostPort() {
        if (this.hostPort != -1) {
            return this.hostPort;
        }
        String string = this.getSystemPropertyOrAlternative("http.proxyPort", "proxyPort");
        this.hostPort = string != null && this.usingProxy() ? Integer.parseInt(string) : this.url.getPort();
        if (this.hostPort < 0) {
            this.hostPort = this.defaultPort;
        }
        return this.hostPort;
    }

    protected String getHostName() {
        if (this.proxyName != null) {
            return this.proxyName;
        }
        if (this.usingProxy()) {
            this.proxyName = this.getSystemPropertyOrAlternative("http.proxyHost", "proxyHost");
            return this.proxyName;
        }
        return this.url.getHost();
    }

    private String getSystemPropertyOrAlternative(String string, String string2) {
        String string3 = HttpURLConnection.getSystemProperty(string);
        if (string3 == null) {
            string3 = HttpURLConnection.getSystemProperty(string2);
        }
        return string3;
    }

    private static String getSystemProperty(String string) {
        String string2 = (String)AccessController.doPrivileged(new PriviAction(string));
        return string2;
    }

    public boolean usingProxy() {
        String string = HttpURLConnection.getSystemProperty("http.proxySet");
        if (string != null) {
            return string.toLowerCase().equals("true");
        }
        string = HttpURLConnection.getSystemProperty("proxySet");
        if (string != null) {
            return string.toLowerCase().equals("true");
        }
        if (HttpURLConnection.getSystemProperty("http.proxyHost") != null) {
            return true;
        }
        return HttpURLConnection.getSystemProperty("proxyHost") != null;
    }

    void doRequest() throws IOException {
        if (this.sentRequest) {
            if (this.resHeader == null && this.os != null) {
                this.os.close();
                this.readServerResponse();
                this.getContentStream();
            }
            return;
        }
        int n = 0;
        while (true) {
            int n2;
            String string;
            if (!this.sendRequest()) {
                return;
            }
            if (this.responseCode == 401) {
                PasswordAuthentication passwordAuthentication;
                int n3;
                string = this.resHeader.get("WWW-Authenticate");
                if (string == null) break;
                n2 = string.indexOf(" ");
                String string2 = string.substring(0, n2);
                String string3 = null;
                String string4 = "realm=\"";
                int n4 = string.indexOf(string4);
                if (n4 != -1 && (n3 = string.indexOf(34, n4 += string4.length())) != -1) {
                    string3 = string.substring(n4, n3);
                }
                if ((passwordAuthentication = Authenticator.requestPasswordAuthentication(this.getHostName(), InetAddress.getByName(this.getHostName()), this.getHostPort(), this.url.getProtocol(), string3, string2)) == null) break;
                this.endRequest();
                this.closeSocket();
                this.connected = false;
                byte[] byArray = new StringBuffer(String.valueOf(passwordAuthentication.getUserName())).append(":").append(new String(passwordAuthentication.getPassword())).toString().getBytes("ISO8859_1");
                String string5 = new String(BASE64Encoder.encode(byArray), "ISO8859_1");
                this.setRequestProperty("Authorization", new StringBuffer(String.valueOf(string2)).append(" ").append(string5).toString());
                continue;
            }
            if (!this.getInstanceFollowRedirects() || this.responseCode != 300 && this.responseCode != 301 && this.responseCode != 302 && this.responseCode != 303 && this.responseCode != 305 || this.os != null) break;
            if (++n > 4) {
                throw new ProtocolException(Msg.getString("K0093"));
            }
            string = this.getHeaderField("Location");
            if (string == null) break;
            if (this.responseCode == 305) {
                n2 = 0;
                if (string.startsWith(new StringBuffer(String.valueOf(this.url.getProtocol())).append(':').toString())) {
                    n2 = this.url.getProtocol().length() + 1;
                }
                if (string.startsWith("//", n2)) {
                    n2 += 2;
                }
                this.setProxy(string.substring(n2));
            } else {
                this.url = new URL(this.url, string);
                this.hostPort = -1;
            }
            this.endRequest();
            this.closeSocket();
            this.sentRequest = false;
            this.connected = false;
        }
        this.getContentStream();
    }

    private void setProxy(String string) {
        int n = string.indexOf(58);
        if (n == -1) {
            this.proxyName = string;
            this.hostPort = this.defaultPort;
        } else {
            this.proxyName = string.substring(0, n);
            String string2 = string.substring(n + 1);
            try {
                this.hostPort = Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(Msg.getString("K00af", string2));
            }
            if (this.hostPort < 0 || this.hostPort > 65535) {
                throw new IllegalArgumentException(Msg.getString("K00b0"));
            }
        }
    }

    private static class CacheEntry {
        private Socket socket;
        private TimerTask timerTask;

        public CacheEntry(Socket socket, TimerTask timerTask) {
            this.socket = socket;
            this.timerTask = timerTask;
        }

        public Socket getSocket() {
            return this.socket;
        }

        public void closeSocket() {
            try {
                this.socket.close();
            }
            catch (IOException iOException) {}
            this.timerTask.cancel();
        }

        public void cancelTimerTask() {
            this.timerTask.cancel();
        }
    }

    private class HttpOutputStream
    extends OutputStream {
        static final int MAX = 1024;
        ByteArrayOutputStream cache = new ByteArrayOutputStream(1031);
        boolean writeToSocket;
        boolean closed = false;
        int limit;

        public HttpOutputStream() {
            this.limit = -1;
        }

        public HttpOutputStream(int n) {
            this.writeToSocket = true;
            this.limit = n;
        }

        private void output(String string) throws IOException {
            HttpURLConnection.this.socketOut.write(string.getBytes("ISO8859_1"));
        }

        private void sendCache(boolean bl) throws IOException {
            int n = this.cache.size();
            if (n > 0 || bl) {
                if (this.limit < 0) {
                    if (n > 0) {
                        this.output(new StringBuffer(String.valueOf(Integer.toHexString(n))).append("\r\n").toString());
                        this.cache.write(13);
                        this.cache.write(10);
                    }
                    if (bl) {
                        this.cache.write(48);
                        this.cache.write(13);
                        this.cache.write(10);
                        this.cache.write(13);
                        this.cache.write(10);
                    }
                }
                HttpURLConnection.this.socketOut.write(this.cache.toByteArray());
                this.cache.reset();
            }
        }

        public synchronized void flush() throws IOException {
            if (this.closed) {
                throw new IOException(Msg.getString("K0059"));
            }
            if (this.writeToSocket) {
                this.sendCache(false);
                HttpURLConnection.this.socketOut.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.writeToSocket) {
                if (this.limit > 0) {
                    throw new IOException(Msg.getString("K00a4"));
                }
                this.sendCache(this.closed);
            }
        }

        public synchronized void write(int n) throws IOException {
            if (this.closed) {
                throw new IOException(Msg.getString("K0059"));
            }
            if (this.limit >= 0) {
                if (this.limit == 0) {
                    throw new IOException(Msg.getString("K00b2"));
                }
                --this.limit;
            }
            this.cache.write(n);
            if (this.writeToSocket && this.cache.size() >= 1024) {
                this.sendCache(false);
            }
        }

        public synchronized void write(byte[] byArray, int n, int n2) throws IOException {
            if (this.closed) {
                throw new IOException(Msg.getString("K0059"));
            }
            if (byArray == null) {
                throw new NullPointerException();
            }
            if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
                throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
            }
            if (this.limit >= 0) {
                if (n2 > this.limit) {
                    throw new IOException(Msg.getString("K00b2"));
                }
                this.limit -= n2;
            }
            if (!this.writeToSocket || this.cache.size() + n2 < 1024) {
                this.cache.write(byArray, n, n2);
            } else {
                if (this.limit < 0) {
                    this.output(new StringBuffer(String.valueOf(Integer.toHexString(n2 + this.cache.size()))).append("\r\n").toString());
                }
                HttpURLConnection.this.socketOut.write(this.cache.toByteArray());
                this.cache.reset();
                HttpURLConnection.this.socketOut.write(byArray, n, n2);
                if (this.limit < 0) {
                    this.output("\r\n");
                }
            }
        }

        synchronized int size() {
            return this.cache.size();
        }

        synchronized byte[] toByteArray() {
            return this.cache.toByteArray();
        }

        boolean isCached() {
            return !this.writeToSocket;
        }

        boolean isChunked() {
            return this.writeToSocket && this.limit == -1;
        }
    }

    private class ChunkedInputStream
    extends InputStream {
        int bytesRemaining = -1;
        boolean atEnd = false;

        public ChunkedInputStream() throws IOException {
            this.readChunkSize();
        }

        public void close() throws IOException {
            HttpURLConnection.this.closeSocket();
            this.atEnd = true;
        }

        public int available() throws IOException {
            int n = HttpURLConnection.this.is.available();
            if (n > this.bytesRemaining) {
                return this.bytesRemaining;
            }
            return n;
        }

        private void readChunkSize() throws IOException {
            String string;
            int n;
            if (this.atEnd) {
                return;
            }
            if (this.bytesRemaining == 0) {
                HttpURLConnection.this.readln();
            }
            if ((n = (string = HttpURLConnection.this.readln()).indexOf(59)) >= 0) {
                string = string.substring(0, n);
            }
            this.bytesRemaining = Integer.parseInt(string.trim(), 16);
            if (this.bytesRemaining == 0) {
                this.atEnd = true;
                HttpURLConnection.this.readHeaders();
            }
        }

        public int read() throws IOException {
            if (this.bytesRemaining <= 0) {
                this.readChunkSize();
            }
            if (this.atEnd) {
                return -1;
            }
            --this.bytesRemaining;
            return HttpURLConnection.this.is.read();
        }

        public int read(byte[] byArray, int n, int n2) throws IOException {
            int n3;
            if (byArray == null) {
                throw new NullPointerException();
            }
            if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.bytesRemaining <= 0) {
                this.readChunkSize();
            }
            if (this.atEnd) {
                return -1;
            }
            if (n2 > this.bytesRemaining) {
                n2 = this.bytesRemaining;
            }
            if ((n3 = HttpURLConnection.this.is.read(byArray, n, n2)) > 0) {
                this.bytesRemaining -= n3;
            }
            return n3;
        }

        public long skip(int n) throws IOException {
            long l;
            if (this.atEnd) {
                return -1L;
            }
            if (this.bytesRemaining <= 0) {
                this.readChunkSize();
            }
            if (n > this.bytesRemaining) {
                n = this.bytesRemaining;
            }
            if ((l = HttpURLConnection.this.is.skip(n)) > 0L) {
                this.bytesRemaining = (int)((long)this.bytesRemaining - l);
            }
            return l;
        }
    }

    private class LimitedInputStream
    extends InputStream {
        int bytesRemaining;

        public LimitedInputStream(int n) {
            this.bytesRemaining = n;
        }

        public void close() throws IOException {
            HttpURLConnection.this.closeSocket();
            this.bytesRemaining = 0;
        }

        public int available() throws IOException {
            int n = HttpURLConnection.this.is.available();
            if (n > this.bytesRemaining) {
                return this.bytesRemaining;
            }
            return n;
        }

        public int read() throws IOException {
            if (this.bytesRemaining <= 0) {
                return -1;
            }
            int n = HttpURLConnection.this.is.read();
            --this.bytesRemaining;
            return n;
        }

        public int read(byte[] byArray, int n, int n2) throws IOException {
            int n3;
            if (byArray == null) {
                throw new NullPointerException();
            }
            if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.bytesRemaining <= 0) {
                return -1;
            }
            if (n2 > this.bytesRemaining) {
                n2 = this.bytesRemaining;
            }
            if ((n3 = HttpURLConnection.this.is.read(byArray, n, n2)) > 0) {
                this.bytesRemaining -= n3;
            }
            return n3;
        }

        public long skip(int n) throws IOException {
            long l;
            if (this.bytesRemaining <= 0) {
                return -1L;
            }
            if (n > this.bytesRemaining) {
                n = this.bytesRemaining;
            }
            if ((l = HttpURLConnection.this.is.skip(n)) > 0L) {
                this.bytesRemaining = (int)((long)this.bytesRemaining - l);
            }
            return l;
        }
    }
}

