/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.logger;

import de.audi.atip.log.LogChannel;

public interface IMediaLogger {
    public static final String MEDIA_LOG_CHANNEL_ROOT;

    default public String getLogPrefix() {
    }

    default public LogChannel dsi() {
    }

    default public LogChannel hmi() {
    }

    default public LogChannel main() {
    }

    default public LogChannel audio() {
    }

    default public LogChannel sds() {
    }

    default public LogChannel exlap() {
    }
}

