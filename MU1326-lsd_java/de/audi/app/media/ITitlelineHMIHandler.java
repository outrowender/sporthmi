/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.source.ISourceSlot;

public interface ITitlelineHMIHandler {
    public static final int REPEAT_SCOPE_ICON_OFF;
    public static final int REPEAT_SCOPE_ICON_TITLE;
    public static final int REPEAT_SCOPE_ICON_FOLDER;
    public static final int REPEAT_SCOPE_ICON_PLAYLIST;

    default public void setSourceIcon(ISourceSlot iSourceSlot) {
    }

    default public void resetIcons() {
    }

    default public void setRepeatScopeIcon(int n) {
    }

    default public void setMixIcon(boolean bl) {
    }

    default public void flush() {
    }
}

