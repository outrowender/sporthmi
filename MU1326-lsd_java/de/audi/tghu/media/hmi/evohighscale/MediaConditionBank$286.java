/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.media.hmi.evohighscale.MediaConditionBank;
import de.audi.tghu.media.hmi.evohighscale.MediaScreenFactory;

class MediaConditionBank$286
extends AbstractCondition {
    private final /* synthetic */ MediaConditionBank this$0;

    MediaConditionBank$286(MediaConditionBank mediaConditionBank) {
        this.this$0 = mediaConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3939, 5572, 1359938304, 1376715520, -1525677312};
    }

    @Override
    public boolean evaluate(int n) {
        return MediaScreenFactory.evalCond205913(n);
    }
}

