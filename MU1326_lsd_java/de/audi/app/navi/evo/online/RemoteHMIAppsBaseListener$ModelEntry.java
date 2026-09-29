/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

public class RemoteHMIAppsBaseListener$ModelEntry {
    private final int labelModel;
    private final int nonLabelModel;
    private String applicationContext;

    public RemoteHMIAppsBaseListener$ModelEntry(int n, int n2) {
        this.labelModel = n;
        this.nonLabelModel = n2;
        this.applicationContext = "";
    }

    public String getApplicationContext() {
        return this.applicationContext;
    }

    public void setApplicationContext(String string) {
        this.applicationContext = string;
    }

    public int getLabelModel() {
        return this.labelModel;
    }

    public int getNonLabelModel() {
        return this.nonLabelModel;
    }
}

