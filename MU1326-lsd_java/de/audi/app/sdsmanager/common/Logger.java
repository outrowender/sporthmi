/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;

public class Logger {
    private static LogChannel logMain;
    private static LogChannel logCmd;
    private static LogChannel logAudio;
    private static LogChannel logDSIASR;
    private static LogChannel logDSITTS;
    private static LogChannel logNBest;
    private static LogChannel logHMI;
    private static LogChannel logGrammar;
    private static LogChannel logGrammarAdding;
    private static LogChannel logTimeout;
    private static LogChannel logAppSystem;
    private static LogChannel logAppADB;
    private static LogChannel logAppMedia;
    private static LogChannel logAppNavi;
    private static LogChannel logAppPhone;
    private static LogChannel logAppTuner;
    private static LogChannel logRemoteHMI;
    private static LogChannel logAppMessaging;
    private static LogChannel logDictation;

    public static void initLogChannels(IFrameworkAccess iFrameworkAccess) {
        logGrammar = iFrameworkAccess.getLogChannel("App.SDS.Grammar");
        logGrammarAdding = iFrameworkAccess.getLogChannel("App.SDS.GrammarAdding");
        logMain = iFrameworkAccess.getLogChannel("App.SDS.Main");
        logCmd = iFrameworkAccess.getLogChannel("App.SDS.Command");
        logAudio = iFrameworkAccess.getLogChannel("App.SDS.Audio");
        logDSIASR = iFrameworkAccess.getLogChannel("App.SDS.DSI.ASR");
        logDSITTS = iFrameworkAccess.getLogChannel("App.SDS.DSI.TTS");
        logNBest = iFrameworkAccess.getLogChannel("App.SDS.NBest");
        logHMI = iFrameworkAccess.getLogChannel("App.SDS.HMI");
        logAppSystem = iFrameworkAccess.getLogChannel("App.SDS.Apps.Common");
        logAppADB = iFrameworkAccess.getLogChannel("App.SDS.Apps.ADB");
        logAppMedia = iFrameworkAccess.getLogChannel("App.SDS.Apps.Media");
        logAppNavi = iFrameworkAccess.getLogChannel("App.SDS.Apps.Navi");
        logAppPhone = iFrameworkAccess.getLogChannel("App.SDS.Apps.Phone");
        logAppTuner = iFrameworkAccess.getLogChannel("App.SDS.Apps.Tuner");
        logRemoteHMI = iFrameworkAccess.getLogChannel("App.SDS.Apps.RemoteHMI");
        logDictation = iFrameworkAccess.getLogChannel("App.SDS.Apps.MessageDictation");
        logAppMessaging = iFrameworkAccess.getLogChannel("App.SDS.Apps.Messaging");
        logTimeout = iFrameworkAccess.getLogChannel("App.SDS.Timeouts");
    }

    public static LogChannel getMainLog() {
        if (logMain == null) {
            return NullLogChannel.getInstance();
        }
        return logMain;
    }

    public static LogChannel getAudioLog() {
        if (logAudio == null) {
            return NullLogChannel.getInstance();
        }
        return logAudio;
    }

    public static LogChannel getDSIASRLog() {
        if (logDSIASR == null) {
            return NullLogChannel.getInstance();
        }
        return logDSIASR;
    }

    public static LogChannel getDSITTSLog() {
        if (logDSITTS == null) {
            return NullLogChannel.getInstance();
        }
        return logDSITTS;
    }

    public static LogChannel getCommandLog() {
        if (logCmd == null) {
            return NullLogChannel.getInstance();
        }
        return logCmd;
    }

    public static LogChannel getNBestLog() {
        if (logNBest == null) {
            return NullLogChannel.getInstance();
        }
        return logNBest;
    }

    public static LogChannel getHMILog() {
        if (logHMI == null) {
            return NullLogChannel.getInstance();
        }
        return logHMI;
    }

    public static LogChannel getAppSystemLog() {
        if (logAppSystem == null) {
            return NullLogChannel.getInstance();
        }
        return logAppSystem;
    }

    public static LogChannel getAppADBLog() {
        if (logAppADB == null) {
            return NullLogChannel.getInstance();
        }
        return logAppADB;
    }

    public static LogChannel getAppMediaLog() {
        if (logAppMedia == null) {
            return NullLogChannel.getInstance();
        }
        return logAppMedia;
    }

    public static LogChannel getAppNaviLog() {
        if (logAppNavi == null) {
            return NullLogChannel.getInstance();
        }
        return logAppNavi;
    }

    public static LogChannel getAppPhoneLog() {
        if (logAppPhone == null) {
            return NullLogChannel.getInstance();
        }
        return logAppPhone;
    }

    public static LogChannel getAppTunerLog() {
        if (logAppTuner == null) {
            return NullLogChannel.getInstance();
        }
        return logAppTuner;
    }

    public static LogChannel getGrammarLog() {
        if (logGrammar == null) {
            return NullLogChannel.getInstance();
        }
        return logGrammar;
    }

    public static LogChannel getGrammarAddingLog() {
        if (logGrammarAdding == null) {
            return NullLogChannel.getInstance();
        }
        return logGrammarAdding;
    }

    public static LogChannel getAppRemoteHMI() {
        if (logRemoteHMI == null) {
            return NullLogChannel.getInstance();
        }
        return logRemoteHMI;
    }

    public static LogChannel getAppDictationLog() {
        if (logDictation == null) {
            return NullLogChannel.getInstance();
        }
        return logDictation;
    }

    public static LogChannel getAppMessagingLog() {
        if (logAppMessaging == null) {
            return NullLogChannel.getInstance();
        }
        return logAppMessaging;
    }

    public static LogChannel getTimeoutLog() {
        if (logTimeout == null) {
            return NullLogChannel.getInstance();
        }
        return logTimeout;
    }
}

