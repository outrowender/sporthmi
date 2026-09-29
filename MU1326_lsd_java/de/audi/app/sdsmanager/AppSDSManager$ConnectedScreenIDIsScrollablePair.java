/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.AppSDSManager$1;

class AppSDSManager$ConnectedScreenIDIsScrollablePair {
    private int screenID = -1;
    private boolean isScrollable = false;
    private final /* synthetic */ AppSDSManager this$0;

    private AppSDSManager$ConnectedScreenIDIsScrollablePair(AppSDSManager appSDSManager) {
        this.this$0 = appSDSManager;
    }

    private void setPairValues(int n, boolean bl) {
        this.screenID = n;
        this.isScrollable = bl;
    }

    private boolean isScreenScrollable(int n) {
        if (n == -1 || this.screenID != n) {
            AppSDSManager.access$200(this.this$0).log(-1601830656, "AppSDSManager.ConnectedScreenIDIsScrollablePair#isScreenScrollable: given screenID != saved screenID => return false!");
            return false;
        }
        return this.isScrollable;
    }

    /* synthetic */ AppSDSManager$ConnectedScreenIDIsScrollablePair(AppSDSManager appSDSManager, AppSDSManager$1 appSDSManager$1) {
        this(appSDSManager);
    }

    static /* synthetic */ boolean access$300(AppSDSManager$ConnectedScreenIDIsScrollablePair appSDSManager$ConnectedScreenIDIsScrollablePair, int n) {
        return appSDSManager$ConnectedScreenIDIsScrollablePair.isScreenScrollable(n);
    }

    static /* synthetic */ void access$400(AppSDSManager$ConnectedScreenIDIsScrollablePair appSDSManager$ConnectedScreenIDIsScrollablePair, int n, boolean bl) {
        appSDSManager$ConnectedScreenIDIsScrollablePair.setPairValues(n, bl);
    }
}

