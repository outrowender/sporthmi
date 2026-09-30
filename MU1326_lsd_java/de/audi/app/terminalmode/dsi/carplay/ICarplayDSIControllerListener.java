/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;

public interface ICarplayDSIControllerListener {
    public void updateMode(IAppState[] var1, IResource[] var2);

    public void updateTextInputState(boolean var1);

    public void duckAudio(int var1, double var2);

    public void unduckAudio(int var1);

    public void updateMainAudioType(int var1);

    public void oemAppSelected();
}

