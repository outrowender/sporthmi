/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.grammar.ITTSASRAppContext;
import de.audi.atip.log.LogChannel;
import java.util.List;
import java.util.SortedSet;

public class TTSASRContextNullImpl
implements ITTSASRAppContext {
    private LogChannel lc;

    public TTSASRContextNullImpl(LogChannel logChannel) {
        this.lc = logChannel;
    }

    @Override
    public void addToGrammar(int n, int n2) {
        this.printTraceMessage("addToGrammar(int, int)");
    }

    @Override
    public void addToGrammar(int n, int[] nArray, int n2) {
        this.printTraceMessage("addToGrammar(int, int[], int)");
    }

    @Override
    public SortedSet getRuleIds() {
        this.printTraceMessage("getRuleIds");
        return null;
    }

    @Override
    public SortedSet getSlotIds() {
        this.printTraceMessage("getSlotIds");
        return null;
    }

    @Override
    public int getRuleIDForNBest() {
        this.printTraceMessage("getRuleIDForNBest");
        return 0;
    }

    @Override
    public List getRuleIDsForSpelling() {
        this.printTraceMessage("getRuleIDsForSpelling");
        return null;
    }

    @Override
    public boolean isDynamicListUpdate() {
        this.printTraceMessage("isDynamicListUpdate");
        return false;
    }

    @Override
    public void addToGrammar(int n, String string) {
        this.printTraceMessage("addToGrammar(int, String)");
    }

    @Override
    public String getSRGSString(int n) {
        this.printTraceMessage("getSRGSString");
        return null;
    }

    private void printTraceMessage(String string) {
        if (this.lc != null) {
            this.lc.log(1078071040, "[TTSASRContextNullImpl#%1]", (Object)string);
        }
    }
}

