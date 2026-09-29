/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.XSAnnotation;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSTerm;

public interface XSModelGroup
extends XSTerm {
    public static final short COMPOSITOR_SEQUENCE;
    public static final short COMPOSITOR_CHOICE;
    public static final short COMPOSITOR_ALL;

    default public short getCompositor() {
    }

    default public XSObjectList getParticles() {
    }

    default public XSAnnotation getAnnotation() {
    }

    default public XSObjectList getAnnotations() {
    }
}

