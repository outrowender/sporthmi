/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.log.LogChannel;

public class NaviOneshotStoreDataCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandler sdsHandler;
    private NBestStorageAccess nBestStorage;
    private int commandUsecase;

    public NaviOneshotStoreDataCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandler naviSDSHandler, NBestStorageAccess nBestStorageAccess, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandler;
        this.nBestStorage = nBestStorageAccess;
        this.commandUsecase = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        byte by = this.sdsHandler.getPickListMode();
        this.logger.log(-2137614336, "[%1#execute] current picklist commandUsecase=%2, picklistMode=%3!", (Object)this.getName(), (long)this.commandUsecase, (long)by);
        if (this.commandUsecase == 1) {
            this.handlePOICorrection();
            return;
        }
        if (this.commandUsecase == 0) {
            if (NaviSDSUtils.isOneshotPickListMode(by) || NaviSDSUtils.isPoiOnshotPickListMode(by)) {
                this.handleOneshot(by);
                return;
            }
            if (by == 33) {
                this.handleCountryAndState();
                return;
            }
            this.logger.log(-2137614336, "[%1#execute] -> no oneshot -> NOP!", (Object)this.getName(), (long)by);
            this.sendResult(1083965440);
            return;
        }
        this.logger.log(-1601830656, "[%1#execute] Unknown command usecase %2!", (Object)this.getName(), (long)this.commandUsecase);
        this.sendResult(1100742656);
    }

    private void handlePOICorrection() {
        this.logger.log(-2137614336, "[%1#handlePOICorrection] called!", (Object)this.getName());
        IPicklistSlot iPicklistSlot = SDSUtils.getSelectedSlot(this.nBestStorage, this.logger, 0);
        if (iPicklistSlot == null) {
            this.logger.log(10000, "[%1#handlePOICorrection] empty slot!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        NaviService$OneshotData naviService$OneshotData = new NaviService$OneshotData(iPicklistSlot.getText(), iPicklistSlot.getObjectStringID(), iPicklistSlot.getObjID());
        this.sdsHandler.setOneshotData(naviService$OneshotData, (byte)0);
        SDSModelAccess.setOneshotPoiLabel(iPicklistSlot.getText());
        this.sendResult(1083965440);
    }

    private void handleOneshot(byte by) {
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        if (naviOneshotHandler != null) {
            this.handleOneshotViaHandler(by);
            return;
        }
        byte by2 = SDSUtils.translate(by, NaviSDSUtils.oneshotListModeToDataLevel);
        this.logger.log(-2137614336, "[%1#handleOneshot] for picklist commandUsecase %2, column %3!", (Object)this.getName(), (long)by, (long)by2);
        IPicklistSlot iPicklistSlot = this.nBestStorage.getSlotForPicklistElement(0, 0, (byte)0, true);
        this.logger.log(-2137614336, "[%1#handleOneshot] picklist slot %2!", (Object)this.getName(), (Object)iPicklistSlot);
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)2);
        this.logger.log(-2137614336, "[%1#handleOneshot] picklist %2!", (Object)this.getName(), (Object)iPicklist);
        String[] stringArray = this.sdsHandler.getOneshotFilterStrings(by2);
        this.logger.log(-2137614336, "[%1#handleOneshot] filterStrings %2!", (Object)this.getName(), (Object)stringArray);
        NaviService$OneshotData naviService$OneshotData = SDSUtils.matchSlotToOneshotPicklist(iPicklistSlot, iPicklist, stringArray, by2, this.logger);
        if (naviService$OneshotData == null) {
            this.logger.log(-1601830656, "[%1#handleOneshot] empty oneshot data -> sending invalid!", (Object)this.getName());
            this.sendResult(1184628736);
            return;
        }
        this.logger.log(-2137614336, "[%1#handleOneshot] store oneshot data -> %2!", (Object)this.getName(), (Object)naviService$OneshotData);
        this.sdsHandler.setOneshotData(naviService$OneshotData, by2);
        SDSModelAccess.setSlotModel(by2 + 1, naviService$OneshotData.getText());
        SDSModelAccess.setSlotModelStringID(by2 + 1, naviService$OneshotData.getStringId());
        SDSModelAccess.setListLineDataGetModel(naviService$OneshotData.getText());
        this.sendResult(1083965440);
    }

    private void handleOneshotViaHandler(byte by) {
        byte by2 = SDSUtils.translate(by, NaviSDSUtils.oneshotListModeToDataLevel);
        this.logger.log(-2137614336, "[%1#handleOneshotViaHandler] for picklist commandUsecase %2, column %3!", (Object)this.getName(), (long)by, (long)by2);
        IPicklistSlot iPicklistSlot = this.nBestStorage.getSlotForPicklistElement(0, 0, (byte)0, true);
        this.logger.log(-2137614336, "[%1#handleOneshotViaHandler] picklist slot %2!", (Object)this.getName(), (Object)iPicklistSlot);
        NaviService$OneshotData naviService$OneshotData = this.sdsHandler.getOneshotHandler().matchSlotToOneshotPicklist(iPicklistSlot, by);
        if (naviService$OneshotData == null) {
            this.logger.log(-1601830656, "[%1#handleOneshotViaHandler] empty oneshot data -> sending invalid!", (Object)this.getName());
            this.sendResult(1184628736);
            return;
        }
        SDSModelAccess.setSlotModel(by2 + 1, naviService$OneshotData.getText());
        SDSModelAccess.setSlotModelStringID(by2 + 1, naviService$OneshotData.getStringId());
        SDSModelAccess.setListLineDataGetModel(naviService$OneshotData.getText());
        this.sendResult(1083965440);
    }

    private void handleCountryAndState() {
        IPicklistSlot iPicklistSlot = this.nBestStorage.getSlotForPicklistElement(0, 0, (byte)0, true);
        int n = iPicklistSlot.getIndex();
        this.nBestStorage.resetPicklistsWithHistory();
        this.nBestStorage.setLastRecogLine(false, n);
        this.sendResult(1083965440);
    }
}

