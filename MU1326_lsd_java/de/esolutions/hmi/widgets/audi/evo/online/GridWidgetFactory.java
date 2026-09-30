/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIGuideIcon;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridColumn;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IGridRow;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.PreferredSize;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyConfig;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.online.GridListItemFactory;
import de.esolutions.hmi.widgets.audi.evo.online.IGridImageLocker;
import de.esolutions.hmi.widgets.audi.evo.online.IInfiniteListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.online.WidgetUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.IListWidgetDataAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListLayoutCalculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class GridWidgetFactory {
    protected final AbstractScreenFactory factory;
    protected final int terminalId;
    protected static final LogChannel log = AbstractWidget.framework.getLogChannel("App.Online.RemoteHMI");
    public static final int LAYOUT_MAIN = 0;
    public static final int LAYOUT_MEDIA = 1;
    public static final int LAYOUT_DETAIL = 2;
    public static final int LAYOUT_ARTIFICIAL = 3;
    public static final int LAYOUT_COUNT = 4;
    public static int SPELLER_INPUT_TYPE_GENERIC = 0;
    public static int SPELLER_INPUT_TYPE_PIN = 1;
    public static int COLOR_WHITE = 0;
    public static int COLOR_BLACK = 1;
    public static int COLOR_ENABLED_ANNOTATION = 7;
    public static int COLOR_DISABLED = 4;
    public static int COLOR_CURSOR = 3;
    public static int COLOR_HIGHLIGHT = 3;
    public static int COLOR_INDEX_BACKGROUND = 0;
    public static int COLOR_INDEX_ENABLED = 1;
    public static int COLOR_INDEX_DISABLED = 2;
    public static int COLOR_INDEX_HIGHLIGHT = 3;
    public static int COLOR_INDEX_CURSOR = 4;
    public static int COLOR_INDEX_DROPDOWN_BACKGROUND = 5;
    private static int DEFAULT_HORIZONTAL_GAP_SIZE = 10;
    private static final Map systemImageGuideIcons;
    protected IGridImageLocker lockController;
    public static List MULTI_LINE_LABLE_LINEHEIGHT_FONTS_TT;
    public static List RESOLUTION_FONT_LIST;

    public GridWidgetFactory(int n, AbstractScreenFactory abstractScreenFactory) {
        if (abstractScreenFactory == null) {
            throw new IllegalArgumentException("GridMenuChanger.Constructor(): Argument factory is not allowed to be null!");
        }
        this.terminalId = n;
        this.factory = abstractScreenFactory;
    }

    public static GridLayout createLayoutWithConstraints(IGrid iGrid) {
        int n = iGrid.getRenderedCellCount();
        int n2 = iGrid.getRowCount();
        int n3 = iGrid.getColumnCount();
        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(n3);
        menuItemColumnsConstraints.grow = new float[n3];
        menuItemColumnsConstraints.shrink = new float[n3];
        menuItemColumnsConstraints.gaps = new int[n3 + 1];
        menuItemColumnsConstraints.tabulatorIDs = new int[n3 + 1];
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        AxisConstraints axisConstraints = new AxisConstraints(n2);
        axisConstraints.gaps = new int[n2 + 1];
        axisConstraints.grow = new float[n2];
        axisConstraints.shrink = new float[n2];
        gridLayout.setRowConstraints(axisConstraints);
        Arrays.fill(menuItemColumnsConstraints.gaps, DEFAULT_HORIZONTAL_GAP_SIZE);
        LayoutContainerController.assignDefaultGaps(axisConstraints.gaps, menuItemColumnsConstraints.gaps);
        Arrays.fill(menuItemColumnsConstraints.tabulatorIDs, -1);
        IGridLayoutHints[] iGridLayoutHintsArray = new GridLayoutHints[n];
        Object[] objectArray = new Object[n];
        gridLayout.setCellConstraints(iGridLayoutHintsArray, objectArray);
        return gridLayout;
    }

    public GridLayout createLayoutWithWidgets(IGrid iGrid, Object object, LayoutContainerController layoutContainerController, int n, SpellerListener spellerListener, boolean bl) {
        Object object2;
        Object object3;
        Object object4;
        GridLayout gridLayout = GridWidgetFactory.createLayoutWithConstraints(iGrid);
        List list = iGrid.getColumns();
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        int[] nArray = axisConstraints.gaps;
        float[] fArray = axisConstraints.grow;
        float[] fArray2 = axisConstraints.shrink;
        int n2 = -1;
        int n3 = Math.min(list.size(), nArray.length - 1);
        for (int i2 = 0; i2 < n3; ++i2) {
            object4 = (IGridColumn)list.get(i2);
            if (object4.getGapBefore() != -1) {
                int n4 = nArray[i2] = n2 == -1 ? object4.getGapBefore() : Math.max(nArray[i2], object4.getGapBefore());
            }
            if (object4.getGapAfter() != -1) {
                nArray[i2 + 1] = object4.getGapAfter();
            }
            if ((object3 = (Object)object4.getWidthMode()) != null) {
                fArray2[i2] = ((IGrid.ExpandMode)object3).isShrinkable() ? 1.0f : 0.0f;
                fArray[i2] = ((IGrid.ExpandMode)object3).isGrowable() ? 1.0f : 0.0f;
            }
            n2 = object4.getGapAfter();
        }
        List list2 = iGrid.getRows();
        AxisConstraints axisConstraints2 = (AxisConstraints)gridLayout.getRowConstraints();
        object4 = axisConstraints2.gaps;
        object3 = axisConstraints2.grow;
        float[] fArray3 = axisConstraints2.shrink;
        int n5 = -1;
        int n6 = Math.min(list2.size(), ((Object)object4).length - 1);
        for (int i3 = 0; i3 < n6; ++i3) {
            IGridRow iGridRow = (IGridRow)list2.get(i3);
            if (iGridRow.getGapBefore() != -1) {
                object4[i3] = n5 == -1 ? iGridRow.getGapBefore() : Math.max((int)object4[i3], iGridRow.getGapBefore());
            }
            if (iGridRow.getGapAfter() != -1) {
                object4[i3 + 1] = iGridRow.getGapAfter();
            }
            if ((object2 = iGridRow.getHeightMode()) != null) {
                fArray3[i3] = ((IGrid.ExpandMode)object2).isShrinkable() ? 1.0f : 0.0f;
                object3[i3] = ((IGrid.ExpandMode)object2).isGrowable() ? 1.0f : 0.0f;
            }
            n5 = iGridRow.getGapAfter();
        }
        int[] nArray2 = axisConstraints.tabulatorIDs;
        int n7 = Math.min(list.size(), nArray2.length - 1);
        for (n6 = 0; n6 < n7; ++n6) {
            object2 = (IGridColumn)list.get(n6);
            nArray2[n6] = object2.getTabIndex();
        }
        IGridLayoutHints[] iGridLayoutHintsArray = gridLayout.getWidgetConstraints();
        Object[] objectArray = gridLayout.getCells();
        int n8 = 0;
        ListIterator listIterator = iGrid.listIterator();
        while (listIterator.hasNext()) {
            int n9;
            WidgetConstants widgetConstants;
            IGridCell iGridCell = (IGridCell)listIterator.next();
            int n10 = iGridCell.getGridColumn();
            int n11 = iGridCell.getGridRow();
            if (!iGridCell.isRendered()) continue;
            Object object5 = this.createWidget(iGridCell, object, n, spellerListener, layoutContainerController, bl);
            if (object5 instanceof AbstractWidgetController) {
                IRenderer iRenderer;
                PreferredSize preferredSize;
                widgetConstants = (AbstractWidgetController)object5;
                if (widgetConstants instanceof LayoutContainerController) {
                    preferredSize = (LayoutContainerController)widgetConstants;
                    if (((AbstractWidgetController)preferredSize).getChildrenSize() != 1) {
                        iRenderer = null;
                    } else {
                        AbstractWidget abstractWidget = ((AbstractWidgetController)preferredSize).getChild(0);
                        if (!(abstractWidget instanceof AbstractWidgetController)) {
                            iRenderer = null;
                        } else {
                            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)abstractWidget;
                            iRenderer = abstractWidgetController.getRenderer();
                        }
                    }
                } else {
                    iRenderer = ((AbstractWidgetController)widgetConstants).getRenderer();
                }
                if (iRenderer instanceof IconRenderer) {
                    preferredSize = (IconRenderer)iRenderer;
                    preferredSize.setAutoscaleModification(iGridCell.getScaleModification());
                    preferredSize.setScaleMode(iGridCell.getScaleMode());
                    preferredSize.setScaleFactor(iGridCell.getScaleFactorX(), iGridCell.getScaleFactorY());
                    preferredSize.setRotationY(iGridCell.getRotationY());
                    preferredSize.setRotationZ(iGridCell.getRotationZ());
                }
                ((AbstractWidget)widgetConstants).setChainedAction(0, 0);
                ((AbstractWidget)widgetConstants).setEnabled(iGridCell.isEnabled());
                n9 = iGridCell.getVisibility();
                ((AbstractWidgetController)widgetConstants).setVisible(n9 != 2);
                ((AbstractWidget)widgetConstants).setHighlighted(n9 == 1);
                objectArray[n8] = widgetConstants;
                layoutContainerController.add((AbstractWidget)widgetConstants);
            } else if (object5 instanceof GridLayout) {
                widgetConstants = (GridLayout)object5;
                objectArray[n8] = widgetConstants;
            } else {
                throw new IllegalStateException("Widget must be either a widget controller or a subgrid! widget=" + object5);
            }
            widgetConstants = new GridLayoutHints(n10, n11, iGridCell.getColumnSpan(), iGridCell.getRowSpan());
            ((GridLayoutHints)widgetConstants).setWidthMax(iGridCell.getMaxWidth());
            ((GridLayoutHints)widgetConstants).setWidthMin(iGridCell.getMinWidth());
            ((GridLayoutHints)widgetConstants).setHeightMax(iGridCell.getMaxHeight());
            ((GridLayoutHints)widgetConstants).setHeightMin(iGridCell.getMinHeight());
            ((GridLayoutHints)widgetConstants).setAlignmentHoriz(iGridCell.getHorizontalAlignment());
            ((GridLayoutHints)widgetConstants).setAlignmentVert(iGridCell.getVerticalAlignment());
            ((GridLayoutHints)widgetConstants).setHidemode(1);
            ((GridLayoutHints)widgetConstants).setIgnoreForCellSizes(iGridCell.isIgnoreSize());
            ((GridLayoutHints)widgetConstants).setOverlapGaps(iGridCell.getOverlapGapsBitmask());
            int n12 = iGridCell.getMarginLeft();
            n9 = iGridCell.getMarginTop();
            ((GridLayoutHints)widgetConstants).setAfterEffects(n12, n9, -iGridCell.getMarginRight() - n12, -iGridCell.getMarginBottom() - n9);
            boolean bl2 = iGridCell.isBlocking();
            log.log(10000000, "GridWidgetFactory#createLayoutWithWidgets: type=%1, blocking=%2.", (Object)Integer.toString(iGridCell.getType()), (Object)Boolean.toString(bl2));
            iGridLayoutHintsArray[n8] = widgetConstants;
            ++n8;
        }
        return gridLayout;
    }

    private int getTextWidgetId(int n, boolean bl, boolean bl2) {
        if (bl) {
            switch (n) {
                case 0: {
                    return 5;
                }
                case 1: {
                    return 9;
                }
                case 2: {
                    return 11;
                }
                case 3: {
                    return 7;
                }
                case 4: {
                    return 13;
                }
                case 5: {
                    return 15;
                }
                case 6: {
                    return 17;
                }
                case 8: {
                    return 20;
                }
                case 7: {
                    return 19;
                }
                case 9: {
                    return 21;
                }
            }
            throw new IllegalArgumentException("Type = " + n + " of font with highlight is unknown! Add it to case-statement above!");
        }
        if (bl2) {
            switch (n) {
                case 0: {
                    return 85;
                }
                case 1: {
                    return 87;
                }
                case 2: {
                    return 88;
                }
                case 3: {
                    return 86;
                }
                case 4: {
                    return 89;
                }
                case 5: {
                    return 90;
                }
                case 6: {
                    return 91;
                }
                case 8: {
                    return 20;
                }
                case 7: {
                    return 19;
                }
                case 9: {
                    return 21;
                }
            }
            throw new IllegalArgumentException("Type = " + n + " of font is unknown! Add it to case-statement above!");
        }
        switch (n) {
            case 0: {
                return 6;
            }
            case 1: {
                return 10;
            }
            case 2: {
                return 12;
            }
            case 3: {
                return 8;
            }
            case 4: {
                return 14;
            }
            case 5: {
                return 16;
            }
            case 6: {
                return 18;
            }
            case 8: {
                return 20;
            }
            case 7: {
                return 19;
            }
            case 9: {
                return 21;
            }
        }
        throw new IllegalArgumentException("Type = " + n + " of font is unknown! Add it to case-statement above!");
    }

    private Object createWidget(IGridCell iGridCell, Object object, int n, SpellerListener spellerListener, LayoutContainerController layoutContainerController, boolean bl) {
        switch (iGridCell.getType()) {
            case 1: {
                return this.createImageWidget(iGridCell.getStringValue());
            }
            case 0: {
                return this.createTextWidget(iGridCell, bl);
            }
            case 2: {
                return this.createProgressBarWidget(iGridCell.getIntValue());
            }
            case 3: {
                return this.createInputWidget(iGridCell.getStringValue(), n, iGridCell.isReadOnly(), SPELLER_INPUT_TYPE_GENERIC, spellerListener);
            }
            case 9: {
                return this.createInputWidget(iGridCell.getStringValue(), n, iGridCell.isReadOnly(), SPELLER_INPUT_TYPE_PIN, spellerListener);
            }
            case 4: {
                return this.createDropDownListWidget(iGridCell, n, (ChoiceListener)object);
            }
            case 5: {
                return this.createCheckboxWidget(iGridCell.getBooleanValue(), iGridCell.isEnabled(), n, (ChoiceListener)object);
            }
            case 6: {
                return this.createRadioButtonWidget(iGridCell.getBooleanValue());
            }
            case 7: {
                return this.createArrowWidget(iGridCell.getRole());
            }
            case 8: {
                return this.createUpdatingIconWidget();
            }
            case 14: {
                return this.createSeparatingLineWidget();
            }
            case 15: {
                return this.createRotarySelectorWidget();
            }
            case 10: {
                return this.createTextWidget(iGridCell, bl);
            }
            case 11: {
                return this.createRrdImageWidget(iGridCell);
            }
            case 13: {
                return this.createFormFieldWidget();
            }
            case 16: {
                return this.createSystemImageWidget(iGridCell.getStringValue());
            }
            case 12: {
                return this.createLayoutWithWidgets(iGridCell.getGridValue(), object, layoutContainerController, n, spellerListener, bl);
            }
        }
        throw new IllegalArgumentException("Type = " + iGridCell.getType() + " of grid cell is unknown! Add it to case-statement above! Column=" + iGridCell.getGridColumn() + ", row=" + iGridCell.getGridRow());
    }

    private AbstractWidgetController createInputWidget(String string, int n, boolean bl, int n2, SpellerListener spellerListener) {
        int n3;
        if (bl) {
            n3 = 41;
        } else if (n2 == SPELLER_INPUT_TYPE_GENERIC) {
            n3 = 23;
        } else if (n2 == SPELLER_INPUT_TYPE_PIN) {
            n3 = 42;
        } else {
            throw new IllegalArgumentException("GridWidgetFactory#createInputWidget()type unknown= " + n2);
        }
        TouchController touchController = (TouchController)this.getWidgetTemplate(n3);
        touchController.setInitialText(string);
        if (!bl) {
            SpellerModel spellerModel = new SpellerModel(n);
            spellerModel.setSpellerListener(spellerListener);
            touchController.setModel(spellerModel);
            touchController.setModelID(n);
        }
        return touchController;
    }

    private AbstractWidgetController createArrowWidget(int n) {
        IconController iconController;
        if (n == 0 || n == 1) {
            iconController = (IconController)this.getWidgetTemplate(27);
            ChoiceModel choiceModel = new ChoiceModel(0);
            choiceModel.setValue(n == 0 ? 0 : 1);
            iconController.setModel(choiceModel);
        } else {
            int n2 = n == 3 ? 29 : 28;
            iconController = (IconController)this.getWidgetTemplate(n2);
        }
        iconController.setHeight(1);
        iconController.setPreferredHeight(1);
        ((IconRenderer)iconController.getRenderer()).setAlignment(2, 5);
        return iconController;
    }

    private AbstractWidgetController createSystemImageWidget(String string) {
        Integer n = (Integer)systemImageGuideIcons.get(string);
        if (n == null && (n = (Integer)systemImageGuideIcons.get(RemoteHMIGuideIcon.EMPTY.getName())) == null) {
            throw new IllegalStateException("The ref widget for empty system image is missing in the translation map !");
        }
        IconController iconController = (IconController)this.getWidgetTemplate(n);
        log.log(100000000, "GridMenuChanger#createSystemImageWidget sysIcon %1", (Object)iconController);
        if (this.lockController != null) {
            this.lockController.addLockImage(iconController);
        }
        return iconController;
    }

    private AbstractWidgetController createUpdatingIconWidget() {
        WaitAnimController waitAnimController = (WaitAnimController)this.getWidgetTemplate(31);
        waitAnimController.setPreferredHeight(20);
        ChoiceModel choiceModel = new ChoiceModel(0);
        choiceModel.setValue(1);
        waitAnimController.setModel(choiceModel);
        return waitAnimController;
    }

    private AbstractWidgetController createSeparatingLineWidget() {
        IconController iconController = (IconController)this.getWidgetTemplate(32);
        IconRenderer iconRenderer = (IconRenderer)iconController.getRenderer();
        iconRenderer.setScaleFactor(3.2f, 4.0f);
        return iconController;
    }

    private AbstractWidgetController createRotarySelectorWidget() {
        return (AbstractWidgetController)this.getWidgetTemplate(30);
    }

    private ComboBoxController createDropDownListWidget(IGridCell iGridCell, int n, ChoiceListener choiceListener) {
        Object object;
        int n2;
        Object object2;
        ComboBoxController comboBoxController = (ComboBoxController)this.getWidgetTemplate(26);
        IGridList iGridList = iGridCell.getListValue();
        ArrayList arrayList = new ArrayList(iGridList.size());
        Object object3 = iGridList.iterator();
        while (object3.hasNext()) {
            IGridCell iGridCell2;
            object2 = (IGrid)object3.next();
            if (object2 == null || object2.size() == 0 || !object2.isVisible() || (iGridCell2 = (IGridCell)object2.get(0)) == null || iGridCell2.getType() != 0) continue;
            LabelController labelController = this.createTextWidget(iGridCell2, false);
            labelController.setChainedAction(3, 17);
            arrayList.add(labelController);
            labelController.setEnabled(iGridCell2.isEnabled());
        }
        object3 = this.createTextWidget(iGridCell, false);
        object2 = (LabelRenderer)((LabelController)object3).getRenderer();
        object2.setAlignment(1, 4);
        comboBoxController.add((AbstractWidget)object3);
        iGridList.calculateDisplayedRows();
        int n3 = iGridList.getCurrentCursor().getSelection().getIndex();
        if (n3 == -1) {
            log.log(10000000, "GridMenuChanger#createDropDownListWidget: no visible rows available!");
            n2 = 0;
        } else {
            object = (IGrid)iGridList.get(n3);
            n2 = object.getDisplayedRow();
        }
        object = new ChoiceModel(n);
        ((ChoiceModel)object).setChoiceListener(choiceListener);
        ((ChoiceModel)object).setValue(n2);
        comboBoxController.setModelID(n);
        comboBoxController.setModel((HMIModelGUI)object);
        LabelController[] labelControllerArray = (LabelController[])arrayList.toArray(new LabelController[arrayList.size()]);
        comboBoxController.setLabelControllers(labelControllerArray);
        return comboBoxController;
    }

    private RadioButtonController createRadioButtonWidget(boolean bl) {
        RadioButtonController radioButtonController = (RadioButtonController)this.getWidgetTemplate(25);
        ChoiceModel choiceModel = new ChoiceModel(0);
        choiceModel.setValue(bl ? 1 : 0);
        radioButtonController.setModel(choiceModel);
        radioButtonController.setWidgetID(1);
        return radioButtonController;
    }

    private CheckboxController createCheckboxWidget(boolean bl, boolean bl2, int n, ChoiceListener choiceListener) {
        CheckboxController checkboxController = (CheckboxController)this.getWidgetTemplate(24);
        ChoiceModel choiceModel = new ChoiceModel(n);
        choiceModel.setChoiceListener(choiceListener);
        int n2 = bl2 ? (bl ? 1 : 0) : (bl ? 128 : 0);
        choiceModel.setValue(n2);
        checkboxController.setModel(choiceModel);
        return checkboxController;
    }

    private ProgressBarController createProgressBarWidget(int n) {
        ProgressBarController progressBarController = (ProgressBarController)this.getWidgetTemplate(3);
        RangeModel rangeModel = new RangeModel(0);
        rangeModel.setLimits(0, 100, 1);
        rangeModel.setValue(n);
        progressBarController.setModel(rangeModel);
        return progressBarController;
    }

    private LabelController createTextWidget(IGridCell iGridCell, boolean bl) {
        Object object;
        Object object2;
        boolean bl2 = iGridCell.getLineEnd() == 1;
        boolean bl3 = bl2 && bl && iGridCell.getType() != 10;
        boolean bl4 = iGridCell.containsHighlightedText();
        int n = iGridCell.getFont();
        int n2 = this.getTextWidgetId(n, bl4, bl3);
        LabelController labelController = (LabelController)this.getWidgetTemplate(n2);
        int n3 = iGridCell.getStyle();
        if (n3 == 2 || bl4) {
            object2 = labelController.getColorIndices();
            if (object2 == null) {
                object = labelController.getParent();
                int[] nArray = object == null ? null : ((AbstractWidget)object).getColorIndices();
                object2 = nArray != null ? (Object)nArray : new int[]{COLOR_BLACK, COLOR_WHITE, COLOR_CURSOR, COLOR_DISABLED, COLOR_HIGHLIGHT, COLOR_CURSOR};
            }
            if (n3 == 2) {
                object2[GridWidgetFactory.COLOR_INDEX_ENABLED] = COLOR_ENABLED_ANNOTATION;
            } else {
                object2[GridWidgetFactory.COLOR_INDEX_HIGHLIGHT] = COLOR_HIGHLIGHT;
                object2[GridWidgetFactory.COLOR_INDEX_ENABLED] = COLOR_WHITE;
            }
            labelController.setColorIndices((int[])object2);
        }
        if (bl2) {
            object2 = (LabelRenderer)labelController.getRenderer();
            object2.setAutoWrap(0);
            labelController.setMaxLines(iGridCell.getMaxLines());
        }
        object2 = (LabelRenderer)labelController.getRenderer();
        object2.setAlignment(iGridCell.getHorizontalAlignment(), 4);
        if (!bl4) {
            this.setGapBetweenLines(iGridCell.getLineHeight(), (LabelRenderer)object2, n);
        }
        object = new TextListCellHighlightText(iGridCell.getStringValue(), iGridCell.getHighlight());
        labelController.setModel(object);
        return labelController;
    }

    private void setGapBetweenLines(int n, LabelRenderer labelRenderer, int n2) {
        int n3;
        if (n == -1) {
            int n4 = AbstractWidget.framework.getScreenRes();
            List list = (List)RESOLUTION_FONT_LIST.get(n4);
            if (list == null) {
                log.log(10000000, "GridWigetFactory#setGapBetweenLines: height not defined for screen resolution %1. Keeping default line height.", (long)n4);
                return;
            }
            Integer n5 = (Integer)list.get(n2);
            if (n5 == null) {
                log.log(10000000, "GridWigetFactory#setGapBetweenLines: height not defined for font %1. Keeping default line height.", (long)n2);
                return;
            }
            n3 = n5;
        } else {
            n3 = n;
        }
        log.log(10000000, "GridWigetFactory#setGapBetweenLines: setting line height to %1 !", (long)n3);
        labelRenderer.setLineHeight(n3);
    }

    private AbstractWidgetController createImageWidget(String string) {
        IconController iconController = (IconController)this.getWidgetTemplate(4);
        ResourceLocatorModel resourceLocatorModel = new ResourceLocatorModel(0);
        resourceLocatorModel.setResourceLocator(-1, string);
        iconController.setModel(resourceLocatorModel);
        if (this.lockController != null) {
            this.lockController.addLockImage(iconController);
        }
        return this.createWrappingContainer(iconController);
    }

    private AbstractWidgetController createWrappingContainer(IconController iconController) {
        LayoutContainerController layoutContainerController = (LayoutContainerController)this.getWidgetTemplate(22);
        layoutContainerController.add(iconController);
        GridLayout gridLayout = new GridLayout(1, 1);
        layoutContainerController.setLayoutManager(gridLayout);
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        axisConstraints.grow = new float[]{1.0f};
        AxisConstraints axisConstraints2 = (AxisConstraints)gridLayout.getRowConstraints();
        axisConstraints2.grow = new float[]{1.0f};
        Object[] objectArray = new Object[]{iconController};
        IGridLayoutHints[] iGridLayoutHintsArray = new GridLayoutHints[]{new GridLayoutHints(0, 0)};
        gridLayout.setCellConstraints(iGridLayoutHintsArray, objectArray);
        return layoutContainerController;
    }

    private IconController createRrdImageWidget(IGridCell iGridCell) {
        int n = iGridCell.getFont() == 4 ? 37 : 36;
        IconController iconController = (IconController)this.getWidgetTemplate(n);
        int n2 = iGridCell.getStyle();
        if (n2 == 2) {
            int[] nArray = iconController.getColorIndices();
            if (nArray == null) {
                int[] nArray2;
                AbstractWidget abstractWidget = iconController.getParent();
                if (abstractWidget != null && abstractWidget.getColorIndices() != null) {
                    nArray2 = abstractWidget.getColorIndices();
                } else {
                    int[] nArray3 = new int[6];
                    nArray3[0] = COLOR_BLACK;
                    nArray3[1] = COLOR_ENABLED_ANNOTATION;
                    nArray3[2] = COLOR_DISABLED;
                    nArray3[3] = COLOR_HIGHLIGHT;
                    nArray3[4] = COLOR_CURSOR;
                    nArray2 = nArray3;
                    nArray3[5] = COLOR_CURSOR;
                }
                nArray = nArray2;
            }
            if (n2 == 2) {
                nArray[GridWidgetFactory.COLOR_INDEX_ENABLED] = COLOR_ENABLED_ANNOTATION;
            } else {
                nArray[GridWidgetFactory.COLOR_INDEX_HIGHLIGHT] = COLOR_HIGHLIGHT;
            }
            iconController.setColorIndices(nArray);
        }
        iconController.setValue(iGridCell.getIntValue());
        return iconController;
    }

    protected ListController createList(int n, BaseListModel baseListModel, IListWidgetDataAccess iListWidgetDataAccess) {
        ListController listController = (ListController)this.getWidgetTemplate(34);
        listController.setWidgetID(n);
        listController.setRecordSetColumn(0);
        listController.setFocusableColumn(1);
        listController.setPropertyColumn(2);
        listController.setSdsActionColumn(4);
        listController.setInfolineTextDisabledColumn(5);
        listController.setInfolineTextEnabledColumn(5);
        ListLayoutCalculator listLayoutCalculator = listController.getLayoutCalculator();
        listLayoutCalculator.setHeightCacheKeyColumns(new int[]{3});
        listController.setAutoLayoutSetup(false);
        listController.setItemFactory(new GridListItemFactory(this.terminalId, this.factory));
        listController.setModel(baseListModel);
        listController.setModelID(n);
        listController.setDataAccess(iListWidgetDataAccess);
        if (iListWidgetDataAccess instanceof IInfiniteListModelAccess) {
            IInfiniteListModelAccess iInfiniteListModelAccess = (IInfiniteListModelAccess)iListWidgetDataAccess;
            iInfiniteListModelAccess.setListController(listController);
        }
        listController.setSdsItemSelectedAction(2);
        return listController;
    }

    protected MenuItemController createMenuItem(int n) {
        log.log(10000000, "GridWidgetFactory#createMenuItem: called for widgetId '%1'", (long)n);
        MenuItemController menuItemController = (MenuItemController)this.getWidgetTemplate(33);
        menuItemController.setWidgetID(n);
        menuItemController.setAutoLayoutSetup(false);
        menuItemController.setType(16);
        menuItemController.setModelID(2300157);
        menuItemController.setAutoConfigureChaining(false);
        FocusedPropertyConfig focusedPropertyConfig = new FocusedPropertyConfig();
        menuItemController.add(focusedPropertyConfig);
        return menuItemController;
    }

    protected void deleteAllWidgets(MenuItemController menuItemController) {
        for (int i2 = menuItemController.getChildrenSize() - 1; i2 >= 0; --i2) {
            AbstractWidget abstractWidget = menuItemController.getChild(i2);
            if (abstractWidget instanceof FocusedPropertyConfig) continue;
            menuItemController.remove(abstractWidget);
        }
    }

    private FormfieldInputController createFormFieldWidget() {
        FormfieldInputController formfieldInputController = (FormfieldInputController)this.getWidgetTemplate(56);
        return formfieldInputController;
    }

    protected HMIView getWidgetTemplate(int n) {
        HMIView hMIView = this.factory.getWidgetTemplate(this.terminalId, n);
        switch (n) {
            case 22: 
            case 26: 
            case 33: 
            case 34: {
                this.factory.getWidgetTemplate(this.terminalId, n);
                break;
            }
        }
        return hMIView;
    }

    static String calculateInfoText(IGrid iGrid, int n) {
        IGrid iGrid2 = WidgetUtilities.getLayoutedGrid(iGrid, n);
        return iGrid2 == null ? "" : iGrid2.getInfoText();
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(RemoteHMIGuideIcon.EMPTY.getName(), new Integer(71));
        hashMap.put(RemoteHMIGuideIcon.TOP_WIZARD_BACKGROUND.getName(), new Integer(54));
        hashMap.put(RemoteHMIGuideIcon.POI_ONLINE.getName(), new Integer(62));
        hashMap.put(RemoteHMIGuideIcon.DEST_IMPORT.getName(), new Integer(66));
        hashMap.put(RemoteHMIGuideIcon.CARFINDER.getName(), new Integer(59));
        hashMap.put(RemoteHMIGuideIcon.MOBILE_KEY.getName(), new Integer(98));
        hashMap.put(RemoteHMIGuideIcon.TRAFFICLIGHT.getName(), new Integer(72));
        hashMap.put(RemoteHMIGuideIcon.ALERTSERVICES.getName(), new Integer(70));
        hashMap.put(RemoteHMIGuideIcon.GOOGLE_EARTH.getName(), new Integer(61));
        hashMap.put(RemoteHMIGuideIcon.ONLINE_TRAFFIC.getName(), new Integer(63));
        hashMap.put(RemoteHMIGuideIcon.WIFI_PLAYER.getName(), new Integer(57));
        hashMap.put(RemoteHMIGuideIcon.SMS_DICTATION.getName(), new Integer(69));
        hashMap.put(RemoteHMIGuideIcon.EMAIL_DICTATION.getName(), new Integer(68));
        hashMap.put(RemoteHMIGuideIcon.REMOTE_LOCK_UNLOCK.getName(), new Integer(58));
        hashMap.put(RemoteHMIGuideIcon.REMOTE_HEATER.getName(), new Integer(58));
        hashMap.put(RemoteHMIGuideIcon.RHMI_USER_SETTINGS.getName(), new Integer(58));
        hashMap.put(RemoteHMIGuideIcon.MAP_CARE.getName(), new Integer(64));
        hashMap.put(RemoteHMIGuideIcon.SPECIAL_DEST.getName(), new Integer(67));
        systemImageGuideIcons = Collections.unmodifiableMap(hashMap);
        MULTI_LINE_LABLE_LINEHEIGHT_FONTS_TT = Collections.unmodifiableList(new ArrayList(){
            private static final long serialVersionUID = 1L;
            {
                this.addAll(Collections.nCopies(10, null));
                this.set(4, new Integer(31));
            }
        });
        RESOLUTION_FONT_LIST = Collections.unmodifiableList(new ArrayList(){
            private static final long serialVersionUID = 1L;
            {
                this.addAll(Collections.nCopies(7, null));
                this.set(4, MULTI_LINE_LABLE_LINEHEIGHT_FONTS_TT);
            }
        });
    }
}

