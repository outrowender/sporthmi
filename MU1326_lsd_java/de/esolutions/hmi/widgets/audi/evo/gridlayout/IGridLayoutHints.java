/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public interface IGridLayoutHints
extends WidgetConstants,
Comparable {
    public static final int STATE_BIGSTAGE_EXPANDED = 1;
    public static final int STATE_BIGSTAGE_COLLAPSED = 2;
    public static final int STATE_SMALLSTAGE_EXPANDED = 4;
    public static final int STATE_SMALLSTAGE_COLLAPSED = 8;
    public static final int OVERLAP_NO_GAPS = 0;
    public static final int OVERLAP_TOP_GAP = 1;
    public static final int OVERLAP_BOTTOM_GAP = 2;
    public static final int OVERLAP_LEFT_GAP = 4;
    public static final int OVERLAP_RIGHT_GAP = 8;

    public boolean shouldShow(int var1);

    public int getOverlapGaps();

    public boolean isIgnoreForCellSizes();

    public int getColumn();

    public int getRow();

    public int getColumnSpan();

    public int getRowSpan();

    public int getWidthMin();

    public int getWidthMax();

    public int getHeightMin();

    public int getHeightMax();

    public int getAlignmentHoriz();

    public int getAlignmentVert();

    public int getVisibleConditions();

    public int getHidemode();

    public int getAdditionalXOffset();

    public int getAdditionalYOffset();

    public int getAdditionalWidthOffset();

    public int getAdditionalHeightOffset();
}

