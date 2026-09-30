/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.logger;

import de.audi.atip.log.LogChannel;

public interface IMediaLogger {
    public static final String MEDIA_LOG_CHANNEL_ROOT = "App.Media";

    public String getLogPrefix();

    public LogChannel dsi();

    public LogChannel hmi();

    public LogChannel main();

    public LogChannel audio();

    public LogChannel sds();

    public LogChannel exlap();
}

