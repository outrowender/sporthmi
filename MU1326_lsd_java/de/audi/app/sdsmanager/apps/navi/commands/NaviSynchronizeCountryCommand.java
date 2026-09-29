/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviSynchronizeCountryCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;
    private final NaviSDSHandler naviHandler;

    public NaviSynchronizeCountryCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandler naviSDSHandler, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.naviHandler = naviSDSHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute", (Object)this.getName());
        this.naviHandler.setPickListMode((byte)-1);
        this.naviService.synchronizeSpeechCountryWithCurrentLD();
    }

    public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte by, boolean bl) {
        this.logger.log(-2137614336, "%1#responseStartDestinationInput: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        if (bl && by == 0 && SDSModelAccess.getDestinationCountrySystemLanguageModel() == 1) {
            this.logger.log(-2137614336, "%1#responseStartDestinationInput: Reloading SUI and Truffles VDE grammars!", (Object)this.getName());
            this.naviHandler.reloadSUIVDERelatedGrammars();
            this.naviHandler.reloadTruffleVDERelatedGrammars();
        } else {
            this.logger.log(-2137614336, "NAVI_SYNCHRONIZECOUNTRY#responseStartDestinationInput: Not reloading SUI and Truffles VDE Grammars, ldc-model=%2, syncNeeded=%1!", bl, (long)SDSModelAccess.getDestinationCountrySystemLanguageModel());
        }
        this.sendResult(n);
    }
}

