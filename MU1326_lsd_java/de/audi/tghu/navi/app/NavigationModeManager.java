/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

public class NavigationModeManager {
    public static final int NAVIGATIONMODE_ROUTECALC = 0;
    public static final int NAVIGATIONMODE_FOLLOW = 1;
    private volatile int navigationMode;

    public int getNavigationMode() {
        return this.navigationMode;
    }

    public void setNavigationMode(int n) {
        this.navigationMode = n;
    }
}

