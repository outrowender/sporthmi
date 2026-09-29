/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSLoader;

public interface XSImplementation {
    default public StringList getRecognizedVersions() {
    }

    default public XSLoader createXSLoader(StringList stringList) {
    }
}

