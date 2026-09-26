/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.XMLResourceIdentifier;

public interface XMLEntityHandler {
    default public void startEntity(String string, XMLResourceIdentifier xMLResourceIdentifier, String string2, Augmentations augmentations) {
    }

    default public void endEntity(String string, Augmentations augmentations) {
    }
}

