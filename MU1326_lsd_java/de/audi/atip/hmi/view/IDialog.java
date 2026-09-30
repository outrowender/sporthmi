/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IScreenOverlay;

public interface IDialog
extends IScreenOverlay {
    public static final int DIALOG_IMG_UPPER_LEFT = 0;
    public static final int DIALOG_IMG_UPPER_CENTER = 1;
    public static final int DIALOG_IMG_UPPER_RIGHT = 2;
    public static final int DIALOG_IMG_MIDDLE_LEFT = 3;
    public static final int DIALOG_IMG_MIDDLE_CENTER = 4;
    public static final int DIALOG_IMG_MIDDLE_RIGHT = 5;
    public static final int DIALOG_IMG_DOWN_LEFT = 6;
    public static final int DIALOG_IMG_DOWN_CENTER = 7;
    public static final int DIALOG_IMG_DOWN_RIGHT = 8;
    public static final int DIALOG_IMG_MENU_LEFT = 9;
    public static final int DIALOG_IMG_MENU_CENTER = 10;
    public static final int DIALOG_IMG_MENU_RIGHT = 11;
    public static final int DIALOG_ALIGNMENT_LEFT = 10;
    public static final int DIALOG_ALIGNMENT_CENTER = 11;
    public static final int DIALOG_ALIGNMENT_RIGHT = 12;
    public static final int DIALOG_ALIGNMENT_FREE = 13;
    public static final int DIALOG_ANIMATION_STATE_HORIZONTAL = 0;
    public static final int DIALOG_ANIMATION_STATE_VERTICAL = 1;
    public static final int DIALOG_ANIMATION_STATE_BOTH = 2;
    public static final int DIALOG_ANIMATION_DIRECTION_HORIZONTAL_FIRST = 0;
    public static final int DIALOG_ANIMATION_DIRECTION_HORIZONTAL_ONLY = 1;
    public static final int DIALOG_ANIMATION_DIRECTION_VERTICAL_FIRST = 2;
    public static final int DIALOG_ANIMATION_DIRECTION_VERTICAL_ONLY = 3;
    public static final int DIALOG_ANIMATION_DIRECTION_BOTH = 4;
    public static final int DIALOG_ANIMATION_MODE_BOTH = 0;
    public static final int DIALOG_ANIMATION_MODE_CLOSE_ONLY = 1;
    public static final int DIALOG_ANIMATION_MODE_OPEN_ONLY = 2;
    public static final int DIALOG_CONTENT_FADING_BOTH = 0;
    public static final int DIALOG_CONTENT_FADING_CLOSE_ONLY = 1;
    public static final int DIALOG_CONTENT_FADING_OPEN_ONLY = 2;
    public static final int DIALOG_CONTENT_FADING_DISABLE = 3;

    public void show();

    public void hide();

    public boolean isShown();

    public void setDialogMargins(int var1, int var2);

    public void setStartBounds(int var1, int var2, int var3, int var4);

    public void setAlignment(int var1);

    public void setAnimationDirection(int var1);

    public void setAnimationMode(int var1);

    public void setContentFading(int var1);
}

