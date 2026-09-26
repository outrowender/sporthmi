/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaMediumSelectCommand
extends AbstractSystemCallCommand {
    private final byte deviceMode;
    private final NBestStorageAccess nBestStorage;
    private final IMediaSDSService mediaSDSService;
    private final MediaSDSHandler mediaSDSHandler;

    public MediaMediumSelectCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NBestStorageAccess nBestStorageAccess, IMediaSDSService iMediaSDSService, MediaSDSHandler mediaSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.deviceMode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.nBestStorage = nBestStorageAccess;
        this.mediaSDSHandler = mediaSDSHandler;
        this.mediaSDSService = iMediaSDSService;
    }

    @Override
    public void execute() {
        int n;
        IPicklistSlot iPicklistSlot = this.nBestStorage.getSlotForPicklistElement(0, 0, (byte)0, true);
        try {
            n = Integer.parseInt(iPicklistSlot.getText()) - 1;
        }
        catch (NumberFormatException numberFormatException) {
            n = this.getDefaultSlot();
        }
        this.logger.log(-2137614336, "%1#execute: deviceMode=%2, slot=%3", (Object)this.getName(), (long)this.deviceMode, (long)n);
        if (!MediaSDSUtils.isMediaDeviceMode(this.deviceMode)) {
            this.logger.log(-1601830656, "%1#execute: Unhandled deviceMode %2!", (Object)this.getName(), (long)this.deviceMode);
            this.sendResult(20001);
            return;
        }
        int n2 = MediaSDSUtils.getSourceIDForDevice(this.deviceMode);
        this.logger.log(-2137614336, "%1#execute: sourceID=%2!", (Object)this.getName(), (long)n2);
        if (n2 == 128) {
            this.logger.log(-1601830656, "%1#execute: Unhandled deviceMode %2, sending ERROR!", (Object)this.getName(), (long)this.deviceMode);
            this.sendResult(20001);
            return;
        }
        this.mediaSDSHandler.ignoreMediaDeviceChanges();
        this.mediaSDSService.activateSource(n2, n);
    }

    protected int getDefaultSlot() {
        this.logger.log(-2137614336, "%1#getDefaultSlot: No number found in first slot, asssuming 0!", (Object)this.getName());
        return 0;
    }

    public void sendActivationReply(int n) {
        this.logger.log(-2137614336, "[%1#sendActivationReply] state=%2!", (Object)this.getName(), (long)n);
        this.sendResult(MediaSDSUtils.getActivationResponseEvent(n, this.logger));
    }
}

