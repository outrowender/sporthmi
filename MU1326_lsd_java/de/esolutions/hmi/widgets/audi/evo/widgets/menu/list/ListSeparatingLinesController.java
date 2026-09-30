/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import java.util.List;

public class ListSeparatingLinesController
extends AbstractWidgetController
implements IMenuCallback {
    private MenuController getMenu() {
        return (MenuController)this.parent;
    }

    public void menuLayouted() {
        int n = this.setupVisibleSeparators();
        this.hideAdditionalSeparators(n);
    }

    private int setupVisibleSeparators() {
        MenuLayout menuLayout = this.getMenu().getLayout();
        int n = menuLayout.getFirstVisibleItem();
        int n2 = menuLayout.getLastVisibleItem();
        if (n == -1 || n2 == -1) {
            return 0;
        }
        int n3 = 0;
        AbstractWidget abstractWidget = this.getMenu().getChildOfRole(1);
        int n4 = abstractWidget == null ? -1000 : abstractWidget.getY();
        int n5 = abstractWidget == null ? -1000 : abstractWidget.getY() + abstractWidget.getHeight() - 1;
        List list = this.getMenu().getAnimationManager().getLayoutData().layoutItems;
        boolean bl = false;
        for (int i2 = n; i2 <= n2; ++i2) {
            MenuItemMetaData menuItemMetaData = (MenuItemMetaData)list.get(i2);
            if (menuItemMetaData.isRealized()) {
                AbstractWidget abstractWidget2;
                if (!bl && menuItemMetaData.hasSeparatorAbove()) {
                    abstractWidget2 = this.setupSeparatorWidget(n3);
                    this.layoutSeparatorLine(abstractWidget2, menuItemMetaData, true, n4, n5);
                    ++n3;
                }
                if (menuItemMetaData.hasSeparatorBelow()) {
                    abstractWidget2 = this.setupSeparatorWidget(n3);
                    this.layoutSeparatorLine(abstractWidget2, menuItemMetaData, false, n4, n5);
                    ++n3;
                    bl = true;
                    continue;
                }
                bl = false;
                continue;
            }
            menuLogCh.log(100000, "ListSeparatingLinesController#setupVisibleSeparators: item %1 is not realized (item height: %2 -> %3)", (Object)menuItemMetaData, (long)menuItemMetaData.heightBefore, (long)menuItemMetaData.heightAfter);
        }
        return n3;
    }

    private AbstractWidget setupSeparatorWidget(int n) {
        if (n < this.getChildrenSize()) {
            return this.getChild(n);
        }
        IconController iconController = new IconController();
        IconRenderer iconRenderer = ((ExtHMITerminalEvo)this.getTerminal()).getRendererFactory().createIconRenderer(iconController);
        iconController.setRenderer(iconRenderer);
        iconRenderer.setScaleMode(3);
        iconController.setProcessStateChange(2);
        iconController.setColorIndices(new int[]{0, 2, 2, 2});
        iconController.setBitmaps(new int[]{HMIImageConstantsSystem.separator_line});
        this.add(iconController);
        return iconController;
    }

    private void layoutSeparatorLine(AbstractWidget abstractWidget, MenuItemMetaData menuItemMetaData, boolean bl, int n, int n2) {
        MenuController menuController = this.getMenu();
        int n3 = this.calculateSeparatorY(menuItemMetaData, bl);
        if (this.shouldHideForCursor(n3, n, n2)) {
            menuLayoutLogCh.log(10000000, "LineSeparatingLinesController#layoutSeparatorLine: hide separatingLine %2 item %1 at position %3 because adjacent cursor", (Object)menuItemMetaData, (Object)(bl ? "above" : "below"), (long)n3);
            abstractWidget.setOnScreen(false);
        } else {
            menuLayoutLogCh.log(10000000, "LineSeparatingLinesController#layoutSeparatorLine: show separatingLine %2 item %1 at position %3", (Object)menuItemMetaData, (Object)(bl ? "above" : "below"), (long)n3);
            abstractWidget.setOnScreen(true);
            abstractWidget.setBounds(menuItemMetaData.widget.getX(), n3, menuItemMetaData.widget.getWidth(), 1);
            if (menuController instanceof NowPlayingMenuController) {
                abstractWidget.setOpacity(((NowPlayingMenuController)menuController).getNowPlayingFadeOutOpacity());
            }
        }
    }

    private boolean shouldHideForCursor(int n, int n2, int n3) {
        if (!AbstractWidget.isScreenResolution1440()) {
            return false;
        }
        int n4 = 2;
        return n == n2 - n4 - 1 || n == n3 + n4 + 1;
    }

    private int calculateSeparatorY(MenuItemMetaData menuItemMetaData, boolean bl) {
        int n = this.getMenu().getLayout().getItemsGap();
        if (bl) {
            int n2 = n / 2;
            return menuItemMetaData.widget.getY() - n2;
        }
        int n3 = n / 2 + n % 2;
        return menuItemMetaData.widget.getY() + menuItemMetaData.widget.getHeight() - 1 + n3;
    }

    private void hideAdditionalSeparators(int n) {
        for (int i2 = n; i2 < this.getChildrenSize(); ++i2) {
            this.getChild(i2).setOnScreen(false);
        }
    }

    public void viewportUpdated(boolean bl) {
    }

    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    public void menuFocusChangeFinished() {
    }

    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    public void setActiveMenuController(MenuController menuController) {
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }

    public IRenderer getRenderer() {
        return null;
    }
}

