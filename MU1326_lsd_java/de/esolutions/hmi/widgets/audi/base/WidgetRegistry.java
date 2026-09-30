/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IBalFadeTouchpadConfig;
import de.audi.tghu.hmi.evo.IMultilineWidget;
import de.audi.tghu.hmi.evo.IWidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IEntertainmentDrawerGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IGapWidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.IStatusbarGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WidgetRegistry
implements IWidgetRegistry,
IGapWidgetRegistry {
    public static final int WIDGET_MENU = 0;
    public static final int WIDGET_CURSORBAR = 1;
    public static final int WIDGET_STATUSBAR = 2;
    public static final int WIDGET_SCREEN = 3;
    public static final int WIDGET_SCROLLBAR = 4;
    public static final int WIDGET_BACKGROUND = 5;
    public static final int WIDGET_SUBTITLE = 6;
    public static final int WIDGET_BORDER = 7;
    public static final int WIDGET_WIZARD = 8;
    public static final int WIDGET_SOFTKEY_NW = 9;
    public static final int WIDGET_SOFTKEY_SW = 10;
    public static final int WIDGET_SOFTKEY_NE = 11;
    public static final int WIDGET_SOFTKEY_SE = 12;
    public static final int WIDGET_ROTARY = 13;
    public static final int WIDGET_GROUP_OPACITY = 14;
    public static final int WIDGET_HORIZONTAL_SHIFT = 15;
    public static final int WIDGET_SIDEBAR = 16;
    public static final int WIDGET_INFOBOX = 17;
    public static final int WIDGET_ENT_DRAWER = 18;
    public static final int WIDGET_GLASSPLATE = 19;
    public static final int WIDGET_SCD = 20;
    public static final int WIDGET_MAX = 21;
    private volatile IMultilineWidget m_mlWidget = null;
    private ArrayList waitAnimCtrls = new ArrayList();
    protected IStatusbarGapEventHandler statusbarGapEventHandler = null;
    protected IEntertainmentDrawerGapEventHandler entertainmentDrawerGapEventHandler = null;
    protected AbstractWidgetController m_parkingDisclaimerHandler = null;
    protected boolean parkingDisclaimerVisible = false;
    private Map registerInfos = new HashMap(50);
    private List registerInfoPool = new ArrayList(2);
    private IBalFadeTouchpadConfig m_balFadCtrl = null;

    public synchronized void setSelectedMultilineWidget(IMultilineWidget iMultilineWidget) {
        this.m_mlWidget = iMultilineWidget;
    }

    public synchronized IMultilineWidget getSelectedMultilineWidget() {
        return this.m_mlWidget;
    }

    public synchronized void setMultilineMinVisLines(int n) {
        if (this.m_mlWidget != null) {
            this.m_mlWidget.setMultilineMinVisLines(n);
        }
    }

    public synchronized void setMultilineMaxVisLines(int n) {
        if (this.m_mlWidget != null) {
            this.m_mlWidget.setMultilineMaxVisLines(n);
        }
    }

    public void setParkingDisclaimerHandler(AbstractWidgetController abstractWidgetController) {
        this.m_parkingDisclaimerHandler = abstractWidgetController;
        this.showParkingDisclaimer(this.parkingDisclaimerVisible);
    }

    public void showParkingDisclaimer(boolean bl) {
        this.parkingDisclaimerVisible = bl;
        if (this.m_parkingDisclaimerHandler != null) {
            this.m_parkingDisclaimerHandler.setVisible(this.parkingDisclaimerVisible);
        }
    }

    public void setStatusbarGapEventHandler(IStatusbarGapEventHandler iStatusbarGapEventHandler) {
        this.statusbarGapEventHandler = iStatusbarGapEventHandler;
        if (this.getEntertainmentDrawerGapEventHandler() != null) {
            this.entertainmentDrawerGapEventHandler.onGapDataChanged(1);
        }
    }

    public IStatusbarGapEventHandler getStatusbarGapEventHandler() {
        return this.statusbarGapEventHandler;
    }

    public void setEntertainmentDrawerGapEventHandler(IEntertainmentDrawerGapEventHandler iEntertainmentDrawerGapEventHandler) {
        this.entertainmentDrawerGapEventHandler = iEntertainmentDrawerGapEventHandler;
    }

    public IEntertainmentDrawerGapEventHandler getEntertainmentDrawerGapEventHandler() {
        return this.entertainmentDrawerGapEventHandler;
    }

    public void addActiveWaitAnimController(AbstractWidgetController abstractWidgetController) {
        if (!this.waitAnimCtrls.contains(abstractWidgetController)) {
            this.waitAnimCtrls.add(abstractWidgetController);
        }
    }

    public ArrayList getActiveWaitAnimControllers() {
        return this.waitAnimCtrls;
    }

    public void newScreenConnected(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#newScreenConnected info is already kept for screen: %1, resetting registerinfo", (Object)screen);
            ((ScreenRegisterInfo)this.registerInfos.get(screen)).deregisterWidgets();
        } else {
            ScreenRegisterInfo screenRegisterInfo;
            if (!this.registerInfoPool.isEmpty()) {
                screenRegisterInfo = (ScreenRegisterInfo)this.registerInfoPool.remove(0);
                screenRegisterInfo.screen = screen;
            } else {
                screenRegisterInfo = new ScreenRegisterInfo(screen);
            }
            this.registerInfos.put(screen, screenRegisterInfo);
        }
    }

    public void screenDisconnected(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            ScreenRegisterInfo screenRegisterInfo = (ScreenRegisterInfo)this.registerInfos.get(screen);
            screenRegisterInfo.deregisterWidgets();
            this.registerInfoPool.add(screenRegisterInfo);
            this.registerInfos.remove(screen);
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#screenDisconnected no info was  kept for screen: %1", (Object)screen);
        }
    }

    protected void deregisterWidgets(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            ((ScreenRegisterInfo)this.registerInfos.get(screen)).deregisterWidgets();
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#deregisterWidgets no info kept for screen: %1", (Object)screen);
        }
    }

    public List getHorizontalShiftWidgets(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((ScreenRegisterInfo)this.registerInfos.get(screen)).getHorizontalShiftWidgets();
        }
        IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#getHorizontalShiftWidgets no info kept for screen: %1", (Object)screen);
        return null;
    }

    public List getGroupOpacityWidgets(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((ScreenRegisterInfo)this.registerInfos.get(screen)).getGroupOpacityWidgets();
        }
        IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#getGroupOpacityWidgets no info kept for screen: %1", (Object)screen);
        return null;
    }

    public void registerWidget(AbstractWidget abstractWidget, int n, int n2, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            ((ScreenRegisterInfo)this.registerInfos.get(screen)).registerWidget(abstractWidget, n, n2);
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#registerWidget no info kept for screen: %1", (Object)screen);
        }
    }

    public void deRegisterWidget(AbstractWidget abstractWidget, int n, int n2, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            ((ScreenRegisterInfo)this.registerInfos.get(screen)).deRegisterWidget(abstractWidget, n, n2);
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#deRegisterWidget no info kept for screen: %1", (Object)screen);
        }
    }

    public AbstractWidget getWidget(int n, int n2, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((ScreenRegisterInfo)this.registerInfos.get(screen)).getWidget(n, n2);
        }
        IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#getWidget no info kept for screen: %1", (Object)screen);
        return null;
    }

    public AbstractWidget getVisibleSoftkey(int n, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((ScreenRegisterInfo)this.registerInfos.get(screen)).getVisibleSoftkey(n);
        }
        IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#getVisibleSoftkey no info kept for screen: %1", (Object)screen);
        return null;
    }

    public List getSoftkeys(int n, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((ScreenRegisterInfo)this.registerInfos.get(screen)).getSoftkeys(n);
        }
        IWidgetLogChannel.logWidgetRegistry.log(100000, "WidgetRegistry#getSoftkeys no info kept for screen: %1", (Object)screen);
        return null;
    }

    public void setBalFaderController(IBalFadeTouchpadConfig iBalFadeTouchpadConfig) {
        this.m_balFadCtrl = iBalFadeTouchpadConfig;
    }

    public String bftp_getConfigs() {
        return this.m_balFadCtrl != null ? this.m_balFadCtrl.bftp_getConfigs() : "<NULL>";
    }

    public String bftp_getKbType() {
        return this.m_balFadCtrl != null ? this.m_balFadCtrl.bftp_getKbType() : "<NULL>";
    }

    public void bftp_setTouchSensitivity(float f2, float f3) {
        if (this.m_balFadCtrl != null) {
            this.m_balFadCtrl.bftp_setTouchSensitivity(f2, f3);
        }
    }

    public void bftp_setLockBreakDist(float f2, float f3, float f4) {
        if (this.m_balFadCtrl != null) {
            this.m_balFadCtrl.bftp_setLockBreakDist(f2, f3, f4);
        }
    }

    private static class ScreenRegisterInfo {
        private static final int FIRST_SOFTKEY_INDEX = 9;
        private static final int SOFTKEY_TYPE_COUNT = 4;
        public AbstractWidget[] registeredWidgets;
        public List[] softkeyWidgets;
        public List groupOpacityWidgets = new ArrayList(5);
        public List horizontalShiftWidgets = new ArrayList(5);
        public Map menus;
        public Map cursorBars;
        public List sideBars;
        public int registeredWidgetsCounter = 0;
        private Screen screen;

        public ScreenRegisterInfo(Screen screen) {
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
                    IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#registerWidget unknown widgetType: %1", (long)n);
                }
            }
        }

        public void deRegisterWidget(AbstractWidget abstractWidget, int n, int n2) {
            --this.registeredWidgetsCounter;
            if (this.registeredWidgetsCounter < 0) {
                IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#deregisterWidget registered widgets are negative: %1", (long)this.registeredWidgetsCounter);
            }
            switch (n) {
                case 1: {
                    if (this.cursorBars.remove(new Integer(n2)) == abstractWidget) break;
                    IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#deregisterWidget cursorbar with menuID: %1 was not registered", (long)n2);
                    break;
                }
                case 0: {
                    if (this.menus.remove(new Integer(n2)) == abstractWidget) break;
                    IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#deregisterWidget menu with menuID: %1 was not registered", (long)n2);
                    break;
                }
                case 14: {
                    if (this.groupOpacityWidgets.remove(abstractWidget)) break;
                    IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#deregisterWidget widget: %1 was not registered as group opacity widget", (Object)abstractWidget);
                    break;
                }
                case 15: {
                    if (this.horizontalShiftWidgets.remove(abstractWidget)) break;
                    IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#deregisterWidget widget: %1 was not registered as horizontal shift widget", (Object)abstractWidget);
                    break;
                }
                case 16: {
                    if (this.sideBars.remove(abstractWidget)) break;
                    IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#deregisterWidget widget: %1 was not registered as sidebar widget", (Object)abstractWidget);
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
                    IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#registerWidget unknown widgetType: %1", (long)n);
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
            IWidgetLogChannel.logWidgetRegistry.log(100000, "ScreenRegisterInfo#getWidget unknown widgetType: %1", (long)n);
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
            IWidgetLogChannel.logWidgetRegistry.log(10000000, "ScreenRegisterInfo#getActiveSoftkey %2 softkeys found for type %1, but none is visible.", (long)n, (long)list.size());
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
    }
}

