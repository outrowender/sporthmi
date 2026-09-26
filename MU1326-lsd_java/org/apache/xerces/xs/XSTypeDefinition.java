/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.XSObject;

public interface XSTypeDefinition
extends XSObject {
    public static final short COMPLEX_TYPE;
    public static final short SIMPLE_TYPE;

    default public short getTypeCategory() {
    }

    default public XSTypeDefinition getBaseType() {
    }

    default public boolean isFinal(short s) {
    }

    default public short getFinal() {
    }

    default public boolean getAnonymous() {
    }

    default public boolean derivedFromType(XSTypeDefinition xSTypeDefinition, short s) {
    }

    default public boolean derivedFrom(String string, String string2, short s) {
    }
}

