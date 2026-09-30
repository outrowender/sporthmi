/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.presets;

import java.io.Serializable;

public class OnlinePresetData
implements Serializable {
    private static final long serialVersionUID = 1588742536925811378L;
    private String appName;
    private String contextName;
    private int type;

    public OnlinePresetData(String string, String string2, int n) {
        this.appName = string;
        this.contextName = string2;
        this.type = n;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getType() {
        return this.type;
    }

    public String getContextName() {
        return this.contextName;
    }
}

