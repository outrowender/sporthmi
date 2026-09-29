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

    @Override
    public ISource getSource() {
        return this.source;
    }

    @Override
    public int getIndex() {
        return this.mediaSlot.getIndex();
    }

    @Override
    public int getState() {
        return this.mediaSlot.getState();
    }

    @Override
    public int getContentType() {
        return this.mediaSlot.getContentType();
    }

    @Override
    public int getMediaType() {
        return this.mediaSlot.getMediaType();
    }

    @Override
    public String getName() {
        return this.mediaSlot.getName();
    }

    @Override
    public String getMountPoint() {
        return this.mediaSlot.getMountPoint();
    }

    @Override
    public MediaFlags getFlags() {
        return this.mediaSlot.getFlags();
    }

    public long getDeviceID() {
        return this.mediaSlot.getDeviceID();
    }

    public long getMediaID() {
        return this.mediaSlot.getMediaID();
    }

    @Override
    public String getUniqueMediaId() {
        return this.mediaSlot.getUniqueMediaId();
    }

    @Override
    public boolean isLoaded() {
        return this.mediaSlot.getState() == 3;
    }

    @Override
    public boolean isLoading() {
        return this.mediaSlot.getState() == 1;
    }

    @Override
    public boolean isReloading() {
        return this.mediaSlot.getState() == 2;
    }

    @Override
    public boolean isEmpty() {
        return this.mediaSlot.getState() == 0;
    }

    @Override
    public int getError() {
        return this.mediaSlot.getError();
    }

    @Override
    public int getDeviceIndex() {
        return this.mediaSlot.getDeviceIndex();
    }

    @Override
    public MediaCapabilities getCapabilities() {
        return this.mediaSlot.getCapabilities();
    }

    @Override
    public String getActiveSourceListIcon() {
        return null;
    }

    @Override
    public String getActiveSourceListReflectionIcon() {
        return null;
    }

    @Override
    public String getActiveSourceListClosedIcon() {
        return null;
    }

    @Override
    public String getCaptionIcon() {
        return null;
    }

    @Override
    public String getLoadingIcon() {
        return null;
    }

    public int hashCode() {
        return this.getSource().getType() * 100 + this.getIndex();
    }

    @Override
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

