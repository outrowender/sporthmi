/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviHouseNumberCheckCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandlerImpl sdsHandler;
    private final NBestStorageAccess nBestStorage;

    public NaviHouseNumberCheckCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandlerImpl naviSDSHandlerImpl, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.nBestStorage = nBestStorageAccess;
    }

    public void execute() {
        String string;
        this.logger.log(10000000, "[%1#execute] called", (Object)this.getName());
        boolean bl = false;
        if (NaviSDSUtils.isOneShotActive((byte)SDSModelAccess.getNaviDestinationTypeModel())) {
            String string2;
            NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
            IPicklist iPicklist = naviOneshotHandler == null ? this.sdsHandler.getEntryPicklist() : naviOneshotHandler.getCurrentPicklist();
            this.logger.log(10000000, "[%1#execute] Oneshot case: %2", (Object)this.getName(), (Object)iPicklist.toString());
            bl = NaviHouseNumberCheckCommand.containsEmptySecondHousenumberSlot(iPicklist);
            IPicklistSlot iPicklistSlot = iPicklist.getSlot(0, 0);
            string = iPicklistSlot != null ? iPicklistSlot.getText() : "";
            String string3 = string2 = iPicklistSlot != null ? iPicklistSlot.getObjectStringID() : "";
            if (!bl) {
                this.logger.log(10000000, "%1#execute: Setting housenumber to %2, slot %3", (Object)this.getName(), (Object)string, 3L);
                this.sdsHandler.setOneshotData(new NaviService.OneshotData(string, string2), (byte)2);
                if (naviOneshotHandler != null) {
                    naviOneshotHandler.setOneshotData(iPicklistSlot, 2);
                }
                SDSModelAccess.setSlotModel(3, string);
                SDSModelAccess.setSlotModelStringID(3, string2);
            }
        } else {
            String string4 = this.nBestStorage.getRecognitionText(0);
            IPicklistSlot iPicklistSlot = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0);
            String string5 = iPicklistSlot != null ? iPicklistSlot.getText() : "";
            this.logger.log(10000000, "[%1#execute] Single-slot case, houseNumberRecString=%2, houseNumberSlotRecString=%3!", (Object)this.getName(), (Object)string4, (Object)string5);
            bl = !string4.equals(string5);
            string = string5;
        }
        if (bl) {
            this.logger.log(10000000, "[%1#execute] Ambiguous case, houseNumber=%2!", (Object)this.getName(), (Object)string);
        }
        SDSModelAccess.setListLineDataGetModel(string);
        SDSModelAccess.setNaviHousenrMatchesNewLabelModel(string);
        this.sendResult(bl ? 3005 : 3000);
    }

    private static boolean containsEmptySecondHousenumberSlot(IPicklist iPicklist) {
        IPicklistSlot iPicklistSlot;
        int n = iPicklist.getSize();
        return n == 2 && ((iPicklistSlot = iPicklist.getSlot(1, 0)) == null || SDSUtils.isEmpty(iPicklistSlot.getText()));
    }
}

