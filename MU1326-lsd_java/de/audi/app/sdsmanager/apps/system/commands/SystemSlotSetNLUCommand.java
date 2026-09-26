/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;

public class SystemSlotSetNLUCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;

    public SystemSlotSetNLUCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
    }

    @Override
    public void execute() {
        IPicklistSlot iPicklistSlot = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0);
        if (iPicklistSlot == null) {
            this.sendResult(3004);
            return;
        }
        int n = (int)iPicklistSlot.getObjID();
        this.logger.log(-2137614336, "%1#execute: objectID=%2!", (Object)this.getName(), (long)n);
        if (n >= 1 && n <= 6) {
            String string = Integer.toString(n);
            iPicklistSlot.setText(string);
            SDSModelAccess.setSlotModel(1, string);
            this.sendResult(3000);
        } else {
            this.sendResult(3004);
        }
    }
}

