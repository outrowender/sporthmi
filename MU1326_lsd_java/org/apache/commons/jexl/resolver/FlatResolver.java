/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.resolver;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlExprResolver;

public class FlatResolver
implements JexlExprResolver {
    protected boolean noValOnNull = true;

    public FlatResolver() {
    }

    public FlatResolver(boolean bl) {
        this.noValOnNull = bl;
    }

    public Object evaluate(JexlContext jexlContext, String string) {
        Object object = jexlContext.getVars().get(string);
        if (object == null && this.noValOnNull) {
            return JexlExprResolver.NO_VALUE;
        }
        return object;
    }
}

