/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.esolutions.fw.util.commons.Buffer;

public interface ScreenChangeAnimationItem {
    public static final int FADE_MASK = 3;
    public static final int TYPE_MASK = 28;
    public static final int TRANSITION_MASK = 96;
    public static final int FADE_IN = 1;
    public static final int FADE_OUT = 2;
    public static final int APPLICATION_SCREEN_CHANGE = 4;
    public static final int OPTION_DRAWER_SCREEN_CHANGE = 8;
    public static final int SELECTION_DRAWER_SCREEN_CHANGE = 12;
    public static final int IN_PLACE_SCREEN_CHANGE = 16;
    public static final int HORIZONTAL_SCREEN_CHANGE = 20;
    public static final int NO_ANIMATION_SCREEN_CHANGE = 24;
    public static final int STANDARD_SCREEN_CHANGE = 28;
    public static final int TRANSITION_FORWARD = 32;
    public static final int TRANSITION_BACKWARD = 64;

    public void setScreenChangeProgress(float var1);

    public void setScreenChangeTarget(int var1);

    public void screenChangeFinished();

    public static class Helper {
        public static String getText(int n) {
            Buffer buffer = new Buffer();
            buffer.append(n);
            buffer.append(" (");
            buffer.append(Helper.addText(n, 28, 4, "APPLICATION_SCREEN_CHANGE"));
            buffer.append(Helper.addText(n, 28, 8, "OPTION_DRAWER_SCREEN_CHANGE"));
            buffer.append(Helper.addText(n, 28, 12, "SELECTION_DRAWER_SCREEN_CHANGE"));
            buffer.append(Helper.addText(n, 28, 16, "IN_PLACE_SCREEN_CHANGE"));
            buffer.append(Helper.addText(n, 28, 20, "HORIZONTAL_SCREEN_CHANGE"));
            buffer.append(Helper.addText(n, 28, 24, "NO_ANIMATION_SCREEN_CHANGE"));
            buffer.append(Helper.addText(n, 3, 1, "FADE_IN"));
            buffer.append(Helper.addText(n, 3, 2, "FADE_OUT"));
            buffer.append(Helper.addText(n, 96, 32, "TRANSITION_FORWARD"));
            buffer.append(Helper.addText(n, 96, 64, "TRANSITION_BACKWARD"));
            buffer.append(')');
            return buffer.toString();
        }

        private static boolean hasFlag(int n, int n2, int n3) {
            return (n & n2) == n3;
        }

        private static String addText(int n, int n2, int n3, String string) {
            if (Helper.hasFlag(n, n2, n3)) {
                return string + ' ';
            }
            return "";
        }

        public static boolean isType(int n, int n2) {
            return Helper.hasFlag(n, 28, n2);
        }

        public static boolean isFade(int n, int n2) {
            return Helper.hasFlag(n, 3, n2);
        }

        public static boolean isTransition(int n, int n2) {
            return Helper.hasFlag(n, 96, n2);
        }
    }
}

