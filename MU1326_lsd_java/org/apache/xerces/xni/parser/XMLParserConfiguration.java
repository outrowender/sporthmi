/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import java.util.Locale;
import org.apache.xerces.xni.XMLDTDContentModelHandler;
import org.apache.xerces.xni.XMLDTDHandler;
import org.apache.xerces.xni.XMLDocumentHandler;
import org.apache.xerces.xni.parser.XMLComponentManager;
import org.apache.xerces.xni.parser.XMLEntityResolver;
import org.apache.xerces.xni.parser.XMLErrorHandler;
import org.apache.xerces.xni.parser.XMLInputSource;

public interface XMLParserConfiguration
extends XMLComponentManager {
    default public void parse(XMLInputSource xMLInputSource) {
    }

    default public void addRecognizedFeatures(String[] stringArray) {
    }

    default public void setFeature(String string, boolean bl) {
    }

    @Override
    default public boolean getFeature(String string) {
    }

    default public void addRecognizedProperties(String[] stringArray) {
    }

    default public void setProperty(String string, Object object) {
    }

    @Override
    default public Object getProperty(String string) {
    }

    default public void setErrorHandler(XMLErrorHandler xMLErrorHandler) {
    }

    default public XMLErrorHandler getErrorHandler() {
    }

    default public void setDocumentHandler(XMLDocumentHandler xMLDocumentHandler) {
    }

    default public XMLDocumentHandler getDocumentHandler() {
    }

    default public void setDTDHandler(XMLDTDHandler xMLDTDHandler) {
    }

    default public XMLDTDHandler getDTDHandler() {
    }

    default public void setDTDContentModelHandler(XMLDTDContentModelHandler xMLDTDContentModelHandler) {
    }

    default public XMLDTDContentModelHandler getDTDContentModelHandler() {
    }

    default public void setEntityResolver(XMLEntityResolver xMLEntityResolver) {
    }

    default public XMLEntityResolver getEntityResolver() {
    }

    default public void setLocale(Locale locale) {
    }

    default public Locale getLocale() {
    }
}

