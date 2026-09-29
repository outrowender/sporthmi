/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.sds;

import de.audi.atip.statemachine.sds.ITTSASRContext;
import java.util.SortedSet;

public interface TTSASR {
    public static final int GRAMMARTYPE_SRGS_GRAMMAR_STRING;
    public static final int GRAMMARTYPE_LIST_WORD_LIST;
    public static final int GRAMMARTYPE_LIST_ID_REF_LIST;
    public static final int GRAMMARTYPE_PRECOMPILED_ID;
    public static final int GRAMMARTYPE_LIST_SPELLING;
    public static final int GRAMMARTYPE_LAST_NBESTLIST;
    public static final int GRAMMARTYPE_LAST_NBESTLIST_WITH_GRAPHEMIC_GROUP;
    public static final int GRAMMARTYPE_LIST_COMBINED_WORD_ID_LIST;

    default public void addToPrompt(String string) {
    }

    default public void startPrompt() {
    }

    default public void stopPrompt() {
    }

    default public ITTSASRContext createGrammarContext() {
    }

    default public void setGrammarContext(ITTSASRContext iTTSASRContext) {
    }

    default public void sdsPopupRemoved() {
    }

    default public SortedSet getLoadedGrammarIDs() {
    }

    default public void initializeStateMachine() {
    }
}

