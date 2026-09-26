/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.StateMachineEvent;
import de.audi.atip.statemachine.SMListener;

public interface SMInterpreter {
    default public void startPopup(int n, int n2) {
    }

    default public void stopPopup(int n, int n2) {
    }

    default public void processEvent(StateMachineEvent stateMachineEvent) {
    }

    default public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
    }

    default public void registersSMListener(SMListener sMListener) {
    }

    default public void setActiveSubterminal(int n, int n2) {
    }

    default public int getActiveSubterminal(int n) {
    }

    default public void jointModeLeft(int n) {
    }
}

