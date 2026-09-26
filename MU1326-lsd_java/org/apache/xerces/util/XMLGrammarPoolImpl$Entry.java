/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.xni.grammars.Grammar;
import org.apache.xerces.xni.grammars.XMLGrammarDescription;

public final class XMLGrammarPoolImpl$Entry {
    public int hash;
    public XMLGrammarDescription desc;
    public Grammar grammar;
    public XMLGrammarPoolImpl$Entry next;

    protected XMLGrammarPoolImpl$Entry(int n, XMLGrammarDescription xMLGrammarDescription, Grammar grammar, XMLGrammarPoolImpl$Entry xMLGrammarPoolImpl$Entry) {
        this.hash = n;
        this.desc = xMLGrammarDescription;
        this.grammar = grammar;
        this.next = xMLGrammarPoolImpl$Entry;
    }

    protected void clear() {
        this.desc = null;
        this.grammar = null;
        if (this.next != null) {
            this.next.clear();
            this.next = null;
        }
    }
}

