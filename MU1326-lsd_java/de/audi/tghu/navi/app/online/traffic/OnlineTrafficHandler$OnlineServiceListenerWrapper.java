/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online.traffic;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;

class OnlineTrafficHandler$OnlineServiceListenerWrapper
implements IOnlineServiceListener {
    private OnlineTrafficHandler handler;
    boolean jumpToInclude = false;
    private final /* synthetic */ OnlineTrafficHandler this$0;

    public OnlineTrafficHandler$OnlineServiceListenerWrapper(OnlineTrafficHandler onlineTrafficHandler, OnlineTrafficHandler onlineTrafficHandler2, boolean bl) {
        this.this$0 = onlineTrafficHandler;
        this.handler = onlineTrafficHandler2;
        this.jumpToInclude = bl;
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.handler.getOnlineApplicationResponse(oSRApplication, this.jumpToInclude);
    }

    @Override
    public void activateLicenseResponse(int n) {
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
    }

    @Override
    public void getReminderStatusResult(int n) {
    }

    @Override
    public void setReminderStateResponse(int n) {
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }
}

