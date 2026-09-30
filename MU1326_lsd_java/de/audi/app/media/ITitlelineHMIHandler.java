/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.source.ISourceSlot;

public interface ITitlelineHMIHandler {
    public static final int REPEAT_SCOPE_ICON_OFF = 0;
    public static final int REPEAT_SCOPE_ICON_TITLE = 1;
    public static final int REPEAT_SCOPE_ICON_FOLDER = 2;
    public static final int REPEAT_SCOPE_ICON_PLAYLIST = 3;

    public void setSourceIcon(ISourceSlot var1);

    public void resetIcons();

    public void setRepeatScopeIcon(int var1);

    public void setMixIcon(boolean var1);

    public void flush();
}

