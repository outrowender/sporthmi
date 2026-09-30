/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import java.util.SortedSet;

public interface ISDSGrammarState {
    public SortedSet getCurrentlyLoadedGrammarRuleIDs();

    public void setCurrentlyLoadedGrammarRuleIDs(SortedSet var1);
}

