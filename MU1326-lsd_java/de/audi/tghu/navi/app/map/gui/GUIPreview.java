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

    @Override
    public String getName() {
        return "GUIPreview";
    }

    @Override
    public int getScreenWidth() {
        return 293;
    }

    @Override
    public int getScreenHeight() {
        return 323;
    }

    @Override
    public void setRotation(int n) {
    }

    @Override
    public void setMagnification(int n) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void stickN(int n, int n2) {
    }

    @Override
    public void stickNW(int n, int n2) {
    }

    @Override
    public void stickW(int n, int n2) {
    }

    @Override
    public void stickSW(int n, int n2) {
    }

    @Override
    public void stickS(int n, int n2) {
    }

    @Override
    public void stickSE(int n, int n2) {
    }

    @Override
    public void stickE(int n, int n2) {
    }

    @Override
    public void stickNE(int n, int n2) {
    }

    @Override
    public void stickIdle(int n, int n2) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
    }

    @Override
    public void increment(int n, int n2, int n3) {
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

