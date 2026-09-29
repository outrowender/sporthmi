/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.gui.NullGUI;
import de.audi.tghu.navi.app.map.gui.layout.AbstractLayoutProvider;
import de.audi.tghu.navi.app.map.gui.layout.LayoutProviderG22Kombi;
import de.audi.tghu.navi.app.util.Util;

public abstract class GUIKombi
extends NullGUI {
    protected AbstractLayoutProvider layoutProvider;

    public GUIKombi(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        int n = Util.isClusterMapMOST(navigationEnv.getFramework()) ? 2 : 3;
        this.layoutProvider = new LayoutProviderG22Kombi(navigationEnv, n);
    }

    @Override
    public AbstractLayoutProvider getLayout() {
        return this.layoutProvider;
    }

    @Override
    public void setMagnification(int n) {
        this.naviMap.getNaviInterface().getClusterService().onMagnificationChanged(n);
    }

    @Override
    public void setSideBarRotaryIcon(int n) {
        this.naviMap.getNaviInterface().getClusterService().onAutoZoomStateChanged(n == 3);
    }

    @Override
    public boolean setPinchZoomLimits(int n, int n2) {
        return false;
    }

    @Override
    public void setMagnificationLimits(int n, int n2, int n3) {
        this.naviMap.getNaviInterface().getClusterService().onMagnificationChanged(n3);
    }

    @Override
    public int getScreenWidth() {
        return this.layoutProvider.getScreenWidth();
    }

    @Override
    public int getScreenHeight() {
        return this.layoutProvider.getScreenHeight();
    }

    @Override
    public int getMapWidth() {
        return this.layoutProvider.getMapWidth();
    }

    @Override
    public int getMapHeight() {
        return this.layoutProvider.getMapHeight();
    }
}

