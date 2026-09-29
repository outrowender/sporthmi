/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.boardbook;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.boardbook.BoardbookEfiUrlHandler;
import de.audi.app.car.core.boardbook.BoardbookHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.phone.ITelStateListener;
import de.audi.atip.mmicombi.IViewSizeManager;

public abstract class AbstractCarBoardbookComponent
extends AbstractCarComponent
implements CarServiceTrackerListener,
ITelStateListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private final String LOGCLASS = (class$de$audi$app$car$core$boardbook$AbstractCarBoardbookComponent == null ? (class$de$audi$app$car$core$boardbook$AbstractCarBoardbookComponent = AbstractCarBoardbookComponent.class$("de.audi.app.car.core.boardbook.AbstractCarBoardbookComponent")) : class$de$audi$app$car$core$boardbook$AbstractCarBoardbookComponent).getName();
    private CarServiceTracker browserTracker;
    private CarServiceProvider telStateService;
    private IBrowserHandler browserHandler;
    protected BoardbookHandler boardbookHandler;
    private IMediaFilePlayerService mediaService;
    private IViewSizeManager viewSizeService;
    private IFrameworkAccess fwAccess;
    static /* synthetic */ Class class$de$audi$app$car$core$boardbook$AbstractCarBoardbookComponent;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelStateListener;
    static /* synthetic */ Class class$de$audi$atip$browser$IBrowserHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaFilePlayerService;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;

    public AbstractCarBoardbookComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Boardbook");
        this.fwAccess = iCarApplication.getFrameworkAccess();
    }

    @Override
    public void init() {
        super.init();
        this.browserTracker = new CarServiceTracker(this, this.getApplication().getBundleContext(), this.getLogChannel());
        this.browserTracker.startTracking();
        this.telStateService = new CarServiceProvider((class$de$audi$atip$interapp$phone$ITelStateListener == null ? (class$de$audi$atip$interapp$phone$ITelStateListener = AbstractCarBoardbookComponent.class$("de.audi.atip.interapp.phone.ITelStateListener")) : class$de$audi$atip$interapp$phone$ITelStateListener).getName(), this, null, this.getApplication().getBundleContext(), this.getLogChannel());
        this.telStateService.startService();
    }

    @Override
    public void deinit() {
        this.browserTracker.stopTracking();
        this.telStateService.stopService();
        this.telStateService = null;
        super.deinit();
    }

    @Override
    public String getName() {
        return "Boardbook";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    @Override
    public String getCurrentViewOptions() {
        return null;
    }

    @Override
    public void initModels() {
    }

    @Override
    public void deinitModels() {
    }

    @Override
    public void initVisibility() {
    }

    @Override
    public void deinitVisibility() {
    }

    @Override
    public String getDSIListenerClassName() {
        return null;
    }

    @Override
    public String getDSIClassName() {
        return null;
    }

    @Override
    public boolean isUsingDSI() {
        return false;
    }

    @Override
    public void serviceAvailable(Object object) {
        if (object instanceof IBrowserHandler) {
            if (this.browserTracker.getServiceInstance().equals(IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOARDBOOK)) {
                this.browserHandler = (IBrowserHandler)object;
                this.initializeBrowser();
            }
        } else if (object instanceof IMediaFilePlayerService) {
            if (this.browserHandler != null) {
                this.boardbookHandler.setMediaService((IMediaFilePlayerService)object);
            } else {
                this.mediaService = (IMediaFilePlayerService)object;
            }
        } else if (object instanceof IViewSizeManager) {
            if (this.browserHandler != null) {
                this.boardbookHandler.setViewSizeService((IViewSizeManager)object);
            } else {
                this.viewSizeService = (IViewSizeManager)object;
            }
        }
    }

    @Override
    public void serviceRemoved() {
        if (this.boardbookHandler != null) {
            this.boardbookHandler.setMediaService(null);
        }
        this.browserHandler = null;
    }

    public void returntoVideoOverView() {
        this.boardbookHandler.returnFromVideoToBoardbook();
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = AbstractCarBoardbookComponent.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName(), (class$de$audi$atip$interapp$media$IMediaFilePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaFilePlayerService = AbstractCarBoardbookComponent.class$("de.audi.atip.interapp.media.IMediaFilePlayerService")) : class$de$audi$atip$interapp$media$IMediaFilePlayerService).getName(), (class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = AbstractCarBoardbookComponent.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager).getName()};
    }

    protected void startBoardbook() {
        if (this.browserHandler != null) {
            this.getLogChannel().log(1078071040, "%1#startBoardbook()", (Object)this.LOGCLASS);
            this.browserHandler.resumeBrowser();
        }
    }

    protected void stopBoardbook() {
        if (this.browserHandler != null) {
            this.getLogChannel().log(1078071040, "%1#stopBoardbook()", (Object)this.LOGCLASS);
            this.browserHandler.suspendBrowser();
        }
    }

    protected void stopMediaPlayback() {
        this.boardbookHandler.returnFromVideoToBoardbook();
    }

    private void initializeBrowser() {
        this.browserHandler.initialize(this.getVirtualButtonModel(1680673024), this.getChoiceModel(-1171584768), this.getChoiceModel(-1188361984), this.getChoiceModel(-1138030336), this.getChoiceModel(-1154807552), 5);
        this.browserHandler.setLabels(this.getLabelModel(-869594880));
        this.browserHandler.setModels(null, this.getChoiceModel(-886372096), this.getChoiceModel(-903149312), this.getButtonModel(-1020589824), this.getButtonModel(-936703744), this.getButtonModel(-1205139200), this.getButtonModel(-1993602816), this.getButtonModel(-1976825600), this.getChoiceModel(137234688), this.getButtonModel(640551168));
        this.browserHandler.setRangeModels(this.getRangeModel(-953480960));
        this.browserHandler.setZoomLabel(this.getLabelModel(-852817664));
        this.browserHandler.setBoardBookAvailableModel(this.getChoiceModel(-1238693632));
        this.boardbookHandler.setBrowserHandler(this.browserHandler);
        this.boardbookHandler.initializeModels(this.getButtonModel(-1104475904), this.getChoiceModel(-1121253120), this.getLabelModel(-1037367040), this.getLabelModel(-1054144256), this.getLabelModel(-1087698688), this.getRangeModel(-1070921472));
        this.boardbookHandler.setErrorChoiceModel(this.getChoiceModel(-987035392));
        this.boardbookHandler.setErrorButtonModel(this.getButtonModel(-970258176));
        if (this.mediaService != null) {
            this.boardbookHandler.setMediaService(this.mediaService);
        }
        if (this.viewSizeService != null) {
            this.boardbookHandler.setViewSizeService(this.viewSizeService);
        }
        this.browserHandler.setBrowserCallbackHandler(this.boardbookHandler);
        BoardbookEfiUrlHandler boardbookEfiUrlHandler = new BoardbookEfiUrlHandler(this.getLogChannel(), this.boardbookHandler);
        this.browserHandler.setEfiUrlHandler(boardbookEfiUrlHandler);
        this.browserHandler.setBoardBookConfigured(true);
        this.getLogChannel().log(1078071040, "IBrowserHandler initialized");
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

