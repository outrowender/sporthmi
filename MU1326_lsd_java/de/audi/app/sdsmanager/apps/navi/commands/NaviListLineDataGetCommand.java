/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.IJoystickBlock;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

public class NaviListLineDataGetCommand
extends AbstractSystemCallCommand
implements IJoystickBlock {
    private static final byte PICKLIST_HOMOGENEOUS;
    private static final byte PICKLIST_HETEROGENEOUS;
    private static final byte PICKLIST_HETEROGENEOUS_SUI;
    private final byte picklistType;
    private final HMIService hmi;
    private final NaviSDSHandlerImpl sdsHandler;
    private final NBestStorageAccess nBestStorage;

    public NaviListLineDataGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, HMIService hMIService, NaviSDSHandlerImpl naviSDSHandlerImpl, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.hmi = hMIService;
        this.sdsHandler = naviSDSHandlerImpl;
        this.nBestStorage = nBestStorageAccess;
        this.picklistType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        int n;
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(-2137614336, "%1#execute: picklistType=%3, lineNumberStr=%2", (Object)this.getName(), (Object)string, (long)this.picklistType);
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(-1601830656, "%1#execute: Exception for lineNumberStr %2: %3!", (Object)this.getName(), (Object)string, (Object)numberFormatException.getMessage());
            this.sendResult(3001);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: lineNumber=%2", (Object)this.getName(), (long)n);
        if (this.picklistType == 2) {
            this.logger.log(-2137614336, "%1#execute: picklistType=%2, using lineNumber %3 as absolute line!", (Object)this.getName(), (long)this.picklistType, (long)n);
            this.sdsListLineDataGet(n);
            return;
        }
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(-2137614336, "%1#execute: Setting lineNumber %2 with generic answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n);
        this.hmi.fireSDSEvent(1, 5, n, nArray);
    }

    public void sdsListLineDataGet(int n) {
        IPicklistElement iPicklistElement;
        byte by = this.sdsHandler.getPickListMode();
        this.logger.log(-2137614336, "%1#sdsListLineDataGet: absLine=%2 (0-indexed), picklistMode=%3", (Object)this.getName(), (long)n, (long)by);
        if (by == 22) {
            this.logger.log(-2137614336, "%1#sdsListLineDataGet: handleMyAudiSelection in Detailscreen; absLine=%2", (Object)this.getName(), (long)n);
            this.sdsHandlerService.setSelectedRow(n);
            this.sendResult(3000);
            return;
        }
        this.nBestStorage.resetPicklistsWithHistory();
        this.nBestStorage.setLastRecogLine(true, n);
        if (by == 40) {
            this.sendPicklistResult(3000);
            return;
        }
        if (by == 17) {
            if (this.sdsHandler.storePOILineData(n)) {
                this.sendResult(3000);
            } else {
                this.sendResult(3001);
            }
            return;
        }
        if (by == 34) {
            EvoListRow evoListRow = SDSModelAccess.getSDSNaviPicklistBaseList().getRow(n);
            String string = evoListRow != null ? evoListRow.getText(0) : "";
            SDSModelAccess.setOneshotHouseNRLabel(string);
            this.logger.log(-2137614336, "%1#sdsListLineDataGet: House number pattern: %2, just sending OK!", (Object)this.getName(), (Object)string);
            this.sendResult(3000);
            return;
        }
        if (NaviSDSUtils.isPOIPicklistMode(by)) {
            this.logger.log(-2137614336, "%1#sdsListLineDataGet: POI mode active, just sending OK!", (Object)this.getName());
            this.sendResult(3000);
            return;
        }
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        IPicklistElement iPicklistElement2 = by == 27 ? this.nBestStorage.getMatchingPicklist((byte)0).get(n) : (iPicklistElement = !NaviSDSUtils.isOneshotPickListMode(by) || naviOneshotHandler == null ? this.sdsHandler.getEntryPicklist().get(n) : naviOneshotHandler.getCurrentPicklist().get(n));
        if (iPicklistElement == null) {
            this.logger.log(-1601830656, "%1#sdsListLineDataGet: Unhandled absLine %2, sending INVALID!", (Object)this.getName(), (long)n);
            this.sendResult(3004);
            return;
        }
        SDSUtils.storeLineData(iPicklistElement, this.logger);
        if (naviOneshotHandler == null && !NaviSDSUtils.storeOneshotData(this.logger, iPicklistElement, by, this.sdsHandler) || naviOneshotHandler != null && !naviOneshotHandler.setOneshotData(iPicklistElement, (int)by)) {
            this.logger.log(-1601830656, "%1#sdsListLineDataGet: Storing oneshot data failed, sending ERROR!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        if (!this.sdsHandler.storeSUIData(iPicklistElement, true)) {
            this.logger.log(-1601830656, "%1#sdsListLineDataGet: Storing SUI data failed, sending ERROR!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        this.sendPicklistResult(iPicklistElement.getRuleID());
    }

    private void sendPicklistResult(int n) {
        this.logger.log(-2137614336, "%1#sendPicklistResult: ruleID=%2, picklistType=%3", (Object)this.getName(), (long)n, (long)this.picklistType);
        switch (this.picklistType) {
            case 0: {
                this.logger.log(-2137614336, "%1#sendPicklistResult: Homogeneous picklist, just sending OK!", (Object)this.getName());
                this.sendResult(3000);
                break;
            }
            case 1: 
            case 2: {
                this.logger.log(-2137614336, "%1#sendPicklistResult: Heterogeneous picklist, retrieving grammar ID and event from list line!", (Object)this.getName());
                int n2 = SDSManagerBaseActivator.getMapping().getEventIdForRule(n);
                this.logger.log(-2137614336, "%1#sendPicklistResult: Sending result event with ID %2!", (Object)this.getName(), (long)n2);
                this.sdsHandlerService.sendResultEvent(n2, false);
                this.processingFinished();
                break;
            }
            default: {
                this.logger.log(-2137614336, "%1#sendPicklistResult: Unhandled picklistType, sending ERROR!", (Object)this.getName());
                this.sendResult(3001);
            }
        }
    }
}

