/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi.ddp2;

public interface ICombiSimulationDrawContext {
    default public void screenConnected() {
    }

    default public void updateText(int n, int n2, String string, int n3) {
    }

    default public void updateCursor(int n, int n2, int n3) {
    }

    default public void setFrameStatus(int n, int n2) {
    }

    default public void setActiveSubterminal(int n) {
    }
}

