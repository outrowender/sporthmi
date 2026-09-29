/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall.logger;

import de.audi.app.bap.utils.AbstractBAPLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;

public final class LoggerEcall
extends AbstractBAPLogger {
    private static final String LOG_CH_PREFIX;
    private static final String LOG_CH_ECALL;
    private static final String LOG_CH_ECALL_BAPDATA;
    private final LogChannel logEcall;
    private final LogChannel logEcallBAPData;

    public LoggerEcall(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, "App.BAPEcall");
        this.logEcall = iFrameworkAccess.getLogChannel(LoggerEcall.createLogChannelName("Ecall"));
        this.logEcallBAPData = iFrameworkAccess.getLogChannel(LoggerEcall.createLogChannelName("Ecall.BAPData"));
    }

    @Override
    public LogChannel getLog(int n) {
        LogChannel logChannel;
        switch (n) {
            case 51: {
                logChannel = this.logEcall;
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
            case 51: {
                logChannel = this.logEcallBAPData;
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

