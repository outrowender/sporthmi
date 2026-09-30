/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import java.util.ArrayList;
import java.util.List;

public class MapStatuslineLabelContainer
extends LayoutContainerController {
    private IconController maneuverPoint;
    private List labels = new ArrayList(2);
    private boolean isSetUp = false;

    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof IconController) {
            this.maneuverPoint = (IconController)abstractWidget;
        } else if (abstractWidget instanceof LabelController) {
            this.labels.add(abstractWidget);
        }
        super.add(abstractWidget);
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (!this.isSetUp) {
            if (this.labels.size() != 2) {
                return;
            }
            if (this.maneuverPoint == null) {
                return;
            }
            LabelController labelController = (LabelController)this.labels.get(0);
            LabelController labelController2 = (LabelController)this.labels.get(1);
            GridLayout gridLayout = new GridLayout(1, 1);
            AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
            axisConstraints.setAlignment(new int[]{2});
            GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
            axisConstraints.grow = new float[]{1.0f};
            GridLayout gridLayout2 = new GridLayout(2, 1);
            AxisConstraints axisConstraints2 = (AxisConstraints)gridLayout2.getRowConstraints();
            axisConstraints2.setAlignment(new int[]{5});
            axisConstraints = (AxisConstraints)gridLayout2.getColumnConstraints();
            axisConstraints.setGaps(new int[]{0, 5, 0});
            axisConstraints.shrink = new float[]{0.0f, 1.0f};
            GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 0);
            gridLayoutHints2.setWidthMin(15);
            GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
            gridLayout2.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints2, gridLayoutHints3, gridLayoutHints3}, new AbstractWidgetController[]{this.maneuverPoint, labelController, labelController2});
            gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{gridLayout2});
            this.setLayoutManager(gridLayout);
            this.isSetUp = true;
        }
    }
}

