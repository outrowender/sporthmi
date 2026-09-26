/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;

public class ActiveSourceState {
    public static final int STATE_READY;
    public static final int STATE_LOADING;
    public static final int STATE_ON_SOURCE_CHANGE;
    public static final int STATE_ERROR_NO_MEDIA;
    public static final int STATE_ERROR_NOT_READABLE;
    public static final int STATE_ERROR_TEMPERATURE_TOO_HIGH;
    public static final int STATE_ERROR_TEMPERATURE_TOO_LOW;
    public static final int STATE_ERROR_NO_PLAYABLE_FILES;
    public static final int STATE_ERROR_WRONG_REGION_CODE_SOME_CHANGES_LEFT;
    public static final int STATE_ERROR_WRONG_REGION_CODE_NO_CHANGES_LEFT;
    public static final int STATE_ERROR_BLUETOOTH_DEACTIVATED;
    public static final int STATE_ERROR_BLUETOOTH_DEACTIVATED_CLAMP_S_OFF;
    public static final int STATE_ERROR_BLUETOOTH_RECONNECTING;
    public static final int STATE_ERROR_BLUETOOTH_AUDIOPLAYER_DEACTIVATED;
    public static final int STATE_ERROR_BLUETOOTH_AUDIOPLAYER_NOT_CONNECTED;
    public static final int STATE_ERROR_IMPORT_RUNNING;
    public static final int STATE_ERROR_DELETION_RUNNING;
    public static final int STATE_ERROR_CHILDLOCK_ERROR;
    public static final int STATE_ERROR_OVERCURRENT;
    public static final int STATE_ERROR_NOT_SUPPORTED;
    public static final int STATE_ERROR_NOT_SUPPORTED_WRONG_FIRMWARE;
    public static final int STATE_ERROR_WLAN_DEACTIVATED;
    public static final int STATE_ERROR_WLAN_DEACTIVATED_CLAMP_S_OFF;
    public static final int STATE_ERROR_JUKEBOX_IS_EMPTY;
    public static final int STATE_ERROR_DEVICE_NOT_AVAILABLE;
    public static final int STATE_ERROR_CORRUPTED_PARTITION;
    public static final int STATE_ERROR_CHARGING;
    public static final int STATE_ERROR_ONLINE_DEACTIVATED_CLAMP_S_OFF;
    public static final int STATE_ERROR_ONLINE_DEACTIVATED_WLAN_OFF;
    public static final int STATE_ERROR_ONLINE_DEACTIVATED_WLAN_NO_CONN;
    public static final int STATE_ERROR_ONLINE_NO_APP;
    public static final int STATE_ERROR_WLAN_NO_DEVICE;
    public static final int STATE_ERROR_WLAN_NO_APP;
    private static final HashMap STATESTRINGMAP;
    private final ISourceSlot slot;
    private final int state;

    public ActiveSourceState(ISourceSlot iSourceSlot, int n) {
        this.slot = iSourceSlot;
        this.state = n;
    }

