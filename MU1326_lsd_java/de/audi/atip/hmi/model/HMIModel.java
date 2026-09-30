/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface HMIModel
extends HMIModelGUI,
HMIModelApp {
    public static final int HINT_CURSOR_MUST_JOIN = 1;
    public static final int HINT_CURSOR_SHOULD_JOIN = 2;
    public static final int HINT_KEEP_TOOLTIP_SHOWN = 4;
    public static final int HINT_DATA_REFRESH = 8;
    public static final int HINT_SLIDINGLIST_FILLED_FROM_START = 16;
    public static final int HINT_LEVEL_DOWN = 32;
    public static final int HINT_LEVEL_UP = 64;
    public static final int HINT_RESET_CURSOR = 128;
    public static final int HINT_KEEP_CURSOR_POSITION = 256;
    public static final int HINT_JUMP5_AVAILABLE = 512;
    public static final int HINT_SPELLER_EXIT_OK = 1024;
    public static final int HINT_SPELLER_EXIT_LIST = 2048;
    public static final int VARIANT_NONE = 0;
    public static final int VARIANT_VW = 1;

    public boolean isEmpty();

    public void deferredConnected();
}

