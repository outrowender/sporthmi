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
    default public void add(IScreenData iScreenData, Screen screen) {
    }

    default public void remove(Screen screen) {
    }

    default public Screen getCurrentScreen() {
    }

    default public void addHardkeyListener(KeyListener keyListener) {
    }

    default public void repaint() {
    }
}

