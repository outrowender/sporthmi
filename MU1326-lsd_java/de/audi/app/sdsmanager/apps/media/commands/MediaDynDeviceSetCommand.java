/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaDynDeviceSetCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;
    private final IMediaSDSService mediaService;
    private final int source;
    private final MediaSDSHandler mediaSDSHandler;
    private final SDSListEntry selectedListEntry;

    public MediaDynDeviceSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, IMediaSDSService iMediaSDSService, MediaSDSHandler mediaSDSHandler, ISystemCallParameter[] iSystemCallParameterArray, SDSListEntry sDSListEntry) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.mediaService = iMediaSDSService;
        this.mediaSDSHandler = mediaSDSHandler;
        this.source = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.selectedListEntry = sDSListEntry;
    }

    @Override
    public void execute() {
        long l;
        switch (this.source) {
            case 0: 
            case 1: {
                l = SDSUtils.getSelectedObjectId(this.nBestStorage, this.logger, 0);
                this.logger.log(-2137614336, "%1#execute: slotObjID=%2", (Object)this.getName(), l);
                break;
            }
            case 2: {
                l = this.selectedListEntry.getId();
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: Unhandled source %2!", (Object)this.getName(), (long)this.source);
                this.sendResult(20001);
                return;
            }
        }
        if (l == -1L || l == 0L) {
            this.logger.log(-1601830656, "%1#execute: Invalid slotObjID %2!", (Object)this.getName(), l);
            this.sendResult(20001);
            return;
        }
        int n = SDSUtils.getLowNibble(l);
        int n2 = SDSUtils.getHighNibble(l);
        this.logger.log(-2137614336, "%1#execute: Activating source with sourceID %2 and slotIdx %3!", (Object)this.getName(), (long)n, (long)n2);
        SDSModelAccess.setMediaDynamicDeviceType(n);
        if (n == 13) {
            SDSModelAccess.setListLineDataGetModel(SDSUtils.getSelectedEntryString(this.nBestStorage, this.logger, 0));
        }
        this.mediaSDSHandler.ignoreMediaDeviceChanges();
        this.mediaService.activateSource(n, n2);
    }

    @Override
    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }

    public void sendActivationReply(int n) {
        this.logger.log(-2137614336, "[%1#sendActivationReply] state=%2!", (Object)this.getName(), (long)n);
        this.sendResult(MediaSDSUtils.getActivationResponseEvent(n, this.logger));
    }
}

