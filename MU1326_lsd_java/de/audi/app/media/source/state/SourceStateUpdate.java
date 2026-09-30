/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.esolutions.fw.util.commons.Buffer;

public class SourceStateUpdate {
    public static final int UPDATE_TYPE_SLOTS_LIST = 1;
    public static final int UPDATE_TYPE_AVAILABILITY = 2;
    public static final int UPDATE_TYPE_POWER_CLAMP_S = 3;
    public static final int UPDATE_TYPE_WLAN_STATE = 4;
    public static final int UPDATE_TYPE_BT_STATE = 5;
    public static final int UPDATE_TYPE_BT_ACTION_FINISHED = 6;
    public static final int UPDATE_TYPE_BT_ACTION_STARTED = 7;
    public static final int UPDATE_TYPE_ONLINE_SERVICES = 8;
    public static final int UPDATE_TYPE_ONLINE_INTERAPP_SERVICE = 9;
    public static final int UPDATE_TYPE_TV_SERVICE = 10;
    public static final int UPDATE_TYPE_ONLINE_LASTMODE = 11;
    public static final int UPDATE_TYPE_TV_AVAILABILITY = 12;
    public static final int UPDATE_TYPE_ONLINE_DEVICE_APP_STARTED = 13;
    public static final int UPDATE_TYPE_WLAN_DEVICE_CONNECTED = 14;
    public static final int UPDATE_TYPE_NUMBER_OF_MEDIA_SLOTS = 15;
    public static final int UPDATE_TYPE_SDIS_CONNECTED = 16;
    private final int type;
    private final Object update;

    public SourceStateUpdate(int n, Object object) {
        this.type = n;
        this.update = object;
    }

    public Object getUpdate() {
        return this.update;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("").append(SourceStateUpdate.typeToString(this.type)).append(" ('").append(this.update).append("')");
        return buffer.toString();
    }

    private static String typeToString(int n) {
        switch (n) {
            case 1: {
                return "UPDATE_TYPE_SLOTS_LIST";
            }
            case 5: {
                return "UPDATE_TYPE_BT_STATE";
            }
            case 3: {
                return "UPDATE_TYPE_POWER_CLAMP_S";
            }
            case 4: {
                return "UPDATE_TYPE_WLAN_STATE";
            }
            case 2: {
                return "UPDATE_TYPE_AVAILABILITY";
            }
            case 6: {
                return "UPDATE_TYPE_BT_ACTION_FINISHED";
            }
            case 7: {
                return "UPDATE_TYPE_BT_ACTION_FINISHED";
            }
            case 8: {
                return "UPDATE_TYPE_ONLINE_SERVICES";
            }
            case 9: {
                return "UPDATE_TYPE_ONLINE_INTERAPP_SERVICE";
            }
            case 10: {
                return "UPDATE_TYPE_TV_SERVICE";
            }
            case 11: {
                return "UPDATE_TYPE_ONLINE_LASTMODE";
            }
            case 13: {
                return "UPDATE_TYPE_ONLINE_DEVICE_APP_STARTED";
            }
            case 14: {
                return "UPDATE_TYPE_ONLINE_DEVICE_CONNECTED";
            }
            case 16: {
                return "UPDATE_TYPE_SDIS_CONNECTED";
            }
        }
        return "UNKNOWN (" + n + ")";
    }
}

