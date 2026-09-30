/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShuffleContainerController
extends AbstractWidgetController
implements IMenuItemMultiItem,
LayoutContainer {
    private List shuffledItems = null;
    private int menuContentWidth;
    private int menuContentHeight;
    private boolean shuffleEnabled = false;

    protected void initializeWidget() {
        this.shuffleItems();
        super.initializeWidget();
    }

    private void shuffleItems() {
        this.shuffledItems = new ArrayList(this.getChildrenSize());
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof MenuItemController)) continue;
            ((MenuItemController)object).setOnScreen(false);
            if (((MenuItemController)object).isVisible()) {
                this.shuffledItems.add(object);
            }
            menuItemLogCh.log(10000000, "ShuffleContainerController#shuffleItem: add item %1 to shuffled container", object);
        }
        if (!this.shuffledItems.isEmpty() && this.isActive() && this.isShuffleEnabled()) {
            Collections.shuffle(this.shuffledItems);
        }
    }

    public int getSubItemCount() {
        return this.shuffledItems.size();
    }

    public void setMenuSize(int n, int n2, int n3) {
        this.menuContentWidth = n;
        this.menuContentHeight = n2;
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof IMenuItemSingle)) continue;
            ((MenuItemController)object).setMenuSize(n, n2, n3);
        }
    }

    public int getItemIndexForUniqueID(long l) {
        return (int)l;
    }

    public Long getUniqueIDForItemIndex(int n) {
        return new Long(n);
    }

    public MenuItemMetaData createMenuItem(int n) {
        MenuItemMetaData menuItemMetaData = new MenuItemMetaData();
        List list = this.shuffledItems;
        int n2 = this.shuffledItems.size();
        if (0 <= n && n < n2) {
            menuItemMetaData.widget = (AbstractWidgetController)list.get(n);
        }
        return menuItemMetaData;
    }

    public void destroyMenuItem(MenuItemMetaData menuItemMetaData) {
        if (!menuItemMetaData.isRealized()) {
            return;
        }
        menuItemLogCh.log(10000000, "ShuffleContainerController#destroyMenuItem: destroy menu item %1", (Object)menuItemMetaData.index);
        if (menuItemMetaData.widget != null) {
            menuItemMetaData.widget.setOnScreen(false);
        }
        menuItemMetaData.widget = null;
    }

    public int getSizeForTabulator(int n) {
        return -1;
    }

    public int getWidgetID() {
        return -1;
    }

    public boolean realizeMenuItem(MenuItemMetaData menuItemMetaData) {
        int n = menuItemMetaData.index.widgetPart;
        menuItemMetaData.widget = this.getChildWithIndex(n);
        return true;
    }

    private AbstractWidgetController getChildWithIndex(int n) {
        int n2 = this.shuffledItems.size();
        if (n2 > 0 && n < n2) {
            return (AbstractWidgetController)this.shuffledItems.get(n);
        }
        return null;
    }

    public boolean isEnabled(int n) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.shuffledItems.get(n);
        return this.isEnabled() && abstractWidgetController.isEnabled();
    }

    public int getPreferredMenuItemHeight(int n, boolean bl) {
        Object object;
        if (this.shuffledItems != null && 0 <= n && n < this.shuffledItems.size() && (object = this.shuffledItems.get(n)) instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)object).getPreferredHeight(bl, this.menuContentWidth);
        }
        return 0;
    }

    public int getPreferredMenuItemHeight(MenuItemMetaData menuItemMetaData, boolean bl) {
        if (this.shuffledItems.size() > menuItemMetaData.index.widgetPart && menuItemMetaData.widget instanceof MenuItemController) {
            return ((IMenuItemSingle)((Object)menuItemMetaData.widget)).getPreferredHeight(bl, this.menuContentWidth);
        }
        return 0;
    }

    public int getGlassplateInsets(int n, boolean bl) {
        Object object;
        if (this.shuffledItems != null && 0 <= n && n < this.shuffledItems.size() && (object = this.shuffledItems.get(n)) instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)object).getGlassplateInsets(bl);
        }
        return 0;
    }

    public int getGlassplateInsets(MenuItemMetaData menuItemMetaData, boolean bl) {
        if (this.shuffledItems.size() > menuItemMetaData.index.widgetPart && menuItemMetaData.widget instanceof MenuItemController) {
            return ((IMenuItemSingle)((Object)menuItemMetaData.widget)).getGlassplateInsets(bl);
        }
        return 0;
    }

    public boolean isFocusable(int n) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.shuffledItems.get(n);
        if (abstractWidgetController instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidgetController)).isFocusable();
        }
        menuItemLogCh.log(100000, "SubelementMenuItemController#isFocusable: child %2 is not a IMenuItemSingle: %1", (Object)abstractWidgetController, (long)n);
        return true;
    }

    public int getMargin(int n, boolean bl) {
        Object object;
        if (this.shuffledItems != null && this.shuffledItems.size() > n && n >= 0 && (object = this.shuffledItems.get(n)) instanceof MenuItemController) {
            return ((MenuItemController)object).getMargin(bl);
        }
        return 0;
    }

    public int getMargin(MenuItemMetaData menuItemMetaData, boolean bl) {
        if (menuItemMetaData.widget instanceof MenuItemController) {
            return ((MenuItemController)menuItemMetaData.widget).getMargin(bl);
        }
        return 0;
    }

    public void showExtended(boolean bl, int n) {
    }

    public void keyPressed(KeyEvent keyEvent, int n) {
    }

    public void keyReleased(KeyEvent keyEvent, int n) {
    }

    public void itemFocused(int n) {
    }

    public IFocusedPropertyObject getPropertiesForLine(int n) {
        return null;
    }

    public IPresetPopupData getPresetPopupData(int n) {
        return null;
    }

    public int getSdsItemSelectedAction(int n) {
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.shuffledItems.get(n);
        if (abstractWidgetController instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidgetController)).getSdsItemSelectedAction();
        }
        return 0;
    }

    public boolean hasInfolineText(int n) {
        return false;
    }

    public void invalidateLayout(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof MenuItemController) {
            this.updateShuffleItemsList((MenuItemController)abstractWidget);
        }
        this.invalidateParentLayout();
    }

    public String getInfolineText(int n) {
        return null;
    }

    public IRenderer getRenderer() {
        return null;
    }

    public int getMenuContentWidth() {
        return this.menuContentWidth;
    }

    public int getMenuContentHeight() {
        return this.menuContentHeight;
    }

    public void updateSubItemCount() {
    }

    public boolean updateMenuItem(MenuItemMetaData menuItemMetaData) {
        List list = this.shuffledItems;
        int n = this.shuffledItems.size();
        if (0 <= menuItemMetaData.index.widgetPart && menuItemMetaData.index.widgetPart < n) {
            Object object = list.get(menuItemMetaData.index.widgetPart);
            return object == menuItemMetaData.widget;
        }
        return false;
    }

    public int getSelectedIndex() {
        return -1;
    }

    public void disconnecting() {
        this.shuffledItems.clear();
        this.shuffledItems = null;
        super.disconnecting();
    }

    public void setShuffleEnabled(boolean bl) {
        this.shuffleEnabled = bl;
    }

    public boolean isShuffleEnabled() {
        return this.shuffleEnabled;
    }

    public void updateShuffleItemsList(MenuItemController menuItemController) {
        if (this.shuffledItems == null) {
            return;
        }
        if (!menuItemController.isVisible() && this.shuffledItems.contains(menuItemController)) {
            this.shuffledItems.remove(menuItemController);
            menuItemLogCh.log(10000000, "ShuffleContainerController#updateShuffleItemsList: remove item %1 to shuffled container , item is invisible", (Object)menuItemController);
        } else if (menuItemController.isVisible() && !this.shuffledItems.contains(menuItemController)) {
            this.shuffledItems.add(menuItemController);
            menuItemLogCh.log(10000000, "ShuffleContainerController#updateShuffleItemsList: add item %1 to shuffled container , item is visible", (Object)menuItemController);
        }
    }

    public boolean isNowPlayingModeEnabled(int n) {
        return false;
    }

    public int getNoCursorArea(int n, boolean bl) {
        return 0;
    }

    public int getNoCursorArea(MenuItemMetaData menuItemMetaData, boolean bl) {
        return 0;
    }

    public void setFocusedCursorBeforeMerge(int n) {
    }
}

