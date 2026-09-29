/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaVideoFormat;
import de.audi.atip.log.LogChannel;

public class NullMediaVideoFormat
implements IMediaVideoFormat {
    private static final String LOGCLASS;
    protected final LogChannel logger;

    public NullMediaVideoFormat(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public boolean setVideoFormat(int n) {
        this.logger.log(1078071040, "[%1.setVideoFormat]", (Object)"NullMediaVideoFormat");
        return false;
    }

    @Override
    public int getHMIVideoFormatID(int n) {
        return 0;
    }
}

