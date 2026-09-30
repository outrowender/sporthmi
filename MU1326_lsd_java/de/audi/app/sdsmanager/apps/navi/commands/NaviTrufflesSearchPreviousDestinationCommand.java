/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSTrufflesHistoryHelper;
import de.audi.app.sdsmanager.apps.navi.NaviServiceListenerImpl;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesSearchDestinationCommand;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviTrufflesSearchPreviousDestinationCommand
extends NaviTrufflesSearchDestinationCommand {
    public NaviTrufflesSearchPreviousDestinationCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, NBestStorageAccess nBestStorageAccess, NaviServiceListenerImpl naviServiceListenerImpl, NaviSDSTrufflesHistoryHelper naviSDSTrufflesHistoryHelper) {
        super(logChannel, string, sDSHandlerService, naviService, nBestStorageAccess, naviServiceListenerImpl, naviSDSTrufflesHistoryHelper);
    }

    public void execute() {
        String string = this.naviTrufflesHist.getLastTruffleSearchText();
        String[] stringArray = this.naviTrufflesHist.getLastTruffleAlternativeSearchTexts();
        this.logger.log(10000000, "%1#execute: searchText=%2!", (Object)this.getName(), (Object)string);
        this.logger.log(10000000, "%1#execute: alternativeSearchTexts=%2!", (Object)this.getName(), (Object)stringArray);
        this.updateSearchPromptPopupText(string);
        int n = this.naviService.startTrufflesSearch(string, stringArray);
        this.naviServiceListener.setTrufflesSearchQueryID(n);
        this.logger.log(10000000, "%1#execute: startTrufflesSearch started with queryID=%2!", (Object)this.getName(), (long)n);
    }
}

