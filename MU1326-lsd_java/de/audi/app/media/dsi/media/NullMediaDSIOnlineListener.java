/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaDSIOnlineListener;
import de.audi.atip.log.LogChannel;

public class NullMediaDSIOnlineListener
implements IMediaDSIOnlineListener {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullMediaDSIOnlineListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void updateBufferState(int n) {
        this.logger.log(1078071040, "[%1.updateBufferState]", (Object)"NullMediaDSIOnlineListener");
    }

    @Override
    public void updateBufferFillInfo(int n, int n2) {
        this.logger.log(1078071040, "[%1.updateBufferFillInfo]", (Object)"NullMediaDSIOnlineListener");
    }

    @Override
    public void updateAudioSettings(int n, int n2) {
        this.logger.log(1078071040, "[%1.updateAudioSettings]", (Object)"NullMediaDSIOnlineListener");
    }
}

