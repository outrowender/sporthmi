/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;
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
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh$1;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh$2;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh$3;
import de.esolutions.hmi.widgets.audi.evo.high.ap.EntertainmentActionProxyRouter;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.osgi.framework.BundleContext;
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
    private AudioDrawerContext$Source currentSource;
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

    @Override
    public void activateSelectionDrawer(long l) {
        Object object;
        Long l2 = Util.createLong(l);
        if (l != -1L && !this.selectionDrawers.containsKey(l2) && (object = AbstractWidget.hmiService.getSelectionDrawers(this.terminal.getTerminalID(), (int)l / -1601830656)) != null) {
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
                logDrawer.log(-2137614336, "DrawerManagerEvoHigh#activateSelectionDrawer: no selection drawer found for id %1", l);
            }
        }
        if (l != -1L && this.selectionDrawers.containsKey(l2)) {
            object = (DrawerController)this.selectionDrawers.get(l2);
            if (!((DrawerController)object).isConnected()) {
                this.connectDrawer((DrawerController)object);
            }
            this.drawerFocusManager.setSelectionDrawer(object);
        } else {
            logDrawer.log(-2137614336, "DrawerManagerEvoHigh#activateSelectionDrawer: no selection drawer available for id %1", l);
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

    @Override
    public void activateOptionDrawer(long l, long[] lArray) {
        IDrawerControllerEvo[] iDrawerControllerEvoArray;
        LogChannel logChannel = IWidgetLogChannel.logDrawerCondtionEngine;
        logChannel.log(-2137614336, "activateOptionDrawer id: %1", l);
        if (lArray != null) {
            for (int i2 = 0; i2 < lArray.length; ++i2) {
                logChannel.log(-2137614336, "activateOptionDrawer next valid context: %1", lArray[i2]);
            }
        }
        Long l2 = Util.createLong(l);
        if (l != -1L && !this.optionDrawers.containsKey(l2) && (iDrawerControllerEvoArray = AbstractWidget.hmiService.getOptionDrawers(this.terminal.getTerminalID(), (int)l / -1601830656)) != null) {
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

    @Override
    public int getBlackListedConnection() {
        return EntertainmentActionProxyRouter.getInstance().getBlackListedConnection();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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

    @Override
    public void activateEntertainmentDrawerContent(AbstractWidgetController abstractWidgetController) {
        if (Util.equals(abstractWidgetController, this.activeEntertainmentContent)) {
            return;
        }
        if (this.activeEntertainmentContent instanceof Screen) {
            logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#activateEntertainmentDrawerContent: deactivate content: %1", (Object)this.activeEntertainmentContent);
            this.connectingService.modifiyModelReference((Screen)((Object)this.activeEntertainmentContent), false, true);
        } else if (this.activeEntertainmentContent != null) {
            logEntertainmentDrawer.log(-1601830656, "DrawerManagerEvoHigh#activateEntertainmentDrawerContent: old content is no Screen: %1", (Object)this.activeEntertainmentContent);
        }
        this.activeEntertainmentContent = abstractWidgetController;
        if (this.activeEntertainmentContent instanceof Screen) {
            logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#activateEntertainmentDrawerContent: activate content: %1", (Object)this.activeEntertainmentContent);
            this.connectDrawer((DrawerController)this.activeEntertainmentContent, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
        logEntertainmentDrawer.log(-1601830656, "DrawerManagerEvoHigh#getNewEntertainmentContent: audioSource %1 could not be found, trying to fetch default content", (long)n);
        return this.getNewEntertainmentContent(9999);
    }

    private void onNewContentAvalabilityChangedAsync() {
        this.terminal.getFramework().getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new DrawerManagerEvoHigh$1(this)));
    }

    @Override
    public void startTrackingServices() {
        if (!AbstractWidget.isScreenResolution1440()) {
            this.initializeDrawerTracker();
            this.initializeADCLDrawerTracker();
        }
    }

    @Override
    public void entertainmentBlacklist(int n, int n2) {
        logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#entertainmentBlacklist: ENTER terminalID=%1 Blacklist=%2", (long)n, (long)n2);
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = this.getEntertainmentDrawerOpenCloseController();
        if (entertainmentDrawerOpenCloseController != null) {
            entertainmentDrawerOpenCloseController.onBlacklistAudioSource(n, n2);
        }
        logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#entertainmentBlacklist: EXIT");
    }

    @Override
    public void entertainmentSetVisible(int n, boolean bl) {
        Object object;
        if (logEntertainmentDrawer.isDebug()) {
            object = new Buffer();
            ((Buffer)object).append("DrawerManagerEvoHigh#entertainmentSetVisible ENTER terminalID=").append(n).append("  visible=").append(bl);
            logEntertainmentDrawer.log(-2137614336, ((Buffer)object).toString());
        }
        if ((object = this.getEntertainmentDrawerOpenCloseController()) != null) {
            ((EntertainmentDrawerOpenCloseController)object).onDrawerVisibiltyChange(bl);
        }
        logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#entertainmentSetVisible: EXIT");
    }

    @Override
    public void onNewContentAvalabilityChanged() {
        logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#onNewContentAvalabilityChanged: ENTER");
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = this.getEntertainmentDrawerOpenCloseController();
        if (entertainmentDrawerOpenCloseController != null && entertainmentDrawerOpenCloseController.isConnected()) {
            entertainmentDrawerOpenCloseController.onNewContentAvalabilityChanged();
        }
        logEntertainmentDrawer.log(-2137614336, "DrawerManagerEvoHigh#onNewContentAvalabilityChanged: EXIT");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyADCListeners(int n, int n2) {
        Object object = this.connectMonitor;
        synchronized (object) {
            AudioDrawerContext$Source audioDrawerContext$Source = this.contentID2SourceMapper(n);
            if (!Util.equals(this.currentSource, audioDrawerContext$Source) || this.currentEntDrawerState != n2) {
                this.currentSource = audioDrawerContext$Source;
                this.currentEntDrawerState = n2;
                this.internalNotifyADCListeners();
            }
        }
    }

    private void initializeDrawerTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$hmi$HMIBundle == null ? (class$de$audi$atip$hmi$HMIBundle = DrawerManagerEvoHigh.class$("de.audi.atip.hmi.HMIBundle")) : class$de$audi$atip$hmi$HMIBundle).getName(), (ServiceTrackerCustomizer)new DrawerManagerEvoHigh$2(this));
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

    private AudioDrawerContext$Source contentID2SourceMapper(int n) {
        n = n < 0 ? n : (n - 1) / 1000 - 1;
        AudioDrawerContext$Source audioDrawerContext$Source = n == -1 ? AudioDrawerContext.SOURCE_NONE : EntertainmentDrawerContentManager.AUDIO_CONTENT_TO_SOURCES_LUT[AnimUtils.clamp(0, EntertainmentDrawerContentManager.AUDIO_CONTENT_TO_SOURCES_LUT.length - 1, n)];
        return audioDrawerContext$Source;
    }

    private void initializeADCLDrawerTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener = DrawerManagerEvoHigh.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener).getName(), (ServiceTrackerCustomizer)new DrawerManagerEvoHigh$3(this));
        serviceTracker.open();
    }

    private EntertainmentDrawerOpenCloseController getEntertainmentDrawerOpenCloseController() {
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = null;
        if (this.entertainmentDrawer != null) {
            entertainmentDrawerOpenCloseController = this.entertainmentDrawer.getOpenCloseController();
        }
        return entertainmentDrawerOpenCloseController;
    }

    @Override
    public IDrawerController getOptionDrawer(long l) {
        return (IDrawerController)this.optionDrawers.get(Util.createLong(l));
    }

    @Override
    public void languageChanged() {
        this.selectionDrawers.clear();
        this.optionDrawers.clear();
    }

    @Override
    public void clear() {
        this.selectionDrawers.clear();
        this.optionDrawers.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
    @Override
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

    static /* synthetic */ Object access$000(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        return drawerManagerEvoHigh.connectMonitor;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ BundleContext access$100(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        return drawerManagerEvoHigh.bundleContext;
    }

    static /* synthetic */ EntertainmentDrawerController access$300(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        return drawerManagerEvoHigh.entertainmentDrawer;
    }

    static /* synthetic */ EntertainmentDrawerController access$302(DrawerManagerEvoHigh drawerManagerEvoHigh, EntertainmentDrawerController entertainmentDrawerController) {
        drawerManagerEvoHigh.entertainmentDrawer = entertainmentDrawerController;
        return drawerManagerEvoHigh.entertainmentDrawer;
    }

    static /* synthetic */ void access$400(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        drawerManagerEvoHigh.onNewContentAvalabilityChangedAsync();
    }

    static /* synthetic */ ArrayList access$500(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        return drawerManagerEvoHigh.adclList;
    }

    static /* synthetic */ AudioDrawerContext$Source access$600(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        return drawerManagerEvoHigh.currentSource;
    }

    static /* synthetic */ int access$700(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        return drawerManagerEvoHigh.currentEntDrawerState;
    }
}

