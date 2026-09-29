/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.gui.GUIKombi;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;

public class GUIKombiMOST
extends GUIKombi {
    public GUIKombiMOST(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public String getName() {
        return "GUIKombiMOST";
    }

    @Override
    public void updateChoiceValue(int n, int n2) {
        this.getEnv().getChoiceModel(n).setValue(n2);
    }

    @Override
    public void refreshMapRepresentation() {
    }

    @Override
    public int getMagnificationValue(int n) {
        this.fixme("getMagnificationValue");
        return this.getMap().getMapManager().getMapMain().getGuiInterface().getMagnificationValue(n);
    }

    @Override
    public int getMagnificationMaximum(int n) {
        this.fixme("getMagnificationMaximum");
        return this.getMap().getMapManager().getMapMain().getGuiInterface().getMagnificationMaximum(n);
    }

    @Override
    public int getMagnificationMinimum(int n) {
        this.fixme("getMagnificationMinimum");
        return this.getMap().getMapManager().getMapMain().getGuiInterface().getMagnificationMinimum(n);
    }

    @Override
    public MapItemSelectionAction hideToolTip() {
        return null;
    }

    public void hideRouteCalculationScreen(boolean bl) {
    }

    @Override
    public int getSidebarState() {
        return this.env.getChoiceModel(1058801152).getValue();
    }

    @Override
    public void closeSidebarWithoutAnimation() {
    }

    @Override
    public void openOrCloseSidebar(int n) {
    }

    @Override
    public void switchToNormalSidebar() {
    }

    @Override
    public void enableScrollInfo(boolean bl) {
    }

    @Override
    public void setRotation(int n) {
    }

    @Override
    public void enableOrientation(boolean bl) {
    }

    @Override
    public void clearDestDistance() {
    }

    @Override
    public void refreshMapType(int n) {
        this.warn("setMapType");
        this.env.getChoiceModel(1159595520).setValue(n);
    }

    @Override
    public int getStatusBarHeight() {
        return 0;
    }

    @Override
    public boolean isDemoMode() {
        return false;
    }

    @Override
    public int getScreenWidth() {
        int n = super.getScreenWidth();
        if (n <= 0) {
            n = 800;
        }
        return n;
    }

    @Override
    public int getScreenHeight() {
        int n = super.getScreenHeight();
        if (n <= 0) {
            n = 298;
        }
        return n;
    }

    @Override
    public int getMapWidth() {
        int n = super.getMapWidth();
        if (n <= 0) {
            n = this.getScreenWidth();
        }
        return n;
    }

    @Override
    public int getMapHeight() {
        int n = super.getMapHeight();
        if (n <= 0) {
            n = this.getScreenHeight();
        }
        return n;
    }
}

