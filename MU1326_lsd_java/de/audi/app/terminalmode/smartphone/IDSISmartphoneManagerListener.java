/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;

public interface IDSISmartphoneManagerListener {
    public void updateDSIState(boolean var1);

    public void updateMode(long var1, IAppState[] var3, IResource[] var4);

    public void updateTextInputState(boolean var1);

    public void duckAudio(int var1, double var2);

    public void duckAudioCompletely();

    public void unduckAudio(int var1);

    public void releaseDuckAudioCompletely();

    public void ignoreUpdateMode(long var1);
}

