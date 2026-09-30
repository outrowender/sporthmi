/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.MenuItemBuilder;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.Iterator;

public class DynamicMenuItemController
extends MenuItemController {
    private int originalType = -1;

    public void connected(InitializationContext initializationContext) {
        menuItemLogCh.log(10000000, "DynamicMenuItemController#connected() - Called.");
        super.connected(initializationContext);
        this.buildMenuItem();
    }

    protected void initializeWidget() {
        menuItemLogCh.log(10000000, "DynamicMenuItemController#initializeWidget() - Called.");
        super.initializeWidget();
        this.buildMenuItem();
    }

    private void buildMenuItem() {
        menuItemLogCh.log(10000000, "DynamicMenuItemController#buildMenuItem() - Called.");
        this.updateFromModel();
        this.autoSetup();
        if ((this.topGap != -1 || this.bottomGap != -1) && this.layoutManager != null) {
            GridLayout gridLayout = (GridLayout)this.layoutManager;
            AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getRowConstraints();
            axisConstraints.gaps[0] = this.topGap;
            axisConstraints.gaps[axisConstraints.gaps.length - 1] = this.bottomGap;
        }
    }

    public void setVisible(boolean bl) {
        menuItemLogCh.log(10000000, "DynamicMenuItemController#autoSetup() - Called.");
        super.setVisible(bl);
    }

    protected void autoSetup() {
        menuItemLogCh.log(10000000, "DynamicMenuItemController#autoSetup() - Called.");
        if (this.originalType == -1) {
            menuItemLogCh.log(10000000, "DynamicMenuItemController#autoSetup() - Original Type unknown till know, setting it to %1.", (long)this.type);
            this.originalType = this.type;
        }
        this.type = this.originalType;
        MenuItemBuilder.configureMenuItem(this, (ExtHMITerminalEvo)((Object)this.getTerminalImpl()));
        if (this.useSmallStageTextForMainLabel) {
            Iterator iterator = this.getChildren().iterator();
            while (iterator.hasNext()) {
                AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
                if (!(abstractWidgetController instanceof LabelController)) continue;
                ((LabelController)abstractWidgetController).setUseSmallStageText(true);
                break;
            }
        }
        if (this.autoConfigureChaining) {
            MenuItemBuilder.configureChaining(this);
        }
    }
}

