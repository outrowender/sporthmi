/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.grammars;

import org.apache.xerces.xni.XMLResourceIdentifier;

public interface XMLGrammarDescription
extends XMLResourceIdentifier {
    public static final String XML_SCHEMA;
    public static final String XML_DTD;

    default public String getGrammarType() {
    }
}

