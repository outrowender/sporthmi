/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.CipherSpec;
import com.ibm.j9.ssl.ConnectionState;
import com.ibm.j9.ssl.SessionState;
import java.io.IOException;

public interface HandshakeSocket {
    public String getHostName();

    public void sendSocketAlert(byte var1, byte var2);

    public long getTimeoutLength();

    public boolean readData() throws IOException;

    public void writeData(byte[] var1, int var2, int var3, byte var4) throws IOException;

    public void setSessionState(SessionState var1);

    public void setWriteConnectionState(ConnectionState var1) throws IOException;

    public void setReadPendingConnectionState(ConnectionState var1) throws IOException;

    public CipherSpec[] getEnabledCipherSpecs();

    public String[] getEnabledProtocols();
}

