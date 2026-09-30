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

    public AbstractLayoutProvider getLayout() {
        return this.layoutProvider;
    }

    public void setMagnification(int n) {
        this.naviMap.getNaviInterface().getClusterService().onMagnificationChanged(n);
    }

    public void setSideBarRotaryIcon(int n) {
        this.naviMap.getNaviInterface().getClusterService().onAutoZoomStateChanged(n == 3);
    }

    public boolean setPinchZoomLimits(int n, int n2) {
        return false;
    }

    public void setMagnificationLimits(int n, int n2, int n3) {
        this.naviMap.getNaviInterface().getClusterService().onMagnificationChanged(n3);
    }

    public int getScreenWidth() {
        return this.layoutProvider.getScreenWidth();
    }

    public int getScreenHeight() {
        return this.layoutProvider.getScreenHeight();
    }

    public int getMapWidth() {
        return this.layoutProvider.getMapWidth();
    }

    public int getMapHeight() {
        return this.layoutProvider.getMapHeight();
    }
}

