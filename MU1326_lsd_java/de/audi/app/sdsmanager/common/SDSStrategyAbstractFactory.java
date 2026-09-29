/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.app.sdsmanager.grammar.ISDSGrammarStateStrategy;
import de.audi.app.sdsmanager.grammar.SDSGrammarStateStrategy;
import org.dsi.ifc.speechrec.GrammarStateInfo;

public class SDSStrategyAbstractFactory {
    public ISDSGrammarStateStrategy createSdsGrammarStateStrategy(GrammarStateInfo grammarStateInfo) {
        return new SDSGrammarStateStrategy(grammarStateInfo);
    }
}

