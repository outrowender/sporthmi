/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env.jexl;

import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.env.jexl.CachingJexlEvaluator;
import org.apache.commons.scxml.env.jexl.JexlEvaluator;

public class JexlEvaluatorFactory {
    public final boolean cached;

    public JexlEvaluatorFactory(boolean bl) {
        this.cached = bl;
    }

    public Evaluator createEvaluator() {
        return this.cached ? new CachingJexlEvaluator() : new JexlEvaluator();
    }
}

