/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio.drawer;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;

public interface AudioDrawerContextListener {
    public static final int DRAWER_STATE_OPENED = 0;
    public static final int DRAWER_STATE_CLOSED = 1;
    public static final int DRAWER_STATE_HIDDEN = 2;
    public static final int DRAWER_STATE_CLOSED_DISABLED = 6;
    public static final int DRAWER_STATE_IGNORE = 7;

    public void updateActiveContext(AudioDrawerContext.Source var1, int var2);

    public void entertainmentDrawerOpened();

    public void entertainmentDrawerClosed();
}

