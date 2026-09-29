/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.State;

public abstract class AbstractTransition
extends State {
    public abstract void performComplexTransition() {
    }

    @Override
    public final void enter(Message message) {
        this.performComplexTransition();
    }

    public final void resume() {
        this.performComplexTransition();
    }

    @Override
    public final boolean processMessage(Message message) {
        return false;
    }

    @Override
    public final void exit(Message message) {
    }
}

