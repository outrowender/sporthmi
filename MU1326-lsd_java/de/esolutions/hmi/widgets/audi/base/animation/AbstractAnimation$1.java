/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation$AbstractAnimationStepEvent;

class AbstractAnimation$1
extends AbstractAnimation$AbstractAnimationStepEvent {
    private final /* synthetic */ AbstractAnimation this$0;

    AbstractAnimation$1(AbstractAnimation abstractAnimation, long l) {
        this.this$0 = abstractAnimation;
        super(l, null);
    }

    @Override
    public void run() {
        this.this$0.processAnimationStepEvent(false);
    }
}

