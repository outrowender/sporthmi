/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;

public abstract class InfoAPImpl {
    protected AppTMC tmcApp;
    protected LogChannel logger;
    protected final InfoEnv env;

    public InfoAPImpl(InfoEnv infoEnv, AppTMC appTMC, LogChannel logChannel) {
        this.env = infoEnv;
        this.tmcApp = appTMC;
        this.logger = logChannel;
    }

    public void tmcMapLeft(int n) {
        this.logger.log(10000000, "[InfoAPImpl#tmcMapLeft] Called");
    }
}

