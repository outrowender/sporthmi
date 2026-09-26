/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.grammar.ISDSGrammarStateStrategy;
import org.dsi.ifc.speechrec.GrammarStateInfo;

public class SDSGrammarStateStrategy
implements ISDSGrammarStateStrategy {
    protected final GrammarStateInfo grammarInfo;

    public SDSGrammarStateStrategy(GrammarStateInfo grammarStateInfo) {
        this.grammarInfo = grammarStateInfo;
    }

    @Override
    public byte getGrammarStatus() {
        if (this.grammarInfo == null) {
            return 0;
        }
        return this.grammarInfo.getGrammarStatus() == 1 || this.grammarInfo.getGrammarStatus() == 4 ? (byte)1 : 0;
    }

    @Override
    public byte getGrammarStatusForMedia() {
        return this.getGrammarStatus();
    }

    @Override
    public boolean isGrammarStatusCompiling() {
        if (this.grammarInfo == null) {
            return false;
        }
        return this.grammarInfo.getGrammarStatus() == 2;
    }
}

