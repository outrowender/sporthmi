/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.XSObject;

public interface XSAnnotation
extends XSObject {
    public static final short W3C_DOM_ELEMENT;
    public static final short SAX_CONTENTHANDLER;
    public static final short W3C_DOM_DOCUMENT;

    default public boolean writeAnnotation(Object object, short s) {
    }

    default public String getAnnotationString() {
    }
}

