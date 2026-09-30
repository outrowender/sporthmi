/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.power;

public interface IPowerManager {
    public static final int HMI_ON = 0;
    public static final int HMI_ON_NO_DISPLAY = 1;
    public static final int HMI_STANDBY = 2;
    public static final int HMI_STANDBY_RESTRICTED = 3;
    public static final int HMI_ON_MUTE = 4;
    public static final String[] HMI_STATE_NAMES = new String[]{"HMI_ON", "HMI_ON_NO_DISPLAY", "HMI_STANDBY", "HMI_STANDBY_RESTRICTED", "HMI_ON_MUTE"};
    public static final int EPS_REARVIEW_ACTIVE = 140;
    public static final int EPS_REARVIEW_INACTIVE_ASG = 141;
    public static final int EPS_REARVIEW_INACTIVE_FSG = 142;
    public static final int EPS_STEERING_INTERVENTION_ACTIVE = 150;
    public static final int EPS_STEERING_INTERVENTION_INACTIVE = 151;
    public static final int EPS_CLIMATE_ACTIVE = 102;
    public static final int EPS_CLIMATE_INACTIVE = 103;
    public static final int EPS_CALL_ACTIVE = 104;
    public static final int EPS_CALL_INACTIVE = 105;
    public static final int EPS_Q21 = 106;
    public static final int EPS_Q4 = 107;
    public static final int EPS_Q0 = 108;
    public static final int EPS_ETC_PICKUP_REMAINDER_ACTIVE = 112;
    public static final int EPS_ETC_PICKUP_REMAINDER_INACTIVE = 113;
    public static final int EPS_SEAT_CONTROL_ACTIVE = 114;
    public static final int EPS_SEAT_CONTROL_INACTIVE = 115;
    public static final int EPS_TEL_USER_REMINDER_ACTIVE = 116;
    public static final int EPS_TEL_USER_REMINDER_INACTIVE = 117;
    public static final int EPS_INCOMING_CALL = 118;
    public static final int EPS_TEL_MAX_ACTIVE = 130;
    public static final int EPS_TEL_MAX_INACTIVE = 131;
    public static final int EPS_DRIVE_SELECT_ACTIVE = 132;
    public static final int EPS_DRIVE_SELECT_INACTIVE = 133;
    public static final int EPS_DRIVE_UGDO_ACTIVE = 132;
    public static final int EPS_DRIVE_UGDO_INACTIVE = 133;
    public static final int EPS_WIRELESS_CHARGING_ACTIVE = 160;
    public static final int EPS_WIRELESS_CHARGING_INACTIVE = 161;
    public static final int EPS_ONLINE_PANNENRUF_ACTIVE = 162;
    public static final int EPS_ONLINE_PANNENRUF_INACTIVE = 163;
    public static final int EPS_SOS_ACTIVE = 164;
    public static final int EPS_SOS_INACTIVE = 165;
    public static final int EPS_ONLINE_HINT_ACTIVE = 166;
    public static final int EPS_ONLINE_HINT_INACTIVE = 167;
    public static final int EPS_URGENT_TMC_ACTIVE = 200;
    public static final int EPS_URGENT_TMC_INACTIVE = 201;

    public void setPowerState(int var1, int var2);

    public void setExtendedPowerState(int var1, int var2);

    public void displayButtonTyped(int var1, int var2);

    public void hardKeyTyped(int var1, int var2);

    public void setHMIReady();

    public void releaseStandbyMute();

    public void comboKeyLastonMmiIocPressed();

    public void rebootSystemCritical(boolean var1);

    public void rebootSystem();

    public void keyPTTPressed();

    public void updateClampSignal(boolean var1, boolean var2);
}

