/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSAttributeDeclaration;
import org.apache.xerces.xs.XSAttributeGroupDefinition;
import org.apache.xerces.xs.XSElementDeclaration;
import org.apache.xerces.xs.XSModelGroupDefinition;
import org.apache.xerces.xs.XSNamedMap;
import org.apache.xerces.xs.XSNotationDeclaration;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSTypeDefinition;

public interface XSNamespaceItem {
    default public String getSchemaNamespace() {
    }

    default public XSNamedMap getComponents(short s) {
    }

    default public XSObjectList getAnnotations() {
    }

    default public XSElementDeclaration getElementDeclaration(String string) {
    }

    default public XSAttributeDeclaration getAttributeDeclaration(String string) {
    }

    default public XSTypeDefinition getTypeDefinition(String string) {
    }

    default public XSAttributeGroupDefinition getAttributeGroup(String string) {
    }

    default public XSModelGroupDefinition getModelGroupDefinition(String string) {
    }

    default public XSNotationDeclaration getNotationDeclaration(String string) {
    }

    default public StringList getDocumentLocations() {
    }
}

