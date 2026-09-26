/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.grammars;

import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.grammars.XMLGrammarDescription;

public interface XMLSchemaDescription
extends XMLGrammarDescription {
    public static final short CONTEXT_INCLUDE;
    public static final short CONTEXT_REDEFINE;
    public static final short CONTEXT_IMPORT;
    public static final short CONTEXT_PREPARSE;
    public static final short CONTEXT_INSTANCE;
    public static final short CONTEXT_ELEMENT;
    public static final short CONTEXT_ATTRIBUTE;
    public static final short CONTEXT_XSITYPE;

    default public short getContextType() {
    }

    default public String getTargetNamespace() {
    }

    default public String[] getLocationHints() {
    }

    default public QName getTriggeringComponent() {
    }

    default public QName getEnclosingElementName() {
    }

    default public XMLAttributes getAttributes() {
    }
}

