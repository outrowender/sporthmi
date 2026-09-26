/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.XMLResourceIdentifier;
import org.apache.xerces.xni.parser.XMLInputSource;

public interface XMLEntityResolver {
    default public XMLInputSource resolveEntity(XMLResourceIdentifier xMLResourceIdentifier) {
    }
}

