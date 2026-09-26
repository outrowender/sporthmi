/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSParticle;
import org.apache.xerces.xs.XSSimpleTypeDefinition;
import org.apache.xerces.xs.XSTypeDefinition;
import org.apache.xerces.xs.XSWildcard;

public interface XSComplexTypeDefinition
extends XSTypeDefinition {
    public static final short CONTENTTYPE_EMPTY;
    public static final short CONTENTTYPE_SIMPLE;
    public static final short CONTENTTYPE_ELEMENT;
    public static final short CONTENTTYPE_MIXED;

    default public short getDerivationMethod() {
    }

    default public boolean getAbstract() {
    }

    default public XSObjectList getAttributeUses() {
    }

    default public XSWildcard getAttributeWildcard() {
    }

    default public short getContentType() {
    }

    default public XSSimpleTypeDefinition getSimpleType() {
    }

    default public XSParticle getParticle() {
    }

    default public boolean isProhibitedSubstitution(short s) {
    }

    default public short getProhibitedSubstitutions() {
    }

    default public XSObjectList getAnnotations() {
    }
}

