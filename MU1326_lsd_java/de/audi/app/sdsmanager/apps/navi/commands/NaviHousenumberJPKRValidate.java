/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;

public class NaviHousenumberJPKRValidate
extends AbstractSystemCallCommand {
    private NBestStorageAccess nBestStorage;

    public NaviHousenumberJPKRValidate(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
    }

    public void execute() {
        IPicklistSlot iPicklistSlot;
        this.logger.log(1000000, "[%1#execute] started", (Object)this.getName());
        IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
        if (iPicklist.getSize() > 0 && (iPicklistSlot = iPicklist.getSlot(0, 0)) != null && iPicklistSlot.getObjectStringID() != null) {
            if (iPicklistSlot.getObjectStringID().length() != 0) {
                this.sendResult(40000);
                return;
            }
            this.logger.log(1000000, "[%1#execute] objectStringID is empty", (Object)this.getName());
            this.sendResult(40009);
            return;
        }
        this.logger.log(1000000, "[%1#execute] No valid entry found in the picklist", (Object)this.getName());
        this.sendResult(40001);
    }
}

