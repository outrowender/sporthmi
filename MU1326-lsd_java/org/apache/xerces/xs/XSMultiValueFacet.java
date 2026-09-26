/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;

public interface XSMultiValueFacet
extends XSObject {
    default public short getFacetKind() {
    }

    default public StringList getLexicalFacetValues() {
    }

    default public XSObjectList getAnnotations() {
    }
}

