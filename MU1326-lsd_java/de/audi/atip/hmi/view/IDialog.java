/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IScreenOverlay;

public interface IDialog
extends IScreenOverlay {
    public static final int DIALOG_IMG_UPPER_LEFT;
    public static final int DIALOG_IMG_UPPER_CENTER;
    public static final int DIALOG_IMG_UPPER_RIGHT;
    public static final int DIALOG_IMG_MIDDLE_LEFT;
    public static final int DIALOG_IMG_MIDDLE_CENTER;
    public static final int DIALOG_IMG_MIDDLE_RIGHT;
    public static final int DIALOG_IMG_DOWN_LEFT;
    public static final int DIALOG_IMG_DOWN_CENTER;
    public static final int DIALOG_IMG_DOWN_RIGHT;
    public static final int DIALOG_IMG_MENU_LEFT;
    public static final int DIALOG_IMG_MENU_CENTER;
    public static final int DIALOG_IMG_MENU_RIGHT;
    public static final int DIALOG_ALIGNMENT_LEFT;
    public static final int DIALOG_ALIGNMENT_CENTER;
    public static final int DIALOG_ALIGNMENT_RIGHT;
    public static final int DIALOG_ALIGNMENT_FREE;
    public static final int DIALOG_ANIMATION_STATE_HORIZONTAL;
    public static final int DIALOG_ANIMATION_STATE_VERTICAL;
    public static final int DIALOG_ANIMATION_STATE_BOTH;
    public static final int DIALOG_ANIMATION_DIRECTION_HORIZONTAL_FIRST;
    public static final int DIALOG_ANIMATION_DIRECTION_HORIZONTAL_ONLY;
    public static final int DIALOG_ANIMATION_DIRECTION_VERTICAL_FIRST;
    public static final int DIALOG_ANIMATION_DIRECTION_VERTICAL_ONLY;
    public static final int DIALOG_ANIMATION_DIRECTION_BOTH;
    public static final int DIALOG_ANIMATION_MODE_BOTH;
    public static final int DIALOG_ANIMATION_MODE_CLOSE_ONLY;
    public static final int DIALOG_ANIMATION_MODE_OPEN_ONLY;
    public static final int DIALOG_CONTENT_FADING_BOTH;
    public static final int DIALOG_CONTENT_FADING_CLOSE_ONLY;
    public static final int DIALOG_CONTENT_FADING_OPEN_ONLY;
    public static final int DIALOG_CONTENT_FADING_DISABLE;

    @Override
    default public void show() {
    }

    @Override
    default public void hide() {
    }

    @Override
    default public boolean isShown() {
    }

    default public void setDialogMargins(int n, int n2) {
    }

    default public void setStartBounds(int n, int n2, int n3, int n4) {
    }

    default public void setAlignment(int n) {
    }

    default public void setAnimationDirection(int n) {
    }

    default public void setAnimationMode(int n) {
    }

    default public void setContentFading(int n) {
    }
}

