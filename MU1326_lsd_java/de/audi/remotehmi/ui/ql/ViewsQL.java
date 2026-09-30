/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.ql;

import de.audi.remotehmi.ui.core.ViewsCore;

public interface ViewsQL
extends ViewsCore {
    public static final int TYPE_LIST_GENERIC = 1000;
    public static final int TYPE_LIST_INFINITE = 1010;
    public static final int TYPE_LIST_INPUT = 1100;
    public static final int TYPE_LIST_PICTURE = 1200;
    public static final int TYPE_LIST_PREVIEW = 1300;
    public static final int TYPE_LIST_DOUBLE = 1400;
    public static final int TYPE_LIST_POI = 1500;
    public static final int TYPE_SPELLER_TEXT = 2000;
    public static final int TYPE_SPELLER_MATCHED = 2100;
    public static final int TYPE_SPELLER_TEXT_CHINA = 2200;
    public static final int TYPE_SPELLER_NUMERIC = 2300;
    public static final int TYPE_BROWSER = 3000;
    public static final int TYPE_BROWSER_FULLSCREEN = 3100;
    public static final int TYPE_TEXTDISPLAY = 4000;
    public static final int TYPE_PICTUREDISPLAY = 5000;
    public static final int TYPE_PICTUREDISPLAY_FULLSCREEN = 5100;
    public static final int TYPE_MAP_VIEW_POIDISPLAY = 6000;
    public static final int TYPE_NAV_LOCATION_INPUT = 6100;
    public static final int TYPE_WIZARD = 10000;
    public static final int TYPE_INFOWIZARD = 10100;
    public static final int TYPE_PROGRESSBAR = 12000;
}

