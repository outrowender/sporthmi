/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import java.util.SortedSet;

public interface IDynamicLists {
    public void addToLookup(int var1, DynamicSlotContent var2);

    public void removeFromLookup(int var1);

    public boolean contains(int var1);

    public String[] getDynListStrings(int var1);

    public long[] getDynListIDs(int var1);

    public boolean isSlotContentNew(int var1);

    public void setSlotContentStatus(int var1, byte var2);

    public void markAllSlotsAsLoaded(boolean var1);

    public SortedSet resetLoadedSlotRuleIDs();
}

