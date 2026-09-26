/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi.evo;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.kbd.hmi.evo.KeyEventDistributorEvo;
import de.audi.kbd.hmi.evo.KeyEventDistributorEvo$1;
import de.audi.tghu.hmi.evo.IEventListenerEvo;

class KeyEventDistributorEvo$NullEventListenerEvo
implements IEventListenerEvo {
    private final /* synthetic */ KeyEventDistributorEvo this$0;

    private KeyEventDistributorEvo$NullEventListenerEvo(KeyEventDistributorEvo keyEventDistributorEvo) {
        this.this$0 = keyEventDistributorEvo;
    }

    @Override
    public void processGestureEvent(GestureEvent gestureEvent) {
        KeyEventDistributorEvo.access$100(this.this$0).log(-1601830656, "[NullEventListenerEvo].processGestureEvent(%1)", (Object)gestureEvent);
    }

    @Override
    public void processKeyEvent(KeyEvent keyEvent) {
        KeyEventDistributorEvo.access$200(this.this$0).log(-1601830656, "[NullEventListenerEvo].processKeyEvent(%1)", (Object)keyEvent);
    }

    @Override
    public void processTouchPadEvent(TouchEvent touchEvent) {
        KeyEventDistributorEvo.access$300(this.this$0).log(-1601830656, "[NullEventListenerEvo].processTouchPadEvent(%1)", (Object)touchEvent);
    }

    /* synthetic */ KeyEventDistributorEvo$NullEventListenerEvo(KeyEventDistributorEvo keyEventDistributorEvo, KeyEventDistributorEvo$1 keyEventDistributorEvo$1) {
        this(keyEventDistributorEvo);
    }
}

