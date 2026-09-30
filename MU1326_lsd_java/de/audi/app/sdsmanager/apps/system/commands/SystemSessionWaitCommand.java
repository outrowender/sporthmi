/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISystemSessionStartCommand;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.atip.log.LogChannel;

public class SystemSessionWaitCommand
extends AbstractSystemCallCommand
implements ISystemSessionStartCommand {
    private final SDSAudioHandler audioHandler;
    private final AppSDSManager sdsManager;
    private final ISDSPopupHelper popupHelper;

    public SystemSessionWaitCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, SDSAudioHandler sDSAudioHandler, AppSDSManager appSDSManager, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.audioHandler = sDSAudioHandler;
        this.sdsManager = appSDSManager;
        this.popupHelper = iSDSPopupHelper;
    }

    public void execute() {
        if (this.sdsHandlerService.isSDSVolumeSettingActive()) {
            this.logger.log(10000000, "%1#execute: Volume setting dialog is active or ending, returning OK without requesting audio connections!", (Object)this.getName());
            this.sendResult(this.sdsHandlerService.isSDSPaused() ? 3002 : 3000);
            return;
        }
        this.logger.log(10000000, "%1#execute: Requesting audio connections and waiting for them to start!", (Object)this.getName());
        this.audioHandler.requestSDSAudioConnections();
    }

    public void responseRequestAudioConnections(boolean bl) {
        this.logger.log(10000000, "%1#responseRequestAudioConnections: ok=%2, dialog is now active!", (Object)this.getName(), (Object)String.valueOf(bl));
        this.sdsManager.setSDSActive(true);
        this.sdsManager.notifyExternalListenersSessionStarted();
        boolean bl2 = this.sdsHandlerService.isSDSPaused();
        if (this.popupHelper != null) {
            this.popupHelper.removeFurtherCommandDisplay();
        }
        this.sendResult(bl ? (bl2 ? 3002 : 3000) : (bl2 ? 3003 : 3001));
    }
}

