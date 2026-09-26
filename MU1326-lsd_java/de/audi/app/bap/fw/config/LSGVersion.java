/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.config;

public final class LSGVersion {
    private final int major;
    private final int minor;

    public static LSGVersion getInstance(int n, int n2) {
        return new LSGVersion(n, n2);
    }

    private LSGVersion(int n, int n2) {
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
        if (super.getClass() != object.getClass()) {
            return false;
        }
        LSGVersion lSGVersion = (LSGVersion)object;
        if (this.major != lSGVersion.major) {
            return false;
        }
        return this.minor == lSGVersion.minor;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.major;
        n = 31 * n + this.minor;
        return n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(56);
        stringBuffer.append("\n - LSG_VersionMajor - ");
        stringBuffer.append(this.major);
        stringBuffer.append("\n - LSG_VersionMinor - ");
        stringBuffer.append(this.minor);
        return stringBuffer.toString();
    }
}

