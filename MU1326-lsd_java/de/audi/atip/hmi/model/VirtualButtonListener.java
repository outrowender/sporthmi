/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.RangeListener;

public interface VirtualButtonListener
extends RangeListener {
    default public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void stickN(int n, int n2) {
    }

    default public void stickNW(int n, int n2) {
    }

    default public void stickW(int n, int n2) {
    }

    default public void stickSW(int n, int n2) {
    }

    default public void stickS(int n, int n2) {
    }

    default public void stickSE(int n, int n2) {
    }

    default public void stickE(int n, int n2) {
    }

    default public void stickNE(int n, int n2) {
    }

    default public void stickIdle(int n, int n2) {
    }

    default public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void touchScreenPressed(int n, int n2, int n3, int n4) {
    }

    default public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
    }

    default public void touchScreenReleased(int n, int n2, int n3, int n4) {
    }

    default public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
    }

    default public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
    }

    default public void touchScreenRotate(int n, short s, int n2) {
    }

    default public void touchPadReleased(int n, int n2, int n3) {
    }

    default public void touchPadPressed(int n, int n2, int n3) {
    }
}

