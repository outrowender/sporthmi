/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSPicklistHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class MediaG2POneshotIsAmbiguousCommand
extends AbstractSystemCallCommand {
    protected final NBestStorageAccess nBestStorage;
    protected MediaSDSPicklistHandler picklistHandler;
    protected final int sortOrder;
    protected static final int MEDIA_ORDER_SWAP;
    private final MediaSDSHandler mediaSDSHandler;

    public MediaG2POneshotIsAmbiguousCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NBestStorageAccess nBestStorageAccess, MediaSDSPicklistHandler mediaSDSPicklistHandler, MediaSDSHandler mediaSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.picklistHandler = mediaSDSPicklistHandler;
        this.sortOrder = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.mediaSDSHandler = mediaSDSHandler;
    }

    @Override
    public void execute() {
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)2);
        if (iPicklist == null) {
            this.sendResult(20001);
            return;
        }
        if (this.checkSwapCondition(iPicklist)) {
            iPicklist = this.swapSlots(iPicklist);
        }
        int n = iPicklist.getSize();
        this.logger.log(-2137614336, "%1#execute: lastRecogSize=%2", (Object)this.getName(), (long)n);
        if (n == 1) {
            this.handleUniqueRecognition(iPicklist);
            return;
        }
        if (n > 1) {
            this.logger.log(-2137614336, "%1#execute: Ambiguous oneshot recognition!", (Object)this.getName());
            this.sendResult(20013);
            return;
        }
        this.logger.log(-1601830656, "%1#execute: Unhandled lastRecogSize %2!", (Object)this.getName(), (long)n);
        this.sendResult(20001);
    }

    protected void handleUniqueRecognition(IPicklist iPicklist) {
        OneshotHandler oneshotHandler = this.mediaSDSHandler.getOneshotHandler();
        if (oneshotHandler != null) {
            if (iPicklist == null || iPicklist.getSize() <= 0) {
                this.logger.log(-1601830656, "%1#handleUniqueRecognitionMedia: Empty picklist or picklist to small!", (Object)this.getName());
                this.sendResult(20001);
                return;
            }
            IPicklistElement iPicklistElement = iPicklist.get(0);
            if (iPicklistElement == null) {
                this.logger.log(-1601830656, "%1#handleUniqueRecognitionMedia: Empty picklistElement!", (Object)this.getName());
                this.sendResult(20001);
                return;
            }
            oneshotHandler.setOneshotData(iPicklistElement.getSlots());
            this.sendResult(oneshotHandler.determineCorrectOneshotEvent());
        } else {
            this.logger.log(-1601830656, "%1#handleUniqueRecognitionMedia: oneshot handler is null!", (Object)this.getName());
            this.sendResult(20001);
        }
    }

    protected IPicklist swapSlots(IPicklist iPicklist) {
        int n = iPicklist.getSize();
        IPicklistElement iPicklistElement = iPicklist.get(0);
        int n2 = iPicklistElement != null ? iPicklistElement.getSlots().length : 0;
        for (int i2 = 0; i2 < n; ++i2) {
            IPicklistSlot iPicklistSlot = iPicklist.getSlot(i2, 0);
            IPicklistSlot iPicklistSlot2 = iPicklist.getSlot(i2, 1);
            IPicklistSlot iPicklistSlot3 = iPicklist.getSlot(i2, 2);
            IPicklistSlot[] iPicklistSlotArray = n2 == 2 ? new IPicklistSlot[]{iPicklistSlot2, iPicklistSlot} : new IPicklistSlot[]{iPicklistSlot3, iPicklistSlot2, iPicklistSlot};
            iPicklist.get(i2).setSlots(iPicklistSlotArray);
        }
        this.nBestStorage.getPicklistHelper().setMatchingPicklist(iPicklist, 2);
        return iPicklist;
    }

    protected boolean checkSwapCondition(IPicklist iPicklist) {
        return this.sortOrder == 1;
    }
}

