/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.FallbackMenuModelListener;
import de.audi.atip.hmi.model.menu.MenuModel$FocusedMenuItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelGUI;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
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
    private volatile MenuModel$FocusedMenuItem lastFocusedMenuItem;

    public MenuModel(int n) {
        super(n);
        this.logPrefix = new Buffer().append('{').append(n).append("} [MenuModel.").toString();
    }

    @Override
    public int getModelType() {
        return 27;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
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

    @Override
    public void setListener(MenuModelListener menuModelListener) {
        this.listener = menuModelListener != null ? menuModelListener : FallbackMenuModelListener.INSTANCE;
    }

    @Override
    public void updateAdvice(WidgetFocusAdvice widgetFocusAdvice) {
        this.currentWidgetAdvice = widgetFocusAdvice;
    }

    @Override
    public void itemFocused(int n, WidgetFocusAdvice widgetFocusAdvice, long l, int n2) {
        this.lc.log(-2137614336, "%1.itemFocused] menuItem:%3 %2", (Object)this.logPrefix, (Object)widgetFocusAdvice, (long)n);
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

    @Override
    public void trigger(ModelTrigger modelTrigger) {
        this.lc.log(-2137614336, "%1.trigger] %2", (Object)this.logPrefix, (Object)modelTrigger);
        if (this.connected()) {
            this.fireModelUpdateEvent(modelTrigger);
        }
    }

    @Override
    public WidgetFocusAdvice getAdvice() {
        return this.currentWidgetAdvice;
    }

    @Override
    public MenuModel$FocusedMenuItem getLastFocusedMenuItem() {
        return this.lastFocusedMenuItem;
    }

    @Override
    public void setFocusedItem(int n, FocusAdvice focusAdvice, long l) {
        this.lc.log(-2137614336, "%1.setFocusedItem] item:%2 uniqueID:%3", (Object)this.logPrefix, (long)n, l);
        this.lc.log(-2137614336, "%1.setFocusedItem] %2", (Object)this.logPrefix, (Object)focusAdvice);
        this.lastFocusedMenuItem = new MenuModel$FocusedMenuItem(n, focusAdvice, l, null);
        if (this.connected()) {
            ModelUpdateData modelUpdateData = ModelUpdateData.obtain(23).put(ModelUpdateData$Key.ITEMID, n).put(ModelUpdateData$Key.UNIQUEID, l).put(ModelUpdateData$Key.FOCUS_ADVICE, focusAdvice);
            this.fireModelUpdateEvent(modelUpdateData);
        }
    }

    @Override
    public void resetFocusedItem() {
        this.lastFocusedMenuItem = null;
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(1000);
        buffer.append(super.dumpContent());
        buffer.append("\ncurrentWidgetAdvice: ").append(this.currentWidgetAdvice);
        buffer.append("\nlastFocusedMenuItem: ").append(this.lastFocusedMenuItem);
        return buffer.toString();
    }
}

