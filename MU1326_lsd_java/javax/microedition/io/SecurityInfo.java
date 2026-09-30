/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.pki.Certificate;

public interface SecurityInfo {
    public String getCipherSuite();

    public String getProtocolName();

    public String getProtocolVersion();

    public Certificate getServerCertificate();
}

