/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlExprResolver;
import org.apache.commons.jexl.parser.SimpleNode;

class ExpressionImpl
implements Expression {
    protected List preResolvers;
    protected List postResolvers;
    protected String expression;
    protected SimpleNode node;

    ExpressionImpl(String string, SimpleNode simpleNode) {
        this.expression = string;
        this.node = simpleNode;
    }

    public Object evaluate(JexlContext jexlContext) throws Exception {
        Object object = null;
        if (this.preResolvers != null && (object = this.tryResolver(this.preResolvers, jexlContext)) != JexlExprResolver.NO_VALUE) {
            return object;
        }
        object = this.node.value(jexlContext);
        if (object == null && this.postResolvers != null && (object = this.tryResolver(this.postResolvers, jexlContext)) != JexlExprResolver.NO_VALUE) {
            return object;
        }
        return object;
    }

    protected Object tryResolver(List list, JexlContext jexlContext) {
        Object object = JexlExprResolver.NO_VALUE;
        String string = this.getExpression();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            JexlExprResolver jexlExprResolver = (JexlExprResolver)list.get(i2);
            object = jexlExprResolver.evaluate(jexlContext, string);
            if (object == JexlExprResolver.NO_VALUE) continue;
            return object;
        }
        return object;
    }

    public String getExpression() {
        return this.expression;
    }

    public void addPreResolver(JexlExprResolver jexlExprResolver) {
        if (this.preResolvers == null) {
            this.preResolvers = new ArrayList();
        }
        this.preResolvers.add(jexlExprResolver);
    }

    public void addPostResolver(JexlExprResolver jexlExprResolver) {
        if (this.postResolvers == null) {
            this.postResolvers = new ArrayList();
        }
        this.postResolvers.add(jexlExprResolver);
    }

    public String toString() {
        String string = this.getExpression();
        return string == null ? "" : string;
    }
}

