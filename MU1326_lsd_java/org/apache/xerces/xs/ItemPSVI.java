/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.ShortList;
import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSSimpleTypeDefinition;
import org.apache.xerces.xs.XSTypeDefinition;

public interface ItemPSVI {
    public static final short VALIDITY_NOTKNOWN;
    public static final short VALIDITY_INVALID;
    public static final short VALIDITY_VALID;
    public static final short VALIDATION_NONE;
    public static final short VALIDATION_PARTIAL;
    public static final short VALIDATION_FULL;

    default public String getValidationContext() {
    }

    default public short getValidity() {
    }

    default public short getValidationAttempted() {
    }

    default public StringList getErrorCodes() {
    }

    default public String getSchemaNormalizedValue() {
    }

    default public Object getActualNormalizedValue() {
    }

    default public short getActualNormalizedValueType() {
    }

    default public ShortList getItemValueTypes() {
    }

    default public XSTypeDefinition getTypeDefinition() {
    }

    default public XSSimpleTypeDefinition getMemberTypeDefinition() {
    }

    default public String getSchemaDefault() {
    }

    default public boolean getIsSchemaSpecified() {
    }
}

