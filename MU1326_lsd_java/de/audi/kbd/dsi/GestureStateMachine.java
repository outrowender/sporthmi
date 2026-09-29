/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.kbd.dsi.GestureStateMachine$GestureInitState;
import de.audi.kbd.dsi.GestureStateMachine$GestureMultiFinger;
import de.audi.kbd.dsi.GestureStateMachine$GestureOneFinger;
import de.audi.kbd.dsi.GestureStateMachine$State;

public class GestureStateMachine {
    private final GestureStateMachine$State stateInit = new GestureStateMachine$GestureInitState(this, null);
    private final GestureStateMachine$State stateOneFinger = new GestureStateMachine$GestureOneFinger(this, null);
    private final GestureStateMachine$State stateMultiFinger = new GestureStateMachine$GestureMultiFinger(this, null);
    private GestureStateMachine$State lastState = this.stateInit;
    private GestureStateMachine$State currentState = this.stateInit;
    private int fingerPressed = 0;
    private int gestureID = 0;

    public int calculateGestureID(int n, int n2, int n3) {
        this.currentState.onEvent(n, n2, n3);
        return this.gestureID;
    }

    private void setState(GestureStateMachine$State gestureStateMachine$State) {
        if (!gestureStateMachine$State.equals(this.currentState)) {
            this.lastState = this.currentState;
            this.lastState.onExit();
            this.currentState = gestureStateMachine$State;
            this.currentState.onEnter();
        }
    }

    static /* synthetic */ GestureStateMachine$State access$300(GestureStateMachine gestureStateMachine) {
        return gestureStateMachine.stateOneFinger;
    }

    static /* synthetic */ void access$400(GestureStateMachine gestureStateMachine, GestureStateMachine$State state) {
        gestureStateMachine.setState(state);
    }

    static /* synthetic */ GestureStateMachine$State access$500(GestureStateMachine gestureStateMachine) {
        return gestureStateMachine.stateMultiFinger;
    }

    static /* synthetic */ int access$602(GestureStateMachine gestureStateMachine, int n) {
        gestureStateMachine.fingerPressed = n;
        return gestureStateMachine.fingerPressed;
    }

    static /* synthetic */ int access$702(GestureStateMachine gestureStateMachine, int n) {
        gestureStateMachine.gestureID = n;
        return gestureStateMachine.gestureID;
    }

    static /* synthetic */ GestureStateMachine$State access$800(GestureStateMachine gestureStateMachine) {
        return gestureStateMachine.stateInit;
    }

    static /* synthetic */ int access$600(GestureStateMachine gestureStateMachine) {
        return gestureStateMachine.fingerPressed;
    }
}

