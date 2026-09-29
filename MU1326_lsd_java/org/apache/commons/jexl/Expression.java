/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlExprResolver;

public interface Expression {
    default public Object evaluate(JexlContext jexlContext) {
    }

    default public String getExpression() {
    }

    default public void addPreResolver(JexlExprResolver jexlExprResolver) {
    }

    default public void addPostResolver(JexlExprResolver jexlExprResolver) {
    }
}

