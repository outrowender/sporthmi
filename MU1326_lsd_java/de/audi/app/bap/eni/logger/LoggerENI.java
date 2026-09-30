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
    private static final String LOG_CH_PREFIX = "App.BAPENI";
    private static final String LOG_CH_ENI = "ENI";
    private static final String LOG_CH_ENI_BAPDATA = "ENI.BAPData";
    private final LogChannel logENI;
    private final LogChannel logENIBAPData;

    public LoggerENI(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, LOG_CH_PREFIX);
        this.logENI = iFrameworkAccess.getLogChannel(LoggerENI.createLogChannelName(LOG_CH_ENI));
        this.logENIBAPData = iFrameworkAccess.getLogChannel(LoggerENI.createLogChannelName(LOG_CH_ENI_BAPDATA));
    }

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

