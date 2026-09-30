/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.EvoListRow;

public class PresetListRow
extends EvoListRow {
    public static final int LAYOUT_TYPE = 0;
    public static final int MAIN_ICON = 1;
    public static final int MAIN_LABEL = 2;
    public static final int SUB_ICON = 3;
    public static final int SUB_LABEL = 4;
    public static final int MAIN_ICON_RL = 5;

    public PresetListRow() {
        super(0L, 6);
    }

    public void setRecordSet(int n) {
        this.setInteger(0, n);
    }

    public void setMainIconIndex(int n) {
        this.setInteger(1, n);
    }

    public int getMainIconIndex() {
        return this.getInteger(1);
    }

    public void setMainIcon(HMIResourceLocator hMIResourceLocator) {
        this.setHMIResourceLocator(5, hMIResourceLocator);
    }

    public HMIResourceLocator getMainIconRL() {
        return (HMIResourceLocator)this.getCell(5);
    }

    public void setMainLabel(String string) {
        this.setText(2, string);
    }

    public String getMainLabel() {
        return this.getText(2);
    }

    public void setSubIconIndex(int n) {
        this.setInteger(3, n);
    }

    public int getSubIconIndex() {
        return this.getInteger(3);
    }

    public void setSubLabel(String string) {
        this.setText(4, string);
    }

    public String getSubLabel() {
        return this.getText(4);
    }

    public String toString() {
        return this.getText(2) + " | " + this.getText(4);
    }
}

