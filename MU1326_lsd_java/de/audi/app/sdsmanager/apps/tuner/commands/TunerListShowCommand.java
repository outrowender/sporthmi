/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISDSScreenConnectedUpdatable;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerSDSUtils;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;

public class TunerListShowCommand
extends AbstractSystemCallCommand
implements ISDSScreenConnectedUpdatable {
    private final NBestStorageAccess nBestStorage;
    private final TunerService tunerService;
    private final ISDSPopupHelper popupHelper;
    private final byte listMode;
    private boolean isUniqueResult;
    private HMIService hmi;

    public TunerListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NBestStorageAccess nBestStorageAccess, TunerService tunerService, ISDSPopupHelper iSDSPopupHelper, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.listMode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.nBestStorage = nBestStorageAccess;
        this.tunerService = tunerService;
        this.popupHelper = iSDSPopupHelper;
        this.isUniqueResult = false;
        this.hmi = hMIService;
    }

    public void execute() {
        byte by;
        this.logger.log(10000000, "%1#execute: listMode=%2", (Object)this.getName(), (long)this.listMode);
        this.nBestStorage.resetPicklistsWithHistory();
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        if (this.listMode == 0 || this.listMode == 2) {
            Object[] objectArray = TunerSDSUtils.combineEqualEntries(iPicklist);
            if (objectArray.length == 1) {
                this.logger.log(10000000, "%1#execute: unique entry in picklist", (Object)this.getName());
                this.isUniqueResult = true;
                this.nBestStorage.setLastRecogLine(false, -1);
            }
            this.logger.log(10000000, "%1#execute: entries=%2", (Object)this.getName(), (Object)SDSUtils.toString(objectArray, true));
            by = this.tunerService.fillTunerPickList((TunerService.TunerListEntry[])objectArray);
        } else {
            Object[] objectArray = SDSUtils.createSDSListFromPicklist(iPicklist);
            this.logger.log(10000000, "%1#execute: entries=%2", (Object)this.getName(), (Object)SDSUtils.toString(objectArray, true));
            by = this.tunerService.fillTunerPickList((SDSListEntry[])objectArray);
        }
        this.fillTunerPicklistResult(by);
    }

    private void fillTunerPicklistResult(int n) {
        this.logger.log(10000000, "%1#fillTunerPicklistResult: result=%2!", (Object)this.getName(), (long)n);
        if (n != 1) {
            this.logger.log(100000, "%1#fillTunerPicklistResult: Unhandled result %2, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(10005);
            return;
        }
        if (this.isUniqueResult) {
            this.logger.log(10000000, "%1#fillTunerPicklistResult: Picklist with one entry -> no popup shown!", (Object)this.getName());
            this.sendResult(10009);
            return;
        }
        int n2 = SDSUtils.translate((int)this.listMode, TunerSDSUtils.TUNER_LIST_MODE_TO_POPUP_MAPPING_ID);
        if (n2 == Integer.MIN_VALUE) {
            this.logger.log(100000, "%1#fillTunerPicklistResult: Unhandled listMode %2, sending ERROR!", (Object)this.getName(), (long)this.listMode);
            this.sendResult(10005);
            return;
        }
        SDSModelAccess.setTunerPicklistTitle(this.listMode);
        SDSUtils.unlockPicklistModel(3865, this.hmi, this.logger);
        this.popupHelper.triggerHapticalPopup(n2, true);
    }

    public void updateSDSScreenConnected(int n) {
        this.logger.log(10000000, "%1#updateSDSScreenConnected: screenID=%2", (Object)this.getName(), (long)n);
        this.sendResult(10008);
    }
}

