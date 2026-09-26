/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.AppSDSManager$1;
import de.audi.atip.interapp.SDSService$ScreenConnectedSDSData;

class AppSDSManager$ConnectedScreenIDWithSDSDataPair {
    private int screenID = -1;
    private SDSService$ScreenConnectedSDSData data = null;
    private final /* synthetic */ AppSDSManager this$0;

    private AppSDSManager$ConnectedScreenIDWithSDSDataPair(AppSDSManager appSDSManager) {
        this.this$0 = appSDSManager;
    }

    private void setPairValues(int n, SDSService$ScreenConnectedSDSData sDSService$ScreenConnectedSDSData) {
        this.screenID = n;
        this.data = sDSService$ScreenConnectedSDSData;
    }

    private SDSService$ScreenConnectedSDSData getSDSData(int n) {
        if (n == -1 || this.screenID != n) {
            AppSDSManager.access$200(this.this$0).log(-1601830656, "AppSDSManager.ConnectedScreenIDWithSDSDataPair#getSDSData: given screenID %1 != %2 saved screenID => return null!", (long)n, (long)this.screenID);
            return null;
        }
        return this.data;
    }

    /* synthetic */ AppSDSManager$ConnectedScreenIDWithSDSDataPair(AppSDSManager appSDSManager, AppSDSManager$1 appSDSManager$1) {
        this(appSDSManager);
    }

    static /* synthetic */ SDSService$ScreenConnectedSDSData access$500(AppSDSManager$ConnectedScreenIDWithSDSDataPair appSDSManager$ConnectedScreenIDWithSDSDataPair, int n) {
        return appSDSManager$ConnectedScreenIDWithSDSDataPair.getSDSData(n);
    }

    static /* synthetic */ void access$600(AppSDSManager$ConnectedScreenIDWithSDSDataPair appSDSManager$ConnectedScreenIDWithSDSDataPair, int n, SDSService$ScreenConnectedSDSData sDSService$ScreenConnectedSDSData) {
        appSDSManager$ConnectedScreenIDWithSDSDataPair.setPairValues(n, sDSService$ScreenConnectedSDSData);
    }
}

