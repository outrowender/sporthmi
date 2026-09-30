/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public interface ITouchInputDataChangeHandler {
    public static final int UPDATE_TYPE_TEXT_CHANGED = 1;
    public static final int UPDATE_LANGUAGE_SET_ARABIC = 2;
    public static final int UPDATE_LANGUAGE_SET_LATIN = 3;
    public static final int UPDATE_TYPE_TOUCH_RESULT_PREVIEW_CHANGED = 2;
    public static final int UPDATE_TYPE_UNCONVERTED_CHARACTERS_CHANGED = 3;
    public static final int UPDATE_TYPE_SUGGESTION_CHANGED = 4;

    public void touchInputDataChanged(int var1, boolean var2, String var3, String var4);
}

