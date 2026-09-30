/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IDrawerManager;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.high.ap.EntertainmentActionProxyRouter;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DrawerManagerEvoHigh
implements IDrawerManager,
IWidgetLogChannel,
EntertainmentActionProxy,
WidgetConstants {
    private IModelConnectService connectingService;
    private BundleContext bundleContext;
    protected HMITerminalImpl terminal;
    protected Map selectionDrawers = new HashMap();
    protected Map optionDrawers = new HashMap();
    private EntertainmentDrawerController entertainmentDrawer;
    protected List entertainmentDrawerContent = new ArrayList(10);
    protected AbstractWidgetController activeEntertainmentContent;
    protected IDrawerFocusManagerEvo drawerFocusManager;
    protected IDrawerConditionEngine drawerConditionEngine;
    private Object connectMonitor = new Object();
    private ArrayList adclList = new ArrayList();
    private AudioDrawerContext.Source currentSource;
    private int currentEntDrawerState;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIBundle;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener;

    public DrawerManagerEvoHigh(HMITerminalImpl hMITerminalImpl, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this.terminal = hMITerminalImpl;
        this.bundleContext = bundleContext;
        this.connectingService = iFrameworkAccess.getHMIService().getModelConnectService(hMITerminalImpl.getTerminalID());
        this.drawerFocusManager = hMITerminalImpl.getDrawerFocusManager();
        this.drawerConditionEngine = hMITerminalImpl.getDrawerConditionEngine();
        EntertainmentActionProxyRouter.getInstance().registerHandler(this);
    }

    public void activateSelectionDrawer(long l) {
        Object object;
        Long l2 = Util.createLong(l);
        if (l != -1L && !this.selectionDrawers.containsKey(l2) && (object = AbstractWidget.hmiService.getSelectionDrawers(this.terminal.getTerminalID(), (int)l / 100000)) != null) {
            int n;
            boolean bl = false;
            for (n = 0; n < ((Object)object).length; ++n) {
                if ((long)object[n].getID() != l) continue;
                bl = true;
            }
            if (bl) {
                for (n = 0; n < ((Object)object).length; ++n) {
                    this.selectionDrawers.put(Util.createLong(object[n].getID()), object[n]);
                    object[n].setDrawerType(1);
                }
            } else {
                logDrawer.log(10000000, "DrawerManagerEvoHigh#activateSelectionDrawer: no selection drawer found for id %1", l);
            }
        }
        if (l != -1L && this.selectionDrawers.containsKey(l2)) {
            object = (DrawerController)this.selectionDrawers.get(l2);
            if (!((DrawerController)object).isConnected()) {
                this.connectDrawer((DrawerController)object);
            }
            this.drawerFocusManager.setSelectionDrawer(object);
        } else {
            logDrawer.log(10000000, "DrawerManagerEvoHigh#activateSelectionDrawer: no selection drawer available for id %1", l);
            this.drawerFocusManager.setSelectionDrawer(null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void connectDrawer(DrawerController drawerController, boolean bl) {
        Object object = this.connectMonitor;
        synchronized (object) {
            this.connectingService.modifiyModelReference(drawerController, true, true);
            drawerController.setTerminal(this.terminal);
            if (bl) {
                try {
                    drawerController.connected(new ScreenData(true));
                    drawerController.setConnected(true);
                }
                catch (RuntimeException runtimeException) {
                    int n = drawerController.getScreenId();
                    logChannel.log(10000, "DrawerManagerEvoHigh#connectDrawer error ocurred in drawer with ID %1 (%2)", (Object)Util.createInteger(n), (Object)this.terminal.getScreenName(n));
                    throw runtimeException;
                }
            }
        }
    }

    public void connectDrawer(DrawerController drawerController) {
        this.connectDrawer(drawerController, true);
    }

    public void activateOptionDrawer(long l, long[] lArray) {
        IDrawerControllerEvo[] iDrawerControllerEvoArray;
        LogChannel logChannel = IWidgetLogChannel.logDrawerCondtionEngine;
        logChannel.log(10000000, "activateOptionDrawer id: %1", l);
        if (lArray != null) {
            for (int i2 = 0; i2 < lArray.length; ++i2) {
                logChannel.log(10000000, "activateOptionDrawer next valid context: %1", lArray[i2]);
            }
        }
        Long l2 = Util.createLong(l);
        if (l != -1L && !this.optionDrawers.containsKey(l2) && (iDrawerControllerEvoArray = AbstractWidget.hmiService.getOptionDrawers(this.terminal.getTerminalID(), (int)l / 100000)) != null) {
            int n;
            boolean bl = false;
            for (n = 0; n < iDrawerControllerEvoArray.length; ++n) {
                if ((long)iDrawerControllerEvoArray[n].getID() != l) continue;
                bl = true;
            }
            if (bl) {
                for (n = 0; n < iDrawerControllerEvoArray.length; ++n) {
                    this.optionDrawers.put(Util.createLong(iDrawerControllerEvoArray[n].getID()), iDrawerControllerEvoArray[n]);
                    iDrawerControllerEvoArray[n].setDrawerType(2);
                }
            }
        }
        iDrawerControllerEvoArray = (IDrawerControllerEvo[])this.drawerFocusManager.getOptionDrawer();
        Comparable comparable = ((DrawerFocusManager)this.drawerFocusManager).getFocusedIndexOfDrawer((DrawerController)iDrawerControllerEvoArray);
        if (l != -1L && this.optionDrawers.containsKey(l2)) {
            DrawerController drawerController = (DrawerController)this.optionDrawers.get(l2);
            this.drawerConditionEngine.activateDrawer(drawerController, lArray);
            if (!drawerController.isConnected()) {
                this.connectDrawer(drawerController);
            }
            this.drawerFocusManager.setOptionDrawer(drawerController, comparable);
        } else {
            this.drawerFocusManager.setOptionDrawer(null, comparable);
            this.drawerConditionEngine.activateDrawer(null, lArray);
        }
    }

    public int getBlackListedConnection() {
        return EntertainmentActionProxyRouter.getInstance().getBlackListedConnection();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activateEntertainmentDrawer() {
        Object object = this.connectMonitor;
        synchronized (object) {
            if (this.entertainmentDrawer != null && !this.entertainmentDrawer.isConnected()) {
                this.connectDrawer(this.entertainmentDrawer);
                this.entertainmentDrawer.setDrawerType(3);
                this.entertainmentDrawer.setDisplayDrawerState(1, false, true);
                this.drawerFocusManager.setEntertainmentDrawer(this.entertainmentDrawer);
            }
        }
    }

    public void activateEntertainmentDrawerContent(AbstractWidgetController abstractWidgetController) {
        if (Util.equals(abstractWidgetController, this.activeEntertainmentContent)) {
            return;
        }
        if (this.activeEntertainmentContent instanceof Screen) {
            logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#activateEntertainmentDrawerContent: deactivate content: %1", (Object)this.activeEntertainmentContent);
            this.connectingService.modifiyModelReference((Screen)((Object)this.activeEntertainmentContent), false, true);
        } else if (this.activeEntertainmentContent != null) {
            logEntertainmentDrawer.log(100000, "DrawerManagerEvoHigh#activateEntertainmentDrawerContent: old content is no Screen: %1", (Object)this.activeEntertainmentContent);
        }
        this.activeEntertainmentContent = abstractWidgetController;
        if (this.activeEntertainmentContent instanceof Screen) {
            logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#activateEntertainmentDrawerContent: activate content: %1", (Object)this.activeEntertainmentContent);
            this.connectDrawer((DrawerController)this.activeEntertainmentContent, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AbstractWidgetController getNewEntertainmentContent(int n) {
        Object object = this.connectMonitor;
        synchronized (object) {
            Iterator iterator = this.entertainmentDrawerContent.iterator();
            while (iterator.hasNext()) {
                EntertainmentDrawerContentController entertainmentDrawerContentController = (EntertainmentDrawerContentController)iterator.next();
                if (entertainmentDrawerContentController == null || entertainmentDrawerContentController.getAudioSource() != n) continue;
                return entertainmentDrawerContentController;
            }
        }
        if (n == 9999) {
            logEntertainmentDrawer.log(10000, "DrawerManagerEvoHigh#getNewEntertainmentContent: default content could not be fetched");
            return null;
        }
        logEntertainmentDrawer.log(100000, "DrawerManagerEvoHigh#getNewEntertainmentContent: audioSource %1 could not be found, trying to fetch default content", (long)n);
        return this.getNewEntertainmentContent(9999);
    }

    private void onNewContentAvalabilityChangedAsync() {
        this.terminal.getFramework().getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                Object object = DrawerManagerEvoHigh.this.connectMonitor;
                synchronized (object) {
                    IWidgetLogChannel.logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#onNewContentAvalabilityChangedAsync: called");
                    DrawerManagerEvoHigh.this.onNewContentAvalabilityChanged();
                }
            }
        }));
    }

    public void startTrackingServices() {
        if (!AbstractWidget.isScreenResolution1440()) {
            this.initializeDrawerTracker();
            this.initializeADCLDrawerTracker();
        }
    }

    public void entertainmentBlacklist(int n, int n2) {
        logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#entertainmentBlacklist: ENTER terminalID=%1 Blacklist=%2", (long)n, (long)n2);
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = this.getEntertainmentDrawerOpenCloseController();
        if (entertainmentDrawerOpenCloseController != null) {
            entertainmentDrawerOpenCloseController.onBlacklistAudioSource(n, n2);
        }
        logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#entertainmentBlacklist: EXIT");
    }

    public void entertainmentSetVisible(int n, boolean bl) {
        Object object;
        if (logEntertainmentDrawer.isDebug()) {
            object = new Buffer();
            ((Buffer)object).append("DrawerManagerEvoHigh#entertainmentSetVisible ENTER terminalID=").append(n).append("  visible=").append(bl);
            logEntertainmentDrawer.log(10000000, ((Buffer)object).toString());
        }
        if ((object = this.getEntertainmentDrawerOpenCloseController()) != null) {
            ((EntertainmentDrawerOpenCloseController)object).onDrawerVisibiltyChange(bl);
        }
        logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#entertainmentSetVisible: EXIT");
    }

    public void onNewContentAvalabilityChanged() {
        logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#onNewContentAvalabilityChanged: ENTER");
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = this.getEntertainmentDrawerOpenCloseController();
        if (entertainmentDrawerOpenCloseController != null && entertainmentDrawerOpenCloseController.isConnected()) {
            entertainmentDrawerOpenCloseController.onNewContentAvalabilityChanged();
        }
        logEntertainmentDrawer.log(10000000, "DrawerManagerEvoHigh#onNewContentAvalabilityChanged: EXIT");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyADCListeners(int n, int n2) {
        Object object = this.connectMonitor;
        synchronized (object) {
            AudioDrawerContext.Source source = this.contentID2SourceMapper(n);
            if (!Util.equals(this.currentSource, source) || this.currentEntDrawerState != n2) {
                this.currentSource = source;
                this.currentEntDrawerState = n2;
                this.internalNotifyADCListeners();
            }
        }
    }

    private void initializeDrawerTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$hmi$HMIBundle == null ? (class$de$audi$atip$hmi$HMIBundle = DrawerManagerEvoHigh.class$("de.audi.atip.hmi.HMIBundle")) : class$de$audi$atip$hmi$HMIBundle).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                final HMIBundle hMIBundle = (HMIBundle)DrawerManagerEvoHigh.this.bundleContext.getService(serviceReference);
                AbstractWidget.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, new Runnable(){

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    public void run() {
                        if (hMIBundle != null) {
                            Object object;
                            EntertainmentDrawerController entertainmentDrawerController = (EntertainmentDrawerController)hMIBundle.getEntertainmentDrawer((this).DrawerManagerEvoHigh.this.terminal.getTerminalID());
                            if (entertainmentDrawerController != null) {
                                object = DrawerManagerEvoHigh.this.connectMonitor;
                                synchronized (object) {
                                    if (DrawerManagerEvoHigh.this.entertainmentDrawer == null) {
                                        DrawerManagerEvoHigh.this.entertainmentDrawer = entertainmentDrawerController;
                                    } else {
                                        IWidgetLogChannel.logDrawer.log(10000, "DrawerManagerEvoHigh#addingService: found two entertainment drawers. Old: %1,  New: %2", (long)DrawerManagerEvoHigh.this.entertainmentDrawer.getScreenId(), (long)entertainmentDrawerController.getScreenId());
                                    }
                                }
                            }
                            if ((object = hMIBundle.getEntertainmentDrawerContent((this).DrawerManagerEvoHigh.this.terminal.getTerminalID())) != null) {
                                Object object2 = DrawerManagerEvoHigh.this.connectMonitor;
                                synchronized (object2) {
                                    (this).DrawerManagerEvoHigh.this.entertainmentDrawerContent.addAll((Collection)object);
                                }
                            }
                            DrawerManagerEvoHigh.this.onNewContentAvalabilityChangedAsync();
                        }
                    }
                }));
                return hMIBundle;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
            }
        });
        serviceTracker.open();
    }

    private void internalNotifyADCListeners() {
        if (this.adclList != null) {
            Iterator iterator = this.adclList.iterator();
            while (iterator.hasNext()) {
                AudioDrawerContextListener audioDrawerContextListener = (AudioDrawerContextListener)iterator.next();
                audioDrawerContextListener.updateActiveContext(this.currentSource, this.currentEntDrawerState);
            }
        }
    }

    private AudioDrawerContext.Source contentID2SourceMapper(int n) {
        n = n < 0 ? n : (n - 1) / 1000 - 1;
        AudioDrawerContext.Source source = n == -1 ? AudioDrawerContext.SOURCE_NONE : EntertainmentDrawerContentManager.AUDIO_CONTENT_TO_SOURCES_LUT[AnimUtils.clamp(0, EntertainmentDrawerContentManager.AUDIO_CONTENT_TO_SOURCES_LUT.length - 1, n)];
        return source;
    }

    private void initializeADCLDrawerTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener = DrawerManagerEvoHigh.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener).getName(), new ServiceTrackerCustomizer(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public Object addingService(ServiceReference serviceReference) {
                AudioDrawerContextListener audioDrawerContextListener = (AudioDrawerContextListener)DrawerManagerEvoHigh.this.bundleContext.getService(serviceReference);
                if (audioDrawerContextListener != null) {
                    Object object = DrawerManagerEvoHigh.this.connectMonitor;
                    synchronized (object) {
                        if (DrawerManagerEvoHigh.this.adclList != null && !DrawerManagerEvoHigh.this.adclList.contains(audioDrawerContextListener)) {
                            DrawerManagerEvoHigh.this.adclList.add(audioDrawerContextListener);
                            audioDrawerContextListener.updateActiveContext(DrawerManagerEvoHigh.this.currentSource, DrawerManagerEvoHigh.this.currentEntDrawerState);
                        }
                    }
                }
                return audioDrawerContextListener;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof AudioDrawerContextListener) {
                    AudioDrawerContextListener audioDrawerContextListener = (AudioDrawerContextListener)object;
                    Object object2 = DrawerManagerEvoHigh.this.connectMonitor;
                    synchronized (object2) {
                        if (DrawerManagerEvoHigh.this.adclList != null && DrawerManagerEvoHigh.this.adclList.contains(audioDrawerContextListener)) {
                            DrawerManagerEvoHigh.this.adclList.remove(audioDrawerContextListener);
                        }
                    }
                }
            }
        });
        serviceTracker.open();
    }

    private EntertainmentDrawerOpenCloseController getEntertainmentDrawerOpenCloseController() {
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = null;
        if (this.entertainmentDrawer != null) {
            entertainmentDrawerOpenCloseController = this.entertainmentDrawer.getOpenCloseController();
        }
        return entertainmentDrawerOpenCloseController;
    }

    public IDrawerController getOptionDrawer(long l) {
        return (IDrawerController)this.optionDrawers.get(Util.createLong(l));
    }

    public void languageChanged() {
        this.selectionDrawers.clear();
        this.optionDrawers.clear();
    }

    public void clear() {
        this.selectionDrawers.clear();
        this.optionDrawers.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void entertainmentDrawerClosed() {
        Object object = this.connectMonitor;
        synchronized (object) {
            if (this.adclList != null) {
                Iterator iterator = this.adclList.iterator();
                while (iterator.hasNext()) {
                    AudioDrawerContextListener audioDrawerContextListener = (AudioDrawerContextListener)iterator.next();
                    audioDrawerContextListener.entertainmentDrawerClosed();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void entertainmentDrawerOpened() {
        Object object = this.connectMonitor;
        synchronized (object) {
            if (this.adclList != null) {
                Iterator iterator = this.adclList.iterator();
                while (iterator.hasNext()) {
                    AudioDrawerContextListener audioDrawerContextListener = (AudioDrawerContextListener)iterator.next();
                    audioDrawerContextListener.entertainmentDrawerOpened();
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
}

