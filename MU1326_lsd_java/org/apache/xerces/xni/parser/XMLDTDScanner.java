/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.parser.XMLDTDContentModelSource;
import org.apache.xerces.xni.parser.XMLDTDSource;
import org.apache.xerces.xni.parser.XMLInputSource;

public interface XMLDTDScanner
extends XMLDTDSource,
XMLDTDContentModelSource {
    default public void setInputSource(XMLInputSource xMLInputSource) {
    }

    default public boolean scanDTDInternalSubset(boolean bl, boolean bl2, boolean bl3) {
    }

    default public boolean scanDTDExternalSubset(boolean bl) {
    }
}

