/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class RouteBriefingLayoutContainer
extends LayoutContainerController {
    private static final int MAX_HEIGHT = 320;
    private MenuController briefingMenu;

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.setHeight(320);
        sideBarLogChannel.log(10000000, "RouteBriefingLayoutContainer#connected Set height = %1 dependent on current region.", (long)this.getHeight());
    }

    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof MenuController) {
            if (this.briefingMenu == null) {
                this.briefingMenu = (MenuController)abstractWidget;
                GridLayout gridLayout = new GridLayout(1, 2);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                AxisConstraints axisConstraints2 = new AxisConstraints(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 1);
                axisConstraints2.setGrow(new float[]{1.0f, 0.0f});
                gridLayout.setColumnConstraints(axisConstraints);
                gridLayout.setRowConstraints(axisConstraints2);
                gridLayout.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints}, new AbstractWidgetController[]{this.briefingMenu});
                this.setLayoutManager(gridLayout);
            } else {
                sideBarLogChannel.log(10000, "RouteBriefingLayoutContainer#add Trying to add second menu.");
            }
        }
    }
}

