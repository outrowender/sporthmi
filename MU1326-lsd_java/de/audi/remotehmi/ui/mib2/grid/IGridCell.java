/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.remotehmi.ui.mib2.grid.IGeoLocatable;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGrid$ExpandMode;
import de.audi.remotehmi.ui.mib2.grid.IGridAction;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$1;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$10;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$11;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$2;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$3;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$4;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$5;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$6;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$7;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$8;
import de.audi.remotehmi.ui.mib2.grid.IGridCell$9;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IGridListAction;
import de.audi.remotehmi.util.DeepCloneable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface IGridCell
extends IGeoLocatable,
DeepCloneable {
    public static final int UNDEFINED;
    public static final int TYPE_TEXT;
    public static final int TYPE_IMAGE;
    public static final int TYPE_PROGRESS_BAR;
    public static final int TYPE_INPUT;
    public static final int TYPE_DROP_DOWN_LIST;
    public static final int TYPE_CHECKBOX;
    public static final int TYPE_RADIO_BUTTON;
    public static final int TYPE_ARROW;
    public static final int TYPE_UPDATING_ICON;
    public static final int TYPE_INPUT_PIN;
    public static final int TYPE_RRD_TEXT;
    public static final int TYPE_RRD_IMAGE;
    public static final int TYPE_SUBGRID;
    public static final int TYPE_FORM_FIELD;
    public static final int TYPE_SEPARATING_LINE;
    public static final int TYPE_ROTARY_SELECTOR;
    public static final int TYPE_SYSTEM_IMAGE;
    public static final int TYPE_BUTTON;
    public static final int TYPE_LABEL_IMAGE;
    public static final List typeDescription;
    public static final int LINE_END_ABBREVIATED;
    public static final int LINE_END_WRAPPED;
    public static final int LINE_END_CLIPPED;
    public static final Map lineEndOptions;
    public static final int FONT_GIGANTIC;
    public static final int FONT_HUGE;
    public static final int FONT_BIG;
    public static final int FONT_MEDIUM;
    public static final int FONT_SMALL;
    public static final int FONT_TINY;
    public static final int FONT_VERY_TINY;
    public static final int FONT_MEDIA_TITLE_NORMAL;
    public static final int FONT_MEDIA_TITLE_BOLD;
    public static final int FONT_MEDIA_ENTRY;
    public static final int FONT_COUNT;
    public static final Map fontOptions;
    public static final int DEFAULT_FONT;
    public static final int STYLE_NORMAL;
    public static final int STYLE_ANNOTATION;
    public static final Map styleOptions;
    public static final int VISIBILITY_NORMAL;
    public static final int VISIBILITY_HIGHLIGHTED;
    public static final int VISIBILITY_HIDDEN;
    public static final int VISIBILITY_NONE;
    public static final Map visibilityOptions;
    public static final int ALIGN_LEFT;
    public static final int ALIGN_CENT_H;
    public static final int ALIGN_RIGHT;
    public static final int ALIGN_TOP;
    public static final int ALIGN_CENT_V;
    public static final int ALIGN_BOTTOM;
    public static final int ALIGN_BASE_LINE;
    public static final int ALIGN_FILL_H;
    public static final int ALIGN_FILL_V;
    public static final Map horizontalAlignmentOptions;
    public static final Map verticalAlignmentOptions;
    public static final int DIRECTION_RIGHT;
    public static final int DIRECTION_DOWN;
    public static final int DIRECTION_LEFT;
    public static final int DIRECTION_TOP;
    public static final Map directionOptions;
    public static final int ROLE_UNDEFINED;
    public static final int ROLE_ARROW_COLLAPSED_GROUP;
    public static final int ROLE_ARROW_EXPANDED_GROUP;
    public static final int ROLE_ARROW_SUBMENU_ACTUAL;
    public static final int ROLE_ARROW_SUBMENU_PREVIEW;
    public static final int ROLE_ARROW_DEFAULT;
    public static final Map roleArrowOptions;
    public static final int LAYOUT_UNDEFINED;
    public static final int LAYOUT_MANUAL;
    public static final int LAYOUT_AUTO;
    public static final Map layoutOptions;
    public static final int MAX_LINES_DEFAULT;
    public static final int SCALE_MODE_FIXED_FACTOR;
    public static final int SCALE_MODE_AUTOSCALE_FIT;
    public static final int SCALE_MODE_AUTOSCALE_FILL;
    public static final int SCALE_MODE_AUTOSCALE_STRETCH;
    public static final Map scaleModeOptions;
    public static final int AUTOSCALE_UP_AND_DOWN;
    public static final int AUTOSCALE_ONLY_UP;
    public static final int AUTOSCALE_ONLY_DOWN;
    public static final Map scaleModificationsOptions;
    public static final int COLOR_WHITE;
    public static final int COLOR_GREEN;
    public static final int COLOR_RED;

    default public int getGridRow() {
    }

    default public void setGridRow(int n) {
    }

    default public int getGridColumn() {
    }

    default public void setGridColumn(int n) {
    }

    default public int getFont() {
    }

    default public void setFont(int n) {
    }

    default public IGrid$ExpandMode getWidthMode() {
    }

    default public void setWidthMode(IGrid$ExpandMode iGrid$ExpandMode) {
    }

    default public int getMinWidth() {
    }

    default public void setMinWidth(int n) {
    }

    default public int getMaxWidth() {
    }

    default public void setMaxWidth(int n) {
    }

    default public int getHorizontalAlignment() {
    }

    default public void setHorizontalAlignment(int n) {
    }

    default public int getVerticalAlignment() {
    }

    default public void setVerticalAlignment(int n) {
    }

    default public boolean isEnabled() {
    }

    default public void setEnabled(boolean bl) {
    }

    default public int getVisibility() {
    }

    default public void setVisibility(int n) {
    }

    default public int getInitialVisibility() {
    }

    default public void setInitialVisibility(int n) {
    }

    default public int getLineEnd() {
    }

    default public void setLineEnd(int n) {
    }

    default public int getMaxLines() {
    }

    default public void setMaxLines(int n) {
    }

    default public int getColumnSpan() {
    }

    default public void setColumnSpan(int n) {
    }

    default public int getRowSpan() {
    }

    default public void setRowSpan(int n) {
    }

    default public int getType() {
    }

    default public void setType(int n) {
    }

    default public String getStringValue() {
    }

    default public void setStringValue(String string) {
    }

    default public boolean getBooleanValue() {
    }

    default public void setBooleanValue(boolean bl) {
    }

    default public int getIntValue() {
    }

    default public void setIntValue(int n) {
    }

    default public IGrid getGridValue() {
    }

    default public void setGridValue(IGrid iGrid) {
    }

    default public int getModelColumn() {
    }

    default public void setModelColumn(int n) {
    }

    default public int getMinHeight() {
    }

    default public void setMinHeight(int n) {
    }

    default public int getMaxHeight() {
    }

    default public void setMaxHeight(int n) {
    }

    default public int[] getHighlight() {
    }

    default public void setHighlight(int[] nArray) {
    }

    default public IGridList getListValue() {
    }

    default public void setListValue(IGridList iGridList) {
    }

    default public String getTextConstantValue() {
    }

    default public void setTextConstantValue(String string) {
    }

    default public boolean isReadOnly() {
    }

    default public void setReadOnly(boolean bl) {
    }

    default public void setBlocking(boolean bl) {
    }

    default public boolean isBlocking() {
    }

    default public int getDirection() {
    }

    default public void setDirection(int n) {
    }

    default public int getRole() {
    }

    default public void setRole(int n) {
    }

    default public String getLocalLocation() {
    }

    default public void setLocalLocation(String string) {
    }

    default public boolean isIgnoreSize() {
    }

    default public void setIgnoreSize(boolean bl) {
    }

    default public float getRotationY() {
    }

    default public void setRotationY(float f2) {
    }

    default public float getRotationZ() {
    }

    default public void setRotationZ(float f2) {
    }

    default public int getScaleMode() {
    }

    default public void setScaleMode(int n) {
    }

    default public int getScaleModification() {
    }

    default public void setScaleModification(int n) {
    }

    default public float getScaleFactorY() {
    }

    default public void setScaleFactorY(float f2) {
    }

    default public float getScaleFactorX() {
    }

    default public void setScaleFactorX(float f2) {
    }

    default public boolean isOverlapLeftGap() {
    }

    default public void setOverlapLeftGap(boolean bl) {
    }

    default public boolean isOverlapRightGap() {
    }

    default public void setOverlapRightGap(boolean bl) {
    }

    default public boolean isOverlapTopGap() {
    }

    default public void setOverlapTopGap(boolean bl) {
    }

    default public boolean isOverlapBottomGap() {
    }

    default public void setOverlapBottomGap(boolean bl) {
    }

    default public int getMarginLeft() {
    }

    default public void setMarginLeft(int n) {
    }

    default public int getMarginRight() {
    }

    default public void setMarginRight(int n) {
    }

    default public int getMarginTop() {
    }

    default public void setMarginTop(int n) {
    }

    default public int getMarginBottom() {
    }

    default public void setMarginBottom(int n) {
    }

    default public void setStyle(int n) {
    }

    default public int getStyle() {
    }

    default public void setActionValue(String string) {
    }

    default public String getActionValue() {
    }

    default public boolean isDynamicallyUpdated() {
    }

    default public void setDynamicallyUpdated(boolean bl) {
    }

    default public boolean isRendered() {
    }

    default public boolean containsHighlightedText() {
    }

    default public void replaceTextConstants(String string, ITextConstantsConverter iTextConstantsConverter) {
    }

    default public int getOverlapGapsBitmask() {
    }

    default public void setOverlapAllGaps() {
    }

    default public void setMarginAllSides(int n) {
    }

    default public int forEachCell(IGridCellAction iGridCellAction, int n) {
    }

    default public int forEachGrid(IGridAction iGridAction, int n) {
    }

    default public int forEachList(IGridListAction iGridListAction, int n) {
    }

    default public void setSelectionId(String string) {
    }

    default public String getSelectionId() {
    }

    default public void setLineHeight(int n) {
    }

    default public int getLineHeight() {
    }

    default public void setLabelText(String string) {
    }

    default public String getLabelText() {
    }

    static {
        typeDescription = Collections.unmodifiableList(Arrays.asList(new String[]{"text", "image", "progressBar", "input", "dropDownList", "checkbox", "radioButton", "arrow", "updatingIcon", "inputPin", "rrdText", "rrdImage", "subgrid", "formField", "separatingLine", "rotarySelector", "systemImage", "button"}));
        lineEndOptions = new IGridCell$1();
        fontOptions = new IGridCell$2();
        styleOptions = new IGridCell$3();
        visibilityOptions = new IGridCell$4();
        horizontalAlignmentOptions = new IGridCell$5();
        verticalAlignmentOptions = new IGridCell$6();
        directionOptions = new IGridCell$7();
        roleArrowOptions = new IGridCell$8();
        layoutOptions = new IGridCell$9();
        scaleModeOptions = new IGridCell$10();
        scaleModificationsOptions = new IGridCell$11();
    }
}

