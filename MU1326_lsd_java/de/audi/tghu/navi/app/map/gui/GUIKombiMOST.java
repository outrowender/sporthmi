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

    public String getName() {
        return "GUIKombiMOST";
    }

    public void updateChoiceValue(int n, int n2) {
        this.getEnv().getChoiceModel(n).setValue(n2);
    }

    public void refreshMapRepresentation() {
    }

    public int getMagnificationValue(int n) {
        this.fixme("getMagnificationValue");
        return this.getMap().getMapManager().getMapMain().getGuiInterface().getMagnificationValue(n);
    }

    public int getMagnificationMaximum(int n) {
        this.fixme("getMagnificationMaximum");
        return this.getMap().getMapManager().getMapMain().getGuiInterface().getMagnificationMaximum(n);
    }

    public int getMagnificationMinimum(int n) {
        this.fixme("getMagnificationMinimum");
        return this.getMap().getMapManager().getMapMain().getGuiInterface().getMagnificationMinimum(n);
    }

    public MapItemSelectionAction hideToolTip() {
        return null;
    }

    public void hideRouteCalculationScreen(boolean bl) {
    }

    public int getSidebarState() {
        return this.env.getChoiceModel(400447).getValue();
    }

    public void closeSidebarWithoutAnimation() {
    }

    public void openOrCloseSidebar(int n) {
    }

    public void switchToNormalSidebar() {
    }

    public void enableScrollInfo(boolean bl) {
    }

    public void setRotation(int n) {
    }

    public void enableOrientation(boolean bl) {
    }

    public void clearDestDistance() {
    }

    public void refreshMapType(int n) {
        this.warn("setMapType");
        this.env.getChoiceModel(400965).setValue(n);
    }

    public int getStatusBarHeight() {
        return 0;
    }

    public boolean isDemoMode() {
        return false;
    }

    public int getScreenWidth() {
        int n = super.getScreenWidth();
        if (n <= 0) {
            n = 800;
        }
        return n;
    }

    public int getScreenHeight() {
        int n = super.getScreenHeight();
        if (n <= 0) {
            n = 298;
        }
        return n;
    }

    public int getMapWidth() {
        int n = super.getMapWidth();
        if (n <= 0) {
            n = this.getScreenWidth();
        }
        return n;
    }

    public int getMapHeight() {
        int n = super.getMapHeight();
        if (n <= 0) {
            n = this.getScreenHeight();
        }
        return n;
    }
}

