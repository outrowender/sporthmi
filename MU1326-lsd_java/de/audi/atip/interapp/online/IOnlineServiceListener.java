/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.audi.atip.interapp.online.OnlineServiceListState;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;

public interface IOnlineServiceListener {
    default public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
    }

    default public void activateLicenseResponse(int n) {
    }

    default public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
    }

    default public void getReminderStatusResult(int n) {
    }

    default public void setReminderStateResponse(int n) {
    }

    default public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
    }

    default public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }

    default public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }
}

