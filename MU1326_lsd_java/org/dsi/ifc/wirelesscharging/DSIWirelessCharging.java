/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.wirelesscharging;

import org.dsi.ifc.base.DSIBase;

public interface DSIWirelessCharging
extends DSIBase {
    public static final String VERSION = "2.11.1";
    public static final int ATTR_CHARGINGINFO = 1;
    public static final int ATTR_BATTERYLEVEL = 2;
    public static final int RT_SETWLCSTATE = 1000;
    public static final int CHARGINGINFO_OFF = 0;
    public static final int CHARGINGINFO_EMPTY = 1;
    public static final int CHARGINGINFO_NONWLC = 2;
    public static final int CHARGINGINFO_WLCFOD = 3;
    public static final int CHARGINGINFO_WLCHARGE = 4;
    public static final int CHARGINGINFO_WLCFULL = 5;
    public static final int CHARGERSTATE_OFF = 0;
    public static final int CHARGERSTATE_ON = 1;

    public void setWLCState(int var1);
}

