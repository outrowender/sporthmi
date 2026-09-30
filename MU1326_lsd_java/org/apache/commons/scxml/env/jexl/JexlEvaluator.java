/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env.jexl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.env.jexl.JexlContext;
import org.w3c.dom.Node;

public class JexlEvaluator
implements Evaluator,
Serializable {
    private static final long serialVersionUID = 1L;
    private static final String ERR_CTX_TYPE = "Error evaluating JEXL expression, Context must be a org.apache.commons.jexl.JexlContext";
    private static String inFct = "In(";
    private static String dataFct = "Data(";
    private static String dataFctNode = "DataNode(";
    private static String dataFctNodeList = "DataNodeList(";
    private static String dataAsStringFct = "DataAsString(";
    private static final ExpressionBuilder EXPR_EVAL = new ExpressionBuilder(){

        public Expression build(String string) throws SCXMLExpressionException {
            String string2 = JexlEvaluator.replaceAll(string, inFct, "_builtin.isMember(_ALL_STATES, ", false);
            string2 = JexlEvaluator.replaceAll(string2, dataFct, "_builtin.data(_ALL_NAMESPACES, ", false);
            string2 = JexlEvaluator.replaceCommonBuiltIns(string2);
            try {
                return ExpressionFactory.createExpression(string2);
            }
            catch (Exception exception) {
                throw new SCXMLExpressionException(exception);
            }
        }
    };
    private static final ExpressionBuilder EXPR_EVAL_COND = new ExpressionBuilder(){

        public Expression build(String string) throws SCXMLExpressionException {
            String string2 = JexlEvaluator.replaceAll(string, inFct, "_builtin.isMember(_ALL_STATES, ", false);
            string2 = JexlEvaluator.replaceAll(string2, dataFct, "_builtin.data(_ALL_NAMESPACES, ", false);
            string2 = JexlEvaluator.replaceCommonBuiltIns(string2);
            try {
                return ExpressionFactory.createExpression(string2);
            }
            catch (Exception exception) {
                throw new SCXMLExpressionException(exception);
            }
        }
    };
    private static final ExpressionBuilder EXPR_EVAL_LOCATION = new ExpressionBuilder(){

        public Expression build(String string) throws SCXMLExpressionException {
            String string2 = JexlEvaluator.replaceAll(string, inFct, "_builtin.isMember(_ALL_STATES, ", false);
            string2 = JexlEvaluator.replaceAll(string2, dataFct, "_builtin.dataNode(_ALL_NAMESPACES, ", true);
            string2 = JexlEvaluator.replaceCommonBuiltIns(string2);
            try {
                return ExpressionFactory.createExpression(string2);
            }
            catch (Exception exception) {
                throw new SCXMLExpressionException(exception);
            }
        }
    };
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$org$w3c$dom$Node;

    JexlEvaluator() {
    }

    protected Expression buildExpression(String string, ExpressionBuilder expressionBuilder) throws SCXMLExpressionException {
        return expressionBuilder.build(string);
    }

    public final Object eval(Context context, String string) throws SCXMLExpressionException {
        return this.eval(context, null, string, this.buildExpression(string, EXPR_EVAL));
    }

    private static String replaceCommonBuiltIns(String string) {
        String string2 = JexlEvaluator.replaceAll(string, inFct, "_builtin.isMember(_ALL_STATES, ", false);
        string2 = JexlEvaluator.replaceAll(string2, dataFctNode, "_builtin.dataNode(_ALL_NAMESPACES, ", false);
        string2 = JexlEvaluator.replaceAll(string2, dataFctNodeList, "_builtin.dataNodeList(_ALL_NAMESPACES, ", false);
        string2 = JexlEvaluator.replaceAll(string2, dataAsStringFct, "_builtin.dataAsString(_ALL_NAMESPACES, ", false);
        return string2;
    }

    public final Boolean evalCond(Context context, String string) throws SCXMLExpressionException {
        return (Boolean)this.eval(context, class$java$lang$Boolean == null ? (class$java$lang$Boolean = JexlEvaluator.class$("java.lang.Boolean")) : class$java$lang$Boolean, string, this.buildExpression(string, EXPR_EVAL_COND));
    }

    public final Node evalLocation(Context context, String string) throws SCXMLExpressionException {
        return (Node)this.eval(context, class$org$w3c$dom$Node == null ? (class$org$w3c$dom$Node = JexlEvaluator.class$("org.w3c.dom.Node")) : class$org$w3c$dom$Node, string, this.buildExpression(string, EXPR_EVAL_LOCATION));
    }

    public Context newContext(Context context) {
        return new JexlContext(context);
    }

    protected final Object eval(Context context, Class clazz, String string, Expression expression) throws SCXMLExpressionException {
        if (!(context instanceof JexlContext)) {
            throw new SCXMLExpressionException(ERR_CTX_TYPE);
        }
        if (expression == null) {
            return null;
        }
        JexlContext jexlContext = (JexlContext)context;
        try {
            Object object = expression.evaluate(this.getEffectiveContext(jexlContext));
            if (clazz != null && object != null && !clazz.isAssignableFrom(object.getClass())) {
                throw new SCXMLExpressionException(new StringBuffer().append("expected ").append(clazz.getName()).append(", got ").append(object.getClass().getName()).append(": ").append(string).toString());
            }
            return object;
        }
        catch (Exception exception) {
            throw new SCXMLExpressionException(new StringBuffer().append("eval('").append(string).append("'):").append(exception.getMessage()).toString(), exception);
        }
    }

    private JexlContext getEffectiveContext(JexlContext jexlContext) {
        ArrayList arrayList = new ArrayList();
        for (JexlContext jexlContext2 = jexlContext; jexlContext2 != null; jexlContext2 = (JexlContext)jexlContext2.getParent()) {
            arrayList.add(jexlContext2);
        }
        HashMap hashMap = new HashMap();
        for (int i2 = arrayList.size() - 1; i2 > -1; --i2) {
            hashMap.putAll(((JexlContext)arrayList.get(i2)).getVars());
        }
        return new JexlContext(hashMap);
    }

    static String replaceAll(String string, String string2, String string3, boolean bl) {
        if (string.indexOf(string2) == -1) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer(string);
        int n = 0;
        while ((n = stringBuffer.toString().indexOf(string2, n)) != -1) {
            stringBuffer.replace(n, n + string2.length(), string3);
            if (!bl) continue;
            break;
        }
        return stringBuffer.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static interface ExpressionBuilder {
        public Expression build(String var1) throws SCXMLExpressionException;
    }
}

