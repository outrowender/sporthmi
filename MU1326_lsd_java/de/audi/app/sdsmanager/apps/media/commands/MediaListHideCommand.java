/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISDSScreenFadedOutUpdatable;
import de.audi.app.sdsmanager.apps.system.PopupStrategy;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class MediaListHideCommand
extends AbstractSystemCallCommand
implements ISDSScreenFadedOutUpdatable {
    private final PopupStrategy popupHelper;
    private final HMIService hmi;

    public MediaListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, PopupStrategy popupStrategy) {
        super(logChannel, string, sDSHandlerService);
        this.popupHelper = popupStrategy;
        this.hmi = hMIService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.popupHelper.triggerPopup();
        int n = this.hmi.getCurrentPopup(0);
        if (n == SDSManagerBaseActivator.getMapping().getPopupID(20)) {
            this.logger.log(10000000, "%1#execute: Media picklist is visible -> wait for fading out", (Object)this.getName());
            return;
        }
        this.processingFinished();
    }

    public void updateSDSScreenFadedOut(int n) {
        this.processingFinished();
    }
}

