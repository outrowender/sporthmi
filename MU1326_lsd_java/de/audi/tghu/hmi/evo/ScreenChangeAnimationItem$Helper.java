/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.esolutions.fw.util.commons.Buffer;

public class ScreenChangeAnimationItem$Helper {
    public static String getText(int n) {
        Buffer buffer = new Buffer();
        buffer.append(n);
        buffer.append(" (");
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 28, 4, "APPLICATION_SCREEN_CHANGE"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 28, 8, "OPTION_DRAWER_SCREEN_CHANGE"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 28, 12, "SELECTION_DRAWER_SCREEN_CHANGE"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 28, 16, "IN_PLACE_SCREEN_CHANGE"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 28, 20, "HORIZONTAL_SCREEN_CHANGE"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 28, 24, "NO_ANIMATION_SCREEN_CHANGE"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 3, 1, "FADE_IN"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 3, 2, "FADE_OUT"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 96, 32, "TRANSITION_FORWARD"));
        buffer.append(ScreenChangeAnimationItem$Helper.addText(n, 96, 64, "TRANSITION_BACKWARD"));
        buffer.append(')');
        return buffer.toString();
    }

    private static boolean hasFlag(int n, int n2, int n3) {
        return (n & n2) == n3;
    }

    private static String addText(int n, int n2, int n3, String string) {
        if (ScreenChangeAnimationItem$Helper.hasFlag(n, n2, n3)) {
            return new StringBuffer().append(string).append(' ').toString();
        }
        return "";
    }

    public static boolean isType(int n, int n2) {
        return ScreenChangeAnimationItem$Helper.hasFlag(n, 28, n2);
    }

    public static boolean isFade(int n, int n2) {
        return ScreenChangeAnimationItem$Helper.hasFlag(n, 3, n2);
    }

    public static boolean isTransition(int n, int n2) {
        return ScreenChangeAnimationItem$Helper.hasFlag(n, 96, n2);
    }
}

