/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSTerm;

public interface XSParticle
extends XSObject {
    default public int getMinOccurs() {
    }

    default public int getMaxOccurs() {
    }

    default public boolean getMaxOccursUnbounded() {
    }

    default public XSTerm getTerm() {
    }

    default public XSObjectList getAnnotations() {
    }
}

