/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSAnnotation;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSTerm;

public interface XSWildcard
extends XSTerm {
    public static final short NSCONSTRAINT_ANY;
    public static final short NSCONSTRAINT_NOT;
    public static final short NSCONSTRAINT_LIST;
    public static final short PC_STRICT;
    public static final short PC_SKIP;
    public static final short PC_LAX;

    default public short getConstraintType() {
    }

    default public StringList getNsConstraintList() {
    }

    default public short getProcessContents() {
    }

    default public XSAnnotation getAnnotation() {
    }

    default public XSObjectList getAnnotations() {
    }
}

