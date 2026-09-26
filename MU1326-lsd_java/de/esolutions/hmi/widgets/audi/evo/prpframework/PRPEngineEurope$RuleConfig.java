/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PRPEngineEurope;

public class PRPEngineEurope$RuleConfig {
    private AbstractPRPRule rule;
    private int ruleId;
    private Object arg;
    private final /* synthetic */ PRPEngineEurope this$0;

    public PRPEngineEurope$RuleConfig(PRPEngineEurope pRPEngineEurope, int n, Object object) {
        this.this$0 = pRPEngineEurope;
        this.ruleId = n;
        this.arg = object;
    }

    public Object getArgument() {
        return this.arg;
    }

    public AbstractPRPRule getRule() {
        if (this.rule == null) {
            this.rule = this.this$0.createRule(this.ruleId);
        }
        return this.rule;
    }

    public int getRuleId() {
        return this.ruleId;
    }

    static /* synthetic */ int access$000(PRPEngineEurope$RuleConfig pRPEngineEurope$RuleConfig) {
        return pRPEngineEurope$RuleConfig.ruleId;
    }
}

