/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.LSInputList;
import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSModel;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.ls.LSInput;

public interface XSLoader {
    default public DOMConfiguration getConfig() {
    }

    default public XSModel loadURIList(StringList stringList) {
    }

    default public XSModel loadInputList(LSInputList lSInputList) {
    }

    default public XSModel loadURI(String string) {
    }

    default public XSModel load(LSInput lSInput) {
    }
}

