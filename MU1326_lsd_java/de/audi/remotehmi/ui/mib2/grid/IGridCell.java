/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.remotehmi.ui.mib2.grid.IGeoLocatable;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridAction;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IGridListAction;
import de.audi.remotehmi.util.DeepCloneable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IGridCell
extends IGeoLocatable,
DeepCloneable {
    public static final int UNDEFINED = -1;
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_PROGRESS_BAR = 2;
    public static final int TYPE_INPUT = 3;
    public static final int TYPE_DROP_DOWN_LIST = 4;
    public static final int TYPE_CHECKBOX = 5;
    public static final int TYPE_RADIO_BUTTON = 6;
    public static final int TYPE_ARROW = 7;
    public static final int TYPE_UPDATING_ICON = 8;
    public static final int TYPE_INPUT_PIN = 9;
    public static final int TYPE_RRD_TEXT = 10;
    public static final int TYPE_RRD_IMAGE = 11;
    public static final int TYPE_SUBGRID = 12;
    public static final int TYPE_FORM_FIELD = 13;
    public static final int TYPE_SEPARATING_LINE = 14;
    public static final int TYPE_ROTARY_SELECTOR = 15;
    public static final int TYPE_SYSTEM_IMAGE = 16;
    public static final int TYPE_BUTTON = 17;
    public static final int TYPE_LABEL_IMAGE = 52;
    public static final List typeDescription = Collections.unmodifiableList(Arrays.asList(new String[]{"text", "image", "progressBar", "input", "dropDownList", "checkbox", "radioButton", "arrow", "updatingIcon", "inputPin", "rrdText", "rrdImage", "subgrid", "formField", "separatingLine", "rotarySelector", "systemImage", "button"}));
    public static final int LINE_END_ABBREVIATED = 0;
    public static final int LINE_END_WRAPPED = 1;
    public static final int LINE_END_CLIPPED = 2;
    public static final Map lineEndOptions = new HashMap(){
        private static final long serialVersionUID = 1224095838029567769L;
        {
            this.put("abbreviated", new Integer(0));
            this.put("wrapped", new Integer(1));
            this.put("clipped", new Integer(2));
        }
    };
    public static final int FONT_GIGANTIC = 0;
    public static final int FONT_HUGE = 1;
    public static final int FONT_BIG = 2;
    public static final int FONT_MEDIUM = 3;
    public static final int FONT_SMALL = 4;
    public static final int FONT_TINY = 5;
    public static final int FONT_VERY_TINY = 6;
    public static final int FONT_MEDIA_TITLE_NORMAL = 7;
    public static final int FONT_MEDIA_TITLE_BOLD = 8;
    public static final int FONT_MEDIA_ENTRY = 9;
    public static final int FONT_COUNT = 10;
    public static final Map fontOptions = new HashMap(){
        private static final long serialVersionUID = -3047474192697278387L;
        {
            this.put("gigantic", new Integer(0));
            this.put("huge", new Integer(1));
            this.put("big", new Integer(2));
            this.put("medium", new Integer(3));
            this.put("small", new Integer(4));
            this.put("tiny", new Integer(5));
            this.put("veryTiny", new Integer(6));
            this.put("mediaTitleNormal", new Integer(7));
            this.put("mediaTitleBold", new Integer(8));
            this.put("mediaEntry", new Integer(9));
        }
    };
    public static final int DEFAULT_FONT = 2;
    public static final int STYLE_NORMAL = 1;
    public static final int STYLE_ANNOTATION = 2;
    public static final Map styleOptions = new HashMap(){
        private static final long serialVersionUID = 5382273276954122401L;
        {
            this.put("normal", new Integer(1));
            this.put("annotation", new Integer(2));
        }
    };
    public static final int VISIBILITY_NORMAL = 0;
    public static final int VISIBILITY_HIGHLIGHTED = 1;
    public static final int VISIBILITY_HIDDEN = 2;
    public static final int VISIBILITY_NONE = 3;
    public static final Map visibilityOptions = new HashMap(){
        private static final long serialVersionUID = -133381886177378864L;
        {
            this.put("normal", new Integer(0));
            this.put("highlighted", new Integer(1));
            this.put("hidden", new Integer(2));
            this.put("none", new Integer(3));
        }
    };
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_CENT_H = 2;
    public static final int ALIGN_RIGHT = 3;
    public static final int ALIGN_TOP = 4;
    public static final int ALIGN_CENT_V = 5;
    public static final int ALIGN_BOTTOM = 6;
    public static final int ALIGN_BASE_LINE = 7;
    public static final int ALIGN_FILL_H = 8;
    public static final int ALIGN_FILL_V = 9;
    public static final Map horizontalAlignmentOptions = new HashMap(){
        private static final long serialVersionUID = -5178049973852710265L;
        {
            this.put("left", new Integer(1));
            this.put("center", new Integer(2));
            this.put("right", new Integer(3));
            this.put("filled", new Integer(8));
        }
    };
    public static final Map verticalAlignmentOptions = new HashMap(){
        private static final long serialVersionUID = -5396838055345565848L;
        {
            this.put("top", new Integer(4));
            this.put("center", new Integer(5));
            this.put("bottom", new Integer(6));
            this.put("filled", new Integer(9));
            this.put("baseLine", new Integer(7));
        }
    };
    public static final int DIRECTION_RIGHT = 0;
    public static final int DIRECTION_DOWN = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_TOP = 3;
    public static final Map directionOptions = new HashMap(){
        private static final long serialVersionUID = -1966711155117298664L;
        {
            this.put("right", new Integer(0));
            this.put("down", new Integer(1));
            this.put("left", new Integer(2));
            this.put("top", new Integer(3));
        }
    };
    public static final int ROLE_UNDEFINED = -1;
    public static final int ROLE_ARROW_COLLAPSED_GROUP = 0;
    public static final int ROLE_ARROW_EXPANDED_GROUP = 1;
    public static final int ROLE_ARROW_SUBMENU_ACTUAL = 2;
    public static final int ROLE_ARROW_SUBMENU_PREVIEW = 3;
    public static final int ROLE_ARROW_DEFAULT = 0;
    public static final Map roleArrowOptions = new HashMap(){
        private static final long serialVersionUID = 6388073090280857583L;
        {
            this.put("collapsedGroup", new Integer(0));
            this.put("expandedGroup", new Integer(1));
            this.put("submenuActual", new Integer(2));
            this.put("submenuPreview", new Integer(3));
        }
    };
    public static final int LAYOUT_UNDEFINED = -1;
    public static final int LAYOUT_MANUAL = 0;
    public static final int LAYOUT_AUTO = 1;
    public static final Map layoutOptions = new HashMap(){
        private static final long serialVersionUID = 9143967491524466192L;
        {
            this.put("manual", new Integer(0));
            this.put("auto", new Integer(1));
            this.put("shrink", new Integer(0));
            this.put("grow", new Integer(1));
        }
    };
    public static final int MAX_LINES_DEFAULT = 30;
    public static final int SCALE_MODE_FIXED_FACTOR = 0;
    public static final int SCALE_MODE_AUTOSCALE_FIT = 1;
    public static final int SCALE_MODE_AUTOSCALE_FILL = 2;
    public static final int SCALE_MODE_AUTOSCALE_STRETCH = 3;
    public static final Map scaleModeOptions = new HashMap(){
        private static final long serialVersionUID = 6388073090280857583L;
        {
            this.put("factor", new Integer(0));
            this.put("fit", new Integer(1));
            this.put("fill", new Integer(2));
            this.put("stretch", new Integer(3));
        }
    };
    public static final int AUTOSCALE_UP_AND_DOWN = 0;
    public static final int AUTOSCALE_ONLY_UP = 1;
    public static final int AUTOSCALE_ONLY_DOWN = 2;
    public static final Map scaleModificationsOptions = new HashMap(){
        private static final long serialVersionUID = 6388073090280857583L;
        {
            this.put("growAndShrink", new Integer(0));
            this.put("grow", new Integer(1));
            this.put("shrink", new Integer(2));
        }
    };
    public static final int COLOR_WHITE = 0;
    public static final int COLOR_GREEN = 1;
    public static final int COLOR_RED = 2;

    public int getGridRow();

    public void setGridRow(int var1);

    public int getGridColumn();

    public void setGridColumn(int var1);

    public int getFont();

    public void setFont(int var1);

    public IGrid.ExpandMode getWidthMode();

    public void setWidthMode(IGrid.ExpandMode var1);

    public int getMinWidth();

    public void setMinWidth(int var1);

    public int getMaxWidth();

    public void setMaxWidth(int var1);

    public int getHorizontalAlignment();

    public void setHorizontalAlignment(int var1);

    public int getVerticalAlignment();

    public void setVerticalAlignment(int var1);

    public boolean isEnabled();

    public void setEnabled(boolean var1);

    public int getVisibility();

    public void setVisibility(int var1);

    public int getInitialVisibility();

    public void setInitialVisibility(int var1);

    public int getLineEnd();

    public void setLineEnd(int var1);

    public int getMaxLines();

    public void setMaxLines(int var1);

    public int getColumnSpan();

    public void setColumnSpan(int var1);

    public int getRowSpan();

    public void setRowSpan(int var1);

    public int getType();

    public void setType(int var1);

    public String getStringValue();

    public void setStringValue(String var1);

    public boolean getBooleanValue();

    public void setBooleanValue(boolean var1);

    public int getIntValue();

    public void setIntValue(int var1);

    public IGrid getGridValue();

    public void setGridValue(IGrid var1);

    public int getModelColumn();

    public void setModelColumn(int var1);

    public int getMinHeight();

    public void setMinHeight(int var1);

    public int getMaxHeight();

    public void setMaxHeight(int var1);

    public int[] getHighlight();

    public void setHighlight(int[] var1);

    public IGridList getListValue();

    public void setListValue(IGridList var1);

    public String getTextConstantValue();

    public void setTextConstantValue(String var1);

    public boolean isReadOnly();

    public void setReadOnly(boolean var1);

    public void setBlocking(boolean var1);

    public boolean isBlocking();

    public int getDirection();

    public void setDirection(int var1);

    public int getRole();

    public void setRole(int var1);

    public String getLocalLocation();

    public void setLocalLocation(String var1);

    public boolean isIgnoreSize();

    public void setIgnoreSize(boolean var1);

    public float getRotationY();

    public void setRotationY(float var1);

    public float getRotationZ();

    public void setRotationZ(float var1);

    public int getScaleMode();

    public void setScaleMode(int var1);

    public int getScaleModification();

    public void setScaleModification(int var1);

    public float getScaleFactorY();

    public void setScaleFactorY(float var1);

    public float getScaleFactorX();

    public void setScaleFactorX(float var1);

    public boolean isOverlapLeftGap();

    public void setOverlapLeftGap(boolean var1);

    public boolean isOverlapRightGap();

    public void setOverlapRightGap(boolean var1);

    public boolean isOverlapTopGap();

    public void setOverlapTopGap(boolean var1);

    public boolean isOverlapBottomGap();

    public void setOverlapBottomGap(boolean var1);

    public int getMarginLeft();

    public void setMarginLeft(int var1);

    public int getMarginRight();

    public void setMarginRight(int var1);

    public int getMarginTop();

    public void setMarginTop(int var1);

    public int getMarginBottom();

    public void setMarginBottom(int var1);

    public void setStyle(int var1);

    public int getStyle();

    public void setActionValue(String var1);

    public String getActionValue();

    public boolean isDynamicallyUpdated();

    public void setDynamicallyUpdated(boolean var1);

    public boolean isRendered();

    public boolean containsHighlightedText();

    public void replaceTextConstants(String var1, ITextConstantsConverter var2);

    public int getOverlapGapsBitmask();

    public void setOverlapAllGaps();

    public void setMarginAllSides(int var1);

    public int forEachCell(IGridCellAction var1, int var2);

    public int forEachGrid(IGridAction var1, int var2);

    public int forEachList(IGridListAction var1, int var2);

    public void setSelectionId(String var1);

    public String getSelectionId();

    public void setLineHeight(int var1);

    public int getLineHeight();

    public void setLabelText(String var1);

    public String getLabelText();
}

