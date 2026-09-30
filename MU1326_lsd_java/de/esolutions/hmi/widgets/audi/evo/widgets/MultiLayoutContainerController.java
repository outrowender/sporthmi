/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.LayoutManagerSimulation;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.DirectWritingController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TransitionLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MultiLayoutContainerController
extends LayoutContainerController {
    public static final int USE_PREFERRED_SIZE = -1;
    public static final int USE_CURRENT_SIZE = -2;
    protected LayoutManager[] layoutChoices;

    public LayoutManager[] getLayoutChoices() {
        return this.layoutChoices;
    }

    public void setLayoutChoices(LayoutManager[] layoutManagerArray) {
        this.layoutChoices = layoutManagerArray;
    }

    public boolean hasMultipleLayouts() {
        return this.layoutChoices != null && this.layoutChoices.length != 0;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.initSelectLayout();
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateChildrenVisibility();
    }

    private void initSelectLayout() {
        if (this.hasMultipleLayouts()) {
            this.setLayoutManager(this.layoutChoices[0]);
        } else {
            logLayout.log(10000000, "MultiLayoutMenuItemController#initSelectLayout: no layout choices are set.");
        }
    }

    protected void flushLayoutCache() {
        super.flushLayoutCache();
        if (this.hasMultipleLayouts()) {
            for (int i2 = 0; i2 < this.layoutChoices.length; ++i2) {
                if (this.layoutChoices[i2] == null) continue;
                this.layoutChoices[i2].flushCache();
            }
        }
    }

    private void updateChildrenVisibility() {
        if (!(this.layoutManager instanceof LayoutManagerSimulation)) {
            return;
        }
        List list = Arrays.asList(((LayoutManagerSimulation)this.layoutManager).getSimulationWidgets());
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (list.contains(abstractWidget)) {
                abstractWidget.setOnScreen(true);
                continue;
            }
            if (abstractWidget instanceof DirectWritingController) continue;
            abstractWidget.setOnScreen(false);
        }
    }

    public void selectLayoutManager(int n) {
        if (this.layoutManager instanceof TransitionLayout) {
            this.finishTransition((TransitionLayout)this.layoutManager);
        }
        LayoutManager layoutManager = this.layoutChoices[n];
        this.setLayoutManager(layoutManager);
        this.updateChildrenVisibility();
    }

    public TransitionLayout selectLayoutManagerWithTransition(int n, int n2, int n3) {
        LayoutManager layoutManager = this.layoutChoices[n];
        if (!(layoutManager instanceof LayoutManagerSimulation)) {
            logLayout.log(100000, "MultiLayoutMenuItemController#selectLayoutManagerWithTransition: new Layout is not a LayoutManagerSimulation: %1", (Object)layoutManager);
            this.setLayoutManager(layoutManager);
            return null;
        }
        this.setViewSizeToLayoutManager(layoutManager);
        TransitionLayout transitionLayout = this.createTransitionLayout((LayoutManagerSimulation)layoutManager, n2, n3);
        this.setLayoutManager(transitionLayout);
        return transitionLayout;
    }

    public boolean hasLayoutChoice(int n) {
        return this.layoutChoices != null && this.layoutChoices.length > n && n >= 0 && this.layoutChoices[n] != null;
    }

    private TransitionLayout createTransitionLayout(LayoutManagerSimulation layoutManagerSimulation, int n, int n2) {
        AbstractWidget[] abstractWidgetArray = layoutManagerSimulation.getSimulationWidgets();
        Object[] objectArray = this.getNotLayoutedChildren(layoutManagerSimulation).toArray();
        AbstractWidget[] abstractWidgetArray2 = new AbstractWidget[abstractWidgetArray.length + objectArray.length];
        System.arraycopy((Object)abstractWidgetArray, 0, (Object)abstractWidgetArray2, 0, abstractWidgetArray.length);
        System.arraycopy((Object)objectArray, 0, (Object)abstractWidgetArray2, abstractWidgetArray.length, objectArray.length);
        TransitionLayout transitionLayout = new TransitionLayout();
        transitionLayout.setNewLayoutManager(layoutManagerSimulation);
        transitionLayout.setNewWidthHint(n);
        transitionLayout.setNewHeightHint(n2);
        transitionLayout.setWidgets(abstractWidgetArray2);
        transitionLayout.setAnimatePreferredSize(false);
        this.setupTransitionBounds(transitionLayout);
        return transitionLayout;
    }

    protected void setupTransitionBounds(TransitionLayout transitionLayout) {
        Object object;
        int n = transitionLayout.getNewWidthHint();
        int n2 = transitionLayout.getNewHeightHint();
        LayoutManagerSimulation layoutManagerSimulation = transitionLayout.getNewLayoutManager();
        AbstractWidget[] abstractWidgetArray = transitionLayout.getWidgets();
        if (n == -1 || n2 == -1) {
            object = layoutManagerSimulation.calculateSize(this, this.getWidthForPrefSizeCalculation(n));
            if (n == -1) {
                n = object[0];
            }
            if (n2 == -1) {
                n2 = object[1];
            }
        }
        if (n == -2) {
            n = this.getWidth();
        }
        if (n2 == -2) {
            n2 = this.getHeight();
        }
        object = layoutManagerSimulation.simulateLayout(n, n2);
        int[][] nArrayArray = new int[abstractWidgetArray.length][];
        System.arraycopy(object, 0, nArrayArray, 0, ((int[])object).length);
        int[][] nArrayArray2 = new int[abstractWidgetArray.length][];
        for (int i2 = 0; i2 < abstractWidgetArray.length; ++i2) {
            AbstractWidget abstractWidget = abstractWidgetArray[i2];
            if (!abstractWidget.isOnScreen() || !(abstractWidget.getRenderOpacity() > 0.0f)) continue;
            int[] nArray = new int[]{abstractWidget.getX(), abstractWidget.getY(), abstractWidget.getWidth(), abstractWidget.getHeight()};
            nArrayArray2[i2] = nArray;
        }
        transitionLayout.setNewChildrenBounds(nArrayArray);
        transitionLayout.setOldChildrenBounds(nArrayArray2);
        transitionLayout.setOldPreferredHeight(this.height);
        transitionLayout.setNewPreferredHeight(n2);
        transitionLayout.setOldPreferredWidth(this.width);
        transitionLayout.setNewPreferredWidth(n);
    }

    private int getWidthForPrefSizeCalculation(int n) {
        if (n == -1) {
            return -1;
        }
        if (n == -2) {
            return this.width;
        }
        return n;
    }

    private List getNotLayoutedChildren(LayoutManagerSimulation layoutManagerSimulation) {
        List list = Arrays.asList(layoutManagerSimulation.getSimulationWidgets());
        ArrayList arrayList = new ArrayList(Math.max(0, this.getChildrenSize() - list.size()));
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (list.contains(abstractWidget)) continue;
            arrayList.add(abstractWidget);
        }
        return arrayList;
    }

    public void animateLayoutTransition(float f2) {
        if (this.layoutManager instanceof TransitionLayout) {
            TransitionLayout transitionLayout = (TransitionLayout)this.layoutManager;
            transitionLayout.setProgress(f2);
            if (transitionLayout.isAnimatePreferredSize()) {
                this.invalidateLayout(null);
            } else {
                this.invalidateChildrenBounds();
            }
        }
    }

    public void layoutTransitionFinished() {
        if (this.layoutManager instanceof TransitionLayout) {
            TransitionLayout transitionLayout = (TransitionLayout)this.layoutManager;
            this.finishTransition(transitionLayout);
            this.setLayoutManager(transitionLayout.getNewLayoutManager());
        }
    }

    private void finishTransition(TransitionLayout transitionLayout) {
        transitionLayout.setProgress(1.0f);
        transitionLayout.layout(this);
    }

    public boolean isLayoutTransitionInProgress() {
        return this.layoutManager instanceof TransitionLayout;
    }

    protected void autoLayoutSetup() {
        super.autoLayoutSetup();
        if (this.hasLayoutChoice(0) && this.layoutChoices[0] instanceof GridLayout) {
            MultiLayoutContainerController.autoLayoutSetup((GridLayout)this.layoutChoices[0]);
        }
    }
}

