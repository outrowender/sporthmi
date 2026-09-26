/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.IPreviewInfo;
import java.util.ArrayList;
import java.util.List;

public final class Commands$StateUpdatePreviewsPayload {
    private final long delayMillis;
    private final List previews;

    public Commands$StateUpdatePreviewsPayload(long l, IPreviewInfo iPreviewInfo) {
        this.delayMillis = l;
        this.previews = new ArrayList(10);
        this.previews.add(iPreviewInfo);
    }

    public long getDelayMillis() {
        return this.delayMillis;
    }

    public List getPreviews() {
        return this.previews;
    }
}

