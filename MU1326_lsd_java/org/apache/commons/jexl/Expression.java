/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlExprResolver;

public interface Expression {
    public Object evaluate(JexlContext var1) throws Exception;

    public String getExpression();

    public void addPreResolver(JexlExprResolver var1);

    public void addPostResolver(JexlExprResolver var1);
}

