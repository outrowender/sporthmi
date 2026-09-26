/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.AppInfoKrService;
import de.audi.atip.log.LogChannel;

public class NaviSimpleMapFreeSelectionInitCommand
extends AbstractSystemCallCommand {
    private AppInfoKrService appInfoKrService;

    public NaviSimpleMapFreeSelectionInitCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, AppInfoKrService appInfoKrService) {
        super(logChannel, string, sDSHandlerService);
        this.appInfoKrService = appInfoKrService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: started");
        this.appInfoKrService.startSimpleMapFreeSelection();
    }

    public void responseStartSimpleMapFreeSelection(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1083965440;
                break;
            }
            default: {
                n2 = 1100742656;
            }
        }
        this.logger.log(1078071040, "%1#responseStartSimpleMapFreeSelection: response=%2", (Object)this.getName(), (long)n2);
        this.sendResult(n2);
    }
}

