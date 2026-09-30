/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class TransferLogger {
    private static final String LOG_CH_PREFIX = "App.Media.Transfer.";
    private static final String LOG_CH_MAIN = "App.Media.Transfer.Main";
    private static final String LOG_CH_DSI = "App.Media.Transfer.DSI";
    private static final String LOG_CH_HMI = "App.Media.Transfer.HMI";
    private final LogChannel main;
    private final LogChannel dsi;
    private final LogChannel hmi;

    public TransferLogger(IFrameworkAccess iFrameworkAccess) {
        this.main = iFrameworkAccess.getLogChannel(LOG_CH_MAIN);
        this.dsi = iFrameworkAccess.getLogChannel(LOG_CH_DSI);
        this.hmi = iFrameworkAccess.getLogChannel(LOG_CH_HMI);
    }

    public LogChannel main() {
        return this.main;
    }

    public LogChannel dsi() {
        return this.dsi;
    }

    public LogChannel hmi() {
        return this.hmi;
    }
}

