/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviHouseNumberResolveCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandlerImpl sdsHandler;
    private final NaviService naviService;
    private final NBestStorageAccess nBestStorage;
    private final byte mode;

    public NaviHouseNumberResolveCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService, NaviSDSHandlerImpl naviSDSHandlerImpl, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.naviService = naviService;
        this.nBestStorage = nBestStorageAccess;
        this.mode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] mode=%2", (Object)this.getName(), (long)this.mode);
        if (this.mode == 10) {
            this.resolveOneshotHousenumber();
        } else if (this.mode == 7) {
            this.resolveStepByStepHousenumber();
        } else {
            this.logger.log(10000, "[%1#execute] mode %2 invalid", (Object)this.getName(), (long)this.mode);
            this.sendResult(40001);
        }
    }

    private void resolveOneshotHousenumber() {
        NaviService.OneshotData oneshotData = this.sdsHandler.getOneshotData((byte)2);
        if (oneshotData != null) {
            this.naviService.setHouseNumber(oneshotData.getText(), oneshotData.getStringId());
        } else {
            this.logger.log(10000, "[%1#resolveOneshotHousenumber] oneshot data is null");
            this.sendResult(3001);
        }
    }

    private void resolveStepByStepHousenumber() {
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        for (int i2 = 0; i2 < iPicklist.getSize(); ++i2) {
            IPicklistSlot iPicklistSlot = iPicklist.getSlot(i2, 0);
            if (iPicklistSlot != null && !SDSUtils.isEmpty(iPicklistSlot.getText()) && !SDSUtils.isEmpty(iPicklistSlot.getObjectStringID())) {
                this.logger.log(1000000, "[%1#resolveStepbyStepHousenumber] found valid entry at index %2", (Object)this.getName(), (long)i2);
                this.sdsHandler.setSpokenHouseNumberUnresolved(iPicklistSlot);
                this.naviService.setHouseNumber(iPicklistSlot.getText(), iPicklistSlot.getObjectStringID());
                return;
            }
            if (iPicklistSlot == null || !SDSUtils.isEmpty(iPicklistSlot.getObjectStringID())) continue;
            this.logger.log(1000000, "[%1#resolveStepbyStepHousenumber] found invalid entry at index %2", (Object)this.getName(), (long)i2);
            this.sendResult(40009);
            return;
        }
        this.logger.log(1000000, "[%1#resolveStepbyStepHousenumber] No valid entry found in the picklist", (Object)this.getName());
        IPicklistSlot iPicklistSlot = this.sdsHandler.getSpokenHouseNumberUnresolved();
        if (iPicklistSlot != null) {
            this.logger.log(1000000, "[%1#resolveStepbyStepHousenumber] using the stored house number slot", (Object)this.getName());
            this.naviService.setHouseNumber(iPicklistSlot.getText(), iPicklistSlot.getObjectStringID());
            return;
        }
        this.logger.log(100000, "[%1#resolveStepbyStepHousenumber] no valid entry found", (Object)this.getName());
        this.sendResult(40006);
    }

    public void sdsDestinationSetResult(byte by) {
        this.logger.log(10000000, "[%1#sdsDestinationSetResult] result=%2", (Object)this.getName(), (long)by);
        this.sendResult(by == 0 ? 40000 : 40001);
    }
}

