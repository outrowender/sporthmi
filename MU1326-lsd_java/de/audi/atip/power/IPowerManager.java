/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.power;

public interface IPowerManager {
    public static final int HMI_ON;
    public static final int HMI_ON_NO_DISPLAY;
    public static final int HMI_STANDBY;
    public static final int HMI_STANDBY_RESTRICTED;
    public static final int HMI_ON_MUTE;
    public static final String[] HMI_STATE_NAMES;
    public static final int EPS_REARVIEW_ACTIVE;
    public static final int EPS_REARVIEW_INACTIVE_ASG;
    public static final int EPS_REARVIEW_INACTIVE_FSG;
    public static final int EPS_STEERING_INTERVENTION_ACTIVE;
    public static final int EPS_STEERING_INTERVENTION_INACTIVE;
    public static final int EPS_CLIMATE_ACTIVE;
    public static final int EPS_CLIMATE_INACTIVE;
    public static final int EPS_CALL_ACTIVE;
    public static final int EPS_CALL_INACTIVE;
    public static final int EPS_Q21;
    public static final int EPS_Q4;
    public static final int EPS_Q0;
    public static final int EPS_ETC_PICKUP_REMAINDER_ACTIVE;
    public static final int EPS_ETC_PICKUP_REMAINDER_INACTIVE;
    public static final int EPS_SEAT_CONTROL_ACTIVE;
    public static final int EPS_SEAT_CONTROL_INACTIVE;
    public static final int EPS_TEL_USER_REMINDER_ACTIVE;
    public static final int EPS_TEL_USER_REMINDER_INACTIVE;
    public static final int EPS_INCOMING_CALL;
    public static final int EPS_TEL_MAX_ACTIVE;
    public static final int EPS_TEL_MAX_INACTIVE;
    public static final int EPS_DRIVE_SELECT_ACTIVE;
    public static final int EPS_DRIVE_SELECT_INACTIVE;
    public static final int EPS_DRIVE_UGDO_ACTIVE;
    public static final int EPS_DRIVE_UGDO_INACTIVE;
    public static final int EPS_WIRELESS_CHARGING_ACTIVE;
    public static final int EPS_WIRELESS_CHARGING_INACTIVE;
    public static final int EPS_ONLINE_PANNENRUF_ACTIVE;
    public static final int EPS_ONLINE_PANNENRUF_INACTIVE;
    public static final int EPS_SOS_ACTIVE;
    public static final int EPS_SOS_INACTIVE;
    public static final int EPS_ONLINE_HINT_ACTIVE;
    public static final int EPS_ONLINE_HINT_INACTIVE;
    public static final int EPS_URGENT_TMC_ACTIVE;
    public static final int EPS_URGENT_TMC_INACTIVE;

    default public void setPowerState(int n, int n2) {
    }

    default public void setExtendedPowerState(int n, int n2) {
    }

    default public void displayButtonTyped(int n, int n2) {
    }

    default public void hardKeyTyped(int n, int n2) {
    }

    default public void setHMIReady() {
    }

    default public void releaseStandbyMute() {
    }

    default public void comboKeyLastonMmiIocPressed() {
    }

    default public void rebootSystemCritical(boolean bl) {
    }

    default public void rebootSystem() {
    }

    default public void keyPTTPressed() {
    }

    default public void updateClampSignal(boolean bl, boolean bl2) {
    }

    static {
        HMI_STATE_NAMES = new String[]{"HMI_ON", "HMI_ON_NO_DISPLAY", "HMI_STANDBY", "HMI_STANDBY_RESTRICTED", "HMI_ON_MUTE"};
    }
}

