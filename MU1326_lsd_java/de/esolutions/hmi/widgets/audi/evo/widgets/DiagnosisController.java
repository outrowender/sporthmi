/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class DiagnosisController
extends IconController {
    public static final int IMAGE_IDX_WHITE;
    public static final int IMAGE_IDX_YRAMP;
    public static final int IMAGE_IDX_COLOR_BARS;
    public static final int IMAGE_IDX_CHECKBOARD_1;
    public static final int IMAGE_IDX_CHECKBOARD_2;
    public static final int NO_IMAGE_IDX;
    public static final int IMG_COL_IDX_IMAGE;
    public static final int IMG_COL_IDX_COLOR;
    public static final int NO_IMG_COL_IDX;
    public static final int COLOR_WHITE;
    public static final int COLOR_BLACK;
    public static final int COLOR_RED__;
    public static final int COLOR_GREEN;
    public static final int COLOR_BLUE_;
    public static final int[][] IMAGE_COLOR_DATA;
    private int width = 1;
    private int height = 1;
    private int currentModelValue = 0;

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Object getContent() {
        int n = IMAGE_COLOR_DATA[this.currentModelValue][0];
        return Util.createInteger(n);
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.width = this.terminal.getLayout().getDistance(1);
        this.height = this.terminal.getLayout().getDistance(2);
    }

    @Override
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

    @Override
    public int getModelValue() {
        ChoiceModelGUI choiceModelGUI;
        int n = 0;
        if (this.model instanceof ChoiceModelGUI && (choiceModelGUI = (ChoiceModelGUI)this.model).getStatus() != 3) {
            n = this.clampModelValues(choiceModelGUI.getValue());
        }
        return n;
    }

    static {
        IMAGE_COLOR_DATA = new int[][]{{0, 255}, {2, -1}, {0, 65535}, {0, 0xFF00FF}, {0, -16776961}, {0, -1}, {0, 255}, {3, -1}, {4, -1}, {1, -1}};
    }
}

