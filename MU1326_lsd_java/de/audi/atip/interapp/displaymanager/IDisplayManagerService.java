/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;

public interface IDisplayManagerService {
    public static final int RATIO_4_3;
    public static final int RATIO_16_9;
    public static final int RATIO_15_9;
    public static final int RATIO_47_20;
    public static final int RATIO_ZOOM;

    default public void activateComponent(int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    default public void deactivateComponent(int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    default public void activateComponent(int n) {
    }

    default public void deactivateComponent(int n) {
    }

    default public void activateComponentRVC(int n) {
    }

    default public void deactivateComponentRVC(int n) {
    }

    default public void setCropping(int n, int n2, int n3, int n4, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    default public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    default public int getCurrentDisplayable() {
    }
}

