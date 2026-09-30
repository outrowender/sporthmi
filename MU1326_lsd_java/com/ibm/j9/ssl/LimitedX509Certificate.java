/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.oti.security.provider.X509Certificate;
import javax.microedition.pki.Certificate;

public class LimitedX509Certificate
implements Certificate {
    private X509Certificate certImpl = null;

    public LimitedX509Certificate(X509Certificate x509Certificate) {
        this.certImpl = x509Certificate;
    }

    public String getIssuer() {
        return this.certImpl.getIssuerDN().getName();
    }

    public long getNotAfter() {
        return this.certImpl.getNotAfter().getTime();
    }

    public long getNotBefore() {
        return this.certImpl.getNotBefore().getTime();
    }

    public String getSerialNumber() {
        String string = this.certImpl.getSerialNumber().toString(16).toUpperCase();
        if (string.length() % 2 != 0) {
            string = "0" + string;
        }
        String string2 = "";
        int n = 0;
        while (n < string.length()) {
            string2 = String.valueOf(string2) + string.substring(n, n + 2);
            if ((n += 2) >= string.length()) continue;
            string2 = String.valueOf(string2) + ":";
        }
        return string2;
    }

    public String getSigAlgName() {
        return this.certImpl.getSigAlgName();
    }

    public String getSubject() {
        return this.certImpl.getSubjectDN().getName();
    }

    public String getType() {
        return "X.509";
    }

    public String getVersion() {
        return Integer.toString(this.certImpl.getVersion());
    }
}

