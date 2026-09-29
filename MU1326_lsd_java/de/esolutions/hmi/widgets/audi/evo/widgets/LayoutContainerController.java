/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.mmicombi.IViewSizeManager;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.LayoutManagerSimulation;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.layouts.DefaultBoundedLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.BaselineWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ShuffleContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LayoutContainerController
extends AbstractWidgetController
implements LayoutContainer,
BaselineWidget,
IViewSizeAnimatable,
IEmptyableWidget {
    private boolean m_hasDynamicLayout = false;
    protected CompositeRenderer renderer;
    protected LayoutManager layoutManager;
    protected boolean autoLayoutSetup = true;
    protected boolean layoutDirty = false;
    private boolean shouldBackmirrorProgressBar = false;
    private static final int[] horizInsetsLeft = new int[]{5, 10, 10, 0, 10, 0, 0};
    private static final int[] horizInsetsRight = new int[]{7, 10, 10, 0, 10, 0, 0};
    private static final int[] rowInsets = new int[]{5, 10, 10, 0, 9, 0, 0};
    private static final int[] rowGapsMiddle = new int[]{11, 16, 16, 0, 15, 0, 0};

    public boolean isLayoutDirty() {
        return this.layoutDirty;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        this.manageLayout();
        super.render(redrawContext);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.checkCorrectProgressBarMirroring();
    }

    public void manageLayout() {
        if (this.isLayoutDirty()) {
            this.layout();
            this.layoutDirty = false;
        }
    }

    protected void layout() {
        if (this.getHasDynamicLayout()) {
            this.layoutManager.layout(this);
        }
    }

    @Override
    public void invalidateLayout(AbstractWidget abstractWidget) {
        this.invalidateChildrenBounds();
        if (this.getHasDynamicLayout() && this.isVisible() && this.isVisibleOnCurrentStage()) {
            this.invalidateParentLayout();
        }
    }

    public void invalidateChildrenBounds() {
        if (!this.isConnected()) {
            return;
        }
        this.layoutDirty = true;
        if (this.getHasDynamicLayout()) {
            this.flushLayoutCache();
            this.setInvalid(true);
            this.setCompositesDirty(true);
        }
    }

    protected void flushLayoutCache() {
        if (this.getHasDynamicLayout()) {
            this.layoutManager.flushCache();
        }
    }

    public void setHasDynamicLayout(boolean bl) {
        this.m_hasDynamicLayout = bl;
        if (bl && this.layoutManager == null) {
            this.layoutManager = DefaultBoundedLayout.getInstance();
        }
    }

    public boolean getHasDynamicLayout() {
        return this.m_hasDynamicLayout;
    }

    @Override
    public int getPreferredWidth() {
        if (this.getHasDynamicLayout() && this.preferredWidth == -1) {
            return this.layoutManager.calculateSize(this, -1)[0];
        }
        return super.getPreferredWidth();
    }

    @Override
    public int getPreferredHeight() {
        if (this.getHasDynamicLayout() && this.preferredHeight == -1) {
            return this.layoutManager.calculateSize(this, -1)[1];
        }
        return super.getPreferredHeight();
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        if (this.width != n3 || this.height != n4) {
            this.invalidateChildrenBounds();
        }
        super.setBounds(n, n2, n3, n4);
    }

    @Override
    public void setWidth(int n) {
        if (this.width != n) {
            this.invalidateChildrenBounds();
        }
        super.setWidth(n);
    }

    @Override
    public void setHeight(int n) {
        if (this.height != n) {
            this.invalidateChildrenBounds();
        }
        super.setHeight(n);
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        this.invalidateLayout(abstractWidget);
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (n == 1 && abstractWidget instanceof LabelController) {
            ((LabelController)abstractWidget).setUserHintRole(n);
        }
        super.add(abstractWidget);
        this.invalidateLayout(abstractWidget);
    }

    @Override
    public void remove(AbstractWidget abstractWidget) {
        super.remove(abstractWidget);
        this.invalidateLayout(abstractWidget);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(CompositeRenderer compositeRenderer) {
        this.renderer = compositeRenderer;
    }

    public LayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public void setAutoLayoutSetup(boolean bl) {
        this.autoLayoutSetup = bl;
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        this.setHasDynamicLayout(layoutManager != null);
        if (this.isConnected()) {
            this.setViewSizeToLayoutManager(layoutManager);
        }
        this.invalidateLayout(null);
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.invalidateChildrenBounds();
        if (this.getHasDynamicLayout()) {
            this.setViewSizeToLayoutManager(this.layoutManager);
        }
        if (this.autoLayoutSetup) {
            this.autoLayoutSetup();
        }
    }

    protected void autoLayoutSetup() {
        if ((this.parent instanceof ListController || this.parent instanceof MenuController || this.parent instanceof ShuffleContainerController) && this.layoutManager instanceof GridLayout) {
            GridLayout gridLayout = (GridLayout)this.layoutManager;
            LayoutContainerController.autoLayoutSetup(gridLayout);
        }
    }

    public static void autoLayoutSetup(GridLayout gridLayout) {
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getRowConstraints();
        int n = axisConstraints.length + 1;
        if (axisConstraints.gaps == null || axisConstraints.gaps.length != n) {
            axisConstraints.gaps = new int[n];
        }
        AxisConstraints axisConstraints2 = (AxisConstraints)gridLayout.getColumnConstraints();
        n = axisConstraints2.length + 1;
        if (axisConstraints2.gaps == null || axisConstraints2.gaps.length != n) {
            axisConstraints2.gaps = new int[n];
        }
        LayoutContainerController.assignDefaultGaps(axisConstraints.gaps, axisConstraints2.gaps);
    }

    public static void assignDefaultGaps(int[] nArray, int[] nArray2) {
        int n = framework.getScreenRes();
        if (nArray == null || nArray.length < 1) {
            throw new IllegalArgumentException("Array for row gaps is null or too small!");
        }
        if (nArray2 == null || nArray2.length < 1) {
            throw new IllegalArgumentException("Array for column gaps is null or too small!");
        }
        int n2 = nArray.length - 1;
        for (int i2 = 1; i2 < n2; ++i2) {
            nArray[i2] = rowGapsMiddle[n];
        }
        nArray[0] = rowInsets[n];
        nArray[n2] = rowInsets[n];
        nArray2[0] = horizInsetsLeft[n];
        nArray2[nArray2.length - 1] = horizInsetsRight[n];
    }

    @Override
    public int getBaseline() {
        this.manageLayout();
        boolean bl = false;
        int n = -129;
        Iterator iterator = this.getLayoutedChildren().iterator();
        while (iterator.hasNext()) {
            BaselineWidget baselineWidget;
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!(abstractWidget instanceof BaselineWidget) || !abstractWidget.isVisible() || !abstractWidget.isOnScreen() || !(baselineWidget = (BaselineWidget)((Object)abstractWidget)).hasBaseline()) continue;
            int n2 = ((BaselineWidget)((Object)abstractWidget)).getBaseline();
            n = Math.min(n, abstractWidget.getY() + n2);
            bl = true;
        }
        if (bl) {
            return n;
        }
        return this.getHeight();
    }

    protected List getLayoutedChildren() {
        if (this.layoutManager instanceof LayoutManagerSimulation) {
            Object[] objectArray = ((LayoutManagerSimulation)this.layoutManager).getSimulationWidgets();
            return Arrays.asList(objectArray);
        }
        return this.getChildren();
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (this.layoutManager instanceof IViewSizeAnimatable) {
            ((IViewSizeAnimatable)((Object)this.layoutManager)).setViewSizeAnimation(f2, fArray, fArray2, bl);
        }
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (this.layoutManager instanceof IViewSizeAnimatable) {
            ((IViewSizeAnimatable)((Object)this.layoutManager)).setViewSizeAnimationFinished(fArray, bl);
        }
    }

    protected void setViewSizeToLayoutManager(LayoutManager layoutManager) {
        IViewSizeManager iViewSizeManager;
        if (layoutManager instanceof IViewSizeAnimatable && (iViewSizeManager = this.getTerminalImpl().getViewSizeManager()) != null) {
            int n = iViewSizeManager.getCurrentViewSize();
            boolean bl = n == 2;
            float[] fArray = bl ? ScreenWidgetEVO.BIG_STAGE : ScreenWidgetEVO.SMALL_STAGE;
            ((IViewSizeAnimatable)((Object)layoutManager)).setViewSizeAnimationFinished(fArray, true);
        }
    }

    public void setRole(int n) {
        this.role = n;
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    @Override
    public boolean hasContent() {
        return this.getPreferredHeight() != 0 && this.getPreferredWidth() != 0;
    }

    @Override
    public boolean hasBaseline() {
        Iterator iterator = this.getLayoutedChildren().iterator();
        while (iterator.hasNext()) {
            BaselineWidget baselineWidget;
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!(abstractWidget instanceof BaselineWidget) || !abstractWidget.isVisible() || !abstractWidget.isOnScreen() || !(baselineWidget = (BaselineWidget)((Object)abstractWidget)).hasBaseline()) continue;
            return true;
        }
        return false;
    }

    @Override
    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public void setShouldBackmirrorProgressBarInArabic(boolean bl) {
        this.shouldBackmirrorProgressBar = bl;
    }

    public void checkCorrectProgressBarMirroring() {
        if (this.layoutManager instanceof GridLayout) {
            ((GridLayout)this.layoutManager).checkCorrectProgressBarMirroring(this.shouldBackmirrorProgressBar);
        }
    }
}

