/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class SystemTruffleSetCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;
    private final NaviService naviService;

    public SystemTruffleSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        String string = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0).getText();
        this.logger.log(-2137614336, "%1#execute: Performing IntelliDest query with trufflesString %2!", (Object)this.getName(), (Object)string);
        this.naviService.startTrufflesSearch(string, new String[0]);
        this.sendResult(3000);
    }
}

