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
    private static final String LOG_CH_PREFIX;
    private static final String LOG_CH_ONLINE_FUNCTIONS;
    private static final String LOG_CH_ONLINE_FUNCTIONS_BAPDATA;
    private final LogChannel logOnlineFunctions;
    private final LogChannel logOnlineFunctionsBAPData;

    public LoggerOnlineFunctionsBAP(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, "App.OnlineFunctionsBAP");
        this.logOnlineFunctions = iFrameworkAccess.getLogChannel(LoggerOnlineFunctionsBAP.createLogChannelName("OnlineFunctions"));
        this.logOnlineFunctionsBAPData = iFrameworkAccess.getLogChannel(LoggerOnlineFunctionsBAP.createLogChannelName("OnlineFunctions.BAPData"));
    }

    @Override
    public LogChannel getLog(int n) {
        return this.logOnlineFunctions;
    }

    @Override
    public LogChannel getLogBAPData(int n) {
        return this.logOnlineFunctionsBAPData;
    }

    @Override
    public LogChannel getMainLog() {
        return logMain != null ? logMain : NullLogChannel.getInstance();
    }
}

