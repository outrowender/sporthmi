/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public interface IGridLayoutHints
extends WidgetConstants,
Comparable {
    public static final int STATE_BIGSTAGE_EXPANDED;
    public static final int STATE_BIGSTAGE_COLLAPSED;
    public static final int STATE_SMALLSTAGE_EXPANDED;
    public static final int STATE_SMALLSTAGE_COLLAPSED;
    public static final int OVERLAP_NO_GAPS;
    public static final int OVERLAP_TOP_GAP;
    public static final int OVERLAP_BOTTOM_GAP;
    public static final int OVERLAP_LEFT_GAP;
    public static final int OVERLAP_RIGHT_GAP;

    default public boolean shouldShow(int n) {
    }

    default public int getOverlapGaps() {
    }

    default public boolean isIgnoreForCellSizes() {
    }

    default public int getColumn() {
    }

    default public int getRow() {
    }

    default public int getColumnSpan() {
    }

    default public int getRowSpan() {
    }

    default public int getWidthMin() {
    }

    default public int getWidthMax() {
    }

    default public int getHeightMin() {
    }

    default public int getHeightMax() {
    }

    default public int getAlignmentHoriz() {
    }

    default public int getAlignmentVert() {
    }

    default public int getVisibleConditions() {
    }

    default public int getHidemode() {
    }

    default public int getAdditionalXOffset() {
    }

    default public int getAdditionalYOffset() {
    }

    default public int getAdditionalWidthOffset() {
    }

    default public int getAdditionalHeightOffset() {
    }
}

