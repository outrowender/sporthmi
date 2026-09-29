/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;

public class MainMapView$TooltipRow
extends EvoListRow {
    public static MainMapView$TooltipRow createTextOnly(String string) {
        return new MainMapView$TooltipRow(0, string, null, null, null, -1);
    }

    public static MainMapView$TooltipRow createStack(String string) {
        return new MainMapView$TooltipRow(0, string, null, null, null, 2);
    }

    public static MainMapView$TooltipRow createPOI(String string, int n) {
        HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(n);
        return new MainMapView$TooltipRow(1, string, hMIResourceLocator, null, null, -1);
    }

    public static MainMapView$TooltipRow createOnline(String string) {
        return new MainMapView$TooltipRow(0, string, null, null, null, 1);
    }

    public static MainMapView$TooltipRow createTMC(String string, IconCell iconCell, IconCell iconCell2) {
        MainMapView$TooltipRow mainMapView$TooltipRow = new MainMapView$TooltipRow(2, string, null, null, null, -1);
        mainMapView$TooltipRow.setIconCell(3, iconCell);
        mainMapView$TooltipRow.setIconCell(4, iconCell2);
        return mainMapView$TooltipRow;
    }

    public static MainMapView$TooltipRow createPicNav(String string) {
        return new MainMapView$TooltipRow(3, string, null, null, null, -1);
    }

    public static MainMapView$TooltipRow createEmpty() {
        return new MainMapView$TooltipRow();
    }

    protected MainMapView$TooltipRow(EvoListRow evoListRow) {
        super(evoListRow);
        this.setInteger(0, evoListRow.getInteger(0));
        this.setText(1, evoListRow.getText(1));
        this.setIconCell(2, (IconCell)evoListRow.getCell(2));
        this.setIconCell(3, (IconCell)evoListRow.getCell(3));
        this.setIconCell(4, (IconCell)evoListRow.getCell(4));
        this.setInteger(5, evoListRow.getInteger(5));
    }

    protected MainMapView$TooltipRow() {
        this(-1, "", null, null, null, -1);
    }

    protected MainMapView$TooltipRow(int n, String string, HMIResourceLocator hMIResourceLocator, HMIResourceLocator hMIResourceLocator2, HMIResourceLocator hMIResourceLocator3, int n2) {
        super(0L, 6);
        this.setInteger(0, n);
        this.setText(1, string);
        this.setIconCell(2, new IconCell(hMIResourceLocator));
        this.setIconCell(3, new IconCell(hMIResourceLocator2));
        this.setIconCell(4, new IconCell(hMIResourceLocator3));
        this.setInteger(5, n2);
    }
}

