/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

public interface IDisplayManagerListener {
    default public void startComponentResult(int n, int n2, int n3, int n4) {
    }

    default public void stopComponentResult(int n, int n2, int n3, int n4) {
    }

    default public void setCroppingResult(int n) {
    }

    default public void error() {
    }
}

