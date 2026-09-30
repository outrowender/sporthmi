/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal.async;

import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import java.util.Set;

public interface ITexDescrAsyncStates
extends TextureDescription {
    public static final int LOADING_STATE_NONE = -3;
    public static final int LOADING_STATE_ABORT = -2;
    public static final int LOADING_STATE_ERROR = -1;
    public static final int LOADING_STATE_IDLE = 0;
    public static final int LOADING_STATE_REQUESTED = 1;
    public static final int LOADING_STATE_IMAGE_LOADED = 2;
    public static final int LOADING_STATE_FINISHED = 3;
    public static final int MAX_RESOLUTION_X = 2048;
    public static final int MAX_RESOLUTION_Y = 2048;

    public void abortLoading();

    public int getLoadingState();

    public Set getIUpdatableReceiver();

    public boolean removeReceiver(Object var1);

    public void resetLoadingState();
}

