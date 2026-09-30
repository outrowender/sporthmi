/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSTrufflesHistoryHelper;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.atip.log.LogChannel;

public class NaviTrufflesEndCommand
extends AbstractSystemCallCommand {
    private SpeechRecognitionHandler recHandler;
    private NaviSDSTrufflesHistoryHelper naviTrufflesHist;

    public NaviTrufflesEndCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, SpeechRecognitionHandler speechRecognitionHandler, NaviSDSTrufflesHistoryHelper naviSDSTrufflesHistoryHelper) {
        super(logChannel, string, sDSHandlerService);
        this.recHandler = speechRecognitionHandler;
        this.naviTrufflesHist = naviSDSTrufflesHistoryHelper;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called!", (Object)this.getName());
        this.naviTrufflesHist.clearLastTruffleSearchTexts();
        this.recHandler.clearTrufflesSearchHistory();
    }

    public void responseClearTrufflesSearchHistory(int n) {
        this.logger.log(10000000, "%1#responseClearTrufflesSearchHistory: replyCode=%2!", (Object)this.getName(), (long)n);
        if (n == 0) {
            this.processingFinished();
        }
    }
}

