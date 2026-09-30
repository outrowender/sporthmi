/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.FallbackMenuModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelGUI;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class MenuModel
extends AbstractModel
implements MenuModelApp,
MenuModelGUI {
    private static final Object NULL_ITEM = new Object();
    private MenuModelListener listener = FallbackMenuModelListener.INSTANCE;
    private final SimpleIntObjectMap menuItems = new SimpleIntObjectMap();
    private final String logPrefix;
    private volatile WidgetFocusAdvice currentWidgetAdvice;
    private volatile FocusedMenuItem lastFocusedMenuItem;

    public MenuModel(int n) {
        super(n);
        this.logPrefix = new Buffer().append('{').append(n).append("} [MenuModel.").toString();
    }

    public int getModelType() {
        return 27;
    }

    public boolean isEmpty() {
        return false;
    }

    public void resetListener() {
        this.listener = FallbackMenuModelListener.INSTANCE;
    }

    public void registerMenuItem(int n) {
        this.menuItems.add(n, NULL_ITEM);
    }

    public void registerMenuItem(int n, BaseListModel baseListModel) {
        this.menuItems.add(n, baseListModel);
    }

    public void unregisterMenuItem(int n) {
        this.menuItems.remove(n);
    }

    public void setListener(MenuModelListener menuModelListener) {
        this.listener = menuModelListener != null ? menuModelListener : FallbackMenuModelListener.INSTANCE;
    }

    public void updateAdvice(WidgetFocusAdvice widgetFocusAdvice) {
        this.currentWidgetAdvice = widgetFocusAdvice;
    }

    public void itemFocused(int n, WidgetFocusAdvice widgetFocusAdvice, long l, int n2) {
        this.lc.log(10000000, "%1.itemFocused] menuItem:%3 %2", (Object)this.logPrefix, (Object)widgetFocusAdvice, (long)n);
        try {
            this.currentWidgetAdvice = widgetFocusAdvice;
            this.listener.itemFocused(n, this.id, l, n2);
            Object object = this.menuItems.get(n);
            if (object != null && object instanceof BaseListModel) {
                ((BaseListModel)object).itemFocused(l, 0, n2);
            }
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void trigger(ModelTrigger modelTrigger) {
        this.lc.log(10000000, "%1.trigger] %2", (Object)this.logPrefix, (Object)modelTrigger);
        if (this.connected()) {
            this.fireModelUpdateEvent(modelTrigger);
        }
    }

    public WidgetFocusAdvice getAdvice() {
        return this.currentWidgetAdvice;
    }

    public FocusedMenuItem getLastFocusedMenuItem() {
        return this.lastFocusedMenuItem;
    }

    public void setFocusedItem(int n, FocusAdvice focusAdvice, long l) {
        this.lc.log(10000000, "%1.setFocusedItem] item:%2 uniqueID:%3", (Object)this.logPrefix, (long)n, l);
        this.lc.log(10000000, "%1.setFocusedItem] %2", (Object)this.logPrefix, (Object)focusAdvice);
        this.lastFocusedMenuItem = new FocusedMenuItem(n, focusAdvice, l);
        if (this.connected()) {
            ModelUpdateData modelUpdateData = ModelUpdateData.obtain(23).put(ModelUpdateData.Key.ITEMID, n).put(ModelUpdateData.Key.UNIQUEID, l).put(ModelUpdateData.Key.FOCUS_ADVICE, focusAdvice);
            this.fireModelUpdateEvent(modelUpdateData);
        }
    }

    public void resetFocusedItem() {
        this.lastFocusedMenuItem = null;
    }

    public String dumpContent() {
        Buffer buffer = new Buffer(1000);
        buffer.append(super.dumpContent());
        buffer.append("\ncurrentWidgetAdvice: ").append(this.currentWidgetAdvice);
        buffer.append("\nlastFocusedMenuItem: ").append(this.lastFocusedMenuItem);
        return buffer.toString();
    }

    public static class FocusedMenuItem {
        private final int menuItemID;
        private final FocusAdvice advice;
        private final long uniqueListRowID;

        private FocusedMenuItem(int n, FocusAdvice focusAdvice, long l) {
            this.menuItemID = n;
            this.advice = focusAdvice;
            this.uniqueListRowID = l;
        }

        public int getMenuItemID() {
            return this.menuItemID;
        }

        public FocusAdvice getAdvice() {
            return this.advice;
        }

        public long getUniqueListRowID() {
            return this.uniqueListRowID;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("menuItemID:").append(this.menuItemID);
            buffer.append(", uniqueListRowID:").append(this.uniqueListRowID);
            buffer.append(", ").append(this.advice);
            return buffer.toString();
        }
    }
}

