/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;

public class NullDisplayManager
implements IDisplayManagerService {
    @Override
    public void activateComponent(int n) {
    }

    @Override
    public void deactivateComponent(int n) {
    }

    @Override
    public void setCropping(int n, int n2, int n3, int n4, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    @Override
    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    @Override
    public void activateComponent(int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    @Override
    public void deactivateComponent(int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
    }

    @Override
    public void activateComponentRVC(int n) {
    }

    @Override
    public void deactivateComponentRVC(int n) {
    }

    @Override
    public int getCurrentDisplayable() {
        return -1;
    }
}

