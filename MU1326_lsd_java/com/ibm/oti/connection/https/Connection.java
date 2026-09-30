/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.https;

import com.ibm.j9.ssl.Util;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.microedition.io.HttpsConnection;
import javax.microedition.io.SecurityInfo;
import javax.microedition.io.StreamConnection;

public class Connection
extends com.ibm.oti.connection.http.Connection
implements HttpsConnection {
    private com.ibm.oti.connection.ssl.Connection sslConnection = null;

    public SecurityInfo getSecurityInfo() throws IOException {
        if (this.isClosed()) {
            throw new IOException();
        }
        if (this.sslConnection == null) {
            super.connect();
        }
        return this.sslConnection.getSecurityInfo();
    }

    public String getProtocol() {
        return "https";
    }

    protected int getDefaultPort() {
        return 443;
    }

    protected StreamConnection openSocket(boolean bl, String string) throws IOException {
        if (this.sslConnection != null) {
            return this.sslConnection;
        }
        String string2 = "//" + this.getHostName() + ":" + this.getHostPort() + string;
        com.ibm.oti.connection.socket.Connection connection = new com.ibm.oti.connection.socket.Connection();
        connection.setParameters2(string2, 3, bl);
        try {
            this.sslConnection = new com.ibm.oti.connection.ssl.Connection(connection, this.getHostName());
            this.verifyHostname();
        }
        catch (IOException iOException) {
            connection.close();
            throw iOException;
        }
        return this.sslConnection;
    }

    protected void verifyHostname() throws IOException {
        String string = this.getSubjectCN(this.sslConnection.getServerCertSubject());
        if (string == null) {
            throw new IOException(Msg.getString("K0201", null, null));
        }
        String string2 = this.getHost();
        int n = string2.length();
        int n2 = string.length();
        while (true) {
            String string3;
            String string4;
            int n3;
            int n4;
            if ((n4 = string2.lastIndexOf(46, n - 1)) == -1) {
                n4 = 0;
            }
            if ((n3 = string.lastIndexOf(46, n2 - 1)) == -1) {
                n3 = 0;
            }
            if (!Util.matchesPattern(string4 = string2.substring(n4, n).toLowerCase(), string3 = string.substring(n3, n2).toLowerCase())) {
                throw new IOException(Msg.getString("K0201", string, string2));
            }
            if (n4 == 0 || n3 == 0) {
                if (n4 == n3) break;
                throw new IOException(Msg.getString("K0201", string, string2));
            }
            n = n4;
            n2 = n3;
        }
    }

    protected String getSubjectAltName(X509Certificate x509Certificate) {
        try {
            byte[] byArray = x509Certificate.getExtensionValue("2.5.29.17");
            if (byArray == null) {
                return null;
            }
            ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
            ASN1Decoder.Node node = aSN1Decoder.readContents();
            if (node.type != 4) {
                return null;
            }
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream((byte[])node.data));
            ASN1Decoder.Node node2 = aSN1Decoder.readContents();
            if (node2.type != 16) {
                return null;
            }
            ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node2.data;
            int n = 0;
            while (n < nodeArray.length) {
                if (nodeArray[n].type == 2) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])node.data, nodeArray[n].startPosition, nodeArray[n].endPosition);
                    aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
                    aSN1Decoder.configureTypeRedirection(0, new ASN1Decoder.TypeMapper(){

                        public int map(int n, int n2, int n3) {
                            if (n == 2) {
                                return 22;
                            }
                            return n;
                        }
                    });
                    ASN1Decoder.Node node3 = aSN1Decoder.readContents();
                    if (node3.type != 22) {
                        return null;
                    }
                    return (String)node3.data;
                }
                ++n;
            }
            return null;
        }
        catch (ASN1Exception aSN1Exception) {
            return null;
        }
    }

    protected String getSubjectCN(String string) {
        X500Principal x500Principal = new X500Principal(string);
        return x500Principal.getValueForKey("CN");
    }
}

