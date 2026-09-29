/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.ItemPSVI;
import org.apache.xerces.xs.XSElementDeclaration;
import org.apache.xerces.xs.XSModel;
import org.apache.xerces.xs.XSNotationDeclaration;

public interface ElementPSVI
extends ItemPSVI {
    default public XSElementDeclaration getElementDeclaration() {
    }

    default public XSNotationDeclaration getNotation() {
    }

    default public boolean getNil() {
    }

    default public XSModel getSchemaInformation() {
    }
}

