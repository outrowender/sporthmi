/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface InfoActionProxy
extends ActionProxy {
    default public void tmcMapLeft(int n) {
    }

    default public void tmcExitMainScreen(int n) {
    }

    default public void tmcEnterMainScreen(int n) {
    }

    default public void tmcEnterScreens(int n) {
    }

    default public void tmcExitScreens(int n) {
    }

    default public void tmcEnterDetailsScreen(int n) {
    }

    default public void tmcExitDetailsScreen(int n) {
    }
}

