/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices.logger;

import de.audi.app.bap.utils.AbstractBAPLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;

public class LoggerRemoteServices
extends AbstractBAPLogger {
    private static final String LOG_CH_PREFIX = "App.BAPRemoteServices";
    private static final String LOG_CH_REMOTE_SERVICES = "RemoteServices";
    private static final String LOG_CH_REMOTE_SERVICES_BAPDATA = "RemoteServices.BAPData";
    private final LogChannel logRemoteServices;
    private final LogChannel logRemoteServicesBAPData;

    public LoggerRemoteServices(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, LOG_CH_PREFIX);
        this.logRemoteServices = iFrameworkAccess.getLogChannel(LoggerRemoteServices.createLogChannelName(LOG_CH_REMOTE_SERVICES));
        this.logRemoteServicesBAPData = iFrameworkAccess.getLogChannel(LoggerRemoteServices.createLogChannelName(LOG_CH_REMOTE_SERVICES_BAPDATA));
    }

    public LogChannel getLog(int n) {
        LogChannel logChannel;
        switch (n) {
            case 78: {
                logChannel = this.logRemoteServices;
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
            case 78: {
                logChannel = this.logRemoteServicesBAPData;
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

