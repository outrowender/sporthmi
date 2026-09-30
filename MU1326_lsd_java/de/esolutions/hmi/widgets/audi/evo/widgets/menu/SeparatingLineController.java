/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import java.util.Iterator;
import java.util.List;

public class SeparatingLineController
extends IconController
implements IMenuCallback {
    private int predWidId = -1;
    private int succWidId = -1;
    private MenuController parentMenu;
    private AbstractWidgetController c1;
    private AbstractWidgetController c2;

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.parent instanceof MenuController) {
            this.parentMenu = (MenuController)this.parent;
            ((IconRenderer)this.getRenderer()).setScaleMode(3);
            if (this.predWidId != -1) {
                this.c1 = (AbstractWidgetController)this.parentMenu.getChild(this.parentMenu.getChildIndexForWidgetId(this.predWidId));
            }
            if (this.succWidId != -1) {
                this.c2 = (AbstractWidgetController)this.parentMenu.getChild(this.parentMenu.getChildIndexForWidgetId(this.succWidId));
            }
        } else {
            menuItemLogCh.log(10000, "SeparatingLineController#connected Parent is null or is not a MenuController.");
        }
    }

    public void menuLayouted() {
        AbstractWidgetController abstractWidgetController = this.c1;
        AbstractWidgetController abstractWidgetController2 = this.c2;
        if (abstractWidgetController == null || abstractWidgetController2 == null) {
            this.setOnScreen(false);
            return;
        }
        if (!this.isVisibleForSeparator(abstractWidgetController2)) {
            this.setOnScreen(false);
            return;
        }
        if (!this.isVisibleForSeparator(abstractWidgetController)) {
            MenuItemIndex menuItemIndex = this.parentMenu.getMenuItemIndex(abstractWidgetController);
            Iterator iterator = this.parentMenu.iterator(menuItemIndex, false, false);
            if (iterator.hasNext()) {
                menuItemIndex = (MenuItemIndex)iterator.next();
                abstractWidgetController = (AbstractWidgetController)this.parentMenu.getChild(menuItemIndex.widget);
            } else {
                this.setOnScreen(false);
                return;
            }
        }
        int n = 0;
        int n2 = 0;
        if (abstractWidgetController instanceof ListController) {
            int[] nArray = this.getListControllerPositionInformation((ListController)abstractWidgetController);
            n = nArray[0];
            n2 = nArray[2] + nArray[1] - nArray[0];
        } else {
            n = abstractWidgetController.getY();
            n2 = abstractWidgetController.getHeight();
        }
        int n3 = 0;
        if (abstractWidgetController2 instanceof ListController) {
            int[] nArray = this.getListControllerPositionInformation((ListController)abstractWidgetController2);
            n3 = nArray[0];
        } else {
            n3 = abstractWidgetController2.getY();
        }
        int n4 = (n + n2 + n3) / 2;
        boolean bl = n4 > 0 && n4 < this.parentMenu.getHeight() && n < n3;
        this.setOnScreen(bl &= abstractWidgetController.getX() < 1000 && abstractWidgetController2.getX() < 1000);
        menuItemLogCh.log(10000000, "SeparatingLineController#menuLayouted y = %2, visible = %1", bl, (long)n4);
        int n5 = this.parentMenu.getLayout().getContentLeftOffset();
        int n6 = this.parentMenu.getWidth() - this.parentMenu.getLayout().getActiveContentRightOffset(true) - n5;
        this.setBounds(n5, n4, n6, 1);
        this.setCompositesDirty(true);
        this.checkHideForAdjacentCursor();
    }

    private boolean isVisibleForSeparator(AbstractWidgetController abstractWidgetController) {
        return abstractWidgetController.isVisible() && abstractWidgetController.isVisibleOnCurrentStage() && abstractWidgetController.isOnScreen() && !this.isEmptyList(abstractWidgetController);
    }

    private boolean isEmptyList(AbstractWidgetController abstractWidgetController) {
        return abstractWidgetController instanceof IMenuItemMultiItem && ((IMenuItemMultiItem)((Object)abstractWidgetController)).getSubItemCount() == 0;
    }

    private void checkHideForAdjacentCursor() {
        AbstractWidget abstractWidget = this.parentMenu.getChildOfRole(1);
        if (abstractWidget == null) {
            return;
        }
        int n = abstractWidget.getY();
        int n2 = abstractWidget.getY() + abstractWidget.getHeight() - 1;
        boolean bl = true;
        boolean bl2 = true;
        if (abstractWidget instanceof FocusCursorController) {
            FocusCursorController focusCursorController = (FocusCursorController)abstractWidget;
            bl = focusCursorController.getBorderTopVisible() == 1.0f;
            boolean bl3 = bl2 = focusCursorController.getBorderBottomVisible() == 1.0f;
        }
        if (this.shouldHideForCursor(this.getY(), n, n2, bl, bl2)) {
            menuItemLogCh.log(10000000, "SeparatingLineController#checkHideForAdjacentCursor Separating line is hidden by cursor.");
            this.setOnScreen(false);
        }
    }

    private boolean shouldHideForCursor(int n, int n2, int n3, boolean bl, boolean bl2) {
        if (!AbstractWidget.isScreenResolution1440()) {
            return false;
        }
        int n4 = 2;
        return bl && n == n2 - n4 - 1 || bl2 && n == n3 + n4 + 1;
    }

    protected void setPredecessor(AbstractWidgetController abstractWidgetController) {
        this.c1 = abstractWidgetController;
    }

    public void setPredecessor(int n) {
        this.predWidId = n;
    }

    protected void setSuccessor(AbstractWidgetController abstractWidgetController) {
        this.c2 = abstractWidgetController;
    }

    public void setSuccessor(int n) {
        this.succWidId = n;
    }

    public void viewportUpdated(boolean bl) {
    }

    private int[] getListControllerPositionInformation(ListController listController) {
        List list = listController.getChildren();
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MIN_VALUE;
        int n3 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!abstractWidgetController.isOnScreen()) continue;
            int n4 = abstractWidgetController.getY();
            if (n4 < n) {
                n = n4;
            }
            if (n4 <= n2) continue;
            n2 = n4;
            n3 = abstractWidgetController.getHeight();
        }
        return new int[]{n, n3, n2};
    }

    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    public void menuFocusChangeFinished() {
    }

    public void setActiveMenuController(MenuController menuController) {
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

