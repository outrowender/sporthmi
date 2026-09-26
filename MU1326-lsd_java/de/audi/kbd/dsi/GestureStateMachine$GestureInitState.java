/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.kbd.dsi.GestureStateMachine;
import de.audi.kbd.dsi.GestureStateMachine$1;
import de.audi.kbd.dsi.GestureStateMachine$State;

final class GestureStateMachine$GestureInitState
extends GestureStateMachine$State {
    private final /* synthetic */ GestureStateMachine this$0;

    private GestureStateMachine$GestureInitState(GestureStateMachine gestureStateMachine) {
        this.this$0 = gestureStateMachine;
        super(gestureStateMachine);
    }

    @Override
    protected void onEvent(int n, int n2, int n3) {
        if (n == 1) {
            GestureStateMachine.access$400(this.this$0, GestureStateMachine.access$300(this.this$0));
        } else if (n > 1) {
            GestureStateMachine.access$400(this.this$0, GestureStateMachine.access$500(this.this$0));
        }
    }

    @Override
    protected void onEnter() {
        GestureStateMachine.access$602(this.this$0, 0);
    }

    /* synthetic */ GestureStateMachine$GestureInitState(GestureStateMachine gestureStateMachine, GestureStateMachine$1 gestureStateMachine$1) {
        this(gestureStateMachine);
    }
}

