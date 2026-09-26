/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env.jexl;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.jexl.Expression;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.env.jexl.JexlEvaluator;
import org.apache.commons.scxml.env.jexl.JexlEvaluator$ExpressionBuilder;

public class CachingJexlEvaluator
extends JexlEvaluator {
    private static final long serialVersionUID;
    private static final Map expressionCache;
    private static final int LRU_SIZE;
    private static final LinkedList lru;
    private final Log log = LogFactory.getLog(class$org$apache$commons$scxml$env$jexl$CachingJexlEvaluator == null ? (class$org$apache$commons$scxml$env$jexl$CachingJexlEvaluator = CachingJexlEvaluator.class$("org.apache.commons.scxml.env.jexl.CachingJexlEvaluator")) : class$org$apache$commons$scxml$env$jexl$CachingJexlEvaluator);
    static /* synthetic */ Class class$org$apache$commons$scxml$env$jexl$CachingJexlEvaluator;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Expression buildExpression(String string, JexlEvaluator$ExpressionBuilder jexlEvaluator$ExpressionBuilder) {
        if (string == null) {
            return null;
        }
        Map map = expressionCache;
        synchronized (map) {
            lru.remove(string);
            lru.addFirst(string);
            while (lru.size() > 64) {
                lru.removeLast();
            }
            Expression expression = null;
            SoftReference softReference = (SoftReference)expressionCache.get(string);
            if (softReference != null) {
                expression = (Expression)softReference.get();
                if (expression != null) {
                    return expression;
                }
            } else if (this.log.isDebugEnabled()) {
                this.log.debug(string);
            }
            expression = jexlEvaluator$ExpressionBuilder.build(string);
            expressionCache.put(string, new SoftReference(expression));
            return expression;
        }
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
        expressionCache = Collections.synchronizedMap(new WeakHashMap());
        lru = new LinkedList();
    }
}

