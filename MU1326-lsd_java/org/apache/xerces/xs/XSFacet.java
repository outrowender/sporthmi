/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.XSAnnotation;
import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;

public interface XSFacet
extends XSObject {
    default public short getFacetKind() {
    }

    default public String getLexicalFacetValue() {
    }

    default public boolean getFixed() {
    }

    default public XSAnnotation getAnnotation() {
    }

    default public XSObjectList getAnnotations() {
    }
}

