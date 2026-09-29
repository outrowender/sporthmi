/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.utils;

import de.audi.app.bap.utils.AbstractBAPLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;

public class CombiLogger
extends AbstractBAPLogger {
    private static final String LOG_CH_PREFIX;
    private static final String LOG_CH_COMBI_AUDIO;
    private static final String LOG_CH_COMBI_AUDIO_BAPDATA;
    private static final String LOG_CH_COMBI_NAVI;
    private static final String LOG_CH_COMBI_NAVI_BAPDATA;
    private static final String LOG_CH_COMBI_NAVI_FREQUENT;
    private static final String LOG_CH_COMBI_PHONE;
    private static final String LOG_CH_COMBI_PHONE_BAPDATA;
    private static final String LOG_CH_COMBI_PHONE2;
    private static final String LOG_CH_COMBI_PHONE2_BAPDATA;
    private static final String LOG_CH_COMBI_MFL;
    private static final String LOG_CH_COMBI_MFL_BAPDATA;
    private static final String LOG_CH_COMBI_STATISTICS;
    private static final String LOG_CH_COMBI_PICTURE_SERVER;
    private static final String LOG_CH_COMBI_PICTURE_SERVER_DSI;
    private static final String LOG_CH_COMBI_FASTLIST;
    private static final String LOG_CH_COMBI_FASTLIST_DSI;
    private static LogChannel logAudio;
    private static LogChannel logAudioBAPData;
    private static LogChannel logNavi;
    private static LogChannel logNaviBAPData;
    private static LogChannel logNaviFrequent;
    private static LogChannel logPhone;
    private static LogChannel logPhoneBAPData;
    private static LogChannel logPhone2;
    private static LogChannel logPhone2BAPData;
    private static LogChannel logMFL;
    private static LogChannel logMFLBAPData;
    private static LogChannel logStatistics;
    private static LogChannel logPicServer;
    private static LogChannel logPicServerDSI;
    private static LogChannel logFastList;
    private static LogChannel logFastListDSI;
    private static boolean advancedLoggingEnabled;

    public CombiLogger(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, "App.CombiBAP");
        logAudio = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Audio"));
        logAudioBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Audio.BAPData"));
        logNavi = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Navi"));
        logNaviBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Navi.BAPData"));
        logNaviFrequent = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Navi.Frequent"));
        logPhone = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Phone"));
        logPhoneBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Phone.BAPData"));
        logPhone2 = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Phone2"));
        logPhone2BAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Phone2.BAPData"));
        logMFL = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("MFL"));
        logMFLBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("MFL.BAPData"));
        logStatistics = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("Statistics"));
        logPicServer = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("PictureServer"));
        logPicServerDSI = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("PictureServer.DSI"));
        logFastList = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("FastList"));
        logFastListDSI = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName("FastList.DSI"));
    }

    @Override
    public LogChannel getLog(int n) {
        LogChannel logChannel;
        switch (n) {
            case 49: {
                logChannel = logAudio;
                break;
            }
            case 50: {
                logChannel = logNavi;
                break;
            }
            case 40: {
                logChannel = logPhone;
                break;
            }
            case 41: {
                logChannel = logPhone2;
                break;
            }
            case 52: {
                logChannel = logMFL;
                break;
            }
            default: {
                logChannel = logMain;
            }
        }
        if (logChannel == null) {
            return NullLogChannel.getInstance();
        }
        return logChannel;
    }

    @Override
    public LogChannel getLogBAPData(int n) {
        LogChannel logChannel;
        switch (n) {
            case 49: {
                logChannel = logAudioBAPData;
                break;
            }
            case 50: {
                logChannel = logNaviBAPData;
                break;
            }
            case 40: {
                logChannel = logPhoneBAPData;
                break;
            }
            case 41: {
                logChannel = logPhone2BAPData;
                break;
            }
            case 52: {
                logChannel = logMFLBAPData;
                break;
            }
            default: {
                logChannel = logMain;
            }
        }
        if (logChannel == null) {
            return NullLogChannel.getInstance();
        }
        return logChannel;
    }

    public static LogChannel getFwNaviFrequentLog() {
        return logNaviFrequent != null ? logNaviFrequent : NullLogChannel.getInstance();
    }

    public static LogChannel getStatisticsLog() {
        return logStatistics != null ? logStatistics : NullLogChannel.getInstance();
    }

    public static LogChannel getPicServerLog() {
        return logPicServer != null ? logPicServer : NullLogChannel.getInstance();
    }

    public static LogChannel getPicServerDSILog() {
        return logPicServerDSI != null ? logPicServerDSI : NullLogChannel.getInstance();
    }

    public static LogChannel getFastListLog() {
        return logFastList != null ? logFastList : NullLogChannel.getInstance();
    }

    public static LogChannel getFastListDSILog() {
        return logFastListDSI != null ? logFastListDSI : NullLogChannel.getInstance();
    }

    public static boolean isAdvancedLoggingEnabled() {
        return advancedLoggingEnabled;
    }

    public static void setAdvancedLoggingEnabled(boolean bl) {
        advancedLoggingEnabled = bl;
    }

    static {
        advancedLoggingEnabled = false;
    }
}

