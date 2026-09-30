/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISource;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;

public interface ISourceSlot {
    public static final int STATE_EMPTY = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_RELOAD = 2;
    public static final int STATE_LOADED = 3;
    public static final int ERR_NONE = 0;
    public static final int ERR_WRONG_REGION_CODE_NO_CHANGES_LEFT = 1;
    public static final int ERR_WRONG_REGION_CODE_CHANGES_LEFT = 2;
    public static final int ERR_CHILDLOCK = 3;
    public static final int ERR_IMPORT_RUNNING = 4;
    public static final int ERR_NO_PLAYABLE_FILES = 5;
    public static final int ERR_DELETION_RUNNING = 6;
    public static final int ERR_OVERCURRENT = 7;
    public static final int ERR_TEMPERATURE_TOO_HIGH = 8;
    public static final int ERR_TEMPERATURE_TOO_LOW = 9;
    public static final int ERR_BT_AUDIOPLAYER_DEACTIVATED = 10;
    public static final int ERR_BT_AUDIOPLAYER_NOT_CONNECTED = 11;
    public static final int ERR_BT_DEACTIVATED = 12;
    public static final int ERR_BT_DEACTIVATED_CLAMP_S_OFF = 13;
    public static final int ERR_BT_RECONNECTING = 14;
    public static final int ERR_DEVICE_UNAVAILABLE = 15;
    public static final int ERR_UNREADABLE = 16;
    public static final int ERR_UNSUPPORTED = 17;
    public static final int ERR_UNSUPPORTED_WRONG_FIRMWARE = 18;
    public static final int ERR_EMPTY = 19;
    public static final int ERR_WLAN_DEACTIVATED_CLAMP_S_OFF = 20;
    public static final int ERR_WLAN_DEACTIVATED = 21;
    public static final int ERR_JUKEBOX_NOT_FILLED = 22;
    public static final int ERR_CORRUPTED_PARTITION = 23;
    public static final int ERR_CHARGING = 24;
    public static final int ERR_ONLINE_DEACTIVATED_CLAMP_S_OFF = 25;
    public static final int ERR_ONLINE_DEACTIVATED_WLAN_OFF = 26;
    public static final int ERR_ONLINE_DEACTIVATED_WLAN_NO_CONN = 27;
    public static final int ERR_ONLINE_NO_APP = 28;
    public static final int ERR_WLAN_NO_DEVICE = 29;
    public static final int ERR_WLAN_NO_APP = 30;
    public static final int INVALID_DEVICE_INDEX = -1;
    public static final int INVALID_SLOT_INDEX = -1;
    public static final String NO_UNIQUE_MEDIA_ID = "";

    public ISource getSource();

    public int getIndex();

    public int getDeviceIndex();

    public int getContentType();

    public int getMediaType();

    public int getState();

    public String getName();

    public String getMountPoint();

    public String getActiveSourceListIcon();

    public String getActiveSourceListReflectionIcon();

    public String getActiveSourceListClosedIcon();

    public String getCaptionIcon();

    public String getLoadingIcon();

    public boolean isLoading();

    public boolean isReloading();

    public boolean isLoaded();

    public boolean isEmpty();

    public MediaFlags getFlags();

    public int getError();

    public boolean equals(Object var1);

    public MediaCapabilities getCapabilities();

    public String getUniqueMediaId();
}

