/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.LayoutManagerSimulation;
import de.esolutions.hmi.widgets.audi.base.PreferredDynamicHeight;
import de.esolutions.hmi.widgets.audi.base.TabLayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ExpandableLayoutManager;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.widgets.BaselineWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridLayout
extends AbstractGridLayout
implements LayoutManager,
TabLayoutManager,
ExpandableLayoutManager,
LayoutManagerSimulation,
IViewSizeAnimatable {
    protected int xOffset = 0;
    protected int yOffset = 0;
    private boolean shouldBackmirrorProgressBarInArabic = false;
    private boolean hasBeenBackmirrored = false;
    private IGridLayoutHints[] widgetConstraintsArabic;
    private IGridLayoutHints[] widgetConstraintsNotArabic;
    private AxisConstraints columnConstraintsNotArabic;
    private AxisConstraints columnConstraintsArabic;
    private ProgressBarController progressBarController;
    private int progressBarIndex = -1;

    public GridLayout() {
    }

    public GridLayout(int n, int n2) {
        this.columnConstraints = new MenuItemColumnsConstraints(n);
        this.rowConstraints = new AxisConstraints(n2);
    }

    @Override
    public void layout(AbstractWidget abstractWidget) {
        this.layoutInternal(abstractWidget.getWidth(), abstractWidget.getHeight());
    }

    @Override
    public int[][] simulateLayout(int n, int n2) {
        return this.simulateLayout(n, n2, true);
    }

    public int[][] simulateLayout(int n, int n2, boolean bl) {
        return this.simulateLayoutInternal(n, n2, bl);
    }

    @Override
    public int[] calculateSize(AbstractWidget abstractWidget, int n) {
        return this.calculateSizeInternal(this.state, n);
    }

    @Override
    public int[] calculateSize(AbstractWidget abstractWidget, boolean bl, int n) {
        return this.calculateSizeInternal(this.calculateState(this.isBigStage(), bl), n);
    }

    @Override
    public int calculateTabulator(AbstractWidget abstractWidget, int n) {
        return this.calculateTabulatorInternal(abstractWidget.getWidth(), abstractWidget.getHeight(), n);
    }

    @Override
    public int[] calculateRows(int n, int n2) {
        return super.calculateRows(n, n2);
    }

    @Override
    public int[] calculateColumns(int n, int n2) {
        return super.calculateColumns(n, n2);
    }

    public void setWidgetConstraints(IGridLayoutHints[] iGridLayoutHintsArray, AbstractWidgetController[] abstractWidgetControllerArray) {
        if (this.shouldBackmirrorProgressBarInArabic && (this.progressBarController != null || this.hasProgressBar(abstractWidgetControllerArray))) {
            if (!this.hasBeenBackmirrored) {
                this.widgetConstraintsNotArabic = (IGridLayoutHints[])iGridLayoutHintsArray.clone();
                this.columnConstraintsNotArabic = (AxisConstraints)((AxisConstraints)this.getColumnConstraints()).clone();
            }
            if (!AbstractWidget.framework.getLanguageMgr().isLeftToRightOrientation()) {
                if (!this.hasBeenBackmirrored) {
                    this.mirrorProgressBar(iGridLayoutHintsArray, abstractWidgetControllerArray);
                }
                if (this.widgetConstraintsArabic != null && this.columnConstraintsArabic != null) {
                    this.widgetConstraints = this.widgetConstraintsArabic;
                    this.columnConstraints = this.columnConstraintsArabic;
                } else {
                    this.widgetConstraints = this.widgetConstraintsNotArabic;
                    this.columnConstraints = this.columnConstraintsNotArabic;
                }
            } else {
                this.widgetConstraints = this.widgetConstraintsNotArabic;
                this.columnConstraints = this.columnConstraintsNotArabic;
            }
            this.widgets = abstractWidgetControllerArray;
        } else {
            this.widgetConstraints = iGridLayoutHintsArray;
            this.widgets = abstractWidgetControllerArray;
        }
    }

    public void setCellConstraints(IGridLayoutHints[] iGridLayoutHintsArray, Object[] objectArray) {
        if (this.shouldBackmirrorProgressBarInArabic && (this.progressBarController != null || this.hasProgressBar(objectArray))) {
            if (!this.hasBeenBackmirrored) {
                this.widgetConstraintsNotArabic = (IGridLayoutHints[])iGridLayoutHintsArray.clone();
                this.columnConstraintsNotArabic = (AxisConstraints)((AxisConstraints)this.getColumnConstraints()).clone();
            }
            if (!AbstractWidget.framework.getLanguageMgr().isLeftToRightOrientation()) {
                if (!this.hasBeenBackmirrored) {
                    this.mirrorProgressBar(iGridLayoutHintsArray, objectArray);
                }
                if (this.widgetConstraintsArabic != null && this.columnConstraintsArabic != null) {
                    this.widgetConstraints = this.widgetConstraintsArabic;
                    this.columnConstraints = this.columnConstraintsArabic;
                } else {
                    this.widgetConstraints = this.widgetConstraintsNotArabic;
                    this.columnConstraints = this.columnConstraintsNotArabic;
                }
            } else {
                this.widgetConstraints = this.widgetConstraintsNotArabic;
                this.columnConstraints = this.columnConstraintsNotArabic;
            }
            this.widgets = objectArray;
        } else {
            this.widgetConstraints = iGridLayoutHintsArray;
            this.widgets = objectArray;
        }
    }

    public Object[] getCells() {
        return this.widgets;
    }

    @Override
    public AbstractWidget[] getSimulationWidgets() {
        ArrayList arrayList = new ArrayList(this.widgets.length);
        for (int i2 = 0; i2 < this.widgets.length; ++i2) {
            if (this.widgets[i2] instanceof AbstractWidget) {
                arrayList.add(this.widgets[i2]);
                continue;
            }
            if (!(this.widgets[i2] instanceof GridLayout)) continue;
            Object[] objectArray = ((GridLayout)this.widgets[i2]).getSimulationWidgets();
            arrayList.addAll(Arrays.asList(objectArray));
        }
        return (AbstractWidget[])arrayList.toArray(new AbstractWidget[arrayList.size()]);
    }

    @Override
    protected void simulateSetBounds(Object object, int n, int n2, int n3, int n4, List list, boolean bl) {
        if (!bl || object instanceof AbstractWidget) {
            list.add(new int[]{n, n2, n3, n4});
        } else if (object instanceof GridLayout) {
            int[][] nArray = ((GridLayout)object).simulateLayout(n3, n4, bl);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int[] nArray2 = nArray[i2];
                if (nArray2 != null) {
                    list.add(new int[]{nArray2[0] + n, nArray2[1] + n2, nArray2[2], nArray2[3]});
                    continue;
                }
                list.add(null);
            }
        }
    }

    @Override
    protected void simulateHideWidgets(Object object, List list) {
        if (object instanceof AbstractWidget) {
            list.add(null);
        } else if (object instanceof GridLayout) {
            AbstractWidget[] abstractWidgetArray = ((GridLayout)object).getSimulationWidgets();
            for (int i2 = 0; i2 < abstractWidgetArray.length; ++i2) {
                list.add(null);
            }
        }
    }

    @Override
    protected int getPreferredWidth(Object object) {
        if (object instanceof AbstractWidgetController) {
            return ((AbstractWidgetController)object).getPreferredWidth();
        }
        if (object instanceof GridLayout) {
            return ((GridLayout)object).calculateSize(null, -1)[0];
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown grid cell: ").append(object).toString());
    }

    @Override
    protected int getPreferredHeight(Object object, int n) {
        if (n > 0) {
            if (object instanceof PreferredDynamicHeight) {
                PreferredDynamicHeight preferredDynamicHeight = (PreferredDynamicHeight)object;
                return preferredDynamicHeight.getPreferredHeight(n);
            }
            if (object instanceof GridLayout) {
                return ((GridLayout)object).calculateSize(null, n)[1];
            }
        }
        return this.getPreferredHeight(object);
    }

    @Override
    protected int getPreferredHeight(Object object) {
        if (object instanceof AbstractWidgetController) {
            return ((AbstractWidgetController)object).getPreferredHeight();
        }
        if (object instanceof GridLayout) {
            return ((GridLayout)object).calculateSize(null, -1)[1];
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown grid cell: ").append(object).toString());
    }

    @Override
    protected boolean hasDynamicHeight(Object object) {
        if (object instanceof AbstractWidgetController) {
            if (object instanceof PreferredDynamicHeight) {
                return ((PreferredDynamicHeight)object).isHeightDependentFromWidth();
            }
            return false;
        }
        if (object instanceof GridLayout) {
            return ((GridLayout)object).hasDynamicHeight();
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown grid cell: ").append(object).toString());
    }

    @Override
    protected int getBaseline(Object object) {
        if (object instanceof BaselineWidget) {
            return ((BaselineWidget)object).getBaseline();
        }
        return this.getPreferredHeight(object);
    }

    @Override
    protected boolean isWidgetVisible(Object object) {
        if (object instanceof AbstractWidgetController) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object;
            return abstractWidgetController.isVisible() && abstractWidgetController.isVisibleOnCurrentStage();
        }
        return true;
    }

    @Override
    protected boolean widgetHasContent(Object object) {
        if (object instanceof IEmptyableWidget) {
            return ((IEmptyableWidget)object).hasContent();
        }
        if (object instanceof GridLayout) {
            AbstractWidget[] abstractWidgetArray = ((GridLayout)object).getSimulationWidgets();
            for (int i2 = 0; i2 < abstractWidgetArray.length; ++i2) {
                if (!this.isWidgetVisible(abstractWidgetArray[i2]) || !this.widgetHasContent(abstractWidgetArray[i2])) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    protected void setBounds(Object object, int n, int n2, int n3, int n4) {
        if (object instanceof AbstractWidget) {
            AbstractWidget abstractWidget = (AbstractWidget)object;
            abstractWidget.setBounds(this.xOffset + n, this.yOffset + n2, n3, n4);
            abstractWidget.setOnScreen(true);
        } else if (object instanceof GridLayout) {
            GridLayout gridLayout = (GridLayout)object;
            gridLayout.xOffset = this.xOffset + n;
            gridLayout.yOffset = this.yOffset + n2;
            gridLayout.layoutInternal(n3, n4);
        } else {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown grid cell: ").append(object).toString());
        }
    }

    @Override
    protected void hideWidget(Object object) {
        if (object instanceof AbstractWidget) {
            AbstractWidget abstractWidget = (AbstractWidget)object;
            abstractWidget.setOnScreen(false);
        } else if (object instanceof GridLayout) {
            GridLayout gridLayout = (GridLayout)object;
            AbstractWidget[] abstractWidgetArray = gridLayout.getSimulationWidgets();
            for (int i2 = 0; i2 < abstractWidgetArray.length; ++i2) {
                abstractWidgetArray[i2].setOnScreen(false);
            }
        } else {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown grid cell: ").append(object).toString());
        }
    }

    @Override
    public void setExpanded(boolean bl) {
        this.setState(this.calculateState(this.isBigStage(), bl));
        if (this.widgets != null) {
            for (int i2 = 0; i2 < this.widgets.length; ++i2) {
                if (!(this.widgets[i2] instanceof GridLayout)) continue;
                ((GridLayout)this.widgets[i2]).setExpanded(bl);
            }
        }
    }

    @Override
    public void flushCache() {
        super.flushCache();
        if (this.widgets != null) {
            for (int i2 = 0; i2 < this.widgets.length; ++i2) {
                if (!(this.widgets[i2] instanceof GridLayout)) continue;
                ((GridLayout)this.widgets[i2]).flushCache();
            }
        }
    }

    private int calculateState(boolean bl, boolean bl2) {
        if (bl) {
            return bl2 ? 1 : 2;
        }
        return bl2 ? 4 : 8;
    }

    private boolean isBigStage() {
        return this.isBigStage(this.state);
    }

    private boolean isBigStage(int n) {
        return n == 1 || n == 2;
    }

    private boolean isExpanded() {
        return this.state == 1 || this.state == 4;
    }

    public void setBigStage(boolean bl) {
        this.setState(this.calculateState(bl, this.isExpanded()));
        if (this.widgets != null) {
            for (int i2 = 0; i2 < this.widgets.length; ++i2) {
                if (!(this.widgets[i2] instanceof GridLayout)) continue;
                ((GridLayout)this.widgets[i2]).setBigStage(bl);
            }
        }
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        this.updateViewSize(fArray);
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        this.updateViewSize(fArray);
    }

    private void updateViewSize(float[] fArray) {
        boolean bl = fArray[0] < 63;
        this.setBigStage(bl);
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    @Override
    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public void mirrorProgressBar(IGridLayoutHints[] iGridLayoutHintsArray, Object[] objectArray) {
        AxisConstraints axisConstraints = (AxisConstraints)this.getColumnConstraints();
        IGridLayoutHints iGridLayoutHints = null;
        IGridLayoutHints iGridLayoutHints2 = null;
        int n = -1;
        int n2 = -1;
        int n3 = iGridLayoutHintsArray[this.progressBarIndex].getColumn();
        int n4 = iGridLayoutHintsArray[this.progressBarIndex].getRow();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] instanceof LabelController && iGridLayoutHintsArray[i2].getRow() == n4) {
                if (iGridLayoutHintsArray[i2].getColumn() < n3) {
                    iGridLayoutHints = iGridLayoutHintsArray[i2];
                    n = i2;
                } else {
                    iGridLayoutHints2 = iGridLayoutHintsArray[i2];
                    n2 = i2;
                }
            }
            if (iGridLayoutHints == null || iGridLayoutHints2 == null) continue;
            iGridLayoutHintsArray[n] = iGridLayoutHints2;
            iGridLayoutHintsArray[n2] = iGridLayoutHints;
            break;
        }
        if (iGridLayoutHints != null && iGridLayoutHints2 == null) {
            GridLayoutHints gridLayoutHints = (GridLayoutHints)iGridLayoutHintsArray[n];
            GridLayoutHints gridLayoutHints2 = (GridLayoutHints)iGridLayoutHintsArray[this.progressBarIndex];
            int n5 = gridLayoutHints.getAlignmentHoriz();
            int n6 = gridLayoutHints2.getAlignmentHoriz();
            gridLayoutHints.setAlignmentHoriz(n6);
            gridLayoutHints2.setAlignmentHoriz(n5);
            float f2 = axisConstraints.getGrowWeight(0);
            float f3 = axisConstraints.getShrinkWeight(0);
            int n7 = axisConstraints.getHidemode(0);
            int n8 = axisConstraints.getAlignment(0);
            int n9 = axisConstraints.getMin(0);
            axisConstraints.alignment = new int[]{axisConstraints.getAlignment(1), n8};
            axisConstraints.grow = new float[]{axisConstraints.getGrowWeight(1), f2};
            axisConstraints.min = new int[]{axisConstraints.getMin(1), n9};
            axisConstraints.shrink = new float[]{axisConstraints.getShrinkWeight(1), f3};
            axisConstraints.hidemode = new int[]{axisConstraints.getHidemode(1), n7};
            iGridLayoutHintsArray[n] = gridLayoutHints2;
            iGridLayoutHintsArray[this.progressBarIndex] = gridLayoutHints;
        } else if (iGridLayoutHints == null && iGridLayoutHints2 != null) {
            GridLayoutHints gridLayoutHints = (GridLayoutHints)iGridLayoutHintsArray[this.progressBarIndex];
            GridLayoutHints gridLayoutHints3 = (GridLayoutHints)iGridLayoutHintsArray[n2];
            int n10 = gridLayoutHints3.getAlignmentHoriz();
            int n11 = gridLayoutHints.getAlignmentHoriz();
            gridLayoutHints3.setAlignmentHoriz(n11);
            gridLayoutHints.setAlignmentHoriz(n10);
            float f4 = axisConstraints.getGrowWeight(0);
            float f5 = axisConstraints.getShrinkWeight(0);
            int n12 = axisConstraints.getHidemode(0);
            int n13 = axisConstraints.getAlignment(0);
            int n14 = axisConstraints.getMin(0);
            axisConstraints.alignment = new int[]{axisConstraints.getAlignment(1), n13};
            axisConstraints.grow = new float[]{axisConstraints.getGrowWeight(1), f4};
            axisConstraints.min = new int[]{axisConstraints.getMin(1), n14};
            axisConstraints.shrink = new float[]{axisConstraints.getShrinkWeight(1), f5};
            axisConstraints.hidemode = new int[]{axisConstraints.getHidemode(1), n12};
            iGridLayoutHintsArray[n2] = gridLayoutHints;
            iGridLayoutHintsArray[this.progressBarIndex] = gridLayoutHints3;
        }
        this.columnConstraintsArabic = axisConstraints;
        this.widgetConstraintsArabic = iGridLayoutHintsArray;
        this.hasBeenBackmirrored = true;
    }

    public void checkCorrectProgressBarMirroring(boolean bl) {
        this.shouldBackmirrorProgressBarInArabic = bl;
        this.setCellConstraints(this.widgetConstraints, this.widgets);
    }

    private boolean hasProgressBar(Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (!(objectArray[i2] instanceof ProgressBarController)) continue;
            this.progressBarController = (ProgressBarController)objectArray[i2];
            this.progressBarIndex = i2;
            return true;
        }
        return false;
    }
}

