/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISource;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;

public interface ISourceSlot {
    public static final int STATE_EMPTY;
    public static final int STATE_LOADING;
    public static final int STATE_RELOAD;
    public static final int STATE_LOADED;
    public static final int ERR_NONE;
    public static final int ERR_WRONG_REGION_CODE_NO_CHANGES_LEFT;
    public static final int ERR_WRONG_REGION_CODE_CHANGES_LEFT;
    public static final int ERR_CHILDLOCK;
    public static final int ERR_IMPORT_RUNNING;
    public static final int ERR_NO_PLAYABLE_FILES;
    public static final int ERR_DELETION_RUNNING;
    public static final int ERR_OVERCURRENT;
    public static final int ERR_TEMPERATURE_TOO_HIGH;
    public static final int ERR_TEMPERATURE_TOO_LOW;
    public static final int ERR_BT_AUDIOPLAYER_DEACTIVATED;
    public static final int ERR_BT_AUDIOPLAYER_NOT_CONNECTED;
    public static final int ERR_BT_DEACTIVATED;
    public static final int ERR_BT_DEACTIVATED_CLAMP_S_OFF;
    public static final int ERR_BT_RECONNECTING;
    public static final int ERR_DEVICE_UNAVAILABLE;
    public static final int ERR_UNREADABLE;
    public static final int ERR_UNSUPPORTED;
    public static final int ERR_UNSUPPORTED_WRONG_FIRMWARE;
    public static final int ERR_EMPTY;
    public static final int ERR_WLAN_DEACTIVATED_CLAMP_S_OFF;
    public static final int ERR_WLAN_DEACTIVATED;
    public static final int ERR_JUKEBOX_NOT_FILLED;
    public static final int ERR_CORRUPTED_PARTITION;
    public static final int ERR_CHARGING;
    public static final int ERR_ONLINE_DEACTIVATED_CLAMP_S_OFF;
    public static final int ERR_ONLINE_DEACTIVATED_WLAN_OFF;
    public static final int ERR_ONLINE_DEACTIVATED_WLAN_NO_CONN;
    public static final int ERR_ONLINE_NO_APP;
    public static final int ERR_WLAN_NO_DEVICE;
    public static final int ERR_WLAN_NO_APP;
    public static final int INVALID_DEVICE_INDEX;
    public static final int INVALID_SLOT_INDEX;
    public static final String NO_UNIQUE_MEDIA_ID;

    default public ISource getSource() {
    }

    default public int getIndex() {
    }

    default public int getDeviceIndex() {
    }

    default public int getContentType() {
    }

    default public int getMediaType() {
    }

    default public int getState() {
    }

    default public String getName() {
    }

    default public String getMountPoint() {
    }

    default public String getActiveSourceListIcon() {
    }

    default public String getActiveSourceListReflectionIcon() {
    }

    default public String getActiveSourceListClosedIcon() {
    }

    default public String getCaptionIcon() {
    }

    default public String getLoadingIcon() {
    }

    default public boolean isLoading() {
    }

    default public boolean isReloading() {
    }

    default public boolean isLoaded() {
    }

    default public boolean isEmpty() {
    }

    default public MediaFlags getFlags() {
    }

    default public int getError() {
    }

    default public boolean equals(Object object) {
    }

    default public MediaCapabilities getCapabilities() {
    }

    default public String getUniqueMediaId() {
    }
}

