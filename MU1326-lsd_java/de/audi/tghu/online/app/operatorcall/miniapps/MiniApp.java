/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

public class MiniApp {
    private int optionModelId;
    private String name = null;
    private String appContext = null;
    private int[] targetTiledListModelIds;

    public MiniApp(int n, int[] nArray) {
        this.optionModelId = n;
        this.targetTiledListModelIds = nArray;
    }

    public int[] getTargetTiledListModelIDs() {
        return this.targetTiledListModelIds;
    }

    public int getOptionModelID() {
        return this.optionModelId;
    }

    public void setData(String string, String string2) {
        this.name = string;
        this.appContext = string2;
    }

    public String getName() {
        return this.name;
    }

    public String getAppContext() {
        return this.appContext;
    }
}

