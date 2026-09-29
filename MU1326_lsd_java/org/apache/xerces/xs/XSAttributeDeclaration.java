/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.ShortList;
import org.apache.xerces.xs.XSAnnotation;
import org.apache.xerces.xs.XSComplexTypeDefinition;
import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSSimpleTypeDefinition;

public interface XSAttributeDeclaration
extends XSObject {
    default public XSSimpleTypeDefinition getTypeDefinition() {
    }

    default public short getScope() {
    }

    default public XSComplexTypeDefinition getEnclosingCTDefinition() {
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

    default public XSAnnotation getAnnotation() {
    }

    default public XSObjectList getAnnotations() {
    }
}

