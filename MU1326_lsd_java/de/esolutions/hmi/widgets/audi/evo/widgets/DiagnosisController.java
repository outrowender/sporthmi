/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class DiagnosisController
extends IconController {
    public static final int IMAGE_IDX_WHITE = 0;
    public static final int IMAGE_IDX_YRAMP = 1;
    public static final int IMAGE_IDX_COLOR_BARS = 2;
    public static final int IMAGE_IDX_CHECKBOARD_1 = 3;
    public static final int IMAGE_IDX_CHECKBOARD_2 = 4;
    public static final int NO_IMAGE_IDX = 5;
    public static final int IMG_COL_IDX_IMAGE = 0;
    public static final int IMG_COL_IDX_COLOR = 1;
    public static final int NO_IMG_COL_IDX = 2;
    public static final int COLOR_WHITE = -1;
    public static final int COLOR_BLACK = -16777216;
    public static final int COLOR_RED__ = -65536;
    public static final int COLOR_GREEN = -16711936;
    public static final int COLOR_BLUE_ = -16776961;
    public static final int[][] IMAGE_COLOR_DATA = new int[][]{{0, -16777216}, {2, -1}, {0, -65536}, {0, -16711936}, {0, -16776961}, {0, -1}, {0, -16777216}, {3, -1}, {4, -1}, {1, -1}};
    private int width = 1;
    private int height = 1;
    private int currentModelValue = 0;

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Object getContent() {
        int n = IMAGE_COLOR_DATA[this.currentModelValue][0];
        return Util.createInteger(n);
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.width = this.terminal.getLayout().getDistance(1);
        this.height = this.terminal.getLayout().getDistance(2);
    }

    public void updateContent() {
        int n = this.getModelValue();
        if (n != this.currentModelValue) {
            this.currentModelValue = n;
            this.invalidateParentLayout();
            this.setCompositesDirty(true);
        }
    }

    public int getColor() {
        return IMAGE_COLOR_DATA[this.currentModelValue][1];
    }

    private int clampModelValues(int n) {
        return Math.max(0, Math.min(n, 9));
    }

    public int getModelValue() {
        ChoiceModelGUI choiceModelGUI;
        int n = 0;
        if (this.model instanceof ChoiceModelGUI && (choiceModelGUI = (ChoiceModelGUI)this.model).getStatus() != 3) {
            n = this.clampModelValues(choiceModelGUI.getValue());
        }
        return n;
    }
}

