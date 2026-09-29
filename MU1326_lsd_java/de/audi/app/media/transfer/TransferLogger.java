/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class TransferLogger {
    private static final String LOG_CH_PREFIX;
    private static final String LOG_CH_MAIN;
    private static final String LOG_CH_DSI;
    private static final String LOG_CH_HMI;
    private final LogChannel main;
    private final LogChannel dsi;
    private final LogChannel hmi;

    public TransferLogger(IFrameworkAccess iFrameworkAccess) {
        this.main = iFrameworkAccess.getLogChannel("App.Media.Transfer.Main");
        this.dsi = iFrameworkAccess.getLogChannel("App.Media.Transfer.DSI");
        this.hmi = iFrameworkAccess.getLogChannel("App.Media.Transfer.HMI");
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

