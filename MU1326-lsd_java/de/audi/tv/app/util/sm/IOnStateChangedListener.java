/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.sm.IState;

public interface IOnStateChangedListener {
    default public void onStateChanged(IState iState) {
    }
}

