/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni;

import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.XMLLocator;
import org.apache.xerces.xni.XMLResourceIdentifier;
import org.apache.xerces.xni.XMLString;
import org.apache.xerces.xni.parser.XMLDTDSource;

public interface XMLDTDHandler {
    public static final short CONDITIONAL_INCLUDE;
    public static final short CONDITIONAL_IGNORE;

    default public void startDTD(XMLLocator xMLLocator, Augmentations augmentations) {
    }

    default public void startParameterEntity(String string, XMLResourceIdentifier xMLResourceIdentifier, String string2, Augmentations augmentations) {
    }

    default public void textDecl(String string, String string2, Augmentations augmentations) {
    }

    default public void endParameterEntity(String string, Augmentations augmentations) {
    }

    default public void startExternalSubset(XMLResourceIdentifier xMLResourceIdentifier, Augmentations augmentations) {
    }

    default public void endExternalSubset(Augmentations augmentations) {
    }

    default public void comment(XMLString xMLString, Augmentations augmentations) {
    }

    default public void processingInstruction(String string, XMLString xMLString, Augmentations augmentations) {
    }

    default public void elementDecl(String string, String string2, Augmentations augmentations) {
    }

    default public void startAttlist(String string, Augmentations augmentations) {
    }

    default public void attributeDecl(String string, String string2, String string3, String[] stringArray, String string4, XMLString xMLString, XMLString xMLString2, Augmentations augmentations) {
    }

    default public void endAttlist(Augmentations augmentations) {
    }

    default public void internalEntityDecl(String string, XMLString xMLString, XMLString xMLString2, Augmentations augmentations) {
    }

    default public void externalEntityDecl(String string, XMLResourceIdentifier xMLResourceIdentifier, Augmentations augmentations) {
    }

    default public void unparsedEntityDecl(String string, XMLResourceIdentifier xMLResourceIdentifier, String string2, Augmentations augmentations) {
    }

    default public void notationDecl(String string, XMLResourceIdentifier xMLResourceIdentifier, Augmentations augmentations) {
    }

    default public void startConditional(short s, Augmentations augmentations) {
    }

    default public void ignoredCharacters(XMLString xMLString, Augmentations augmentations) {
    }

    default public void endConditional(Augmentations augmentations) {
    }

    default public void endDTD(Augmentations augmentations) {
    }

    default public void setDTDSource(XMLDTDSource xMLDTDSource) {
    }

    default public XMLDTDSource getDTDSource() {
    }
}

