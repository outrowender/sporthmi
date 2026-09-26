/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLineController;
import java.util.List;

public abstract class SeparatingLines
extends AbstractWidgetController {
    protected MenuController parentMenu;
    private boolean isSetUp = false;
    private boolean auto = true;

    public boolean isAuto() {
        return this.auto;
    }

    public void setManual() {
        this.auto = false;
    }

    public SeparatingLineController addSeparator(AbstractWidgetController abstractWidgetController, AbstractWidgetController abstractWidgetController2) {
        if (this.auto) {
            throw new IllegalStateException("only supported in manual mode!");
        }
        if (this.parentMenu == null && !(this.parent instanceof MenuController)) {
            throw new IllegalStateException(new StringBuffer().append("cannot add separator to parent ").append(this.parent).toString());
        }
        int[] nArray = this.getBitmapIndices();
        if (nArray != null && nArray.length > 0) {
            MenuController menuController = this.parentMenu != null ? this.parentMenu : (MenuController)this.parent;
            return this.addSeparator(nArray[0], menuController, abstractWidgetController, abstractWidgetController2);
        }
        return null;
    }

    private SeparatingLineController addSeparator(int n, MenuController menuController, AbstractWidgetController abstractWidgetController, AbstractWidgetController abstractWidgetController2) {
        SeparatingLineController separatingLineController = new SeparatingLineController();
        IconRenderer iconRenderer = this.createIconRenderer(separatingLineController);
        separatingLineController.setRenderer(iconRenderer);
        separatingLineController.setBitmaps(new int[]{n});
        separatingLineController.setPredecessor(abstractWidgetController);
        separatingLineController.setSuccessor(abstractWidgetController2);
        separatingLineController.setX(this.getX());
        menuController.add(separatingLineController, 7);
        return separatingLineController;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.parent instanceof MenuController) {
            this.parentMenu = (MenuController)this.parent;
            this.setUpWidget();
        } else {
            menuItemLogCh.log(10000, "SeparatingLines#connected Parent is null or is not a menu.");
        }
    }

    protected abstract IconRenderer createIconRenderer(SeparatingLineController separatingLineController) {
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            if (this.parentMenu != null && this.auto) {
                int[] nArray = this.getBitmapIndices();
                if (nArray == null || nArray.length == 0) {
                    menuItemLogCh.log(10000, "SeparatingLinesHigh#setUpWidget No bitmaps were configured.");
                    return;
                }
                List list = this.parentMenu.getChildren();
                AbstractWidgetController abstractWidgetController = null;
                AbstractWidgetController abstractWidgetController2 = null;
                int n = list.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
                    if (!this.parentMenu.isMenuItem(abstractWidget)) continue;
                    if (abstractWidgetController == null) {
                        abstractWidgetController = (AbstractWidgetController)abstractWidget;
                        continue;
                    }
                    abstractWidgetController2 = (AbstractWidgetController)abstractWidget;
                    SeparatingLineController separatingLineController = this.addSeparator(nArray[0], this.parentMenu, abstractWidgetController, abstractWidgetController2);
                    if (separatingLineController != null) {
                        ((IconRenderer)separatingLineController.getRenderer()).setAlignment(1, 5);
                    }
                    abstractWidgetController = abstractWidgetController2;
                }
            }
            this.isSetUp = true;
        }
    }
}

