/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio.drawer;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;

public interface AudioDrawerContextListener {
    public static final int DRAWER_STATE_OPENED;
    public static final int DRAWER_STATE_CLOSED;
    public static final int DRAWER_STATE_HIDDEN;
    public static final int DRAWER_STATE_CLOSED_DISABLED;
    public static final int DRAWER_STATE_IGNORE;

    default public void updateActiveContext(AudioDrawerContext$Source audioDrawerContext$Source, int n) {
    }

    default public void entertainmentDrawerOpened() {
    }

    default public void entertainmentDrawerClosed() {
    }
}

