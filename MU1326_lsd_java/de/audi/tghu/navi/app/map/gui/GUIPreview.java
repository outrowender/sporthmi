/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.gui.NullGUI;

public class GUIPreview
extends NullGUI {
    public GUIPreview(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public String getName() {
        return "GUIPreview";
    }

    public int getScreenWidth() {
        return 293;
    }

    public int getScreenHeight() {
        return 323;
    }

    public void setRotation(int n) {
    }

    public void setMagnification(int n) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
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
}

