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

    @Override
    public void addToPrompt(String string) {
        this.printTraceMessage("addToPrompt");
    }

    @Override
    public void startPrompt() {
        this.printTraceMessage("startPrompt");
    }

    @Override
    public void stopPrompt() {
        this.printTraceMessage("stopPrompt");
    }

    @Override
    public ITTSASRContext createGrammarContext() {
        this.printTraceMessage("createGrammarContext");
        return new TTSASRContextNullImpl(this.lc);
    }

    @Override
    public void setGrammarContext(ITTSASRContext iTTSASRContext) {
        this.printTraceMessage("setGrammarContext(ITTSASRContext)");
    }

    @Override
    public void sdsPopupRemoved() {
        this.printTraceMessage("sdsPopupRemoved");
    }

    @Override
    public SortedSet getLoadedGrammarIDs() {
        this.printTraceMessage("getLoadedGrammarIDs");
        return null;
    }

    @Override
    public void initializeStateMachine() {
        this.printTraceMessage("initializeStateMachine");
    }

    @Override
    public ITTSASRAppContext createAppGrammarContext() {
        this.printTraceMessage("createAppGrammarContext");
        return null;
    }

    @Override
    public void setCommandListManager(CommandListManager commandListManager) {
        this.printTraceMessage("setCommandListManager");
    }

    @Override
    public void setSlotGrammarContext(ITTSASRContext iTTSASRContext) {
        this.printTraceMessage("setSlotGrammarContext");
    }

    @Override
    public void reloadGrammarContext(ITTSASRContext iTTSASRContext) {
        this.printTraceMessage("reloadGrammarContext");
    }

    private void printTraceMessage(String string) {
        if (this.lc != null) {
            this.lc.log(1078071040, "[TTSASRNullImpl#%1]", (Object)string);
        }
    }
}

