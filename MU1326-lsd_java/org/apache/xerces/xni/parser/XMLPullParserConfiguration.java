/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.parser.XMLInputSource;
import org.apache.xerces.xni.parser.XMLParserConfiguration;

public interface XMLPullParserConfiguration
extends XMLParserConfiguration {
    default public void setInputSource(XMLInputSource xMLInputSource) {
    }

    default public boolean parse(boolean bl) {
    }

    default public void cleanup() {
    }
}

