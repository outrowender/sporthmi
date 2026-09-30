/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuSDSNumbersRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class MenuSDSNumbersController
extends AbstractWidgetController {
    private IMenuSDSNumbersRenderer renderer;
    private int[] numberPositionsY;
    private boolean[] numbersEnabled;
    private float numbersOpacity = 1.0f;
    private GlassplateController glassplate;

    protected void initializeWidget() {
        super.initializeWidget();
        if (this.isSdsActiveOnConnect()) {
            this.setSdsActive(true);
        }
    }

    private boolean isSdsActiveOnConnect() {
        if (this.parent instanceof MenuController) {
            return ((MenuController)this.parent).isSDSActive();
        }
        menuLogCh.log(100000, "MenuSDSNumbersController#isSdsActiveOnConnect: parent is not a menu (screen: %2, parent: %1)", (Object)this.parent, (long)this.getScreenId());
        return false;
    }

    public void predisconnecting() {
        this.setSdsActive(false);
        super.predisconnecting();
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IMenuSDSNumbersRenderer iMenuSDSNumbersRenderer) {
        this.renderer = iMenuSDSNumbersRenderer;
    }

    public int[] getNumberPositionsY() {
        return this.numberPositionsY;
    }

    public void setNumberPositionsY(int[] nArray) {
        this.numberPositionsY = nArray;
    }

    public int getNumbersCount() {
        return this.numberPositionsY == null ? 0 : this.numberPositionsY.length;
    }

    public float getNumbersOpacity() {
        return this.numbersOpacity;
    }

    public void setNumbersOpacity(float f2) {
        this.numbersOpacity = f2;
    }

    public boolean[] getNumbersEnabled() {
        return this.numbersEnabled;
    }

    public void setNumbersEnabled(boolean[] blArray) {
        this.numbersEnabled = blArray;
    }

    public boolean isSdsNumberEnabled(int n) {
        if (this.numbersEnabled != null && this.numbersEnabled.length > n) {
            return this.numbersEnabled[n];
        }
        return true;
    }

    public void setSdsActive(boolean bl) {
        menuLogCh.log(10000000, "MenuSDSNumbersController#setSdsActive: SDSactive: %1 (screen: %3, parent: %2)", (Object)bl, (Object)this.parent, (long)this.getScreenId());
        this.configureNumbersBackground(bl);
        this.configureScaling(bl);
    }

    private void configureScaling(boolean bl) {
        DrawerAnimationManager drawerAnimationManager = ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager();
        drawerAnimationManager.setSdsState(bl ? 1.0f : 0.0f, false);
    }

    private void configureNumbersBackground(boolean bl) {
        GlassplateController glassplateController = this.getGlassplate();
        if (glassplateController != null) {
            glassplateController.setSdsNumbersVisible(bl ? 1.0f : 0.0f);
        } else {
            menuLogCh.log(100000, "MenuSDSNumbersController#configureGlassplate: no glassplate found (screen: %2, parent: %1)", (Object)this.parent, (long)this.getScreenId());
        }
    }

    public GlassplateController getGlassplate() {
        if (this.glassplate == null) {
            this.glassplate = this.findGlassplate();
        }
        return this.glassplate;
    }

    private GlassplateController findGlassplate() {
        AbstractWidget abstractWidget = this;
        int n = 20;
        for (int i2 = 0; i2 < n; ++i2) {
            Object object;
            if (abstractWidget == null) {
                return null;
            }
            if (abstractWidget instanceof GlassplateController) {
                return (GlassplateController)abstractWidget;
            }
            if (abstractWidget instanceof MenuController) {
                object = ((MenuController)abstractWidget).getChildOfRole(4);
                if (object instanceof GlassplateController) {
                    return (GlassplateController)object;
                }
            } else if (abstractWidget instanceof ContainerController) {
                object = ((AbstractWidget)abstractWidget).getChildren().iterator();
                while (object.hasNext()) {
                    AbstractWidget abstractWidget2 = (AbstractWidget)object.next();
                    if (!(abstractWidget2 instanceof GlassplateController)) continue;
                    return (GlassplateController)abstractWidget2;
                }
            }
            abstractWidget = abstractWidget.getParent();
        }
        menuLogCh.log(10000, "MenuSDSNumbersController#findGlassplate: hierarchy top not reached after %1 steps without finding a glassplate", (long)n);
        return null;
    }
}

