/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.XMLDTDContentModelHandler;

public interface XMLDTDContentModelSource {
    default public void setDTDContentModelHandler(XMLDTDContentModelHandler xMLDTDContentModelHandler) {
    }

    default public XMLDTDContentModelHandler getDTDContentModelHandler() {
    }
}

