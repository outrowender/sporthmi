/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer;

import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerState;

public class EntertainmentDrawerAnimationState {
    private EntertainmentDrawerState sourceState = new EntertainmentDrawerState();
    private EntertainmentDrawerState currentState = new EntertainmentDrawerState();
    private EntertainmentDrawerState targetState = new EntertainmentDrawerState();

    public int getCurrentDrawerState() {
        return this.currentState.getDrawerState();
    }

    public int getTargetDrawerState() {
        if (this.targetState != null) {
            return this.targetState.getDrawerState();
        }
        return this.currentState.getDrawerState();
    }

    public EntertainmentDrawerState getSourceState() {
        return this.sourceState;
    }

    public void setSourceState(EntertainmentDrawerState entertainmentDrawerState) {
        this.sourceState = entertainmentDrawerState;
    }

    public EntertainmentDrawerState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(EntertainmentDrawerState entertainmentDrawerState) {
        this.currentState = entertainmentDrawerState;
    }

    public EntertainmentDrawerState getTargetState() {
        return this.targetState;
    }

    public void setTargetState(EntertainmentDrawerState entertainmentDrawerState) {
        this.targetState = entertainmentDrawerState;
    }
}

