/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.logger;

import de.audi.app.media.logger.IMediaLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class MediaLoggerImpl
implements IMediaLogger {
    private static final String LOG_CH_PREFIX_RSE_LEFT;
    private static final String LOG_CH_PREFIX_RSE_RIGHT;
    private static final String LOG_CH_MEDIA;
    private static final String LOG_CH_HMI;
    private static final String LOG_CH_DSI;
    private static final String LOG_CH_SDS;
    private static final String LOG_CH_AUDIO;
    private static final String LOG_CH_EXLAP;
    private final int terminalID;
    private final LogChannel dsiChannel;
    private final LogChannel hmiChannel;
    private final LogChannel mainChannel;
    private final LogChannel audioChannel;
    private final LogChannel sdsChannel;
    private final LogChannel exlapChannel;

    public MediaLoggerImpl(int n, IFrameworkAccess iFrameworkAccess) {
        this.terminalID = n;
        this.mainChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, "Main"));
        this.hmiChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, "HMI"));
        this.dsiChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, "DSI"));
        this.audioChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, "Audio"));
        this.sdsChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, "SDS"));
        this.exlapChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, "Exlap"));
    }

    @Override
    public String getLogPrefix() {
        return MediaLoggerImpl.getLogChPrefix(this.terminalID);
    }

    private static String getLogChPrefix(int n) {
        switch (n) {
            case 3: {
                return "App.Media_LEFT";
            }
            case 4: {
                return "App.Media_RIGHT";
            }
        }
        return "App.Media";
    }

    private static String getLogChName(int n, String string) {
        Buffer buffer = new Buffer(30);
        return buffer.append(MediaLoggerImpl.getLogChPrefix(n)).append('.').append(string).toString();
    }

    @Override
    public LogChannel dsi() {
        return this.dsiChannel;
    }

    @Override
    public LogChannel hmi() {
        return this.hmiChannel;
    }

    @Override
    public LogChannel main() {
        return this.mainChannel;
    }

    @Override
    public LogChannel audio() {
        return this.audioChannel;
    }

    @Override
    public LogChannel sds() {
        return this.sdsChannel;
    }

    @Override
    public LogChannel exlap() {
        return this.exlapChannel;
    }
}

