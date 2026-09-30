/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSlot;
import de.esolutions.fw.util.commons.Buffer;

public class MediaSourceSlot
implements ISourceSlot {
    private final ISource source;
    private final MediaSlot mediaSlot;

    public MediaSourceSlot(ISource iSource, int n, int n2, int n3, long l, long l2, String string, String string2, MediaFlags mediaFlags, MediaCapabilities mediaCapabilities, int n4, int n5, String string3) {
        this.source = iSource;
        this.mediaSlot = new MediaSlot(n, n2, n3, l, l2, string, string2, mediaFlags, mediaCapabilities, n4, n5, string3);
    }

    public MediaSourceSlot(ISource iSource, MediaSlot mediaSlot) {
        this.source = iSource;
        this.mediaSlot = mediaSlot;
    }

    public ISource getSource() {
        return this.source;
    }

    public int getIndex() {
        return this.mediaSlot.getIndex();
    }

    public int getState() {
        return this.mediaSlot.getState();
    }

    public int getContentType() {
        return this.mediaSlot.getContentType();
    }

    public int getMediaType() {
        return this.mediaSlot.getMediaType();
    }

    public String getName() {
        return this.mediaSlot.getName();
    }

    public String getMountPoint() {
        return this.mediaSlot.getMountPoint();
    }

    public MediaFlags getFlags() {
        return this.mediaSlot.getFlags();
    }

    public long getDeviceID() {
        return this.mediaSlot.getDeviceID();
    }

    public long getMediaID() {
        return this.mediaSlot.getMediaID();
    }

    public String getUniqueMediaId() {
        return this.mediaSlot.getUniqueMediaId();
    }

    public boolean isLoaded() {
        return this.mediaSlot.getState() == 3;
    }

    public boolean isLoading() {
        return this.mediaSlot.getState() == 1;
    }

    public boolean isReloading() {
        return this.mediaSlot.getState() == 2;
    }

    public boolean isEmpty() {
        return this.mediaSlot.getState() == 0;
    }

    public int getError() {
        return this.mediaSlot.getError();
    }

    public int getDeviceIndex() {
        return this.mediaSlot.getDeviceIndex();
    }

    public MediaCapabilities getCapabilities() {
        return this.mediaSlot.getCapabilities();
    }

    public String getActiveSourceListIcon() {
        return null;
    }

    public String getActiveSourceListReflectionIcon() {
        return null;
    }

    public String getActiveSourceListClosedIcon() {
        return null;
    }

    public String getCaptionIcon() {
        return null;
    }

    public String getLoadingIcon() {
        return null;
    }

    public int hashCode() {
        return this.getSource().getType() * 100 + this.getIndex();
    }

    public boolean equals(Object object) {
        if (!(object instanceof MediaSourceSlot)) {
            return false;
        }
        MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)object;
        return mediaSourceSlot.getSource().equals(this.getSource()) && mediaSourceSlot.getIndex() == this.getIndex();
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[");
        buffer.append(this.getSource());
        buffer.append(",");
        buffer.append(this.mediaSlot);
        buffer.append("]");
        return buffer.toString();
    }
}

