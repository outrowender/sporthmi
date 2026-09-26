/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.grammars;

import java.util.Locale;
import org.apache.xerces.xni.grammars.Grammar;
import org.apache.xerces.xni.parser.XMLEntityResolver;
import org.apache.xerces.xni.parser.XMLErrorHandler;
import org.apache.xerces.xni.parser.XMLInputSource;

public interface XMLGrammarLoader {
    default public String[] getRecognizedFeatures() {
    }

    default public boolean getFeature(String string) {
    }

    default public void setFeature(String string, boolean bl) {
    }

    default public String[] getRecognizedProperties() {
    }

    default public Object getProperty(String string) {
    }

    default public void setProperty(String string, Object object) {
    }

    default public void setLocale(Locale locale) {
    }

    default public Locale getLocale() {
    }

    default public void setErrorHandler(XMLErrorHandler xMLErrorHandler) {
    }

    default public XMLErrorHandler getErrorHandler() {
    }

    default public void setEntityResolver(XMLEntityResolver xMLEntityResolver) {
    }

    default public XMLEntityResolver getEntityResolver() {
    }

    default public Grammar loadGrammar(XMLInputSource xMLInputSource) {
    }
}

