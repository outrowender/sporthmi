/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import org.dsi.ifc.online.OSRServiceState;

public interface IOnlineService {
    public static final String OSGI_ONLINE_SERVICE_IDENTIFIER;
    public static final int LICENSE_EXPIRES_REMINDER_OFF;
    public static final int LICENSE_EXPIRES_REMINDER_ON;
    public static final String SERVICE_ID_PICNAV;

    default public void setOnlineApplicationState(int n, IOnlineServiceListener iOnlineServiceListener) {
    }

    default public void getLicenseInformation(IOnlineServiceListener iOnlineServiceListener) {
    }

    default public void getReminderStatus(IOnlineServiceListener iOnlineServiceListener) {
    }

    default public void activateLicense(IOnlineServiceListener iOnlineServiceListener) {
    }

    default public void setReminderState(int n, IOnlineServiceListener iOnlineServiceListener) {
    }

    default public boolean addCallBackListener(IOnlineServiceListener iOnlineServiceListener) {
    }

    default public boolean removeCallBackListener(IOnlineServiceListener iOnlineServiceListener) {
    }

    default public void getOnlineApplicationPreCheck(IOnlineServiceListener iOnlineServiceListener, String string) {
    }

    default public void getOnlineApplicationPreCheckResult(String string, OSRServiceState oSRServiceState, IOnlineServiceListener iOnlineServiceListener) {
    }

    default public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }
}

