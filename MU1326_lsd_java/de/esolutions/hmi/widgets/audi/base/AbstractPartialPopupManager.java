/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.LanguageChangedEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.RegisterPartialPopupsEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.ScreenDebugInfoEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.audi.tghu.hmi.evo.IPartialPopupControllerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupStub;
import de.audi.tghu.hmi.evo.IScreenEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager$1;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager$2;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractPartialPopupManager
implements IPartialPopupManagerEvo,
ATIPEventListener {
    private static final boolean SHOW_ONSCREEN_DEBUG_INFOS = Boolean.getBoolean("showPartialPopupDebugInfos");
    private static final int VOLUME_POPUP_TIMEOUT_DEFAULT;
    private static final int VOLUME_POPUP_TIMEOUT_RVC;
    protected HMITerminalImpl terminal;
    protected IScreenManager screenManager;
    protected Map popups = new HashMap(180);
    protected List[] waitingPopupsQueues;
    private Map partialPopupListenerList = new HashMap();
    private IPartialPopupControllerEvo lastShownPopup;
    protected IPartialPopupControllerEvo[] currentVisiblePopups;
    protected IPartialPopupControllerEvo[] currentAnimatingPopups;
    private static final int[] SLOTS;
    protected Set blockedPopups = new HashSet();
    protected Screen currentConnectedScreen;
    private boolean partialPopupsGloballyEnabled = true;
    private boolean allPartialPopupsAllowedByScreen = true;
    private int lastScreentype = -1;
    public static final LogChannel LOGPOPUPS;
    public static final LogChannel LOGPERFORMANCE;
    protected BundleContext bundleContext;
    protected IModelConnectService connectingService;
    private EventDispatcher eventDispatcher;
    protected IFrameworkAccess framework;
    private int focusedLayer = -1;
    private int[] sortedSlots;
    private boolean atLeastOnePartialPopupVisible;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIBundle;

    public AbstractPartialPopupManager(HMITerminalImpl hMITerminalImpl, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this.terminal = hMITerminalImpl;
        this.bundleContext = bundleContext;
        this.connectingService = iFrameworkAccess.getHMIService().getModelConnectService(hMITerminalImpl.getTerminalID());
        this.eventDispatcher = iFrameworkAccess.getHMIService().getEventDispatcher();
        this.framework = iFrameworkAccess;
        this.screenManager = iFrameworkAccess.getHMITerminalRegistry().getTerminalContext(hMITerminalImpl.getTerminalID()).getScreenManager();
        this.initSlots();
    }

    public void startTrackingServices() {
        IWidgetLogChannel.logChannelPopups.log(-2137614336, "PartialPopupManager#startTrackingServices");
        this.initializePartialPopupListenerTracker();
        this.initializeUnboundPartialPopupTracker();
    }

    public void registerServices() {
    }

    private void initializePartialPopupListenerTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = AbstractPartialPopupManager.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), (ServiceTrackerCustomizer)new AbstractPartialPopupManager$1(this));
        serviceTracker.open();
    }

    private void initializeUnboundPartialPopupTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$hmi$HMIBundle == null ? (class$de$audi$atip$hmi$HMIBundle = AbstractPartialPopupManager.class$("de.audi.atip.hmi.HMIBundle")) : class$de$audi$atip$hmi$HMIBundle).getName(), (ServiceTrackerCustomizer)new AbstractPartialPopupManager$2(this));
        serviceTracker.open();
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof RegisterPartialPopupsEvent) {
            RegisterPartialPopupsEvent registerPartialPopupsEvent = (RegisterPartialPopupsEvent)aTIPEvent;
            IPartialPopupController[] iPartialPopupControllerArray = registerPartialPopupsEvent.getPopups();
            if (iPartialPopupControllerArray != null) {
                if (registerPartialPopupsEvent.isServiceAdded()) {
                    long l = this.framework.getMonotonicTime();
                    LOGPOPUPS.log(1078071040, "PartialPopupManager#processEvent -> connectNewUnboundPartialPopups for bundle %1", (long)registerPartialPopupsEvent.getBundleID());
                    this.connectNewUnboundPartialPopups(iPartialPopupControllerArray);
                    if (LOGPERFORMANCE.isDebug()) {
                        long l2 = this.framework.getMonotonicTime();
                        LOGPERFORMANCE.log(-2137614336, "PartialPopupManager#processEvent connecting partial popups from bundle %1 took %2ms", (long)registerPartialPopupsEvent.getBundleID(), l2 - l);
                    }
                } else {
                    LOGPOPUPS.log(1078071040, "PartialPopupManager#processEvent -> disconnectOldUnboundPartialPopups for bundle %1", (long)registerPartialPopupsEvent.getBundleID());
                    this.disconnectOldUnboundPartialPopups(iPartialPopupControllerArray);
                }
            }
        } else {
            LOGPOPUPS.log(-1601830656, "PartialPopupManager#processEvent: Unknown event: %1", (Object)aTIPEvent);
        }
    }

    private void disconnectOldUnboundPartialPopups(IPartialPopupController[] iPartialPopupControllerArray) {
        for (int i2 = 0; i2 < iPartialPopupControllerArray.length; ++i2) {
            Screen screen = (Screen)((Object)iPartialPopupControllerArray[i2]);
            int n = screen.getID();
            Screen screen2 = (Screen)this.popups.get(new Integer(n));
            if (screen2 != null) {
                this.connectingService.modifiyModelReference(screen2, false, true);
                if (screen2.isConnected()) {
                    screen2.disconnecting();
                }
                this.deregisterPopup((IPartialPopupControllerEvo)((Object)screen2));
                continue;
            }
            LOGPOPUPS.log(10000, "PartialPopupManager#disconnectOldUnboundPartialPopups: try unregister popup (ID %2), but it was not yet registered: %1", (Object)screen, (long)n);
        }
    }

    private int getNumberOfSlots() {
        return 14;
    }

    private void initSlots() {
        int n;
        int n2 = this.getNumberOfSlots();
        this.waitingPopupsQueues = new ArrayList[n2];
        this.currentVisiblePopups = new IPartialPopupControllerEvo[n2];
        this.currentAnimatingPopups = new IPartialPopupControllerEvo[n2];
        for (n = 0; n < n2; ++n) {
            this.waitingPopupsQueues[n] = new ArrayList(8);
        }
        this.sortedSlots = new int[14];
        for (n = 0; n < 14; ++n) {
            this.sortedSlots[n] = n;
        }
        for (n = 0; n < 14; ++n) {
            for (int i2 = n; i2 < 14; ++i2) {
                if (IPartialPopupManagerEvo.PARTIAL_POPUP_SLOT_DEPTHS[this.sortedSlots[i2]] <= IPartialPopupManagerEvo.PARTIAL_POPUP_SLOT_DEPTHS[this.sortedSlots[n]]) continue;
                int n3 = this.sortedSlots[n];
                this.sortedSlots[n] = this.sortedSlots[i2];
                this.sortedSlots[i2] = n3;
            }
        }
    }

    private int insertIntoWaitingPopupQueue(IPartialPopupControllerEvo iPartialPopupControllerEvo, int n) {
        int n2;
        for (n2 = 0; n2 < this.waitingPopupsQueues[n].size() && ((IPartialPopupControllerEvo)this.waitingPopupsQueues[n].get(n2)).getPriority() > iPartialPopupControllerEvo.getPriority(); ++n2) {
        }
        this.waitingPopupsQueues[n].add(n2, iPartialPopupControllerEvo);
        return n2;
    }

    public abstract String getPopupName(int n) {
    }

    protected boolean checkIfPopupHasToBeBlocked(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        if (iPartialPopupControllerEvo != null && !iPartialPopupControllerEvo.isPopupActive()) {
            return true;
        }
        if (!this.partialPopupsGloballyEnabled) {
            return true;
        }
        if (iPartialPopupControllerEvo == null) {
            LOGPOPUPS.log(10000, "PartialPopupManager#checkIfPopupHasToBeBlocked popup is null (has not been set correctly)");
            return false;
        }
        if (this.currentConnectedScreen != null) {
            return this.currentConnectedScreen.isPartialPopupBlocked(iPartialPopupControllerEvo);
        }
        LOGPOPUPS.log(-1601830656, "PartialPopupManager#checkIfPopupHasToBeBlocked currentConnectedScreen is null (has not been set correctly or no screen shown yet)");
        return false;
    }

    private void updatePPDebugInfo() {
        if (SHOW_ONSCREEN_DEBUG_INFOS) {
            int n = this.getNumberOfSlots();
            String[] stringArray = new String[n + 1];
            stringArray[0] = "PartialPopups:";
            for (int i2 = 0; i2 < n; ++i2) {
                stringArray[i2 + 1] = new String(new StringBuffer().append("slot ").append(i2).append(": ").toString());
                if (this.waitingPopupsQueues[i2] == null || this.waitingPopupsQueues[i2].size() == 0) {
                    int n2 = i2 + 1;
                    stringArray[n2] = new StringBuffer().append(stringArray[n2]).append("none").toString();
                    continue;
                }
                int n3 = this.waitingPopupsQueues[i2].size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    IPartialPopupControllerEvo iPartialPopupControllerEvo;
                    if (i3 > 0) {
                        int n4 = i2 + 1;
                        stringArray[n4] = new StringBuffer().append(stringArray[n4]).append(", ").toString();
                    }
                    if ((iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[i2].get(i3)) == null) {
                        int n5 = i2 + 1;
                        stringArray[n5] = new StringBuffer().append(stringArray[n5]).append("null").toString();
                        continue;
                    }
                    int n6 = i2 + 1;
                    stringArray[n6] = new StringBuffer().append(stringArray[n6]).append(this.getPopupName(iPartialPopupControllerEvo.getID())).toString();
                }
            }
            IHMIServiceEvo iHMIServiceEvo = AbstractWidget.hmiService;
            if (iHMIServiceEvo != null) {
                ScreenDebugInfoEvent screenDebugInfoEvent = new ScreenDebugInfoEvent(iHMIServiceEvo.getRootWindow(0), stringArray, 12);
                iHMIServiceEvo.getEventDispatcher().postEvent(screenDebugInfoEvent);
            }
        }
    }

    @Override
    public int showPopup(int n, IPartialPopupListener iPartialPopupListener) {
        Integer n2;
        ArrayList arrayList;
        if (LOGPOPUPS.isInfo()) {
            LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup popup with id %1 is triggered by a PartialPopupActivatorWidget", (Object)this.getPopupName(n));
        }
        if ((arrayList = (ArrayList)this.partialPopupListenerList.get(n2 = new Integer(n))) == null) {
            arrayList = new ArrayList(2);
            this.partialPopupListenerList.put(n2, arrayList);
        }
        if (!arrayList.contains(iPartialPopupListener)) {
            arrayList.add(iPartialPopupListener);
        }
        int n3 = this.showPopup(n);
        return n3;
    }

    @Override
    public int showPopupAndRepaintScreen(int n) {
        int n2 = this.showPopup(n);
        IWidgetLogChannel.logRepaintCause.log(-2137614336, "PartialPopupManager#showPopupAndRepaintScreen: do checked repaint. popup: %2, connected screen %1", (Object)this.currentConnectedScreen, (long)n);
        this.repaintScreen();
        return n2;
    }

    protected abstract boolean isSDSPartialPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
    }

    protected int doShowPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo, int n) {
        LOGPOPUPS.log(-2137614336, "PartialPopupManager#doShowPopup style: %1, id: %2", (long)n, (long)iPartialPopupControllerEvo.getID());
        this.currentAnimatingPopups[iPartialPopupControllerEvo.getSlot()] = iPartialPopupControllerEvo;
        int n2 = iPartialPopupControllerEvo.show(n);
        LOGPOPUPS.log(-2137614336, "PartialPopupManager#doShowPopup: result of popup.show(style) is: %1", (long)n2);
        if (n2 != 1) {
            this.currentAnimatingPopups[iPartialPopupControllerEvo.getSlot()] = null;
        }
        return n2;
    }

    protected int doHidePopup(IPartialPopupControllerEvo iPartialPopupControllerEvo, int n) {
        return iPartialPopupControllerEvo.hide(n);
    }

    private void getPartialPopupStubsForModule(int n) {
        LOGPOPUPS.log(-2137614336, "PartialPopupManager#getPartialPopupStubsForModule: try to get all unbound partialPopups for moduleID %1", (long)n);
        HMIBundle hMIBundle = AbstractWidget.hmiService.getHMIBundle(n * -1601830656);
        if (hMIBundle == null) {
            LOGPOPUPS.log(10000, "PartialPopupManager#getPartialPopupStubsForModule: No HMIBundle for moduleID %1 available", (long)n);
        } else {
            long l = this.framework.getMonotonicTime();
            IPartialPopupController[] iPartialPopupControllerArray = hMIBundle.getPartialPopupStubs(this.terminal.getTerminalID());
            long l2 = this.framework.getMonotonicTime();
            if (iPartialPopupControllerArray != null) {
                this.connectNewUnboundPartialPopups(iPartialPopupControllerArray);
            }
            if (LOGPERFORMANCE.isDebug()) {
                long l3 = this.framework.getMonotonicTime();
                LOGPERFORMANCE.log(-2137614336, "PartialPopupManager#getUnboundPopupsForModule getting partial popups from module %1 took %2ms, connecting new popups took %3ms", (long)n, l2 - l, l3 - l2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public int showPopup(int n) {
        Object object;
        int n2;
        IPartialPopupControllerEvo iPartialPopupControllerEvo;
        Integer n3;
        String string;
        block22: {
            string = this.getPopupName(n);
            if (!this.partialPopupsGloballyEnabled) {
                LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup popup with id %1 can not be shown because partial popups have been disabled globally", (Object)string);
                this.blockedPopups.add(Util.createInteger(n));
                return 2;
            }
            n3 = new Integer(n);
            if (!this.popups.containsKey(n3) && n != this.getPopupIdInvalid()) {
                int n4 = n / -1601830656;
                this.getPartialPopupStubsForModule(n4);
            }
            if (!this.popups.containsKey(n3)) {
                if (n == this.getPopupIdInvalid()) return 2;
                LOGPOPUPS.log(-1601830656, "PartialPopupManager#showPopup no popup with id %1 was registered", (Object)this.getPopupName(n3));
                return 3;
            }
            iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.popups.get(n3);
            if (this.checkIfPopupHasToBeBlocked(iPartialPopupControllerEvo)) {
                return 2;
            }
            LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup try to show popup with id %1, prio %2", (Object)string, (long)iPartialPopupControllerEvo.getPriority());
            if (this.currentConnectedScreen == null && this.terminal.getRootWindow().getCurrentScreen() == null) {
                if (!iPartialPopupControllerEvo.isFallbackScreenAllowed()) {
                    LOGPOPUPS.log(-1601830656, "PartialPopupManager#showPopup popup with id %1 shall be shown but fallback screen is not allowed", (Object)string);
                    return 2;
                }
                LOGPOPUPS.log(-1601830656, "PartialPopupManager#showPopup popup with id %1 shall be shown but no screen connected, try to show fallback screen", (Object)string);
                AbstractWidget.hmiService.showFallbackScreen(this.terminal.getTerminalID());
                if (this.currentConnectedScreen == null) {
                    LOGPOPUPS.log(1000, "PartialPopupManager#showPopup popup with id %1 shall cannot be shown because fallback screen could not be connected.", (Object)string);
                    return 2;
                }
            }
            if (this.waitingPopupsQueues[n2 = iPartialPopupControllerEvo.getSlot()].contains(iPartialPopupControllerEvo)) {
                iPartialPopupControllerEvo.restartAutoHideTimer();
                if (this.currentVisiblePopups[n2] != null && this.currentVisiblePopups[n2] != iPartialPopupControllerEvo && iPartialPopupControllerEvo.getPriority() == this.currentVisiblePopups[n2].getPriority() && this.waitingPopupsQueues[n2].contains(this.currentVisiblePopups[n2])) {
                    this.waitingPopupsQueues[n2].remove(iPartialPopupControllerEvo);
                    break block22;
                } else {
                    LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup popup with id %1 is already visible or in waiting queue", (Object)string);
                    return 1;
                }
            }
            if (this.currentAnimatingPopups[n2] != null && this.currentAnimatingPopups[n2] == iPartialPopupControllerEvo) {
                this.currentAnimatingPopups[n2] = null;
                LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup same popup is animating , removed doubled popup with id %1 ", (Object)string);
            }
        }
        int n5 = this.insertIntoWaitingPopupQueue(iPartialPopupControllerEvo, n2);
        if (n5 > 0) {
            LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup there are other popups in the waiting queue with higher prio, index in queue is %1 (popupID = %2)", (long)n5, (long)n);
            object = (IPartialPopupController)this.waitingPopupsQueues[n2].get(0);
            if (object != null) {
                LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup current highest prio popup in slot %1 has id: %2", (long)n2, (long)object.getID());
            } else {
                LOGPOPUPS.log(10000, "PartialPopupManager#showPopup popup with id: %1 has not highest prio, but no higher prio partial popup available", (long)n);
            }
        }
        if (!this.isPopupAllowedOnScreen(iPartialPopupControllerEvo)) {
            LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup there are full screen popups with higher prio, index in queue is %1 (popupID = %2)", (long)n5, (long)n);
            object = (ArrayList)this.partialPopupListenerList.get(n3);
            if (object == null) return 2;
            int n6 = ((ArrayList)object).size();
            int n7 = 0;
            while (n7 < n6) {
                IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)((ArrayList)object).get(n7);
                iPartialPopupListener.partialPopupHidden(iPartialPopupControllerEvo.getID(), this.terminal.getTerminalID());
                ++n7;
            }
            return 2;
        }
        if (this.isPopupSuppressedByOtherSlot(iPartialPopupControllerEvo)) {
            LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup  popup %1 in slot %2is not shown because popup in other slot suppresses popup", (long)n, (long)n2);
            object = (ArrayList)this.partialPopupListenerList.get(n3);
            if (object == null) return 2;
            int n8 = ((ArrayList)object).size();
            int n9 = 0;
            while (n9 < n8) {
                IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)((ArrayList)object).get(n9);
                iPartialPopupListener.partialPopupHidden(iPartialPopupControllerEvo.getID(), this.terminal.getTerminalID());
                ++n9;
            }
            return 2;
        }
        this.checkForSlotDependencies(n2, true);
        if (null == this.currentAnimatingPopups[n2] && null == this.currentVisiblePopups[n2] && 0 == n5) {
            iPartialPopupControllerEvo.activateBackgroundGrayOut();
            int n10 = this.doShowPopup(iPartialPopupControllerEvo, iPartialPopupControllerEvo.getStyle());
            if (n10 != 1) {
                this.waitingPopupsQueues[n2].remove(n5);
                LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup IPartialPopup.show() returned SHOW_ERROR -> the popup has not been shown (popupID = %1)", (Object)string);
            }
            if (n10 != 1) return 3;
            return 1;
        }
        if (n5 != 0) return 2;
        object = null;
        object = null != this.currentVisiblePopups[n2] ? this.currentVisiblePopups[n2] : this.currentAnimatingPopups[n2];
        if (LOGPOPUPS.isInfo()) {
            LOGPOPUPS.log(1078071040, "PartialPopupManager#showPopup popup with id %1 rules out popup with id %2", (Object)string, (Object)this.getPopupName(object.getID()));
        }
        int n11 = object.getStyle();
        if (iPartialPopupControllerEvo.getSlot() == 1 || iPartialPopupControllerEvo.getSlot() == 2) {
            n11 = 2;
        }
        iPartialPopupControllerEvo.deactivateBackgroundGrayOut();
        object.deactivateBackgroundGrayOut();
        this.doHidePopup((IPartialPopupControllerEvo)object, n11);
        return 1;
    }

    private boolean isPopupAllowedOnScreen(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        if (null == this.currentConnectedScreen || null == iPartialPopupControllerEvo) {
            return false;
        }
        if (iPartialPopupControllerEvo.getSlot() != 0 && iPartialPopupControllerEvo.getSlot() != 4 && iPartialPopupControllerEvo.getSlot() != 8 && iPartialPopupControllerEvo.getSlot() != 9 && iPartialPopupControllerEvo.getSlot() != 1 && iPartialPopupControllerEvo.getSlot() != 2 && iPartialPopupControllerEvo.getSlot() != 11) {
            return true;
        }
        int n = this.framework.getHMIService().getCurrentPopupPriority(this.terminal.getTerminalID());
        return iPartialPopupControllerEvo.getPriority() >= n && !this.currentConnectedScreen.isPartialPopupBlocked(iPartialPopupControllerEvo);
    }

    private boolean isPopupSuppressedByOtherSlot(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        return !(iPartialPopupControllerEvo.getSlot() != 1 && iPartialPopupControllerEvo.getSlot() != 2 || this.currentVisiblePopups[4] == null && this.currentAnimatingPopups[4] == null);
    }

    @Override
    public int hidePopupAndRepaintScreen(int n) {
        int n2 = this.hidePopup(n);
        IWidgetLogChannel.logRepaintCause.log(-2137614336, "PartialPopupManager#hidePopupAndRepaintScreen: do checked repaint. popup: %2, connected screen %1", (Object)this.currentConnectedScreen, (long)n);
        this.repaintScreen();
        return n2;
    }

    @Override
    public int hidePopup(int n) {
        return this.hidePopup(n, true);
    }

    @Override
    public int hidePopup(int n, boolean bl) {
        Integer n2 = new Integer(n);
        if (this.popups.containsKey(n2)) {
            IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.popups.get(n2);
            int n3 = iPartialPopupControllerEvo.getSlot();
            int n4 = this.waitingPopupsQueues[n3].indexOf(iPartialPopupControllerEvo);
            if (n4 != -1) {
                int n5;
                this.waitingPopupsQueues[n3].remove(n4);
                if (bl && (n5 = this.screenManager.removePartialPopupFromScreenData(this.currentConnectedScreen.getID(), n)) != 0) {
                    LOGPOPUPS.log(1078071040, "PartialPopupManager#hidePopup popup with id %1 has been removed from screendata", (Object)this.getPopupName(n));
                }
                this.blockedPopups.remove(Util.createInteger(iPartialPopupControllerEvo.getID()));
                n5 = iPartialPopupControllerEvo.getStyle();
                if ((iPartialPopupControllerEvo.getSlot() == 1 || iPartialPopupControllerEvo.getSlot() == 2) && this.waitingPopupsQueues[n3].size() > 0) {
                    n5 = 2;
                }
                if (LOGPOPUPS.isInfo()) {
                    LOGPOPUPS.log(1078071040, "PartialPopupManager#hidePopup try to hide popup with id %1", (Object)this.getPopupName(n));
                }
                if (this.waitingPopupsQueues[n3].size() <= 0) {
                    iPartialPopupControllerEvo.activateBackgroundGrayOut();
                }
                boolean bl2 = iPartialPopupControllerEvo.isVisible();
                this.doHidePopup(iPartialPopupControllerEvo, n5);
                if (!bl2) {
                    this.callbackPartialPopupRemoved(iPartialPopupControllerEvo.getID());
                }
                if (iPartialPopupControllerEvo.getStyle() != 1) {
                    iPartialPopupControllerEvo.activateBackgroundGrayOut();
                    if (this.lastShownPopup != null) {
                        this.lastShownPopup.activateBackgroundGrayOut();
                    }
                }
            }
        } else {
            LOGPOPUPS.log(10000, "PartialPopupManager#hidePopup no popup with id %1 was registered", (Object)this.getPopupName(n2));
            return 3;
        }
        return 2;
    }

    @Override
    public int popupVisible(int n) {
        Object object;
        LOGPOPUPS.log(-2137614336, "PartialPopupManager#popupVisible called with id: %1", (long)n);
        int n2 = 3;
        Integer n3 = new Integer(n);
        if (this.popups.containsKey(n3)) {
            int n4;
            object = (IPartialPopupControllerEvo)this.popups.get(n3);
            if (object == this.currentAnimatingPopups[n4 = object.getSlot()]) {
                this.currentAnimatingPopups[n4] = null;
            }
            if (this.currentVisiblePopups[n4] == null) {
                this.currentVisiblePopups[n4] = object;
                n2 = 1;
            } else if (this.currentVisiblePopups[n4] != object) {
                if (this.currentVisiblePopups[n4].getPriority() > object.getPriority()) {
                    this.doHidePopup((IPartialPopupControllerEvo)object, object.getStyle());
                    n2 = 2;
                } else {
                    IPartialPopupControllerEvo iPartialPopupControllerEvo = this.currentVisiblePopups[n4];
                    this.currentVisiblePopups[n4] = object;
                    this.doHidePopup(iPartialPopupControllerEvo, iPartialPopupControllerEvo.getStyle());
                    n2 = 1;
                }
            } else {
                n2 = 1;
            }
        } else if (n == this.getPopupIdStatusLine()) {
            n2 = 1;
        } else {
            LOGPOPUPS.log(10000, "PartialPopupManager#popupVisible no popup with id %1 was registered", (Object)this.getPopupName(n));
            n2 = 3;
        }
        if (n2 == 1) {
            object = (ArrayList)this.partialPopupListenerList.get(n3);
            LOGPOPUPS.log(-2137614336, "PartialPopupManager#popupVisible id: %2, listeners: %1", object, (long)n);
            if (object != null) {
                int n5 = ((ArrayList)object).size();
                for (int i2 = 0; i2 < n5; ++i2) {
                    IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)((ArrayList)object).get(i2);
                    iPartialPopupListener.partialPopupVisible(n, this.terminal.getTerminalID());
                }
            }
        }
        this.updatePPDebugInfo();
        if (n2 == 1) {
            this.partialPopupVisibilityChanged();
        }
        return n2;
    }

    private void partialPopupVisibilityChanged() {
        boolean bl = false;
        for (int i2 = 0; i2 < SLOTS.length; ++i2) {
            if (this.currentVisiblePopups[SLOTS[i2]] == null) continue;
            bl = true;
            break;
        }
        if (bl != this.atLeastOnePartialPopupVisible) {
            IDrawerFocusManagerEvo iDrawerFocusManagerEvo;
            this.atLeastOnePartialPopupVisible = bl;
            if (this.terminal != null && (iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager()) != null) {
                iDrawerFocusManagerEvo.atLeastOnePartialPopupVisible(bl);
            }
        }
    }

    @Override
    public int popupHidden(int n) {
        int n2;
        Object object;
        int n3 = 3;
        Integer n4 = new Integer(n);
        boolean bl = false;
        if (this.popups.containsKey(n4)) {
            object = (IPartialPopupControllerEvo)this.popups.get(n4);
            n2 = object.getSlot();
            boolean bl2 = bl = !this.waitingPopupsQueues[n2].contains(object);
            if (object == this.currentAnimatingPopups[n2]) {
                this.currentAnimatingPopups[n2] = null;
            }
            if (object == this.currentVisiblePopups[n2]) {
                this.currentVisiblePopups[n2] = null;
                if (this.waitingPopupsQueues[n2].size() > 0) {
                    IPartialPopupControllerEvo iPartialPopupControllerEvo;
                    this.lastShownPopup = iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[n2].get(0);
                    if (this.isPopupAllowedOnScreen(iPartialPopupControllerEvo) && !this.isPopupSuppressedByOtherSlot(iPartialPopupControllerEvo)) {
                        int n5;
                        if (LOGPOPUPS.isInfo()) {
                            LOGPOPUPS.log(1078071040, "PartialPopupManager#popupHidden popup with id %1 was hidden; try to show next popup in queue (id %2)", (Object)this.getPopupName(n), (Object)this.getPopupName(iPartialPopupControllerEvo.getID()));
                        }
                        int n6 = iPartialPopupControllerEvo.getStyle();
                        if (iPartialPopupControllerEvo.getSlot() == 1 || iPartialPopupControllerEvo.getSlot() == 2) {
                            n6 = 2;
                        }
                        if ((n5 = this.doShowPopup(iPartialPopupControllerEvo, n6)) != 1) {
                            if (LOGPOPUPS.isDebug()) {
                                LOGPOPUPS.log(-2137614336, "PartialPopupManager#popupHidden popup with id %1 could not be shown", (Object)this.getPopupName(iPartialPopupControllerEvo.getID()));
                            }
                            this.currentVisiblePopups[n2] = null;
                        }
                    } else if (LOGPOPUPS.isInfo()) {
                        if (this.isPopupSuppressedByOtherSlot(iPartialPopupControllerEvo)) {
                            LOGPOPUPS.log(1078071040, "PartialPopupManager#popupHidden popup with id %1 was hidden and shall not be shown directly again because it is suppressed by other popup in other slot", (Object)this.getPopupName(n), (Object)this.getPopupName(iPartialPopupControllerEvo.getID()));
                        } else {
                            LOGPOPUPS.log(1078071040, "PartialPopupManager#popupHidden popup with id %1 was hidden; the next popup in queue (id %2) has lower priority than the current full screen popup", (Object)this.getPopupName(n), (Object)this.getPopupName(iPartialPopupControllerEvo.getID()));
                        }
                    }
                } else {
                    this.checkForSlotDependencies(n2, false);
                }
            }
            n3 = 2;
        } else {
            LOGPOPUPS.log(-1601830656, "PartialPopupManager#popupHidden no popup with id %1 was registered", (Object)this.getPopupName(n));
            n3 = 3;
        }
        if (n3 == 2 && (object = (ArrayList)this.partialPopupListenerList.get(n4)) != null) {
            n2 = ((ArrayList)object).size();
            for (int i2 = 0; i2 < n2; ++i2) {
                IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)((ArrayList)object).get(i2);
                iPartialPopupListener.partialPopupHidden(n, this.terminal.getTerminalID());
                if (!bl) continue;
                iPartialPopupListener.partialPopupRemoved(n, this.terminal.getTerminalID());
            }
            IPartialPopupListener iPartialPopupListener = this.getActivatorListener((List)object);
            if (iPartialPopupListener != null) {
                ((AbstractCollection)object).remove(iPartialPopupListener);
            }
        }
        this.updatePPDebugInfo();
        if (n3 == 2) {
            this.partialPopupVisibilityChanged();
        }
        return n3;
    }

    private void checkForSlotDependencies(int n, boolean bl) {
        if (n == 4) {
            if (this.waitingPopupsQueues[1].size() > 0) {
                if (!bl) {
                    this.doShowPopup((IPartialPopupControllerEvo)this.waitingPopupsQueues[1].get(0), 1);
                } else {
                    this.doHidePopup((IPartialPopupControllerEvo)this.waitingPopupsQueues[1].get(0), 2);
                }
            }
            if (this.waitingPopupsQueues[2].size() > 0) {
                if (!bl) {
                    this.doShowPopup((IPartialPopupControllerEvo)this.waitingPopupsQueues[2].get(0), 1);
                } else {
                    this.doHidePopup((IPartialPopupControllerEvo)this.waitingPopupsQueues[2].get(0), 2);
                }
            }
        }
    }

    protected abstract IPartialPopupListener getActivatorListener(List list) {
    }

    private int replacePopupStub(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        Integer n = new Integer(iPartialPopupControllerEvo.getID());
        if (this.popups.containsKey(n)) {
            int n2;
            int n3;
            int n4;
            if (LOGPOPUPS.isDebug()) {
                LOGPOPUPS.log(-2137614336, "PartialPopupManager#replacePopupStub with id %1", (Object)this.getPopupName(n));
            }
            if ((n4 = iPartialPopupControllerEvo.getSlot()) < IPartialPopupManagerEvo.PARTIAL_POPUP_SLOT_DEPTHS.length) {
                n3 = IPartialPopupManagerEvo.PARTIAL_POPUP_SLOT_DEPTHS[n4];
            } else {
                LOGPOPUPS.log(10000, "PartialPopupManager#replacePopupStub with id %1, no depth defined for this slot (%2)", (Object)this.getPopupName(n), (long)n4);
                n3 = -1;
            }
            iPartialPopupControllerEvo.setDepth(n3);
            this.popups.put(n, iPartialPopupControllerEvo);
            if (this.currentVisiblePopups[n4] != null && this.currentVisiblePopups[n4].getID() == iPartialPopupControllerEvo.getID()) {
                this.currentVisiblePopups[n4] = iPartialPopupControllerEvo;
            }
            if (this.currentAnimatingPopups[n4] != null && this.currentAnimatingPopups[n4].getID() == iPartialPopupControllerEvo.getID()) {
                this.currentAnimatingPopups[n4] = iPartialPopupControllerEvo;
            }
            if ((n2 = this.waitingPopupsQueues[n4].size()) > 0) {
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (((IPartialPopupControllerEvo)this.waitingPopupsQueues[n4].get(i2)).getID() != iPartialPopupControllerEvo.getID()) continue;
                    this.waitingPopupsQueues[n4].remove(i2);
                    this.waitingPopupsQueues[n4].add(i2, iPartialPopupControllerEvo);
                    break;
                }
            }
            return 1;
        }
        LOGPOPUPS.log(1078071040, "PartialPopupManager#replacePopup no popup with id %1 can be replaced", (Object)this.getPopupName(n));
        return 2;
    }

    @Override
    public int registerPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        int n;
        int n2;
        Integer n3 = new Integer(iPartialPopupControllerEvo.getID());
        if (this.popups.containsKey(n3)) {
            if (this.popups.get(n3) instanceof IPartialPopupStub) {
                return this.replacePopupStub(iPartialPopupControllerEvo);
            }
            LOGPOPUPS.log(10000, "PartialPopupManager#registerPopup a popup with the same id (%1) was registered before and gets dismissed", (Object)this.getPopupName(n3));
            return 2;
        }
        if (LOGPOPUPS.isDebug()) {
            LOGPOPUPS.log(-2137614336, "PartialPopupManager#registerPopup with id %1", (Object)this.getPopupName(n3));
        }
        if ((n2 = iPartialPopupControllerEvo.getSlot()) < IPartialPopupManagerEvo.PARTIAL_POPUP_SLOT_DEPTHS.length) {
            n = IPartialPopupManagerEvo.PARTIAL_POPUP_SLOT_DEPTHS[n2];
        } else {
            LOGPOPUPS.log(10000, "PartialPopupManager#registerPopup with id %1, no depth defined for this slot (%2)", (Object)this.getPopupName(n3), (long)n2);
            n = -1;
        }
        iPartialPopupControllerEvo.setDepth(n);
        this.popups.put(n3, iPartialPopupControllerEvo);
        return 1;
    }

    @Override
    public int deregisterPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        Integer n = new Integer(iPartialPopupControllerEvo.getID());
        if (this.popups.containsKey(n)) {
            int n2 = iPartialPopupControllerEvo.getSlot();
            if (iPartialPopupControllerEvo == this.currentVisiblePopups[n2]) {
                this.hidePopup(iPartialPopupControllerEvo.getID(), false);
                if (iPartialPopupControllerEvo.getStyle() == 1) {
                    this.popupHidden(iPartialPopupControllerEvo.getID());
                }
            }
            if (LOGPOPUPS.isDebug()) {
                LOGPOPUPS.log(-2137614336, "PartialPopupManager#deregisterPopup with id %1", (Object)this.getPopupName(n));
            }
            this.popups.remove(n);
            int n3 = this.waitingPopupsQueues[n2].indexOf(iPartialPopupControllerEvo);
            if (n3 != -1) {
                this.waitingPopupsQueues[n2].remove(n3);
            }
            return 1;
        }
        LOGPOPUPS.log(-2137614336, "PartialPopupManager#deregisterPopup there is no popup registered with this id (%1)", (Object)this.getPopupName(n));
        return 2;
    }

    private void updateVolumePopupTimeout() {
        int n;
        if (this.currentConnectedScreen != null && (n = this.currentConnectedScreen.getScreenType()) != this.lastScreentype) {
            this.lastScreentype = n;
            IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.getPartialPopup(this.getPopupIdVolume());
            if (iPartialPopupControllerEvo != null) {
                if (n == 5) {
                    LOGPOPUPS.log(-2137614336, "PartialPopupManager#updateVolumePopupTimeout to %1 for RVC", (long)0);
                    iPartialPopupControllerEvo.setAutoHideTime(500);
                } else {
                    LOGPOPUPS.log(-2137614336, "PartialPopupManager#updateVolumePopupTimeout to %1", (long)0);
                    iPartialPopupControllerEvo.setAutoHideTime(3000);
                }
            }
        }
    }

    @Override
    public void oldScreenDisconnecting(Screen screen) {
        if (screen != null) {
            LOGPOPUPS.log(-2137614336, "PartialPopupManager#hideNotSurvivingPartialPopups screenID = %1", (long)screen.getID());
        }
        this.setUnboundPartialPopupsInvalid();
        for (int i2 = 0; i2 < this.waitingPopupsQueues.length; ++i2) {
            int n;
            for (int i3 = n = this.waitingPopupsQueues[i2].size() - 1; i3 >= 0; --i3) {
                IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[i2].get(i3);
                if (iPartialPopupControllerEvo.getType() == 7 && !iPartialPopupControllerEvo.survivesScreenChange() || this.checkIfPopupHasToBeBlocked(iPartialPopupControllerEvo)) {
                    this.hidePopup(iPartialPopupControllerEvo.getID());
                    continue;
                }
                if (0 != i3 || this.isPopupAllowedOnScreen(iPartialPopupControllerEvo) || iPartialPopupControllerEvo.getType() != 7 || iPartialPopupControllerEvo != this.currentAnimatingPopups[i2] && iPartialPopupControllerEvo != this.currentVisiblePopups[i2]) continue;
                this.doHidePopup(iPartialPopupControllerEvo, iPartialPopupControllerEvo.getStyle());
            }
        }
    }

    @Override
    public void newScreenConnected(Screen screen) {
        if (screen != null) {
            LOGPOPUPS.log(-2137614336, "PartialPopupManager#newScreenConnected screenID = %1", (long)screen.getID());
        }
        this.setUnboundPartialPopupsInvalid();
        this.currentConnectedScreen = screen;
        this.updateVolumePopupTimeout();
        for (int i2 = 0; i2 < this.waitingPopupsQueues.length; ++i2) {
            IPartialPopupControllerEvo iPartialPopupControllerEvo;
            int n = this.waitingPopupsQueues[i2].size() - 1;
            boolean bl = false;
            for (int i3 = n; i3 >= 0; --i3) {
                IPartialPopupControllerEvo iPartialPopupControllerEvo2 = (IPartialPopupControllerEvo)this.waitingPopupsQueues[i2].get(i3);
                if (iPartialPopupControllerEvo2.getType() == 7 && !iPartialPopupControllerEvo2.survivesScreenChange() || this.checkIfPopupHasToBeBlocked(iPartialPopupControllerEvo2)) {
                    bl = true;
                    this.hidePopup(iPartialPopupControllerEvo2.getID());
                    continue;
                }
                if (0 != i3 || this.isPopupAllowedOnScreen(iPartialPopupControllerEvo2) || iPartialPopupControllerEvo2.getType() != 7 || iPartialPopupControllerEvo2 != this.currentAnimatingPopups[i2] && iPartialPopupControllerEvo2 != this.currentVisiblePopups[i2]) continue;
                bl = true;
                this.doHidePopup(iPartialPopupControllerEvo2, iPartialPopupControllerEvo2.getStyle());
            }
            if (bl || 0 >= this.waitingPopupsQueues[i2].size() || !this.isPopupAllowedOnScreen(iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[i2].get(0)) || this.currentAnimatingPopups[i2] == iPartialPopupControllerEvo || this.currentVisiblePopups[i2] == iPartialPopupControllerEvo) continue;
            this.doShowPopup(iPartialPopupControllerEvo, iPartialPopupControllerEvo.getStyle());
        }
        if (!(!this.partialPopupsGloballyEnabled || this.currentConnectedScreen == null || this.allPartialPopupsAllowedByScreen && this.currentConnectedScreen.areAllPartialPopupsAllowed())) {
            this.allPartialPopupsAllowedByScreen = this.currentConnectedScreen.areAllPartialPopupsAllowed();
            this.executePopupsAllowance(true);
        }
    }

    @Override
    public void hideAllPopupsAndRepaintScreen(int n) {
        int n2;
        for (int i2 = n2 = this.waitingPopupsQueues[n].size() - 1; i2 >= 0; --i2) {
            IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[n].get(i2);
            this.hidePopup(iPartialPopupControllerEvo.getID());
        }
        IWidgetLogChannel.logRepaintCause.log(-2137614336, "PartialPopupManager#hideAllPopupsAndRepaintScreen: do checked repaint. slot: %2, connected screen %1", (Object)this.currentConnectedScreen, (long)n);
        this.repaintScreen();
    }

    protected abstract void repaintScreen() {
    }

    @Override
    public IPartialPopupController getCurrentVisiblePopup(int n) {
        return this.currentVisiblePopups[n];
    }

    @Override
    public void hideNotScreenChangeSurvivingPopups() {
        for (int i2 = 0; i2 < this.waitingPopupsQueues.length; ++i2) {
            int n;
            for (int i3 = n = this.waitingPopupsQueues[i2].size() - 1; i3 >= 0; --i3) {
                IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[i2].get(i3);
                if ((iPartialPopupControllerEvo.getType() != 8 || iPartialPopupControllerEvo.survivesScreenChange()) && !this.checkIfPopupHasToBeBlocked(iPartialPopupControllerEvo)) continue;
                this.hidePopup(iPartialPopupControllerEvo.getID());
            }
        }
    }

    private void callbackPartialPopupRemoved(int n) {
        Integer n2 = new Integer(n);
        ArrayList arrayList = (ArrayList)this.partialPopupListenerList.get(n2);
        if (arrayList != null) {
            int n3 = arrayList.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)arrayList.get(i2);
                iPartialPopupListener.partialPopupRemoved(n, this.terminal.getTerminalID());
            }
            IPartialPopupListener iPartialPopupListener = this.getActivatorListener(arrayList);
            if (iPartialPopupListener != null) {
                arrayList.remove(iPartialPopupListener);
            }
        }
    }

    private boolean propagateModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent == null) {
            LOGPOPUPS.log(10000, "PartialPopupManager#propagateModelUpdateEvent modelUpdateEvent is: %1", (Object)modelUpdateEvent);
            return false;
        }
        if (this.popups.isEmpty()) {
            LOGPOPUPS.log(-2137614336, "PartialPopupManager#propagateModelUpdateEvent modelUpdateEvent is: %1; no popups registered at the moment", (Object)modelUpdateEvent);
            return false;
        }
        boolean bl = false;
        boolean bl2 = modelUpdateEvent.getModelType() == 100;
        ArrayList arrayList = new ArrayList(this.popups.values());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)iterator.next();
            if (iPartialPopupControllerEvo.getType() != 7) continue;
            if (bl2) {
                ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
                for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
                    bl |= iPartialPopupControllerEvo.processModelUpdateEventWithBoolean(modelUpdateEventArray[i2]);
                }
                continue;
            }
            bl |= iPartialPopupControllerEvo.processModelUpdateEventWithBoolean(modelUpdateEvent);
        }
        return bl;
    }

    @Override
    public boolean processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        return this.propagateModelUpdateEvent(modelUpdateEvent);
    }

    private void paintUnboundPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        RedrawContext redrawContext = this.terminal.getRedrawContext();
        ((AbstractWidget)((Object)iPartialPopupControllerEvo)).managePaint(redrawContext);
    }

    @Override
    public void paintUnboundPopups() {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] != null && this.currentVisiblePopups[n].getType() == 7) {
                this.paintUnboundPopup(this.currentVisiblePopups[n]);
            }
            if (null == this.currentAnimatingPopups[n] || this.currentAnimatingPopups[n].getType() != 7) continue;
            this.paintUnboundPopup(this.currentAnimatingPopups[n]);
        }
    }

    public void setUnboundPartialPopupsInvalid() {
        for (int i2 = 0; i2 < this.waitingPopupsQueues.length; ++i2) {
            if (this.currentVisiblePopups[i2] != null && this.currentVisiblePopups[i2].getType() == 7) {
                this.currentVisiblePopups[i2].makeSubtreeDirty();
            }
            if (this.currentAnimatingPopups[i2] == null || this.currentAnimatingPopups[i2].getType() != 7) continue;
            this.currentAnimatingPopups[i2].makeSubtreeDirty();
        }
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            if (!this.shouldReceiveKeyEvents(this.sortedSlots[i2])) continue;
            IPartialPopupControllerEvo iPartialPopupControllerEvo = this.currentVisiblePopups[this.sortedSlots[i2]];
            if (this.focusedLayer != -1 && iPartialPopupControllerEvo.getlayer() != this.focusedLayer && !this.checkForPopupDrawer(iPartialPopupControllerEvo)) continue;
            iPartialPopupControllerEvo.setFocusedLayer(this.focusedLayer);
            iPartialPopupControllerEvo.keyMoved(joystickEvent);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            if (!this.shouldReceiveKeyEvents(this.sortedSlots[i2])) continue;
            IPartialPopupControllerEvo iPartialPopupControllerEvo = this.currentVisiblePopups[this.sortedSlots[i2]];
            int n = iPartialPopupControllerEvo.getlayer();
            if (this.focusedLayer != -1 && n != this.focusedLayer && !this.checkForPopupDrawer(iPartialPopupControllerEvo)) continue;
            iPartialPopupControllerEvo.setFocusedLayer(this.focusedLayer);
            iPartialPopupControllerEvo.keyPressed(keyEvent);
        }
    }

    private boolean shouldReceiveKeyEvents(int n) {
        IPartialPopupControllerEvo iPartialPopupControllerEvo = this.currentVisiblePopups[n];
        return iPartialPopupControllerEvo != null && this.waitingPopupsQueues[n].contains(iPartialPopupControllerEvo);
    }

    private boolean checkForPopupDrawer(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        if (this.focusedLayer != 2) {
            return false;
        }
        return iPartialPopupControllerEvo.hasPopupDrawer();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            if (!this.shouldReceiveKeyEvents(this.sortedSlots[i2])) continue;
            IPartialPopupControllerEvo iPartialPopupControllerEvo = this.currentVisiblePopups[this.sortedSlots[i2]];
            if (this.focusedLayer != -1 && iPartialPopupControllerEvo.getlayer() != this.focusedLayer && !this.checkForPopupDrawer(iPartialPopupControllerEvo)) continue;
            iPartialPopupControllerEvo.setFocusedLayer(this.focusedLayer);
            iPartialPopupControllerEvo.keyReleased(keyEvent);
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            if (!this.shouldReceiveKeyEvents(this.sortedSlots[i2])) continue;
            IPartialPopupControllerEvo iPartialPopupControllerEvo = this.currentVisiblePopups[this.sortedSlots[i2]];
            if (this.focusedLayer != -1 && iPartialPopupControllerEvo.getlayer() != this.focusedLayer && !this.checkForPopupDrawer(iPartialPopupControllerEvo)) continue;
            iPartialPopupControllerEvo.setFocusedLayer(this.focusedLayer);
            iPartialPopupControllerEvo.keyTurned(wheelButtonEvent);
        }
    }

    @Override
    public void processSDSEvent(SDSEvent sDSEvent) {
    }

    @Override
    public String[] getRegisteredPopupsDebugOutput() {
        String[] stringArray;
        if (this.popups.isEmpty()) {
            stringArray = new String[]{"  no popups registered"};
        } else {
            stringArray = new String[this.popups.size()];
            int n = 0;
            Buffer buffer = new Buffer();
            Iterator iterator = this.popups.keySet().iterator();
            while (iterator.hasNext()) {
                Integer n2 = (Integer)iterator.next();
                IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.popups.get(n2);
                buffer.clear();
                buffer.append("  ID = ");
                buffer.append(this.getPopupName(n2));
                buffer.append("\n");
                buffer.append("    priority = ");
                buffer.append(iPartialPopupControllerEvo.getPriority());
                buffer.append("\n");
                if (iPartialPopupControllerEvo.getType() == 7) {
                    buffer.append("    type = unbound\n");
                } else {
                    buffer.append("    type = bound\n");
                }
                String string = super.getClass().getName();
                int n3 = string.lastIndexOf(".") + 1;
                buffer.append(new StringBuffer().append("    widget = ").append(string.substring(n3)).toString());
                stringArray[n] = new String(buffer.toString());
                ++n;
            }
        }
        return stringArray;
    }

    @Override
    public String[] getVisiblePopupsDebugOutput() {
        String[] stringArray = new String[this.currentVisiblePopups.length];
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.currentVisiblePopups.length; ++i2) {
            stringArray[i2] = new StringBuffer().append("slot ").append(i2).append(": ").toString();
            if (this.currentVisiblePopups[i2] == null) continue;
            buffer.clear();
            buffer.append("ID = ");
            buffer.append(this.getPopupName(this.currentVisiblePopups[i2].getID()));
            buffer.append("; priority = ");
            buffer.append(this.currentVisiblePopups[i2].getPriority());
            if (this.currentVisiblePopups[i2].getType() == 7) {
                buffer.append("; type = unbound");
            } else {
                buffer.append("; type = bound");
            }
            String string = super.getClass().getName();
            int n = string.lastIndexOf(".") + 1;
            buffer.append(new StringBuffer().append("; widget = ").append(string.substring(n)).toString());
            int n2 = i2;
            stringArray[n2] = new StringBuffer().append(stringArray[n2]).append(new String(buffer.toString())).toString();
        }
        return stringArray;
    }

    @Override
    public IPartialPopupController getPartialPopup(int n) {
        IPartialPopupController iPartialPopupController = (IPartialPopupController)this.popups.get(new Integer(n));
        if (iPartialPopupController instanceof IPartialPopupStub) {
            return ((IPartialPopupStub)((Object)iPartialPopupController)).getSkeleton();
        }
        return iPartialPopupController;
    }

    @Override
    public void setPopupOpacity(float f2) {
        for (int i2 = 0; i2 < this.waitingPopupsQueues.length; ++i2) {
            if (this.currentVisiblePopups[i2] == null || this.currentVisiblePopups[i2].getType() != 8 && this.currentVisiblePopups[i2].survivesScreenChange()) continue;
            this.currentVisiblePopups[i2].setOpacity(f2);
        }
    }

    @Override
    public void setPartialPopupsEnabled(boolean bl) {
        LOGPOPUPS.log(1078071040, "PartialPopupManager#setPartialPopupsEnabled( %1 ), terminal = %2", bl, (long)this.terminal.getTerminalID());
        if (this.partialPopupsGloballyEnabled == bl) {
            return;
        }
        this.partialPopupsGloballyEnabled = bl;
        this.executePopupsAllowance(false);
    }

    protected void executePopupsAllowance(boolean bl) {
        if (this.partialPopupsGloballyEnabled) {
            Iterator iterator = bl ? this.popups.values().iterator() : this.blockedPopups.iterator();
            while (iterator.hasNext()) {
                IPartialPopupControllerEvo iPartialPopupControllerEvo = bl ? (IPartialPopupControllerEvo)iterator.next() : (IPartialPopupControllerEvo)this.popups.get((Integer)iterator.next());
                if (iPartialPopupControllerEvo == null || iPartialPopupControllerEvo.getType() != 7 || this.currentConnectedScreen.isPartialPopupBlocked(iPartialPopupControllerEvo) || !this.shouldCheckModelStatusOnExecutePopupAllowance(iPartialPopupControllerEvo.getID())) continue;
                iPartialPopupControllerEvo.checkModelStatusAndInformPopupManager();
            }
            if (!bl) {
                this.blockedPopups.clear();
            }
        } else {
            for (int i2 = 0; i2 < this.waitingPopupsQueues.length; ++i2) {
                int n;
                for (int i3 = n = this.waitingPopupsQueues[i2].size() - 1; i3 >= 0; --i3) {
                    IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[i2].get(i3);
                    this.hidePopup(iPartialPopupControllerEvo.getID());
                    this.blockedPopups.add(Util.createInteger(iPartialPopupControllerEvo.getID()));
                }
            }
        }
        if (this.currentConnectedScreen != null && AbstractWidget.hmiService.getEventDispatcher().isDispatchThread()) {
            IWidgetLogChannel.logRepaintCause.log(-2137614336, "PartialPopupManager#executePopupsAllowance: trigger repaint. current screen: %1", (Object)this.currentConnectedScreen);
            ((AbstractWidget)((Object)this.currentConnectedScreen)).triggerRepaint();
        } else {
            LOGPOPUPS.log(10000, "PartialPopupManager#executePopupsAllowance currentConnectedScreen is null (has not been set correctly)");
        }
    }

    @Override
    public void checkPriosAgainstFullScreenPopup() {
        for (int i2 = 0; i2 < this.waitingPopupsQueues.length; ++i2) {
            if (0 >= this.waitingPopupsQueues[i2].size()) continue;
            IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.waitingPopupsQueues[i2].get(0);
            if (this.isPopupAllowedOnScreen(iPartialPopupControllerEvo) && this.partialPopupsGloballyEnabled) {
                if (this.currentAnimatingPopups[i2] == iPartialPopupControllerEvo || this.currentVisiblePopups[i2] == iPartialPopupControllerEvo) continue;
                this.doShowPopup(iPartialPopupControllerEvo, iPartialPopupControllerEvo.getStyle());
                continue;
            }
            if (this.currentAnimatingPopups[i2] != iPartialPopupControllerEvo && this.currentVisiblePopups[i2] != iPartialPopupControllerEvo) continue;
            this.doHidePopup(iPartialPopupControllerEvo, iPartialPopupControllerEvo.getStyle());
        }
    }

    protected abstract boolean shouldCheckModelStatusOnExecutePopupAllowance(int n) {
    }

    @Override
    public void setLanguage(Language language) {
        if (this.framework != null) {
            LanguageChangedEvent languageChangedEvent = new LanguageChangedEvent(language, new ATIPEventListener[]{this.framework.getHMIService().getRootWindow(this.terminal.getTerminalID())});
            this.eventDispatcher.postEvent(languageChangedEvent);
        }
    }

    @Override
    public void processLanguageChangedEvent(LanguageChangedEvent languageChangedEvent) {
        IPartialPopupControllerEvo iPartialPopupControllerEvo;
        LinkedList linkedList = new LinkedList();
        Iterator iterator = this.popups.values().iterator();
        while (iterator.hasNext()) {
            iPartialPopupControllerEvo = (IPartialPopupControllerEvo)iterator.next();
            if (iPartialPopupControllerEvo == null || iPartialPopupControllerEvo.getType() != 7) continue;
            linkedList.add(iPartialPopupControllerEvo);
        }
        Iterator iterator2 = linkedList.iterator();
        while (iterator2.hasNext()) {
            iPartialPopupControllerEvo = (IPartialPopupControllerEvo)iterator2.next();
            ((IScreenEvo)((Object)iPartialPopupControllerEvo)).predisconnecting();
            ((IScreenEvo)((Object)iPartialPopupControllerEvo)).disconnecting();
            iPartialPopupControllerEvo.connected(false, false);
            if (iPartialPopupControllerEvo.getID() != this.getPopupIdStatusLine()) continue;
            this.showPopup(this.getPopupIdStatusLine());
        }
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null || this.focusedLayer != -1 && this.currentVisiblePopups[n].getlayer() != this.focusedLayer) continue;
            this.currentVisiblePopups[n].setFocusedLayer(this.focusedLayer);
            this.currentVisiblePopups[n].touchPadAbandoned(touchEvent);
        }
    }

    @Override
    public void touchPadPalmRecognized(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null || this.focusedLayer != -1 && this.currentVisiblePopups[n].getlayer() != this.focusedLayer) continue;
            this.currentVisiblePopups[n].setFocusedLayer(this.focusedLayer);
            this.currentVisiblePopups[n].touchPadPalmRecognized(touchEvent);
        }
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null || this.focusedLayer != -1 && this.currentVisiblePopups[n].getlayer() != this.focusedLayer) continue;
            this.currentVisiblePopups[n].setFocusedLayer(this.focusedLayer);
            this.currentVisiblePopups[n].touchPadApproached(touchEvent);
        }
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null || this.focusedLayer != -1 && this.currentVisiblePopups[n].getlayer() != this.focusedLayer) continue;
            this.currentVisiblePopups[n].setFocusedLayer(this.focusedLayer);
            this.currentVisiblePopups[n].touchPadCharactersRecognized(touchEvent);
        }
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null || this.focusedLayer != -1 && this.currentVisiblePopups[n].getlayer() != this.focusedLayer) continue;
            this.currentVisiblePopups[n].setFocusedLayer(this.focusedLayer);
            this.currentVisiblePopups[n].touchPadPositionMoved(touchEvent);
        }
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null || this.focusedLayer != -1 && this.currentVisiblePopups[n].getlayer() != this.focusedLayer) continue;
            this.currentVisiblePopups[n].setFocusedLayer(this.focusedLayer);
            this.currentVisiblePopups[n].touchPadPressed(touchEvent);
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null || this.focusedLayer != -1 && this.currentVisiblePopups[n].getlayer() != this.focusedLayer) continue;
            this.currentVisiblePopups[n].setFocusedLayer(this.focusedLayer);
            this.currentVisiblePopups[n].touchPadReleased(touchEvent);
        }
    }

    @Override
    public boolean hasVisiblePopupInSlot(int n) {
        if (this.currentVisiblePopups == null) {
            LOGPOPUPS.log(10000, "PartialPopUpManager#hasVisiblePopUps PartialPopUpManager was not initialized");
            return false;
        }
        return this.currentVisiblePopups[n] != null;
    }

    @Override
    public int getEventID(int n) {
        int n2 = -1;
        if (this.currentVisiblePopups != null) {
            for (int i2 = 0; i2 < this.currentVisiblePopups.length && n2 == -1; ++i2) {
                if (!(this.currentVisiblePopups[i2] instanceof Screen) || this.currentVisiblePopups[i2].getType() != 7) continue;
                n2 = ((Screen)((Object)this.currentVisiblePopups[i2])).getEventID(n);
            }
        }
        return n2;
    }

    public void connectNewUnboundPartialPopups(IPartialPopupController[] iPartialPopupControllerArray) {
        for (int i2 = 0; i2 < iPartialPopupControllerArray.length; ++i2) {
            Screen screen = (Screen)((Object)iPartialPopupControllerArray[i2]);
            if (this.popups.containsKey(new Integer(screen.getID()))) continue;
            this.connectingService.modifiyModelReference(screen, true, true);
            screen.setTerminal(this.terminal);
            ScreenData screenData = new ScreenData(true);
            screen.connected(screenData);
        }
    }

    protected abstract int getPopupIdStatusLine() {
    }

    protected abstract int getPopupIdVolume() {
    }

    protected abstract int getPopupIdInvalid() {
    }

    @Override
    public void triggerGestureEvent(GestureEvent gestureEvent) {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            int n = this.sortedSlots[i2];
            if (this.currentVisiblePopups[n] == null) continue;
            gestureEvent.consume();
            break;
        }
    }

    @Override
    public void setFocusedLayer(int n) {
        this.focusedLayer = n;
    }

    public void closePopupDrawer() {
        for (int i2 = 0; i2 < this.sortedSlots.length; ++i2) {
            IPartialPopupControllerEvo iPartialPopupControllerEvo = this.currentVisiblePopups[this.sortedSlots[i2]];
            if (iPartialPopupControllerEvo == null) continue;
            iPartialPopupControllerEvo.closePopupDrawer();
        }
    }

    @Override
    public void setPartialPopupCoordinates(int n, int n2, int n3, int n4, int n5) {
        Integer n6 = new Integer(n);
        if (this.popups.containsKey(n6)) {
            IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)this.popups.get(n6);
            ArrayList arrayList = (ArrayList)this.partialPopupListenerList.get(n6);
            LOGPOPUPS.log(1078071040, new StringBuffer().append("PartialPopupManager#popupFullyVisible id: %2, listeners: %1, x: ").append(n2).append(", y: ").append(n3).append(", width: ").append(n4).append(", height: ").append(n5).toString(), (Object)arrayList, (long)n);
            if (arrayList != null) {
                int n7 = arrayList.size();
                for (int i2 = 0; i2 < n7; ++i2) {
                    IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)arrayList.get(i2);
                    iPartialPopupListener.informAboutPPCoordinates(n, this.terminal.getTerminalID(), iPartialPopupControllerEvo.getX(), iPartialPopupControllerEvo.getY(), iPartialPopupControllerEvo.getWidth(), iPartialPopupControllerEvo.getHeight());
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ Map access$100(AbstractPartialPopupManager abstractPartialPopupManager) {
        return abstractPartialPopupManager.partialPopupListenerList;
    }

    static {
        SLOTS = new int[]{0, 1, 2, 4, 6, 7, 8, 9, 11, 12, 13};
        LOGPOPUPS = IWidgetLogChannel.logChannelPopups;
        LOGPERFORMANCE = IWidgetLogChannel.logWidgetPerformance;
    }
}

