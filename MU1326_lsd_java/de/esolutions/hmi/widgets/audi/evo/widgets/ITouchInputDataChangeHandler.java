/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public interface ITouchInputDataChangeHandler {
    public static final int UPDATE_TYPE_TEXT_CHANGED;
    public static final int UPDATE_LANGUAGE_SET_ARABIC;
    public static final int UPDATE_LANGUAGE_SET_LATIN;
    public static final int UPDATE_TYPE_TOUCH_RESULT_PREVIEW_CHANGED;
    public static final int UPDATE_TYPE_UNCONVERTED_CHARACTERS_CHANGED;
    public static final int UPDATE_TYPE_SUGGESTION_CHANGED;

    default public void touchInputDataChanged(int n, boolean bl, String string, String string2) {
    }
}

