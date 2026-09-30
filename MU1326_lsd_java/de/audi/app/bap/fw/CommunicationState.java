/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.CommunicationUpListener;

public final class CommunicationState {
    private static final int DOWN = 0;
    private static final int UP = 1;
    private volatile int initState = 0;
    private volatile int fsgOperationState = 1;
    private final CommunicationUpListener listener;
    private volatile int communicationState = 0;

    public CommunicationState(CommunicationUpListener communicationUpListener) {
        this.listener = communicationUpListener;
    }

    public void updateInitState(int n) {
        this.initState = n;
        this.updateState(this.initState, this.fsgOperationState);
    }

    public void updateFsgOperationnState(int n) {
        this.fsgOperationState = n;
        this.updateState(this.initState, this.fsgOperationState);
    }

    public boolean isUp() {
        return this.communicationState == 1;
    }

    private void updateState(int n, int n2) {
        if (this.communicationState == 0 && CommunicationState.isCommunicationUp(n, n2)) {
            this.transitionToUp();
        }
        if (this.communicationState == 1 && !CommunicationState.isCommunicationUp(n, n2)) {
            this.transitionToDown();
        }
    }

    private void transitionToUp() {
        this.communicationState = 1;
        this.listener.communicationUp();
    }

    private void transitionToDown() {
        this.communicationState = 0;
    }

    private static boolean isCommunicationUp(int n, int n2) {
        return n == 11 && n2 == 0;
    }
}

