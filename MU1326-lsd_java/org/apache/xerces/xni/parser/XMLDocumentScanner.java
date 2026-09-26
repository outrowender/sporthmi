/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.parser.XMLDocumentSource;
import org.apache.xerces.xni.parser.XMLInputSource;

public interface XMLDocumentScanner
extends XMLDocumentSource {
    default public void setInputSource(XMLInputSource xMLInputSource) {
    }

    default public boolean scanDocument(boolean bl) {
    }
}

