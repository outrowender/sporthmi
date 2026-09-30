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
    private static final String LOG_CH_PREFIX_RSE_LEFT = "App.Media_LEFT";
    private static final String LOG_CH_PREFIX_RSE_RIGHT = "App.Media_RIGHT";
    private static final String LOG_CH_MEDIA = "Main";
    private static final String LOG_CH_HMI = "HMI";
    private static final String LOG_CH_DSI = "DSI";
    private static final String LOG_CH_SDS = "SDS";
    private static final String LOG_CH_AUDIO = "Audio";
    private static final String LOG_CH_EXLAP = "Exlap";
    private final int terminalID;
    private final LogChannel dsiChannel;
    private final LogChannel hmiChannel;
    private final LogChannel mainChannel;
    private final LogChannel audioChannel;
    private final LogChannel sdsChannel;
    private final LogChannel exlapChannel;

    public MediaLoggerImpl(int n, IFrameworkAccess iFrameworkAccess) {
        this.terminalID = n;
        this.mainChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, LOG_CH_MEDIA));
        this.hmiChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, LOG_CH_HMI));
        this.dsiChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, LOG_CH_DSI));
        this.audioChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, LOG_CH_AUDIO));
        this.sdsChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, LOG_CH_SDS));
        this.exlapChannel = iFrameworkAccess.getLogChannel(MediaLoggerImpl.getLogChName(this.terminalID, LOG_CH_EXLAP));
    }

    public String getLogPrefix() {
        return MediaLoggerImpl.getLogChPrefix(this.terminalID);
    }

    private static String getLogChPrefix(int n) {
        switch (n) {
            case 3: {
                return LOG_CH_PREFIX_RSE_LEFT;
            }
            case 4: {
                return LOG_CH_PREFIX_RSE_RIGHT;
            }
        }
        return "App.Media";
    }

    private static String getLogChName(int n, String string) {
        Buffer buffer = new Buffer(30);
        return buffer.append(MediaLoggerImpl.getLogChPrefix(n)).append('.').append(string).toString();
    }

    public LogChannel dsi() {
        return this.dsiChannel;
    }

    public LogChannel hmi() {
        return this.hmiChannel;
    }

    public LogChannel main() {
        return this.mainChannel;
    }

    public LogChannel audio() {
        return this.audioChannel;
    }

    public LogChannel sds() {
        return this.sdsChannel;
    }

    public LogChannel exlap() {
        return this.exlapChannel;
    }
}

