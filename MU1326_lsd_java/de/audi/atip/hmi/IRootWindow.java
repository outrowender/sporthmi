/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;

public interface IRootWindow
extends ATIPEventListener {
    public void add(IScreenData var1, Screen var2);

    public void remove(Screen var1);

    public Screen getCurrentScreen();

    public void addHardkeyListener(KeyListener var1);

    public void repaint();
}

