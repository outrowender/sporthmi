/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env.jexl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.jexl.Expression;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.env.jexl.JexlContext;
import org.apache.commons.scxml.env.jexl.JexlEvaluator$1;
import org.apache.commons.scxml.env.jexl.JexlEvaluator$2;
import org.apache.commons.scxml.env.jexl.JexlEvaluator$3;
import org.apache.commons.scxml.env.jexl.JexlEvaluator$ExpressionBuilder;
import org.w3c.dom.Node;

public class JexlEvaluator
implements Evaluator,
Serializable {
    private static final long serialVersionUID;
    private static final String ERR_CTX_TYPE;
    private static String inFct;
    private static String dataFct;
    private static String dataFctNode;
    private static String dataFctNodeList;
    private static String dataAsStringFct;
    private static final JexlEvaluator$ExpressionBuilder EXPR_EVAL;
    private static final JexlEvaluator$ExpressionBuilder EXPR_EVAL_COND;
    private static final JexlEvaluator$ExpressionBuilder EXPR_EVAL_LOCATION;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$org$w3c$dom$Node;

    JexlEvaluator() {
    }

    protected Expression buildExpression(String string, JexlEvaluator$ExpressionBuilder jexlEvaluator$ExpressionBuilder) {
        return jexlEvaluator$ExpressionBuilder.build(string);
    }

    @Override
    public final Object eval(Context context, String string) {
        return this.eval(context, null, string, this.buildExpression(string, EXPR_EVAL));
    }

    private static String replaceCommonBuiltIns(String string) {
        String string2 = JexlEvaluator.replaceAll(string, inFct, "_builtin.isMember(_ALL_STATES, ", false);
        string2 = JexlEvaluator.replaceAll(string2, dataFctNode, "_builtin.dataNode(_ALL_NAMESPACES, ", false);
        string2 = JexlEvaluator.replaceAll(string2, dataFctNodeList, "_builtin.dataNodeList(_ALL_NAMESPACES, ", false);
        string2 = JexlEvaluator.replaceAll(string2, dataAsStringFct, "_builtin.dataAsString(_ALL_NAMESPACES, ", false);
        return string2;
    }

    @Override
    public final Boolean evalCond(Context context, String string) {
        return (Boolean)this.eval(context, class$java$lang$Boolean == null ? (class$java$lang$Boolean = JexlEvaluator.class$("java.lang.Boolean")) : class$java$lang$Boolean, string, this.buildExpression(string, EXPR_EVAL_COND));
    }

    @Override
    public final Node evalLocation(Context context, String string) {
        return (Node)this.eval(context, class$org$w3c$dom$Node == null ? (class$org$w3c$dom$Node = JexlEvaluator.class$("org.w3c.dom.Node")) : class$org$w3c$dom$Node, string, this.buildExpression(string, EXPR_EVAL_LOCATION));
    }

    @Override
    public Context newContext(Context context) {
        return new JexlContext(context);
    }

    protected final Object eval(Context context, Class clazz, String string, Expression expression) {
        if (!(context instanceof JexlContext)) {
            throw new SCXMLExpressionException("Error evaluating JEXL expression, Context must be a org.apache.commons.jexl.JexlContext");
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

    static /* synthetic */ String access$000() {
        return inFct;
    }

    static /* synthetic */ String access$100() {
        return dataFct;
    }

    static /* synthetic */ String access$200(String string) {
        return JexlEvaluator.replaceCommonBuiltIns(string);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        inFct = "In(";
        dataFct = "Data(";
        dataFctNode = "DataNode(";
        dataFctNodeList = "DataNodeList(";
        dataAsStringFct = "DataAsString(";
        EXPR_EVAL = new JexlEvaluator$1();
        EXPR_EVAL_COND = new JexlEvaluator$2();
        EXPR_EVAL_LOCATION = new JexlEvaluator$3();
    }
}

