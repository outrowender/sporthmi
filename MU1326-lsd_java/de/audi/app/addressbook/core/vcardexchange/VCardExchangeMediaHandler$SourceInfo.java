/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange;

class VCardExchangeMediaHandler$SourceInfo {
    private int sourceState;
    private String mountPoint;

    public VCardExchangeMediaHandler$SourceInfo(int n, String string) {
        this.sourceState = n;
        this.mountPoint = string;
    }

    public int getSourceState() {
        return this.sourceState;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }
}

