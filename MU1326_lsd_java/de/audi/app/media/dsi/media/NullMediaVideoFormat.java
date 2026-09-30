/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaVideoFormat;
import de.audi.atip.log.LogChannel;

public class NullMediaVideoFormat
implements IMediaVideoFormat {
    private static final String LOGCLASS = "NullMediaVideoFormat";
    protected final LogChannel logger;

    public NullMediaVideoFormat(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public boolean setVideoFormat(int n) {
        this.logger.log(1000000, "[%1.setVideoFormat]", (Object)LOGCLASS);
        return false;
    }

    public int getHMIVideoFormatID(int n) {
        return 0;
    }
}

