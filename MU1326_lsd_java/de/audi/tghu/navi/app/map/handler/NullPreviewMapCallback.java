/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.PreviewMapCallback;
import de.audi.atip.log.LogChannel;

public class NullPreviewMapCallback
implements PreviewMapCallback {
    private LogChannel logger;

    public NullPreviewMapCallback(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void onPreviewMapEntered() {
    }

    public void onPreviewMapLeft() {
    }
}

