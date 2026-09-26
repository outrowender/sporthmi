/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

public class EALViewportsAndLayers$Helper {
    public static boolean isOnlyOffscreenViewport(int n) {
        boolean bl;
        switch (n) {
            case -20: 
            case -10: {
                bl = true;
            }
        }
        bl = false;
        return bl;
    }
}

