/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.HMIDiagScreenNameMapping;
import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IHMITerminalRegistry;
import de.audi.atip.hmi.event.InitialGraphicsEvent;
import de.audi.atip.hmi.event.LanguageChangedEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.hmi.view.IFontLoader;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.hmi.view.IVisualFeedback;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.start.IStartupManager;
import de.audi.tghu.fwhmi.IDisplayManagerKombiControl;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IKanziResourceLoader;
import de.audi.tghu.hmi.evo.IKzbMappingHelper;
import de.audi.tghu.hmi.evo.ILongpressKeyHandler;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IPhoneKeyHandler;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.audi.tghu.hmi.evo.PreloadManager;
import de.eso.IconExtractor.IconExtractor;
import de.eso.widgets.preset.PresetManager;
import de.eso.widgets.preset.PresetManagerNAR;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IDrawerManager;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALStatistics;
import de.esolutions.hmi.widgets.audi.base.eal.EALVisualFeedback;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.KzbMergeManager;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.eal.StringUtilityEAL;
import de.esolutions.hmi.widgets.audi.evo.CarCodingHelper;
import de.esolutions.hmi.widgets.audi.evo.HMITerminalEvoImpl;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;
import de.esolutions.hmi.widgets.audi.evo.KzbMappingHelper;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationMIB2HighSport;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh;
import de.esolutions.hmi.widgets.audi.evo.high.FontLoaderEvoHigh;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$1;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$10;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$11;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$12;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$13;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$14;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$15;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$16;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$2;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$3;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$4;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$5;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$6;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$7;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$8;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High$9;
import de.esolutions.hmi.widgets.audi.evo.high.ImageLoaderMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.KanziResourceLoaderMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighB9;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighB9Sport;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighQ7;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighQ7Sport;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighScale;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighScaleA3;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighScaleA3Sport;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2MMICombiR8;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2MMICombiR8Sport;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2MMICombiTT;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2MMICombiTTSport;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerEvoHigh;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerMMICombi;
import de.esolutions.hmi.widgets.audi.evo.high.PresetLayoutFactory;
import de.esolutions.hmi.widgets.audi.evo.high.RendererFactoryHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LongpressKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.PhoneKeyHandler;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.BundleContext;

