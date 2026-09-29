/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class MascotConfiguration {
    public boolean manualMode;
    public boolean onIgnitionMode;
    public boolean onLockMode;

    public MascotConfiguration() {
        this.manualMode = false;
        this.onIgnitionMode = false;
        this.onLockMode = false;
    }

    public MascotConfiguration(boolean bl, boolean bl2, boolean bl3) {
        this.manualMode = bl;
        this.onIgnitionMode = bl2;
        this.onLockMode = bl3;
    }

    public boolean isManualMode() {
        return this.manualMode;
    }

    public boolean isOnIgnitionMode() {
        return this.onIgnitionMode;
    }

    public boolean isOnLockMode() {
        return this.onLockMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("MascotConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("manualMode");
        stringBuffer.append('=');
        stringBuffer.append(this.manualMode);
        stringBuffer.append(',');
        stringBuffer.append("onIgnitionMode");
        stringBuffer.append('=');
        stringBuffer.append(this.onIgnitionMode);
        stringBuffer.append(',');
        stringBuffer.append("onLockMode");
        stringBuffer.append('=');
        stringBuffer.append(this.onLockMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

