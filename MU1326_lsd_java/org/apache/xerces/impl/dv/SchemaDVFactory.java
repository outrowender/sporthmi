/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

import org.apache.xerces.impl.dv.DVFactoryException;
import org.apache.xerces.impl.dv.ObjectFactory;
import org.apache.xerces.impl.dv.XSSimpleType;
import org.apache.xerces.util.SymbolHash;
import org.apache.xerces.xs.XSObjectList;

public abstract class SchemaDVFactory {
    private static final String DEFAULT_FACTORY_CLASS;

    public static final synchronized SchemaDVFactory getInstance() {
        return SchemaDVFactory.getInstance("org.apache.xerces.impl.dv.xs.SchemaDVFactoryImpl");
    }

    public static final synchronized SchemaDVFactory getInstance(String string) {
        try {
            return (SchemaDVFactory)ObjectFactory.newInstance(string, ObjectFactory.findClassLoader(), true);
        }
        catch (ClassCastException classCastException) {
            throw new DVFactoryException(new StringBuffer().append("Schema factory class ").append(string).append(" does not extend from SchemaDVFactory.").toString());
        }
    }

    protected SchemaDVFactory() {
    }

    public abstract XSSimpleType getBuiltInType(String string) {
    }

    public abstract SymbolHash getBuiltInTypes() {
    }

    public abstract XSSimpleType createTypeRestriction(String string, String string2, short s, XSSimpleType xSSimpleType, XSObjectList xSObjectList) {
    }

    public abstract XSSimpleType createTypeList(String string, String string2, short s, XSSimpleType xSSimpleType, XSObjectList xSObjectList) {
    }

    public abstract XSSimpleType createTypeUnion(String string, String string2, short s, XSSimpleType[] xSSimpleTypeArray, XSObjectList xSObjectList) {
    }
}

