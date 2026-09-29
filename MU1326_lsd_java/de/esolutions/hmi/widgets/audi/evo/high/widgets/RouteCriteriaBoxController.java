/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IAxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRouteCriteriaBoxController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListController2;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class RouteCriteriaBoxController
extends AbstractRouteCriteriaBoxController {
    private static final int ICON_HOV_LANES;
    private static final int ICON_REROUTING;
    private static final int ICON_AEA;
    private static final int ICON_FERRY;
    private static final int ICON_MOTORAIL;
    private static final int ICON_TOLLROAD;
    private static final int ICON_VIGNETTE;
    private static final int ICON_SEASONALLY_RESTRICTED;
    private static final int ICON_FREEWAY;
    private static final int ICON_TIME_RESTRICTED;
    private static final int NUM_ICONS;
    private static final int MAX_ITEMS_VISIBLE;
    private int[] cachedItemStates;

    @Override
    protected void printBoxInfo(LogChannel logChannel) {
        if (logChannel.isDebug()) {
            int n;
            for (n = 0; n < this.itemState.length; ++n) {
                logChannel.log(-2137614336, "RouteCriteriaBoxController#printBoxInfo %1-th itemState: %2", (long)n, (long)this.itemState[n]);
            }
            for (n = 0; n < this.icons.length; ++n) {
                logChannel.log(-2137614336, "RouteCriteriaBoxController#printBoxInfo %2-th icon visible: %1", this.icons[n].isVisible(), (long)n);
            }
        }
    }

    @Override
    protected boolean isRegion(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: {
                return true;
            }
        }
        return false;
    }

    private boolean isNAR() {
        return framework.isNar();
    }

    @Override
    protected void setUpIndividualProperties() {
        this.itemState = new int[10];
        this.cachedItemStates = new int[10];
    }

    @Override
    protected void setUpWidgets() {
        int[] nArray = this.getBitmapIndices();
        if (nArray == null) {
            mapOverlayLogCh.log(10000, "RouteCriteriaBoxController#connected No bitmaps defined.");
            return;
        }
        this.icons = new IconController[10];
        this.icons[0] = RouteCriteriaBoxController.createIcon(nArray, new int[]{12, 11});
        this.icons[1] = RouteCriteriaBoxController.createIcon(nArray, new int[]{0, 1, 2});
        this.icons[2] = RouteCriteriaBoxController.createIcon(nArray, 3);
        this.icons[3] = RouteCriteriaBoxController.createIcon(nArray, 4);
        this.icons[4] = RouteCriteriaBoxController.createIcon(nArray, 5);
        this.icons[5] = RouteCriteriaBoxController.createIcon(nArray, 6);
        this.icons[6] = RouteCriteriaBoxController.createIcon(nArray, 7);
        this.icons[7] = RouteCriteriaBoxController.createIcon(nArray, 8);
        this.icons[8] = RouteCriteriaBoxController.createIcon(nArray, 9);
        this.icons[9] = RouteCriteriaBoxController.createIcon(nArray, 10);
        this.add(this.icons[0]);
        this.add(this.icons[1]);
        for (int i2 = 2; i2 < 10; ++i2) {
            this.icons[i2].setVisible(false);
            this.add(this.icons[i2]);
        }
        this.icons[0].setVisible(false);
    }

    @Override
    protected void setUpLayout() {
        IGridLayoutHints[] iGridLayoutHintsArray;
        int n;
        boolean bl = MixedListController2.isMMIKombi();
        int n2 = 11;
        int n3 = 10;
        int n4 = 1;
        GridLayout gridLayout = new GridLayout();
        IGridLayoutHints[] iGridLayoutHintsArray2 = new AxisConstraints(n3);
        AxisConstraints axisConstraints = new AxisConstraints(n4);
        iGridLayoutHintsArray2.gaps = new int[n3 + 1];
        iGridLayoutHintsArray2.gaps[0] = 11;
        for (n = 1; n < iGridLayoutHintsArray2.gaps.length - 1; ++n) {
            iGridLayoutHintsArray2.gaps[n] = 17;
        }
        iGridLayoutHintsArray2.gaps[iGridLayoutHintsArray2.gaps.length - 1] = 11;
        axisConstraints.gaps = bl ? new int[]{13, 12} : new int[]{12, 13};
        if (bl) {
            iGridLayoutHintsArray = iGridLayoutHintsArray2;
            iGridLayoutHintsArray2 = axisConstraints;
            axisConstraints = iGridLayoutHintsArray;
        }
        gridLayout.setColumnConstraints((IAxisConstraints)iGridLayoutHintsArray2);
        gridLayout.setRowConstraints(axisConstraints);
        iGridLayoutHintsArray = new GridLayoutHints[n2];
        AbstractWidgetController[] abstractWidgetControllerArray = new AbstractWidgetController[n2];
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.overlapGaps = 15;
        gridLayoutHints.ignoreForCellSizes = true;
        if (bl) {
            gridLayoutHints.rowSpan = n3;
            gridLayoutHints.columnSpan = n4;
        } else {
            gridLayoutHints.rowSpan = n4;
            gridLayoutHints.columnSpan = n3;
        }
        for (n = 0; n < n3; ++n) {
            int n5 = 0;
            int n6 = n;
            if (bl) {
                int n7 = n5;
                n5 = n6;
                n6 = n7;
            }
            iGridLayoutHintsArray[n] = new GridLayoutHints(n6, n5);
            abstractWidgetControllerArray[n] = this.icons[n];
        }
        iGridLayoutHintsArray[n] = gridLayoutHints;
        abstractWidgetControllerArray[n] = this.plate;
        gridLayout.setWidgetConstraints(iGridLayoutHintsArray, abstractWidgetControllerArray);
        this.setLayoutManager(gridLayout);
    }

    @Override
    protected void updateContent(Object object, int n) {
        int n2;
        int n3;
        if (n != this.getModelID()) {
            return;
        }
        if (!(object instanceof ListCell[][])) {
            return;
        }
        ListCell[][] listCellArray = (ListCell[][])object;
        int[] nArray = new int[10];
        RouteCriteriaBoxController.getRow(listCellArray, 0, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, nArray);
        if (this.isInitialized() && !RouteCriteriaBoxController.arrayChanged(this.cachedItemStates, nArray)) {
            mapOverlayLogCh.log(-2137614336, "RouteCriteriaBoxController#updateContent Content not changed.");
            return;
        }
        this.cachedItemStates = nArray;
        this.itemState[0] = this.cachedItemStates[0];
        this.itemState[1] = this.cachedItemStates[1];
        int n4 = 1;
        for (n3 = 2; n3 < this.cachedItemStates.length; ++n3) {
            n2 = this.cachedItemStates[n3];
            if (n2 == 1) {
                ++n4;
            }
            this.itemState[n3] = n2;
        }
        n2 = 6;
        n3 = this.itemState.length - 1;
        while (n4 > n2) {
            while (this.itemState[n3] == 0) {
                --n3;
            }
            this.itemState[n3] = 0;
            --n4;
        }
        if (this.isNAR()) {
            this.icons[1].setVisible(false);
            this.icons[0].setVisible(true);
            this.icons[0].setValue(this.itemState[0]);
        } else {
            this.icons[1].setVisible(true);
            this.icons[0].setVisible(false);
        }
        this.icons[1].setValue(this.itemState[1]);
        for (n3 = 2; n3 < this.icons.length; ++n3) {
            this.icons[n3].setVisible(this.itemState[n3] == 1);
        }
        this.printBoxInfo(mapOverlayLogCh);
    }
}

