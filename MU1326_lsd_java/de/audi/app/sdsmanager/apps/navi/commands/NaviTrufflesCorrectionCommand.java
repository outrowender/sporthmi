/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSTrufflesHistoryHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.speechrec.NBestList;

public class NaviTrufflesCorrectionCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;
    private final SpeechRecognitionHandler speechRecognitionHandler;
    private final NBestStorageAccess nBestStorageAccess;
    private NaviSDSTrufflesHistoryHelper naviTrufflesHistory;

    public NaviTrufflesCorrectionCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, SpeechRecognitionHandler speechRecognitionHandler, NaviService naviService, NBestStorageAccess nBestStorageAccess, NaviSDSTrufflesHistoryHelper naviSDSTrufflesHistoryHelper) {
        super(logChannel, string, sDSHandlerService);
        this.speechRecognitionHandler = speechRecognitionHandler;
        this.nBestStorageAccess = nBestStorageAccess;
        this.naviService = naviService;
        this.naviTrufflesHistory = naviSDSTrufflesHistoryHelper;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called!", (Object)this.getName());
        this.speechRecognitionHandler.deleteLastTrufflesSearchText();
    }

    public void responseDeleteLastTrufflesSearchText(int n, NBestList nBestList) {
        this.logger.log(10000000, "%1#responseDeleteLastTrufflesSearchText: replyCode=%2!", (Object)this.getName(), (long)n);
        if (n != 0) {
            this.sendResult(40001);
            return;
        }
        if (SDSUtils.isEmpty(nBestList)) {
            this.logger.log(10000000, "%1#responseDeleteLastTrufflesSearchText: N-Best list is empty => also clear truffles search history!", (Object)this.getName());
            this.naviTrufflesHistory.clearLastTruffleSearchTexts();
            this.speechRecognitionHandler.clearTrufflesSearchHistory();
            return;
        }
        this.nBestStorageAccess.storeNBestList(nBestList);
        this.sendResult(40000);
    }

    public void responseClearTrufflesSearchHistory(int n) {
        this.logger.log(10000000, "%1#responseClearTrufflesSearchHistory: replyCode=%2!", (Object)this.getName(), (long)n);
        if (n == 0) {
            this.naviService.cancelSDSTrufflesSearch(true);
            this.sendResult(40009);
        } else {
            this.sendResult(40001);
        }
    }
}

