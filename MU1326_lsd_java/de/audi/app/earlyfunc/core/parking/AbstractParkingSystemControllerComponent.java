/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.car.common.adapter.AbstractDSICarParkingSystemAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$LocalMsgListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$LogUtil;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$PSCServiceTrackerCustomizer;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$PowerEventListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$SDSServiceTrackerListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$VPSAbortButtonListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$VPSShowButtonListener;
import de.audi.app.earlyfunc.core.parking.IParkingPopupHandler;
import de.audi.app.earlyfunc.core.parking.IParkingSystem;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.IParkingSystemHighProtocol;
import de.audi.app.earlyfunc.core.parking.ParkingPartialPopupHandler;
import de.audi.app.earlyfunc.core.parking.ParkingPopupHandler;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.ParkingServiceTracker;
import de.audi.app.earlyfunc.core.parking.ara.AbstractParkingSystemARAComponent;
import de.audi.app.earlyfunc.core.parking.ops.OPSViewModeHandler;
import de.audi.app.earlyfunc.core.parking.pla.AbstractParkingSystemPLAComponent;
import de.audi.app.earlyfunc.core.parking.vps.AbstractParkingSystemVPSComponent;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.power.IPowerManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractParkingSystemControllerComponent
extends AbstractDSICarParkingSystemAdapter
implements IParkingSystemController,
IParkingSystemHighProtocol {
    public static final short CODING_ID;
    public final AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry[] parkingSystemSubSystemSet = new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry[]{new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 0, false, false, false, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 1, false, true, false, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 2, false, false, true, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 3, false, true, true, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 4, false, true, false, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 5, false, false, false, false, false, true), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 6, false, false, false, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 7, false, true, false, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 8, false, true, true, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 9, false, false, false, true, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 10, false, true, false, true, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 11, false, true, false, true, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 12, false, false, true, true, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 13, false, true, true, true, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 14, false, true, true, true, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 15, false, true, false, false, true, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 16, false, true, true, false, true, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 17, false, true, false, false, false, false), new AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(this, 18, false, true, true, false, false, false)};
    private final AbstractParkingSystemControllerComponent$LocalMsgListener msgListener;
    protected volatile ParkingSystemViewOptions currentViewOptions;
    protected volatile DisplayContent currentDisplayContent = new DisplayContent();
    private DisplayContent lastContentUpdate;
    private DisplayContent deferredPopupRequest;
    private IParkingPopupHandler popupHandler;
    private ParkingPartialPopupHandler partialPopupHandler;
    private IPowerManager powerManager;
    private final MsgDistributor msgDistributor;
    private AbstractParkingSystemControllerComponent$PowerEventListener powerEventListener;
    private SimpleIntObjectMap availableParkingSystems = new SimpleIntObjectMap();
    private Map parkingSystemsForPopup = new HashMap();
    protected static final Object mutex;
    private LogChannel logMSC;
    private volatile CarServiceTracker sdsServiceTracker;
    private volatile ParkingServiceTracker audioDrawerServiceTracker;
    private volatile AudioDrawerContext audioDrawerContextService;
    private SDSService sdsService;
    private Hashtable popupRequests = new Hashtable();
    private OPSViewModeHandler opsViewModeHandler;
    private boolean firstUpdateContentReceived = false;
    private boolean plaActive = false;
    private boolean highProtocol = false;
    private final HashSet highProtocolReasons = new HashSet();
    final int VPS_CLEANING_MODE_INVALID;
    final int VPS_CLEANING_MODE_VALID;
    private static final int RIGHT_DRAWER_VISIBLE;
    private static final int RIGHT_DRAWER_INVISIBLE;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;

    protected void parkingSoftkeyPressed() {
    }

    protected boolean isQueuedContent() {
        return false;
    }

    protected void restoreParkingContent() {
    }

    public AbstractParkingSystemControllerComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.Parking");
        this.VPS_CLEANING_MODE_INVALID = 0;
        this.VPS_CLEANING_MODE_VALID = 1;
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.EarlyFunc.Parking.MSC");
        this.msgListener = new AbstractParkingSystemControllerComponent$LocalMsgListener(this, null);
        this.popupHandler = new ParkingPopupHandler(iCarApplication, this, this.getLogChannel());
        this.partialPopupHandler = new ParkingPartialPopupHandler(iCarApplication, this, this.getLogChannel());
        this.powerManager = this.getApplication().getFrameworkAccess().getPowerMgr();
        this.powerEventListener = new AbstractParkingSystemControllerComponent$PowerEventListener(this, null);
        iCarApplication.getPowerEventDispatcher().addPowerEventListener(this.powerEventListener);
        this.opsViewModeHandler = new OPSViewModeHandler(iCarApplication, this.getLogChannel());
        this.msgDistributor = iCarApplication.getFrameworkAccess().getMsgDistrib();
        this.sdsServiceTracker = new CarServiceTracker(new AbstractParkingSystemControllerComponent$SDSServiceTrackerListener(this, null), iCarApplication.getBundleContext(), this.getLogChannel());
    }

    @Override
    public String getName() {
        return "Parking system";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{44, 32, 45, 26})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        Object object = mutex;
        synchronized (object) {
            this.logMSC.log(1078071040, "---> setHMIStateIsReady(%1)", bl);
            this.getDSI().setHMIStateIsReady(bl);
        }
    }

    @Override
    public void init() {
        this.partialPopupHandler.initServiceProvider();
        this.sdsServiceTracker.startTracking();
        this.audioDrawerServiceTracker = new ParkingServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = AbstractParkingSystemControllerComponent.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext).getName(), (ServiceTrackerCustomizer)new AbstractParkingSystemControllerComponent$PSCServiceTrackerCustomizer(this, null), this.getLogChannel());
        this.audioDrawerServiceTracker.openTracker();
        this.opsViewModeHandler.updateOPSViewMode();
        this.getButtonModel(1611407360).setButtonListener(new AbstractParkingSystemControllerComponent$VPSAbortButtonListener(this, null));
        this.getButtonModel(1779179520).setButtonListener(new AbstractParkingSystemControllerComponent$VPSShowButtonListener(this, null));
        this.getApplication().getMessageDispatcher().addMessageListener(2, this.msgListener);
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
        super.init();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.partialPopupHandler.deinitServiceProvider();
        this.sdsServiceTracker.stopTracking();
        if (this.audioDrawerServiceTracker != null) {
            this.audioDrawerServiceTracker.closeTracker();
            this.audioDrawerServiceTracker = null;
        }
        this.getButtonModel(1611407360).resetListener();
        this.getButtonModel(1779179520).resetListener();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
        this.getApplication().getMessageDispatcher().removeMessageListener(2, this.msgListener);
    }

    @Override
    public void registerParkingSystemComponent(IParkingSystem iParkingSystem) {
        int n = iParkingSystem.getParkingSystemID();
        this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#registerParkingSystemComponent] parking system registered: %1", (long)n);
        if (this.availableParkingSystems.get(n) != null) {
            this.getLogChannel().log(-1601830656, "[AbstractParkingSystemControllerComponent#registerParkingSystemComponent] a parking system of the same type (%1) is already registered", (long)n);
        }
        this.availableParkingSystems.add(n, iParkingSystem);
        this.removePopupMapping(iParkingSystem);
        this.addPopupMapping(iParkingSystem);
        if (this.deferredPopupRequest != null && this.isPopupSupported(this.deferredPopupRequest, true)) {
            if (this.currentViewOptions != null) {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#registerParkingSystemComponent] deferred popup request is now executed");
                this.requestParkingPopup(this.deferredPopupRequest);
            } else {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#registerParkingSystemComponent] no view options -> defer popup request");
            }
        }
    }

    @Override
    public void unregisterParkingSystemComponent(IParkingSystem iParkingSystem) {
        this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#unregisterParkingSystemComponent] parking system unregistered: %1", (long)iParkingSystem.getParkingSystemID());
        this.availableParkingSystems.remove(iParkingSystem.getParkingSystemID());
        this.removePopupMapping(iParkingSystem);
    }

    @Override
    public SimpleIntObjectMap getAvailableParkingSystems() {
        return this.availableParkingSystems;
    }

    @Override
    public IParkingPopupHandler getPopupHandler() {
        return this.popupHandler;
    }

    @Override
    public ParkingPartialPopupHandler getPartialPopupHandler() {
        return this.partialPopupHandler;
    }

    @Override
    public OPSViewModeHandler getOPSViewModeHandler() {
        return this.opsViewModeHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public DisplayContent getCurrentDisplayContent() {
        Object object = mutex;
        synchronized (object) {
            return this.currentDisplayContent;
        }
    }

    @Override
    public void changeDisplayContent(DisplayContent displayContent) {
        this.showParkingPopup(displayContent, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void changeDisplayContent(DisplayContent displayContent, boolean bl) {
        if (bl) {
            Object object = mutex;
            synchronized (object) {
                this.lastContentUpdate = this.currentDisplayContent;
                this.currentDisplayContent = new DisplayContent();
            }
        } else {
            this.deactivateCurrentlyVisibleParkingSystems(displayContent, this.getInvolvedParkingSystems(displayContent));
        }
        this.showParkingPopup(displayContent, !bl);
    }

    @Override
    public void notifyPopupCanceled(int n) {
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPopupCanceled] cancelReason=%1", (long)n);
        if (n == 1) {
            if (this.partialPopupHandler.isPopupActive()) {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPopupCanceled] a partialPopup is still visible");
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPopupCanceled] canceled by ASG: also cancel partial popup");
                this.partialPopupHandler.removeCurrentPopup(n);
            }
            this.cancelParkingPopup(n);
        } else {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPopupCanceled] cancelReason=FSG -> nothing to do");
        }
        this.updateInterappClients(!this.plaActive && this.isAnyParkingSystemActive() || this.plaActive);
    }

    @Override
    public void notifyPartialPopupCanceled(int n) {
        if (n == 1) {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPartialPopupCanceled] cancelReason=ASG");
            if (this.popupHandler.isPopupActive()) {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPartialPopupCanceled] a popup is still visible");
            } else if (this.currentDisplayContent.popup != 0) {
                this.cancelParkingPopup(n);
            } else {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPartialPopupCanceled] no cancel because popup was not requested by FSG");
            }
        } else {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyPopupCanceled] cancelReason=FSG -> nothing to do");
        }
        this.updateInterappClients(!this.plaActive && this.isAnyParkingSystemActive() || this.plaActive);
    }

    @Override
    public void notifyParkingSystemActive(IParkingSystem iParkingSystem, boolean bl) {
        if (iParkingSystem.getParkingSystemID() == 2) {
            IParkingSystem iParkingSystem2;
            this.opsViewModeHandler.updateOPSActive(bl);
            IParkingSystem iParkingSystem3 = (IParkingSystem)this.availableParkingSystems.get(16);
            if (iParkingSystem3 instanceof AbstractParkingSystemPLAComponent && iParkingSystem3.getParkingSystemID() != iParkingSystem.getParkingSystemID()) {
                ((AbstractParkingSystemPLAComponent)iParkingSystem3).notifyOPSActive(bl);
            }
            if ((iParkingSystem2 = (IParkingSystem)this.availableParkingSystems.get(8)) instanceof AbstractParkingSystemARAComponent && iParkingSystem2.getParkingSystemID() != iParkingSystem.getParkingSystemID()) {
                ((AbstractParkingSystemARAComponent)iParkingSystem2).notifyOPSActive(bl);
            }
        } else if (iParkingSystem.getParkingSystemID() == 4) {
            this.reconfigParkingOptionDrawer();
        } else if (iParkingSystem.getParkingSystemID() == 8) {
            this.opsViewModeHandler.updateARAActive(bl);
            this.reconfigParkingOptionDrawer();
        } else if (iParkingSystem.getParkingSystemID() == 16) {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#notifyParkingSystemActive] PLA component parking popup interference is %1.", (Object)(bl ? "active" : "inactive"));
            this.plaActive = bl;
            this.setSDSDisabled(this.plaActive || this.isSDSProhibited(this.getCurrentDisplayContent()));
        }
        this.updateInterappClients(!this.plaActive && (bl || this.isAnyParkingSystemActive()) || this.plaActive);
    }

    @Override
    public void notifyViewModeSettingChanged(IParkingSystem iParkingSystem, int n, int n2, int n3, boolean bl) {
        this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#notifyViewModeSettingChanged] parkingSystemID='%1', oldViewMode='%2',newViewMode='%3'", (long)n, (long)n2, (long)n3);
        if (2 == n) {
            Object object;
            IParkingSystem iParkingSystem2 = (IParkingSystem)this.availableParkingSystems.get(8);
            if (iParkingSystem2 instanceof AbstractParkingSystemARAComponent && iParkingSystem2.getParkingSystemID() != iParkingSystem.getParkingSystemID()) {
                object = (AbstractParkingSystemARAComponent)iParkingSystem2;
                ((AbstractParkingSystemARAComponent)object).updateOPSViewModeSetting(n2, n3);
            }
            if (bl) {
                object = this.getApplication().getFrameworkAccess().getStorageMgr();
                object.setInt(1006, 50, n3);
                this.getChoiceModel(1510744064).setValue(n3);
                this.opsViewModeHandler.updateOPSViewModeSetting(n3);
            }
        }
    }

    public int getCurrentOPSViewMode() {
        return this.opsViewModeHandler.getOPSViewModeSetting();
    }

    private boolean isAnyParkingSystemActive() {
        if (this.popupRequests != null) {
            return !this.popupRequests.isEmpty();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void removePopupMapping(IParkingSystem iParkingSystem) {
        List[] listArray = null;
        Map map = this.parkingSystemsForPopup;
        // MONITORENTER : map
        if (!this.parkingSystemsForPopup.isEmpty()) {
            listArray = new List[this.parkingSystemsForPopup.size()];
            int n = 0;
            Iterator iterator = this.parkingSystemsForPopup.values().iterator();
            while (iterator.hasNext()) {
                listArray[n++] = (List)iterator.next();
            }
        }
        // MONITOREXIT : map
        if (listArray == null) return;
        int n = 0;
        while (n < listArray.length) {
            List[] listArray2 = listArray;
            // MONITORENTER : listArray
            listArray[n].remove(iParkingSystem);
            // MONITOREXIT : listArray2
            ++n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addPopupMapping(IParkingSystem iParkingSystem) {
        int[] nArray = iParkingSystem.getSupportedDSIPopupIDs();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            Object object;
            Integer n = new Integer(nArray[i2]);
            List list = (List)this.parkingSystemsForPopup.get(n);
            if (list == null) {
                list = new ArrayList();
                object = this.parkingSystemsForPopup;
                synchronized (object) {
                    this.parkingSystemsForPopup.put(n, list);
                }
                object = iParkingSystem.getHMIPopupID(nArray[i2]);
                if (object != null) {
                    if (((ParkingPopupIdentifier)object).getPopupType() == 1) {
                        this.getPartialPopupHandler().registerPopup(((ParkingPopupIdentifier)object).getHmiPopupID());
                    } else {
                        this.getPopupHandler().registerPopup(((ParkingPopupIdentifier)object).getHmiPopupID());
                    }
                }
            }
            if (list.contains(iParkingSystem)) continue;
            object = list;
            synchronized (object) {
                list.add(iParkingSystem);
                continue;
            }
        }
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateParkingSystemViewOptions] parkingSystemViewOptions=%1, validFlag=%2", (Object)(parkingSystemViewOptions != null ? this.formatViewOptionsLog(parkingSystemViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = parkingSystemViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            if (this.deferredPopupRequest != null && this.isPopupSupported(this.deferredPopupRequest, true)) {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#updateParkingSystemViewOptions] deferred popup request is now executed");
                this.requestParkingPopup(this.deferredPopupRequest);
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateParkingPopupContent(DisplayContent displayContent, int n) {
        if (n == 1) {
            this.logMSC.log(1078071040, "<--- updateParkingPopupContent(%1)", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(displayContent));
            this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateParkingPopupContent] displayContent=%1", (Object)displayContent);
            this.setVPSCleaningModel(displayContent.getView());
            if (!this.firstUpdateContentReceived) {
                this.firstUpdateContentReceived = true;
                if (displayContent.popup == 0) {
                    this.getApplication().getFrameworkAccess().getStartupMgr().setRVCActive(false);
                }
            }
            if (this.equalsDisplayContent(this.lastContentUpdate, displayContent)) {
                this.getLogChannel().log(-1601830656, "[AbstractParkingSystemControllerComponent#updateParkingPopupContent] received same content or content requested by HMI -> not processed");
            } else if (displayContent.getPopup() == 0) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateParkingPopupContent] received DSICarParkingSystem.POPUP_NONE -> ignored");
            } else if (!this.isPopupSupported(displayContent, true)) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateParkingPopupContent] displayContent not supported by current parking system configuration");
            } else if (this.currentDisplayContent.getPopup() != 0) {
                this.lastContentUpdate = displayContent;
                if (!this.isAcknowledgeRequired(displayContent)) {
                    this.activateParkingSystem(displayContent);
                    Object object = mutex;
                    synchronized (object) {
                        this.currentDisplayContent = displayContent;
                    }
                } else {
                    this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#updateParkingPopupContent] acknowledge required before activating parking system");
                    this.showParkingPopup(displayContent, false);
                }
            } else {
                this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateParkingPopupContent] no popup visible -> ignore update");
            }
        }
    }

    @Override
    public void requestParkingPopup(DisplayContent displayContent) {
        this.logMSC.log(1078071040, "<--- requestParkingPopup(%1)", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(displayContent));
        this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#requestParkingPopup] displayContent=%1", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(displayContent));
        this.setVPSCleaningModel(displayContent.getView());
        if (this.currentViewOptions == null) {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#requestParkingPopup] no view options -> defer popup request");
            this.deferredPopupRequest = displayContent;
        } else if (displayContent.getPopup() == 0) {
            this.cancelParkingPopup(0);
            this.deferredPopupRequest = null;
        } else if (!this.isPopupSupported(displayContent, true)) {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#requestParkingPopup] displayContent not supported by current parking system configuration -> defer popup request");
            this.deferredPopupRequest = displayContent;
        } else if (!this.powerEventListener.isInStandby() && this.isHigherPrioPopupVisible(displayContent)) {
            this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#requestParkingPopup] a higher prio popup is currently visible -> popup is rejected");
            this.showParkingPopup(new DisplayContent(), true);
            this.deferredPopupRequest = null;
        } else {
            if (!this.isAcknowledgeRequired(displayContent)) {
                this.activateParkingSystem(displayContent);
                this.showParkingPopup(displayContent, true);
                this.powerManager.setExtendedPowerState(140, 0);
            } else {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#requestParkingPopup] acknowledge required before activating parking system");
                this.showParkingPopup(displayContent, false);
            }
            this.deferredPopupRequest = null;
        }
    }

    @Override
    public void responseLifeMonitoring(boolean bl) {
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#responseLifeMonitoring] monitoring=%1", bl);
        this.getDSI().requestLifeMonitoring(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void acknowledgeParkingPopup(DisplayContent displayContent) {
        this.logMSC.log(1078071040, "<--- acknowledgeParkingPopup(%1)", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(displayContent));
        this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#acknowledgeParkingPopup] displayContent=%1", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(displayContent));
        if (this.isAcknowledgeRequired(displayContent) && displayContent.getPopup() != 0) {
            if (this.powerEventListener.isInStandby()) {
                this.powerEventListener.setDisplayContentForMMIOn(displayContent);
            } else {
                this.activateParkingSystem(displayContent);
                Object object = mutex;
                synchronized (object) {
                    this.currentDisplayContent = displayContent;
                }
            }
            this.powerManager.setExtendedPowerState(140, 0);
        }
        this.lastContentUpdate = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void showParkingPopup(DisplayContent displayContent, boolean bl) {
        Object object = mutex;
        synchronized (object) {
            if (bl) {
                this.currentDisplayContent = displayContent;
            }
            this.logMSC.log(1078071040, "---> showParkingPopup(%1)", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(displayContent));
            this.getDSI().showParkingPopup(displayContent);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void cancelParkingPopup(int n) {
        Object object = mutex;
        synchronized (object) {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#cancelParkingPopup] cancelReasion=%1", (Object)(n == 1 ? "ASG" : "FSG"));
            this.deactivateCurrentlyVisibleParkingSystems(new DisplayContent(), new ArrayList());
            if (this.powerEventListener.isQueuedUp() && n == 1) {
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#cancelParkingPopup] queued up -> do nothing");
            } else {
                this.logMSC.log(1078071040, "---> cancelParkingPopup(%1)", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(this.getCurrentDisplayContent()));
                this.getDSI().cancelParkingPopup(this.getCurrentDisplayContent(), n);
                this.currentDisplayContent = new DisplayContent();
                if (!this.plaActive) {
                    this.powerManager.setExtendedPowerState(n == 1 ? 141 : 142, 0);
                }
            }
        }
    }

    private void activateParkingSystem(DisplayContent displayContent) {
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#activateParkingSystem] %1", (Object)AbstractParkingSystemControllerComponent$LogUtil.access$2500(displayContent));
        List list = this.getInvolvedParkingSystems(displayContent);
        this.deactivateCurrentlyVisibleParkingSystems(displayContent, list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((IParkingSystem)iterator.next()).setActive(true, displayContent);
        }
        if (this.isSDSProhibited(displayContent)) {
            this.setSDSDisabled(true);
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#deactivateSDS]");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void deactivateCurrentlyVisibleParkingSystems(DisplayContent displayContent, List list) {
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#deactivateCurrentlyVisibleParkingSystems] newContent=%1", (Object)displayContent);
        if (this.currentDisplayContent != null && this.currentDisplayContent.getPopup() != 0) {
            List list2 = this.getInvolvedParkingSystems(this.currentDisplayContent);
            int n = this.getMasterComponentID(list2, list);
            Object object = list2.iterator();
            while (object.hasNext()) {
                IParkingSystem iParkingSystem = (IParkingSystem)object.next();
                if (!this.isDeactivationNeeded(displayContent, list, iParkingSystem)) continue;
                iParkingSystem.setActive(false, displayContent);
            }
            if (n > -1) {
                object = (IParkingSystem)this.availableParkingSystems.get(n);
                object.setActive(false, displayContent);
            }
        } else if (this.isAnyParkingSystemActive() && this.lastContentUpdate != null) {
            this.currentDisplayContent = this.lastContentUpdate;
            List list3 = this.getInvolvedParkingSystems(this.currentDisplayContent);
            int n = this.getMasterComponentID(list3, list);
            Object object = list3.iterator();
            while (object.hasNext()) {
                IParkingSystem iParkingSystem = (IParkingSystem)object.next();
                if (!this.isDeactivationNeeded(displayContent, list, iParkingSystem)) continue;
                iParkingSystem.setActive(false, displayContent);
            }
            if (n > -1) {
                object = (IParkingSystem)this.availableParkingSystems.get(n);
                object.setActive(false, displayContent);
            }
        } else {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#deactivateCurrentlyVisibleParkingSystems] no parking system active");
            Object object = mutex;
            synchronized (object) {
                this.currentDisplayContent = displayContent;
            }
        }
        if (displayContent.popup == 0) {
            this.setSDSDisabled(false);
        }
    }

    protected boolean isDeactivationNeeded(DisplayContent displayContent, List list, IParkingSystem iParkingSystem) {
        List list2 = this.getInvolvedParkingSystems(this.currentDisplayContent);
        int n = this.getMasterComponentID(list2, list);
        return !list.contains(iParkingSystem) && iParkingSystem.getParkingSystemID() != n;
    }

    private void setSDSDisabled(boolean bl) {
        if (this.sdsService != null) {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#setSDSDisabled] call sdsService.disablePTT(%1)", bl);
            try {
                this.sdsService.disablePTT(bl, true, (byte)2);
            }
            catch (Exception exception) {
                this.getLogChannel().log(1000, "[AbstractParkingSystemControllerComponent#setSDSDisabled] Caught exception while calling sdsService.disablePTT(): disabler=SDSService.PTT_DISABLER_APS_OPS_RVC", (Throwable)exception);
            }
        } else {
            this.getLogChannel().log(-1601830656, "[AbstractParkingSystemControllerComponent#setSDSDisabled] SDS service not available");
        }
    }

    private int getMasterComponentID(List list, List list2) {
        int n = 4;
        IParkingSystem iParkingSystem = (IParkingSystem)this.availableParkingSystems.get(n);
        if (this.availableParkingSystems.get(n) != null && list.contains(iParkingSystem) && !list2.contains(iParkingSystem)) {
            return n;
        }
        return -1;
    }

    private boolean isAcknowledgeRequired(DisplayContent displayContent) {
        if (this.plaActive) {
            AbstractParkingSystemPLAComponent abstractParkingSystemPLAComponent = (AbstractParkingSystemPLAComponent)this.getAvailableParkingSystems().get(16);
            if (abstractParkingSystemPLAComponent != null) {
                abstractParkingSystemPLAComponent.updateCurrentDisplayContent(displayContent, false);
            }
            return !this.plaActive;
        }
        return this.hasVPSContent(displayContent) && (this.currentDisplayContent == null || !this.hasVPSContent(this.currentDisplayContent));
    }

    @Override
    public boolean hasVPSContent(DisplayContent displayContent) {
        IParkingSystem iParkingSystem = (IParkingSystem)this.availableParkingSystems.get(4);
        boolean bl = iParkingSystem != null ? this.getInvolvedParkingSystems(displayContent).contains(iParkingSystem) : false;
        this.getLogChannel().log(14808325, "[AbstractParkingSystemControllerComponent#hasVPSContent] %1, content=%2", bl, (Object)displayContent);
        return bl;
    }

    @Override
    public boolean hasOPSContent(DisplayContent displayContent) {
        boolean bl = this.hasComponentContent(displayContent, 2);
        this.getLogChannel().log(14808325, "[AbstractParkingSystemControllerComponent#hasOPSContent] %1, content=%2", bl, (Object)displayContent);
        return bl;
    }

    private boolean hasComponentContent(DisplayContent displayContent, int n) {
        IParkingSystem iParkingSystem = (IParkingSystem)this.availableParkingSystems.get(n);
        boolean bl = iParkingSystem != null ? this.getInvolvedParkingSystems(displayContent).contains(iParkingSystem) : false;
        this.getLogChannel().log(14808325, "[AbstractParkingSystemControllerComponent#hasComponentContent] %1, content=%2 , componentId=%3", bl, (Object)displayContent, (Object)new Integer(n));
        return bl;
    }

    private boolean hasARAContent(DisplayContent displayContent) {
        IParkingSystem iParkingSystem = (IParkingSystem)this.availableParkingSystems.get(8);
        if (iParkingSystem != null) {
            return this.getInvolvedParkingSystems(displayContent).contains(iParkingSystem);
        }
        return false;
    }

    private boolean isSDSProhibited(DisplayContent displayContent) {
        return displayContent != null && displayContent.getPopup() != 0;
    }

    public List getInvolvedParkingSystems(DisplayContent displayContent) {
        IParkingSystem iParkingSystem;
        LinkedList linkedList = new LinkedList();
        List list = (List)this.parkingSystemsForPopup.get(new Integer(displayContent.getPopup()));
        if (list != null) {
            AbstractParkingSystemVPSComponent abstractParkingSystemVPSComponent;
            linkedList.addAll(list);
            iParkingSystem = (AbstractParkingSystemPLAComponent)this.availableParkingSystems.get(16);
            if (iParkingSystem != null && !iParkingSystem.equals(linkedList.getLast()) && linkedList.remove(iParkingSystem)) {
                linkedList.addLast(iParkingSystem);
            }
            if ((abstractParkingSystemVPSComponent = (AbstractParkingSystemVPSComponent)this.availableParkingSystems.get(4)) != null && !abstractParkingSystemVPSComponent.equals(linkedList.getFirst()) && linkedList.remove(abstractParkingSystemVPSComponent)) {
                linkedList.addFirst(abstractParkingSystemVPSComponent);
            }
        }
        if (displayContent.getMode() == 12 && (iParkingSystem = (IParkingSystem)this.availableParkingSystems.get(8)) != null && !linkedList.contains(iParkingSystem)) {
            linkedList.add(iParkingSystem);
        }
        return linkedList;
    }

    private boolean isPopupSupported(DisplayContent displayContent, boolean bl) {
        this.getLogChannel().log(14808325, "[AbstractParkingSystemControllerComponent#isPopupSupported] content=%1 , fullSupport=%2", (Object)(null == displayContent ? "null" : displayContent.toString()), (Object)(bl ? "true" : "false"));
        List list = this.getInvolvedParkingSystems(displayContent);
        if (bl && !list.isEmpty()) {
            AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry abstractParkingSystemControllerComponent$ParkingSystemSubContentEntry = null;
            for (int i2 = 0; i2 < this.parkingSystemSubSystemSet.length; ++i2) {
                if (displayContent.getPopup() != this.parkingSystemSubSystemSet[i2].getPopup()) continue;
                abstractParkingSystemControllerComponent$ParkingSystemSubContentEntry = this.parkingSystemSubSystemSet[i2];
            }
            if (null != abstractParkingSystemControllerComponent$ParkingSystemSubContentEntry) {
                List list2 = abstractParkingSystemControllerComponent$ParkingSystemSubContentEntry.getInvolvedParkingSystems();
                Iterator iterator = list2.iterator();
                while (iterator.hasNext()) {
                    IParkingSystem iParkingSystem = (IParkingSystem)this.availableParkingSystems.get((Integer)iterator.next());
                    if (null != iParkingSystem && list.contains(iParkingSystem)) {
                        this.getLogChannel().log(14808325, "[AbstractParkingSystemControllerComponent#isPopupSupported] parkingSystem(%1) available.", (Object)iParkingSystem.getName());
                        continue;
                    }
                    this.getLogChannel().log(14808325, "[AbstractParkingSystemControllerComponent#isPopupSupported] parkingSystem(%1) not available.", (Object)(null == iParkingSystem ? "unknown" : iParkingSystem.getName()));
                    return false;
                }
                return true;
            }
            return false;
        }
        return !list.isEmpty();
    }

    protected abstract void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addPopupRequest(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#addPopupRequest] hmiPopupID=%1, requestingComponent=%2", (Object)parkingPopupIdentifier, (long)iParkingSystem.getParkingSystemID());
        List list = (List)this.popupRequests.get(parkingPopupIdentifier);
        if (list == null) {
            list = new ArrayList();
            this.popupRequests.put(parkingPopupIdentifier, list);
            List list2 = list;
            synchronized (list2) {
                if (!list.contains(iParkingSystem)) {
                    list.add(iParkingSystem);
                }
            }
            if (parkingPopupIdentifier.getPopupType() == 1) {
                this.getPartialPopupHandler().showPopup(parkingPopupIdentifier.getHmiPopupID());
            } else {
                this.getPopupHandler().showPopup(parkingPopupIdentifier.getHmiPopupID());
            }
        } else {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#addPopupRequest] popup already requested");
            List list3 = list;
            synchronized (list3) {
                if (!list.contains(iParkingSystem)) {
                    list.add(iParkingSystem);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addPopupRequestSuppression(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
        List list = (List)this.popupRequests.get(parkingPopupIdentifier);
        if (list == null) {
            list = new ArrayList();
            this.popupRequests.put(parkingPopupIdentifier, list);
        }
        List list2 = list;
        synchronized (list2) {
            if (!list.contains(iParkingSystem)) {
                list.add(iParkingSystem);
                if (parkingPopupIdentifier.getPopupType() == 1) {
                    this.getPartialPopupHandler().hidePartialPopup(parkingPopupIdentifier.getHmiPopupID());
                } else {
                    this.getPopupHandler().removeCurrentPopup(0);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removePopupRequestSuppression(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
        List list = (List)this.popupRequests.get(parkingPopupIdentifier);
        if (list != null) {
            List list2 = list;
            synchronized (list2) {
                boolean bl = false;
                if (list.contains(iParkingSystem)) {
                    bl = list.remove(iParkingSystem);
                }
                if (list.isEmpty()) {
                    this.popupRequests.remove(parkingPopupIdentifier);
                } else if (bl) {
                    if (parkingPopupIdentifier.getPopupType() == 1) {
                        this.getPartialPopupHandler().showPopup(parkingPopupIdentifier.getHmiPopupID());
                    } else {
                        this.getPopupHandler().showPopup(parkingPopupIdentifier.getHmiPopupID());
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removePopupRequest(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#removePopupRequest] hmiPopupID=%1, requestingComponent=%2", (Object)parkingPopupIdentifier, (long)iParkingSystem.getParkingSystemID());
        List list = (List)this.popupRequests.get(parkingPopupIdentifier);
        if (list != null) {
            boolean bl;
            Object object = list;
            synchronized (object) {
                list.remove(iParkingSystem);
                if (list.isEmpty()) {
                    this.popupRequests.remove(parkingPopupIdentifier);
                    bl = true;
                } else {
                    bl = false;
                }
            }
            if (bl) {
                if (parkingPopupIdentifier.getPopupType() == 1) {
                    this.getPartialPopupHandler().hidePartialPopup(parkingPopupIdentifier.getHmiPopupID());
                } else {
                    this.getPopupHandler().removeCurrentPopup(0);
                }
            } else if (this.getLogChannel().isDebug()) {
                object = new Buffer();
                List list2 = list;
                synchronized (list2) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        ((Buffer)object).append(((IParkingSystem)iterator.next()).getParkingSystemID());
                        if (!iterator.hasNext()) continue;
                        ((Buffer)object).append(",");
                    }
                }
                this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#removePopupRequest] popup still requested by other component (%1)", (Object)((Buffer)object).toString());
            }
        } else {
            this.getLogChannel().log(-1601830656, "[AbstractParkingSystemControllerComponent#removePopupRequest] popup was not requested before");
        }
    }

    @Override
    public boolean equalsDisplayContent(DisplayContent displayContent, DisplayContent displayContent2) {
        if (displayContent == null || displayContent2 == null) {
            return false;
        }
        return displayContent.popup == displayContent2.popup && displayContent.screen == displayContent2.screen && displayContent.view == displayContent2.view && displayContent.mode == displayContent2.mode;
    }

    public Map getPopupRequests() {
        return this.popupRequests;
    }

    public boolean isHigherPrioPopupVisible(DisplayContent displayContent) {
        int n = this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopupPriority(0);
        int n2 = this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopup();
        int n3 = this.getParkingPopupPrio(displayContent);
        boolean bl = n3 < n;
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#isHigherPrioPopupVisible] standbyPopupVisible=%1, higherPrioPopupVisible=%2", this.isStandbyPopupVisible(), bl);
        if (n2 != -1) {
            this.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent#isHigherPrioPopupVisible] parkingPopup: prio=%1; currentVisiblePopup: ID=%2, prio=%3", (long)n3, (long)n2, (long)n);
        }
        return !this.isStandbyPopupVisible() && bl;
    }

    protected int getParkingPopupPrio(DisplayContent displayContent) {
        List list = this.getInvolvedParkingSystems(displayContent);
        int n = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IParkingSystem iParkingSystem = (IParkingSystem)iterator.next();
            if (iParkingSystem instanceof AbstractParkingSystemPLAComponent) continue;
            n = Math.max(n, iParkingSystem.getHMIPopupPrio(displayContent.getPopup()));
        }
        return n;
    }

    @Override
    public boolean isStandbyPopupVisible() {
        return this.getStandbyPopupID() != -1 && this.getApplication().getFrameworkAccess().getHmiServiceApp().getCurrentPopup() == this.getStandbyPopupID();
    }

    @Override
    public void notifyPopupVisible(int n) {
    }

    @Override
    public boolean notifyPopupHidden(int n) {
        AbstractParkingSystemPLAComponent abstractParkingSystemPLAComponent = (AbstractParkingSystemPLAComponent)this.getAvailableParkingSystems().get(16);
        if (abstractParkingSystemPLAComponent != null && abstractParkingSystemPLAComponent.isSystemActive()) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#notifyPopupHidden] hmiPopupID=%1", (long)n);
            }
            abstractParkingSystemPLAComponent.canceledByHMI();
            return false;
        }
        return true;
    }

    protected abstract int getStandbyPopupID() {
    }

    protected void reconfigParkingOptionDrawer() {
    }

    private void updateInterappClients(boolean bl) {
        this.updateAudioDrawerContext(bl);
        try {
            this.msgDistributor.sendMessage(bl ? 108 : 107);
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "[AbstractParkingSystemControllerComponent#updateInterappClients]", (Throwable)exception);
        }
    }

    private void updateAudioDrawerContext(boolean bl) {
        AudioDrawerContext audioDrawerContext = this.audioDrawerContextService;
        if (audioDrawerContext != null && bl) {
            this.getChoiceModel(3915).setValue(1);
            if (this.isHighProtocol() && this.isHighProtocolReason(1)) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateAudioDrawerContext] source='SOURCE_APS', state='ACTIVE_HIGH_PRIO'");
                audioDrawerContext.setContext(AudioDrawerContext.SOURCE_APS, AudioDrawerContext.SOURCE_AUDIO_STATE_APS_ACTIVE_HIGH_PRIO);
            } else {
                this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateAudioDrawerContext] source='SOURCE_APS', state='ACTIVE'");
                audioDrawerContext.setContext(AudioDrawerContext.SOURCE_APS, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
            }
        } else if (audioDrawerContext != null && !bl) {
            this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#updateAudioDrawerContext] source='SOURCE_APS', state='INACTIVE'");
            audioDrawerContext.setContext(AudioDrawerContext.SOURCE_APS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
            this.getChoiceModel(3915).setValue(0);
        }
    }

    @Override
    public void setHighProtocol(boolean bl, int[] nArray, boolean bl2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractParkingSystemControllerComponent#setHighProtocol] activate='%1', reason='%2'", bl, (Object)(null == nArray ? "null" : nArray.toString()));
        }
        this.highProtocol = bl;
        if (bl2) {
            this.highProtocolReasons.clear();
        }
        if (this.highProtocol && null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.highProtocolReasons.add(new Integer(nArray[i2]));
            }
        }
        this.getChoiceModel(504176640).setValue(bl ? 1 : 0);
        this.notifyHighProtocolUpdated();
    }

    @Override
    public boolean isHighProtocol() {
        return this.highProtocol;
    }

    @Override
    public boolean isHighProtocolReason(int n) {
        if (null != this.highProtocolReasons) {
            return this.highProtocolReasons.contains(new Integer(n));
        }
        return false;
    }

    @Override
    public int[] getHighProtocolReasons() {
        int n = this.highProtocolReasons.size();
        Object[] objectArray = this.highProtocolReasons.toArray();
        if (0 < n) {
            int[] nArray = new int[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nArray[i2] = (Integer)objectArray[i2];
            }
            return nArray;
        }
        return new int[0];
    }

    protected void notifyHighProtocolUpdated() {
        this.updateInterappClients(!this.plaActive && this.isAnyParkingSystemActive() || this.plaActive);
    }

    private void setVPSCleaningModel(int n) {
        int n2 = n == 1 ? 1 : 0;
        this.getChoiceModel(1376591872).setValue(n2);
    }

    public static Object getParkingMutex() {
        return mutex;
    }

    static /* synthetic */ SDSService access$002(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, SDSService sDSService) {
        abstractParkingSystemControllerComponent.sdsService = sDSService;
        return abstractParkingSystemControllerComponent.sdsService;
    }

    static /* synthetic */ boolean access$100(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, DisplayContent displayContent) {
        return abstractParkingSystemControllerComponent.isSDSProhibited(displayContent);
    }

    static /* synthetic */ void access$200(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, boolean bl) {
        abstractParkingSystemControllerComponent.setSDSDisabled(bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ICarApplication access$300(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        return abstractParkingSystemControllerComponent.getApplication();
    }

    static /* synthetic */ AudioDrawerContext access$402(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AudioDrawerContext audioDrawerContext) {
        abstractParkingSystemControllerComponent.audioDrawerContextService = audioDrawerContext;
        return abstractParkingSystemControllerComponent.audioDrawerContextService;
    }

    static /* synthetic */ ICarApplication access$500(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        return abstractParkingSystemControllerComponent.getApplication();
    }

    static /* synthetic */ ICarApplication access$600(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        return abstractParkingSystemControllerComponent.getApplication();
    }

    static /* synthetic */ boolean access$700(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        return abstractParkingSystemControllerComponent.isAnyParkingSystemActive();
    }

    static /* synthetic */ boolean access$800(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        return abstractParkingSystemControllerComponent.plaActive;
    }

    static /* synthetic */ void access$900(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, int n) {
        abstractParkingSystemControllerComponent.cancelParkingPopup(n);
    }

    static /* synthetic */ void access$1000(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, DisplayContent displayContent) {
        abstractParkingSystemControllerComponent.activateParkingSystem(displayContent);
    }

    static /* synthetic */ ChoiceModelApp access$1100(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, int n) {
        return abstractParkingSystemControllerComponent.getChoiceModel(n);
    }

    static /* synthetic */ ButtonModelApp access$1200(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, int n) {
        return abstractParkingSystemControllerComponent.getButtonModel(n);
    }

    static /* synthetic */ void access$1400(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, String string, int n, int n2, boolean bl) {
        abstractParkingSystemControllerComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$1500(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, String string, int n, int n2, boolean bl) {
        abstractParkingSystemControllerComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$1600(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, int n) {
        return abstractParkingSystemControllerComponent.getChoiceModel(n);
    }

    static /* synthetic */ void access$1700(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, String string, int n, int n2, boolean bl) {
        abstractParkingSystemControllerComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$1800(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, String string, int n, int n2, boolean bl) {
        abstractParkingSystemControllerComponent.logModelData(string, n, n2, bl);
    }

    static {
        mutex = new Object();
    }
}

