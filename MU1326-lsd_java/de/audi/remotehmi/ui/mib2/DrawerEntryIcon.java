/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

public class DrawerEntryIcon {
    private String localPath;
    private String url;
    private String checksum;

    public void setPath(String string) {
        this.localPath = string;
    }

    public String getPath() {
        return this.localPath;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setChecksum(String string) {
        this.checksum = string;
    }

    public String getChecksum() {
        return this.checksum;
    }
}

