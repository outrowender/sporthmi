/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl.evo.hmiswitcher.manager;

import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;

public class PopupManagerEvo
extends AbstractPopupManager {
    public PopupManagerEvo(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super(swdlEnv, abstractSwdlJoinedDownloadState, swdlDSIHandlerProgress);
    }

    protected void fireSMEventTriggerDownloadAborting(int n) {
    }

    protected int getSwdlPopupID() {
        return 1700000;
    }

    protected void showSwdlPopup(int n) {
        this.getHMIService().showPopup(this.getSwdlPopupID(), n);
    }

    protected void hideSwdlPopup(int n) {
        this.getHMIService().removePopup(this.getSwdlPopupID(), n);
    }
}

