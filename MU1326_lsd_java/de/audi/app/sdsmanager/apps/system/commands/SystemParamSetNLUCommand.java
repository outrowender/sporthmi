/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemParamSetNLUCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;
    private final int slotIndex;

    public SystemParamSetNLUCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.slotIndex = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: slotIndex=%2", (Object)this.getName(), (long)this.slotIndex);
        SDSModelAccess.setTagModel(0);
        int n = (int)this.nBestStorage.getSlotObjID(this.slotIndex, 0);
        this.logger.log(10000000, "%1#execute: objectID=%2!", (Object)this.getName(), (long)n);
        if (n >= 1 && n <= 8) {
            SDSModelAccess.setTagModel(n);
        }
        this.nBestStorage.filterPicklistDuplicates();
        this.sendResult(3000);
    }
}

