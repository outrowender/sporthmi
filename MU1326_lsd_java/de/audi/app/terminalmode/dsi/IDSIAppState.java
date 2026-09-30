/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IAppState;

public interface IDSIAppState
extends IAppState {
    public int getDSIAppStateId();

    public int getDSIOwner();

    public int getDSISpeechMode();
}

