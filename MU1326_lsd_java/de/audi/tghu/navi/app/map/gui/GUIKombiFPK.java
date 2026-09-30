/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.gui.GUIEventDispatcher;
import de.audi.tghu.navi.app.map.gui.GUIKombi;

public class GUIKombiFPK
extends GUIKombi {
    public GUIKombiFPK(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public String getName() {
        return "GUIKombiFPK";
    }

    public int getScreenLayoutAt(int n) {
        ListModelApp listModelApp = this.getDispatcher().getmScreenLayout();
        int n2 = 0;
        if (listModelApp != null && listModelApp.getLength() != 0 && n < listModelApp.getMaxColumns()) {
            IntegerListCell integerListCell = (IntegerListCell)listModelApp.getCell(1, n);
            n2 = integerListCell == null ? 0 : integerListCell.getValue();
        }
        return n2;
    }

    private GUIEventDispatcher getDispatcher() {
        return this.getMap().getMapManager().getGUIEventDispatcher();
    }

    public int getMixedListOffset() {
        return this.getScreenLayoutAt(5);
    }

    public int getRouteCriteriaBoxLeftOffset() {
        return this.getScreenLayoutAt(10);
    }

    public int getScreenSmallLeftOffset() {
        return this.getScreenLayoutAt(13);
    }

    public int getScreenSmallRightOffset() {
        return this.getScreenLayoutAt(14);
    }

    public int getSideBarWidth() {
        return this.getScreenLayoutAt(3);
    }

    public int getSideBarWidthAR() {
        return this.getScreenLayoutAt(4);
    }

    public int getSideBarWidthOpen() {
        return this.getScreenLayoutAt(3);
    }

    public int getStatusBarHeight() {
        return this.getScreenLayoutAt(2);
    }

    public int getTopLineHeight() {
        return this.getScreenLayoutAt(9);
    }

    public void setRotation(int n) {
    }
}

