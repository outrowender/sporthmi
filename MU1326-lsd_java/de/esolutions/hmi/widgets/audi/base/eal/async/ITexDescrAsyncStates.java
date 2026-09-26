/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal.async;

import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import java.util.Set;

public interface ITexDescrAsyncStates
extends TextureDescription {
    public static final int LOADING_STATE_NONE;
    public static final int LOADING_STATE_ABORT;
    public static final int LOADING_STATE_ERROR;
    public static final int LOADING_STATE_IDLE;
    public static final int LOADING_STATE_REQUESTED;
    public static final int LOADING_STATE_IMAGE_LOADED;
    public static final int LOADING_STATE_FINISHED;
    public static final int MAX_RESOLUTION_X;
    public static final int MAX_RESOLUTION_Y;

    default public void abortLoading() {
    }

    default public int getLoadingState() {
    }

    default public Set getIUpdatableReceiver() {
    }

    default public boolean removeReceiver(Object object) {
    }

    default public void resetLoadingState() {
    }
}

