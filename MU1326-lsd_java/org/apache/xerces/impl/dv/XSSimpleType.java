/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

import org.apache.xerces.impl.dv.ValidatedInfo;
import org.apache.xerces.impl.dv.ValidationContext;
import org.apache.xerces.impl.dv.XSFacets;
import org.apache.xerces.xs.XSSimpleTypeDefinition;

public interface XSSimpleType
extends XSSimpleTypeDefinition {
    public static final short WS_PRESERVE;
    public static final short WS_REPLACE;
    public static final short WS_COLLAPSE;
    public static final short PRIMITIVE_STRING;
    public static final short PRIMITIVE_BOOLEAN;
    public static final short PRIMITIVE_DECIMAL;
    public static final short PRIMITIVE_FLOAT;
    public static final short PRIMITIVE_DOUBLE;
    public static final short PRIMITIVE_DURATION;
    public static final short PRIMITIVE_DATETIME;
    public static final short PRIMITIVE_TIME;
    public static final short PRIMITIVE_DATE;
    public static final short PRIMITIVE_GYEARMONTH;
    public static final short PRIMITIVE_GYEAR;
    public static final short PRIMITIVE_GMONTHDAY;
    public static final short PRIMITIVE_GDAY;
    public static final short PRIMITIVE_GMONTH;
    public static final short PRIMITIVE_HEXBINARY;
    public static final short PRIMITIVE_BASE64BINARY;
    public static final short PRIMITIVE_ANYURI;
    public static final short PRIMITIVE_QNAME;
    public static final short PRIMITIVE_PRECISIONDECIMAL;
    public static final short PRIMITIVE_NOTATION;

    default public short getPrimitiveKind() {
    }

    default public Object validate(String string, ValidationContext validationContext, ValidatedInfo validatedInfo) {
    }

    default public Object validate(Object object, ValidationContext validationContext, ValidatedInfo validatedInfo) {
    }

    default public void validate(ValidationContext validationContext, ValidatedInfo validatedInfo) {
    }

    default public void applyFacets(XSFacets xSFacets, short s, short s2, ValidationContext validationContext) {
    }

    default public boolean isEqual(Object object, Object object2) {
    }

    default public boolean isIDType() {
    }

    default public short getWhitespace() {
    }
}

