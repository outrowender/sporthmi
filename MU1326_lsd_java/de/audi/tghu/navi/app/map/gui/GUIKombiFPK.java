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

    @Override
    public String getName() {
        return "GUIKombiFPK";
    }

    @Override
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

    @Override
    public int getMixedListOffset() {
        return this.getScreenLayoutAt(5);
    }

    @Override
    public int getRouteCriteriaBoxLeftOffset() {
        return this.getScreenLayoutAt(10);
    }

    @Override
    public int getScreenSmallLeftOffset() {
        return this.getScreenLayoutAt(13);
    }

    @Override
    public int getScreenSmallRightOffset() {
        return this.getScreenLayoutAt(14);
    }

    @Override
    public int getSideBarWidth() {
        return this.getScreenLayoutAt(3);
    }

    @Override
    public int getSideBarWidthAR() {
        return this.getScreenLayoutAt(4);
    }

    @Override
    public int getSideBarWidthOpen() {
        return this.getScreenLayoutAt(3);
    }

    @Override
    public int getStatusBarHeight() {
        return this.getScreenLayoutAt(2);
    }

    @Override
    public int getTopLineHeight() {
        return this.getScreenLayoutAt(9);
    }

    @Override
    public void setRotation(int n) {
    }
}

