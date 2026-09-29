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
import de.esolutions.hmi.widgets.audi.base.WidgetRegistry$ScreenRegisterInfo;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WidgetRegistry
implements IWidgetRegistry,
IGapWidgetRegistry {
    public static final int WIDGET_MENU;
    public static final int WIDGET_CURSORBAR;
    public static final int WIDGET_STATUSBAR;
    public static final int WIDGET_SCREEN;
    public static final int WIDGET_SCROLLBAR;
    public static final int WIDGET_BACKGROUND;
    public static final int WIDGET_SUBTITLE;
    public static final int WIDGET_BORDER;
    public static final int WIDGET_WIZARD;
    public static final int WIDGET_SOFTKEY_NW;
    public static final int WIDGET_SOFTKEY_SW;
    public static final int WIDGET_SOFTKEY_NE;
    public static final int WIDGET_SOFTKEY_SE;
    public static final int WIDGET_ROTARY;
    public static final int WIDGET_GROUP_OPACITY;
    public static final int WIDGET_HORIZONTAL_SHIFT;
    public static final int WIDGET_SIDEBAR;
    public static final int WIDGET_INFOBOX;
    public static final int WIDGET_ENT_DRAWER;
    public static final int WIDGET_GLASSPLATE;
    public static final int WIDGET_SCD;
    public static final int WIDGET_MAX;
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

    @Override
    public synchronized void setMultilineMinVisLines(int n) {
        if (this.m_mlWidget != null) {
            this.m_mlWidget.setMultilineMinVisLines(n);
        }
    }

    @Override
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

    @Override
    public void setStatusbarGapEventHandler(IStatusbarGapEventHandler iStatusbarGapEventHandler) {
        this.statusbarGapEventHandler = iStatusbarGapEventHandler;
        if (this.getEntertainmentDrawerGapEventHandler() != null) {
            this.entertainmentDrawerGapEventHandler.onGapDataChanged(1);
        }
    }

    @Override
    public IStatusbarGapEventHandler getStatusbarGapEventHandler() {
        return this.statusbarGapEventHandler;
    }

    @Override
    public void setEntertainmentDrawerGapEventHandler(IEntertainmentDrawerGapEventHandler iEntertainmentDrawerGapEventHandler) {
        this.entertainmentDrawerGapEventHandler = iEntertainmentDrawerGapEventHandler;
    }

    @Override
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
            IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#newScreenConnected info is already kept for screen: %1, resetting registerinfo", (Object)screen);
            ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).deregisterWidgets();
        } else {
            WidgetRegistry$ScreenRegisterInfo widgetRegistry$ScreenRegisterInfo;
            if (!this.registerInfoPool.isEmpty()) {
                widgetRegistry$ScreenRegisterInfo = (WidgetRegistry$ScreenRegisterInfo)this.registerInfoPool.remove(0);
                WidgetRegistry$ScreenRegisterInfo.access$002(widgetRegistry$ScreenRegisterInfo, screen);
            } else {
                widgetRegistry$ScreenRegisterInfo = new WidgetRegistry$ScreenRegisterInfo(screen);
            }
            this.registerInfos.put(screen, widgetRegistry$ScreenRegisterInfo);
        }
    }

    public void screenDisconnected(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            WidgetRegistry$ScreenRegisterInfo widgetRegistry$ScreenRegisterInfo = (WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen);
            widgetRegistry$ScreenRegisterInfo.deregisterWidgets();
            this.registerInfoPool.add(widgetRegistry$ScreenRegisterInfo);
            this.registerInfos.remove(screen);
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#screenDisconnected no info was  kept for screen: %1", (Object)screen);
        }
    }

    protected void deregisterWidgets(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).deregisterWidgets();
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#deregisterWidgets no info kept for screen: %1", (Object)screen);
        }
    }

    public List getHorizontalShiftWidgets(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).getHorizontalShiftWidgets();
        }
        IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#getHorizontalShiftWidgets no info kept for screen: %1", (Object)screen);
        return null;
    }

    public List getGroupOpacityWidgets(Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).getGroupOpacityWidgets();
        }
        IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#getGroupOpacityWidgets no info kept for screen: %1", (Object)screen);
        return null;
    }

    public void registerWidget(AbstractWidget abstractWidget, int n, int n2, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).registerWidget(abstractWidget, n, n2);
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#registerWidget no info kept for screen: %1", (Object)screen);
        }
    }

    public void deRegisterWidget(AbstractWidget abstractWidget, int n, int n2, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).deRegisterWidget(abstractWidget, n, n2);
        } else {
            IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#deRegisterWidget no info kept for screen: %1", (Object)screen);
        }
    }

    public AbstractWidget getWidget(int n, int n2, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).getWidget(n, n2);
        }
        IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#getWidget no info kept for screen: %1", (Object)screen);
        return null;
    }

    public AbstractWidget getVisibleSoftkey(int n, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).getVisibleSoftkey(n);
        }
        IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#getVisibleSoftkey no info kept for screen: %1", (Object)screen);
        return null;
    }

    public List getSoftkeys(int n, Screen screen) {
        if (this.registerInfos.containsKey(screen)) {
            return ((WidgetRegistry$ScreenRegisterInfo)this.registerInfos.get(screen)).getSoftkeys(n);
        }
        IWidgetLogChannel.logWidgetRegistry.log(-1601830656, "WidgetRegistry#getSoftkeys no info kept for screen: %1", (Object)screen);
        return null;
    }

    public void setBalFaderController(IBalFadeTouchpadConfig iBalFadeTouchpadConfig) {
        this.m_balFadCtrl = iBalFadeTouchpadConfig;
    }

    @Override
    public String bftp_getConfigs() {
        return this.m_balFadCtrl != null ? this.m_balFadCtrl.bftp_getConfigs() : "<NULL>";
    }

    @Override
    public String bftp_getKbType() {
        return this.m_balFadCtrl != null ? this.m_balFadCtrl.bftp_getKbType() : "<NULL>";
    }

    @Override
    public void bftp_setTouchSensitivity(float f2, float f3) {
        if (this.m_balFadCtrl != null) {
            this.m_balFadCtrl.bftp_setTouchSensitivity(f2, f3);
        }
    }

    @Override
    public void bftp_setLockBreakDist(float f2, float f3, float f4) {
        if (this.m_balFadCtrl != null) {
            this.m_balFadCtrl.bftp_setLockBreakDist(f2, f3, f4);
        }
    }
}

