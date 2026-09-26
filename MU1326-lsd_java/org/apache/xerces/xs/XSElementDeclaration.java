/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.ShortList;
import org.apache.xerces.xs.XSAnnotation;
import org.apache.xerces.xs.XSComplexTypeDefinition;
import org.apache.xerces.xs.XSNamedMap;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSTerm;
import org.apache.xerces.xs.XSTypeDefinition;

public interface XSElementDeclaration
extends XSTerm {
    default public XSTypeDefinition getTypeDefinition() {
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

    default public boolean getNillable() {
    }

    default public XSNamedMap getIdentityConstraints() {
    }

    default public XSElementDeclaration getSubstitutionGroupAffiliation() {
    }

    default public boolean isSubstitutionGroupExclusion(short s) {
    }

    default public short getSubstitutionGroupExclusions() {
    }

    default public boolean isDisallowedSubstitution(short s) {
    }

    default public short getDisallowedSubstitutions() {
    }

    default public boolean getAbstract() {
    }

    default public XSAnnotation getAnnotation() {
    }

    default public XSObjectList getAnnotations() {
    }
}