    public ISourceSlot getSlot() {
        return this.slot;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ActiveSourceState)) {
            return false;
        }
        ActiveSourceState activeSourceState = (ActiveSourceState)object;
        if (activeSourceState.getState() != this.getState()) {
            return false;
        }
        if (!((Object)activeSourceState.getSlot()).equals(this.getSlot())) {
            return false;
        }
        if (activeSourceState.getSlot().getCapabilities() == null && this.getSlot().getCapabilities() != null) {
            return false;
        }
        return activeSourceState.getSlot().getCapabilities().equals(this.getSlot().getCapabilities());
    }

    static String getActiveSourceStateStr(int n) {
        Object object = STATESTRINGMAP.get(Integers.valueOf(n));
        if (object == null) {
            return new StringBuffer().append("UNKNOWN (").append(n).append(")").toString();
        }
        return (String)object;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("['").append(this.slot.getSource()).append("',");
        buffer.append("'").append(this.slot.getIndex()).append("','");
        buffer.append(ActiveSourceState.getActiveSourceStateStr(this.getState())).append("']");
        return buffer.toString();
    }

    static {
        STATESTRINGMAP = new HashMap(30);
        STATESTRINGMAP.put(Integers.valueOf(1), "STATE_READY");
        STATESTRINGMAP.put(Integers.valueOf(2), "STATE_LOADING");
        STATESTRINGMAP.put(Integers.valueOf(3), "STATE_ON_SOURCE_CHANGE");
        STATESTRINGMAP.put(Integers.valueOf(4), "STATE_ERROR_NO_MEDIA");
        STATESTRINGMAP.put(Integers.valueOf(5), "STATE_ERROR_NOT_READABLE");
        STATESTRINGMAP.put(Integers.valueOf(6), "STATE_ERROR_TEMPERATURE_TOO_HIGH");
        STATESTRINGMAP.put(Integers.valueOf(7), "STATE_ERROR_TEMPERATURE_TOO_LOW");
        STATESTRINGMAP.put(Integers.valueOf(8), "STATE_ERROR_NO_PLAYABLE_FILES");
        STATESTRINGMAP.put(Integers.valueOf(9), "STATE_ERROR_WRONG_REGION_CODE_SOME_CHANGES_LEFT");
        STATESTRINGMAP.put(Integers.valueOf(10), "STATE_ERROR_WRONG_REGION_CODE_NO_CHANGES_LEFT");
        STATESTRINGMAP.put(Integers.valueOf(11), "STATE_ERROR_BLUETOOTH_DEACTIVATED");
        STATESTRINGMAP.put(Integers.valueOf(12), "STATE_ERROR_BLUETOOTH_DEACTIVATED_CLAMP_S_OFF");
        STATESTRINGMAP.put(Integers.valueOf(13), "STATE_ERROR_BLUETOOTH_RECONNECTING");
        STATESTRINGMAP.put(Integers.valueOf(14), "STATE_ERROR_BLUETOOTH_AUDIOPLAYER_DEACTIVATED");
        STATESTRINGMAP.put(Integers.valueOf(15), "STATE_ERROR_BLUETOOTH_AUDIOPLAYER_NOT_CONNECTED");
        STATESTRINGMAP.put(Integers.valueOf(16), "STATE_ERROR_IMPORT_RUNNING");
        STATESTRINGMAP.put(Integers.valueOf(17), "STATE_ERROR_DELETION_RUNNING");
        STATESTRINGMAP.put(Integers.valueOf(18), "STATE_ERROR_CHILDLOCK_ERROR");
        STATESTRINGMAP.put(Integers.valueOf(19), "STATE_ERROR_OVERCURRENT");
        STATESTRINGMAP.put(Integers.valueOf(20), "STATE_ERROR_NOT_SUPPORTED");
        STATESTRINGMAP.put(Integers.valueOf(21), "STATE_ERROR_NOT_SUPPORTED_WRONG_FIRMWARE");
        STATESTRINGMAP.put(Integers.valueOf(22), "STATE_ERROR_WLAN_DEACTIVATED");
        STATESTRINGMAP.put(Integers.valueOf(23), "STATE_ERROR_WLAN_DEACTIVATED_CLAMP_S_OFF");
        STATESTRINGMAP.put(Integers.valueOf(24), "STATE_ERROR_JUKEBOX_IS_EMPTY");
        STATESTRINGMAP.put(Integers.valueOf(25), "STATE_ERROR_DEVICE_NOT_AVAILABLE");
        STATESTRINGMAP.put(Integers.valueOf(26), "STATE_ERROR_CORRUPTED_PARTITION");
        STATESTRINGMAP.put(Integers.valueOf(27), "STATE_ERROR_CHARGING");
        STATESTRINGMAP.put(Integers.valueOf(28), "STATE_ERROR_ONLINE_DEACTIVATED_CLAMP_S_OFF");
        STATESTRINGMAP.put(Integers.valueOf(29), "STATE_ERROR_ONLINE_DEACTIVATED_WLAN_OFF");
        STATESTRINGMAP.put(Integers.valueOf(30), "STATE_ERROR_ONLINE_DEACTIVATED_WLAN_NO_CONN");
        STATESTRINGMAP.put(Integers.valueOf(31), "STATE_ERROR_ONLINE_NO_APP");
        STATESTRINGMAP.put(Integers.valueOf(32), "STATE_ERROR_WLAN_NO_DEVICE");
    }
}

