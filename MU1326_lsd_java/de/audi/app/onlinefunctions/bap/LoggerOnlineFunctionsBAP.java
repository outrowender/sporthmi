/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.utils.AbstractBAPLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;

public class LoggerOnlineFunctionsBAP
extends AbstractBAPLogger {
    private static final String LOG_CH_PREFIX = "App.OnlineFunctionsBAP";
    private static final String LOG_CH_ONLINE_FUNCTIONS = "OnlineFunctions";
    private static final String LOG_CH_ONLINE_FUNCTIONS_BAPDATA = "OnlineFunctions.BAPData";
    private final LogChannel logOnlineFunctions;
    private final LogChannel logOnlineFunctionsBAPData;

    public LoggerOnlineFunctionsBAP(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, LOG_CH_PREFIX);
        this.logOnlineFunctions = iFrameworkAccess.getLogChannel(LoggerOnlineFunctionsBAP.createLogChannelName(LOG_CH_ONLINE_FUNCTIONS));
        this.logOnlineFunctionsBAPData = iFrameworkAccess.getLogChannel(LoggerOnlineFunctionsBAP.createLogChannelName(LOG_CH_ONLINE_FUNCTIONS_BAPDATA));
    }

    public LogChannel getLog(int n) {
        return this.logOnlineFunctions;
    }

    public LogChannel getLogBAPData(int n) {
        return this.logOnlineFunctionsBAPData;
    }

    public LogChannel getMainLog() {
        return logMain != null ? logMain : NullLogChannel.getInstance();
    }
}

