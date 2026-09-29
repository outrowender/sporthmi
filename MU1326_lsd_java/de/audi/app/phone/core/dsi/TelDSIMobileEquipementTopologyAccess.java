/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.AbstractMobileEquipementTopologyAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$1;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipmentTopologyDiag;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.TelDefaultDSIMobileEquipmentToplogyListener;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper;
import de.audi.app.phone.core.dsi.Topology;
import de.audi.app.phone.core.dsi.cmd.RequestChangeTopologyCmd;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;

public class TelDSIMobileEquipementTopologyAccess
extends AbstractMobileEquipementTopologyAccess {
    static final int MAX_DSI_INSTANCES;
    private DSIActivator dsiMobileEquipmentTopologyActivator;
    private volatile DSIMobileEquipmentTopology dsiMobileEquipmentTopology;
    private final TelDSIMobileEquipmentDeviceAccess[] deviceInstances = new TelDSIMobileEquipmentDeviceAccess[3];
    private int[] instanceUsage;
    private final Object deviceTopologyMutex = new Object();
    private final CommandListManager commandListManager;
    private final Object requestChangeTopologyMutex = new Object();
    private final Monitor requestChangeTopologyMonitor;
    private final TelDefaultDSIMobileEquipmentToplogyListener defaultListener;
    private TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener dsiMobileEquipmentTopologyListener;
    private Topology currentTopology;
    private final boolean secondPhoneFeatureSupported;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener;

    public TelDSIMobileEquipementTopologyAccess(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.DSI");
        this.secondPhoneFeatureSupported = iTelApplication.getFrameworkAccess().getSysApp().getAdaptationANP().isSupports2ndPhone();
        this.currentTopology = new Topology(this.log, this.secondPhoneFeatureSupported, new int[]{0, 1, 2});
        this.defaultListener = new TelDefaultDSIMobileEquipmentToplogyListener();
        this.dsiMobileEquipmentTopologyListener = new TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener(this);
        this.dsiMobileEquipmentTopologyActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = TelDSIMobileEquipementTopologyAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology).getName(), (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener = TelDSIMobileEquipementTopologyAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener).getName(), new Integer(0), this.dsiMobileEquipmentTopologyListener, new TelDSIMobileEquipementTopologyAccess$1(this));
        this.deviceInstances[0] = new TelDSIMobileEquipmentDeviceAccess(iTelApplication, 0, 256);
        this.deviceInstances[1] = new TelDSIMobileEquipmentDeviceAccess(iTelApplication, 1, 512);
        this.deviceInstances[2] = new TelDSIMobileEquipmentDeviceAccess(iTelApplication, 2, 768);
        for (int i2 = 0; i2 < this.deviceInstances.length; ++i2) {
            this.addSubPhoneComponent(this.deviceInstances[i2]);
        }
        LogChannel logChannel = this.getApplication().getFrameworkAccess().getLogChannel("App.Phone.DSI.CL");
        this.commandListManager = new CommandListManager("DSIMobileEquipmentTopology", this.getApplication().getFrameworkAccess(), logChannel, null, null);
        this.requestChangeTopologyMonitor = new Monitor(logChannel);
    }

    @Override
    public void init() {
        this.startCmdManager();
        this.dsiMobileEquipmentTopologyActivator.start(this.getApplication().getBundleContext());
        this.getApplication().addDiagnosisComponent(new TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipmentTopologyDiag(this, null));
        super.init();
    }

    void startCmdManager() {
        this.commandListManager.start();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.dsiMobileEquipmentTopologyActivator.stop(this.getApplication().getBundleContext());
        this.stopCmdManager();
    }

    void stopCmdManager() {
        this.commandListManager.destroy();
    }

    TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener getDsiMobileEquipmentTopologyListener() {
        return this.dsiMobileEquipmentTopologyListener;
    }

    @Override
    public ITelDSIMobileEquipmentDeviceAccess getPrimaryTelephoneAccess() {
        return this.getRoleDeviceAccess(256);
    }

    @Override
    public ITelDSIMobileEquipmentDeviceAccess getSecondaryTelephoneAccess() {
        return this.getRoleDeviceAccess(512);
    }

    @Override
    public ITelDSIMobileEquipmentDeviceAccess getDataOnlyNadAccess() {
        return this.getRoleDeviceAccess(768);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ITelDSIMobileEquipmentDeviceAccess getRoleDeviceAccess(int n) {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.nullTelDSIMobileEquipmentDeviceAccess;
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.deviceInstances.length; ++i2) {
                if (this.deviceInstances[i2].getDeviceRole() != n) continue;
                iTelDSIMobileEquipmentDeviceAccess = this.deviceInstances[i2];
                break;
            }
        }
        return iTelDSIMobileEquipmentDeviceAccess;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    ITelDSIMobileEquipmentDeviceAccess getDsiInstance(int n) {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.nullTelDSIMobileEquipmentDeviceAccess;
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            iTelDSIMobileEquipmentDeviceAccess = this.deviceInstances[n];
        }
        return iTelDSIMobileEquipmentDeviceAccess;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ITelDSIMobileEquipmentDeviceAccess getNADInstance() {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.nullTelDSIMobileEquipmentDeviceAccess;
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.instanceUsage.length; ++i2) {
                if (this.instanceUsage[i2] != 0) continue;
                iTelDSIMobileEquipmentDeviceAccess = this.deviceInstances[i2];
                break;
            }
        }
        return iTelDSIMobileEquipmentDeviceAccess;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void restoreFactorySettings(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.deviceInstances.length; ++i2) {
                if (this.deviceInstances[i2] == null) continue;
                this.deviceInstances[i2].restoreFactorySettings(bl, n, iTelDSIResponseListener, iTelDSIResponseListenerArray);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestSetLanguage(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.deviceInstances.length; ++i2) {
                if (this.deviceInstances[i2] == null) continue;
                this.deviceInstances[i2].requestSetLanguage(string, bl, n, iTelDSIResponseListener, iTelDSIResponseListenerArray);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestSetNADMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            this.getNADInstance().requestSetNADMode(n, bl, n2, iTelDSIResponseListener, iTelDSIResponseListenerArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void togglePhones(int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            this.requestChangeTopology(this.currentTopology.getToggledArray(), n, iTelDSIResponseListener, iTelDSIResponseListenerArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestSetNadRole(int n, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            this.requestChangeTopology(this.currentTopology.getSwitchedSlotTopology(this.getCurrentNadUsageSlot(), n2), n, iTelDSIResponseListener, iTelDSIResponseListenerArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void requestChangeTopology(int[] nArray, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.requestChangeTopologyMutex;
        synchronized (object) {
            if (this.requestChangeTopologyMonitor.isActive()) {
                this.log.log(1078071040, "[TelDSIMobileEquipementTopologyAccess#requestChangeTopology] requestChangeTopology already running --> NOP!");
                return;
            }
            TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.getApplication().getTelEventQueue(), this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, true, iTelDSIResponseListenerArray);
            new RequestChangeTopologyCmd(this.log, n, this.getDsiMobileEquipmentTopology(), nArray, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.commandListManager, this.requestChangeTopologyMonitor);
        }
    }

    DSIMobileEquipmentTopology getDsiMobileEquipmentTopology() {
        return this.dsiMobileEquipmentTopology;
    }

    void setDsiMobileEquipmentTopology(DSIMobileEquipmentTopology dSIMobileEquipmentTopology) {
        this.dsiMobileEquipmentTopology = dSIMobileEquipmentTopology;
    }

    int[] getTopologySlots() {
        return this.currentTopology.getTopology();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void assignRoles() {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            int[] nArray = this.currentTopology.getRoles();
            if (nArray != null && nArray.length == 3) {
                for (int i2 = 0; i2 < 3; ++i2) {
                    this.deviceInstances[i2].setDeviceRole(nArray[i2]);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getNadInstanceID() {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.instanceUsage.length; ++i2) {
                if (this.instanceUsage[i2] != 0) continue;
                return i2;
            }
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getCurrentNadUsageSlot() {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            int n = this.getNadInstanceID();
            int[] nArray = this.getTopologySlots();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] != n) continue;
                return i2;
            }
        }
        return 0;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ TelDefaultDSIMobileEquipmentToplogyListener access$100(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.defaultListener;
    }

    static /* synthetic */ CommandListManager access$200(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.commandListManager;
    }

    static /* synthetic */ ITelApplication access$300(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.getApplication();
    }

    static /* synthetic */ LogChannel access$400(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }

    static /* synthetic */ LogChannel access$600(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }

    static /* synthetic */ Object access$700(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.deviceTopologyMutex;
    }

    static /* synthetic */ TelDSIMobileEquipmentDeviceAccess[] access$800(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.deviceInstances;
    }

    static /* synthetic */ int[] access$902(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess, int[] nArray) {
        telDSIMobileEquipementTopologyAccess.instanceUsage = nArray;
        return nArray;
    }

    static /* synthetic */ Topology access$1000(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.currentTopology;
    }

    static /* synthetic */ ITelApplication access$1100(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.getApplication();
    }

    static /* synthetic */ Topology access$1002(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess, Topology topology) {
        telDSIMobileEquipementTopologyAccess.currentTopology = topology;
        return telDSIMobileEquipementTopologyAccess.currentTopology;
    }

    static /* synthetic */ LogChannel access$1200(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }

    static /* synthetic */ boolean access$1300(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.secondPhoneFeatureSupported;
    }

    static /* synthetic */ int[] access$900(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.instanceUsage;
    }

    static /* synthetic */ LogChannel access$1400(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }

    static /* synthetic */ LogChannel access$1500(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }

    static /* synthetic */ void access$1600(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        telDSIMobileEquipementTopologyAccess.assignRoles();
    }

    static /* synthetic */ LogChannel access$1700(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }

    static /* synthetic */ ITelApplication access$1800(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.getApplication();
    }

    static /* synthetic */ ITelApplication access$1900(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.getApplication();
    }

    static /* synthetic */ void access$2000(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess, int[] nArray, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        telDSIMobileEquipementTopologyAccess.requestChangeTopology(nArray, n, iTelDSIResponseListener, iTelDSIResponseListenerArray);
    }

    static /* synthetic */ LogChannel access$2100(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }

    static /* synthetic */ LogChannel access$2200(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        return telDSIMobileEquipementTopologyAccess.log;
    }
}

