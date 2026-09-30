/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import de.esolutions.fw.util.transport.socket.ssl.JSSEDefaultCredentialProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class JSSEFileCredentialProvider
extends JSSEDefaultCredentialProvider {
    private String keyStorePath;
    private String trustStorePath;

    public void setKeyStorePath(String string) {
        this.keyStorePath = string;
    }

    public void setTrustStorePath(String string) {
        this.trustStorePath = string;
    }

    public void init() throws IOException, GeneralSecurityException {
        String string = this.keyStorePath;
        if (string == null) {
            string = System.getProperty("ipl.keyStore");
        }
        if (string != null && !new File(string).isFile()) {
            throw new FileNotFoundException("JSSE: keyStore not found: " + string);
        }
        this.setKeyStoreStream(new FileInputStream(string));
        String string2 = this.trustStorePath;
        if (string2 == null) {
            string2 = System.getProperty("ipl.trustStore");
        }
        if (string2 != null && !new File(string2).isFile()) {
            throw new FileNotFoundException("JSSE: trustStore not found: " + string2);
        }
        this.setTrustStoreStream(new FileInputStream(string2));
        super.init();
    }
}

