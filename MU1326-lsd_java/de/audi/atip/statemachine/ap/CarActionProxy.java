/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface CarActionProxy
extends ActionProxy {
    default public void setIndividualEntered(int n) {
    }

    default public void charismaExited(int n) {
    }

    default public void ugdoAbort(int n) {
    }

    default public void ugdoRestart(int n) {
    }

    default public void carMenusEntered(int n, boolean bl) {
    }

    default public void browserScreenEntered(int n) {
    }

    default public void browserScreenExited(int n) {
    }

    default public void charismaEntered(int n) {
    }

    default public void resetTruffleSelection(int n) {
    }

    default public void browserScreenEnteredByHistory(int n) {
    }

    default public void browserScreenStartMediaPlayback(int n) {
    }

    default public void browserScreenEndMediaPlayback(int n) {
    }

    default public void codriverMovementByDriverScreenExited(int n) {
    }

    default public void codriverMovementByDriverScreenEntered(int n) {
    }

    default public void setCarContext(int n, int n2) {
    }

    default public void ugdoSync(int n) {
    }

    default public void charismaMenuStateChange(int n, int n2) {
    }

    default public void jokerKeyPopupActive(int n, int n2) {
    }
}

