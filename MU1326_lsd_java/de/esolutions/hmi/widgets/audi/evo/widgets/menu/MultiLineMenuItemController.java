/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyConfig;
import de.esolutions.hmi.widgets.audi.evo.MenuItemBuilder;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IAxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import java.util.Iterator;

public class MultiLineMenuItemController
extends LayoutContainerController
implements IMenuItemMultiLine {
    private LabelController label;
    private FocusedPropertyConfig property;
    private int widgetID = -1;
    private int internalID = -1;
    private int marginTop;
    private int marginBottom;
    private int glassplateInsetsTop;
    private int glassplateInsetsBottom;
    private int filledInsetsTop;
    private int filledInsetsBottom;
    private int leftGap = -1;
    private int rightGap = -1;
    private int oldFirstLineNumber;
    private int autoWrap = -1;
    private int labelId = -1;
    private int[] replacementModelIds;
    private int menuContentWidth;

    public MultiLineMenuItemController() {
        this.autoLayoutSetup = false;
    }

    protected void initializeWidget() {
        this.oldFirstLineNumber = 0;
        this.initializeLabel();
        super.initializeWidget();
    }

    protected void afterConnected() {
        this.initializeLayout();
        super.afterConnected();
    }

    private void initializeLabel() {
        if (this.label != null) {
            return;
        }
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof LabelController)) continue;
            this.label = (LabelController)abstractWidgetController;
            return;
        }
        MenuItemBuilder.configureMultiLineMenuItem(this, (ExtHMITerminalEvo)((Object)this.getTerminalImpl()));
    }

    private AbstractWidgetController findBackgroundWidget() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof FormfieldInputController)) continue;
            IRenderer iRenderer = abstractWidgetController.getRenderer();
            if (iRenderer instanceof FormfieldInputRenderer) {
                ((FormfieldInputRenderer)iRenderer).setUseControllerHeight(true);
                ((FormfieldInputRenderer)iRenderer).setEnableYTranslation(false);
            }
            return abstractWidgetController;
        }
        return null;
    }

    private void initializeLayout() {
        if (this.layoutManager != null) {
            return;
        }
        Layout layout = this.getTerminalImpl().getLayout();
        int n = layout.getIntegerConstant(14);
        int n2 = layout.getIntegerConstant(15);
        this.leftGap = this.leftGap == -1 ? layout.getIntegerConstant(16) : this.leftGap;
        this.rightGap = this.rightGap == -1 ? layout.getIntegerConstant(17) : this.rightGap;
        int n3 = ((MenuController)this.getParent()).getLayout().getItemsGap();
        this.filledInsetsTop = n;
        this.filledInsetsBottom = n2 - (this.getLineHeight() - this.getFontHeight()) + n3;
        GridLayout gridLayout = new GridLayout(1, 1);
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        AxisConstraints axisConstraints2 = (AxisConstraints)gridLayout.getRowConstraints();
        axisConstraints.setGaps(new int[]{this.leftGap, this.rightGap});
        axisConstraints.setAlignment(new int[]{8});
        axisConstraints.setGrow(new float[]{1.0f});
        axisConstraints2.setGaps(new int[]{n, n2});
        axisConstraints2.setAlignment(new int[]{9});
        axisConstraints2.setGrow(new float[]{1.0f});
        AbstractWidgetController abstractWidgetController = this.findBackgroundWidget();
        if (this.label != null && abstractWidgetController != null) {
            gridLayout.setCellConstraints(new GridLayoutHints[]{this.createLabelLayoutHints(), this.createBackgroundLayoutHints()}, new Object[]{this.label, abstractWidgetController});
        } else if (this.label != null) {
            gridLayout.setCellConstraints(new GridLayoutHints[]{this.createLabelLayoutHints()}, new Object[]{this.label});
        } else {
            gridLayout.setCellConstraints(new GridLayoutHints[0], new Object[0]);
        }
        this.setLayoutManager(gridLayout);
    }

    private GridLayoutHints createBackgroundLayoutHints() {
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.overlapGaps = 15;
        gridLayoutHints.ignoreForCellSizes = true;
        return gridLayoutHints;
    }

    private GridLayoutHints createLabelLayoutHints() {
        return new GridLayoutHints(0, 0);
    }

    public void setLabel(LabelController labelController) {
        if (this.label != null) {
            this.remove(this.label);
        }
        this.label = labelController;
        if (this.label != null) {
            this.add(this.label);
        }
    }

    public LabelController getLabel() {
        return this.label;
    }

    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof FocusedPropertyConfig) {
            this.property = (FocusedPropertyConfig)abstractWidget;
        }
    }

    public void remove(AbstractWidget abstractWidget) {
        super.remove(abstractWidget);
        if (abstractWidget == this.property) {
            this.property = null;
        }
    }

    private LabelRenderer getLabelRenderer() {
        if (this.label != null) {
            return (LabelRenderer)this.label.getRenderer();
        }
        return null;
    }

    public void showExtended(boolean bl) {
    }

    public int getPreferredHeight(boolean bl, int n) {
        if (this.getHasDynamicLayout() && this.preferredHeight == -1) {
            return this.layoutManager.calculateSize(this, n)[1];
        }
        return this.getPreferredHeight();
    }

    public IFocusedPropertyObject getProperty() {
        if (this.property != null) {
            IFocusedPropertyObject iFocusedPropertyObject = this.property.getCurrentFocusedPropertyObject();
            if (iFocusedPropertyObject != null) {
                if (this.modelID != -1) {
                    iFocusedPropertyObject.setModelID(this.modelID);
                }
                if (this.widgetID != -1) {
                    iFocusedPropertyObject.setWidgetID(this.widgetID);
                }
            }
            return iFocusedPropertyObject;
        }
        return null;
    }

    public int getSizeForTabulator(int n) {
        return -1;
    }

    public boolean isSelected() {
        return false;
    }

    public int getMargin(boolean bl) {
        return bl ? this.marginTop : this.marginBottom;
    }

    public int getGlassplateInsets(boolean bl) {
        return bl ? this.glassplateInsetsTop : this.glassplateInsetsBottom;
    }

    public int getFilledInsets(boolean bl) {
        return bl ? this.filledInsetsTop : this.filledInsetsBottom;
    }

    public int getWidgetID() {
        return this.widgetID;
    }

    public int getSdsItemSelectedAction() {
        return 0;
    }

    public int getSubItemCount() {
        LabelRenderer labelRenderer = this.getLabelRenderer();
        if (labelRenderer != null) {
            return Math.max(1, labelRenderer.getNumberOfRows(this.getEffectiveLabelWidth()));
        }
        return 1;
    }

    private int getEffectiveLabelWidth() {
        return this.menuContentWidth - this.getGridSideGaps();
    }

    private int getGridSideGaps() {
        if (this.layoutManager instanceof GridLayout) {
            IAxisConstraints iAxisConstraints = ((GridLayout)this.layoutManager).getColumnConstraints();
            if (iAxisConstraints.getLength() > 0) {
                return iAxisConstraints.getGap(0) + iAxisConstraints.getGap(iAxisConstraints.getLength());
            }
            return 0;
        }
        return 0;
    }

    public int getPreferredLineHeight(int n) {
        return this.getLineHeight();
    }

    protected int getLineHeight() {
        LabelRenderer labelRenderer = this.getLabelRenderer();
        if (labelRenderer != null) {
            return labelRenderer.getPreferredLineHeight();
        }
        return 20;
    }

    protected int getFontHeight() {
        LabelRenderer labelRenderer = this.getLabelRenderer();
        if (labelRenderer != null) {
            return labelRenderer.getFontHeight();
        }
        return 20;
    }

    public void setVisibleAreaBounds(int n, int n2, int n3) {
        this.setY(n);
        this.setHeight(n3);
        LabelRenderer labelRenderer = this.getLabelRenderer();
        if (labelRenderer != null && this.oldFirstLineNumber != n2) {
            labelRenderer.setFirstVisibleLine(n2);
            this.label.setCompositesDirty(true);
            this.oldFirstLineNumber = n2;
        }
    }

    public boolean isFocusable() {
        return false;
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    public void setMarginTop(int n) {
        this.marginTop = n;
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public void setMarginBottom(int n) {
        this.marginBottom = n;
    }

    public int getGlassplateInsetsTop() {
        return this.glassplateInsetsTop;
    }

    public void setGlassplateInsetsTop(int n) {
        this.glassplateInsetsTop = n;
    }

    public int getGlassplateInsetsBottom() {
        return this.glassplateInsetsBottom;
    }

    public void setGlassplateInsetsBottom(int n) {
        this.glassplateInsetsBottom = n;
    }

    public int getFilledInsetsTop() {
        return this.filledInsetsTop;
    }

    public void setFilledInsetsTop(int n) {
        this.filledInsetsTop = n;
    }

    public int getFilledInsetsBottom() {
        return this.filledInsetsBottom;
    }

    public void setFilledInsetsBottom(int n) {
        this.filledInsetsBottom = n;
    }

    public boolean hasInfolineText() {
        return false;
    }

    public String getInfolineText() {
        return null;
    }

    public void setType(int n) {
        if (n != 32) {
            menuItemLogCh.log(10000, "MultiLineMenuItemController#setType: multiLine item supporty only type LABEL_MULTILINE, but has type: %1", (long)n);
        }
    }

    public int getAutoWrap() {
        return this.autoWrap;
    }

    public void setAutoWrap(int n) {
        this.autoWrap = n;
    }

    public int[] getReplacementModelIds() {
        return this.replacementModelIds;
    }

    public void setReplacementModelIds(int[] nArray) {
        this.replacementModelIds = nArray;
    }

    public int getLabelId() {
        return this.labelId;
    }

    public void setLabelId(int n) {
        this.labelId = n;
    }

    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    public int getMenuContentWidth() {
        return this.menuContentWidth;
    }

    public void setMenuSize(int n, int n2, int n3) {
        this.menuContentWidth = n;
        this.setOptionsIconSpace(n3);
    }

    public int getInternalID() {
        return this.internalID;
    }

    public void setInternalID(int n) {
        this.internalID = n;
    }

    public boolean isScrollLineByLine() {
        return true;
    }

    public int getOptionIconYOffset() {
        return 0;
    }

    public void setFocusable(boolean bl) {
        if (!bl) {
            menuItemLogCh.log(10000, "MultiLineMenuItemController#setFocusable: multiLine item can not be focusable, but setFocusable was called with true");
        }
    }

    public void setLeftGap(int n) {
        this.leftGap = n;
    }

    public int getLeftGap() {
        return this.leftGap;
    }

    public void setRightGap(int n) {
        this.rightGap = n;
    }

    public int getRightGap() {
        return this.rightGap;
    }

    public boolean isHasInfolineDisclaimer() {
        return false;
    }

    public void setHasInfolineDisclaimer(boolean bl) {
    }

    public int getSdsItemSelectedAction(int n) {
        return 0;
    }

    public void setOptionsIconSpace(int n) {
        this.setOptionsIconSpace(n, this.layoutManager);
    }

    private void setOptionsIconSpace(int n, LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayout) {
            IAxisConstraints iAxisConstraints = ((GridLayout)layoutManager).getColumnConstraints();
            if (iAxisConstraints instanceof MenuItemColumnsConstraints) {
                MenuItemColumnsConstraints menuItemColumnsConstraints = (MenuItemColumnsConstraints)iAxisConstraints;
                if (menuItemColumnsConstraints.rightOptionsIconSpace != n) {
                    menuItemColumnsConstraints.rightOptionsIconSpace = n;
                    this.flushLayoutCache();
                    this.invalidateChildrenBounds();
                }
            } else {
                menuItemLogCh.log(100000, "MultiLineMenuItemController#setOptionsIconSpace: columnConstraints have no optionsIconSpace. Space: %2, Constraints: %1", (Object)iAxisConstraints, (long)n);
            }
        }
    }

    public void setCursorOffsetTop(int n) {
        this.setMarginTop(n);
    }

    public int getNoCursorArea(boolean bl) {
        return 0;
    }
}

