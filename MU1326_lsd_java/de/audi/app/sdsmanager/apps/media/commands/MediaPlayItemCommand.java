/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.IMediaPlayItemCommand;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaPlayItemCommand
extends AbstractSystemCallCommand
implements IMediaPlayItemCommand {
    private final NBestStorageAccess nBestStorage;
    private final IMediaSDSService mediaSDSService;
    private final int listmode;
    private final boolean lastRecog;
    private MediaSDSHandler mediaSDSHandler;

    public MediaPlayItemCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NBestStorageAccess nBestStorageAccess, IMediaSDSService iMediaSDSService, MediaSDSHandler mediaSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.listmode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.lastRecog = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1) == 0;
        this.nBestStorage = nBestStorageAccess;
        this.mediaSDSService = iMediaSDSService;
        this.mediaSDSHandler = mediaSDSHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] called, listmode %2", (Object)this.getName(), (long)this.listmode);
        long l = 0L;
        l = MediaSDSUtils.isOneshotListmode(this.listmode) ? this.getEntryIDForMultiSlot() : this.getEntryIDForSingleSlot();
        this.logger.log(-2137614336, "[%1#execute] entryID for selection=%2!", (Object)this.getName(), l);
        if (l == 0L) {
            this.sendResult(20001);
            return;
        }
        switch (this.listmode) {
            case 1: 
            case 7: {
                this.mediaSDSService.g2pPlayAlbum(l);
                break;
            }
            case 3: 
            case 6: {
                this.mediaSDSService.g2pPlayTitle(l);
                break;
            }
            case 2: 
            case 5: {
                this.mediaSDSService.g2pPlayArtist(l);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1#execute] unhandled listmode=%2", (Object)this.getName(), (long)this.listmode);
                return;
            }
        }
    }

    private long getEntryIDForSingleSlot() {
        IPicklistSlot iPicklistSlot;
        int n = this.nBestStorage.getLastRecogLine();
        if (n == -1) {
            n = 0;
        }
        if ((iPicklistSlot = this.nBestStorage.getSlotForPicklistElement(0, n, (byte)0, this.lastRecog)) == null) {
            this.logger.log(-1601830656, "[%1#execute] Slot 0 for Picklist-Element at position %2 not found!", (Object)this.getName(), (long)n);
            return 0L;
        }
        return iPicklistSlot.getObjID();
    }

    private long getEntryIDForMultiSlot() {
        NaviService$OneshotData naviService$OneshotData = this.getMediaItemFromOneshot();
        if (naviService$OneshotData == null || naviService$OneshotData.getObjId() == -1L) {
            return 0L;
        }
        this.logger.log(-1601830656, "[%1#getEntryIDForMultiSlot] Selected item: %2 (%3)!", (Object)this.getName(), (Object)naviService$OneshotData.getText(), naviService$OneshotData.getObjId());
        return naviService$OneshotData.getObjId();
    }

    private NaviService$OneshotData getMediaItemFromOneshot() {
        OneshotHandler oneshotHandler = this.mediaSDSHandler.getOneshotHandler();
        NaviService$OneshotData naviService$OneshotData = null;
        for (int i2 = 2; i2 >= 0 && (naviService$OneshotData = oneshotHandler.getOneshotData(i2)).getText().equals(""); --i2) {
        }
        return naviService$OneshotData;
    }

    @Override
    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }

    @Override
    public void playItemResult(byte by) {
        this.logger.log(-2137614336, "[%1#playItemResult] successful=%2", (Object)this.getName(), (long)by);
        this.sendResult(by == 0 ? 20000 : 20001);
    }
}

