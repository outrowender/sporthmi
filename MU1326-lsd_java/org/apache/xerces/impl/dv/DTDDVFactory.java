/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

import java.util.Hashtable;
import org.apache.xerces.impl.dv.DVFactoryException;
import org.apache.xerces.impl.dv.DatatypeValidator;
import org.apache.xerces.impl.dv.ObjectFactory;

public abstract class DTDDVFactory {
    private static final String DEFAULT_FACTORY_CLASS;

    public static final synchronized DTDDVFactory getInstance() {
        return DTDDVFactory.getInstance("org.apache.xerces.impl.dv.dtd.DTDDVFactoryImpl");
    }

    public static final synchronized DTDDVFactory getInstance(String string) {
        try {
            return (DTDDVFactory)ObjectFactory.newInstance(string, ObjectFactory.findClassLoader(), true);
        }
        catch (ClassCastException classCastException) {
            throw new DVFactoryException(new StringBuffer().append("DTD factory class ").append(string).append(" does not extend from DTDDVFactory.").toString());
        }
    }

    protected DTDDVFactory() {
    }

    public abstract DatatypeValidator getBuiltInDV(String string) {
    }

    public abstract Hashtable getBuiltInTypes() {
    }
}

