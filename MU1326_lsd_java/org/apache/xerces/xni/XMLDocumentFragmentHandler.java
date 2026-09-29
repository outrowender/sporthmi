/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni;

import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.NamespaceContext;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.XMLLocator;
import org.apache.xerces.xni.XMLResourceIdentifier;
import org.apache.xerces.xni.XMLString;

public interface XMLDocumentFragmentHandler {
    default public void startDocumentFragment(XMLLocator xMLLocator, NamespaceContext namespaceContext, Augmentations augmentations) {
    }

    default public void startGeneralEntity(String string, XMLResourceIdentifier xMLResourceIdentifier, String string2, Augmentations augmentations) {
    }

    default public void textDecl(String string, String string2, Augmentations augmentations) {
    }

    default public void endGeneralEntity(String string, Augmentations augmentations) {
    }

    default public void comment(XMLString xMLString, Augmentations augmentations) {
    }

    default public void processingInstruction(String string, XMLString xMLString, Augmentations augmentations) {
    }

    default public void startElement(QName qName, XMLAttributes xMLAttributes, Augmentations augmentations) {
    }

    default public void emptyElement(QName qName, XMLAttributes xMLAttributes, Augmentations augmentations) {
    }

    default public void characters(XMLString xMLString, Augmentations augmentations) {
    }

    default public void ignorableWhitespace(XMLString xMLString, Augmentations augmentations) {
    }

    default public void endElement(QName qName, Augmentations augmentations) {
    }

    default public void startCDATA(Augmentations augmentations) {
    }

    default public void endCDATA(Augmentations augmentations) {
    }

    default public void endDocumentFragment(Augmentations augmentations) {
    }
}

