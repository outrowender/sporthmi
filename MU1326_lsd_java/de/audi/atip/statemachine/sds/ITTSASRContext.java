/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.sds;

import java.util.List;
import java.util.SortedSet;

public interface ITTSASRContext {
    public void addToGrammar(int var1, int var2);

    public void addToGrammar(int var1, int[] var2, int var3);

    public SortedSet getRuleIds();

    public SortedSet getSlotIds();

    public int getRuleIDForNBest();

    public List getRuleIDsForSpelling();

    public boolean isDynamicListUpdate();
}

