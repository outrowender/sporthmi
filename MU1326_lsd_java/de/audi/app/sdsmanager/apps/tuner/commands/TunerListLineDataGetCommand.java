/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.IJoystickBlock;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class TunerListLineDataGetCommand
extends AbstractSystemCallCommand
implements IJoystickBlock {
    private final HMIService hmi;
    private NBestStorageAccess nBestStorage;

    public TunerListLineDataGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.hmi = hMIService;
    }

    public void execute() {
        int n;
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(10000000, "%1#execute: lineNumberStr=%2", (Object)this.getName(), (Object)string);
        try {
            n = Integer.parseInt(string);
        }
        catch (Exception exception) {
            this.logger.log(100000, "%1#execute: Exception for lineNumberStr %2: %3!", (Object)this.getName(), (Object)string, (Object)exception.getMessage());
            this.sendResult(10005);
            return;
        }
        int[] nArray = new int[]{10008, 10006, 10005};
        this.logger.log(10000000, "%1#execute: Setting lineNumber %2 with answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n);
        this.hmi.fireSDSEvent(1, 5, n, nArray);
    }

    public void sdsListLineDataGet(int n) {
        this.logger.log(10000000, "%1#sdsListLineDataGet: absLine=%2 (0-indexed)", (Object)this.getName(), (long)n);
        this.nBestStorage.resetPicklistsWithHistory();
        this.nBestStorage.setLastRecogLine(true, n);
        this.sendResult(10008);
    }
}