public class HMITerminalImplMIB2High
extends HMITerminalEvoImpl
implements HMITerminalEAL {
    public static int backgroundImageId = HMIImageConstantsSystem.mib2_background;
    public static final int TRANSPARENT_IMAGE_ID = HMIImageConstantsSystem.empty_image;
    public static final int BLACK_IMAGE_ID = HMIImageConstantsSystem.black_pixel;
    public static final int BLACK_IMAGE_ID_R8 = HMIImageConstantsSystem.mib2_background_R8_AU724;
    private EALManager ealManager;
    private PreloadManager preloadManager;
    private EALVisualFeedback visualFeedbackController;
    private PresetManager presetManager;
    private ICarCodingHelper carCodingHelper;

    public HMITerminalImplMIB2High(int n, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        super(n, bundleContext, iFrameworkAccess);
        this.postInitialEventsBeforeSysConst();
    }

    private void postInitialEventsBeforeSysConst() {
        if (this.getTerminalID() == 0) {
            IStartupManager iStartupManager;
            try {
                iStartupManager = this.framework.getStartupMgr();
            }
            catch (Exception exception) {
                IWidgetLogChannel.logBenchmark.log(10000, "HMITerminalImplMIB2#constructor no startup manager available");
                return;
            }
            if (iStartupManager != null) {
                iStartupManager.addInitialEvents(this.createInitialEventsBeforeSysConst());
            }
        }
    }

    public void postInitialEventsAfterSysConst() {
        List list = this.createInitialEventsAfterSysConst();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractWidget.hmiService.getEventDispatcher().postEvent((InitialGraphicsEvent)list.get(i2));
        }
    }

    private List createInitialEventsBeforeSysConst() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$1(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$2(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$3(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$4(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$5(this)));
        return arrayList;
    }

    private List createInitialEventsAfterSysConst() {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$6(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$7(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$8(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$9(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$10(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$11(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$12(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$13(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$14(this)));
        arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$15(this)));
        if (this.getFramework().getLogChannel("Fw.Startup").isDebug()) {
            arrayList.add(new InitialGraphicsEvent(new HMITerminalImplMIB2High$16(this)));
        }
        return arrayList;
    }

    @Override
    public void start() {
        IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#start start");
        this.initializeSkin();
        super.start();
        IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#start after super.start");
    }

    private void initializeSkin() {
        HMIModel hMIModel;
        if (this.hasMMIKombi() && (hMIModel = this.getFramework().getHMIService().getModel(this.getTerminalID(), 3937)) instanceof ChoiceModelGUI) {
            int n = ((ChoiceModelGUI)((Object)hMIModel)).getValue();
            IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#initializeSkin skin model: %1, skin ID: %2", (long)hMIModel.getID(), (long)n);
            super.setSkin(n);
        }
    }

    private boolean hasMMIKombi() {
        return this.framework != null && this.framework.getKombiType() == 4;
    }

    @Override
    protected void initializeLayout() {
        this.setLayout(this.generateLayout());
    }

    private void propagateLayoutToClusterTerminal(Layout layout) {
        HMIService hMIService = this.framework.getHMIService();
        HMITerminal hMITerminal = null;
        if (hMIService != null) {
            hMITerminal = hMIService.getHMITerminal(1);
        } else {
            IWidgetLogChannel.logBenchmark.log(10000, "HMITerminalImplMIB2#propagateLayoutToClusterTerminal the HMI service is null");
        }
        if (hMITerminal instanceof HMITerminalImpl) {
            IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#propagateLayoutToClusterTerminal cluster terminal layout: %1", (Object)layout);
            ((HMITerminalImpl)hMITerminal).setLayout(layout);
        } else {
            IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#propagateLayoutToClusterTerminal no valid cluster terminal found");
        }
    }

    @Override
    public void initializeViewSize(int n) {
        if (this.hasMMIKombi()) {
            IViewSizeManager iViewSizeManager = this.getViewSizeManager();
            if (iViewSizeManager != null) {
                IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#viewSizeChanged size: %1, skin: %2", (long)n, (long)this.skin);
                boolean bl = n == 1;
                iViewSizeManager.setSportskinSmallStage(this.skin == 1 && bl);
                AnimationMIB2HighSport.setViewSize(this.ealManager, this.layout, bl);
            } else {
                IWidgetLogChannel.logBenchmark.log(-1601830656, "HMITerminalImplMIB2#viewSizeChanged no view size manager available");
            }
        }
    }

    @Override
    public void initializeDrawerViewSize() {
        if (this.hasMMIKombi()) {
            IViewSizeManager iViewSizeManager = this.getViewSizeManager();
            if (iViewSizeManager != null) {
                boolean bl = iViewSizeManager.getCurrentViewSize() == 1;
                IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#initializeDrawerViewSize smallStage: %1, layout: %2", bl, (Object)this.layout);
                AnimationMIB2HighSport.setDrawerViewSize(this.ealManager, this.layout, bl);
            } else {
                IWidgetLogChannel.logBenchmark.log(-1601830656, "HMITerminalImplMIB2#viewSizeChanged no view size manager available");
            }
        }
    }

    public void createPreloadManager() {
    }

    @Override
    protected IDrawerManager generateDrawerManager() {
        return new DrawerManagerEvoHigh(this, this.bundleContext, this.framework);
    }

    protected void afterStart() {
        Car3DResourceHandler car3DResourceHandler;
        KzbMergeManager kzbMergeManager;
        IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#afterStart start");
        if (AbstractWidget.framework.isTarget() && AbstractWidget.isVariantHigh() && !MixedListKZBMerger.isIconExtractorInitialized) {
            IconExtractor.initialize();
            MixedListKZBMerger.isIconExtractorInitialized = true;
        }
        if (this.carCodingHelper.isR8()) {
            backgroundImageId = BLACK_IMAGE_ID_R8;
            this.ealManager.setBackgroundImageID(BLACK_IMAGE_ID_R8);
            this.ealManager.updateBackgroundImageNode(this);
            this.initializeViewSize(this.getViewSizeManager().getCurrentViewSize());
        }
        if ((kzbMergeManager = this.ealManager.getKzbMergeManager()) != null) {
            if (!this.ealManager.isOpsKzbMergeStarted()) {
                if (kzbMergeManager.mergeKzbAsynchron(12, -30, "OPS")) {
                    this.ealManager.setOpsKzbMergeStarted(true);
                    IWidgetLogChannel.logChannel3DEngine.log(1078071040, "HMITerminalImplMIB2High#afterStart: asynchronous merge of OPS-KZB started");
                } else {
                    IWidgetLogChannel.logChannel3DEngine.log(10000, "HMITerminalImplMIB2High#afterStart: could not start asynchronous merge of OPS-KZB");
                }
            }
            if (kzbMergeManager.mergeKzbAsynchron(8, 200, "selectionDrawer")) {
                IWidgetLogChannel.logChannel3DEngine.log(1078071040, "HMITerminalImplMIB2High#afterStart: asynchronous merge of selectionDrawer-KZB started");
            } else {
                IWidgetLogChannel.logChannel3DEngine.log(10000, "HMITerminalImplMIB2High#afterStart: could not start asynchronous merge of selectionDrawer-KZB");
            }
        }
        if ((car3DResourceHandler = this.ealManager.getCar3DResourceHandler()) != null) {
            if (this.carCodingHelper.isPHEVCar()) {
                car3DResourceHandler.initializePHEVHandler();
            }
            car3DResourceHandler.loadResourcesAsync(3, 110, "car");
        }
        IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#start after afterStart");
    }

    protected void createEALManager() {
        this.ealManager = new EALManager(this);
        MixedListKZBMerger.startTrackingAndMerge(this.bundleContext, this.ealManager);
    }

    public void startMergeMixedListKZB() {
        MixedListKZBMerger.startTrackingAndMerge(this.bundleContext, this.ealManager);
    }

    @Override
    protected void initializeGraphics() {
        EALStatistics eALStatistics = new EALStatistics(this.ealManager, this);
        this.statistics = eALStatistics;
        this.ealManager.setStatistics(eALStatistics);
        this.visualFeedbackController = new EALVisualFeedback(this.ealManager, this);
    }

    @Override
    protected void initializeOSGi() {
        this.ealManager.initializeAnimationSyncTracker();
        super.initializeOSGi();
    }

    @Override
    protected void initializeBins() {
    }

    @Override
    protected void disposeGraphics() {
        ((EALStatistics)this.statistics).destroyStatisticElements();
        if (null != this.visualFeedbackController) {
            this.visualFeedbackController.deinit();
        }
    }

    @Override
    public IGUIManager getGUIManager() {
        return this.ealManager;
    }

    @Override
    protected Screen createFallbackScreen() {
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(-129);
        screenWidgetEVO.setRenderer(new ScreenRendererHigh(screenWidgetEVO));
        screenWidgetEVO.setTerminal(this);
        screenWidgetEVO.setColorIndices(new int[]{1, 2, 4, 0});
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, 255, -1, -1, -1701143809, -1431655681, -1246382593, -1701143809, -1}, {-1, 255, 419495935, 1751100415, -1701143809, -1431655681, -1246382593, -1701143809, 1228585215}, {-1, 255, -19456, 1838260991, -1701143809, -1431655681, -1246382593, -1701143809, 1838260991}, {-1, 255, -1433657601, -1567134209, -1701143809, -1431655681, -1246382593, -1701143809, -1567134209}, {-1, 255, 11166975, 1973122047, -1701143809, -1431655681, -1246382593, -1701143809, 1973122047}});
        return screenWidgetEVO;
    }

    @Override
    protected IFontLoader generateFontLoader() {
        return new FontLoaderEvoHigh(this);
    }

    @Override
    protected IImageLoader generateImageLoader() {
        if (imageLoader == null) {
            imageLoader = new ImageLoaderMIB2High(this.ealManager);
        }
        return imageLoader;
    }

    @Override
    public IKanziResourceLoader getKanziResourceLoader() {
        return kanziResourceLoader;
    }

    @Override
    public EALManager getEALManager() {
        return this.ealManager;
    }

    @Override
    protected Layout generateLayout() {
        Layout layout;
        if (this.isG21HighScale()) {
            layout = new LayoutMIB2HighScale();
        } else {
            ICarCodingHelper iCarCodingHelper = this.getCarCodingHelper();
            layout = this.skin == 1 ? this.generateLayoutSport(iCarCodingHelper) : this.generateLayoutClassic(iCarCodingHelper);
        }
        IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#generateLayout layout: %1", (Object)layout);
        return layout;
    }

    private boolean isG21HighScale() {
        return this.isScreenResolution800() && this.framework.getSysConst(4581) == 0 && this.framework.getSysConst(523) == 1;
    }

    private boolean isScreenResolution800() {
        return this.framework.getSysConst(522) == 1;
    }

    private Layout generateLayoutSport(ICarCodingHelper iCarCodingHelper) {
        WidgetConstants widgetConstants = iCarCodingHelper.isA3() ? new LayoutMIB2HighScaleA3Sport() : (iCarCodingHelper.isB9() || iCarCodingHelper.isQ2() || iCarCodingHelper.isQ5() ? new LayoutMIB2HighB9Sport() : (iCarCodingHelper.isQ7() ? new LayoutMIB2HighQ7Sport() : (iCarCodingHelper.isR8() ? new LayoutMIB2MMICombiR8Sport() : new LayoutMIB2MMICombiTTSport())));
        return widgetConstants;
    }

    private Layout generateLayoutClassic(ICarCodingHelper iCarCodingHelper) {
        WidgetConstants widgetConstants = iCarCodingHelper.isA3() ? new LayoutMIB2HighScaleA3() : (iCarCodingHelper.isB9() || iCarCodingHelper.isQ2() || iCarCodingHelper.isQ5() ? new LayoutMIB2HighB9() : (iCarCodingHelper.isQ7() ? new LayoutMIB2HighQ7() : (iCarCodingHelper.isR8() ? new LayoutMIB2MMICombiR8() : new LayoutMIB2MMICombiTT())));
        return widgetConstants;
    }

    @Override
    protected IAnimationController generateAnimationController() {
        AnimationControllerMIB2High animationControllerMIB2High = new AnimationControllerMIB2High(109);
        animationControllerMIB2High.setSkin(this.skin);
        return animationControllerMIB2High;
    }

    @Override
    public String getScreenName(int n) {
        return HMIDiagScreenNameMapping.getScreenName(n);
    }

    @Override
    protected StringUtility generateStringUtility() {
        return new StringUtilityEAL(this);
    }

    @Override
    protected DumpInfoProvider createRenderInfoProvider() {
        return null;
    }

    @Override
    protected IPartialPopupManagerEvo generatePartialPopupManagerEvo() {
        PartialPopupManagerEvoHigh partialPopupManagerEvoHigh = AbstractWidget.isScreenResolution1440() ? new PartialPopupManagerMMICombi(this, this.bundleContext, this.framework) : new PartialPopupManagerEvoHigh(this, this.bundleContext, this.framework);
        return partialPopupManagerEvoHigh;
    }

    @Override
    protected IPresetInputHandler generatePresetPopupHandler() {
        if (this.presetManager == null) {
            this.presetManager = this.framework.isNar() ? new PresetManagerNAR(this, this.bundleContext, this.framework) : new PresetManager(this, this.bundleContext, this.framework);
            this.presetManager.initialize();
            this.presetManager.setPresetLayoutFactory(new PresetLayoutFactory());
        }
        return this.presetManager.getPresetInputHandler();
    }

    @Override
    protected ICarCodingHelper generateCarCodingHelper() {
        if (this.carCodingHelper == null) {
            this.carCodingHelper = new CarCodingHelper(this.framework);
        }
        return this.carCodingHelper;
    }

    @Override
    protected IKzbMappingHelper generateKzbMappingHelper(ICarCodingHelper iCarCodingHelper) {
        if (this.kzbMappingHelper == null) {
            this.kzbMappingHelper = new KzbMappingHelper(iCarCodingHelper);
        }
        return this.kzbMappingHelper;
    }

    @Override
    protected IPhoneKeyHandler generatePhoneKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        return new PhoneKeyHandler(iDrawerFocusManagerEvo);
    }

    @Override
    protected ILongpressKeyHandler generateLongpressKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        return new LongpressKeyHandler(iDrawerFocusManagerEvo);
    }

    @Override
    protected void setJointTerminalFocus(int n) {
    }

    @Override
    public StringUtility getStringUtility(IWrappedFont iWrappedFont) {
        StringUtility stringUtility = this.getStringUtility();
        ((StringUtilityEAL)stringUtility).setCurrentFont(iWrappedFont);
        return stringUtility;
    }

    @Override
    protected IRendererFactory generateRendererFactory() {
        return new RendererFactoryHigh();
    }

    @Override
    protected void initializeApplicationModels() {
        int n = 29;
        ListCell[] listCellArray = new ListCell[n];
        Layout layout = this.getLayout();
        int n2 = layout.getDistance(1);
        int n3 = layout.getDistance(2);
        listCellArray[0] = IntegerListCell.create(n2);
        listCellArray[1] = IntegerListCell.create(n3);
        listCellArray[2] = IntegerListCell.create(layout.getDistance(194));
        listCellArray[3] = IntegerListCell.create(layout.getDistance(195));
        listCellArray[4] = IntegerListCell.create(layout.getDistance(196));
        listCellArray[5] = IntegerListCell.create(layout.getDistance(197));
        listCellArray[6] = IntegerListCell.create(layout.getDistance(198));
        listCellArray[7] = IntegerListCell.create(layout.getDistance(199));
        listCellArray[19] = IntegerListCell.create(layout.getDistance(215));
        listCellArray[8] = IntegerListCell.create(layout.getDistance(200));
        listCellArray[9] = IntegerListCell.create(layout.getDistance(201));
        listCellArray[10] = IntegerListCell.create(layout.getDistance(202));
        listCellArray[11] = IntegerListCell.create(layout.getDistance(203));
        listCellArray[12] = IntegerListCell.create(layout.getDistance(204));
        listCellArray[13] = IntegerListCell.create(layout.getDistance(205));
        listCellArray[14] = IntegerListCell.create(layout.getDistance(206));
        listCellArray[15] = IntegerListCell.create(layout.getDistance(207));
        listCellArray[16] = IntegerListCell.create(layout.getDistance(208));
        listCellArray[17] = IntegerListCell.create(layout.getDistance(208));
        listCellArray[18] = IntegerListCell.create(layout.getDistance(214));
        listCellArray[20] = IntegerListCell.create(layout.getDistance(219));
        listCellArray[21] = IntegerListCell.create(layout.getDistance(220));
        listCellArray[22] = IntegerListCell.create(layout.getDistance(221));
        listCellArray[23] = IntegerListCell.create(layout.getDistance(222));
        listCellArray[24] = IntegerListCell.create(0);
        listCellArray[25] = IntegerListCell.create(0);
        listCellArray[27] = IntegerListCell.create(layout.getIntegerConstant(114));
        listCellArray[26] = IntegerListCell.create(layout.getIntegerConstant(115));
        listCellArray[28] = IntegerListCell.create(65);
        ListModelApp listModelApp = (ListModelApp)((Object)AbstractWidget.hmiService.getModel(176));
        if (listModelApp != null) {
            boolean bl;
            int n4 = this.framework.getSysConst(541);
            boolean bl2 = bl = n4 == 2 || n4 == 1;
            if (bl) {
                listModelApp.setMaxRows(2);
            } else {
                listModelApp.setMaxRows(1);
            }
            listModelApp.setMaxColumns(listCellArray.length);
            listModelApp.addRow(listCellArray);
            if (n4 == 2) {
                ListCell[] listCellArray2 = new ListCell[n];
                for (int i2 = 0; i2 < 29; ++i2) {
                    listCellArray2[i2] = IntegerListCell.create(((IntegerListCell)listCellArray[i2]).getValue());
                }
                listCellArray2[9] = IntegerListCell.create(77);
                listCellArray2[2] = IntegerListCell.create(155);
                listCellArray2[0] = IntegerListCell.create(1440);
                listCellArray2[1] = IntegerListCell.create(540);
                listCellArray2[27] = IntegerListCell.create(1440);
                listCellArray2[26] = IntegerListCell.create(455);
                listCellArray2[8] = IntegerListCell.create(165);
                listCellArray2[9] = IntegerListCell.create(75);
                listCellArray2[11] = IntegerListCell.create(370);
                listCellArray2[13] = IntegerListCell.create(490);
                listCellArray2[12] = IntegerListCell.create(370);
                listCellArray2[14] = IntegerListCell.create(490);
                listCellArray2[24] = IntegerListCell.create(layout.getIntegerConstant(108));
                listCellArray2[25] = IntegerListCell.create(layout.getIntegerConstant(109));
                listModelApp.addRow(listCellArray2);
            } else if (n4 == 1) {
                ListCell[] listCellArray3 = new ListCell[n];
                for (int i3 = 0; i3 < 29; ++i3) {
                    listCellArray3[i3] = IntegerListCell.create(0);
                }
                listCellArray3[0] = IntegerListCell.create(800);
                listCellArray3[1] = IntegerListCell.create(298);
                listCellArray3[27] = IntegerListCell.create(800);
                listCellArray3[26] = IntegerListCell.create(298);
                listCellArray3[2] = IntegerListCell.create(20);
                listCellArray3[8] = IntegerListCell.create(28);
                listModelApp.addRow(listCellArray3);
            }
        }
    }

    @Override
    protected void generateKanziResourceLoader(IGUIManager iGUIManager) {
        if (kanziResourceLoader == null) {
            kanziResourceLoader = new KanziResourceLoaderMIB2High((EALManager)iGUIManager);
        }
    }

    @Override
    public IVisualFeedback getVisualFeedback() {
        return this.visualFeedbackController;
    }

    @Override
    public void setSkin(int n) {
        if (this.skin != n) {
            IWidgetLogChannel.logBenchmark.log(-2137614336, "HMITerminalImplMIB2#setSkin skin: %1", (long)n);
            System.out.println(new StringBuffer().append("HMITerminalImplMIB2#setSkin skin: ").append(n).toString());
            super.setSkin(n);
            this.propagateSkinToDisplayManager(n);
            this.setLayout(this.generateLayout());
            if (this.animationController != null) {
                ((AnimationControllerMIB2High)this.animationController).setSkin(n);
            }
            if (this.getDrawerFocusManager() != null && AbstractWidget.isScreenResolution1440()) {
                this.getDrawerFocusManager().reconnectDrawers();
            }
            if (n == 0) {
                AnimationMIB2HighSport.setViewSize(this.ealManager, this.layout, false);
            } else if (this.getViewSizeManager().getCurrentViewSize() == 1) {
                AnimationMIB2HighSport.setViewSize(this.ealManager, this.layout, true);
            }
            if (this.ealManager != null) {
                this.ealManager.draw();
            }
        }
    }

    @Override
    public void setLayout(Layout layout) {
        super.setLayout(layout);
        this.propagateLayoutToClusterTerminal(layout);
    }

    private void propagateSkinToDisplayManager(int n) {
        IDisplayManager iDisplayManager;
        IHMITerminalRegistry iHMITerminalRegistry;
        if (this.framework != null && (iHMITerminalRegistry = this.framework.getHMITerminalRegistry()) != null && (iDisplayManager = iHMITerminalRegistry.getDisplayManager()) instanceof IDisplayManagerKombiControl) {
            ((IDisplayManagerKombiControl)iDisplayManager).setupKDKBackground(n);
        }
    }

    @Override
    public PreloadManager getPreloadManager() {
        return this.preloadManager;
    }

    @Override
    public ICarCodingHelper getCarCodingHelper() {
        return this.carCodingHelper;
    }

    @Override
    public void languageChanged(LanguageChangedEvent languageChangedEvent) {
        IViewSizeManager iViewSizeManager;
        boolean bl = EALManager.RTL_ENABLED ? languageChangedEvent.getLanguage().getTextDirection() == 0 : true;
        this.ealManager.setGlobalPropertyFlag("global_arabic", !bl);
        this.ealManager.setLayersLayout(bl);
        super.languageChanged(languageChangedEvent);
        if (AbstractWidget.isArabia() && this.carCodingHelper != null && this.carCodingHelper.isR8() && (iViewSizeManager = this.getViewSizeManager()) != null) {
            boolean bl2 = iViewSizeManager.getCurrentViewSize() == 1;
            AnimationMIB2HighSport.setViewSize(this.ealManager, this.layout, bl2);
        }
    }

    static /* synthetic */ EALManager access$000(HMITerminalImplMIB2High hMITerminalImplMIB2High) {
        return hMITerminalImplMIB2High.ealManager;
    }

    static /* synthetic */ ICarCodingHelper access$100(HMITerminalImplMIB2High hMITerminalImplMIB2High) {
        return hMITerminalImplMIB2High.carCodingHelper;
    }
}

