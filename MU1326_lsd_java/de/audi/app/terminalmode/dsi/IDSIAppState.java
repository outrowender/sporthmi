/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IAppState;

public interface IDSIAppState
extends IAppState {
    default public int getDSIAppStateId() {
    }

    default public int getDSIOwner() {
    }

    default public int getDSISpeechMode() {
    }
}

