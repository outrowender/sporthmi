/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.AppInfoKrService;
import de.audi.atip.log.LogChannel;

public class NaviSimpleMapAreaSetCommand
extends AbstractSystemCallCommand {
    private AppInfoKrService appInfoKrService;
    private NBestStorageAccess nbestStorage;

    public NaviSimpleMapAreaSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, AppInfoKrService appInfoKrService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.appInfoKrService = appInfoKrService;
        this.nbestStorage = nBestStorageAccess;
    }

    @Override
    public void execute() {
        this.appInfoKrService.refreshSpeakableSimpleMaps();
    }

    public void responseRefreshSpeakableSimpleMaps(int n) {
        if (n != 0) {
            this.sendResult(1100742656);
            this.logger.log(1078071040, "%1#responseRefreshSpeakableSimpleMaps: response=%2", (Object)this.getName(), (long)n);
            return;
        }
        IPicklist iPicklist = this.nbestStorage.getMatchingPicklist((byte)0);
        int n2 = iPicklist.getSize();
        int[] nArray = new int[n2];
        String[] stringArray = new String[n2];
        if (n2 == 0) {
            this.sendResult(1100742656);
            return;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            IPicklistSlot iPicklistSlot = iPicklist.getSlot(i2, 0);
            nArray[i2] = iPicklistSlot.getIndex();
            stringArray[i2] = iPicklistSlot.getText();
        }
        this.logger.log(1078071040, "%1#execute: index=%2 text=%3", (Object)this.getName(), (Object)Integer.toString(nArray[0]), (Object)stringArray[0]);
        SDSModelAccess.setOneshotStreetLabel(stringArray[0]);
        this.appInfoKrService.showSimpleMaps(stringArray, nArray);
    }

    public void responseSimpleMapAreaSet(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1083965440;
                break;
            }
            case 2: {
                n2 = 1251737600;
                break;
            }
            default: {
                n2 = 1100742656;
            }
        }
        this.logger.log(1078071040, "%1#responseSimpleMapAreaSet: response=%2", (Object)this.getName(), (long)n2);
        this.sendResult(n2);
    }
}

