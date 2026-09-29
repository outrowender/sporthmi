/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class NaviPOIOnlineUniqueResultCommand
extends AbstractSystemCallCommand {
    private final HMIService hmiService;

    public NaviPOIOnlineUniqueResultCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
    }

    @Override
    public void execute() {
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(-2137614336, "%1.execute: Setting line nr. %2 with generic answers for OK/INVALID/ERROR!", (Object)this.getName(), 1L);
        this.hmiService.fireSDSEvent(0, 5, 1, nArray);
        this.processingFinished();
    }
}

