/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.AbstractMobileEquipementTopologyAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIMobileEquipmentToplogyListener;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper;
import de.audi.app.phone.core.dsi.Topology;
import de.audi.app.phone.core.dsi.cmd.RequestChangeTopologyCmd;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.ServiceProvider;

public class TelDSIMobileEquipementTopologyAccess
extends AbstractMobileEquipementTopologyAccess {
    static final int MAX_DSI_INSTANCES = 3;
    private DSIActivator dsiMobileEquipmentTopologyActivator;
    private volatile DSIMobileEquipmentTopology dsiMobileEquipmentTopology;
    private final TelDSIMobileEquipmentDeviceAccess[] deviceInstances = new TelDSIMobileEquipmentDeviceAccess[3];
    private int[] instanceUsage;
    private final Object deviceTopologyMutex = new Object();
    private final CommandListManager commandListManager;
    private final Object requestChangeTopologyMutex = new Object();
    private final Monitor requestChangeTopologyMonitor;
    private final TelDefaultDSIMobileEquipmentToplogyListener defaultListener;
    private TelDSIMobileEquipementTopologyListener dsiMobileEquipmentTopologyListener;
    private Topology currentTopology;
    private final boolean secondPhoneFeatureSupported;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener;

    public TelDSIMobileEquipementTopologyAccess(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.DSI");
        this.secondPhoneFeatureSupported = iTelApplication.getFrameworkAccess().getSysApp().getAdaptationANP().isSupports2ndPhone();
        this.currentTopology = new Topology(this.log, this.secondPhoneFeatureSupported, new int[]{0, 1, 2});
        this.defaultListener = new TelDefaultDSIMobileEquipmentToplogyListener();
        this.dsiMobileEquipmentTopologyListener = new TelDSIMobileEquipementTopologyListener();
        this.dsiMobileEquipmentTopologyActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = TelDSIMobileEquipementTopologyAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology).getName(), (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener = TelDSIMobileEquipementTopologyAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener).getName(), new Integer(0), this.dsiMobileEquipmentTopologyListener, new IDSIClient(){

            public void setDSI(DSIBase dSIBase) {
                TelDSIMobileEquipementTopologyAccess.this.setDsiMobileEquipmentTopology((DSIMobileEquipmentTopology)dSIBase);
            }

            public int[] getAutoNotifications() {
                return DSIActivator.ATTR_ALL;
            }
        });
        this.deviceInstances[0] = new TelDSIMobileEquipmentDeviceAccess(iTelApplication, 0, 65536);
        this.deviceInstances[1] = new TelDSIMobileEquipmentDeviceAccess(iTelApplication, 1, 131072);
        this.deviceInstances[2] = new TelDSIMobileEquipmentDeviceAccess(iTelApplication, 2, 196608);
        for (int i2 = 0; i2 < this.deviceInstances.length; ++i2) {
            this.addSubPhoneComponent(this.deviceInstances[i2]);
        }
        LogChannel logChannel = this.getApplication().getFrameworkAccess().getLogChannel("App.Phone.DSI.CL");
        this.commandListManager = new CommandListManager("DSIMobileEquipmentTopology", this.getApplication().getFrameworkAccess(), logChannel, null, null);
        this.requestChangeTopologyMonitor = new Monitor(logChannel);
    }

    public void init() {
        this.startCmdManager();
        this.dsiMobileEquipmentTopologyActivator.start(this.getApplication().getBundleContext());
        this.getApplication().addDiagnosisComponent(new TelDSIMobileEquipmentTopologyDiag());
        super.init();
    }

    void startCmdManager() {
        this.commandListManager.start();
    }

    public void deinit() {
        super.deinit();
        this.dsiMobileEquipmentTopologyActivator.stop(this.getApplication().getBundleContext());
        this.stopCmdManager();
    }

    void stopCmdManager() {
        this.commandListManager.destroy();
    }

    TelDSIMobileEquipementTopologyListener getDsiMobileEquipmentTopologyListener() {
        return this.dsiMobileEquipmentTopologyListener;
    }

    public ITelDSIMobileEquipmentDeviceAccess getPrimaryTelephoneAccess() {
        return this.getRoleDeviceAccess(65536);
    }

    public ITelDSIMobileEquipmentDeviceAccess getSecondaryTelephoneAccess() {
        return this.getRoleDeviceAccess(131072);
    }

    public ITelDSIMobileEquipmentDeviceAccess getDataOnlyNadAccess() {
        return this.getRoleDeviceAccess(196608);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
    public void requestSetNADMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            this.getNADInstance().requestSetNADMode(n, bl, n2, iTelDSIResponseListener, iTelDSIResponseListenerArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void togglePhones(int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        Object object = this.deviceTopologyMutex;
        synchronized (object) {
            this.requestChangeTopology(this.currentTopology.getToggledArray(), n, iTelDSIResponseListener, iTelDSIResponseListenerArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
                this.log.log(1000000, "[TelDSIMobileEquipementTopologyAccess#requestChangeTopology] requestChangeTopology already running --> NOP!");
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

    static /* synthetic */ int[] access$902(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess, int[] nArray) {
        telDSIMobileEquipementTopologyAccess.instanceUsage = nArray;
        return nArray;
    }

    private class TelDSIMobileEquipmentTopologyDiag
    implements IPhoneDiagComponent {
        private TelDSIMobileEquipmentTopologyDiag() {
        }

        public String getTopology() {
            return TelDSIMobileEquipementTopologyAccess.this.currentTopology.toString();
        }

        public void cmdTogglePhones() {
            TelDSIMobileEquipementTopologyAccess.this.togglePhones(0, null, null);
        }

        public void cmdChangeTopology(int n, int n2, int n3) {
            TelDSIMobileEquipementTopologyAccess.this.requestChangeTopology(new int[]{n, n2, n3}, 0, null, null);
        }

        public void cmdDSIUpdateRegistrationState(int n, int n2, String string) {
            TelDSIMobileEquipmentListener telDSIMobileEquipmentListener;
            TelDSIMobileEquipmentListener telDSIMobileEquipmentListener2 = telDSIMobileEquipmentListener = TelDSIMobileEquipementTopologyAccess.this.deviceInstances[n] != null ? TelDSIMobileEquipementTopologyAccess.this.deviceInstances[n].getDsiListener() : null;
            if (telDSIMobileEquipmentListener != null) {
                RegisterStateStruct registerStateStruct = new RegisterStateStruct();
                registerStateStruct.telRegisterState = n2;
                registerStateStruct.telLongProviderName = string;
                registerStateStruct.telRegMode = 1;
                telDSIMobileEquipmentListener.updateRegisterState(registerStateStruct, 1);
            }
        }

        public void cmdDSIUpdateServiceProvider(int n, boolean bl, String string) {
            TelDSIMobileEquipmentListener telDSIMobileEquipmentListener;
            TelDSIMobileEquipmentListener telDSIMobileEquipmentListener2 = telDSIMobileEquipmentListener = TelDSIMobileEquipementTopologyAccess.this.deviceInstances[n] != null ? TelDSIMobileEquipementTopologyAccess.this.deviceInstances[n].getDsiListener() : null;
            if (telDSIMobileEquipmentListener != null) {
                ServiceProvider serviceProvider = new ServiceProvider();
                serviceProvider.displayConditionServiceProviderName = bl;
                serviceProvider.displayConditionProviderName = !bl;
                serviceProvider.telServiceProviderName = string;
                telDSIMobileEquipmentListener.updateServiceProvider(serviceProvider, 1);
            }
        }

        public String cmdTelFeature_ReadOut() {
            ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess;
            ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess2;
            StringBuffer stringBuffer = new StringBuffer(200);
            stringBuffer.append("\r\nActual tel features: \r\n");
            ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess3 = TelDSIMobileEquipementTopologyAccess.this.getPrimaryTelephoneAccess();
            if (iTelDSIMobileEquipmentDeviceAccess3 instanceof TelDSIMobileEquipmentDeviceAccess) {
                iTelDSIMobileEquipmentDeviceAccess2 = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess3;
                stringBuffer.append("\r\n Primary tel features: ");
                stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess2).getActivationState().getTelFeat());
                stringBuffer.append("\r\n   Primary Activation state: ");
                stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess2).getActivationState().toString());
            } else {
                stringBuffer.append("\r\n No primary device found");
            }
            iTelDSIMobileEquipmentDeviceAccess2 = TelDSIMobileEquipementTopologyAccess.this.getSecondaryTelephoneAccess();
            if (iTelDSIMobileEquipmentDeviceAccess2 instanceof TelDSIMobileEquipmentDeviceAccess) {
                iTelDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess2;
                stringBuffer.append("\r\n Associated tel features: ");
                stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess).getActivationState().getTelFeat());
                stringBuffer.append("\r\n   Associated Activation state: ");
                stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess).getActivationState().toString());
            } else {
                stringBuffer.append("\r\n No associated device found");
            }
            iTelDSIMobileEquipmentDeviceAccess = TelDSIMobileEquipementTopologyAccess.this.getDataOnlyNadAccess();
            if (iTelDSIMobileEquipmentDeviceAccess instanceof TelDSIMobileEquipmentDeviceAccess) {
                TelDSIMobileEquipmentDeviceAccess telDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess;
                stringBuffer.append("\r\n Data tel features: ");
                stringBuffer.append(telDSIMobileEquipmentDeviceAccess.getActivationState().getTelFeat());
                stringBuffer.append("\r\n   Data Activation state: ");
                stringBuffer.append(telDSIMobileEquipmentDeviceAccess.getActivationState().toString());
            } else {
                stringBuffer.append("\r\n No data device found");
            }
            return stringBuffer.toString();
        }

        public String cmdTelFeature_Set_Readme() {
            String string = " \r\n The parameter for cmdTelFeature_Set is the sum of the needed tel features:  \r\n   -   1 = TELFEAT_INBAND \r\n   -   2 = TELFEAT_REJECTCALL ------------------  !!MANDATORY!! \r\n   -   4 = TELFEAT_RESPHOLD (In Japan) \r\n   -   8 = TELFEAT_THREEWAY \r\n   -  16 = TELFEAT_ENHCALL \r\n   -  32 = TELFEAT_ENHSTAT ------------------  !!MANDATORY!! \r\n   -  64 = TELFEAT_ADD_TO_CONFERENCE \r\n  Example: iphone (inband) that supports ADD_TO_CONFERENCE but does NOT supports ENHCALL = 1 + 2 + 8 + 32 + 64 = 107";
            return string;
        }

        public String cmdTelFeature_Set_Primary(int n) {
            ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = TelDSIMobileEquipementTopologyAccess.this.getPrimaryTelephoneAccess();
            if (iTelDSIMobileEquipmentDeviceAccess instanceof TelDSIMobileEquipmentDeviceAccess) {
                TelDSIMobileEquipmentDeviceAccess telDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess;
                TelDSIMobileEquipementTopologyAccess.this.log.log(1000000, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipmentTopologyDiag#cmdTelFeature_Set_Primary] telFeat=%1", (long)n);
                telDSIMobileEquipmentDeviceAccess.getActivationState().telFeat = (short)n;
                telDSIMobileEquipmentDeviceAccess.updateGlobalTelephoneState(4);
                return telDSIMobileEquipmentDeviceAccess.getActivationState().toString();
            }
            return "\r\n No primary device found";
        }

        public String cmdTelFeature_Set_Associated(int n) {
            ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = TelDSIMobileEquipementTopologyAccess.this.getSecondaryTelephoneAccess();
            if (iTelDSIMobileEquipmentDeviceAccess instanceof TelDSIMobileEquipmentDeviceAccess) {
                TelDSIMobileEquipmentDeviceAccess telDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess;
                TelDSIMobileEquipementTopologyAccess.this.log.log(1000000, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipmentTopologyDiag#cmdTelFeature_Set_Associated] telFeat=%1", (long)n);
                telDSIMobileEquipmentDeviceAccess.getActivationState().telFeat = (short)n;
                telDSIMobileEquipmentDeviceAccess.updateGlobalTelephoneState(4);
                return telDSIMobileEquipmentDeviceAccess.getActivationState().toString();
            }
            return "\r\n No associated device found";
        }
    }

    class TelDSIMobileEquipementTopologyListener
    implements DSIMobileEquipmentTopologyListener,
    ICommandResponseSupplier {
        TelDSIMobileEquipementTopologyListener() {
        }

        public DSIListener getDSIDefaultHandler() {
            return TelDSIMobileEquipementTopologyAccess.this.defaultListener;
        }

        public CommandList getActiveCommandList() {
            return TelDSIMobileEquipementTopologyAccess.this.commandListManager.getActiveCommandList();
        }

        public LogChannel getLogChannel() {
            return TelDSIMobileEquipementTopologyAccess.this.getApplication().getLogChannel("App.Phone.DSI.CL");
        }

        public String getHandlerName() {
            return "TelDSIMobileEquipementTopologyListener";
        }

        public void asyncException(int n, String string, int n2) {
            Buffer buffer = new Buffer();
            buffer.append("errorCode=");
            buffer.append(n);
            buffer.append(", ");
            TelDSIMobileEquipementTopologyAccess.this.log.log(100000, "[TelDSIMobileEquipementTopologyListener#asyncException] %1", (Object)buffer);
        }

        public void updateUsage(final int[] nArray, int n) {
            if (n == 1) {
                TelDSIMobileEquipementTopologyAccess.this.getApplication().enqueueEvent(new AbstractTelDSIUpdateEvent("DSIMobileEquipementTopologyListener#updateUsage"){

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    public void run() {
                        TelDSIMobileEquipementTopologyAccess.this.log.log(1000000, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyListener#updateUsage] usage=%1", (Object)Converter.intArrayToString(nArray));
                        Object object = TelDSIMobileEquipementTopologyAccess.this.deviceTopologyMutex;
                        synchronized (object) {
                            if (nArray != null) {
                                for (int i2 = 0; i2 < nArray.length; ++i2) {
                                    TelDSIMobileEquipementTopologyAccess.this.deviceInstances[i2].setIsNadInstance(nArray[i2] == 0);
                                }
                            }
                            TelDSIMobileEquipementTopologyAccess.access$902(TelDSIMobileEquipementTopologyAccess.this, nArray);
                            if (TelDSIMobileEquipementTopologyAccess.this.currentTopology != null) {
                                TelDSIMobileEquipementTopologyAccess.this.currentTopology.setInstanceUsage(nArray);
                            }
                        }
                    }
                });
            }
        }

        public void updateTopology(final int[] nArray, int n) {
            if (n == 1) {
                TelDSIMobileEquipementTopologyAccess.this.getApplication().enqueueEvent(new AbstractTelDSIUpdateEvent("DSIMobileEquipementTopologyListener#updateTopology"){

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    public void run() {
                        Object object = TelDSIMobileEquipementTopologyAccess.this.deviceTopologyMutex;
                        synchronized (object) {
                            TelDSIMobileEquipementTopologyAccess.this.currentTopology = new Topology(TelDSIMobileEquipementTopologyAccess.this.log, TelDSIMobileEquipementTopologyAccess.this.secondPhoneFeatureSupported, nArray);
                            TelDSIMobileEquipementTopologyAccess.this.currentTopology.setInstanceUsage(TelDSIMobileEquipementTopologyAccess.this.instanceUsage);
                            TelDSIMobileEquipementTopologyAccess.this.log.log(1000000, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyAccess(...).new DSIMobileEquipmentTopologyListener() {...}#updateTopology] %1", (Object)TelDSIMobileEquipementTopologyAccess.this.currentTopology);
                            if (nArray != null && nArray.length > 0) {
                                if (TelDSIMobileEquipementTopologyAccess.this.currentTopology.isInitState()) {
                                    TelDSIMobileEquipementTopologyAccess.this.log.log(1000000, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyAccess(...).new DSIMobileEquipmentTopologyListener() {...}#updateTopology] INIT_STATE --> showing wait screen");
                                } else {
                                    TelDSIMobileEquipementTopologyAccess.this.assignRoles();
                                }
                            } else {
                                TelDSIMobileEquipementTopologyAccess.this.log.log(100000, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipementTopologyListener.updateTopology(...).new Runnable() {...}#run] invalid slot data --> NOP!");
                            }
                            TelDSIMobileEquipementTopologyAccess.this.getApplication().getGlobalTelephoneStateManager().updateTopology(TelDSIMobileEquipementTopologyAccess.this.currentTopology);
                        }
                    }
                });
            }
        }

        public void responseChangeTopology(final int n) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((ITelDSIMobileEquipementResponseListener)dSIListener).responseChangeTopology(n);
                }
            });
        }
    }
}

