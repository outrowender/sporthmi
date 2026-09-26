/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation$1;

abstract class AbstractAnimation$AbstractAnimationStepEvent
extends ATIPEvent
implements Runnable {
    private static final int EVENT_ID;
    private long delay;
    private int dbgCurrenScreen = 128;
    private int dbgStep = 128;
    private int dbgType = 128;
    private boolean dbgFadeIn = false;

    private AbstractAnimation$AbstractAnimationStepEvent(long l) {
        super((ATIPEventListener)null, 10552);
    }

    @Override
    public void dispatch() {
        this.run();
    }

    private long getDelay() {
        return this.delay;
    }

    private void setDelay(long l) {
        this.delay = l;
    }

    private void setDebugInfo(int n, int n2, boolean bl, int n3) {
        this.dbgFadeIn = bl;
        this.dbgType = n;
        this.dbgStep = n2;
        this.dbgCurrenScreen = n3;
    }

    public String toString() {
        if (this.dbgType > 128) {
            Buffer buffer = new Buffer(100);
            buffer.append("Animation type: ").append(this.dbgType).append(" fade in: ").append(this.dbgFadeIn).append(" step: ").append(this.dbgStep).append(" delay: ").append(this.delay);
            if (this.dbgCurrenScreen > 128) {
                buffer.append(" current screen: ").append(this.dbgCurrenScreen);
            }
            return buffer.toString();
        }
        return "AnimationStepEvent";
    }

    static /* synthetic */ void access$000(AbstractAnimation$AbstractAnimationStepEvent abstractAnimation$AbstractAnimationStepEvent, long l) {
        abstractAnimation$AbstractAnimationStepEvent.setDelay(l);
    }

    /* synthetic */ AbstractAnimation$AbstractAnimationStepEvent(long l, AbstractAnimation$1 abstractAnimation$1) {
        this(l);
    }

    static /* synthetic */ void access$200(AbstractAnimation$AbstractAnimationStepEvent abstractAnimation$AbstractAnimationStepEvent, int n, int n2, boolean bl, int n3) {
        abstractAnimation$AbstractAnimationStepEvent.setDebugInfo(n, n2, bl, n3);
    }

    static /* synthetic */ long access$300(AbstractAnimation$AbstractAnimationStepEvent abstractAnimation$AbstractAnimationStepEvent) {
        return abstractAnimation$AbstractAnimationStepEvent.getDelay();
    }
}

