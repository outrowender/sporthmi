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
    private static final String LOG_CH_PREFIX;
    private static final String LOG_CH_REMOTE_SERVICES;
    private static final String LOG_CH_REMOTE_SERVICES_BAPDATA;
    private final LogChannel logRemoteServices;
    private final LogChannel logRemoteServicesBAPData;

    public LoggerRemoteServices(IFrameworkAccess iFrameworkAccess) {
        AbstractBAPLogger.init(iFrameworkAccess, "App.BAPRemoteServices");
        this.logRemoteServices = iFrameworkAccess.getLogChannel(LoggerRemoteServices.createLogChannelName("RemoteServices"));
        this.logRemoteServicesBAPData = iFrameworkAccess.getLogChannel(LoggerRemoteServices.createLogChannelName("RemoteServices.BAPData"));
    }

    @Override
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

    @Override
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

