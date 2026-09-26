/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.media.hmi.evohighscale.MediaConditionBank;
import de.audi.tghu.media.hmi.evohighscale.MediaScreenFactory;

class MediaConditionBank$64
extends AbstractCondition {
    private final /* synthetic */ MediaConditionBank this$0;

    MediaConditionBank$64(MediaConditionBank mediaConditionBank) {
        this.this$0 = mediaConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1693515008, -787545344};
    }

    @Override
    public boolean evaluate(int n) {
        return MediaScreenFactory.evalCond200690(n);
    }
}

