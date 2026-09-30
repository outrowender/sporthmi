/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.vps;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemComponent;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;
import org.dsi.ifc.carparkingsystem.VPSConfiguration;
import org.dsi.ifc.carparkingsystem.VPSSupportedRVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedViews;

public abstract class AbstractParkingSystemVPSComponent
extends AbstractParkingSystemComponent
implements ChoiceListener {
    private static final int VPS_TYPE_NO_VPS = 0;
    private static final int VPS_TYPE_RVC_ONLY = 1;
    private static final int VPS_TYPE_VPS = 2;
    protected static final int PARK_MODE_INVALID = -1;
    protected static final int PARK_MODE_NOMODE = 0;
    protected static final int PARK_MODE_PARALLEL = 1;
    protected static final int PARK_MODE_PARKBOX = 2;
    protected static final int PARK_MODE_TRAILER_ASSIST = 3;
    protected static final int PARK_MODE_LEFT_RIGHT_SIDEVIEW = 4;
    public static final int VPS_VIEW_INVALID = -1;
    public static final int VPS_VIEW_FRONTVIEW = 0;
    public static final int VPS_VIEW_REARVIEW = 1;
    public static final int VPS_VIEW_CORNERVIEW_FRONT = 2;
    public static final int VPS_VIEW_CORNERVIEW_REAR = 3;
    public static final int VPS_VIEW_TOPVIEW = 4;
    public static final int VPS_VIEW_SIDEVIEW = 5;
    protected static final int VPS_SCREEN_INVALID = -1;
    protected static final int VPS_SCREEN_FULLSCREEN = 0;
    protected static final int VPS_SCREEN_SPLITSCREEN = 1;
    private static final int VPS_CAMERA_STATE_SIDEVIEW_FUNCTIONAL = 0;
    private static final int VPS_CAMERA_STATE_SIDEVIEW_FOLDED_MIRROR = 1;
    private static final int VPS_CAMERA_STATE_SIDEVIEW_OPEN_DOOR = 2;
    private static final int VPS_CAMERA_STATE_FRONT_REAR_VIEW_FUNCTIONAL = 0;
    private static final int VPS_CAMERA_STATE_FRONT_REAR_VIEW_OPEN_HOOD_OR_TRUNK = 1;
    private CarServiceTracker displayManagerServiceTracker;
    private IDisplayManagerService displayManagerService;
    protected volatile boolean guidingLinesEnabled = true;
    protected volatile int selectedParkMode;
    private final ChoiceModelApp currentVPSScreenChoiceModel;
    private boolean cameraCleaningActive = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$displaymanager$IDisplayManagerService;

    public AbstractParkingSystemVPSComponent(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController, "App.EarlyFunc.Parking.VPS");
        this.displayManagerServiceTracker = new CarServiceTracker(new DisplayManagerServiceTrackerListener(), iCarApplication.getBundleContext(), this.getLogChannel());
        this.currentVPSScreenChoiceModel = this.getChoiceModel(2100345);
    }

    public void init() {
        this.getChoiceModel(2100198).setValue(3);
        this.controller.getOPSViewModeHandler().updateVPSView(-1);
        super.init();
        this.displayManagerServiceTracker.startTracking();
    }

    public void deinit() {
        super.deinit();
        this.displayManagerServiceTracker.stopTracking();
    }

    public String getName() {
        return "Parking system VPS";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{44, 70, 79})};
    }

    protected void initModels() {
        this.getChoiceModel(2100179).setValue(-1);
        this.getChoiceModel(2100337).setChoiceListener(this);
        this.getChoiceModel(2100152).setChoiceListener(this);
        this.getChoiceModel(2100179).setChoiceListener(this);
        this.getButtonModel(2100558).setButtonListener(new VPSCameraCleaningButtonListener());
        this.getCurrentVPSScreenChoiceModel().setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(2100337).resetListener();
        this.getChoiceModel(2100152).resetListener();
        this.getChoiceModel(2100179).resetListener();
        this.getChoiceModel(2100552).resetListener();
        this.getButtonModel(2100558).resetListener();
        this.getCurrentVPSScreenChoiceModel().resetListener();
    }

    public void setActive(boolean bl, DisplayContent displayContent) {
        this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#setActive] active=%1, displayContent=%2", bl, (Object)displayContent);
        if (bl) {
            this.updateVPSScreen(displayContent.screen, displayContent.view, displayContent.mode);
            this.updateParkMode(displayContent.mode);
            this.updateVPSView(displayContent.view, displayContent.mode);
            this.getChoiceModel(2100346).setValue(0);
            this.setDisplayManagerComponentActive(true);
            this.controller.addPopupRequest(this.getHMIPopupID(displayContent.getPopup()), this);
            this.getApplication().getFrameworkAccess().getStartupMgr().setRVCActive(true);
        } else {
            this.controller.removePopupRequest(this.getHMIPopupID(this.controller.getCurrentDisplayContent().getPopup()), this);
            this.getApplication().getFrameworkAccess().getStartupMgr().setRVCActive(false);
            this.setDisplayManagerComponentActive(false);
            this.updateParkMode(-1);
            this.updateVPSView(0, 0);
            this.updateVPSScreen(0, 0, 0);
        }
        this.controller.notifyParkingSystemActive(this, bl);
    }

    private void setDisplayManagerComponentActive(boolean bl) {
        if (this.displayManagerService != null) {
            if (bl) {
                this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#setDisplayManagerComponentActive] displayManagerService.activateComponent()");
                this.displayManagerService.activateComponentRVC(17);
            } else {
                this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#setDisplayManagerComponentActive] displayManagerService.deactivateComponent()");
                this.displayManagerService.deactivateComponentRVC(17);
            }
        } else {
            this.getLogChannel().log(100000, "[AbstractParkingSystemVPSComponent#setDisplayManagerComponentActive] displayManagerService is null");
        }
    }

    public int[] getSupportedDSIPopupIDs() {
        return new int[]{2, 3, 8, 12, 13, 14, 16, 18};
    }

    public int getParkingSystemID() {
        return 4;
    }

    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        super.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
        if (n == 1 && parkingSystemViewOptions != null) {
            boolean bl = false;
            if (parkingSystemViewOptions.getVpsConfiguration() != null) {
                VPSSupportedRVModes vPSSupportedRVModes;
                VPSConfiguration vPSConfiguration = parkingSystemViewOptions.getVpsConfiguration();
                VPSSupportedViews vPSSupportedViews = vPSConfiguration.getSupportedViews();
                if (vPSSupportedViews != null) {
                    boolean bl2 = vPSSupportedViews.isRearview();
                    boolean bl3 = vPSSupportedViews.isFrontview();
                    boolean bl4 = vPSSupportedViews.isRearview() && vPSConfiguration.getSupportedRVModes() != null && vPSConfiguration.getSupportedRVModes().isCrossing();
                    boolean bl5 = vPSSupportedViews.isFrontview() && vPSConfiguration.getSupportedFVModes() != null && vPSConfiguration.getSupportedFVModes().isCrossing();
                    boolean bl6 = vPSSupportedViews.isBirdview();
                    boolean bl7 = vPSSupportedViews.isLeftsideview() && vPSSupportedViews.isRightsideview();
                    this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#updateParkingSystemViewOptions] rearViewAvailable=%1", bl2);
                    this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#updateParkingSystemViewOptions] frontViewAvailable=%1", bl3);
                    this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#updateParkingSystemViewOptions] cornerViewRearAvailable=%1", bl4);
                    this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#updateParkingSystemViewOptions] cornerViewFrontAvailable=%1", bl5);
                    this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#updateParkingSystemViewOptions] topViewAvailable=%1", bl6);
                    this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#updateParkingSystemViewOptions] sideViewAvailable=%1", bl7);
                    if (bl2 || bl3 || bl6 || bl7) {
                        bl = true;
                        this.getChoiceModel(2100180).setValue(!bl3 && !bl6 && !bl7 ? 1 : 2);
                    }
                    this.getChoiceModel(2100177).setValue(bl2 ? 0 : 1);
                    this.getChoiceModel(2100176).setValue(bl3 ? 0 : 1);
                    this.getChoiceModel(2100175).setValue(bl4 ? 0 : 1);
                    this.getChoiceModel(2100174).setValue(bl5 ? 0 : 1);
                    this.getChoiceModel(2100178).setValue(bl6 ? 0 : 1);
                    this.getChoiceModel(2100334).setValue(bl6 ? 0 : 1);
                }
                if ((vPSSupportedRVModes = vPSConfiguration.getSupportedRVModes()) != null) {
                    this.getChoiceModel(2100335).setValue(vPSSupportedRVModes.trailerAssist ? 0 : 1);
                    this.getChoiceModel(2100406).setValue(vPSSupportedRVModes.trailerAssistARA ? 0 : 1);
                }
                this.updateMenuEntryVisibility(parkingSystemViewOptions);
            }
            if (bl) {
                this.controller.registerParkingSystemComponent(this);
            } else {
                this.getChoiceModel(2100180).setValue(0);
                this.controller.unregisterParkingSystemComponent(this);
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 2100337) {
            this.switchParkMode(n2 == 1 ? 3 : 2);
        } else if (n == 2100152) {
            this.switchParkMode(n2);
        } else if (n == 2100179) {
            this.switchVPSView(n2);
        } else if (n == this.getCurrentVPSScreenChoiceModel().getID()) {
            this.switchVPSScreen(n2);
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    protected void setGuidingLinesEnabled(boolean bl) {
        if (this.guidingLinesEnabled != bl) {
            this.guidingLinesEnabled = bl;
            this.switchParkMode(this.selectedParkMode);
        }
    }

    private void switchParkMode(int n) {
        this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#switchParkMode] parkMode=%1", (long)n);
        boolean bl = this.currentViewOptions.getVpsConfiguration().getSupportedRVModes().isParallelToRoad();
        boolean bl2 = this.currentViewOptions.getVpsConfiguration().getSupportedRVModes().isParkbox();
        boolean bl3 = this.currentViewOptions.getVpsConfiguration().getSupportedRVModes().isTrailerAssist();
        switch (n) {
            case 0: {
                this.selectedParkMode = 0;
                break;
            }
            case 1: {
                this.selectedParkMode = 2;
                if (bl) break;
                this.getLogChannel().log(10000, "[AbstractParkingSystemVPSComponent#switchParkMode] parkmode 'parallelToRoad' not supported");
                break;
            }
            case 2: {
                this.selectedParkMode = 1;
                if (bl2) break;
                this.getLogChannel().log(10000, "[AbstractParkingSystemVPSComponent#switchParkMode] parkmode 'parkbox' not supported");
                break;
            }
            case 3: {
                this.selectedParkMode = 8;
                if (bl3) break;
                this.getLogChannel().log(10000, "[AbstractParkingSystemVPSComponent#switchParkMode] parkmode 'trailerAssist' not supported");
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractParkingSystemVPSComponent#switchParkMode] invalid park mode selected: %1", (long)n);
                return;
            }
        }
        int n2 = this.guidingLinesEnabled ? this.selectedParkMode : 0;
        DisplayContent displayContent = new DisplayContent();
        DisplayContent displayContent2 = this.controller.getCurrentDisplayContent();
        if (displayContent2.mode == n2) {
            this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#switchParkMode] park mode already active");
        } else {
            displayContent.popup = displayContent2.popup;
            displayContent.view = 8 == n2 ? 1 : displayContent2.view;
            displayContent.screen = displayContent2.screen;
            displayContent.mode = n2;
            this.getLogChannel().log(1000000, "[AbstractParkingSystemVPSComponent#switchParkMode] switch park mode", (Object)displayContent);
            this.controller.changeDisplayContent(displayContent, false);
        }
    }

    private void updateParkMode(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 8: {
                n2 = 3;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        this.getChoiceModel(2100152).setValue(n2);
        this.getChoiceModel(2100337).setValue(n2 == 3 ? 1 : 0);
    }

    protected void switchVPSView(int n) {
        int n2;
        int n3;
        this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#switchVPSView] view=%1", (long)n);
        switch (n) {
            case 0: {
                n3 = 2;
                n2 = 1;
                break;
            }
            case 1: {
                n3 = 1;
                n2 = this.selectedParkMode == 1 || this.selectedParkMode == 8 ? this.selectedParkMode : 1;
                break;
            }
            case 2: {
                n3 = 2;
                n2 = 7;
                break;
            }
            case 3: {
                n3 = 1;
                n2 = 7;
                break;
            }
            case 4: {
                n3 = 4;
                n2 = 9;
                break;
            }
            case 5: {
                n3 = 3;
                n2 = 6;
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractParkingSystemVPSComponent#switchVPSView] invalid view selected: %1", (long)n);
                return;
            }
        }
        DisplayContent displayContent = new DisplayContent();
        DisplayContent displayContent2 = this.controller.getCurrentDisplayContent();
        if (displayContent2.view == n3 && displayContent2.mode == n2) {
            this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent#switchVPSView] view already active");
        } else {
            displayContent.popup = displayContent2.popup;
            displayContent.screen = displayContent2.screen;
            displayContent.view = n3;
            displayContent.mode = n2;
            this.getLogChannel().log(1000000, "[AbstractParkingSystemVPSComponent#switchVPSView] switch vps view", (Object)displayContent);
            this.controller.changeDisplayContent(displayContent);
        }
    }

    protected void updateVPSView(int n, int n2) {
        int n3;
        switch (n) {
            case 0: {
                n3 = -1;
                break;
            }
            case 2: {
                if (n2 == 7) {
                    n3 = 2;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1: {
                if (n2 == 7) {
                    n3 = 3;
                    break;
                }
                n3 = 1;
                break;
            }
            case 4: {
                n3 = 4;
                break;
            }
            case 3: {
                n3 = 5;
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractParkingSystemVPSComponent#updateVPSView] invalid view: %1", (long)n);
                return;
            }
        }
        this.getChoiceModel(2100179).setValue(n3);
        this.controller.getOPSViewModeHandler().updateVPSView(n3);
    }

    protected void switchVPSScreen(int n) {
    }

    protected void updateVPSScreen(int n, int n2, int n3) {
    }

    public void updateVPSCameraStates(VPSCameraStates vPSCameraStates, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemVPSComponent#updateVPSCameraStates] cameraStates=%1, valid=%2", (Object)vPSCameraStates, (long)n);
        if (n == 1) {
            this.updateSideViewCameraState(vPSCameraStates.getLeftCamera(), 2100304);
            this.updateSideViewCameraState(vPSCameraStates.getRightCamera(), 2100306);
            this.updateFrontRearViewCameraState(vPSCameraStates.getRearCamera(), 2100305);
            this.updateFrontRearViewCameraState(vPSCameraStates.getFrontCamera(), 2100307);
        }
    }

    private void updateSideViewCameraState(int n, int n2) {
        int n3 = 0;
        if (n == 6) {
            n3 = 1;
        } else if (this.isAnyDoorOpen(n)) {
            n3 = 2;
        }
        this.setCameraStateIconChoice(n, n2, n3);
    }

    private void updateFrontRearViewCameraState(int n, int n2) {
        int n3 = 0;
        if (n2 == 2100305 ? n == 7 : n == 8) {
            n3 = 1;
        }
        this.setCameraStateIconChoice(n, n2, n3);
    }

    private void setCameraStateIconChoice(int n, int n2, int n3) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemVPSComponent#setCameraStateIconChoice] set model value to select VPS camera state icon and to decide whether camera display is substituted by a gray area: modelID='%1', iconChoiceValue='%2', cameraState='%3'", (long)n2, (long)n3, (long)n);
        }
        this.getChoiceModel(n2).setValue(n3);
    }

    private boolean isAnyDoorOpen(int n) {
        return n == 9 || n == 10 || n == 11 || n == 12 || n == 13 || n == 14;
    }

    public int getCurrentVPSView() {
        return this.getChoiceModel(2100179).getValue();
    }

    public boolean isTrailerAssistActive() {
        return this.getChoiceModel(2100152).getValue() == 3;
    }

    protected ChoiceModelApp getCurrentVPSScreenChoiceModel() {
        return this.currentVPSScreenChoiceModel;
    }

    protected abstract void updateMenuEntryVisibility(ParkingSystemViewOptions var1);

    public void updateVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemVPSComponent#updateVPSCameraCleaning] cameraStates=%1, valid=%2", (Object)vPSCameraCleaning, (long)n);
        if (n == 1 && vPSCameraCleaning != null) {
            this.cameraCleaningActive = vPSCameraCleaning.isRearCamera();
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

    private class VPSCameraCleaningButtonListener
    extends DefaultButtonListener {
        public void keyPressed(int n, int n2, int n3) {
            Object object;
            if (AbstractParkingSystemVPSComponent.this.cameraCleaningActive) {
                AbstractParkingSystemVPSComponent.this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent.VPSCameraCleaningButtonListener#keyPressed] Cleaning already active - ignoring");
            } else {
                AbstractParkingSystemVPSComponent.this.getLogChannel().log(10000000, "[AbstractParkingSystemVPSComponent.VPSCameraCleaningButtonListener#keyPressed] Activating cleaning: getDSI().setVPSCameraCleaning ");
                object = new VPSCameraCleaning(true);
                AbstractParkingSystemVPSComponent.this.getDSI().setVPSCameraCleaning((VPSCameraCleaning)object);
            }
            object = AbstractParkingSystemVPSComponent.this.getApplication().getFrameworkAccess().getHMIService();
            DrawerEvent drawerEvent = new DrawerEvent(object.getRootWindow(0), 2);
            object.getEventDispatcher().postEvent(drawerEvent);
        }
    }

    private class DisplayManagerServiceTrackerListener
    implements CarServiceTrackerListener {
        private DisplayManagerServiceTrackerListener() {
        }

        public void serviceAvailable(Object object) {
            AbstractParkingSystemVPSComponent.this.displayManagerService = (IDisplayManagerService)object;
        }

        public void serviceRemoved() {
            AbstractParkingSystemVPSComponent.this.displayManagerService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$displaymanager$IDisplayManagerService == null ? (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService = AbstractParkingSystemVPSComponent.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerService")) : class$de$audi$atip$interapp$displaymanager$IDisplayManagerService).getName()};
        }
    }
}

