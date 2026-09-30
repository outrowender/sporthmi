/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapCrosshairController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapDynamicSidebar;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.OptionIconPositionController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SDRSInfoFlap;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class MapDynamicSidebarContainer
extends LayoutContainerController {
    private static final int ADDITIONAL_GUIDE_OFFSET = 202;
    private static final int Y_CENTER = 199;
    private static final int Y_TOP = -1;
    private static final int Y_OFFSET_SDRS_POPUP = 15;
    private static final int VZA_POS_SIDEBAR_CLOSED = 617;
    private static final int VZA_POS_SIDEBAR_OPENED = 596;
    private static final int Y_OFFSET = 80;
    private static final int X_OPTION_ICON = 0;
    private LayoutContainerController mapDynamicSidebarParentContainer;
    private LayoutContainerController mapDynamicSidebar;
    private LayoutContainerController routeInfoContainer;
    private LayoutContainerController trafficContainer;
    private IconLabelController vza;
    private LayoutContainerController plusContainer;
    private SDRSInfoFlap sdrsInfoFlap;
    private OptionIconPositionController plus;
    private MapCrosshairController mapCrosshair;

    public void add(AbstractWidget abstractWidget) {
        switch (abstractWidget.getRole()) {
            case 1: {
                this.mapDynamicSidebarParentContainer = (LayoutContainerController)abstractWidget;
                this.mapDynamicSidebar = (LayoutContainerController)this.mapDynamicSidebarParentContainer.getChildren().get(0);
                int n = this.mapDynamicSidebar.getChildrenSize();
                block8: for (int i2 = 0; i2 < n; ++i2) {
                    AbstractWidget abstractWidget2 = this.mapDynamicSidebar.getChild(i2);
                    switch (abstractWidget2.getRole()) {
                        case 1: {
                            this.routeInfoContainer = (LayoutContainerController)abstractWidget2;
                            continue block8;
                        }
                        case 2: {
                            this.trafficContainer = (LayoutContainerController)abstractWidget2;
                            continue block8;
                        }
                    }
                }
                if (this.mapCrosshair == null || !(this.mapDynamicSidebar instanceof MapDynamicSidebar)) break;
                ((MapDynamicSidebar)this.mapDynamicSidebar).setMapCrosshair(this.mapCrosshair);
                break;
            }
            case 4: {
                AbstractWidgetController abstractWidgetController;
                this.plusContainer = (LayoutContainerController)abstractWidget;
                if (this.plusContainer.getChildrenSize() <= 0 || !((abstractWidgetController = (AbstractWidgetController)this.plusContainer.getChild(0)) instanceof OptionIconPositionController)) break;
                this.plus = (OptionIconPositionController)abstractWidgetController;
                this.plus.setUseDynamicPosition(true);
                break;
            }
        }
        if (abstractWidget instanceof SDRSInfoFlap) {
            this.sdrsInfoFlap = (SDRSInfoFlap)abstractWidget;
        }
        if (abstractWidget instanceof MapCrosshairController) {
            this.mapCrosshair = (MapCrosshairController)abstractWidget;
            if (this.mapDynamicSidebar instanceof MapDynamicSidebar) {
                ((MapDynamicSidebar)this.mapDynamicSidebar).setMapCrosshair(this.mapCrosshair);
            }
        }
        if (abstractWidget instanceof IconLabelController) {
            this.vza = (IconLabelController)abstractWidget;
            this.vza.setX(617);
        }
        super.add(abstractWidget);
    }

    private boolean isG21() {
        return framework.getSysConst(522) == 1;
    }

    private boolean isEvoHighMMIKombi() {
        return framework.getSysConst(522) == 4;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        IRenderer iRenderer = this.getRenderer();
        if (iRenderer instanceof CompositeRendererHigh && this.isG21()) {
            ((CompositeRendererHigh)iRenderer).setClipping(true);
        }
        this.invalidateLayout(this);
    }

    public void invalidateLayout(AbstractWidget abstractWidget) {
        if (this.isEvoHighMMIKombi()) {
            return;
        }
        if (this.routeInfoContainer == null || this.trafficContainer == null) {
            sideBarLogChannel.log(10000000, "MapDynamicSidebarContainer#invalidateLayout Component is missing.");
            return;
        }
        boolean bl = this.mapDynamicSidebarParentContainer.isVisible();
        boolean bl2 = this.routeInfoContainer.isVisible();
        boolean bl3 = this.trafficContainer.isVisible();
        sideBarLogChannel.log(10000000, "MapDynamicSidebarContainer#invalidateLayout trafficVisible = %1, routeInfoContainer = %2, sidebarVisible = %3", bl3, bl2, bl);
        if (!bl) {
            if (this.plus != null) {
                this.plus.setDynamicPosition(0, -203);
            }
            if (this.sdrsInfoFlap != null) {
                this.sdrsInfoFlap.setY(14);
            }
            return;
        }
        int n = this.mapDynamicSidebarParentContainer.getY() + this.mapDynamicSidebarParentContainer.getHeight();
        int n2 = this.mapDynamicSidebar.getPreferredHeight();
        int n3 = Math.max(0, Math.min(199, n - n2 - 80));
        sideBarLogChannel.log(10000000, "MapDynamicSidebarContainer#invalidateLayout yDynamic = %1", (long)n3);
        if (this.plus != null) {
            this.plus.setDynamicPosition(0, n3 - 202);
        }
        if (this.sdrsInfoFlap != null) {
            this.sdrsInfoFlap.setY(n3 + 15);
        }
        if (this.vza != null && this.mapDynamicSidebar instanceof MapDynamicSidebar) {
            this.vza.setX(((MapDynamicSidebar)this.mapDynamicSidebar).isOpen() ? 596 : 617);
            this.vza.setCompositesDirty(true);
        }
    }
}

