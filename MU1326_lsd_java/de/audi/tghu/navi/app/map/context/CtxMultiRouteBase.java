/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxRouteBase;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public abstract class CtxMultiRouteBase
extends CtxRouteBase {
    protected CtxMultiRouteBase(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (bl) {
            if (!this.naviMap.getMapDataContainer().isInMap && !this.naviMap.getMapDataContainer().isInPreviewMap) {
                this.getLogChannel().log(1078071040, "CtxMultiRouteBase#updateRgActive(): not in map, switching to hidden context");
                this.naviMap.switchToContext(3);
            } else if (!this.naviMap.getRouteCalculationHandler().isSingleRoute()) {
                this.getLogChannel().log(1078071040, "CtxMultiRouteBase#updateRgActive(): switching to alt route context");
                this.naviMap.switchToContext(5);
            } else {
                this.getLogChannel().log(1078071040, "CtxMultiRouteBase#updateRgActive(): switching to shown context");
                this.naviMap.switchToAShownContext();
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 1125910016) {
            try {
                boolean bl;
                if (this.getMap().getActiveContextIndex() == 20) {
                    bl = n2 == 0 || n2 == 1;
                } else {
                    CalculatedRouteListElement calculatedRouteListElement = this.getMap().getRouteCalculationHandler().getCalculatedRouteListElement()[n2];
                    boolean bl2 = bl = calculatedRouteListElement != null && MapUtils.isCRLElementCalculated(calculatedRouteListElement);
                }
                if (bl) {
                    this.getGUI().fireModelEvent(n);
                    this.onRouteSelected(n2);
                }
            }
            catch (Exception exception) {
                this.getLogChannel().log(-1601830656, "CtxMultiRouteBase#itemSelected() - invalid route index, %1", (Throwable)exception);
            }
        } else {
            super.itemSelected(n, n2, n3, n4);
        }
    }

    protected abstract void onRouteSelected(int n) {
    }

    @Override
    public void itemFocused(int n, int n2) {
        super.itemFocused(n, n2);
        this.getMap().getRouteCalculationHandler().restartTimerIfCalculationStateIsReady();
        this.focusRoute(n2);
    }

    protected void focusRoute(int n) {
        this.getLogChannel().log(-2137614336, "CtxMultiRouteBase#focusRoute( %1 )", (long)n);
        this.getMap().getRouteCalculationHandler().setSelectedRouteIndex(n);
        this.displayCurrentRoute();
        this.refreshRouteOptions();
    }
}

