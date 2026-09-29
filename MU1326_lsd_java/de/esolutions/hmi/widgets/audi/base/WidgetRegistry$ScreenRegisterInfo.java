/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.view.Screen;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class WidgetRegistry$ScreenRegisterInfo {
    private static final int FIRST_SOFTKEY_INDEX;
    private static final int SOFTKEY_TYPE_COUNT;
    public AbstractWidget[] registeredWidgets;
    public List[] softkeyWidgets;
    public List groupOpacityWidgets = new ArrayList(5);
    public List horizontalShiftWidgets = new ArrayList(5);
    public Map menus;
    public Map cursorBars;
    public List sideBars;
    public int registeredWidgetsCounter = 0;
    private Screen screen;

    public WidgetRegistry$ScreenRegisterInfo(Screen screen) {
        this.registeredWidgets = new AbstractWidget[21];
        this.menus = new HashMap(2);
        this.cursorBars = new HashMap(2);
        this.sideBars = new ArrayList(3);
        this.softkeyWidgets = new List[4];
        this.screen = screen;
    }

    protected void deregisterWidgets() {
        this.menus.clear();
        this.cursorBars.clear();
        this.groupOpacityWidgets.clear();
        this.horizontalShiftWidgets.clear();
        this.sideBars.clear();
        this.softkeyWidgets = new List[4];
        int n = this.registeredWidgets.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (this.registeredWidgets[i2] == null) continue;
            this.registeredWidgets[i2] = null;
        }
        this.registeredWidgetsCounter = 0;
    }

    public List getHorizontalShiftWidgets() {
        return this.horizontalShiftWidgets;
    }

    public void registerWidget(AbstractWidget abstractWidget, int n, int n2) {
        ++this.registeredWidgetsCounter;
        switch (n) {
            case 1: {
                this.cursorBars.put(new Integer(n2), abstractWidget);
                break;
            }
            case 0: {
                this.menus.put(new Integer(n2), abstractWidget);
                break;
            }
            case 14: {
                this.groupOpacityWidgets.add(abstractWidget);
                break;
            }
            case 15: {
                this.horizontalShiftWidgets.add(abstractWidget);
                break;
            }
            case 16: {
                this.sideBars.add(abstractWidget);
                break;
            }
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 13: 
            case 17: 
            case 19: {
                this.registeredWidgets[n] = abstractWidget;
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                int n3 = n - 9;
                if (this.softkeyWidgets[n3] == null) {
                    this.softkeyWidgets[n3] = new ArrayList(1);
                }
                this.softkeyWidgets[n3].add(abstractWidget);
                break;
            }
            default: {
                IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#registerWidget unknown widgetType: %1", (long)n);
            }
        }
    }

    public void deRegisterWidget(AbstractWidget abstractWidget, int n, int n2) {
        --this.registeredWidgetsCounter;
        if (this.registeredWidgetsCounter < 0) {
            IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#deregisterWidget registered widgets are negative: %1", (long)this.registeredWidgetsCounter);
        }
        switch (n) {
            case 1: {
                if (this.cursorBars.remove(new Integer(n2)) == abstractWidget) break;
                IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#deregisterWidget cursorbar with menuID: %1 was not registered", (long)n2);
                break;
            }
            case 0: {
                if (this.menus.remove(new Integer(n2)) == abstractWidget) break;
                IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#deregisterWidget menu with menuID: %1 was not registered", (long)n2);
                break;
            }
            case 14: {
                if (this.groupOpacityWidgets.remove(abstractWidget)) break;
                IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#deregisterWidget widget: %1 was not registered as group opacity widget", (Object)abstractWidget);
                break;
            }
            case 15: {
                if (this.horizontalShiftWidgets.remove(abstractWidget)) break;
                IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#deregisterWidget widget: %1 was not registered as horizontal shift widget", (Object)abstractWidget);
                break;
            }
            case 16: {
                if (this.sideBars.remove(abstractWidget)) break;
                IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#deregisterWidget widget: %1 was not registered as sidebar widget", (Object)abstractWidget);
                break;
            }
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 13: 
            case 17: 
            case 19: {
                this.registeredWidgets[n] = null;
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                int n3 = n - 9;
                if (this.softkeyWidgets[n3] == null) break;
                this.softkeyWidgets[n3].remove(abstractWidget);
                break;
            }
            default: {
                IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#registerWidget unknown widgetType: %1", (long)n);
            }
        }
    }

    public AbstractWidget getWidget(int n, int n2) {
        switch (n) {
            case 1: {
                return (AbstractWidget)this.cursorBars.get(new Integer(n2));
            }
            case 0: {
                return (AbstractWidget)this.menus.get(new Integer(n2));
            }
            case 3: {
                return (AbstractWidget)((Object)this.screen);
            }
            case 16: {
                if (0 <= n2 && n2 < this.sideBars.size()) {
                    return (AbstractWidget)this.sideBars.get(n2);
                }
                return null;
            }
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 13: 
            case 17: 
            case 19: {
                return this.registeredWidgets[n];
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                return this.getVisibleSoftkey(n);
            }
        }
        IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "ScreenRegisterInfo#getWidget unknown widgetType: %1", (long)n);
        return null;
    }

    public AbstractWidget getVisibleSoftkey(int n) {
        int n2 = n - 9;
        List list = this.softkeyWidgets[n2];
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!abstractWidget.isVisible()) continue;
            return abstractWidget;
        }
        IWidgetLogChannel.logWidgetRegistry.log(-2137614336, "ScreenRegisterInfo#getActiveSoftkey %2 softkeys found for type %1, but none is visible.", (long)n, (long)list.size());
        return null;
    }

    public List getSoftkeys(int n) {
        int n2 = n - 9;
        List list = this.softkeyWidgets[n2];
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.EMPTY_LIST;
    }

    public List getGroupOpacityWidgets() {
        return this.groupOpacityWidgets;
    }

    static /* synthetic */ Screen access$002(WidgetRegistry$ScreenRegisterInfo widgetRegistry$ScreenRegisterInfo, Screen screen) {
        widgetRegistry$ScreenRegisterInfo.screen = screen;
        return widgetRegistry$ScreenRegisterInfo.screen;
    }
}

