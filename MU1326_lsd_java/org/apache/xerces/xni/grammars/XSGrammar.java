/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.grammars;

import org.apache.xerces.xni.grammars.Grammar;
import org.apache.xerces.xs.XSModel;

public interface XSGrammar
extends Grammar {
    default public XSModel toXSModel() {
    }

    default public XSModel toXSModel(XSGrammar[] xSGrammarArray) {
    }
}

