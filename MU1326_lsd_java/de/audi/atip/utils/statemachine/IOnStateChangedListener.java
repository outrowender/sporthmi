/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.IState;

public interface IOnStateChangedListener {
    default public void onStateChanged(IState iState) {
    }
}

