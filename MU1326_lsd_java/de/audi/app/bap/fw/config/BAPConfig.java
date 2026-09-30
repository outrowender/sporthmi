/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.config;

import de.audi.app.bap.fw.config.BAPVersion;
import de.audi.app.bap.fw.config.LSGVersion;

public final class BAPConfig {
    private final int lsgClass;
    private final int lsgSubclass;
    private final BAPVersion bapVersion;
    private final LSGVersion lsgVersion;

    public static BAPConfig getInstance(int n, int n2, BAPVersion bAPVersion, LSGVersion lSGVersion) {
        return new BAPConfig(n, n2, bAPVersion, lSGVersion);
    }

    private BAPConfig(int n, int n2, BAPVersion bAPVersion, LSGVersion lSGVersion) {
        this.lsgClass = n;
        this.lsgSubclass = n2;
        this.bapVersion = bAPVersion;
        this.lsgVersion = lSGVersion;
    }

    public int getLsgClass() {
        return this.lsgClass;
    }

    public int getLsgSubclass() {
        return this.lsgSubclass;
    }

    public BAPVersion getBapVersion() {
        return this.bapVersion;
    }

    public LSGVersion getLsgVersion() {
        return this.lsgVersion;
    }

    public boolean isCompatibleWith(BAPConfig bAPConfig) {
        return this.lsgClass == bAPConfig.lsgClass && this.bapVersion.getMajor() == bAPConfig.bapVersion.getMajor() && this.bapVersion.getMinor() == bAPConfig.bapVersion.getMinor() && this.lsgVersion.getMajor() == bAPConfig.lsgVersion.getMajor();
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
        BAPConfig bAPConfig = (BAPConfig)object;
        if (this.bapVersion == null ? bAPConfig.bapVersion != null : !this.bapVersion.equals(bAPConfig.bapVersion)) {
            return false;
        }
        if (this.lsgClass != bAPConfig.lsgClass) {
            return false;
        }
        if (this.lsgSubclass != bAPConfig.lsgSubclass) {
            return false;
        }
        return !(this.lsgVersion == null ? bAPConfig.lsgVersion != null : !this.lsgVersion.equals(bAPConfig.lsgVersion));
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.bapVersion == null ? 0 : this.bapVersion.hashCode());
        n = 31 * n + this.lsgClass;
        n = 31 * n + this.lsgSubclass;
        n = 31 * n + (this.lsgVersion == null ? 0 : this.lsgVersion.hashCode());
        return n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(45);
        stringBuffer.append(this.bapVersion.toString());
        stringBuffer.append(this.lsgVersion.toString());
        stringBuffer.append("\n - LSG_Class - ");
        stringBuffer.append(this.lsgClass);
        stringBuffer.append("\n - LSG_SubClass - ");
        stringBuffer.append(this.lsgSubclass);
        return stringBuffer.toString();
    }
}

