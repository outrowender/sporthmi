/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSTypeDefinition;

public interface XSSimpleTypeDefinition
extends XSTypeDefinition {
    public static final short VARIETY_ABSENT;
    public static final short VARIETY_ATOMIC;
    public static final short VARIETY_LIST;
    public static final short VARIETY_UNION;
    public static final short FACET_NONE;
    public static final short FACET_LENGTH;
    public static final short FACET_MINLENGTH;
    public static final short FACET_MAXLENGTH;
    public static final short FACET_PATTERN;
    public static final short FACET_WHITESPACE;
    public static final short FACET_MAXINCLUSIVE;
    public static final short FACET_MAXEXCLUSIVE;
    public static final short FACET_MINEXCLUSIVE;
    public static final short FACET_MININCLUSIVE;
    public static final short FACET_TOTALDIGITS;
    public static final short FACET_FRACTIONDIGITS;
    public static final short FACET_ENUMERATION;
    public static final short ORDERED_FALSE;
    public static final short ORDERED_PARTIAL;
    public static final short ORDERED_TOTAL;

    default public short getVariety() {
    }

    default public XSSimpleTypeDefinition getPrimitiveType() {
    }

    default public short getBuiltInKind() {
    }

    default public XSSimpleTypeDefinition getItemType() {
    }

    default public XSObjectList getMemberTypes() {
    }

    default public short getDefinedFacets() {
    }

    default public boolean isDefinedFacet(short s) {
    }

    default public short getFixedFacets() {
    }

    default public boolean isFixedFacet(short s) {
    }

    default public String getLexicalFacetValue(short s) {
    }

    default public StringList getLexicalEnumeration() {
    }

    default public StringList getLexicalPattern() {
    }

    default public short getOrdered() {
    }

    default public boolean getFinite() {
    }

    default public boolean getBounded() {
    }

    default public boolean getNumeric() {
    }

    default public XSObjectList getFacets() {
    }

    default public XSObjectList getMultiValueFacets() {
    }

    default public XSObjectList getAnnotations() {
    }
}

