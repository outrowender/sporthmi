/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.media.hmi.evohighscale.MediaConditionBank;

class MediaConditionBank$137
extends AbstractCondition {
    private final /* synthetic */ MediaConditionBank this$0;

    MediaConditionBank$137(MediaConditionBank mediaConditionBank) {
        this.this$0 = mediaConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{756024064};
    }

    @Override
    public boolean evaluate(int n) {
        return MediaConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(756024064, n, 1);
    }
}

