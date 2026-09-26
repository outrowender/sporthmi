/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.XMLDocumentHandler;

public interface XMLDocumentSource {
    default public void setDocumentHandler(XMLDocumentHandler xMLDocumentHandler) {
    }

    default public XMLDocumentHandler getDocumentHandler() {
    }
}

