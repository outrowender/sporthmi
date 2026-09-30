/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import org.dsi.ifc.online.OSRServiceState;

public interface IOnlineService {
    public static final String OSGI_ONLINE_SERVICE_IDENTIFIER = "ONLINE_APP_ID";
    public static final int LICENSE_EXPIRES_REMINDER_OFF = 0;
    public static final int LICENSE_EXPIRES_REMINDER_ON = 1;
    public static final String SERVICE_ID_PICNAV = "service_picnav";

    public void setOnlineApplicationState(int var1, IOnlineServiceListener var2);

    public void getLicenseInformation(IOnlineServiceListener var1);

    public void getReminderStatus(IOnlineServiceListener var1);

    public void activateLicense(IOnlineServiceListener var1);

    public void setReminderState(int var1, IOnlineServiceListener var2);

    public boolean addCallBackListener(IOnlineServiceListener var1);

    public boolean removeCallBackListener(IOnlineServiceListener var1);

    public void getOnlineApplicationPreCheck(IOnlineServiceListener var1, String var2);

    public void getOnlineApplicationPreCheckResult(String var1, OSRServiceState var2, IOnlineServiceListener var3);

    public void updateServiceState(OnlineServiceListState var1);

    public static interface ORSPropertiesConstants {
        public static final String LICENSE_EXPIRES_REMINDER_STATE = "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE";
        public static final String LICENSE_EXPIRES_REMINDER_ON = "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_ON";
        public static final String LICENSE_EXPIRES_REMINDER_OFF = "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_OFF";
    }
}

