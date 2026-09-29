/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni.logger;

import de.audi.app.bap.utils.AbstractBAPLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;

public class LoggerENI
extends AbstractBAPLogger {
    private static final String LOG_CH_PREFIX;
    private static final String LOG_CH_ENI;
    private static final String LOG_CH_ENI_BAPDATA;
    private final LogChannel logENI;
    private final LogChannel logENIBAPData;

    public LoggerENI(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, "App.BAPENI");
        this.logENI = iFrameworkAccess.getLogChannel(LoggerENI.createLogChannelName("ENI"));
        this.logENIBAPData = iFrameworkAccess.getLogChannel(LoggerENI.createLogChannelName("ENI.BAPData"));
    }

    @Override
    public LogChannel getLog(int n) {
        LogChannel logChannel;
        switch (n) {
            case 55: {
                logChannel = this.logENI;
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
            case 55: {
                logChannel = this.logENIBAPData;
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
}

