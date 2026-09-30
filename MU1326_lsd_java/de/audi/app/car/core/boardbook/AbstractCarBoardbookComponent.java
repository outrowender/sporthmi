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
    public static final short CODING_ID = 111;
    private static final String LOGCHANNEL_NAME = "App.Car.Boardbook";
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
        super(iCarApplication, LOGCHANNEL_NAME);
        this.fwAccess = iCarApplication.getFrameworkAccess();
    }

    public void init() {
        super.init();
        this.browserTracker = new CarServiceTracker(this, this.getApplication().getBundleContext(), this.getLogChannel());
        this.browserTracker.startTracking();
        this.telStateService = new CarServiceProvider((class$de$audi$atip$interapp$phone$ITelStateListener == null ? (class$de$audi$atip$interapp$phone$ITelStateListener = AbstractCarBoardbookComponent.class$("de.audi.atip.interapp.phone.ITelStateListener")) : class$de$audi$atip$interapp$phone$ITelStateListener).getName(), this, null, this.getApplication().getBundleContext(), this.getLogChannel());
        this.telStateService.startService();
    }

    public void deinit() {
        this.browserTracker.stopTracking();
        this.telStateService.stopService();
        this.telStateService = null;
        super.deinit();
    }

    public String getName() {
        return "Boardbook";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    public String getCurrentViewOptions() {
        return null;
    }

    public void initModels() {
    }

    public void deinitModels() {
    }

    public void initVisibility() {
    }

    public void deinitVisibility() {
    }

    public String getDSIListenerClassName() {
        return null;
    }

    public String getDSIClassName() {
        return null;
    }

    public boolean isUsingDSI() {
        return false;
    }

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

    public void serviceRemoved() {
        if (this.boardbookHandler != null) {
            this.boardbookHandler.setMediaService(null);
        }
        this.browserHandler = null;
    }

    public void returntoVideoOverView() {
        this.boardbookHandler.returnFromVideoToBoardbook();
    }

    public String[] getTrackedServiceClazzName() {
        return new String[]{(class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = AbstractCarBoardbookComponent.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName(), (class$de$audi$atip$interapp$media$IMediaFilePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaFilePlayerService = AbstractCarBoardbookComponent.class$("de.audi.atip.interapp.media.IMediaFilePlayerService")) : class$de$audi$atip$interapp$media$IMediaFilePlayerService).getName(), (class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = AbstractCarBoardbookComponent.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager).getName()};
    }

    protected void startBoardbook() {
        if (this.browserHandler != null) {
            this.getLogChannel().log(1000000, "%1#startBoardbook()", (Object)this.LOGCLASS);
            this.browserHandler.resumeBrowser();
        }
    }

    protected void stopBoardbook() {
        if (this.browserHandler != null) {
            this.getLogChannel().log(1000000, "%1#stopBoardbook()", (Object)this.LOGCLASS);
            this.browserHandler.suspendBrowser();
        }
    }

    protected void stopMediaPlayback() {
        this.boardbookHandler.returnFromVideoToBoardbook();
    }

    private void initializeBrowser() {
        this.browserHandler.initialize(this.getVirtualButtonModel(601444), this.getChoiceModel(601018), this.getChoiceModel(601017), this.getChoiceModel(601020), this.getChoiceModel(601019), 5);
        this.browserHandler.setLabels(this.getLabelModel(601036));
        this.browserHandler.setModels(null, this.getChoiceModel(601035), this.getChoiceModel(601034), this.getButtonModel(601027), this.getButtonModel(601032), this.getButtonModel(601016), this.getButtonModel(601225), this.getButtonModel(601226), this.getChoiceModel(601608), this.getButtonModel(601638));
        this.browserHandler.setRangeModels(this.getRangeModel(601031));
        this.browserHandler.setZoomLabel(this.getLabelModel(601037));
        this.browserHandler.setBoardBookAvailableModel(this.getChoiceModel(601014));
        this.boardbookHandler.setBrowserHandler(this.browserHandler);
        this.boardbookHandler.initializeModels(this.getButtonModel(601022), this.getChoiceModel(601021), this.getLabelModel(601026), this.getLabelModel(601025), this.getLabelModel(601023), this.getRangeModel(601024));
        this.boardbookHandler.setErrorChoiceModel(this.getChoiceModel(601029));
        this.boardbookHandler.setErrorButtonModel(this.getButtonModel(601030));
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
        this.getLogChannel().log(1000000, "IBrowserHandler initialized");
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

