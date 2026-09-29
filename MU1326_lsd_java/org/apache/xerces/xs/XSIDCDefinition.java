/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;

public interface XSIDCDefinition
extends XSObject {
    public static final short IC_KEY;
    public static final short IC_KEYREF;
    public static final short IC_UNIQUE;

    default public short getCategory() {
    }

    default public String getSelectorStr() {
    }

    default public StringList getFieldStrs() {
    }

    default public XSIDCDefinition getRefKey() {
    }

    default public XSObjectList getAnnotations() {
    }
}

