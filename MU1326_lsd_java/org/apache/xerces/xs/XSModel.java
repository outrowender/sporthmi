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
import org.apache.xerces.xs.XSNamespaceItemList;
import org.apache.xerces.xs.XSNotationDeclaration;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSTypeDefinition;

public interface XSModel {
    default public StringList getNamespaces() {
    }

    default public XSNamespaceItemList getNamespaceItems() {
    }

    default public XSNamedMap getComponents(short s) {
    }

    default public XSNamedMap getComponentsByNamespace(short s, String string) {
    }

    default public XSObjectList getAnnotations() {
    }

    default public XSElementDeclaration getElementDeclaration(String string, String string2) {
    }

    default public XSAttributeDeclaration getAttributeDeclaration(String string, String string2) {
    }

    default public XSTypeDefinition getTypeDefinition(String string, String string2) {
    }

    default public XSAttributeGroupDefinition getAttributeGroup(String string, String string2) {
    }

    default public XSModelGroupDefinition getModelGroupDefinition(String string, String string2) {
    }

    default public XSNotationDeclaration getNotationDeclaration(String string, String string2) {
    }

    default public XSObjectList getSubstitutionGroup(XSElementDeclaration xSElementDeclaration) {
    }
}

