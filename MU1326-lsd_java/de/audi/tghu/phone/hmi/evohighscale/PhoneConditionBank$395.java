/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;

class PhoneConditionBank$395
extends AbstractCondition {
    private final /* synthetic */ PhoneConditionBank this$0;

    PhoneConditionBank$395(PhoneConditionBank phoneConditionBank) {
        this.this$0 = phoneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{731382784};
    }

    @Override
    public boolean evaluate(int n) {
        return PhoneConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(731382784, n, 1);
    }
}

