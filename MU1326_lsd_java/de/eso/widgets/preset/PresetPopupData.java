/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.preset.Preset;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public class PresetPopupData
implements IPresetPopupData,
WidgetConstants {
    private int[] textIDs = null;
    private int[] bitmapIDs = null;
    private int presetLayoutType = 7;
    private int rowID = -1;
    private int[] stateStack = null;
    private Preset preset;
    private int cursorColor;
    private int result = 0;

    public PresetPopupData(int n, int n2, Preset preset, int[] nArray, int[] nArray2, int n3, int[] nArray3) {
        this.presetLayoutType = n;
        this.cursorColor = n2;
        this.preset = preset;
        this.textIDs = nArray;
        this.bitmapIDs = nArray2;
        this.rowID = n3;
        this.stateStack = nArray3;
    }

    public int getPresetType() {
        if (this.preset != null) {
            return this.preset.getType();
        }
        return -1;
    }

    public int getLayoutType() {
        return this.presetLayoutType;
    }

    public void setLayoutType(int n) {
        this.presetLayoutType = n;
    }

    public int getCursorColor() {
        return this.cursorColor;
    }

    public int[] getTextIDs() {
        return this.textIDs;
    }

    public void setTextIDs(int[] nArray) {
        this.textIDs = nArray;
    }

    public int[] getBitmapIDs() {
        return this.bitmapIDs;
    }

    public void setBitmapIDs(int[] nArray) {
        this.bitmapIDs = nArray;
    }

    public int getRowID() {
        return this.rowID;
    }

    public void setPreset(Preset preset) {
        this.preset = preset;
    }

    public Preset getPreset() {
        return this.preset;
    }

    public int[] getStateStack() {
        return this.stateStack;
    }

    public void setResult(int n) {
        this.result = n;
    }

    public int getResult() {
        return this.result;
    }
}

