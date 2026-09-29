/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.interapp.displaymanager.IDisplayManagerListener;

public interface IDSIDisplayManagerController {
    default public void startDSI() {
    }

    default public void stopDSI() {
    }

    default public void startComponent(int n, int n2, int n3) {
    }

    default public void stopComponent(int n, int n2, int n3) {
    }

    default public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void addListener(IDisplayManagerListener iDisplayManagerListener) {
    }
}

