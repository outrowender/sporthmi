/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.XMLDTDHandler;

public interface XMLDTDSource {
    default public void setDTDHandler(XMLDTDHandler xMLDTDHandler) {
    }

    default public XMLDTDHandler getDTDHandler() {
    }
}

