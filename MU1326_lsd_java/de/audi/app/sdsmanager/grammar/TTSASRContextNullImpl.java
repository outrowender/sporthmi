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

    public void addToGrammar(int n, int n2) {
        this.printTraceMessage("addToGrammar(int, int)");
    }

    public void addToGrammar(int n, int[] nArray, int n2) {
        this.printTraceMessage("addToGrammar(int, int[], int)");
    }

    public SortedSet getRuleIds() {
        this.printTraceMessage("getRuleIds");
        return null;
    }

    public SortedSet getSlotIds() {
        this.printTraceMessage("getSlotIds");
        return null;
    }

    public int getRuleIDForNBest() {
        this.printTraceMessage("getRuleIDForNBest");
        return 0;
    }

    public List getRuleIDsForSpelling() {
        this.printTraceMessage("getRuleIDsForSpelling");
        return null;
    }

    public boolean isDynamicListUpdate() {
        this.printTraceMessage("isDynamicListUpdate");
        return false;
    }

    public void addToGrammar(int n, String string) {
        this.printTraceMessage("addToGrammar(int, String)");
    }

    public String getSRGSString(int n) {
        this.printTraceMessage("getSRGSString");
        return null;
    }

    private void printTraceMessage(String string) {
        if (this.lc != null) {
            this.lc.log(1000000, "[TTSASRContextNullImpl#%1]", (Object)string);
        }
    }
}

