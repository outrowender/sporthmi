/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.RangeModelGUI;

public interface VirtualButtonModelGUI
extends RangeModelGUI {
    default public void joyN(int n) {
    }

    default public void joyNW(int n) {
    }

    default public void joyW(int n) {
    }

    default public void joySW(int n) {
    }

    default public void joyS(int n) {
    }

    default public void joySE(int n) {
    }

    default public void joyE(int n) {
    }

    default public void joyNE(int n) {
    }

    default public void joyIdle(int n) {
    }

    default public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
    }

    default public void touchPadReleased(int n, int n2, int n3) {
    }

    default public void touchPadPressed(int n, int n2, int n3) {
    }

    default public void touchScreenMoved(int n, int n2, int n3, int n4, int n5) {
    }

    default public void touchScreenFlicked(int n, int n2, int n3, int n4, int n5) {
    }

    default public void touchScreenPressed(int n, int n2, int n3) {
    }

    default public void touchScreenLongPressed(int n, int n2, int n3) {
    }

    default public void touchScreenReleased(int n, int n2, int n3) {
    }

    default public void touchScreenDoubleClick(int n, int n2, int n3) {
    }

    default public void touchScreenPinch(float f2, int n, int n2, int n3) {
    }

    default public void touchScreenRotate(short s, int n) {
    }
}

