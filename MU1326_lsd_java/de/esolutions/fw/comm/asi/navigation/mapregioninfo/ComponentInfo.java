/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo;

public class ComponentInfo {
    public String componentName;
    public byte[] versionInfo;

    public String getComponentName() {
        return this.componentName;
    }

    public void setComponentName(String string) {
        this.componentName = string;
    }

    public byte[] getVersionInfo() {
        return this.versionInfo;
    }

    public void setVersionInfo(byte[] byArray) {
        this.versionInfo = byArray;
    }

    public ComponentInfo() {
    }

    public ComponentInfo(String string, byte[] byArray) {
        this.componentName = string;
        this.versionInfo = byArray;
    }

    public String toString() {
        return "ComponentInfo{" + "componentName=" + this.componentName + ", versionInfo=" + "[" + (this.versionInfo == null ? "null" : "size=" + this.versionInfo.length) + "]" + "}";
    }
}

