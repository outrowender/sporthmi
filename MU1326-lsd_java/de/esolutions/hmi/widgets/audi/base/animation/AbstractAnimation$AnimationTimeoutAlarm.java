/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation$1;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation$AnimationTimeoutAlarm$1;

class AbstractAnimation$AnimationTimeoutAlarm
implements Runnable {
    private final /* synthetic */ AbstractAnimation this$0;

    private AbstractAnimation$AnimationTimeoutAlarm(AbstractAnimation abstractAnimation) {
        this.this$0 = abstractAnimation;
    }

    @Override
    public void run() {
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new AbstractAnimation$AnimationTimeoutAlarm$1(this, 1L), 1L);
    }

    /* synthetic */ AbstractAnimation$AnimationTimeoutAlarm(AbstractAnimation abstractAnimation, AbstractAnimation$1 abstractAnimation$1) {
        this(abstractAnimation);
    }

    static /* synthetic */ AbstractAnimation access$500(AbstractAnimation$AnimationTimeoutAlarm abstractAnimation$AnimationTimeoutAlarm) {
        return abstractAnimation$AnimationTimeoutAlarm.this$0;
    }
}

