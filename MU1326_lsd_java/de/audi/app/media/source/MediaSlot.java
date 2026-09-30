/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.esolutions.fw.util.commons.Buffer;

public class MediaSlot {
    private static final IntMap CONTENTTYPEMAP = new IntMap(20);
    private final int slotNumber;
    private final long dsiDeviceID;
    private final int deviceIndex;
    private final long dsiMediaID;
    private final int state;
    private final int mediaType;
    private final String mediaName;
    private final String mountPoint;
    private final MediaFlags mediaFlags;
    private final MediaCapabilities mediaCapabilities;
    private final int error;
    private final String uniqueMediaId;

    public MediaSlot(int n, int n2, int n3, long l, long l2, String string, String string2, MediaFlags mediaFlags, MediaCapabilities mediaCapabilities, int n4, int n5, String string3) {
        this.state = n;
        this.mediaType = n3;
        this.slotNumber = n2;
        this.dsiDeviceID = l;
        this.dsiMediaID = l2;
        this.mediaFlags = mediaFlags;
        this.mediaCapabilities = mediaCapabilities;
        this.mediaName = string;
        this.mountPoint = string2;
        this.error = n4;
        this.deviceIndex = n5;
        this.uniqueMediaId = string3;
    }

    public int getIndex() {
        return this.slotNumber;
    }

    public int getState() {
        return this.state;
    }

    public int getContentType() {
        return MediaSlot.resolveContentType(this.mediaType);
    }

    static int resolveContentType(int n) {
        try {
            return CONTENTTYPEMAP.get(n);
        }
        catch (NoMapElementException noMapElementException) {
            return -1;
        }
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getName() {
        return this.mediaName;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public MediaFlags getFlags() {
        return this.mediaFlags;
    }

    public MediaCapabilities getCapabilities() {
        return this.mediaCapabilities;
    }

    public long getDeviceID() {
        return this.dsiDeviceID;
    }

    public int getDeviceIndex() {
        return this.deviceIndex;
    }

    public long getMediaID() {
        return this.dsiMediaID;
    }

    public String getUniqueMediaId() {
        return this.uniqueMediaId;
    }

    public boolean isLoaded() {
        return this.state == 3;
    }

    public boolean isLoading() {
        return this.state == 1;
    }

    public boolean isReloading() {
        return this.state == 2;
    }

    public boolean isEmpty() {
        return this.state == 0;
    }

    public int getError() {
        return this.error;
    }

    private static String getStateStr(int n) {
        switch (n) {
            case 0: {
                return "EMPTY";
            }
            case 3: {
                return "LOADED";
            }
            case 1: {
                return "LOADING";
            }
            case 2: {
                return "RELOAD";
            }
        }
        return "UNKNOWN (" + n + ")";
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (int)(this.dsiDeviceID ^ this.dsiDeviceID >>> 32);
        n = 31 * n + (int)(this.dsiMediaID ^ this.dsiMediaID >>> 32);
        n = 31 * n + this.error;
        n = 31 * n + (this.mediaFlags == null ? 0 : this.mediaFlags.hashCode());
        n = 31 * n + (this.mediaName == null ? 0 : this.mediaName.hashCode());
        n = 31 * n + this.mediaType;
        n = 31 * n + (this.mountPoint == null ? 0 : this.mountPoint.hashCode());
        n = 31 * n + this.slotNumber;
        n = 31 * n + this.state;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        MediaSlot mediaSlot = (MediaSlot)object;
        if (this.state != mediaSlot.state) {
            return false;
        }
        if (this.error != mediaSlot.error) {
            return false;
        }
        if (this.mediaFlags == null ? mediaSlot.mediaFlags != null : !this.mediaFlags.equals(mediaSlot.mediaFlags)) {
            return false;
        }
        if (this.mediaCapabilities == null ? mediaSlot.mediaCapabilities != null : !this.mediaCapabilities.equals(mediaSlot.mediaCapabilities)) {
            return false;
        }
        if (this.dsiDeviceID != mediaSlot.dsiDeviceID) {
            return false;
        }
        if (this.dsiMediaID != mediaSlot.dsiMediaID) {
            return false;
        }
        if (this.mediaName == null ? mediaSlot.mediaName != null : !this.mediaName.equals(mediaSlot.mediaName)) {
            return false;
        }
        if (this.mediaType != mediaSlot.mediaType) {
            return false;
        }
        if (this.mountPoint == null ? mediaSlot.mountPoint != null : !this.mountPoint.equals(mediaSlot.mountPoint)) {
            return false;
        }
        if (this.slotNumber != mediaSlot.slotNumber) {
            return false;
        }
        return this.deviceIndex == mediaSlot.deviceIndex;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("'");
        buffer.append(this.getIndex());
        buffer.append("','").append(MediaSlot.getStateStr(this.getState())).append("',");
        buffer.append("'").append(LogUtil.getISourceSlotErrorStr(this.getError())).append("',");
        buffer.append("'");
        buffer.append(this.getDeviceID());
        buffer.append("','");
        buffer.append(this.getMediaID()).append("'");
        buffer.append(",").append(this.mediaFlags);
        buffer.append(",").append(this.mediaCapabilities);
        return buffer.toString();
    }

    static {
        CONTENTTYPEMAP.put(1, 0);
        CONTENTTYPEMAP.put(26, 2);
        CONTENTTYPEMAP.put(5, 2);
        CONTENTTYPEMAP.put(6, 2);
        CONTENTTYPEMAP.put(12, 1);
        CONTENTTYPEMAP.put(2, 1);
        CONTENTTYPEMAP.put(7, 1);
        CONTENTTYPEMAP.put(9, 1);
        CONTENTTYPEMAP.put(10, 1);
        CONTENTTYPEMAP.put(11, 1);
        CONTENTTYPEMAP.put(24, 1);
        CONTENTTYPEMAP.put(23, 1);
        CONTENTTYPEMAP.put(13, 1);
        CONTENTTYPEMAP.put(15, 6);
        CONTENTTYPEMAP.put(19, 5);
        CONTENTTYPEMAP.put(14, 5);
        CONTENTTYPEMAP.put(17, 4);
        CONTENTTYPEMAP.put(16, 3);
        CONTENTTYPEMAP.put(20, 7);
        CONTENTTYPEMAP.put(25, 8);
    }
}

