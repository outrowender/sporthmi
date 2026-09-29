/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface ScreenChangeAnimationItem {
    public static final int FADE_MASK;
    public static final int TYPE_MASK;
    public static final int TRANSITION_MASK;
    public static final int FADE_IN;
    public static final int FADE_OUT;
    public static final int APPLICATION_SCREEN_CHANGE;
    public static final int OPTION_DRAWER_SCREEN_CHANGE;
    public static final int SELECTION_DRAWER_SCREEN_CHANGE;
    public static final int IN_PLACE_SCREEN_CHANGE;
    public static final int HORIZONTAL_SCREEN_CHANGE;
    public static final int NO_ANIMATION_SCREEN_CHANGE;
    public static final int STANDARD_SCREEN_CHANGE;
    public static final int TRANSITION_FORWARD;
    public static final int TRANSITION_BACKWARD;

    default public void setScreenChangeProgress(float f2) {
    }

    default public void setScreenChangeTarget(int n) {
    }

    default public void screenChangeFinished() {
    }
}

