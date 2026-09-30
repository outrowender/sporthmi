/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.source.ISource;
import de.audi.app.media.source.MediaSlot;
import de.audi.app.media.source.MediaSourceSlot;

public class OnlinePlayerSourceSlot
extends MediaSourceSlot {
    private final String activeSourceListIcon;
    private final String activeSourceListReflectionIcon;
    private final String activeSourceListClosedIcon;
    private final String captionIcon;
    private final String loadingIcon;
    private final int entryPointID;

    public OnlinePlayerSourceSlot(ISource iSource, int n, MediaSlot mediaSlot, int n2, String string, String string2, String string3, String string4, String string5, String string6, String string7, int n3) {
        super(iSource, 3, n, 25, mediaSlot.getDeviceID(), mediaSlot.getMediaID(), string, string2, mediaSlot.getFlags(), mediaSlot.getCapabilities(), n2, 0, "");
        this.activeSourceListIcon = string3 != null && string3.length() == 0 ? null : string3;
        this.activeSourceListReflectionIcon = string4 != null && string4.length() == 0 ? null : string4;
        this.activeSourceListClosedIcon = string5 != null && string5.length() == 0 ? null : string5;
        this.captionIcon = string6 != null && string6.length() == 0 ? null : string6;
        this.loadingIcon = string7 != null && string7.length() == 0 ? null : string7;
        this.entryPointID = n3;
    }

    public String getActiveSourceListIcon() {
        return this.activeSourceListIcon;
    }

    public String getActiveSourceListReflectionIcon() {
        return this.activeSourceListReflectionIcon;
    }

    public String getActiveSourceListClosedIcon() {
        return this.activeSourceListClosedIcon;
    }

    public String getCaptionIcon() {
        return this.captionIcon;
    }

    public String getLoadingIcon() {
        return this.loadingIcon;
    }

    public int getEntryPointID() {
        return this.entryPointID;
    }
}

