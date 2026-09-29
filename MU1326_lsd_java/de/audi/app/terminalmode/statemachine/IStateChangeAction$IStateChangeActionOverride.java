/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.IStateChangeAction;

public interface IStateChangeAction$IStateChangeActionOverride
extends IStateChangeAction {
    default public boolean executeSuperAction() {
    }
}

