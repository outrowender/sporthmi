/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import java.util.SortedSet;

public interface IDynamicLists {
    default public void addToLookup(int n, DynamicSlotContent dynamicSlotContent) {
    }

    default public void removeFromLookup(int n) {
    }

    default public boolean contains(int n) {
    }

    default public String[] getDynListStrings(int n) {
    }

    default public long[] getDynListIDs(int n) {
    }

    default public boolean isSlotContentNew(int n) {
    }

    default public void setSlotContentStatus(int n, byte by) {
    }

    default public void markAllSlotsAsLoaded(boolean bl) {
    }

    default public SortedSet resetLoadedSlotRuleIDs() {
    }
}

