/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.media.hmi.evohighscale.MediaConditionBank;

class MediaConditionBank$94
extends AbstractCondition {
    private final /* synthetic */ MediaConditionBank this$0;

    MediaConditionBank$94(MediaConditionBank mediaConditionBank) {
        this.this$0 = mediaConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{755892992};
    }

    @Override
    public boolean evaluate(int n) {
        return MediaConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(755892992, n, 1);
    }
}

