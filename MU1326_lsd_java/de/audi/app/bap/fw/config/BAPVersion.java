/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.config;

public final class BAPVersion {
    private final int major;
    private final int minor;

    public static BAPVersion getInstance(int n, int n2) {
        return new BAPVersion(n, n2);
    }

    private BAPVersion(int n, int n2) {
        this.major = n;
        this.minor = n2;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        BAPVersion bAPVersion = (BAPVersion)object;
        if (this.major != bAPVersion.major) {
            return false;
        }
        return this.minor == bAPVersion.minor;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.major;
        n = 31 * n + this.minor;
        return n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(56);
        stringBuffer.append("\n - BAP_VersionMajor - ");
        stringBuffer.append(this.major);
        stringBuffer.append("\n - BAP_VersionMinor - ");
        stringBuffer.append(this.minor);
        return stringBuffer.toString();
    }
}

