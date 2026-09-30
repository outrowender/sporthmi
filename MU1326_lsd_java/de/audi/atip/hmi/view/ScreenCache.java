/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.Screen;

public interface ScreenCache {
    public void putScreen(Screen var1);

    public Screen getScreen(int var1);

    public void setCachingDisabled(boolean var1);

    public void clear();

    public void clear(int var1);
}

