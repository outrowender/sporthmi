/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

public class GestureStateMachine {
    private final State stateInit = new GestureInitState();
    private final State stateOneFinger = new GestureOneFinger();
    private final State stateMultiFinger = new GestureMultiFinger();
    private State lastState = this.stateInit;
    private State currentState = this.stateInit;
    private int fingerPressed = 0;
    private int gestureID = 0;

    public int calculateGestureID(int n, int n2, int n3) {
        this.currentState.onEvent(n, n2, n3);
        return this.gestureID;
    }

    private void setState(State state) {
        if (!state.equals(this.currentState)) {
            this.lastState = this.currentState;
            this.lastState.onExit();
            this.currentState = state;
            this.currentState.onEnter();
        }
    }

    public abstract class State {
        protected void onEnter() {
        }

        protected void onExit() {
        }

        protected void onEvent(int n, int n2, int n3) {
        }
    }

    private final class GestureInitState
    extends State {
        private GestureInitState() {
        }

        protected void onEvent(int n, int n2, int n3) {
            if (n == 1) {
                GestureStateMachine.this.setState(GestureStateMachine.this.stateOneFinger);
            } else if (n > 1) {
                GestureStateMachine.this.setState(GestureStateMachine.this.stateMultiFinger);
            }
        }

        protected void onEnter() {
            GestureStateMachine.this.fingerPressed = 0;
        }
    }

    private final class GestureOneFinger
    extends State {
        private GestureOneFinger() {
        }

        protected void onEvent(int n, int n2, int n3) {
            if (n == 0) {
                GestureStateMachine.this.setState(GestureStateMachine.this.stateInit);
            } else if (n == 1) {
                GestureStateMachine.this.gestureID = 5;
            } else if (n > 1) {
                GestureStateMachine.this.setState(GestureStateMachine.this.stateMultiFinger);
            }
        }

        protected void onEnter() {
            if (GestureStateMachine.this.fingerPressed > 1) {
                GestureStateMachine.this.gestureID = 3;
            } else {
                GestureStateMachine.this.gestureID = 4;
            }
            GestureStateMachine.this.fingerPressed = 1;
        }

        protected void onExit() {
            GestureStateMachine.this.gestureID = 3;
        }
    }

    private final class GestureMultiFinger
    extends State {
        private GestureMultiFinger() {
        }

        protected void onEvent(int n, int n2, int n3) {
            if (n == 1) {
                GestureStateMachine.this.setState(GestureStateMachine.this.stateOneFinger);
            }
            if (n > 1) {
                GestureStateMachine.this.gestureID = 9;
            } else {
                GestureStateMachine.this.setState(GestureStateMachine.this.stateInit);
            }
        }

        protected void onEnter() {
            GestureStateMachine.this.fingerPressed = 2;
            GestureStateMachine.this.gestureID = 8;
        }

        protected void onExit() {
            GestureStateMachine.this.gestureID = 3;
        }
    }
}

