/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISystemSessionEndCommand;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.atip.log.LogChannel;

public class SystemSessionEndCommand
extends AbstractSystemCallCommand
implements ISystemSessionEndCommand {
    private final SpeechRecognitionHandler srHandler;
    private final AppSDSManager sdsManager;
    private final SDSAudioHandler audioHandler;
    private final ISDSPopupHelper popupHelper;

    public SystemSessionEndCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, AppSDSManager appSDSManager, SpeechRecognitionHandler speechRecognitionHandler, SDSAudioHandler sDSAudioHandler, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.sdsManager = appSDSManager;
        this.srHandler = speechRecognitionHandler;
        this.audioHandler = sDSAudioHandler;
        this.popupHelper = iSDSPopupHelper;
    }

    public void execute() {
        boolean bl = this.sdsHandlerService.isSDSPaused();
        this.logger.log(10000000, "%1#execute: sdsPaused=%2", (Object)this.getName(), (Object)bl);
        if (!bl) {
            this.sdsHandlerService.resetSelectedRow();
            this.srHandler.stopDialog();
        } else {
            this.logger.log(100000, "%1#execute: SDS paused, NOT stopping dialog!", (Object)this.getName());
        }
        if (this.sdsHandlerService.isSDSVolumeSettingActive()) {
            this.logger.log(10000000, "%1#execute: Volume setting dialog is ending, returning OK without releasing audio connections!", (Object)this.getName());
            this.sdsManager.endSession();
            if (!bl) {
                this.sdsManager.resetDialogFlags();
            }
            this.sendResult(bl ? 3002 : 3000);
            return;
        }
        this.logger.log(10000000, "%1#execute: Releasing audio connections and waiting for them to stop!", (Object)this.getName());
        this.audioHandler.releaseSDSAudioConnections();
    }

    public void responseReleaseAudioConnections(boolean bl) {
        this.logger.log(10000000, "%1#responseReleaseAudioConnections: ok=%2, ending session!", (Object)this.getName(), (Object)bl);
        boolean bl2 = this.sdsHandlerService.isSDSPaused();
        if (!bl2) {
            this.sdsManager.endSession();
            this.logger.log(10000000, "%1#responseReleaseAudioConnections: SDS not paused, removing logical popup!", (Object)this.getName());
            this.popupHelper.setLogicalPopupRemovedBySDS(true);
            this.popupHelper.triggerHapticalPopup(4, false);
            this.sdsManager.resetDialogFlags();
        }
        this.sendResult(bl ? (bl2 ? 3002 : 3000) : (bl2 ? 3003 : 3001));
    }

    public boolean isSDSEndSequenceCommand() {
        return this.sdsManager.isSDSAborting();
    }

    public boolean isSDSSessionEndCommand() {
        return true;
    }

    public boolean handleTimeout() {
        boolean bl = this.sdsHandlerService.isSDSPaused();
        if (!bl) {
            this.popupHelper.triggerHapticalPopup(4, false);
            this.sdsManager.resetDialogFlags();
        }
        return super.handleTimeout();
    }
}

