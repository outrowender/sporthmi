/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.ShortList;
import org.apache.xerces.xs.XSAttributeDeclaration;
import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;

public interface XSAttributeUse
extends XSObject {
    default public boolean getRequired() {
    }

    default public XSAttributeDeclaration getAttrDeclaration() {
    }

    default public short getConstraintType() {
    }

    default public String getConstraintValue() {
    }

    default public Object getActualVC() {
    }

    default public short getActualVCType() {
    }

    default public ShortList getItemValueTypes() {
    }

    default public XSObjectList getAnnotations() {
    }
}

