/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.grammar.ITTSASRAppContext;
import de.audi.app.sdsmanager.grammar.TTSASRContextNullImpl;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.tghu.command.CommandListManager;
import java.util.SortedSet;

public class TTSASRNullImpl
implements ITTSASR {
    private LogChannel lc;

    public TTSASRNullImpl(LogChannel logChannel) {
        this.lc = logChannel;
    }

    public void addToPrompt(String string) {
        this.printTraceMessage("addToPrompt");
    }

    public void startPrompt() {
        this.printTraceMessage("startPrompt");
    }

    public void stopPrompt() {
        this.printTraceMessage("stopPrompt");
    }

    public ITTSASRContext createGrammarContext() {
        this.printTraceMessage("createGrammarContext");
        return new TTSASRContextNullImpl(this.lc);
    }

    public void setGrammarContext(ITTSASRContext iTTSASRContext) {
        this.printTraceMessage("setGrammarContext(ITTSASRContext)");
    }

    public void sdsPopupRemoved() {
        this.printTraceMessage("sdsPopupRemoved");
    }

    public SortedSet getLoadedGrammarIDs() {
        this.printTraceMessage("getLoadedGrammarIDs");
        return null;
    }

    public void initializeStateMachine() {
        this.printTraceMessage("initializeStateMachine");
    }

    public ITTSASRAppContext createAppGrammarContext() {
        this.printTraceMessage("createAppGrammarContext");
        return null;
    }

    public void setCommandListManager(CommandListManager commandListManager) {
        this.printTraceMessage("setCommandListManager");
    }

    public void setSlotGrammarContext(ITTSASRContext iTTSASRContext) {
        this.printTraceMessage("setSlotGrammarContext");
    }

    public void reloadGrammarContext(ITTSASRContext iTTSASRContext) {
        this.printTraceMessage("reloadGrammarContext");
    }

    private void printTraceMessage(String string) {
        if (this.lc != null) {
            this.lc.log(1000000, "[TTSASRNullImpl#%1]", (Object)string);
        }
    }
}

