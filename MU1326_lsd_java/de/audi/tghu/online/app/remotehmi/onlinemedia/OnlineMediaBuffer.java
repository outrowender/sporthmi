/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

public class OnlineMediaBuffer {
    int fillLevel;
    String state;

    public int getFillLevel() {
        return this.fillLevel;
    }

    public void setFillLevel(int n) {
        this.fillLevel = n;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String string) {
        this.state = string;
    }
}

