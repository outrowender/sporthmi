/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.X509Extension;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class X509CRLEntry
extends java.security.cert.X509CRLEntry {
    private byte[] encoded;
    private BigInteger serialNumber;
    private Date revocationDate;
    private Hashtable extensions;
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS = new String[0];

    public byte[] getEncoded() throws CRLException {
        return this.encoded;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public Date getRevocationDate() {
        return this.revocationDate;
    }

    public boolean hasExtensions() {
        if (this.extensions == null) {
            return false;
        }
        return this.extensions.size() > 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X.509 CRL Entry S/N=");
        stringBuffer.append(this.getSerialNumber());
        stringBuffer.append(" , Extensions: ");
        stringBuffer.append(this.extensions == null ? 0 : this.extensions.size());
        stringBuffer.append(" , Revocation: ");
        stringBuffer.append(this.getRevocationDate());
        return stringBuffer.toString();
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        if (set == null) {
            return false;
        }
        if (set.size() > SUPPORTED_CRITICAL_EXTENSIONS.length) {
            return true;
        }
        int n = 0;
        while (n < SUPPORTED_CRITICAL_EXTENSIONS.length) {
            set.remove(SUPPORTED_CRITICAL_EXTENSIONS[n]);
            ++n;
        }
        return set.size() != 0;
    }

    private Set getExtensionOIDs(boolean bl) {
        if (this.extensions == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumeration = this.extensions.elements();
        while (enumeration.hasMoreElements()) {
            X509Extension x509Extension = (X509Extension)enumeration.nextElement();
            if (x509Extension.isCritical() != bl) continue;
            hashSet.add(x509Extension.name());
        }
        return hashSet;
    }

    public Set getCriticalExtensionOIDs() {
        return this.getExtensionOIDs(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return this.getExtensionOIDs(false);
    }

    public byte[] getExtensionValue(String string) {
        if (this.extensions == null) {
            return null;
        }
        X509Extension x509Extension = (X509Extension)this.extensions.get(string);
        if (x509Extension == null) {
            return null;
        }
        byte[] byArray = x509Extension.value();
        if (byArray == null) {
            byArray = new byte[]{};
        }
        ASN1Decoder.Node node = new ASN1Decoder.Node();
        node.type = 4;
        node.data = x509Extension.value();
        return ASN1Encoder.encodeNode(node);
    }

    static X509CRLEntry X509CRLEntryFromASN1Object(ASN1Decoder.Node node, byte[] byArray) throws CRLException {
        try {
            X509CRLEntry x509CRLEntry = new X509CRLEntry();
            int n = node.startPosition;
            int n2 = node.endPosition;
            if (n == 0 && n2 == byArray.length - 1) {
                x509CRLEntry.encoded = byArray;
            } else {
                x509CRLEntry.encoded = new byte[n2 - n + 1];
                System.arraycopy((Object)byArray, n, (Object)x509CRLEntry.encoded, 0, x509CRLEntry.encoded.length);
            }
            ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
            x509CRLEntry.serialNumber = (BigInteger)nodeArray[0].data;
            x509CRLEntry.revocationDate = (Date)nodeArray[1].data;
            if (nodeArray.length > 2) {
                x509CRLEntry.extensions = new Hashtable();
                ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[2].data;
                int n3 = 0;
                while (n3 < nodeArray2.length) {
                    ASN1Decoder.Node node2 = nodeArray2[n3];
                    ASN1Decoder.Node[] nodeArray3 = (ASN1Decoder.Node[])node2.data;
                    x509CRLEntry.extensions.put(nodeArray3[0], nodeArray3[1]);
                    ++n3;
                }
            }
            return x509CRLEntry;
        }
        catch (ClassCastException classCastException) {
            throw new CRLException();
        }
    }
}

