/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app;

import de.audi.atip.interapp.InfoService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;

public class InfoSdsService
implements InfoService {
    private AppTMC appTMC;
    private LogChannel logger;

    public InfoSdsService(AppTMC appTMC, LogChannel logChannel) {
        this.appTMC = appTMC;
        this.logger = logChannel;
    }

    @Override
    public int getTPInfoAvailable() {
        this.logger.log(-2137614336, "InfoSdsService#getTPInfoAvailable() ");
        return 0;
    }

    @Override
    public void speakTmcMessages(boolean bl) {
        this.logger.log(-2137614336, "InfoSdsService#speakTmcMessages() - available: %1", bl);
    }

    @Override
    public void speakTIMMessages(boolean bl) {
        this.logger.log(-2137614336, "InfoSdsService#speakTIMMessages() - available: %1", bl);
    }

    public void stop() {
        this.logger.log(-2137614336, "InfoSdsService#stop() ");
    }
}

