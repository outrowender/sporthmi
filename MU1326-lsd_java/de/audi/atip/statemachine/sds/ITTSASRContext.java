/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.sds;

import java.util.List;
import java.util.SortedSet;

public interface ITTSASRContext {
    default public void addToGrammar(int n, int n2) {
    }

    default public void addToGrammar(int n, int[] nArray, int n2) {
    }

    default public SortedSet getRuleIds() {
    }

    default public SortedSet getSlotIds() {
    }

    default public int getRuleIDForNBest() {
    }

    default public List getRuleIDsForSpelling() {
    }

    default public boolean isDynamicListUpdate() {
    }
}

