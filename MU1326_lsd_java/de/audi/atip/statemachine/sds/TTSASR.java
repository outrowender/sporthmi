/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.sds;

import de.audi.atip.statemachine.sds.ITTSASRContext;
import java.util.SortedSet;

public interface TTSASR {
    public static final int GRAMMARTYPE_SRGS_GRAMMAR_STRING = 1;
    public static final int GRAMMARTYPE_LIST_WORD_LIST = 2;
    public static final int GRAMMARTYPE_LIST_ID_REF_LIST = 3;
    public static final int GRAMMARTYPE_PRECOMPILED_ID = 4;
    public static final int GRAMMARTYPE_LIST_SPELLING = 5;
    public static final int GRAMMARTYPE_LAST_NBESTLIST = 6;
    public static final int GRAMMARTYPE_LAST_NBESTLIST_WITH_GRAPHEMIC_GROUP = 7;
    public static final int GRAMMARTYPE_LIST_COMBINED_WORD_ID_LIST = 8;

    public void addToPrompt(String var1);

    public void startPrompt();

    public void stopPrompt();

    public ITTSASRContext createGrammarContext();

    public void setGrammarContext(ITTSASRContext var1);

    public void sdsPopupRemoved();

    public SortedSet getLoadedGrammarIDs();

    public void initializeStateMachine();
}

