/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.media.hmi.evohighscale.MediaConditionBank;

class MediaConditionBank$81
extends AbstractCondition {
    private final /* synthetic */ MediaConditionBank this$0;

    MediaConditionBank$81(MediaConditionBank mediaConditionBank) {
        this.this$0 = mediaConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{940442368};
    }

    @Override
    public boolean evaluate(int n) {
        return MediaConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(940442368, n, 1);
    }
}

