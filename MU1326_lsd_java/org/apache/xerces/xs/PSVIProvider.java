/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.AttributePSVI;
import org.apache.xerces.xs.ElementPSVI;

public interface PSVIProvider {
    default public ElementPSVI getElementPSVI() {
    }

    default public AttributePSVI getAttributePSVI(int n) {
    }

    default public AttributePSVI getAttributePSVIByName(String string, String string2) {
    }
}

