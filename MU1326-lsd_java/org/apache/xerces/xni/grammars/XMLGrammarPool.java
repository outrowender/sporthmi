/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.grammars;

import org.apache.xerces.xni.grammars.Grammar;
import org.apache.xerces.xni.grammars.XMLGrammarDescription;

public interface XMLGrammarPool {
    default public Grammar[] retrieveInitialGrammarSet(String string) {
    }

    default public void cacheGrammars(String string, Grammar[] grammarArray) {
    }

    default public Grammar retrieveGrammar(XMLGrammarDescription xMLGrammarDescription) {
    }

    default public void lockPool() {
    }

    default public void unlockPool() {
    }

    default public void clear() {
    }
}

