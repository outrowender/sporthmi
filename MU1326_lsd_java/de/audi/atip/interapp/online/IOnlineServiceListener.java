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
    public void getOnlineApplicationResponse(OSRApplication var1);

    public void activateLicenseResponse(int var1);

    public void getLicenseInformationResult(OSRLicense[] var1);

    public void getReminderStatusResult(int var1);

    public void setReminderStateResponse(int var1);

    public void updateApplicationState(OSRNotifyProperties[] var1);

    public void getPreCheckResult(OSRServiceState var1);

    public void updateServiceState(OnlineServiceListState var1);
}

