/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.Screen;

public interface ScreenCache {
    default public void putScreen(Screen screen) {
    }

    default public Screen getScreen(int n) {
    }

    default public void setCachingDisabled(boolean bl) {
    }

    default public void clear() {
    }

    default public void clear(int n) {
    }
}

