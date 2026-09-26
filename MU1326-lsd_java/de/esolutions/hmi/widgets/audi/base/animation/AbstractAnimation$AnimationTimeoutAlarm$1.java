/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation$AbstractAnimationStepEvent;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation$AnimationTimeoutAlarm;

class AbstractAnimation$AnimationTimeoutAlarm$1
extends AbstractAnimation$AbstractAnimationStepEvent {
    private final /* synthetic */ AbstractAnimation$AnimationTimeoutAlarm this$1;

    AbstractAnimation$AnimationTimeoutAlarm$1(AbstractAnimation$AnimationTimeoutAlarm abstractAnimation$AnimationTimeoutAlarm, long l) {
        this.this$1 = abstractAnimation$AnimationTimeoutAlarm;
        super(l, null);
    }

    @Override
    public void run() {
        AbstractAnimation$AnimationTimeoutAlarm.access$500(this.this$1).processAnimationStepEvent(true);
    }

    @Override
    public String toString() {
        return "AnimationTimeoutEvent";
    }
}

