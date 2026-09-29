/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;

public class SystemSessionStartCommand
extends AbstractSystemCallCommand {
    private final SpeechRecognitionHandler srHandler;
    private final AppSDSManager sdsManager;
    private final NBestStorageAccess nBestStorage;

    public SystemSessionStartCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, AppSDSManager appSDSManager, SpeechRecognitionHandler speechRecognitionHandler, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsManager = appSDSManager;
        this.srHandler = speechRecognitionHandler;
        this.nBestStorage = nBestStorageAccess;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute called", (Object)this.getName());
        boolean bl = this.sdsHandlerService.isSDSPaused();
        if (!bl) {
            this.nBestStorage.resetNBestListHistory();
            this.srHandler.startDialog();
        } else {
            this.logger.log(-1601830656, "%1#execute: SDS paused, NOT starting dialog!", (Object)this.getName());
        }
        if (this.sdsHandlerService.isSDSVolumeSettingActive()) {
            this.logger.log(-2137614336, "%1#execute: Volume setting dialog is active, sending OK!", (Object)this.getName());
            this.sendResult(3000);
            return;
        }
        this.sdsManager.startSession();
        this.sendResult(bl ? 3002 : 3000);
    }
}

