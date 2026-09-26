/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.parser.XMLParseException;

public interface XMLErrorHandler {
    default public void warning(String string, String string2, XMLParseException xMLParseException) {
    }

    default public void error(String string, String string2, XMLParseException xMLParseException) {
    }

    default public void fatalError(String string, String string2, XMLParseException xMLParseException) {
    }
}

