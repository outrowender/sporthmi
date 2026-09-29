/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;

public class DrawerAnimationManager$Helper {
    public static String getAnimationName(int n) {
        return DrawerAnimationManager.ANIMATION_NAMES[n];
    }

    public static boolean hasFlag(int n, int n2) {
        return (n & 1 << n2) != 0;
    }

    public static String getMaskString(int n) {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < DrawerAnimationManager.ANIMATION_NAMES.length; ++i2) {
            if (!DrawerAnimationManager$Helper.hasFlag(n, i2)) continue;
            buffer.append(DrawerAnimationManager.ANIMATION_NAMES[i2]);
            buffer.append(' ');
        }
        return buffer.toString();
    }
}

