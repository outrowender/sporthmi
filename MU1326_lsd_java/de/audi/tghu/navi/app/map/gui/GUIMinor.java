/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.gui.NullGUI;
import de.audi.tghu.navi.app.util.Util;

public class GUIMinor
extends NullGUI {
    private static final String NAME = "GUIMinor";

    public GUIMinor(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public String getName() {
        return NAME;
    }

    public int getScreenWidth() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return 244;
        }
        if (Util.isClusterRGI(this.env.getFramework())) {
            return 293;
        }
        return 260;
    }

    public int getScreenHeight() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return 266;
        }
        if (Util.isClusterRGI(this.env.getFramework())) {
            return 323;
        }
        return 318;
    }

    public void setRotation(int n) {
    }

    public void setMagnification(int n) {
    }

    public boolean setPinchZoomLimits(int n, int n2) {
        return false;
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        super.itemSelected(n, n2, n3, n4);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void stickN(int n, int n2) {
    }

    public void stickNW(int n, int n2) {
    }

    public void stickW(int n, int n2) {
    }

    public void stickSW(int n, int n2) {
    }

    public void stickS(int n, int n2) {
    }

    public void stickSE(int n, int n2) {
    }

    public void stickE(int n, int n2) {
    }

    public void stickNE(int n, int n2) {
    }

    public void stickIdle(int n, int n2) {
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void decrement(int n, int n2, int n3) {
    }

    public void increment(int n, int n2, int n3) {
    }

    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public boolean setMagnificationLimits(int n, int n2) {
        return false;
    }

    public boolean setMagnificationNoFlush(int n) {
        return false;
    }

    public boolean setMagnificationNoFlush(int n, boolean bl) {
        return false;
    }

    public void setMagnification(int n, boolean bl) {
    }
}

