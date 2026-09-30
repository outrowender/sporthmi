/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.ITTSHandler;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.hmi.LanguageAware;
import de.audi.atip.hmi.event.LanguageChangedEvent;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IFontLoader;
import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IStatistics;
import de.audi.atip.hmi.view.ITouchInputManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenCache;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.fwhmi.evo.IRootWindowEvo;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IKzbMappingHelper;
import de.audi.tghu.hmi.evo.ILongpressKeyHandler;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IPhoneKeyHandler;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IDrawerManager;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.ScreenCacheImpl;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.TTSHandler;
import de.esolutions.hmi.widgets.audi.base.WidgetPersistenceManager;
import de.esolutions.hmi.widgets.audi.base.WidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class HMITerminalImpl
implements HMITerminal,
LanguageAware {
    protected LogChannel logBenchmark;
    public static IFontLoader fontLoader;
    public static IImageLoader imageLoader;
    protected static boolean binsInitizalized;
    protected final int terminalID;
    protected Layout layout;
    protected IStatistics statistics;
    protected RedrawContext redrawContext;
    protected IAnimationController animationController;
    protected IRootWindowEvo rootWindow;
    protected WidgetRegistry widgetRegistry;
    protected StringUtility stringUtility;
    protected ScreenCache screenCache;
    protected WidgetPersistenceManager widgetPersistence;
    protected IPartialPopupManagerEvo partialPopupManagerEvo;
    protected volatile boolean started = false;
    protected static ITTSHandler ttsHandler;
    protected long state = 1L;
    private int highlightSK;
    private boolean hasFocus = false;
    private boolean inJointMode = false;
    private HMITerminalImpl jointTerminal;
    protected BundleContext bundleContext;
    protected IFrameworkAccess framework;
    private IDrawerFocusManagerEvo drawerFocusManager;
    private ICarCodingHelper carCodingHelper;
    protected IKzbMappingHelper kzbMappingHelper;
    private IDrawerManager drawerManager;
    private IViewSizeManager viewSizeManager;
    private IDrawerConditionEngine drawerConditionEngine;
    private ITouchInputManager touchInputManager;
    private IPresetInputHandler presetPopupHandler;
    private KbdService kbdService;
    private ServiceRegistration sReg;
    private ServiceRegistration sRegTTSService;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;

    public HMITerminalImpl(int n, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this.terminalID = n;
        this.framework = iFrameworkAccess;
        this.bundleContext = bundleContext;
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public void start() {
        if (this.logBenchmark == null) {
            this.logBenchmark = AbstractWidget.framework.getLogChannel("Ext.Benchmark");
        }
        if (this.started) {
            this.logBenchmark.log(10000, "HMITerminal#start terminal already started, ignore.");
            return;
        }
        this.logBenchmark.log(10000000, "HMITerminal#start before terminal start");
        this.initializeComponents();
        this.initializeRootWindow();
        this.initializeGraphics();
        this.initializeBins();
        this.framework.getHMIService().setFallbackScreen(this.terminalID, this.createFallbackScreen());
        this.started = true;
        this.initializeOSGi();
        this.logBenchmark.log(10000000, "HMITerminal#start after terminal start");
    }

    protected void initializeComponents() {
        this.partialPopupManagerEvo = this.generatePartialPopupManagerEvo();
        this.initializeLayout();
        this.widgetRegistry = this.generateWidgetRegistry();
        this.animationController = this.generateAnimationController();
        AnimationController animationController = (AnimationController)this.animationController;
        if (animationController != null) {
            animationController.setTerminal(this);
            animationController.setWidgetRegistry(this.widgetRegistry);
            animationController.start(this.framework);
        }
        if (fontLoader == null) {
            fontLoader = this.generateFontLoader();
        }
        this.stringUtility = this.generateStringUtility();
        this.screenCache = new ScreenCacheImpl();
        this.widgetPersistence = new WidgetPersistenceManager();
        this.drawerFocusManager = this.generateDrawerFocusManager();
        if (!AbstractWidget.isScreenResolution1440()) {
            this.presetPopupHandler = this.generatePresetPopupHandler();
        }
        if (this.drawerFocusManager != null) {
            this.drawerFocusManager.setPartialPopupManager(this.partialPopupManagerEvo);
            this.drawerFocusManager.setPresetPopupHandler(this.presetPopupHandler);
            IPhoneKeyHandler iPhoneKeyHandler = this.generatePhoneKeyHandler(this.drawerFocusManager);
            this.drawerFocusManager.setPhoneKeyHandler(iPhoneKeyHandler);
            ILongpressKeyHandler iLongpressKeyHandler = this.generateLongpressKeyHandler(this.drawerFocusManager);
            this.drawerFocusManager.setLongpressKeyHandler(iLongpressKeyHandler);
        }
        this.drawerConditionEngine = this.generateDrawerConditionEngine(this.bundleContext);
        this.drawerManager = this.generateDrawerManager();
        this.viewSizeManager = this.generateViewSizeManager();
        this.touchInputManager = this.generateTouchInputManager();
        if (ttsHandler == null) {
            ttsHandler = new TTSHandler();
        }
        this.initializeApplicationModels();
    }

    protected void initializeLayout() {
        if (this.layout == null) {
            this.layout = this.generateLayout();
        }
    }

    protected abstract StringUtility generateStringUtility();

    protected abstract IDrawerFocusManagerEvo generateDrawerFocusManager();

    protected abstract IDrawerManager generateDrawerManager();

    protected abstract IViewSizeManager generateViewSizeManager();

    protected abstract IDrawerConditionEngine generateDrawerConditionEngine(BundleContext var1);

    protected abstract ITouchInputManager generateTouchInputManager();

    protected void initializeRootWindow() {
        this.rootWindow = (IRootWindowEvo)this.framework.getHMIService().getRootWindow(this.terminalID);
        this.rootWindow.setDrawerFocusManager(this.drawerFocusManager);
        this.rootWindow.setViewSizeManager(this.viewSizeManager);
    }

    protected abstract void initializeGraphics();

    protected abstract void initializeBins();

    protected void initializeOSGi() {
        this.animationController.registerService(this.framework);
        Hashtable hashtable = new Hashtable();
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.sReg = this.bundleContext.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = HMITerminalImpl.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.partialPopupManagerEvo, (Dictionary)hashtable);
        ((AbstractPartialPopupManager)this.partialPopupManagerEvo).startTrackingServices();
        ((AbstractPartialPopupManager)this.partialPopupManagerEvo).registerServices();
        this.drawerManager.startTrackingServices();
        this.viewSizeManager.startTrackingServices(this.bundleContext, this);
        this.viewSizeManager.registerViewSizeManagerService(this.framework);
        this.drawerFocusManager.startTrackingServices(this.bundleContext, this);
        this.drawerFocusManager.registerDrawerFocusManagerService(this.framework);
        this.framework.getBundleCxt().registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = HMITerminalImpl.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)this.createRenderInfoProvider(), null);
    }

    private void registerTTSListener() {
        if (this.terminalID == 0 && this.sRegTTSService == null) {
            Hashtable hashtable = new Hashtable();
            hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_TOUCHPAD);
            hashtable.put("ApplicationName", "TOUCHPAD");
            this.sRegTTSService = this.bundleContext.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = HMITerminalImpl.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)this.getTTSHandler(), (Dictionary)hashtable);
        }
    }

    protected abstract void initializeApplicationModels();

    protected abstract Screen createFallbackScreen();

    public int getOffscreenContainerThresholdSize() {
        return 10000;
    }

    protected abstract DumpInfoProvider createRenderInfoProvider();

    public void stop() {
        this.started = false;
        this.disposeComponents();
        this.disposeGraphics();
        this.disposeOSGi();
    }

    protected void disposeComponents() {
        if (imageLoader != null) {
            imageLoader.clearImageCache();
        }
    }

    protected abstract void disposeGraphics();

    protected void disposeOSGi() {
        if (this.sReg != null) {
            this.sReg.unregister();
            this.sReg = null;
        }
    }

    public boolean isStarted() {
        return this.started;
    }

    protected abstract Layout generateLayout();

    protected abstract IAnimationController generateAnimationController();

    protected abstract IImageLoader generateImageLoader();

    protected abstract IFontLoader generateFontLoader();

    protected abstract IPartialPopupManagerEvo generatePartialPopupManagerEvo();

    protected abstract IPresetInputHandler generatePresetPopupHandler();

    protected abstract ICarCodingHelper generateCarCodingHelper();

    protected abstract IKzbMappingHelper generateKzbMappingHelper(ICarCodingHelper var1);

    protected abstract IPhoneKeyHandler generatePhoneKeyHandler(IDrawerFocusManagerEvo var1);

    protected abstract ILongpressKeyHandler generateLongpressKeyHandler(IDrawerFocusManagerEvo var1);

    protected WidgetRegistry generateWidgetRegistry() {
        return new WidgetRegistry();
    }

    public RedrawContext getRedrawContext() {
        return this.redrawContext;
    }

    public void setRedrawContext(RedrawContext redrawContext) {
        this.redrawContext = redrawContext;
    }

    public IAnimationController getIAnimationController() {
        return this.animationController;
    }

    public IRootWindow getRootWindow() {
        return this.rootWindow;
    }

    public IFontLoader getFontLoader() {
        return fontLoader;
    }

    public IImageLoader getImageLoader() {
        return imageLoader;
    }

    public WidgetPersistenceManager getWidgetPersistenceManager() {
        return this.widgetPersistence;
    }

    public StringUtility getStringUtility() {
        return this.stringUtility;
    }

    protected String getBinSizes() {
        return null;
    }

    public int getFontSizeCount() {
        return 1;
    }

    public IStatistics getStatistics() {
        return this.statistics;
    }

    public ScreenCache getScreenCache() {
        return this.screenCache;
    }

    public IPartialPopupManager getPartialPopupManager() {
        return this.partialPopupManagerEvo;
    }

    public IPartialPopupManagerEvo getPartialPopupManagerEvo() {
        return this.partialPopupManagerEvo;
    }

    public IPresetInputHandler getPresetPopupHandler() {
        return this.presetPopupHandler;
    }

    public ITTSHandler getTTSHandler() {
        return ttsHandler;
    }

    public void setFocus(boolean bl) {
        if (!this.hasFocus && bl) {
            if (!this.isInJointMode() && this.kbdService != null) {
                this.kbdService.setSKIlluminationExclusive(this.highlightSK);
            }
            if (this.jointTerminal == null) {
                this.jointTerminal = (HMITerminalImpl)this.framework.getHMITerminalRegistry().getTerminal(5);
            }
            if (this.jointTerminal != null) {
                this.jointTerminal.setJointTerminalFocus(this.terminalID);
            }
        }
        this.hasFocus = bl;
    }

    protected abstract void setJointTerminalFocus(int var1);

    public boolean hasFocus() {
        return this.hasFocus;
    }

    public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        if (ttsHandler != null) {
            ttsHandler.setTTSService(tTSSessionBasedService);
        }
        this.registerTTSListener();
    }

    public int getHighlightSK() {
        return this.highlightSK;
    }

    public void setHighlightSK(int n) {
        this.highlightSK = n;
    }

    public boolean isInJointMode() {
        return this.inJointMode;
    }

    public void setInJointMode(boolean bl) {
        this.inJointMode = bl;
    }

    public int[] getGlyphCachePageSize() {
        return new int[]{512, 512};
    }

    public WidgetRegistry getWidgetRegistry() {
        return this.widgetRegistry;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public IDrawerFocusManagerEvo getDrawerFocusManager() {
        return this.drawerFocusManager;
    }

    public String getScreenName(int n) {
        return String.valueOf(n);
    }

    public IDrawerManager getDrawerManager() {
        return this.drawerManager;
    }

    public IDrawerConditionEngine getDrawerConditionEngine() {
        return this.drawerConditionEngine;
    }

    public IViewSizeManager getViewSizeManager() {
        return this.viewSizeManager;
    }

    public ITouchInputManager getTouchInputManager() {
        return this.touchInputManager;
    }

    public void setKbdService(KbdService kbdService) {
        this.kbdService = kbdService;
    }

    public KbdService getKbdService() {
        return this.kbdService;
    }

    public ICarCodingHelper getCarCodingHelper() {
        return this.carCodingHelper;
    }

    public IKzbMappingHelper getKzbMappingHelper() {
        return this.kzbMappingHelper;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public abstract IUserHintHandler getUserHintHandler();

    public void languageChanged(LanguageChangedEvent languageChangedEvent) {
        this.partialPopupManagerEvo.processLanguageChangedEvent(languageChangedEvent);
        this.drawerFocusManager.reconnectDrawers();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        binsInitizalized = false;
        ttsHandler = null;
    }
}

