/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;

class AbstractManager {
    private SwdlEnv swdlEnv;
    private final AbstractPopupManager popupManager;

    public AbstractManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager) {
        this.swdlEnv = swdlEnv;
        this.popupManager = abstractPopupManager;
    }

    protected final IHMIServiceApp getHMIService() {
        return this.getSwdlEnv().getHMIService();
    }

    protected SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    protected SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    protected final AbstractSwdlTextFactory getTextFactory() {
        return this.getSwdlEnv().getTextFactory();
    }

    protected final AbstractPopupManager getPopupManager() {
        return this.popupManager;
    }

    protected final LogChannel getLogHMI() {
        return this.getSwdlEnv().getLogHMI();
    }
}

