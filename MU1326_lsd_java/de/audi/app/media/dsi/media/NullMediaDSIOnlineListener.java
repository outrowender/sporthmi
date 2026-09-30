/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaDSIOnlineListener;
import de.audi.atip.log.LogChannel;

public class NullMediaDSIOnlineListener
implements IMediaDSIOnlineListener {
    private static final String LOGCLASS = "NullMediaDSIOnlineListener";
    private final LogChannel logger;

    public NullMediaDSIOnlineListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void updateBufferState(int n) {
        this.logger.log(1000000, "[%1.updateBufferState]", (Object)LOGCLASS);
    }

    public void updateBufferFillInfo(int n, int n2) {
        this.logger.log(1000000, "[%1.updateBufferFillInfo]", (Object)LOGCLASS);
    }

    public void updateAudioSettings(int n, int n2) {
        this.logger.log(1000000, "[%1.updateAudioSettings]", (Object)LOGCLASS);
    }
}

