/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSTrufflesHistoryHelper;
import de.audi.app.sdsmanager.apps.navi.NaviServiceListenerImpl;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.nbest.NBestUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviTrufflesSearchDestinationCommand
extends AbstractSystemCallCommand {
    protected final NaviService naviService;
    protected final NBestStorageAccess nBestStorage;
    protected final NaviServiceListenerImpl naviServiceListener;
    protected NaviSDSTrufflesHistoryHelper naviTrufflesHist;
    private int searchResults;
    private static final String LINE_ONE;

    public NaviTrufflesSearchDestinationCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, NBestStorageAccess nBestStorageAccess, NaviServiceListenerImpl naviServiceListenerImpl, NaviSDSTrufflesHistoryHelper naviSDSTrufflesHistoryHelper) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.nBestStorage = nBestStorageAccess;
        this.naviServiceListener = naviServiceListenerImpl;
        this.naviTrufflesHist = naviSDSTrufflesHistoryHelper;
        this.searchResults = 0;
    }

    @Override
    public void execute() {
        int n;
        String[] stringArray;
        String string;
        this.logger.log(-2137614336, "%1#execute: called!", (Object)this.getName());
        IPicklistSlot iPicklistSlot = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0);
        if (iPicklistSlot != null) {
            if ("1".equals(iPicklistSlot.getText()) && this.naviService.isTrufflesConflictmodeAvailable()) {
                string = this.naviTrufflesHist.getLastTruffleSearchText();
                stringArray = this.naviTrufflesHist.getLastTruffleAlternativeSearchTexts();
                n = this.naviService.triggerTrufflesConflictmode(string, stringArray);
            } else {
                string = iPicklistSlot.getText();
                stringArray = NBestUtils.getFirstSlotStringsFromRange(this.nBestStorage, this.logger, 1, this.nBestStorage.getPicklistSize((byte)0) - 1);
                this.naviTrufflesHist.setLastTruffleSearchText(string);
                this.naviTrufflesHist.setLastTruffleAlternativeSearchTexts(stringArray);
                n = this.naviService.startTrufflesSearch(string, stringArray);
            }
        } else {
            string = this.naviTrufflesHist.getLastTruffleSearchText();
            stringArray = this.naviTrufflesHist.getLastTruffleAlternativeSearchTexts();
            n = this.naviService.startTrufflesSearch(string, stringArray);
        }
        this.logger.log(-2137614336, "%1#execute: searchText=%2!", (Object)this.getName(), (Object)string);
        this.logger.log(-2137614336, "%1#execute: alternativeSearchTexts=%2!", (Object)this.getName(), (Object)stringArray);
        this.updateSearchPromptPopupText(string);
        this.naviServiceListener.setTrufflesSearchQueryID(n);
        this.logger.log(-2137614336, "%1#execute: startTrufflesSearch started with queryID=%2!", (Object)this.getName(), (long)n);
    }

    protected void updateSearchPromptPopupText(String string) {
        this.logger.log(-2137614336, "%1#execute: searchText=%2!", (Object)this.getName(), (Object)string);
    }

    public void updateResponseStartTrufflesSearch(byte by, int n, boolean bl, int n2) {
        this.logger.log(-2137614336, "%1#updateResponseStartTrufflesSearch: numberOfSearchResults=%2, navDBSearchEnded=%3!", (Object)this.getName(), (long)n, (long)(bl ? 1 : 0));
        this.logger.log(-2137614336, "%1#updateResponseStartTrufflesSearch: queryID=%2", (Object)this.getName(), (long)n2);
        this.searchResults = n;
        if (by == 1) {
            this.logger.log(10000, "%1#updateResponseStartTrufflesSearch: result=%2!", (Object)this.getName(), (long)by);
            this.sendResult(1100742656);
            return;
        }
        if (NaviTrufflesSearchDestinationCommand.enoughSearchResults(n) || bl) {
            this.sendResult(1083965440);
        }
    }

    private static boolean enoughSearchResults(int n) {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            return n >= 1;
        }
        return n >= 2;
    }

    @Override
    public boolean handleTimeout() {
        this.naviService.cancelSDSTrufflesSearch(false);
        this.sendResult(1436286976);
        return true;
    }

    @Override
    public void processingFinished() {
        this.naviServiceListener.setTrufflesSearchQueryID(-1);
        super.processingFinished();
    }

    public int getSearchResults() {
        return this.searchResults;
    }
}

