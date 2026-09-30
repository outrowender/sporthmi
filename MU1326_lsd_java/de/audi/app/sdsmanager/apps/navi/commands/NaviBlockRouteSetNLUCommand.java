/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;
import java.util.StringTokenizer;

public class NaviBlockRouteSetNLUCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;

    public NaviBlockRouteSetNLUCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
    }

    public void execute() {
        IPicklistSlot iPicklistSlot = this.nBestStorage.getSlotForPicklistElement(0, 0, (byte)0, true);
        IPicklistSlot iPicklistSlot2 = this.nBestStorage.getSlotForPicklistElement(1, 0, (byte)0, true);
        String string = iPicklistSlot == null ? "" : iPicklistSlot.getText();
        int n = (int)(iPicklistSlot2 == null ? -1L : iPicklistSlot2.getObjID());
        this.logger.log(10000000, "%1#execute: distance=%2, unit=%3", (Object)this.getName(), (Object)string, (long)n);
        if (SDSUtils.isEmpty(string)) {
            this.handleInvalidSlotValues();
            return;
        }
        switch (n) {
            case 1: {
                SDSModelAccess.setNaviScaleUnits(0);
                break;
            }
            case 2: {
                SDSModelAccess.setNaviScaleUnits(1);
                break;
            }
            case 3: {
                SDSModelAccess.setNaviScaleUnits(2);
                break;
            }
            case 4: {
                SDSModelAccess.setNaviScaleUnits(3);
                break;
            }
            default: {
                this.handleInvalidSlotValues();
                return;
            }
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        string = stringTokenizer.nextToken();
        SDSModelAccess.setSlotModel(1, string);
        this.sendResult(40000);
    }

    private void handleInvalidSlotValues() {
        this.logger.log(10000000, "%1#handleInvalidSlotValues: reset slot label and scale unit model", (Object)this.getName());
        SDSModelAccess.setNaviScaleUnits(-1);
        SDSModelAccess.setSlotModel(1, "");
        this.sendResult(40000);
    }
}

