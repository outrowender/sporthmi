/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRApplicationProperties;

public class OnlineServiceRegistrationHelper {
    public static int getReminderStatus(OSRApplication oSRApplication) {
        return OnlineServiceRegistrationHelper.getReminderStatus(oSRApplication, null);
    }

    public static int getReminderStatus(OSRApplication oSRApplication, LogChannel logChannel) {
        String string = OnlineServiceRegistrationHelper.getValue("ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE", oSRApplication);
        return OnlineServiceRegistrationHelper.getReminderStatus(string, logChannel);
    }

    public static int getReminderStatus(OSRApplicationProperties[] oSRApplicationPropertiesArray, LogChannel logChannel) {
        String string = OnlineServiceRegistrationHelper.getValue("ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE", oSRApplicationPropertiesArray);
        return OnlineServiceRegistrationHelper.getReminderStatus(string, logChannel);
    }

    private static int getReminderStatus(String string, LogChannel logChannel) {
        if (string != null && string.length() > 0) {
            if (string.equals("ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_ON")) {
                return 1;
            }
            return 0;
        }
        if (logChannel != null) {
            logChannel.log(100000, "[OnlineServiceRegistrationHelper#getReminderStatus] no reminder status set > OnlineCoreService south problem");
        }
        return 0;
    }

    public static OSRApplicationProperties createReminderProperty(int n) {
        String string = "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_OFF";
        switch (n) {
            case 1: {
                string = "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_ON";
                break;
            }
        }
        return new OSRApplicationProperties(0, "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE", string);
    }

    public static OSRApplicationProperties[] changeReminderProperty(OSRApplicationProperties[] oSRApplicationPropertiesArray, int n) {
        OSRApplicationProperties[] oSRApplicationPropertiesArray2;
        String string = "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_OFF";
        switch (n) {
            case 1: {
                string = "ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_ON";
                break;
            }
        }
        boolean bl = false;
        for (int i2 = 0; i2 < oSRApplicationPropertiesArray.length && !bl; ++i2) {
            oSRApplicationPropertiesArray2 = oSRApplicationPropertiesArray[i2];
            if (oSRApplicationPropertiesArray2.getGroup() != 0 || !oSRApplicationPropertiesArray2.getKey().equals("ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE")) continue;
            oSRApplicationPropertiesArray2.value = string;
            bl = true;
        }
        if (!bl) {
            OSRApplicationProperties oSRApplicationProperties = OnlineServiceRegistrationHelper.createReminderProperty(n);
            oSRApplicationPropertiesArray2 = new OSRApplicationProperties[oSRApplicationPropertiesArray.length + 1];
            System.arraycopy((Object)oSRApplicationPropertiesArray, 0, (Object)oSRApplicationPropertiesArray2, 0, oSRApplicationPropertiesArray.length);
            oSRApplicationPropertiesArray2[oSRApplicationPropertiesArray2.length - 1] = oSRApplicationProperties;
            oSRApplicationPropertiesArray = oSRApplicationPropertiesArray2;
        }
        return oSRApplicationPropertiesArray;
    }

    public static boolean isKeyAvailable(String string, OSRApplication oSRApplication) {
        String string2 = OnlineServiceRegistrationHelper.getValue(string, oSRApplication);
        return string2 != null && string2.length() > 0;
    }

    public static String getValue(String string, OSRApplication oSRApplication) {
        String string2 = "";
        if (oSRApplication != null) {
            OSRApplicationProperties[] oSRApplicationPropertiesArray = oSRApplication.getPropertyList();
            string2 = OnlineServiceRegistrationHelper.getValue(string, oSRApplicationPropertiesArray);
        }
        return string2;
    }

    public static String getValue(String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        String string2 = "";
        if (oSRApplicationPropertiesArray != null) {
            for (int i2 = 0; i2 < oSRApplicationPropertiesArray.length; ++i2) {
                if (!oSRApplicationPropertiesArray[i2].getKey().equals(string)) continue;
                return oSRApplicationPropertiesArray[i2].getValue();
            }
        }
        return string2;
    }
}

