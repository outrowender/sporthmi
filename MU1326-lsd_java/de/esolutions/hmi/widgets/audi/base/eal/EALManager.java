/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.EALMergeEvent;
import de.audi.atip.hmi.event.MergeKZBAsyncEvent;
import de.audi.atip.hmi.event.PersonalPoiDatabaseUpdateEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.event.VRAMEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.IKzbMergeListener;
import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.audi.tghu.hmi.evo.IKzbMappingHelper;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.FlagEvent;
import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.api.IContext;
import de.esolutions.graphics.eal.api.IFactory;
import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DImage;
import de.esolutions.graphics.eal.api.INode2DLink;
import de.esolutions.graphics.eal.api.INode2DManaged;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DCamera;
import de.esolutions.graphics.eal.api.INode3DImage;
import de.esolutions.graphics.eal.api.INode3DQuickDraw;
import de.esolutions.graphics.eal.api.INode3DScene;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.api.IRenderer;
import de.esolutions.graphics.eal.api.IRendererAnnotation;
import de.esolutions.graphics.eal.api.ITemplateNode3D;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutResult;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.api.ITextureShared;
import de.esolutions.graphics.eal.ealFovType_t;
import de.esolutions.graphics.eal.ealLayerPixelFormat_t;
import de.esolutions.graphics.eal.ealPropertyType_t;
import de.esolutions.graphics.eal.ealSize_t;
import de.esolutions.graphics.eal.event_t;
import de.esolutions.graphics.eal.imageOptions_t;
import de.esolutions.graphics.eal.texOptions_t;
import de.esolutions.graphics.eal.utility.CFrameInformation;
import de.esolutions.graphics.eal.utility.COffscreenHelper;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IDisplayControllerWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.SystemProperties;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler;
import de.esolutions.hmi.widgets.audi.base.eal.EALEventListener;
import de.esolutions.hmi.widgets.audi.base.eal.EALException;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$1;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$2;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$DestroyJob;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$EALManagerInfoProvider;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$IdleDestroying;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$IdleRendering;
import de.esolutions.hmi.widgets.audi.base.eal.EALStatistics;
import de.esolutions.hmi.widgets.audi.base.eal.EALViewportsAndLayers;
import de.esolutions.hmi.widgets.audi.base.eal.IBaseWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedManagedNode;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DTextMultiSection;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;
import de.esolutions.hmi.widgets.audi.base.eal.KzbMergeManager;
import de.esolutions.hmi.widgets.audi.base.eal.LRUTextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionAsyncImage;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionByteBuffer;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionDummy;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionGuideImage;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionHMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionOffscreenLayer;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionShared;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedManagedNode;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DTextMultiSection;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3DVisibility;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedViewport;
import de.esolutions.hmi.widgets.audi.base.eal.async.TextureDescriptionManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EALManager
implements IGUIManager,
IWidgetLogChannel,
EALViewportsAndLayers {
    public static final boolean CHECK_SCENEGRAPH_CONSISTENCY = Boolean.getBoolean("checkScenegraphConsistency");
    public static final boolean FONT_LAYOUT_WORKAROUND = SystemProperties.getBoolean("EALEnableFontLayoutWorkaround", true);
    public static final boolean IGNORE_INVALID_EAL_NODES = Boolean.getBoolean("ignoreInvalidEALNodes");
    public static final boolean RTL_ENABLED = SystemProperties.getBoolean("enableRTL", true);
    public static final int CACHE_INDEX_NONE;
    public static final int CACHE_INDEX_GUIDE;
    public static final int CACHE_INDEX_FILES;
    public static final int CACHE_INDEX_STANDARD_CAR;
    public static final int CACHE_INDEX_ASYNC;
    public static final int MAX_STATIC_BITMAPS;
    public static final long TRUNCATION_HEIGHT_MAX;
    public static final long TRUNCATION_WIDTH_MAX;
    public static final String DUMMY_THROWABLE_DESCRIPTION;
    public static final String GLOBAL_PROPERTY_KEY_RTL;
    protected AbstractScreenWidget currentScreen;
    protected HMIService hmiService = null;
    private static final boolean VARIANT_HIGH;
    private static final boolean IGNORE_EAL_STARTUP_ERRORS;
    private static final boolean USE_LONG_NODE_NAMES;
    private static final boolean ACTIVATE_IDLE_DESTROYING;
    private static final boolean SHOW_MEMORY_USAGE;
    private static final boolean SHOW_EVENT_QUEUE_STATISTIC;
    private static final boolean SHOW_SCREEN_INFO;
    private static final boolean SHOW_DRAW_TIME_STATISTIC;
    private static final boolean TEXT_NODE_CACHE_DISABLED;
    private static final boolean TEXTURE_CACHE_DISABLED;
    private static final boolean EAL_OBJECT_TRACER_ENABLED;
    private static final boolean DUMP_EAL_OBJECTS_ON_SCREEN_CHANGE;
    private static final boolean EAL_REGISTRY_ENABLED;
    private static final int MAX_TIME_NODE_DESTROYING;
    private static final int IDLE_DESTROYING_START;
    private static final int MAX_NO_OF_NODES_TO_DESTROY;
    private static final int MEMORY_USAGE_UNIT;
    private static final int[] TEXTURE_CACHE_SIZES_DEFAULTS;
    private static final int[] TEXTURE_CACHE_SIZES;
    private static final int[] TEXTURE_CACHE_TYPES;
    private static final int ICON_LABEL_CACHE_FREE_LEVEL;
    private static final int ICON_LABEL_CACHE_ERROR_LEVEL;
    private static final int MAIN_AREA_DESATURATION_DISABLED;
    private static final int MAIN_AREA_DESATURATION_OFFSCREEN;
    private static final int MAIN_AREA_DESATURATION;
    private static final int ERROR_CORRECTION_DEFAULT;
    private static final int ERROR_CORRECTION_ENABLED;
    private static final int ERROR_CORRECTION;
    private static final int MAX_RECURSIVE_DEPTH_ADDING_CHECK;
    private static final int MAX_NUMBER_OF_IDLE_RENDER_STEPS_FOR_OPS_ASYNC_MERGE;
    private static final int CRITICAL_IMAGE_LOADING_TIME;
    private static final int fontSizesPtFirst;
    private static final int[] FONT_SIZES_PIXEL_H;
    private static final int DUMP_EAL_INFO_EVERY_N_SECONDS;
    private static final int LOW_MEMORY_DUMP_WHILE_TRACING_LEVEL;
    private static final int CACHE_COUNT;
    private static final int DEFAULT_TEXT_COLOR;
    private static final long DELAY_TIME_FOR_IDLE_RENDER_STEPS_FOR_OPS_ASYNC_MERGE;
    private static final float FOV;
    private static final float MAP_DESATURATION_PERCENTAGE;
    private static final float MAP_BRIGHTNESS_PERCENTAGE;
    private static final String GLOBAL_PROPERTIES_SHORTCUT;
    private static final String PROPERTY_NAME_LAYER_MATERIAL;
    private static boolean annotationsEnabled;
    private static boolean partialRenderingEnabled;
    private static boolean partialOffscreenRenderingEnabled;
    private static boolean selectionDrawerMerged;
    private static int ealMemorySize;
    private static int defaultTextureOptions;
    private static long nodeCounter;
    private static Buffer stringBuilder;
    private static IManager manager;
    private static ITextureCache cacheIconLabel;
    private static Map flagImageMap;
    private static Map flagTextureMap;
    private static Map kzbMergeListener;
    private final EALManager$EALManagerInfoProvider dumpInfoProvider;
    private final HMITerminalImpl terminal;
    private final List textNodeCache = new ArrayList();
    private final Map cacheMap = new HashMap();
    private boolean kzbLoadingError;
    private boolean drawMissing = false;
    private boolean screenPainted;
    private boolean wasMapScreen;
    private boolean permanentRenderingStarted;
    private boolean removeNodeBeforeDestroy = SystemProperties.getBoolean("removeNodeBeforeDestroy", false);
    private boolean idleDestroyingEventPosted;
    private boolean opsKzbMerged;
    private boolean opsKzbMergeStarted;
    private short combiInternalApplicationID = 1;
    private int dumpStep = -1;
    private int backgroundImageID = -1;
    private int transparentImageID = -1;
    private int blackImageID = -1;
    private int mmiCombiContextID;
    private int screenWidth;
    private int screenHeight;
    private int previousBkgrImageID = -1;
    private int cacheCounter = 4;
    private int clearMethod = -1;
    private int kdkImageID = -1;
    private long nextDumpTime = 0L;
    private Car3DResourceHandler car3DResourceHandler;
    private CFrameInformation ealFrameInfos;
    private COffscreenHelper offscreenHelper;
    private EALEventListener ealEventListener;
    private EALStatistics statistics;
    private IMaterial clearingMaterial;
    private IMaterial desaturateMaterial;
    private IMaterial desaturateMapMaterial;
    private IMMICombiAnimationSyncer animationSyncer;
    private INode2D visualFeedbackNode;
    private INode2DImage transparentImageNode;
    private INode2DImage blackImageNode;
    private INode2DImage backgroundImageNode;
    private INode2DImage desaturationImage;
    private INode2DImage kdkBackgroundImage;
    private IProject project;
    private IProperty mainAreaDesaturateProperty;
    private IProperty mainAreaMapDesaturateProperty;
    private IProperty mainAreaMapBrightnessProperty;
    private IProperty mainAreaMaterialProperty;
    private IRenderer renderer;
    private IRendererAnnotation annotationRenderer;
    private IWrappedLayer screensLayer;
    private IWrappedLayer optionDrawerLayer;
    private IWrappedLayer optionDrawerClosedLayer;
    private IWrappedLayer selectionDrawerClosedLayer;
    private IWrappedLayer entertainmentDrawerLayer;
    private IWrappedLayer popupsBehindDrawersLayer;
    private IWrappedLayer popupsFrontLayer;
    private IWrappedLayer popupsBetweenLayer;
    private IWrappedLayer screenPartialPopupsLayer;
    private IWrappedLayer unboundPresetPopupLayer;
    private IWrappedLayer statisticsNode;
    private IWrappedManagedNode masterRoot;
    private IWrappedNode3D popupsBehindDrawersMainNode;
    private IWrappedTexture backgroundTexture;
    private IWrappedViewport screensViewport;
    private IWrappedViewport mainViewport;
    private IWrappedViewport popupsBehindDrawersViewport;
    private IWrappedViewport statisticViewport;
    private KzbMergeManager kzbMergeManager;
    private LinkedList nodesToDestroy = new LinkedList();
    private String annotation;
    private volatile boolean permanentRenderingEnabled = Boolean.getBoolean("EnablePermanentRendering");
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IMMICombiAnimationSyncer;

    private void processAsyncKzbLoading() {
        if (this.renderer != null && !this.renderer.render()) {
            logChannel3DEngine.log(10000, "EALManager.IdleRendering#processAsyncKzbLoading render failed");
        }
    }

    public EALManager(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
        this.hmiService = hMITerminalImpl.getFramework().getHMIService();
        boolean bl = hMITerminalImpl.getFramework().getScreenRes() == 4;
        annotationsEnabled = bl && !Boolean.getBoolean("DISABLE_ANNOTATION");
        this.screenWidth = hMITerminalImpl.getLayout().getDistance(1);
        this.screenHeight = hMITerminalImpl.getLayout().getDistance(2);
        if (VARIANT_HIGH) {
            this.car3DResourceHandler = new Car3DResourceHandler(hMITerminalImpl, this);
            logBenchmark.log(-2137614336, "EALManager#<init>: after creating car 3D resource handler");
        }
        this.kzbMergeManager = new KzbMergeManager(this);
        if (IStatisticsManager.INSTRUMENTATION_ENABLED && !IStatisticsManager.INSTRUMENT_RES_LOADING_ON_DEMAND) {
            StatisticsManager.createInstance(hMITerminalImpl.getFramework());
        }
        this.dumpInfoProvider = new EALManager$EALManagerInfoProvider(null);
        AbstractWidget.framework.getErrorMgr().registerDumpInfoProvider(this.dumpInfoProvider);
        logChannel3DEngine.log(-2137614336, "EALManager#<init>: eal texture cache disabled: %1", TEXTURE_CACHE_DISABLED);
        int n = CHECK_SCENEGRAPH_CONSISTENCY ? 10000 : -2137614336;
        logChannel3DEngine.log(n, "EALManager#<init>: CHECK_SCENEGRAPH_CONSISTENCY = %1", CHECK_SCENEGRAPH_CONSISTENCY);
        this.createIconLabelCache();
    }

    private void createIconLabelCache() {
        if (cacheIconLabel == null) {
            cacheIconLabel = this.createLRUCache(32, 64, true);
            if (cacheIconLabel == null) {
                iconLabelLogCh.log(10000, "EALManager#createIconLabelCache Error creating cache.");
            } else {
                iconLabelLogCh.log(-1601830656, "EALManager#createIconLabelCache Texture cache created.");
            }
        }
    }

    public void initializeAnimationSyncTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.terminal.getFramework().getBundleCxt(), (class$de$audi$atip$mmicombi$IMMICombiAnimationSyncer == null ? (class$de$audi$atip$mmicombi$IMMICombiAnimationSyncer = EALManager.class$("de.audi.atip.mmicombi.IMMICombiAnimationSyncer")) : class$de$audi$atip$mmicombi$IMMICombiAnimationSyncer).getName(), (ServiceTrackerCustomizer)new EALManager$1(this));
        serviceTracker.open();
    }

    public void loadLibrary() {
        System.loadLibrary("ealswig");
        logBenchmark.log(-2137614336, "EALManager#loadLibrary after loading library ealswig");
    }

    public static void printTraceOptions() {
        logChannel3DEngine.log(1078071040, "EALManager#printTraceOptions");
        System.out.println("EAL trace options:");
        System.out.print("EALEnableObjectTracer");
        System.out.print('=');
        System.out.println(EAL_OBJECT_TRACER_ENABLED);
        System.out.print("EALEnableRegistry");
        System.out.print('=');
        System.out.println(EAL_REGISTRY_ENABLED);
        System.out.print("EALEnableDumpEveryNSeconds");
        System.out.print('=');
        System.out.println(DUMP_EAL_INFO_EVERY_N_SECONDS);
        System.out.print("EALEnableObjectTracingOnScreenChange");
        System.out.print('=');
        System.out.println(DUMP_EAL_OBJECTS_ON_SCREEN_CHANGE);
        System.out.print("LowMemoryDumpWhileTracingLevel");
        System.out.print('=');
        System.out.println(LOW_MEMORY_DUMP_WHILE_TRACING_LEVEL);
    }

    public void createManager() {
        if (manager != null) {
            logChannel3DEngine.log(1078071040, "EALManager#createManager(): manager already exists");
            return;
        }
        if (EAL_REGISTRY_ENABLED || EAL_OBJECT_TRACER_ENABLED) {
            EALManager.printTraceOptions();
        } else {
            logChannel3DEngine.log(-2137614336, "EALManager#printActivatedTraceOptions object tracer and registry disabled");
        }
        manager = new IManager();
        this.initializeManager();
        logBenchmark.log(-2137614336, "EALManager#createManager manager created");
    }

    protected void initializeManager() {
        int n = Integer.getInteger("ealObjectWarnLimit", 1500);
        if (logChannel3DEngine.isInfo()) {
            logChannel3DEngine.log(1078071040, "EALManager#initializeManager ealObjectWarnLimit: %1", (long)n);
            logChannel3DEngine.log(1078071040, "EALManager#initializeManager ACTIVATE_IDLE_DESTROYING: %1", ACTIVATE_IDLE_DESTROYING);
            logChannel3DEngine.log(1078071040, "EALManager#initializeManager MAX_TIME_NODE_DESTROYING: %1", (long)MAX_TIME_NODE_DESTROYING);
            logChannel3DEngine.log(1078071040, "EALManager#initializeManager IDLE_DESTROYING_START: %1", (long)IDLE_DESTROYING_START);
            logChannel3DEngine.log(1078071040, "EALManager#initializeManager MAX_NO_OF_NODES_TO_DESTROY: %1", (long)MAX_NO_OF_NODES_TO_DESTROY);
            logChannel3DEngine.log(1078071040, "EALManager#initializeManager FONT_LAYOUT_WORKAROUND: %1", FONT_LAYOUT_WORKAROUND);
            logChannel3DEngine.log(1078071040, "EALManager#initializeManager LOW_MEMORY_DUMP_WHILE_TRACING_LEVEL: %1 KB", (long)LOW_MEMORY_DUMP_WHILE_TRACING_LEVEL);
            logChannel3DEngineCache.log(1078071040, "EALManager#initializeManager TEXTURE_CACHE_SIZES: %1", (Object)TEXTURE_CACHE_SIZES);
        }
        manager.setObjectWarnLimit(n);
        int n2 = -2137614336;
        if (EAL_OBJECT_TRACER_ENABLED) {
            n2 = -1601830656;
            manager.setObjectTracer(true);
        }
        logChannel3DEngine.log(n2, "EALManager#initializeManager EAL_OBJECT_TRACER_ENABLED: %1", EAL_OBJECT_TRACER_ENABLED);
        n2 = -2137614336;
        if (EAL_REGISTRY_ENABLED) {
            n2 = -1601830656;
            manager.setRegistry(true);
        }
        logChannel3DEngine.log(n2, "EALManager#initializeManager EAL_REGISTRY_ENABLED: %1", EAL_REGISTRY_ENABLED);
        int n3 = this.terminal.getLayout().getIntegerConstant(64);
        ealMemorySize = Integer.getInteger("ealMemorySize", n3);
        manager.setMemorySize(ealMemorySize * 1024 * 1024);
        logBenchmark.log(-2137614336, "EALManager#initializeManager ealMemorySize: %1 MB", (long)ealMemorySize);
        this.updateContext();
        this.setDefaultTextureOptions();
    }

    private void updateContext() {
        IContext iContext = manager.getContext();
        logBenchmark.log(-2137614336, "EALManager#updateContext: after getting context");
        iContext.setWidth(this.screenWidth);
        iContext.setHeight(this.screenHeight + (annotationsEnabled ? 2 : 0));
        iContext.setDisplayId(0);
        iContext.disableDepthBuffer();
        if (annotationsEnabled && !iContext.setAnnotation(true)) {
            this.handleEALStartupError("Enabling annotations failed");
        }
        iContext.dispose();
    }

    private void setDefaultTextureOptions() {
        defaultTextureOptions = texOptions_t.TEX_OPTIONS_MEMORY_GPU.swigValue();
        defaultTextureOptions |= texOptions_t.TEX_OPTIONS_COMPRESSION_NONE.swigValue();
        defaultTextureOptions |= texOptions_t.TEX_OPTIONS_FILTER_BILINEAR.swigValue();
        defaultTextureOptions |= texOptions_t.TEX_OPTIONS_WRAP_CLAMP.swigValue();
    }

    public void prepareAnnotationRenderer() {
        this.renderer = manager.getRenderer();
        if (!this.renderer.isValid()) {
            this.handleEALStartupError("Renderer is invalid");
        }
        this.annotationRenderer = new IRendererAnnotation(this.renderer);
        if (ERROR_CORRECTION != 0) {
            boolean bl = annotationsEnabled && ERROR_CORRECTION == 1;
            logChannel3DEngine.log(1078071040, "EALManager#startRendering Setting error correction to %1, annotationsEnabled=%2", bl, annotationsEnabled);
            if (!this.annotationRenderer.setErrorCorrection(bl)) {
                logChannel3DEngine.log(-1601830656, "EALManager#startRendering Failed setting error correction");
            }
        }
    }

    public void startManager() {
        if (!manager.start()) {
            this.handleEALStartupError("Starting the 3D-Engine failed");
        } else {
            logBenchmark.log(-2137614336, "EALManager#startManager after starting manager");
        }
    }

    public ITextureCache createLRUCache(int n, int n2) {
        return this.createLRUCache(n, n2, false);
    }

    private ITextureCache createLRUCache(int n, int n2, boolean bl) {
        if (TEXTURE_CACHE_DISABLED) {
            return null;
        }
        int n3 = this.cacheCounter++;
        LRUTextureCache lRUTextureCache = new LRUTextureCache(this, n3, n, n2, false, bl);
        this.cacheMap.put(Util.createInteger(n3), lRUTextureCache);
        return lRUTextureCache;
    }

    public ITextureCache getCache(int n) {
        if (TEXTURE_CACHE_DISABLED || n < 0) {
            return null;
        }
        Integer n2 = Util.createInteger(n);
        if (!this.cacheMap.containsKey(n2) && n < TEXTURE_CACHE_SIZES.length) {
            int n3 = TEXTURE_CACHE_TYPES[n];
            LRUTextureCache lRUTextureCache = new LRUTextureCache(this, n, TEXTURE_CACHE_SIZES[n], TEXTURE_CACHE_SIZES[n] * 2, n3 != 0);
            this.cacheMap.put(n2, lRUTextureCache);
        }
        return (ITextureCache)this.cacheMap.get(n2);
    }

    public void createMasterRoot() {
        this.project = manager.getDefaultProject();
        logBenchmark.log(-2137614336, "EALManager#createMasterRoot after getting default project");
        if (!this.project.isValid()) {
            this.handleEALStartupError("Default project is invalid");
        }
        if (this.masterRoot == null) {
            INode2DManaged iNode2DManaged = new INode2DManaged(this.project, "masterRoot");
            if (!iNode2DManaged.isValid()) {
                logChannel3DEngine.log(10000, "EALManager#createMasterRoot Could not create masterRoot");
                iNode2DManaged.dispose();
                return;
            }
            this.project.setScreenMain(iNode2DManaged);
            logChannel3DEngine.log(1078071040, "EALManager#createMasterRoot partialRenderingEnabled: %1", partialRenderingEnabled);
            logChannel3DEngine.log(1078071040, "EALManager#createMasterRoot partialOffscreenRenderingEnabled: %1", partialOffscreenRenderingEnabled);
            iNode2DManaged.setPartialRendering(partialRenderingEnabled);
            this.masterRoot = new WrappedManagedNode(iNode2DManaged);
        }
        logBenchmark.log(-2137614336, "EALManager#createMasterRoot masterRoot created");
    }

    public void updateGlobalProperties() {
        if (this.masterRoot != null) {
            this.createGlobalProperties(this.masterRoot.getNode());
        }
    }

    private void createGlobalProperties(INode iNode) {
        this.registerNodeShortcut(iNode, "global_properties");
        boolean bl = this.isLTR();
        IProperty iProperty = this.createBooleanProperty(iNode, "global_arabic");
        if (iProperty != null) {
            iProperty.dispose();
        }
        this.setGlobalPropertyFlag("global_arabic", !bl);
    }

    private IProperty createBooleanProperty(INode iNode, String string) {
        if (iNode == null) {
            logChannel3DEngine.log(10000, "EALManager#createBooleanProperty set failed because node is null, key='%1'", (Object)string);
            return null;
        }
        return this.createProperty(iNode, string, ealPropertyType_t.EAL_PROPERTYTYPE_BOOL);
    }

    private IProperty createProperty(INode iNode, String string, ealPropertyType_t ealPropertyType_t2) {
        IProperty iProperty = iNode.getProperty(string, ealPropertyType_t2);
        boolean bl = iProperty.isValid();
        logChannel3DEngine.log(bl ? 1078071040 : 10000, "EALManager#createProperty propertyKey='%1', valid=%2", (Object)string, (Object)bl);
        if (!bl) {
            iProperty.dispose();
            return null;
        }
        return iProperty;
    }

    private boolean registerNodeShortcut(INode iNode, String string) {
        boolean bl = this.project.registerNode(iNode, string);
        logChannel3DEngine.log(bl ? 1078071040 : 10000, "EALManager#registerNodeShortcut register shortcut: '%1': %2", (Object)string, (Object)(bl ? "OK" : "FAILED"));
        return bl;
    }

    public void setGlobalPropertyFlag(String string, boolean bl) {
        logChannel3DEngine.log(1078071040, "EALManager#setGlobalPropertyFlag: setting property %1 to %2", (Object)string, (Object)bl);
        INode2D iNode2D = this.getShortcutNode2D("global_properties");
        if (iNode2D == null) {
            return;
        }
        IProperty iProperty = iNode2D.getProperty(string);
        if (!iProperty.isValid()) {
            logChannel3DEngine.log(-1601830656, "EALManager#setGlobalPropertyFlag: property %1 not found", (Object)string);
            iProperty.dispose();
            iNode2D.dispose();
            return;
        }
        if (!iProperty.set(bl)) {
            logChannel3DEngine.log(10000, "EALManager#setGlobalPropertyFlag: could not set property %1 to %2", (Object)string, (Object)bl);
        }
        iProperty.dispose();
        iNode2D.dispose();
    }

    public void createLayers(Object object) {
        int n = event_t.EVENTTYPE_MERGE_LOADED.swigValue() | event_t.EVENTTYPE_MERGE_MERGED.swigValue();
        this.ealEventListener = new EALEventListener(EALManager.getManager(), new FlagEvent(n));
        logChannel3DEngine.log(-2137614336, "EALManager#createLayers created ealEventListener: %1", (Object)this.ealEventListener.getName());
        boolean bl = false;
        this.screensViewport = this.createViewport("screens", 130, this.screenWidth, this.screenHeight, true, bl);
        this.screensLayer = this.createLayer(this.screensViewport, "screens", 0);
        this.screenPartialPopupsLayer = this.createLayer(this.screensViewport, "screenPartialPopups", 80);
        this.popupsBehindDrawersViewport = this.createViewport("popupsBehindDrawers", 190, this.screenWidth, this.screenHeight, true, bl);
        this.popupsBehindDrawersLayer = this.createLayer(this.popupsBehindDrawersViewport, "popupsBehindDrawers", 0);
        this.popupsBehindDrawersMainNode = this.createNode3D(this.popupsBehindDrawersLayer.getNode(), "popupsBehindDrawersMainNode", this.popupsBehindDrawersLayer.getWidth(), this.popupsBehindDrawersLayer.getHeight(), 0, this.popupsBehindDrawersLayer.getViewport(), true);
        this.mainViewport = this.createViewport("main", 210, this.screenWidth, this.screenHeight, true, bl);
        this.selectionDrawerClosedLayer = this.createLayer(this.mainViewport, "selectionDrawerClosed", 10);
        this.optionDrawerClosedLayer = this.createLayer(this.mainViewport, "optionDrawerClosed", 20);
        this.optionDrawerLayer = this.createLayer(this.mainViewport, "optionDrawer", 30);
        this.popupsBetweenLayer = this.createLayer(this.mainViewport, "popupBetween", 40);
        this.entertainmentDrawerLayer = this.createLayer(this.mainViewport, "entertainmentDrawer", 50);
        this.unboundPresetPopupLayer = this.createLayer(this.mainViewport, "presetPopup", 70);
        this.popupsFrontLayer = this.createLayer(this.mainViewport, "popupsUnboundFront", 60);
        logBenchmark.log(-2137614336, "EALManager#createLayers layer nodes instanciated");
        boolean bl2 = this.isLTR();
        this.setLayersLayout(bl2);
        this.updateTransparentImageNode(object);
        this.updateBlackImageNode(object);
        this.updateBackgroundImageNode(object);
        logBenchmark.log(-2137614336, "EALManager#createLayers: after setting up initial nodes");
    }

    public void setLayersLayout(boolean bl) {
        this.screensLayer.setLayoutDirectionLeftToRight(bl);
        this.optionDrawerLayer.setLayoutDirectionLeftToRight(bl);
        this.selectionDrawerClosedLayer.setLayoutDirectionLeftToRight(bl);
        this.optionDrawerClosedLayer.setLayoutDirectionLeftToRight(bl);
        this.entertainmentDrawerLayer.setLayoutDirectionLeftToRight(bl);
        this.popupsBehindDrawersLayer.setLayoutDirectionLeftToRight(bl);
        this.popupsFrontLayer.setLayoutDirectionLeftToRight(bl);
        this.popupsBetweenLayer.setLayoutDirectionLeftToRight(bl);
        this.unboundPresetPopupLayer.setLayoutDirectionLeftToRight(bl);
        this.screenPartialPopupsLayer.setLayoutDirectionLeftToRight(bl);
        logBenchmark.log(-2137614336, "EALManager#setLayersLayout Layout applied to layers");
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public boolean isPermanentRenderingEnabled() {
        return this.permanentRenderingEnabled;
    }

    public void setPermanentRenderingEnabled(boolean bl) {
        if (bl && !this.permanentRenderingEnabled) {
            this.permanentRenderingEnabled = bl;
            this.hmiService.getEventDispatcher().postEvent(new RunnableEvent(false, new EALManager$IdleRendering(this)));
        }
        this.permanentRenderingEnabled = bl;
    }

    private IWrappedLayer createLayer(IWrappedViewport iWrappedViewport, String string, int n) {
        return this.createLayer(iWrappedViewport, string, n, this.screenWidth, this.screenHeight);
    }

    public IWrappedLayer createLayer(String string, int n, int n2, int n3) {
        boolean bl = true;
        IWrappedViewport iWrappedViewport = this.createViewport(string, n, n2, n3, false, bl);
        return this.createLayer(iWrappedViewport, string, 0, n2, n3);
    }

    public IWrappedLayer createLayer(IWrappedViewport iWrappedViewport, String string, int n, int n2, int n3, int n4) {
        return this.createLayer(iWrappedViewport, string, n, n2, n3);
    }

    private IWrappedLayer createLayer(IWrappedViewport iWrappedViewport, String string, int n, int n2, int n3) {
        String string2 = StringUtility.concatenate(string, "Layer");
        String string3 = StringUtility.concatenate(string, "LTRNode");
        logChannel3DEngineLayersAndViewports.log(-2137614336, "EALManager#createLayer: Creating layer '%1' at index %2", (Object)string2, (long)n);
        IWrappedNode3D iWrappedNode3D = this.createNode3D(null, string2, n2, n3);
        IWrappedNode3D iWrappedNode3D2 = this.createNode3D(iWrappedNode3D, string3, n2, n3, 0, iWrappedViewport, true);
        iWrappedNode3D.setScreenSize(n2, n3);
        iWrappedViewport.getScene().addByIndex(iWrappedNode3D.getNode(), n);
        WrappedLayer wrappedLayer = new WrappedLayer(iWrappedViewport, string2, iWrappedNode3D, iWrappedNode3D2, n2, n3, n);
        iWrappedViewport.addLayer(wrappedLayer);
        return wrappedLayer;
    }

    public IWrappedViewport createViewport(String string, int n, int n2, int n3) {
        return this.createViewport(string, n, n2, n3, true, false);
    }

    private IWrappedViewport createViewport(String string, int n, int n2, int n3, boolean bl, boolean bl2) {
        String string2 = StringUtility.concatenate(string, "Viewport");
        logChannel3DEngineLayersAndViewports.log(-2137614336, "EALManager#createViewport: Creating viewport '%1' at index %2", (Object)string2, (long)n);
        INode3DScene iNode3DScene = new INode3DScene(manager, EALManager.createNodeName("scene", string2));
        INode2DLink iNode2DLink = new INode2DLink(this.project, string2);
        iNode2DLink.setPixelFormat(ealLayerPixelFormat_t.EAL_LAYER_PIXEL_FORMAT_RGBA);
        INode3DCamera iNode3DCamera = new INode3DCamera(manager, EALManager.createNodeName("camera", string2));
        float f2 = -EALManager.getPixelPerfectZ(n2, 13378);
        iNode3DCamera.setPerspective(1.0f, Math.abs(f2 * 2.0f), 13378, ealFovType_t.EAL_FOV_TYPE_VERTICAL);
        int n4 = bl ? 0 : (annotationsEnabled ? 2 : 0);
        Vec3f vec3f = new Vec3f(n2 / 2, (n3 + n4) / 2, f2);
        Vec3f vec3f2 = new Vec3f(n2 / 2, (n3 + n4) / 2, 0.0f);
        Vec3f vec3f3 = new Vec3f(0.0f, 32959, 0.0f);
        iNode3DCamera.lookAt(vec3f, vec3f2, vec3f3);
        iNode3DCamera.setAspectRatio((float)n2 / (float)n3);
        iNode3DScene.add(iNode3DCamera);
        iNode3DCamera.dispose();
        WrappedViewport wrappedViewport = new WrappedViewport(iNode2DLink, string2, iNode3DScene, n2, n3, n, this, bl2);
        this.masterRoot.addViewport(wrappedViewport);
        iNode2DLink.setScene(iNode3DScene, true);
        return wrappedViewport;
    }

    private void handleEALStartupError(String string) {
        if (!IGNORE_EAL_STARTUP_ERRORS) {
            throw new EALException(string);
        }
        logChannel3DEngine.log(10000, "EALManager#initialize: EAL-Error: %1", (Object)string);
    }

    private static float getPixelPerfectZ(float f2, float f3) {
        return f2 / (2.0f * (float)Math.tan((double)f3 * Math.PI / 360.0));
    }

    public Car3DResourceHandler getCar3DResourceHandler() {
        return this.car3DResourceHandler;
    }

    public IKzbMappingHelper getKzbMappingHelper() {
        return this.terminal.getKzbMappingHelper();
    }

    public void setupDesaturation(int n) {
        logChannel3DEngine.log(-2137614336, "EALManager#setupDesaturation, mode=%1", (long)MAIN_AREA_DESATURATION);
        if (MAIN_AREA_DESATURATION == 0) {
            logChannel3DEngine.log(1078071040, "EALManager#setupDesaturation desaturation disabled");
            return;
        }
        if (MAIN_AREA_DESATURATION != 2) {
            logChannel3DEngine.log(10000, "EALManager#setupDesaturation unknown mode %1, desaturation disabled", (long)MAIN_AREA_DESATURATION);
            return;
        }
        IWrappedTexture iWrappedTexture = this.screensLayer.getViewport().enableOffscreen();
        if (iWrappedTexture == null) {
            return;
        }
        this.desaturationImage = new INode2DImage(this.project, "desaturationimage", iWrappedTexture.getTexture());
        if (!this.desaturationImage.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#setupDesaturation: could not create desaturation image");
            this.desaturationImage.dispose();
            this.desaturationImage = null;
            this.setDesaturationEnabled(false);
            return;
        }
        this.masterRoot.addToScreen(this.desaturationImage, 140);
        this.mainAreaMaterialProperty = this.desaturationImage.getProperty("LayerMaterial");
        if (!this.mainAreaMaterialProperty.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#setupDesaturation: property LayerMaterial not found");
            this.setDesaturationEnabled(false);
            return;
        }
        this.desaturateMaterial = this.createMaterial("Prefabs/MaterialLibrary", "Materials/Desaturate/Desaturate", n, -1);
        if (this.desaturateMaterial == null) {
            logChannel3DEngine.log(10000, "EALManager#setupDesaturation: desaturate material is null");
            this.setDesaturationEnabled(false);
            return;
        }
        this.mainAreaDesaturateProperty = this.desaturateMaterial.getProperty("desaturate");
        if (!this.mainAreaDesaturateProperty.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#setupDesaturation: desaturate property not found at material");
            this.setDesaturationEnabled(false);
            this.mainAreaDesaturateProperty.dispose();
            this.mainAreaDesaturateProperty = null;
            this.desaturateMaterial.dispose();
            this.mainAreaMaterialProperty.dispose();
            return;
        }
        this.mainAreaDesaturateProperty.set(0.0f);
        this.desaturateMapMaterial = this.createMaterial("Prefabs/MaterialLibrary", "Materials/MapDesaturate/MapDesaturate", n, -1);
        if (this.desaturateMapMaterial == null) {
            logChannel3DEngine.log(10000, "EALManager#setupDesaturation: MapDesaturate material is null");
            this.setDesaturationEnabled(false);
            return;
        }
        this.mainAreaMapDesaturateProperty = this.desaturateMapMaterial.getProperty("desaturate");
        this.mainAreaMapBrightnessProperty = this.desaturateMapMaterial.getProperty("brightness");
        if (!this.mainAreaMapDesaturateProperty.isValid() || !this.mainAreaMapBrightnessProperty.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#setupDesaturation: desaturate property not found at material");
            this.setDesaturationEnabled(false);
            this.mainAreaMapDesaturateProperty.dispose();
            this.mainAreaMapDesaturateProperty = null;
            this.mainAreaMapBrightnessProperty.dispose();
            this.mainAreaMapBrightnessProperty = null;
            this.desaturateMapMaterial.dispose();
            this.mainAreaMaterialProperty.dispose();
            return;
        }
        this.mainAreaDesaturateProperty.set(0.0f);
        this.setMainAreaMaterial(this.desaturateMaterial);
        logChannel3DEngine.log(-2137614336, "EALManager#setupDesaturation desaturation created");
    }

    @Override
    public void draw() {
        long l = AbstractWidget.framework.getMonotonicTime();
        if (AbstractWidget.framework.isAsia()) {
            this.setGlobalPropertyFlag("global_arabic", !this.isLTR());
        }
        if (!this.renderer.isValid()) {
            throw new EALException("Renderer is invalid");
        }
        if (!this.project.isValid()) {
            throw new EALException("Project is invalid");
        }
        this.appendAnnotation();
        this.drawStatistics();
        boolean bl = false;
        if (!this.screenPainted && this.isContextSwitchNeeded()) {
            this.hmiService.getDisplayManager().lockDisplay(this.terminal.getTerminalID());
            bl = true;
            this.handleContextSwitch();
        }
        this.invalidateOffscreenImage();
        logChannel3DEngine.log(-2137614336, "EALManager#draw before draw");
        boolean bl2 = this.renderer.render(this.project);
        logChannel3DEngine.log(-2137614336, "EALManager#draw after draw");
        if (bl) {
            this.hmiService.getDisplayManager().unlockDisplay(this.terminal.getTerminalID());
        }
        if (!bl2) {
            logChannel3DEngine.log(10000, "EALManager#draw: render project failed");
        }
        this.screenPainted = true;
        if (this.car3DResourceHandler != null && this.car3DResourceHandler.isVisible()) {
            this.car3DResourceHandler.afterDraw();
        }
        this.dumpEALInfo();
        long l2 = AbstractWidget.framework.getMonotonicTime();
        IWidgetLogChannel.logWidgetPerformance.log(1078071040, "EALManager#draw took %1 ms", l2 - l);
    }

    private void dumpEALInfo() {
        if (DUMP_EAL_INFO_EVERY_N_SECONDS <= 0) {
            return;
        }
        if (this.dumpStep < 0) {
            if (!this.ealDumpNeeded()) {
                return;
            }
            this.dumpStep = 0;
        }
        switch (this.dumpStep) {
            case 0: {
                ++this.dumpStep;
                if (EAL_OBJECT_TRACER_ENABLED) {
                    EALManager.dumpEALObjects();
                    return;
                }
            }
            case 1: {
                ++this.dumpStep;
                if (EAL_REGISTRY_ENABLED) {
                    EALManager.dumpEALRegistry();
                    return;
                }
            }
            case 2: {
                long l;
                ++this.dumpStep;
                if (LOW_MEMORY_DUMP_WHILE_TRACING_LEVEL <= 0 || (l = manager.getMemoryRAMFree()) >= (long)(LOW_MEMORY_DUMP_WHILE_TRACING_LEVEL * 1024)) break;
                logChannel3DEngine.log(-1601830656, "EALManager#dumpEALObjects free RAM: %1 Byte", l);
                EALManager.dumpEALMemory();
                return;
            }
        }
        this.dumpStep = -1;
    }

    public void fireRenderEvent() {
        EALManager$2 eALManager$2 = new EALManager$2(this);
        this.hmiService.getEventDispatcher().postEvent(new RunnableEvent(false, eALManager$2));
    }

    private boolean ealDumpNeeded() {
        long l = System.currentTimeMillis();
        if (l < this.nextDumpTime) {
            return false;
        }
        this.nextDumpTime = l + (long)(DUMP_EAL_INFO_EVERY_N_SECONDS * 1000);
        logChannel3DEngine.log(1078071040, "EALManager#ealInfoDumpNeeded");
        return true;
    }

    private void invalidateOffscreenImage() {
        if (!partialRenderingEnabled) {
            return;
        }
        if (this.desaturationImage == null || !this.desaturationImage.isVisible()) {
            return;
        }
        if (!this.screensLayer.isInvalid()) {
            return;
        }
        this.desaturationImage.invalidateObject();
        this.screensLayer.setInvalid(false);
    }

    protected boolean isContextSwitchNeeded() {
        if (this.currentScreen != null) {
            int n = this.hmiService.getDisplayManager().getCurrentContextID(this.terminal.getTerminalID());
            if (n >= 79) {
                n -= 79;
            }
            int n2 = 0;
            IDisplayControllerWidget iDisplayControllerWidget = this.currentScreen.getDisplayController();
            if (iDisplayControllerWidget != null) {
                n2 = iDisplayControllerWidget.getTargetContextID();
            }
            return n != n2;
        }
        return false;
    }

    private void appendAnnotation() {
        int n;
        int n2 = this.mmiCombiContextID;
        String string = "";
        long l = System.currentTimeMillis();
        int n3 = n = this.backgroundImageNode != null && this.backgroundImageNode.isVisible() ? 1 : 0;
        if (this.animationSyncer != null) {
            n2 = this.animationSyncer.getMappedMMICombiContext(this.mmiCombiContextID);
            string = this.animationSyncer.getSyncAnnotation(1);
            this.annotation = this.assembleAnnotation(l, n2, n, string);
            this.annotationRenderer.setData(this.combiInternalApplicationID, this.annotation);
            logChannel3DEngine.log(-2137614336, "EALManager#draw annotation version %2: %1", (Object)this.annotation, 1L);
        }
    }

    private String assembleAnnotation(long l, int n, int n2, String string) {
        Buffer buffer = new Buffer("V");
        buffer.append(1);
        buffer.append("-");
        buffer.append(l);
        buffer.append("|");
        buffer.append(n);
        buffer.append("-");
        buffer.append(n2);
        buffer.append(string);
        return buffer.toString();
    }

    @Override
    public void swapBuffers() {
    }

    private void handleContextSwitch() {
        if (this.currentScreen != null) {
            IDisplayControllerWidget iDisplayControllerWidget = this.currentScreen.getDisplayController();
            if (iDisplayControllerWidget == null) {
                int n = 0;
                AbstractWidget.hmiService.getDisplayManager().switchContext(n, this.terminal.getTerminalID(), null);
            } else {
                iDisplayControllerWidget.prepareAndSwitchToTargetContext();
            }
        }
    }

    public void newScreenConnected(AbstractScreenWidget abstractScreenWidget) {
        if (EAL_OBJECT_TRACER_ENABLED && DUMP_EAL_OBJECTS_ON_SCREEN_CHANGE) {
            Buffer buffer = new Buffer(128);
            buffer.append(this.terminal.getFramework().getMonotonicTime());
            buffer.append("-EALManager#newScreenConnected(");
            buffer.append(abstractScreenWidget.getID());
            buffer.append("): EAL_OBJECT_TRACER [DUMP OBJECTS]!");
            System.out.println(buffer);
            EALManager.dumpEALObjects();
        }
        if (this.isPermanentRenderingEnabled() && !this.permanentRenderingStarted) {
            this.permanentRenderingStarted = true;
            this.hmiService.getEventDispatcher().postEvent(new RunnableEvent(false, new EALManager$IdleRendering(this)));
        }
        this.currentScreen = abstractScreenWidget;
        this.screenPainted = false;
    }

    @Override
    public void readPixels(int[] nArray) {
        IContext iContext = manager.getContext();
        IImage iImage = iContext.getScreenData();
        if (!iImage.isValid()) {
            throw new EALException("Screen data is invalid");
        }
        ByteBuffer byteBuffer = iImage.getData();
        int n = nArray.length * HMIImage.getNumBytesPerPixel(6);
        int n2 = byteBuffer.capacity();
        if (n2 != n) {
            System.out.println("!!!! EALManager::readPixels() actualLength != expectedLength !!!!");
            logChannel3DEngine.log(10000, "Screen data has wrong size. Expected: %1 bytes, actual: %2 bytes", (long)n, (long)n2);
        } else {
            int n3 = 0;
            while (n3 < Math.min(nArray.length, n2 / 4)) {
                nArray[n3] = 255;
                int n4 = n3;
                nArray[n4] = nArray[n4] | (byteBuffer.get() & 0xFF) << 16;
                int n5 = n3;
                nArray[n5] = nArray[n5] | (byteBuffer.get() & 0xFF) << 8;
                int n6 = n3++;
                nArray[n6] = nArray[n6] | byteBuffer.get() & 0xFF;
                byteBuffer.get();
            }
        }
        iContext.dispose();
        iImage.destroy();
        iImage.dispose();
    }

    @Override
    public void setUnsupportedDevelopmentBuild(boolean bl) {
    }

    @Override
    public void doErrorHandling(Exception exception, int n) {
        exception.printStackTrace();
    }

    public static IManager getManager() {
        return manager;
    }

    public IProject getProject() {
        return this.project;
    }

    public HMIImage getHMIImage(int n, int n2) {
        long l = System.currentTimeMillis();
        Object object = this.terminal.getFramework().getHMIService().getImage(n, this.terminal.getTerminalID(), 0, n2);
        long l2 = System.currentTimeMillis();
        if (l2 - l > 0) {
            logChannel.log(1000, "EALManager#getHMIImage(id) took %1ms, screenID = %2", l2 - l, (long)n2);
        }
        return this.convertToHmiImage(object);
    }

    private HMIImage convertToHmiImage(Object object) {
        if (object instanceof HMIImage) {
            return (HMIImage)object;
        }
        if (object instanceof String) {
            logChannel.log(-1601830656, "EALManager#convertToHmiImage returned a string object instead of a HMIImage, using format RGBA");
            return new HMIImage((String)object, 6);
        }
        return null;
    }

    public HMIImage getHMIImage(HMIResourceLocator hMIResourceLocator, int n, boolean bl) {
        long l = System.currentTimeMillis();
        Object object = this.terminal.getImageLoader().loadImage(hMIResourceLocator, bl, n, this.terminal.getTerminalID());
        long l2 = System.currentTimeMillis();
        if (l2 - l > 0) {
            logChannel.log(1000, "EALManager#getHMIImage(resourceLocator) took %1ms, screenID = %2", l2 - l, (long)n);
        }
        return this.convertToHmiImage(object);
    }

    private void destroyNode(INode iNode, boolean bl) {
        if (iNode == null) {
            return;
        }
        if (iNode.isDisposed()) {
            logChannel3DEngine.log(10000, "EALManager#destroyNode: node is already disposed");
            return;
        }
        if (iNode.isDeleted()) {
            logChannel3DEngine.log(10000, "EALManager#destroyNode: node is already deleted");
            return;
        }
        if (ACTIVATE_IDLE_DESTROYING) {
            iNode.setVisible(false);
            if (this.nodesToDestroy.size() > MAX_NO_OF_NODES_TO_DESTROY) {
                EALManager$DestroyJob eALManager$DestroyJob = (EALManager$DestroyJob)this.nodesToDestroy.removeFirst();
                this.destroyNodeIndeed(eALManager$DestroyJob.getNode(), eALManager$DestroyJob.isRecursive());
                this.nodesToDestroy.addLast(new EALManager$DestroyJob(iNode, bl));
                return;
            }
            this.nodesToDestroy.addLast(new EALManager$DestroyJob(iNode, bl));
            if (this.nodesToDestroy.size() > IDLE_DESTROYING_START && !this.idleDestroyingEventPosted) {
                this.idleDestroyingEventPosted = true;
                this.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, new EALManager$IdleDestroying(this, null)));
            }
        } else {
            this.destroyNodeIndeed(iNode, bl);
        }
    }

    private void destroyNodeIndeed(INode iNode, boolean bl) {
        if (iNode.isValid()) {
            boolean bl2;
            if (logChannel3DEngine.isDebug()) {
                logChannel3DEngine.log(-2137614336, "EALManager#destroyNode: Destroying node '%1', recursive=%2", (Object)iNode.getName(), (Object)bl);
            }
            if (logChannel3DEngineDestroy.isInfo()) {
                String string = iNode.getName();
                long l = AbstractWidget.framework.getMonotonicTime();
                bl2 = IFactory.destroy(iNode, bl);
                long l2 = AbstractWidget.framework.getMonotonicTime();
                long l3 = l2 - l;
                logChannel3DEngineDestroy.log(1078071040, "EALManager#destroyNode time to destroy node: time=%3ms, recursive=%2, name=%1", (Object)string, (Object)bl, l3);
            } else {
                bl2 = IFactory.destroy(iNode, bl);
            }
            if (!bl2) {
                logChannel3DEngine.log(10000, "EALManager#destroyNode: Could not destroy node", new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            }
            iNode.dispose();
        } else {
            logChannel3DEngine.log(10000, "EALManager#destroyNode: node is already invalid");
        }
    }

    public void processIdleDestroying() {
        long l = System.currentTimeMillis();
        while (!this.nodesToDestroy.isEmpty()) {
            if (this.nodesToDestroy.size() < MAX_NO_OF_NODES_TO_DESTROY && ((AbstractAnimationController)this.terminal.getIAnimationController()).isAnimationRunning()) {
                return;
            }
            EALManager$DestroyJob eALManager$DestroyJob = (EALManager$DestroyJob)this.nodesToDestroy.removeFirst();
            this.destroyNodeIndeed(eALManager$DestroyJob.getNode(), eALManager$DestroyJob.isRecursive());
            if (System.currentTimeMillis() - l <= (long)MAX_TIME_NODE_DESTROYING) continue;
            if (((AbstractAnimationController)this.terminal.getIAnimationController()).isAnimationRunning() || this.hmiService.getEventDispatcher().peekEvent() != null) {
                return;
            }
            try {
                Thread.sleep(0);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            if (this.hmiService.getEventDispatcher().peekEvent() != null) {
                return;
            }
            l = System.currentTimeMillis();
        }
    }

    public void destroy(IWrappedNode3D iWrappedNode3D) {
        IWrappedNode3D iWrappedNode3D2;
        if (iWrappedNode3D == null) {
            return;
        }
        IWrappedNode3D iWrappedNode3D3 = iWrappedNode3D.getParent();
        if (iWrappedNode3D3 != null) {
            if (this.removeNodeBeforeDestroy || !TEXT_NODE_CACHE_DISABLED && iWrappedNode3D instanceof IWrappedNode3DText) {
                if (!iWrappedNode3D3.remove(iWrappedNode3D)) {
                    logChannel3DEngine.log(10000, "EALManager#destroy Could not remove '%1' from '%2'", (Object)iWrappedNode3D3, (Object)iWrappedNode3D);
                }
            } else {
                iWrappedNode3D3.removeWrappedChild(iWrappedNode3D);
            }
        }
        if (iWrappedNode3D instanceof IWrappedNode3DText) {
            iWrappedNode3D2 = (IWrappedNode3DText)iWrappedNode3D;
            if (!TEXT_NODE_CACHE_DISABLED) {
                this.insertTextNodeInCache((IWrappedNode3DText)iWrappedNode3D2);
                return;
            }
        }
        if (iWrappedNode3D instanceof IWrappedNode3DImage) {
            iWrappedNode3D2 = (IWrappedNode3DImage)iWrappedNode3D;
            iWrappedNode3D2.releaseTexture();
        }
        iWrappedNode3D.dispose();
        boolean bl = iWrappedNode3D.setDestroyedFlag();
        if (bl) {
            this.destroyNode(iWrappedNode3D.getNode(), iWrappedNode3D.isInstance());
        }
    }

    public void destroy(IWrappedTexture iWrappedTexture) {
        if (iWrappedTexture == null) {
            return;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#destroy: destroying texture %1", (Object)iWrappedTexture);
        TextureDescriptionManager.getInstance().removeTextureDescription(iWrappedTexture.getDescription());
        ITexture iTexture = iWrappedTexture.getTexture();
        this.destroy(iTexture);
    }

    public void destroy(IWrappedLayer iWrappedLayer) {
        if (iWrappedLayer == null) {
            return;
        }
        if (logChannel3DEngineLayersAndViewports.isDebug()) {
            logChannel3DEngineLayersAndViewports.log(-2137614336, "EALManager#destroy: destroying layer %1", (Object)iWrappedLayer);
        }
        this.destroy(iWrappedLayer.getNode());
        this.destroy(iWrappedLayer.getMainNode());
        IWrappedViewport iWrappedViewport = iWrappedLayer.getViewport();
        iWrappedViewport.removeLayer(iWrappedLayer);
        if (iWrappedViewport.getLayerCount() == 0 && iWrappedViewport.isAutomaticallyCreated()) {
            logChannel3DEngineLayersAndViewports.log(-2137614336, "EALManager#destroy: last layer of viewport destroyed, destroying viewport %1", (Object)iWrappedViewport);
            this.destroy(iWrappedViewport);
        }
    }

    public void destroy(IWrappedViewport iWrappedViewport) {
        if (iWrappedViewport == null) {
            return;
        }
        if (logChannel3DEngineLayersAndViewports.isDebug()) {
            logChannel3DEngineLayersAndViewports.log(-2137614336, "EALManager#destroy: destroying viewport %1", (Object)iWrappedViewport);
        }
        iWrappedViewport.disableOffscreen();
        iWrappedViewport.destroyTexture();
        iWrappedViewport.getScene().dispose();
        this.masterRoot.remove(iWrappedViewport);
        INode2DLink iNode2DLink = iWrappedViewport.getLink();
        if (iNode2DLink != null) {
            this.destroyNode(iNode2DLink, true);
        }
    }

    public void destroy(IWrappedFont iWrappedFont) {
        if (iWrappedFont == null) {
            return;
        }
        IFontGroup iFontGroup = iWrappedFont.getFontGroup();
        if (iFontGroup != null) {
            if (!iFontGroup.isDeleted()) {
                iFontGroup.destroy();
            }
            if (!iFontGroup.isDisposed()) {
                iFontGroup.dispose();
            }
        }
        this.destroy(iWrappedFont.getLayout());
    }

    public void destroy(IObject iObject) {
        if (iObject == null) {
            return;
        }
        if (iObject.isDeleted()) {
            logChannel3DEngine.log(10000, "EALManager#destroyIObject: already deleted: %1", (Object)super.getClass(), new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            return;
        }
        if (iObject.isDisposed()) {
            logChannel3DEngine.log(10000, "EALManager#destroyIObject: already disposed: %1", (Object)super.getClass(), new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            return;
        }
        if (!iObject.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#destroyIObject: already invalid: %1", (Object)super.getClass(), new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            return;
        }
        if (iObject instanceof ITexture) {
            ITexture iTexture = (ITexture)iObject;
            boolean bl = false;
            if (IWidgetLogChannel.logChannel3DEngineTextureDestroyCheck.isDebug() && iTexture.testIfReferenced()) {
                logChannel3DEngineTextureDestroyCheck.log(10000, "EALManager#destroyIObject not destroying texture because it is still referenced: %1", (Object)iTexture, new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
                bl = true;
            }
            logChannel3DEngine.log(-2137614336, "EALManager#destroyIObject: destroy texture %1", (Object)iTexture);
            if (!(bl || iTexture.destroy() || iTexture instanceof ITextureShared)) {
                logChannel3DEngine.log(10000, "EALManager#destroyIObject: texture %1 could not be destroyed", (Object)iTexture, new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            }
        } else if (iObject instanceof IImage) {
            IImage iImage = (IImage)iObject;
            logChannel3DEngine.log(-2137614336, "EALManager#destroyIObject: destroy image %1", (Object)iImage);
            if (!iImage.destroy()) {
                logChannel3DEngine.log(10000, "EALManager#destroyIObject: image %1 could not be destroyed", (Object)iImage, new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            }
        } else if (iObject instanceof ITextLayout) {
            ITextLayout iTextLayout = (ITextLayout)iObject;
            logChannel3DEngine.log(-2137614336, "EALManager#destroyIObject: destroy text-layout %1", (Object)iTextLayout);
            if (!iTextLayout.destroy()) {
                logChannel3DEngine.log(10000, "EALManager#destroyIObject: text-layout %1 could not be destroyed", (Object)iTextLayout, new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            }
        } else {
            if (iObject instanceof INode) {
                this.destroyNode((INode)iObject, false);
                return;
            }
            if (!(iObject instanceof IProperty)) {
                logChannel3DEngine.log(10000, "EALManager#destroyIObject: unknown object type; %1 will not be destroyed", (Object)iObject, new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            }
        }
        logChannel3DEngine.log(-2137614336, "EALManager#destroyIObject: dispose object %1", (Object)iObject);
        iObject.dispose();
    }

    public IWrappedNode3DText createText3D(IWrappedNode3D iWrappedNode3D, String string, String string2, IWrappedFont iWrappedFont) {
        return this.createText3D(iWrappedNode3D, string, string2, iWrappedFont, 0);
    }

    public IWrappedNode3DText createText3D(IWrappedNode3D iWrappedNode3D, String string, String string2, IWrappedFont iWrappedFont, int n) {
        return (IWrappedNode3DText)this.createText3D(true, iWrappedNode3D, string, string2, iWrappedFont, n);
    }

    public IWrappedNode3DTextMultiSection createText3DMultiSection(IWrappedNode3D iWrappedNode3D, String string, String string2, IWrappedFont iWrappedFont, int n) {
        return (IWrappedNode3DTextMultiSection)this.createText3D(false, iWrappedNode3D, string, string2, iWrappedFont, n);
    }

    private IBaseWrappedNode3DText createText3D(boolean bl, IWrappedNode3D iWrappedNode3D, String string, String string2, IWrappedFont iWrappedFont, int n) {
        long l = this.terminal.getFramework().getMonotonicTime();
        logChannel3DEngine.log(-2137614336, "EALManager#createText3D: nodeName: '%1', text: %2", (Object)string, (Object)string2);
        if (iWrappedNode3D != null && !iWrappedNode3D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createText3D: parent node is invalid for new text node '%1', text: %2", (Object)string, (Object)string2, (Object)new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            return null;
        }
        if (string == null) {
            logChannel3DEngine.log(10000, "EALManager#createText3D: Name must not be null for text node with text: %1", (Object)string2, new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            return null;
        }
        if (iWrappedFont == null) {
            logChannel3DEngine.log(10000, "EALManager#createText3D: Font must not be null for text node '%1' with text: %2", (Object)string, (Object)string2, (Object)new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
        }
        if (string2 == null) {
            string2 = "";
        }
        IBaseWrappedNode3DText iBaseWrappedNode3DText = this.getWrapped3DTextNode(bl, string, string2, iWrappedFont, n);
        if (iWrappedNode3D != null) {
            iWrappedNode3D.add(iBaseWrappedNode3DText);
        }
        if (logChannel3DEngine.isDebug()) {
            long l2 = this.terminal.getFramework().getMonotonicTime() - l;
            logChannel3DEngine.log(-2137614336, "EALManager#createText3D: returning text node, time: %1ms", l2);
        }
        return iBaseWrappedNode3DText;
    }

    private IBaseWrappedNode3DText getWrapped3DTextNode(boolean bl, String string, String string2, IWrappedFont iWrappedFont, int n) {
        IBaseWrappedNode3DText iBaseWrappedNode3DText;
        IWrappedNode3DText iWrappedNode3DText;
        IWrappedNode3DText iWrappedNode3DText2 = iWrappedNode3DText = TEXT_NODE_CACHE_DISABLED || !bl ? null : this.getCachedTextNode();
        if (iWrappedNode3DText == null) {
            if (!this.project.isValid()) {
                logChannel3DEngine.log(10000, "EALManager#createText3D: project is invalid for new text node '%1', text: %2", (Object)string, (Object)string2);
                return null;
            }
            logChannel3DEngine.log(-2137614336, "EALManager#createText3D: create new text node '%1'", (Object)string);
            iBaseWrappedNode3DText = this.createNewIWrappedNode3DText(bl, string, string2, iWrappedFont, n);
        } else {
            iWrappedNode3DText.setNodeName(string);
            iWrappedNode3DText.setText(string2, iWrappedFont);
            iWrappedNode3DText.resetTransformation();
            iWrappedNode3DText.setColor(DEFAULT_TEXT_COLOR);
            iWrappedNode3DText.setNodeIndex(n);
            iBaseWrappedNode3DText = iWrappedNode3DText;
            if (logChannel3DEngine.isDebug()) {
                logChannel3DEngine.log(-2137614336, "EALManager#createText3D: returning cached text node '%1'", (Object)iBaseWrappedNode3DText.getNode().getName());
            }
        }
        return iBaseWrappedNode3DText;
    }

    private IBaseWrappedNode3DText createNewIWrappedNode3DText(boolean bl, String string, String string2, IWrappedFont iWrappedFont, int n) {
        iWrappedFont.getFontGroup().activate();
        INode3DText iNode3DText = new INode3DText(this.project, string, iWrappedFont.getLayout(), string2);
        if (!IGNORE_INVALID_EAL_NODES && !iNode3DText.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createIWrappedNode3DText: can't create INode3DText '%1', with font: %3, text: %2", (Object)string, (Object)string2, (Object)iWrappedFont);
            iNode3DText.dispose();
            return null;
        }
        AbstractWrappedNode3DText abstractWrappedNode3DText = bl ? new WrappedNode3DText(iNode3DText, iNode3DText.getInterfaceText(), string2, iWrappedFont, n, this, this.isLTR()) : new WrappedNode3DTextMultiSection(iNode3DText, iNode3DText.getInterfaceText(), string2, iWrappedFont, n, this, this.isLTR());
        abstractWrappedNode3DText.resetTransformation();
        return abstractWrappedNode3DText;
    }

    public IWrappedNode3DQuickDraw createQuickDrawNode3D(IWrappedNode3D iWrappedNode3D, String string, int n, int n2, int n3) {
        long l = this.terminal.getFramework().getMonotonicTime();
        logChannel3DEngine.log(-2137614336, "EALManager#createQuickDrawNode3D: nodeName '%1'", (Object)string);
        if (iWrappedNode3D != null && !iWrappedNode3D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createQuickDrawNode3D: Parent node is invalid for new image node '%1'", (Object)string);
            return null;
        }
        if (!this.project.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createQuickDrawNode3D: Project is invalid for new image node '%1'", (Object)string);
            return null;
        }
        long l2 = this.terminal.getFramework().getMonotonicTime();
        INode3DQuickDraw iNode3DQuickDraw = new INode3DQuickDraw(this.project, string, n, n2);
        long l3 = this.terminal.getFramework().getMonotonicTime() - l2;
        logChannel3DEngine.log(-2137614336, "Time to create image node: %1ms", l3);
        if (!iNode3DQuickDraw.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createQuickDrawNode3D: Could not create image node '%1'", (Object)string);
            iNode3DQuickDraw.dispose();
            return null;
        }
        WrappedNode3DQuickDraw wrappedNode3DQuickDraw = new WrappedNode3DQuickDraw(iNode3DQuickDraw, n, n2, n3, this.isLTR());
        wrappedNode3DQuickDraw.resetTransformation();
        if (iWrappedNode3D != null) {
            iWrappedNode3D.add(wrappedNode3DQuickDraw);
        }
        wrappedNode3DQuickDraw.setPosition(0.0f, 0.0f, 0.0f);
        logChannel3DEngine.log(-2137614336, "EALManager#createQuickDrawNode3D: Returning image node '%1', time: %2ms", (Object)string, this.terminal.getFramework().getMonotonicTime() - l);
        return wrappedNode3DQuickDraw;
    }

    public IWrappedNode3DImage createImage3D(IWrappedNode3D iWrappedNode3D, String string, TextureDescription textureDescription, int n, boolean bl, Object object) {
        if (textureDescription == null) {
            logChannel3DEngine.log(1078071040, "EALManager#createImage3D: description is null");
            return null;
        }
        long l = this.terminal.getFramework().getMonotonicTime();
        IWrappedTexture iWrappedTexture = textureDescription.getTexture(object);
        if (iWrappedTexture == null) {
            logChannel3DEngine.log(10000, "EALManager#createImage3D: Could not create texture from description '%1'", (Object)textureDescription);
            return null;
        }
        INode3DImage iNode3DImage = new INode3DImage(this.project, string, iWrappedTexture.getTexture());
        long l2 = this.terminal.getFramework().getMonotonicTime() - l;
        logChannel3DEngine.log(-2137614336, "EALManager#createImage3D: Time to create image node: %1ms", l2);
        if (!iNode3DImage.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createImage3D: Could not create image node '%1', texture description '%2'", (Object)string, (Object)textureDescription);
            iNode3DImage.dispose();
            iWrappedTexture.releaseTexture(true, object);
            return null;
        }
        WrappedNode3DImage wrappedNode3DImage = new WrappedNode3DImage(iNode3DImage, n, iWrappedTexture, bl, object, this.isLTR());
        if (iWrappedNode3D != null) {
            iWrappedNode3D.add(wrappedNode3DImage);
        }
        return wrappedNode3DImage;
    }

    public IWrappedNode3DImage createImage3D(IWrappedNode3D iWrappedNode3D, String string, IWrappedTexture iWrappedTexture, int n, boolean bl, Object object) {
        long l = this.terminal.getFramework().getMonotonicTime();
        INode3DImage iNode3DImage = new INode3DImage(this.project, string, iWrappedTexture.getTexture());
        long l2 = this.terminal.getFramework().getMonotonicTime() - l;
        logChannel3DEngine.log(-2137614336, "EALManager#createImage3D: Time to create image node: %1ms", l2);
        if (!iNode3DImage.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createImage3D: Could not create image node '%1', texture '%2'", (Object)string, (Object)iWrappedTexture);
            iNode3DImage.dispose();
            return null;
        }
        WrappedNode3DImage wrappedNode3DImage = new WrappedNode3DImage(iNode3DImage, n, iWrappedTexture, bl, object, this.isLTR());
        if (iWrappedNode3D != null) {
            iWrappedNode3D.add(wrappedNode3DImage);
        }
        return wrappedNode3DImage;
    }

    public IWrappedNode3DImage createImage3D(IWrappedNode3D iWrappedNode3D, String string, HMIImage hMIImage, Object object) {
        TextureDescription textureDescription = this.createTextureDescription(hMIImage, null, false);
        return this.createImage3D(iWrappedNode3D, string, textureDescription, 0, true, object);
    }

    public ITextureShared createSharedTexture(String string, int n, int n2) {
        ITextureShared iTextureShared = new ITextureShared(this.project, string, n, n2);
        if (!iTextureShared.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createSharedTexture: could not create shared texture with name %1", (Object)string);
            iTextureShared.dispose();
            return null;
        }
        return iTextureShared;
    }

    public TextureDescription createTextureDescription(int n, boolean bl, int n2) {
        return this.createTextureDescription(n, bl, n2, false);
    }

    public TextureDescription createTextureDescriptionAsync(int n, boolean bl, int n2) {
        return this.createTextureDescription(n, bl, n2, true);
    }

    private TextureDescription createTextureDescription(int n, boolean bl, int n2, boolean bl2) {
        if (TEXTURE_CACHE_DISABLED) {
            return this.getTextureDescription(n, bl, n2, bl2);
        }
        TextureDescription textureDescription = TextureDescriptionManager.getInstance().getCachedTextureDescription(n);
        if (textureDescription != null) {
            return textureDescription;
        }
        textureDescription = this.getTextureDescription(n, bl, n2, bl2);
        return TextureDescriptionManager.getInstance().put(textureDescription);
    }

    private TextureDescription getTextureDescription(int n, boolean bl, int n2, boolean bl2) {
        if (bl2) {
            return new TextureDescriptionAsyncImage(this, n, bl, n2);
        }
        return new TextureDescriptionGuideImage(this, n, bl, n2);
    }

    public TextureDescription createTextureDescription(HMIImage hMIImage, ITextureCache iTextureCache, boolean bl) {
        return this.createTextureDescription(hMIImage, iTextureCache, bl, false);
    }

    public TextureDescription createTextureDescriptionAsync(HMIImage hMIImage, ITextureCache iTextureCache, boolean bl) {
        return this.createTextureDescriptionAsync(hMIImage, iTextureCache, bl, false);
    }

    public TextureDescription createTextureDescription(HMIImage hMIImage, ITextureCache iTextureCache, boolean bl, boolean bl2) {
        return this.createTextureDescription(hMIImage, iTextureCache, bl, bl2, false);
    }

    public TextureDescription createTextureDescriptionAsync(HMIImage hMIImage, ITextureCache iTextureCache, boolean bl, boolean bl2) {
        return this.createTextureDescription(hMIImage, iTextureCache, bl, bl2, true);
    }

    private TextureDescription createTextureDescription(HMIImage hMIImage, ITextureCache iTextureCache, boolean bl, boolean bl2, boolean bl3) {
        if (iTextureCache == null || iTextureCache.getCacheId() >= 4 || TEXTURE_CACHE_DISABLED) {
            return this.getTextureDescription(hMIImage, iTextureCache, bl, bl2, bl3);
        }
        if (hMIImage.getPath() == null) {
            return null;
        }
        TextureDescription textureDescription = TextureDescriptionManager.getInstance().getCachedTextureDescription(hMIImage);
        if (textureDescription != null) {
            return textureDescription;
        }
        textureDescription = this.getTextureDescription(hMIImage, iTextureCache, bl, bl2, bl3);
        return TextureDescriptionManager.getInstance().put(textureDescription);
    }

    private TextureDescription getTextureDescription(HMIImage hMIImage, ITextureCache iTextureCache, boolean bl, boolean bl2, boolean bl3) {
        if (bl3) {
            return new TextureDescriptionAsyncImage(this, iTextureCache, hMIImage, bl, bl2);
        }
        return new TextureDescriptionHMIImage(this, hMIImage, iTextureCache, bl, bl2);
    }

    public TextureDescription createTextureDescription(IWrappedViewport iWrappedViewport) {
        return new TextureDescriptionOffscreenLayer(iWrappedViewport, EALManager.getImageFlags(6));
    }

    public TextureDescription createTextureDescription(String string, int n, int n2) {
        return new TextureDescriptionShared(this, string, n, n2);
    }

    public TextureDescription createTextureDescription(ByteBuffer byteBuffer, int n, int n2, int n3, ITextureCache iTextureCache, Object object) {
        return new TextureDescriptionByteBuffer(this, byteBuffer, n, n2, n3, iTextureCache, object);
    }

    public IWrappedTexture getWrappedTexture(ITexture iTexture) {
        TextureDescriptionDummy textureDescriptionDummy = new TextureDescriptionDummy(iTexture);
        return new WrappedTexture(iTexture, textureDescriptionDummy, this);
    }

    public IWrappedTexture getTexture(TextureDescription textureDescription, Object object) {
        if (textureDescription == null) {
            return null;
        }
        logChannel3DEngineCache.log(1078071040, "EALManager#getTexture: description='%1'", (Object)textureDescription);
        ITextureCache iTextureCache = textureDescription.getCache();
        if (iTextureCache == null) {
            return textureDescription.createTexture();
        }
        return iTextureCache.getTexture(textureDescription, object);
    }

    @Override
    public int[] getImageHeaderInformation(String string) {
        int[] nArray = new int[2];
        ealSize_t ealSize_t2 = IImage.getImageInfo(string);
        nArray[0] = (int)ealSize_t2.getWidth();
        nArray[1] = (int)ealSize_t2.getHeight();
        return nArray;
    }

    public ITexture createTexture(IImage iImage, FlagTexture flagTexture) {
        ITexture iTexture = new ITexture(this.project, iImage, flagTexture);
        if (!iTexture.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createTexture could not create texture from image");
            iTexture.dispose();
            return null;
        }
        return iTexture;
    }

    public int releaseTexture(IWrappedTexture iWrappedTexture, boolean bl, Object object) {
        if (iWrappedTexture == null) {
            return -1;
        }
        logChannel3DEngineCache.log(1078071040, "EALManager#releaseTexture: texture='%1'", (Object)iWrappedTexture);
        TextureDescription textureDescription = iWrappedTexture.getDescription();
        ITextureCache iTextureCache = textureDescription.getCache();
        if (iTextureCache == null) {
            if (bl) {
                this.destroy(iWrappedTexture);
                return 2;
            }
            return 1;
        }
        if (!iTextureCache.release(iWrappedTexture, object)) {
            logChannel3DEngineCache.log(10000, "EALManager#releaseTexture: could not release texture='%1'", (Object)iWrappedTexture);
            return -1;
        }
        return 1;
    }

    public IImage createEALImage(HMIImage hMIImage) {
        return this.createEALImage(hMIImage, -1, -1);
    }

    public IImage createEALImage(HMIImage hMIImage, int n, int n2) {
        logChannel3DEngine.log(-2137614336, "EALManager#createEALImage: image path: '%1'", (Object)hMIImage);
        if (hMIImage == null || hMIImage.getPath() == null) {
            logChannel3DEngine.log(10000, "EALManager#createEALImage: Image path may not be null");
            return null;
        }
        long l = this.terminal.getFramework().getMonotonicTime();
        FlagImage flagImage = EALManager.getImageFlags(hMIImage.getFormat());
        IImage iImage = null;
        iImage = n < 1 || n2 < 1 ? new IImage(manager, hMIImage.getPath(), flagImage) : new IImage(manager, hMIImage.getPath(), flagImage, (long)n, n2);
        long l2 = this.terminal.getFramework().getMonotonicTime() - l;
        logChannel3DEngine.log(-2137614336, "Time to create image: %1ms", l2);
        if (!iImage.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createEALImage: Could not create image, image path '%1'", (Object)hMIImage);
            iImage.dispose();
            return null;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#createEALImage: New IImage '%1' created", (Object)hMIImage);
        return iImage;
    }

    IImage createEALImage(ByteBuffer byteBuffer, int n, int n2, int n3) {
        logChannel3DEngine.log(-2137614336, "EALManager#createEALImage: via nioBuffer, width = %1, height = %2", (long)n2, (long)n3);
        if (byteBuffer == null) {
            logChannel3DEngine.log(10000, "EALManager#createEALImage: nioBuffer may not be null");
            return null;
        }
        if (byteBuffer.capacity() < n2 * n3 * HMIImage.getNumBytesPerPixel(n)) {
            logChannel3DEngine.log(10000, "EALManager#createEALImage: nioBuffer capacity not sufficient");
            return null;
        }
        long l = this.terminal.getFramework().getMonotonicTime();
        FlagImage flagImage = EALManager.getImageFlags(n);
        IImage iImage = new IImage(manager, byteBuffer, n2, (long)n3, flagImage);
        long l2 = this.terminal.getFramework().getMonotonicTime() - l;
        logChannel3DEngine.log(-2137614336, "Time to create image from nioBuffer: %1ms", l2);
        if (!iImage.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createEALImage: Could not create image via nioBuffer");
            iImage.dispose();
            return null;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#createEALImage: New IImage from nioBuffer created");
        return iImage;
    }

    ITexture createEALTexture(IImage iImage, HMIImage hMIImage, boolean bl) {
        logChannel3DEngine.log(-2137614336, "EALManager#createEALTexture: image path: '%1', ealAtlas: %2", (Object)hMIImage, (Object)bl);
        long l = this.terminal.getFramework().getMonotonicTime();
        long l2 = this.terminal.getFramework().getMonotonicTime() - l;
        FlagTexture flagTexture = EALManager.getTextureFlags(hMIImage.getFormat(), bl);
        ITexture iTexture = new ITexture(this.project, iImage, flagTexture);
        logChannel3DEngine.log(-2137614336, "Time to create texture: %1ms", l2);
        if (!iTexture.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createEALTexture: Could not create texture, image path '%1'", (Object)hMIImage);
            iTexture.dispose();
            return null;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#createEALTexture: New ITexture '%1' created", (Object)hMIImage);
        return iTexture;
    }

    private IWrappedNode3DText getCachedTextNode() {
        if (TEXT_NODE_CACHE_DISABLED) {
            return null;
        }
        int n = this.textNodeCache.size();
        if (n == 0) {
            return null;
        }
        return (IWrappedNode3DText)this.textNodeCache.remove(n - 1);
    }

    private void insertTextNodeInCache(IWrappedNode3DText iWrappedNode3DText) {
        this.textNodeCache.add(iWrappedNode3DText);
        logChannel3DEngine.log(-2137614336, "EALManager#insertTextNodeInCache: store text node in cache, text cache size: %1", (long)this.textNodeCache.size());
    }

    public IWrappedNode3D createNode3D(IWrappedNode3D iWrappedNode3D, String string, float f2, float f3) {
        return this.createNode3D(iWrappedNode3D, string, f2, f3, 0);
    }

    public IWrappedNode3D createNode3D(IWrappedNode3D iWrappedNode3D, String string, float f2, float f3, int n) {
        return this.createNode3D(iWrappedNode3D, string, f2, f3, n, null, false);
    }

    public IWrappedNode3D createNode3D(IWrappedNode3D iWrappedNode3D, String string, float f2, float f3, int n, IWrappedViewport iWrappedViewport, boolean bl) {
        Object object;
        long l = this.terminal.getFramework().getMonotonicTime();
        if (logChannel3DEngine.isDebug()) {
            object = iWrappedNode3D == null ? null : iWrappedNode3D.getNode().getName();
            logChannel3DEngine.log(-2137614336, "EALManager#createNode3D: nodeName: %1 parentNode: %2", (Object)string, object);
        }
        if (iWrappedNode3D != null && !iWrappedNode3D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createNode3D: parent node is invalid for new node '%1'", (Object)string);
            return null;
        }
        if (string == null) {
            throw new IllegalArgumentException("Name must not be null for new node");
        }
        if (!this.project.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createNode3D: project is invalid for new node '%1'", (Object)string);
            return null;
        }
        object = new INode3D(manager, string);
        if (!((INode)object).isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createNode3D: can't create node '%1'", (Object)string);
            ((INode3D)object).dispose();
            return null;
        }
        WrappedNode3D wrappedNode3D = bl ? new WrappedNode3DVisibility((INode3D)object, f2, f3, false, n, iWrappedViewport, this.isLTR()) : new WrappedNode3D((INode3D)object, f2, f3, false, n, this.isLTR());
        wrappedNode3D.resetTransformation();
        if (iWrappedNode3D != null) {
            iWrappedNode3D.add(wrappedNode3D);
        } else {
            logChannel3DEngine.log(-2137614336, "EALManager#createNode3D: parent node is null for new node '%1'", (Object)string);
        }
        wrappedNode3D.setPosition(0.0f, 0.0f, 0.0f);
        if (logChannel3DEngine.isDebug()) {
            long l2 = this.terminal.getFramework().getMonotonicTime() - l;
            logChannel3DEngine.log(-2137614336, "EALManager#createNode3D: return node %1, time: %2ms", (Object)string, l2);
        }
        return wrappedNode3D;
    }

    public IWrappedNode3D createTemplateInstanceNode(IWrappedNode3D iWrappedNode3D, String string, float f2, float f3, int n, String string2, int n2) {
        return this.createTemplateInstanceNode(iWrappedNode3D, string, f2, f3, n, string2, n2, 0);
    }

    public IWrappedNode3D createTemplateInstanceNode(IWrappedNode3D iWrappedNode3D, String string, float f2, float f3, int n, String string2, int n2, int n3) {
        long l = this.terminal.getFramework().getMonotonicTime();
        String string3 = this.getKzbName(n);
        if (string3.equals(this.getKzbName(0))) {
            logChannel3DEngine.log(-1601830656, "EALManager#createTemplateInstanceNode: templateName: '%1', kzbFileName: '%2', nodeName: '%3'. Return dummy 3D node for EMPTY_KZB!", (Object)string2, (Object)string3, (Object)string);
            return this.createNode3D(iWrappedNode3D, string, f2, f3, n3);
        }
        logChannel3DEngine.log(-2137614336, "EALManager#createTemplateInstanceNode: templateName: '%1', kzbFileName: '%2', nodeName: '%3'", (Object)string2, (Object)string3, (Object)string);
        ITemplateNode3D iTemplateNode3D = (ITemplateNode3D)this.getHMIService().getKanziResource(string3, string2, 1, this.terminal.getTerminalID(), n2);
        if (iTemplateNode3D == null) {
            logChannel3DEngine.log(10000, "EALManager#createTemplateInstanceNode: Could not get template '%1'", (Object)string2);
            return null;
        }
        INode3D iNode3D = iTemplateNode3D.instantiate(this.project, string);
        iTemplateNode3D.dispose();
        if (!iNode3D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createTemplateInstanceNode: Could not instantiate '%1'", (Object)string2);
            iNode3D.dispose();
            return null;
        }
        WrappedNode3D wrappedNode3D = new WrappedNode3D(iNode3D, f2, f3, true, n3, this.isLTR());
        wrappedNode3D.resetTransformation();
        if (iWrappedNode3D != null) {
            iWrappedNode3D.add(wrappedNode3D);
        }
        if (logChannel3DEngine.isDebug()) {
            long l2 = this.terminal.getFramework().getMonotonicTime() - l;
            logChannel3DEngine.log(-2137614336, "EALManager#createTemplateInstanceNode: Instance of '%1' in '%2'-KZB created, nodeName: %3, time: %4", (Object)string2, (Object)string3, (Object)string, l2);
        }
        return wrappedNode3D;
    }

    protected String getKzbName(int n) {
        IKzbMappingHelper iKzbMappingHelper = this.getKzbMappingHelper();
        String string = iKzbMappingHelper.get(n);
        return string;
    }

    public IMaterial createMaterial(String string, String string2, int n, int n2) {
        long l = this.terminal.getFramework().getMonotonicTime();
        String string3 = this.getKzbName(n);
        logChannel3DEngine.log(-2137614336, "EALManager#createMaterial: material path: '%1', kzbFileName: %2", (Object)string2, (Object)string3);
        IMaterial iMaterial = (IMaterial)this.getHMIService().getKanziResource(string3, new String[]{string, string2}, 4, this.terminal.getTerminalID(), n2);
        if (iMaterial == null) {
            logChannel3DEngine.log(10000, "EALManager#createMaterial: Could not get material '%1', template '%2'", (Object)string2, (Object)string);
            return null;
        }
        if (logChannel3DEngine.isDebug()) {
            long l2 = this.terminal.getFramework().getMonotonicTime() - l;
            logChannel3DEngine.log(-2137614336, "EALManager#createMaterial: Created material '%1', time: %2", (Object)string2, l2);
        }
        return iMaterial;
    }

    public void moveToParent(INode2D iNode2D, INode2D iNode2D2) {
        if (iNode2D == null) {
            return;
        }
        if (iNode2D2 == null) {
            throw new IllegalArgumentException("Parent node must not be null");
        }
        if (!iNode2D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#moveToParent: node is invalid");
            return;
        }
        if (!iNode2D2.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#moveToParent: new parent node is invalid");
            return;
        }
        if (iNode2D2.hasChild(iNode2D)) {
            return;
        }
        INode2D iNode2D3 = iNode2D.getParent();
        if (iNode2D3 == iNode2D2) {
            ((INode)iNode2D3).dispose();
            return;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#moveToParent: move node %1 from old parent %2 to new parent %3", (Object)iNode2D, (Object)iNode2D3, (Object)iNode2D2);
        iNode2D3.remove(iNode2D);
        if (!iNode2D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#moveToParent: node is invalid after remove");
            ((INode)iNode2D3).dispose();
            return;
        }
        ((INode)iNode2D3).dispose();
        iNode2D2.add(iNode2D);
    }

    public void moveToParent(IWrappedNode3D iWrappedNode3D, IWrappedNode3D iWrappedNode3D2) {
        if (iWrappedNode3D == null) {
            return;
        }
        if (iWrappedNode3D2 == null) {
            throw new IllegalArgumentException("Parent node must not be null");
        }
        if (!iWrappedNode3D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#moveToParent: node is invalid");
            return;
        }
        if (!iWrappedNode3D2.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#moveToParent: new parent node is invalid");
            return;
        }
        IWrappedNode3D iWrappedNode3D3 = iWrappedNode3D.getParent();
        if (iWrappedNode3D2.equals(iWrappedNode3D3)) {
            return;
        }
        if (EALManager.isDescendant(iWrappedNode3D2, iWrappedNode3D, MAX_RECURSIVE_DEPTH_ADDING_CHECK)) {
            int n = iWrappedNode3D2.equals(iWrappedNode3D) ? -2137614336 : 10000;
            if (logChannel3DEngine.isDebug() || n == 10000) {
                logChannel3DEngine.log(n, "EALManager#moveToParent recursion check failed. child=%1", (Object)EALManager.getAncestors(iWrappedNode3D));
                logChannel3DEngine.log(n, "EALManager#moveToParent new parent=%1", (Object)EALManager.getAncestors(iWrappedNode3D2));
                logChannel3DEngine.log(n, "EALManager#moveToParent", new Throwable("Dummy_LogStackTrace_usually_NOT_an_exception"));
            }
            return;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#moveToParent3D: move node %1 from old parent %2 to new parent %3", (Object)iWrappedNode3D, (Object)iWrappedNode3D3, (Object)iWrappedNode3D2);
        iWrappedNode3D3.remove(iWrappedNode3D);
        iWrappedNode3D2.add(iWrappedNode3D);
    }

    private static String getAncestors(IWrappedNode3D iWrappedNode3D) {
        Buffer buffer = new Buffer(1024);
        for (IWrappedNode3D iWrappedNode3D2 = iWrappedNode3D; iWrappedNode3D2 != null; iWrappedNode3D2 = iWrappedNode3D2.getParent()) {
            buffer.append("->");
            buffer.append(iWrappedNode3D2.toString());
        }
        return buffer.toString();
    }

    public static boolean isDescendant(IWrappedNode3D iWrappedNode3D, IWrappedNode3D iWrappedNode3D2, int n) {
        int n2 = 0;
        for (IWrappedNode3D iWrappedNode3D3 = iWrappedNode3D; iWrappedNode3D3 != null; iWrappedNode3D3 = iWrappedNode3D3.getParent()) {
            if (n2 > n) {
                return false;
            }
            ++n2;
            if (!iWrappedNode3D3.equals(iWrappedNode3D2)) continue;
            return true;
        }
        return false;
    }

    public int getTextWidth(String string, IWrappedFont iWrappedFont) {
        int n;
        if (iWrappedFont == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Font must not be null for text: ").append(string).toString());
        }
        long l = this.terminal.getFramework().getMonotonicTime();
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return 0;
        }
        if (!this.project.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#getTextWidth: project is invalid for text: %1", (Object)string);
            return 0;
        }
        iWrappedFont.getFontGroup().activate();
        ITextLayout iTextLayout = FONT_LAYOUT_WORKAROUND ? new ITextLayout(iWrappedFont.getSize()) : iWrappedFont.getLayout();
        iTextLayout.setMaximumSize(0, 0);
        ITextLayoutResult iTextLayoutResult = manager.layout(iTextLayout, string);
        long l2 = iTextLayoutResult.getWidth();
        iTextLayoutResult.destroy();
        iTextLayoutResult.dispose();
        if (FONT_LAYOUT_WORKAROUND) {
            this.destroy(iTextLayout);
        }
        if (l2 > (n = 0)) {
            logChannel3DEngine.log(10000, "EALManager#getTextWidth: text width is too big for int: %2. text: '%1'", (Object)string, l2);
        }
        int n2 = (int)l2;
        if (logChannel3DEngine.isDebug()) {
            long l3 = this.terminal.getFramework().getMonotonicTime() - l;
            logChannel3DEngine.log(-2137614336, "EALManager#getTextWidth: return width %2 for text '%1', time: %3ms", (Object)string, (long)n2, l3);
        }
        return n2;
    }

    public static int getFontHeightUppercase(IWrappedFont iWrappedFont) {
        int n = iWrappedFont.getSize();
        int n2 = n - 10;
        if (n2 < 0) {
            logChannel3DEngine.log(-1601830656, "EALManager#getFontHeightUppercase: no static size stored for %1 pt font. First stored font: %2 pt", (long)n, (long)0);
            return FONT_SIZES_PIXEL_H[0];
        }
        if (n2 >= FONT_SIZES_PIXEL_H.length) {
            logChannel3DEngine.log(-1601830656, "EALManager#getFontHeightUppercase: no static size stored for %1 pt font. Last stored font: %2 pt", (long)n, (long)(10 + FONT_SIZES_PIXEL_H.length));
            return FONT_SIZES_PIXEL_H[FONT_SIZES_PIXEL_H.length - 1];
        }
        return FONT_SIZES_PIXEL_H[n2];
    }

    @Override
    public boolean isDrawMissing() {
        return this.drawMissing;
    }

    @Override
    public void setDrawMissing(boolean bl) {
        this.drawMissing = bl;
    }

    public static int createColorCode(int n) {
        int n2 = n >> 24 & 0xFF;
        int n3 = n << 8 & 0xFFFFFF00;
        return n3 | n2;
    }

    public int getBackgroundImageID() {
        return this.backgroundImageID;
    }

    public void setBackgroundImageID(int n) {
        this.backgroundImageID = n;
    }

    public void setTransparentImageID(int n) {
        this.transparentImageID = n;
    }

    public void setBlackImageID(int n) {
        this.blackImageID = n;
    }

    public void updateBackgroundImageNode(Object object) {
        if (this.previousBkgrImageID != this.backgroundImageID || this.backgroundImageNode == null || this.backgroundTexture == null) {
            this.previousBkgrImageID = this.backgroundImageID;
            if (this.backgroundImageNode != null) {
                this.masterRoot.removeFromScreen(this.backgroundImageNode);
                this.destroy(this.backgroundImageNode);
                this.backgroundImageNode = null;
            }
            if (this.backgroundTexture != null) {
                this.backgroundTexture.releaseTexture(true, object);
            }
            this.backgroundTexture = null;
            if (this.backgroundImageID != -1) {
                TextureDescription textureDescription = this.createTextureDescription(this.backgroundImageID, false, -1);
                this.backgroundTexture = textureDescription.getTexture(object);
                if (this.backgroundTexture != null) {
                    INode2DImage iNode2DImage = this.createImage2DTex(this.backgroundTexture.getTexture(), "backgroundImage");
                    if (iNode2DImage != null) {
                        if (iNode2DImage.getWidth() > 0) {
                            int n = this.terminal.getLayout().getIntegerConstant(111);
                            iNode2DImage.setTranslation(n, 0.0f);
                        }
                        this.masterRoot.addToScreen(iNode2DImage, 0);
                        this.backgroundImageNode = iNode2DImage;
                        IProperty iProperty = iNode2DImage.getProperty("LayerMaterial");
                        if (!iProperty.isValid()) {
                            logChannel3DEngine.log(10000, "EALManager#updateBackgroundImageNode: property LayerMaterial not found");
                            iProperty.dispose();
                            return;
                        }
                        iProperty.set(this.clearingMaterial);
                        iProperty.dispose();
                        if (this.clearingMaterial == null) {
                            logChannel3DEngine.log(10000, "EALManager#updateBackgroundImageNode: clearing material is null, you have to load it first");
                            return;
                        }
                    }
                } else {
                    logChannel3DEngine.log(10000, "EALManager#updateBackgroundImageNode: path for background image is null. imageID: %1", (long)this.backgroundImageID);
                }
            }
        }
    }

    public void loadClearingMaterial(int n) {
        this.clearingMaterial = this.createMaterial("Prefabs/MaterialLibrary", "Materials/Clearing/Clearing", n, -1);
        if (this.clearingMaterial == null) {
            this.kzbLoadingError = true;
            logChannel3DEngine.log(10000, "EALManager#loadClearingMaterial: clearing material is null");
            return;
        }
    }

    public void updateTransparentImageNode(Object object) {
        this.transparentImageNode = this.updateImageNode(this.transparentImageNode, this.transparentImageID, "transparentImage", object);
    }

    public void updateBlackImageNode(Object object) {
        this.blackImageNode = this.updateImageNode(this.blackImageNode, this.blackImageID, "blackImage", object);
    }

    private INode2DImage updateImageNode(INode2DImage iNode2DImage, int n, String string, Object object) {
        if (iNode2DImage != null) {
            this.masterRoot.removeFromScreen(iNode2DImage);
            this.destroy(iNode2DImage);
            iNode2DImage = null;
        }
        INode2DImage iNode2DImage2 = null;
        if (n != -1) {
            TextureDescription textureDescription = this.createTextureDescription(n, false, -1);
            if (textureDescription != null) {
                IWrappedTexture iWrappedTexture = textureDescription.getTexture(object);
                if (iWrappedTexture != null && (iNode2DImage2 = this.createImage2DTex(iWrappedTexture.getTexture(), string)) != null) {
                    float f2 = iNode2DImage2.getWidth();
                    float f3 = iNode2DImage2.getHeight();
                    iNode2DImage2.scale((float)this.screenWidth / f2, (float)this.screenHeight / f3);
                    iNode2DImage2.setVisible(false);
                    this.masterRoot.addToScreen(iNode2DImage2, 0);
                    IProperty iProperty = iNode2DImage2.getProperty("LayerMaterial");
                    if (!iProperty.isValid()) {
                        logChannel3DEngine.log(10000, "EALManager#updateImageNode: property LayerMaterial not found");
                        iNode2DImage2.dispose();
                        return null;
                    }
                    if (this.clearingMaterial == null) {
                        logChannel3DEngine.log(10000, "EALManager#updateImageNode: clearing material is null, you have to load it first");
                        iNode2DImage2.dispose();
                        return null;
                    }
                    iProperty.set(this.clearingMaterial);
                    iProperty.dispose();
                }
            } else {
                logChannel3DEngine.log(10000, "EALManager#updateImageNode: path is null. imageName: %1, imageID: %2", (Object)string, (long)n);
            }
        }
        return iNode2DImage2;
    }

    INode2DImage createImage2DTex(ITexture iTexture, String string) {
        INode2DImage iNode2DImage;
        if (iTexture == null) {
            logChannel3DEngine.log(10000, "EALManager#createImage2DTex Could not create image '%1' because not texture was set", (Object)string);
        }
        if (!(iNode2DImage = new INode2DImage(this.project, string, iTexture)).isValid()) {
            logChannel3DEngine.log(10000, "EALManager#createImage2DTex Could not create image '%1'", (Object)string);
            iNode2DImage.dispose();
            return null;
        }
        return iNode2DImage;
    }

    public IWrappedLayer getScreensLayer() {
        return this.screensLayer;
    }

    public IWrappedNode3D getScreensNode() {
        return this.screensLayer.getNode();
    }

    public IWrappedNode3D getOptionDrawerNode() {
        return this.optionDrawerLayer.getNode();
    }

    public IWrappedNode3D getEntertainmentDrawerNode() {
        return this.entertainmentDrawerLayer.getNode();
    }

    public IWrappedNode3D getPartialPopupsBackNode() {
        return this.popupsBehindDrawersMainNode;
    }

    public IWrappedLayer getPopupBackLayer() {
        return this.popupsBehindDrawersLayer;
    }

    public IWrappedLayer getPopupFrontLayer() {
        return this.popupsFrontLayer;
    }

    public IWrappedLayer getPopupsBetweenLayer() {
        return this.popupsBetweenLayer;
    }

    public IWrappedNode3D getPartialPopupsBetweenNode() {
        return this.popupsBetweenLayer.getNode();
    }

    public IWrappedNode3D getPartialPopupsFrontNode() {
        return this.popupsFrontLayer.getNode();
    }

    public IWrappedNode3D getPresetPopupNode() {
        return this.unboundPresetPopupLayer.getNode();
    }

    public IWrappedLayer getScreenPartialPopupsLayer() {
        return this.screenPartialPopupsLayer;
    }

    public IWrappedNode3D getScreenPartialPopupsNode() {
        return this.screenPartialPopupsLayer.getNode();
    }

    public IWrappedNode3D getStatisticsNode() {
        if (this.statisticViewport == null) {
            boolean bl = false;
            this.statisticViewport = this.createViewport("statistic", 240, this.screenWidth, this.screenHeight, true, bl);
            this.statisticsNode = this.createLayer(this.statisticViewport, "statistic", 0);
        }
        return this.statisticsNode.getNode();
    }

    @Override
    public void setMMICombiContextID(int n) {
        this.mmiCombiContextID = n;
    }

    public void setStatistics(EALStatistics eALStatistics) {
        this.statistics = eALStatistics;
    }

    @Override
    public String getRAMStatus() {
        long l = manager.getMemoryRAM();
        long l2 = manager.getMemoryRAMFree();
        Buffer buffer = new Buffer();
        buffer.append("RAM ");
        switch (MEMORY_USAGE_UNIT) {
            case 0: {
                buffer.append(l);
                buffer.append(" Byte allocated, ");
                buffer.append(l2);
                buffer.append(" Byte free");
                break;
            }
            case 1: {
                buffer.append(l / 0);
                buffer.append(" KB allocated, ");
                buffer.append(l2 / 0);
                buffer.append(" KB free");
                break;
            }
            default: {
                buffer.append(l / 0 / 0);
                buffer.append(" MB allocated, ");
                buffer.append(l2 / 0 / 0);
                buffer.append(" MB free");
            }
        }
        return buffer.toString();
    }

    @Override
    public String getVRAMStatus() {
        long l = manager.getMemoryVRAM();
        Buffer buffer = new Buffer();
        buffer.append("VRAM ");
        switch (MEMORY_USAGE_UNIT) {
            case 0: {
                buffer.append(l);
                buffer.append(" Byte");
                break;
            }
            case 1: {
                buffer.append(l / 0);
                buffer.append(" KB");
                break;
            }
            default: {
                buffer.append(l / 0 / 0);
                buffer.append(" MB");
            }
        }
        return buffer.toString();
    }

    public String[] getDrawTimes() {
        if (this.renderer == null) {
            return new String[]{""};
        }
        Buffer buffer = new Buffer();
        String[] stringArray = new String[3];
        buffer.append("permanent rendering is ");
        buffer.append(this.permanentRenderingEnabled ? "on" : "off");
        stringArray[0] = buffer.toString();
        buffer.clear();
        buffer.append("partial rendering is ");
        buffer.append(partialRenderingEnabled ? "on" : "off");
        if (partialRenderingEnabled && !partialOffscreenRenderingEnabled) {
            buffer.append(", offscreen PR is off");
        }
        stringArray[1] = buffer.toString();
        buffer.clear();
        if (this.ealFrameInfos == null) {
            this.ealFrameInfos = new CFrameInformation(this.renderer);
        }
        buffer.append(this.ealFrameInfos.getFPS());
        buffer.append(" fps");
        stringArray[2] = buffer.toString();
        return stringArray;
    }

    private void drawStatistics() {
        if (this.statistics != null) {
            if (SHOW_MEMORY_USAGE) {
                this.statistics.showStatistics(0, false);
            }
            if (SHOW_EVENT_QUEUE_STATISTIC) {
                this.statistics.showStatistics(1, false);
            }
            if (SHOW_SCREEN_INFO) {
                this.statistics.showStatistics(3, false);
            }
            if (SHOW_DRAW_TIME_STATISTIC) {
                this.statistics.showStatistics(7, false);
            }
        }
    }

    public void setClearMethod(int n) {
        boolean bl;
        if (this.clearMethod == n) {
            return;
        }
        this.clearMethod = n;
        logChannel3DEngine.log(-2137614336, "EALManager#setClearMethod: change clear method to %1", (long)n);
        if (!this.project.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#setClearMethod: project is invalid");
            return;
        }
        boolean bl2 = n == 0;
        boolean bl3 = n == 1;
        boolean bl4 = bl = n == 2;
        if (this.transparentImageNode != null && this.transparentImageNode.isValid()) {
            logChannel3DEngine.log(1078071040, "EALManager#setClearColor: Setting visibility of transparentImageNode to %1", bl2);
            this.transparentImageNode.setVisible(bl2);
        }
        if (this.blackImageNode != null && this.blackImageNode.isValid()) {
            logChannel3DEngine.log(1078071040, "EALManager#setClearColor: Setting visibility of blackImageNode to %1", bl3);
            this.blackImageNode.setVisible(bl3);
        }
        if (this.backgroundImageNode != null && this.backgroundImageNode.isValid()) {
            logChannel3DEngine.log(1078071040, "EALManager#setClearColor: Setting visibility of backgroundImageNode to %1", bl);
            this.backgroundImageNode.setVisible(bl);
        }
    }

    private long getMonotonicTime() {
        return this.terminal.getFramework().getMonotonicTime();
    }

    public INode2D mergeProject(int n, int n2, int n3) {
        long l = this.getMonotonicTime();
        String string = this.getKzbName(n);
        INode2D iNode2D = (INode2D)this.getHMIService().getKanziResource(string, Util.createInteger(n2), 2, this.terminal.getTerminalID(), n3);
        if (iNode2D == null) {
            return null;
        }
        long l2 = this.getMonotonicTime() - l;
        logBenchmark.log(-2137614336, "EALManager#mergeProject: Merged project in '%1'-KZB, time: %2", (Object)string, l2);
        logChannel3DEngine.log(-2137614336, "EALManager#mergeProject: Merged project in '%1'-KZB, time: %2", (Object)string, l2);
        return iNode2D;
    }

    public boolean isProjectMerged(int n) {
        boolean bl = false;
        String string = this.getKzbName(n);
        try {
            bl = this.isProjectMergedInternal(string);
        }
        catch (Throwable throwable) {
            logChannel3DEngine.log(10000, "EALManager#isProjectMerged failed to determine whether '%1'-KZB has already been merged with the main project or not", (Object)string);
        }
        return bl;
    }

    private boolean isProjectMergedInternal(String string) {
        HMIBundle hMIBundle;
        IHMIServiceEvo iHMIServiceEvo;
        boolean bl = false;
        IManager iManager = EALManager.getManager();
        if (iManager != null && (iHMIServiceEvo = this.getHMIService()) != null && (hMIBundle = iHMIServiceEvo.getHMIBundle(0)) != null) {
            HMITerminalImpl hMITerminalImpl = this.getTerminal();
            int n = -1;
            if (hMITerminalImpl != null) {
                n = hMITerminalImpl.getTerminalID();
            }
            String string2 = null;
            if (n != -1) {
                string2 = hMIBundle.getKzbPath(string);
            } else {
                logChannel3DEngine.log(10000, "EALManager#isProjectMergedInternal failed to retrieve the terminal ID");
            }
            if (string2 != null) {
                bl = iManager.isMerged(this.getProject(), string2);
            } else {
                logChannel3DEngine.log(10000, "EALManager#isProjectMergedInternal failed to resolve a path for '%1'-KZB", (Object)string);
            }
        }
        logChannel3DEngine.log(-2137614336, "EALManager#isProjectMergedInternal '%2'-KZB has already been merged into the main project: %1", bl, (Object)string);
        return bl;
    }

    public void mergeKzb(int n) {
        long l = this.getMonotonicTime();
        String string = this.getKzbName(n);
        Boolean bl = (Boolean)this.getHMIService().getKanziResource(string, null, 7, this.terminal.getTerminalID(), -1);
        if (!bl.booleanValue()) {
            logChannel3DEngine.log(10000, "EALManager#mergeKzb: Could not merge '%1'-KZB", (Object)string);
        }
        long l2 = this.getMonotonicTime() - l;
        logBenchmark.log(-2137614336, "EALManager#mergeKzb: Merged merge '%1'-KZB, time: %2", (Object)string, l2);
        logChannel3DEngine.log(-2137614336, "EALManager#mergeKzb: Merged merge '%1'-KZB, time: %2", (Object)string, l2);
    }

    public boolean mergeProjectAsync(int n, int n2, int n3) {
        Object object = this.getHMIService().getKanziResource(this.getKzbName(n), Util.createInteger(n2), 5, this.terminal.getTerminalID(), n3);
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#mergeProjectAsync: something went wrong, return value isn't a Boolean");
        return false;
    }

    @Override
    public void dumpGlyphCache(String string) {
        System.err.println("not yet supported by EAL");
    }

    public boolean getKzbLoadingError() {
        return this.kzbLoadingError;
    }

    public IWrappedTexture getBackgroundTexture() {
        if (this.backgroundImageNode == null || !this.backgroundImageNode.isValid() || !this.backgroundImageNode.isVisible()) {
            return null;
        }
        return this.backgroundTexture;
    }

    public INode2DImage getBackgroundImageNode() {
        return this.backgroundImageNode;
    }

    public static boolean isAnnotationsEnabled() {
        return annotationsEnabled;
    }

    public boolean setDesaturationEnabled(boolean bl) {
        logChannel3DEngine.log(1078071040, "EALManager#setDesaturationEnabled set enabled=%1", bl);
        if (MAIN_AREA_DESATURATION == 0) {
            logChannel3DEngine.log(1078071040, "EALManager#setDesaturationEnabled desaturation not enabled");
            return true;
        }
        if (null == this.desaturationImage) {
            logChannel3DEngine.log(10000, "EALManager#setDesaturationEnabled desaturation image not initialized");
            return false;
        }
        boolean bl2 = this.desaturationImage.isVisible();
        if (bl == bl2) {
            logChannel3DEngine.log(1078071040, "EALManager#setDesaturationEnabled desaturation already %1", bl);
            return true;
        }
        if (bl) {
            IWrappedTexture iWrappedTexture = this.screensLayer.getViewport().enableOffscreen();
            if (iWrappedTexture == null) {
                logChannel3DEngine.log(10000, "EALManager#setDesaturationEnabled could not enable offscreen");
                return false;
            }
            return this.desaturationImage.setVisible(true);
        }
        this.desaturationImage.setVisible(false);
        this.screensLayer.getViewport().disableOffscreen();
        return true;
    }

    public void setMainAreaMaterial(IMaterial iMaterial) {
        if (!this.mainAreaMaterialProperty.set(iMaterial)) {
            logChannel3DEngine.log(10000, "EALManager#setMainAreaMaterial: unable to set material to desaturation layer");
            return;
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    public void setMainAreaMaterialProperties(boolean bl, float f2, float f3) {
        this.setDesaturationEnabled(f2 > 0.0f || bl && f3 > 0.0f);
        if (this.wasMapScreen != bl) {
            this.setMainAreaMaterial(bl ? this.desaturateMapMaterial : this.desaturateMaterial);
            this.wasMapScreen = bl;
        }
        if (bl) {
            this.desaturationImage.setOpacity(1.0f);
            if (this.mainAreaMapDesaturateProperty != null) {
                this.mainAreaMapDesaturateProperty.set(f2 * -842216386);
            }
            if (this.mainAreaMapBrightnessProperty != null) {
                this.mainAreaMapBrightnessProperty.set(1.0f - f3 * -640796865);
            }
        } else if (this.mainAreaDesaturateProperty != null) {
            this.mainAreaDesaturateProperty.set(f2);
            int n = 1.0f - f3 < 63 ? 63 : (int)(1.0f - f3);
            this.desaturationImage.setOpacity(n);
        }
    }

    public IWrappedManagedNode getMasterRoot() {
        return this.masterRoot;
    }

    protected IHMIServiceEvo getHMIService() {
        return (IHMIServiceEvo)this.terminal.getFramework().getHMIService();
    }

    @Override
    public void processEvent(EALMergeEvent eALMergeEvent) {
        String string = eALMergeEvent.getNodeName();
        if (string.equals("Layers/w140_root")) {
            MixedListKZBMerger.kZBMergedCallback(eALMergeEvent.getNodeName());
        } else if (string.indexOf("Layers/ops_root") >= 0) {
            this.opsKzbMerged = true;
            this.notifyKzbListener(12, string);
            logChannel3DEngine.log(-2137614336, "EALManager#processEvent: OPS-KZB-Listeners are notified");
        } else if (string.indexOf("Layers/carMenu") >= 0) {
            this.car3DResourceHandler.asyncMergeFinished(eALMergeEvent.getNodeName());
            this.notifyKzbListener(3, string);
            logChannel3DEngine.log(-2137614336, "EALManager#processEvent: carviewer-KZB-Listeners are notified");
        } else if (string.indexOf("Layers/ds_root") >= 0) {
            selectionDrawerMerged = true;
            this.notifyKzbListener(8, string);
            logChannel3DEngine.log(-2137614336, "EALManager#processEvent: selectionDrawer-KZB-Listeners are notified");
        } else {
            logChannel3DEngine.log(10000, "EALManager#processEvent: unknown nodeName: %1", (Object)string);
        }
    }

    public void registerAsKzbListener(int n, IKzbMergeListener iKzbMergeListener) {
        Integer n2 = Util.createInteger(n);
        ArrayList arrayList = (ArrayList)kzbMergeListener.get(n2);
        if (arrayList == null) {
            arrayList = new ArrayList();
            arrayList.add(iKzbMergeListener);
            kzbMergeListener.put(n2, arrayList);
            return;
        }
        if (!arrayList.contains(iKzbMergeListener)) {
            arrayList.add(iKzbMergeListener);
            return;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#registerAsKzbListener: listener %1 is already registered", (Object)iKzbMergeListener);
    }

    public void unregisterAsKzbListener(IKzbMergeListener iKzbMergeListener) {
        if (kzbMergeListener.size() == 0) {
            return;
        }
        Iterator iterator = kzbMergeListener.entrySet().iterator();
        while (iterator.hasNext()) {
            ArrayList arrayList;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            if (map$Entry == null || (arrayList = (ArrayList)kzbMergeListener.get(map$Entry.getValue())) == null) continue;
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                Object object = iterator2.next();
                if (!(object instanceof IKzbMergeListener)) continue;
                if (object.equals(iKzbMergeListener)) {
                    arrayList.remove(object);
                    logChannel3DEngine.log(-2137614336, "EALManager#unregisterAsKzbListener: uregister Listener %1 from kzbConstant %2", (Object)iKzbMergeListener.getWidgetName(), (Object)((Integer)map$Entry.getValue()).toString());
                    continue;
                }
                logChannel3DEngine.log(-2137614336, "EALManager#unregisterAsKzbListener: Listener %1 not in list. Nothing to do.", (Object)iKzbMergeListener.getWidgetName());
            }
        }
    }

    private void notifyKzbListener(int n, String string) {
        Integer n2 = Util.createInteger(n);
        ArrayList arrayList = (ArrayList)kzbMergeListener.get(n2);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!((AbstractWidgetController)object).isConnected()) continue;
            IKzbMergeListener iKzbMergeListener = (IKzbMergeListener)object;
            iKzbMergeListener.mergeFinished(string);
        }
    }

    @Override
    public void processEvent(MergeKZBAsyncEvent mergeKZBAsyncEvent) {
        MixedListKZBMerger.mergeKZBAsync(mergeKZBAsyncEvent.getKzbConstant(), -1, this);
    }

    public INode2D getVisualFeedbackNode() {
        if (null == this.visualFeedbackNode) {
            this.visualFeedbackNode = new INode2D(this.getProject(), "visualFeedbackNode");
            if (null != this.visualFeedbackNode && this.visualFeedbackNode.isValid()) {
                this.masterRoot.addToScreen(this.visualFeedbackNode, 230);
                this.visualFeedbackNode.setVisible(false);
            } else {
                this.visualFeedbackNode = null;
            }
        }
        return this.visualFeedbackNode;
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof VRAMEvent) {
            logChannel3DEngine.log(-1601830656, "EAL reported memory %1", manager.getMemoryRAM());
        }
    }

    public static String createNodeName(String string, AbstractRenderer abstractRenderer) {
        if (!EALManager.shouldCreateLongNodeNames()) {
            return string;
        }
        return EALManager.createNodeName(string, null, abstractRenderer);
    }

    public static String createNodeName(String string, int n, AbstractRenderer abstractRenderer) {
        if (!EALManager.shouldCreateLongNodeNames()) {
            return string;
        }
        return EALManager.createNodeName(string, String.valueOf(n), abstractRenderer);
    }

    public static String createNodeName(String string, String string2) {
        if (!EALManager.shouldCreateLongNodeNames()) {
            return string;
        }
        return EALManager.createNodeName(string, string2, null);
    }

    public static String createNodeName(String string, String string2, AbstractRenderer abstractRenderer) {
        if (!EALManager.shouldCreateLongNodeNames() || string2 == null && abstractRenderer == null) {
            return string;
        }
        stringBuilder.clear();
        stringBuilder.append(string);
        if (string2 != null) {
            stringBuilder.append("_").append(string2);
        }
        if (abstractRenderer != null) {
            AbstractWidgetController abstractWidgetController = abstractRenderer.getAbstractController();
            if (abstractWidgetController != null) {
                stringBuilder.append("_").append(abstractWidgetController.getClassName());
                stringBuilder.append("[").append(abstractWidgetController.getModelID()).append(",").append(abstractWidgetController.getScreenId()).append("]");
            } else {
                stringBuilder.append("_").append(super.getClass().getName());
            }
        }
        stringBuilder.append(nodeCounter++);
        return stringBuilder.toString();
    }

    private static boolean shouldCreateLongNodeNames() {
        return USE_LONG_NODE_NAMES || logChannel3DEngineNodeNames.isDebug();
    }

    public INode3D getShortcutNode3D(String string) {
        logChannel3DEngine.log(-2137614336, "EALManager#getShortcutNode3D: getting node '%1'", (Object)string);
        INode3D iNode3D = this.project.getNode3D(string);
        if (!iNode3D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#getShortcutNode3D: Could not get node '%1'", (Object)string);
            iNode3D.dispose();
            return null;
        }
        return iNode3D;
    }

    public ITexture getShortcutTexture(String string) {
        logChannel3DEngine.log(-2137614336, "EALManager#getShortcutTexture: getting texture '%1'", (Object)string);
        ITexture iTexture = this.project.getTexture(string);
        if (!iTexture.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#getShortcutTexture: Could not get texture '%1'", (Object)string);
            iTexture.dispose();
            return null;
        }
        return iTexture;
    }

    public INode2D getShortcutNode2D(String string) {
        logChannel3DEngine.log(-2137614336, "EALManager#getShortcutNode2D: getting node '%1'", (Object)string);
        INode2D iNode2D = this.project.getNode2D(string);
        if (!iNode2D.isValid()) {
            logChannel3DEngine.log(10000, "EALManager#getShortcutNode2D: Could not get node '%1'", (Object)string);
            iNode2D.dispose();
            return null;
        }
        return iNode2D;
    }

    private COffscreenHelper getOffscreenHelper() {
        if (this.offscreenHelper != null) {
            return this.offscreenHelper;
        }
        logChannel3DEngine.log(-2137614336, "EALManager#getOffscreenHelper creating offscreenHelper");
        this.offscreenHelper = new COffscreenHelper(this.project, this.masterRoot.getNode());
        return this.offscreenHelper;
    }

    public IWrappedTexture enableOffscreen(WrappedViewport wrappedViewport, TextureDescription textureDescription) {
        FlagTexture flagTexture = EALManager.getTextureFlags(6, false);
        ITexture iTexture = this.enableOffscreen(wrappedViewport.getLink(), wrappedViewport.getWidth(), wrappedViewport.getHeight(), flagTexture, wrappedViewport.getIndex());
        if (iTexture == null) {
            return null;
        }
        return new WrappedTexture(iTexture, textureDescription, this);
    }

    public boolean reEnableOffscreen(WrappedViewport wrappedViewport) {
        return this.reEnableOffscreen(wrappedViewport.getLink(), wrappedViewport.getTexture().getTexture(), wrappedViewport.getIndex());
    }

    private ITexture enableOffscreen(INode2D iNode2D, long l, long l2, FlagTexture flagTexture, int n) {
        COffscreenHelper cOffscreenHelper = this.getOffscreenHelper();
        ITexture iTexture = cOffscreenHelper.enableOffscreen(iNode2D, l, l2, flagTexture, n, partialOffscreenRenderingEnabled);
        if (iTexture == null) {
            logChannel3DEngine.log(10000, "EALManager#enableOffscreen texture null for node'%1'", (Object)iNode2D.getName());
            return null;
        }
        if (iTexture.isValid()) {
            return iTexture;
        }
        iTexture.dispose();
        logChannel3DEngine.log(10000, "EALManager#enableOffscreen texture invalid for node '%1'", (Object)iNode2D.getName());
        return null;
    }

    private boolean reEnableOffscreen(INode2D iNode2D, ITexture iTexture, int n) {
        COffscreenHelper cOffscreenHelper = this.getOffscreenHelper();
        if (cOffscreenHelper.enableOffscreen(iNode2D, iTexture, n, partialOffscreenRenderingEnabled)) {
            return true;
        }
        logChannel3DEngine.log(10000, "EALManager#reEnableOffscreen could not reenable texture for node'%1'", (Object)iNode2D.getName());
        return false;
    }

    public boolean disableOffscreen(INode2D iNode2D) {
        COffscreenHelper cOffscreenHelper = this.getOffscreenHelper();
        return cOffscreenHelper.disableOffscreen(iNode2D);
    }

    public static FlagImage getImageFlags(int n) {
        imageOptions_t imageOptions_t2 = EALManager.getImageOptionFormat(n);
        Integer n2 = Util.createInteger(imageOptions_t2.swigValue());
        FlagImage flagImage = (FlagImage)flagImageMap.get(n2);
        if (flagImage != null) {
            return flagImage;
        }
        FlagImage flagImage2 = new FlagImage(imageOptions_t2);
        flagImageMap.put(n2, flagImage2);
        return flagImage2;
    }

    public static FlagTexture getTextureFlags(int n, boolean bl) {
        Integer n2;
        FlagTexture flagTexture;
        int n3 = defaultTextureOptions;
        n3 |= EALManager.getTextureOptionFormat(n).swigValue();
        if (!bl) {
            n3 |= texOptions_t.TEX_OPTIONS_EXT_NO_ATLAS.swigValue();
        }
        if ((flagTexture = (FlagTexture)flagTextureMap.get(n2 = Util.createInteger(n3))) != null) {
            return flagTexture;
        }
        FlagTexture flagTexture2 = new FlagTexture(n3);
        flagImageMap.put(n2, flagTexture2);
        return flagTexture2;
    }

    private static imageOptions_t getImageOptionFormat(int n) {
        switch (n) {
            case 0: {
                return imageOptions_t.IMAGE_OPTIONS_FORMAT_A_8;
            }
            case 4: {
                return imageOptions_t.IMAGE_OPTIONS_FORMAT_LA_88;
            }
            case 2: {
                return imageOptions_t.IMAGE_OPTIONS_FORMAT_RGB_888;
            }
        }
        return imageOptions_t.IMAGE_OPTIONS_FORMAT_RGBA_8888;
    }

    private static texOptions_t getTextureOptionFormat(int n) {
        switch (n) {
            case 0: {
                return texOptions_t.TEX_OPTIONS_FORMAT_A_8;
            }
            case 4: {
                return texOptions_t.TEX_OPTIONS_FORMAT_LA_88;
            }
            case 2: {
                return texOptions_t.TEX_OPTIONS_FORMAT_RGB_888;
            }
        }
        return texOptions_t.TEX_OPTIONS_FORMAT_RGBA_8888;
    }

    public void destroy(ITextureCache iTextureCache) {
        if (iTextureCache == null) {
            return;
        }
        iTextureCache.destroyAll();
        this.cacheMap.remove(Util.createInteger(iTextureCache.getCacheId()));
    }

    public void setPartialRenderingModeEnabled(boolean bl) {
        if (partialRenderingEnabled == bl) {
            logChannel3DEngine.log(1078071040, "EALManager#setPartialRenderingModeEnabled not changing partial rendering mode");
            return;
        }
        logChannel3DEngine.log(1078071040, "EALManager#setPartialRenderingModeEnabled setting partial rendering to %1", bl);
        partialRenderingEnabled = bl;
        if (!this.masterRoot.getNode().setPartialRendering(bl)) {
            logChannel3DEngine.log(10000, "EALManager#setPartialRenderingModeEnabled could not set partial rendering to %1", bl);
        }
    }

    public void setRemoveNodesBeforeDestroy(boolean bl) {
        logChannel3DEngine.log(1078071040, "EALManager#setRemoveNodesBeforeDestroy removeNodeBeforeDestroy=%1", bl);
        this.removeNodeBeforeDestroy = bl;
    }

    public static void dumpEALObjects() {
        logChannel3DEngine.log(1078071040, "EALManager#dumpEALObjects");
        manager.dumpObjects();
    }

    public static void dumpEALMemory() {
        logChannel3DEngine.log(1078071040, "EALManager#dumpMemory");
        manager.dumpMemory();
    }

    public static void dumpEALRegistry() {
        logChannel3DEngine.log(1078071040, "EALManager#dumpEALRegistry");
        manager.dumpRegistry();
    }

    @Override
    public boolean isPartialRenderingEnabled() {
        return partialRenderingEnabled;
    }

    @Override
    public boolean isOffscreenPartialRenderingEnabled() {
        return partialOffscreenRenderingEnabled;
    }

    private INode2DImage createKDKImage(int n, Object object) {
        TextureDescription textureDescription = this.createTextureDescription(n, false, -1);
        if (textureDescription != null) {
            IWrappedTexture iWrappedTexture = textureDescription.getTexture(object);
            if (iWrappedTexture != null) {
                INode2DImage iNode2DImage = this.createImage2DTex(iWrappedTexture.getTexture(), "kdkImage");
                if (iNode2DImage != null) {
                    this.masterRoot.addToScreen(iNode2DImage, 220);
                    iNode2DImage.setVisible(false);
                    return iNode2DImage;
                }
                logChannel3DEngine.log(10000, "EALManager#createKDKImage: could not create image, imageId is %1", (long)n);
                return null;
            }
            logChannel3DEngine.log(10000, "EALManager#createKDKImage: texture not valid");
            return null;
        }
        logChannel3DEngine.log(10000, "EALManager#createKDKImage: texture description cannot be created, imageID = %1", (long)n);
        return null;
    }

    public void showKDKBackground(int n, int n2, int n3, Object object) {
        if (this.kdkBackgroundImage == null || n != this.kdkImageID) {
            if (this.kdkBackgroundImage != null) {
                this.masterRoot.removeFromScreen(this.kdkBackgroundImage);
                this.destroy(this.kdkBackgroundImage);
                this.kdkBackgroundImage = null;
            }
            this.kdkBackgroundImage = this.createKDKImage(n, object);
            if (this.kdkBackgroundImage == null) {
                return;
            }
        }
        this.kdkBackgroundImage.setTranslation(n2, n3);
        this.kdkBackgroundImage.setVisible(true);
    }

    public void hideKDKBackground() {
        if (this.kdkBackgroundImage == null) {
            return;
        }
        this.kdkBackgroundImage.setVisible(false);
    }

    public HMITerminalImpl getTerminal() {
        return this.terminal;
    }

    public boolean isLTR() {
        if (!RTL_ENABLED) {
            return true;
        }
        return this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation();
    }

    public IWrappedLayer getOptionDrawerClosedLayer() {
        return this.optionDrawerClosedLayer;
    }

    public IWrappedLayer getSelectionDrawerClosedLayer() {
        return this.selectionDrawerClosedLayer;
    }

    public static int setBrightness(float f2, int n) {
        int n2 = (int)((float)(n >> 24 & 0xFF) * f2);
        n2 = Math.min(n2, 255) << 24;
        int n3 = (int)((float)(n >> 16 & 0xFF) * f2);
        n3 = Math.min(n3, 255) << 16;
        int n4 = (int)((float)(n >> 8 & 0xFF) * f2);
        n4 = Math.min(n4, 255) << 8;
        int n5 = n & 0xFF;
        return n2 | n3 | n4 | n5;
    }

    public boolean isOpsKzbMerged() {
        return this.opsKzbMerged;
    }

    public void setOpsKzbMerged(boolean bl) {
        logChannel3DEngine.log(-2137614336, "EALManager#setOpsKzbMerged disable idleRendering %1", bl);
        this.opsKzbMerged = bl;
    }

    public void setOpsKzbMergeStarted(boolean bl) {
        this.opsKzbMergeStarted = bl;
        logChannel3DEngine.log(-2137614336, "EALManager#setOpsKzbMergeStarted trigger idleRendering");
        this.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, new EALManager$IdleRendering(this, true)));
    }

    public boolean isOpsKzbMergeStarted() {
        return this.opsKzbMergeStarted;
    }

    public KzbMergeManager getKzbMergeManager() {
        return this.kzbMergeManager;
    }

    public ITextureCache getIconLabelCache() {
        return cacheIconLabel;
    }

    private void clearIconLabelCache() {
        if (cacheIconLabel != null) {
            ((LRUTextureCache)cacheIconLabel).clearBufferIfPossible();
            iconLabelLogCh.log(-2137614336, "EALManager#clearIconLabelCache Cache cleared:");
            cacheIconLabel.dump(iconLabelLogCh);
        } else {
            iconLabelLogCh.log(10000, "EALManager#clearIconLabelCache Cache has not been created.");
        }
    }

    @Override
    public void processEvent(PersonalPoiDatabaseUpdateEvent personalPoiDatabaseUpdateEvent) {
        iconLabelLogCh.log(-1601830656, "EALManager#processEvent PersonalPoiDatabaseUpdateEvent received.");
        this.clearIconLabelCache();
    }

    public static boolean isSelectionDrawerMerged() {
        return selectionDrawerMerged;
    }

    public EALManager$EALManagerInfoProvider getEalManagerInfoProvider() {
        return this.dumpInfoProvider;
    }

    static /* synthetic */ int access$000() {
        return MAX_NUMBER_OF_IDLE_RENDER_STEPS_FOR_OPS_ASYNC_MERGE;
    }

    static /* synthetic */ void access$100(EALManager eALManager) {
        eALManager.processAsyncKzbLoading();
    }

    static /* synthetic */ long access$200() {
        return DELAY_TIME_FOR_IDLE_RENDER_STEPS_FOR_OPS_ASYNC_MERGE;
    }

    static /* synthetic */ boolean access$302(EALManager eALManager, boolean bl) {
        eALManager.idleDestroyingEventPosted = bl;
        return eALManager.idleDestroyingEventPosted;
    }

    static /* synthetic */ LinkedList access$400(EALManager eALManager) {
        return eALManager.nodesToDestroy;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IMMICombiAnimationSyncer access$602(EALManager eALManager, IMMICombiAnimationSyncer iMMICombiAnimationSyncer) {
        eALManager.animationSyncer = iMMICombiAnimationSyncer;
        return eALManager.animationSyncer;
    }

    static /* synthetic */ HMITerminalImpl access$700(EALManager eALManager) {
        return eALManager.terminal;
    }

    static /* synthetic */ IMMICombiAnimationSyncer access$600(EALManager eALManager) {
        return eALManager.animationSyncer;
    }

    static /* synthetic */ IProject access$800(EALManager eALManager) {
        return eALManager.project;
    }

    static /* synthetic */ IRenderer access$900(EALManager eALManager) {
        return eALManager.renderer;
    }

    static /* synthetic */ boolean access$1100() {
        return partialRenderingEnabled;
    }

    static /* synthetic */ boolean access$1200() {
        return annotationsEnabled;
    }

    static {
        VARIANT_HIGH = System.getProperty("variant.skin", "EvoHigh").indexOf("EvoHigh") >= 0;
        IGNORE_EAL_STARTUP_ERRORS = Boolean.getBoolean("ignoreEALStartupErrors");
        USE_LONG_NODE_NAMES = Boolean.getBoolean("useLongNodeNames");
        ACTIVATE_IDLE_DESTROYING = SystemProperties.getBoolean("ActivateIdleDestroying", true);
        SHOW_MEMORY_USAGE = System.getProperty("showMemoryUsage") != null;
        SHOW_EVENT_QUEUE_STATISTIC = Boolean.getBoolean("showEventQueueStatistic");
        SHOW_SCREEN_INFO = Boolean.getBoolean("showScreenInfo");
        SHOW_DRAW_TIME_STATISTIC = System.getProperty("showDrawTimeStatistic") != null;
        TEXT_NODE_CACHE_DISABLED = SystemProperties.getBoolean("disableTextNodeCache", true);
        TEXTURE_CACHE_DISABLED = SystemProperties.getBoolean("disableTextureCache", false);
        EAL_OBJECT_TRACER_ENABLED = Boolean.getBoolean("EALEnableObjectTracer");
        DUMP_EAL_OBJECTS_ON_SCREEN_CHANGE = Boolean.getBoolean("EALEnableObjectTracingOnScreenChange");
        EAL_REGISTRY_ENABLED = Boolean.getBoolean("EALEnableRegistry");
        MAX_TIME_NODE_DESTROYING = Integer.getInteger("maxTimeNodeDestroying", 100);
        IDLE_DESTROYING_START = Integer.getInteger("idleDestroyingStart", 200);
        MAX_NO_OF_NODES_TO_DESTROY = Integer.getInteger("maxNoOfNodesToDestroy", 500);
        MEMORY_USAGE_UNIT = Integer.getInteger("memoryUsageUnit", 2);
        TEXTURE_CACHE_SIZES_DEFAULTS = new int[]{Integer.getInteger("textureCacheSize0", 2961665), Integer.getInteger("textureCacheSize1", -1060754176), Integer.getInteger("textureCacheCarViewerStandardSize", 5), Integer.getInteger("textureCacheAsyncSize", -1060754176)};
        TEXTURE_CACHE_SIZES = SystemProperties.getIntArray("textureCacheSizes", TEXTURE_CACHE_SIZES_DEFAULTS);
        TEXTURE_CACHE_TYPES = SystemProperties.getIntArray("textureCacheTypes", new int[]{1, 1, 0, 1});
        MAIN_AREA_DESATURATION = Integer.getInteger("mainAreaDesaturation", 2);
        ERROR_CORRECTION = Integer.getInteger("annotationErrorCorrection", 1);
        MAX_RECURSIVE_DEPTH_ADDING_CHECK = Integer.getInteger("maxRecursiveDepthAddingCheck", 10);
        MAX_NUMBER_OF_IDLE_RENDER_STEPS_FOR_OPS_ASYNC_MERGE = Integer.getInteger("maxNumberOfIdleRenderStepsForOpsAsyncMerge", 50);
        FONT_SIZES_PIXEL_H = new int[]{7, 8, 9, 10, 10, 11, 12, 13, 13, 15, 15, 16, 17, 18, 18, 19, 20, 21, 21, 22, 23, 24, 24, 25, 26, 26, 27, 28, 29, 29, 30, 31, 32, 32, 33, 35, 36, 36, 37, 38, 39, 39, 40, 41, 41, 43, 43, 44, 45, 46, 47};
        DUMP_EAL_INFO_EVERY_N_SECONDS = Integer.getInteger("EALEnableDumpEveryNSeconds", 0);
        LOW_MEMORY_DUMP_WHILE_TRACING_LEVEL = Integer.getInteger("LowMemoryDumpWhileTracingLevel", 0);
        DEFAULT_TEXT_COLOR = EALManager.createColorCode(-65281);
        DELAY_TIME_FOR_IDLE_RENDER_STEPS_FOR_OPS_ASYNC_MERGE = Integer.getInteger("delayTimeForIdleRenderStepsForOpsAsyncMerge", 50).intValue();
        partialRenderingEnabled = SystemProperties.getBoolean("partialRenderingEnabled", VARIANT_HIGH);
        partialOffscreenRenderingEnabled = partialRenderingEnabled && SystemProperties.getBoolean("partialOffscreenRenderingEnabled", partialRenderingEnabled);
        stringBuilder = new Buffer();
        flagImageMap = new HashMap();
        flagTextureMap = new HashMap();
        kzbMergeListener = new HashMap();
    }
}

