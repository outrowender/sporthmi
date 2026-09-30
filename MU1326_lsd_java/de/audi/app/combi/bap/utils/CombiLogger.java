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
    private static final String LOG_CH_PREFIX = "App.CombiBAP";
    private static final String LOG_CH_COMBI_AUDIO = "Audio";
    private static final String LOG_CH_COMBI_AUDIO_BAPDATA = "Audio.BAPData";
    private static final String LOG_CH_COMBI_NAVI = "Navi";
    private static final String LOG_CH_COMBI_NAVI_BAPDATA = "Navi.BAPData";
    private static final String LOG_CH_COMBI_NAVI_FREQUENT = "Navi.Frequent";
    private static final String LOG_CH_COMBI_PHONE = "Phone";
    private static final String LOG_CH_COMBI_PHONE_BAPDATA = "Phone.BAPData";
    private static final String LOG_CH_COMBI_PHONE2 = "Phone2";
    private static final String LOG_CH_COMBI_PHONE2_BAPDATA = "Phone2.BAPData";
    private static final String LOG_CH_COMBI_MFL = "MFL";
    private static final String LOG_CH_COMBI_MFL_BAPDATA = "MFL.BAPData";
    private static final String LOG_CH_COMBI_STATISTICS = "Statistics";
    private static final String LOG_CH_COMBI_PICTURE_SERVER = "PictureServer";
    private static final String LOG_CH_COMBI_PICTURE_SERVER_DSI = "PictureServer.DSI";
    private static final String LOG_CH_COMBI_FASTLIST = "FastList";
    private static final String LOG_CH_COMBI_FASTLIST_DSI = "FastList.DSI";
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
        AbstractBAPLogger.init(iFrameworkAccess, LOG_CH_PREFIX);
        logAudio = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_AUDIO));
        logAudioBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_AUDIO_BAPDATA));
        logNavi = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_NAVI));
        logNaviBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_NAVI_BAPDATA));
        logNaviFrequent = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_NAVI_FREQUENT));
        logPhone = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_PHONE));
        logPhoneBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_PHONE_BAPDATA));
        logPhone2 = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_PHONE2));
        logPhone2BAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_PHONE2_BAPDATA));
        logMFL = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_MFL));
        logMFLBAPData = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_MFL_BAPDATA));
        logStatistics = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_STATISTICS));
        logPicServer = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_PICTURE_SERVER));
        logPicServerDSI = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_PICTURE_SERVER_DSI));
        logFastList = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_FASTLIST));
        logFastListDSI = iFrameworkAccess.getLogChannel(CombiLogger.createLogChannelName(LOG_CH_COMBI_FASTLIST_DSI));
    }

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

