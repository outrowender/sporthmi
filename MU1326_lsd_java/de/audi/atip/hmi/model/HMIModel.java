/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface HMIModel
extends HMIModelGUI,
HMIModelApp {
    public static final int HINT_CURSOR_MUST_JOIN;
    public static final int HINT_CURSOR_SHOULD_JOIN;
    public static final int HINT_KEEP_TOOLTIP_SHOWN;
    public static final int HINT_DATA_REFRESH;
    public static final int HINT_SLIDINGLIST_FILLED_FROM_START;
    public static final int HINT_LEVEL_DOWN;
    public static final int HINT_LEVEL_UP;
    public static final int HINT_RESET_CURSOR;
    public static final int HINT_KEEP_CURSOR_POSITION;
    public static final int HINT_JUMP5_AVAILABLE;
    public static final int HINT_SPELLER_EXIT_OK;
    public static final int HINT_SPELLER_EXIT_LIST;
    public static final int VARIANT_NONE;
    public static final int VARIANT_VW;

    default public boolean isEmpty() {
    }

    default public void deferredConnected() {
    }
}

