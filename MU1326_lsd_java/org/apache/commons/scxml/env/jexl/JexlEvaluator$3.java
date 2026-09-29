/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env.jexl;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.env.jexl.JexlEvaluator;
import org.apache.commons.scxml.env.jexl.JexlEvaluator$ExpressionBuilder;

final class JexlEvaluator$3
implements JexlEvaluator$ExpressionBuilder {
    JexlEvaluator$3() {
    }

    @Override
    public Expression build(String string) {
        String string2 = JexlEvaluator.replaceAll(string, JexlEvaluator.access$000(), "_builtin.isMember(_ALL_STATES, ", false);
        string2 = JexlEvaluator.replaceAll(string2, JexlEvaluator.access$100(), "_builtin.dataNode(_ALL_NAMESPACES, ", true);
        string2 = JexlEvaluator.access$200(string2);
        try {
            return ExpressionFactory.createExpression(string2);
        }
        catch (Exception exception) {
            throw new SCXMLExpressionException(exception);
        }
    }
}

