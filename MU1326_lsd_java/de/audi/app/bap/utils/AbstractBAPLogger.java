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
    private static final String LOG_CH_MAIN;
    private static final String LOG_CH_DSI;
    private static final String LOG_CH_DIAG;
    private static String channelPrefix;
    protected static LogChannel logMain;
    private static LogChannel logDSI;
    private static LogChannel logDiag;

    public static void init(IFrameworkAccess iFrameworkAccess, String string) {
        channelPrefix = string;
        logMain = iFrameworkAccess.getLogChannel(AbstractBAPLogger.createLogChannelName("Main"));
        logDSI = iFrameworkAccess.getLogChannel(AbstractBAPLogger.createLogChannelName("DSI"));
        logDiag = iFrameworkAccess.getLogChannel(AbstractBAPLogger.createLogChannelName("Diag"));
    }

    protected static String createLogChannelName(String string) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(channelPrefix);
        return stringBuffer.append('.').append(string).toString();
    }

    @Override
    public LogChannel getMainLog() {
        return logMain != null ? logMain : NullLogChannel.getInstance();
    }

    @Override
    public LogChannel getDSILog() {
        return logDSI != null ? logDSI : NullLogChannel.getInstance();
    }

    @Override
    public LogChannel getDiagLog() {
        return logDiag != null ? logDiag : NullLogChannel.getInstance();
    }
}

