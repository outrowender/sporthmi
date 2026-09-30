/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.app.bap.utils.IBAPLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;

public abstract class AbstractBAPLogger
implements IBAPLogger {
    private static final String LOG_CH_MAIN = "Main";
    private static final String LOG_CH_DSI = "DSI";
    private static final String LOG_CH_DIAG = "Diag";
    private static String channelPrefix;
    protected static LogChannel logMain;
    private static LogChannel logDSI;
    private static LogChannel logDiag;

    public static void init(IFrameworkAccess iFrameworkAccess, String string) {
        channelPrefix = string;
        logMain = iFrameworkAccess.getLogChannel(AbstractBAPLogger.createLogChannelName(LOG_CH_MAIN));
        logDSI = iFrameworkAccess.getLogChannel(AbstractBAPLogger.createLogChannelName(LOG_CH_DSI));
        logDiag = iFrameworkAccess.getLogChannel(AbstractBAPLogger.createLogChannelName(LOG_CH_DIAG));
    }

    protected static String createLogChannelName(String string) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(channelPrefix);
        return stringBuffer.append('.').append(string).toString();
    }

    public LogChannel getMainLog() {
        return logMain != null ? logMain : NullLogChannel.getInstance();
    }

    public LogChannel getDSILog() {
        return logDSI != null ? logDSI : NullLogChannel.getInstance();
    }

    public LogChannel getDiagLog() {
        return logDiag != null ? logDiag : NullLogChannel.getInstance();
    }
}

