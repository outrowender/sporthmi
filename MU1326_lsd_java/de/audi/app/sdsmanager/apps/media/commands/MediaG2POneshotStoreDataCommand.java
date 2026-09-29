/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSPicklistHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.log.LogChannel;

public class MediaG2POneshotStoreDataCommand
extends AbstractSystemCallCommand {
    protected final MediaSDSPicklistHandler mediaPicklistHandler;
    protected final NBestStorageAccess nbest;
    protected final MediaSDSHandler mediaSDSHandler;

    public MediaG2POneshotStoreDataCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MediaSDSPicklistHandler mediaSDSPicklistHandler, NBestStorageAccess nBestStorageAccess, MediaSDSHandler mediaSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.mediaPicklistHandler = mediaSDSPicklistHandler;
        this.nbest = nBestStorageAccess;
        this.mediaSDSHandler = mediaSDSHandler;
    }

    @Override
    public void execute() {
        byte by = this.mediaPicklistHandler.getListmode();
        this.logger.log(-2137614336, "[%1#execute] current picklist listMode=%2", (Object)this.getName(), (long)by);
        if (MediaSDSUtils.isOneshotListmode(by)) {
            this.handleOneshot(by);
            return;
        }
        this.sendResult(20000);
    }

    protected void handleOneshot(byte by) {
        this.logger.log(-2137614336, "[%1#handleOneshot] for picklist commandUsecase %2", (Object)this.getName(), (long)by);
        IPicklistSlot iPicklistSlot = this.nbest.getSlotForPicklistElement(0, 0, (byte)0, true);
        this.logger.log(-2137614336, "[%1#handleOneshot] picklist slot %2", (Object)this.getName(), (Object)iPicklistSlot);
        byte by2 = SDSUtils.translate(by, MediaSDSUtils.oneshotListModeToDataLevel);
        this.logger.log(-2137614336, "[%1#handleOneshot] for picklist commandUsecase %2, column %3!", (Object)this.getName(), (long)by, (long)by2);
        OneshotHandler oneshotHandler = this.mediaSDSHandler.getOneshotHandler();
        if (oneshotHandler == null) {
            this.logger.log(-1601830656, "[%1#handleOneshot] oneshot Handler is null", (Object)this.getName());
            this.sendResult(20001);
            return;
        }
        NaviService$OneshotData naviService$OneshotData = oneshotHandler.matchSlotToOneshotPicklist(iPicklistSlot, by);
        if (naviService$OneshotData == null) {
            this.logger.log(-1601830656, "[%1#handleOneshot] empty oneshot data -> sending invalid", (Object)this.getName());
            this.sendResult(20006);
            return;
        }
        SDSModelAccess.setSlotModel(by2 + 1, naviService$OneshotData.getText());
        SDSModelAccess.setSlotModelStringID(by2 + 1, naviService$OneshotData.getStringId());
        SDSModelAccess.setListLineDataGetModel(naviService$OneshotData.getText());
        this.sendResult(20000);
    }
}

