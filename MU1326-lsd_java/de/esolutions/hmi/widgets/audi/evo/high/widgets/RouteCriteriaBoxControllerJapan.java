/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.RouteOptionTollConstantsJp;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRouteCriteriaBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class RouteCriteriaBoxControllerJapan
extends AbstractRouteCriteriaBoxController
implements RouteOptionTollConstantsJp {
    private static final int MODEL_TOLL_LIST;
    private static final int NUM_ROUTE_CRITERIA;
    private static final int ICON_REROUTING;
    private static final int ICON_SEASONALLY_RESTRICTED;
    private static final int ICON_FERRY;
    private static final int ICON_MOTORWAY_ENTRANCE;
    private static final int ICON_MOTORWAY_EXIT;
    private static final int ICON_TOLL_SEGMENT;
    private static final int ICON_TOLL_AMOUNT;
    private static final int NUM_ICONS;
    private static final int LABEL_MOTORWAY_ENTRANCE;
    private static final int LABEL_MOTORWAY_EXIT;
    private static final int LABEL_TOLL_SEGMENT;
    private static final int LABEL_TOLL_AMOUNT;
    private static final int NUM_TEXTS;
    private static final int NUM_ROWS;
    private static final int MAX_WIDTH_TEXT;
    private static final int X_OFFSET;
    private static final int[] Y_OFFSETS_TOLL_VISIBLE;
    private static final int Y_OFFSET_SEP1;
    private static final int Y_OFFSET_SEP2;
    private LayoutContainerController[] rows;
    private LabelController[] labels;
    private IconController separatingLineTop;
    private IconController separatingLineBottom;
    private boolean isTollInfoVisible;
    private String[] cachedTexts;

    @Override
    protected boolean isRegion(int n) {
        return n == 3;
    }

    private static final void createGridLayoutLine(LayoutContainerController layoutContainerController, AbstractWidgetController[] abstractWidgetControllerArray, int[] nArray) {
        int n = abstractWidgetControllerArray.length;
        int n2 = 1;
        GridLayout gridLayout = new GridLayout();
        AxisConstraints axisConstraints = new AxisConstraints(n);
        AxisConstraints axisConstraints2 = new AxisConstraints(n2);
        axisConstraints2.setAlignment(new int[]{5});
        axisConstraints.setGaps(nArray);
        gridLayout.setColumnConstraints(axisConstraints);
        gridLayout.setRowConstraints(axisConstraints2);
        IGridLayoutHints[] iGridLayoutHintsArray = new GridLayoutHints[n];
        for (int i2 = 0; i2 < n; ++i2) {
            layoutContainerController.add(abstractWidgetControllerArray[i2]);
            iGridLayoutHintsArray[i2] = new GridLayoutHints(i2, 0);
        }
        gridLayout.setWidgetConstraints(iGridLayoutHintsArray, abstractWidgetControllerArray);
        layoutContainerController.setLayoutManager(gridLayout);
    }

    @Override
    protected void printBoxInfo(LogChannel logChannel) {
        if (logChannel.isDebug()) {
            int n;
            for (n = 0; n < this.itemState.length; ++n) {
                logChannel.log(-2137614336, "RouteCriteriaBoxController#printBoxInfo %1-th itemState: %2", (long)n, (long)this.itemState[n]);
            }
            for (n = 0; n < 3; ++n) {
                logChannel.log(-2137614336, "RouteCriteriaBoxController#printBoxInfo %2-th icon visible: %1", this.icons[n].isVisible(), (long)n);
            }
            for (n = 0; n < this.labels.length; ++n) {
                logChannel.log(-2137614336, "RouteCriteriaBoxController#printBoxInfo %2-th text: %1", (Object)this.labels[n].getText(), (long)n);
            }
        }
    }

    @Override
    protected void setUpIndividualProperties() {
        this.itemState = new int[3];
        this.cachedTexts = new String[4];
        this.modelStubs = new int[]{807536128};
    }

    @Override
    protected void setUpWidgets() {
        int n;
        int[] nArray = this.getBitmapIndices();
        if (nArray == null) {
            mapOverlayLogCh.log(10000, "RouteCriteriaBoxControllerJapan#connected No bitmaps found.");
            return;
        }
        this.rows = new LayoutContainerController[5];
        for (n = 0; n < 5; ++n) {
            this.rows[n] = RouteCriteriaBoxControllerJapan.createLayoutContainer(178, 100);
            this.rows[n].setX(9);
            this.rows[n].setY(Y_OFFSETS_TOLL_VISIBLE[n]);
            this.rows[n].setVisible(false);
            this.add(this.rows[n]);
        }
        this.icons = new IconController[7];
        this.icons[0] = RouteCriteriaBoxControllerJapan.createIcon(nArray, new int[]{0, 1, 2});
        this.icons[1] = RouteCriteriaBoxControllerJapan.createIcon(nArray, 8);
        this.icons[2] = RouteCriteriaBoxControllerJapan.createIcon(nArray, 4);
        this.icons[3] = RouteCriteriaBoxControllerJapan.createIcon(nArray, 13);
        this.icons[4] = RouteCriteriaBoxControllerJapan.createIcon(nArray, 14);
        this.icons[5] = RouteCriteriaBoxControllerJapan.createIcon(nArray, 15);
        this.icons[6] = RouteCriteriaBoxControllerJapan.createIcon(nArray, 16);
        this.labels = new LabelController[4];
        for (n = 0; n < 4; ++n) {
            this.labels[n] = RouteCriteriaBoxControllerJapan.createLabel(115, 50);
        }
        this.separatingLineTop = RouteCriteriaBoxControllerJapan.createIcon(nArray, 17);
        this.separatingLineBottom = RouteCriteriaBoxControllerJapan.createIcon(nArray, 17);
        this.separatingLineTop.setVisible(false);
        this.separatingLineBottom.setVisible(false);
        this.separatingLineTop.setY(49);
        this.separatingLineBottom.setY(163);
        this.add(this.separatingLineTop);
        this.add(this.separatingLineBottom);
    }

    @Override
    protected void setUpLayout() {
        GridLayout gridLayout = new GridLayout();
        AxisConstraints axisConstraints = new AxisConstraints(1);
        AxisConstraints axisConstraints2 = new AxisConstraints(1);
        int[] nArray = new int[]{9, 9};
        int[] nArray2 = new int[]{9, 9};
        axisConstraints.setGaps(nArray);
        axisConstraints2.setGaps(nArray2);
        axisConstraints.shrink = new float[]{1.0f};
        axisConstraints.grow = new float[]{1.0f};
        axisConstraints2.shrink = new float[]{1.0f};
        axisConstraints2.grow = new float[]{1.0f};
        gridLayout.setColumnConstraints(axisConstraints);
        gridLayout.setRowConstraints(axisConstraints2);
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.overlapGaps = 15;
        gridLayoutHints.ignoreForCellSizes = true;
        gridLayout.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints}, new AbstractWidgetController[]{this.plate});
        this.setLayoutManager(gridLayout);
        RouteCriteriaBoxControllerJapan.createGridLayoutLine(this.rows[0], new AbstractWidgetController[]{this.icons[0], this.icons[1], this.icons[2]}, new int[]{0, 10, 10, 9});
        RouteCriteriaBoxControllerJapan.createGridLayoutLine(this.rows[1], new AbstractWidgetController[]{this.icons[3], this.labels[0]}, new int[]{0, 10, 9});
        RouteCriteriaBoxControllerJapan.createGridLayoutLine(this.rows[2], new AbstractWidgetController[]{this.icons[4], this.labels[1]}, new int[]{0, 10, 9});
        RouteCriteriaBoxControllerJapan.createGridLayoutLine(this.rows[3], new AbstractWidgetController[]{this.icons[5], this.labels[2]}, new int[]{0, 10, 9});
        RouteCriteriaBoxControllerJapan.createGridLayoutLine(this.rows[4], new AbstractWidgetController[]{this.icons[6], this.labels[3]}, new int[]{0, 10, 9});
        this.setPreferredWidth(178);
    }

    @Override
    protected void updateContent(Object object, int n) {
        Object[] objectArray;
        Object object2;
        if (n == this.getModelID()) {
            if (!(object instanceof ListCell[][])) {
                return;
            }
            object2 = (ListCell[][])object;
            objectArray = new int[this.itemState.length];
            RouteCriteriaBoxControllerJapan.getRow((ListCell[][])object2, 0, new int[]{1, 7, 3}, objectArray);
            if (this.isInitialized() && !RouteCriteriaBoxControllerJapan.arrayChanged(this.itemState, objectArray)) {
                mapOverlayLogCh.log(-2137614336, "RouteCriteriaBoxControllerJapan#updateContent Content not changed for model %1.", (long)n);
                return;
            }
            this.itemState = objectArray;
            this.icons[0].setVisible(true);
            this.icons[0].setValue(this.itemState[0]);
            this.icons[1].setVisible(this.itemState[1] == 1);
            this.icons[2].setVisible(this.itemState[2] == 1);
        } else if (n == 807536128) {
            boolean bl;
            if (!(object instanceof TiledListModelGUI)) {
                mapOverlayLogCh.log(10000, "RouteCriteriaBoxControllerJapan#updateContent data is null.");
                return;
            }
            object2 = (TiledListModelGUI)object;
            objectArray = new String[4];
            RouteCriteriaBoxControllerJapan.getRow((TiledListModelGUI)object2, 0, (String[])objectArray);
            boolean bl2 = bl = object2.getStatus() == 1;
            if (this.isInitialized() && !RouteCriteriaBoxControllerJapan.arrayChanged(this.cachedTexts, (String[])objectArray) && this.isTollInfoVisible == bl) {
                mapOverlayLogCh.log(-2137614336, "RouteCriteriaBoxControllerJapan#updateContent Content not changed for model %1.", (long)n);
                return;
            }
            this.cachedTexts = (String[])objectArray;
            this.isTollInfoVisible = bl;
            this.labels[0].setText(this.cachedTexts[0]);
            this.labels[1].setText(this.cachedTexts[1]);
            this.labels[2].setText(this.cachedTexts[2]);
            this.labels[3].setText(this.cachedTexts[3]);
        } else {
            mapOverlayLogCh.log(10000, "RouteCriteriaBoxControllerJapan#updateContent Received update event from unknown model with ID = %1", (long)n);
            return;
        }
        mapOverlayLogCh.log(-2137614336, "RouteCriteriaBoxControllerJapan#updateContent tollVisible = %1", this.isTollInfoVisible);
        int n2 = this.isTollInfoVisible ? 260 : 50;
        this.setPreferredHeight(n2);
        this.rows[0].setVisible(true);
        for (int i2 = 1; i2 < 5; ++i2) {
            this.rows[i2].setVisible(this.isTollInfoVisible);
        }
        this.separatingLineTop.setVisible(this.isTollInfoVisible);
        this.separatingLineBottom.setVisible(this.isTollInfoVisible);
        this.setCompositesDirty(true);
        this.printBoxInfo(mapOverlayLogCh);
    }

    static {
        Y_OFFSETS_TOLL_VISIBLE = new int[]{9, 66, 114, 180, 219};
    }
}

