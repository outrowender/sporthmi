/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.wlan.core.mode;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.mode.AbstractWlanMode$1;
import de.audi.app.wlan.core.mode.CommandSetRFActive;
import de.audi.app.wlan.core.mode.CommandSetRole;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.SDISConnectionStateListener;
import de.audi.atip.interapp.WlanService;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractWlanMode
extends AbstractWlanComponent
implements ButtonListener,
WlanService,
IConnectivityPhoneStateListener,
SDISConnectionStateListener {
    private static final int DISABLE;
    private static final int ENABLE;
    private final int[] attributeNotifications = new int[]{12, 1};
    private final ChoiceModelApp clientModeChoice = this.getChoiceModel(2082874880);
    private final ButtonModelApp activateHotspot = this.getButtonModel(1814439424);
    private final ButtonModelApp activateTethering = this.getButtonModel(1831216640);
    private boolean rfActive;
    private int role;
    private boolean simInserted;
    private boolean sdisConnected;
    private ServiceRegistration serviceRegistration1;
    private ServiceRegistration serviceRegistration2;
    private ServiceRegistration sdisConStateListenerRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$WlanService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDISConnectionStateListener;

    public AbstractWlanMode(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
        iWlanApplication.getDiag().addDiagnosisComponent((IDiagComponent)new AbstractWlanMode$1(this));
    }

    @Override
    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    protected boolean isClientModeForbidden() {
        return this.sdisConnected || this.simInserted;
    }

    @Override
    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        boolean bl;
        boolean bl2 = bl = iTelMESlotState3 != null && iTelMESlotState3.isSim();
        if (bl != this.simInserted) {
            this.log.log(-2137614336, "AbstractWlanMode#updateMESlotInfo(): simPresent=%1", bl);
            this.simInserted = bl;
        }
        this.setClientModeActivation();
    }

    private void setClientModeActivation() {
        this.clientModeChoice.setValue(this.isClientModeForbidden() || !this.rfActive ? 0 : 1);
    }

    @Override
    public void updatePhoneState(int n, int n2) {
    }

    @Override
    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
    }

    @Override
    public void telAppEntered() {
    }

    @Override
    public void telAppLeft() {
    }

    @Override
    public void telUnlockEntered() {
    }

    @Override
    public void telUnlockLeft() {
    }

    @Override
    public void updateConnectedGatewayState(boolean bl) {
    }

    @Override
    public void switchWlanState(boolean bl) {
        this.log.log(1078071040, "AbstractWlanMode#switchWlanState(): Switch on: %1", bl);
        this.turnWlanOn(bl, null);
    }

    protected void turnWlanOn(boolean bl, HMIModelApp hMIModelApp) {
        if (bl != this.rfActive) {
            CommandSetRFActive.schedule(this.wlanApplication, this.dsiWlan, hMIModelApp, bl);
        }
    }

    @Override
    public void setRole(int n) {
        this.log.log(1078071040, "AbstractWlanMode#setRole(): %1", (long)n);
        this.setRoleWithTethering(n);
    }

    private void setRoleWithTethering(int n) {
        this.setRoleWithActivation(n, null);
    }

    protected void setRoleOnly(int n, HMIModelApp hMIModelApp) {
        if (this.role != n) {
            CommandSetRole.schedule(this.wlanApplication, this.dsiWlan, hMIModelApp, n);
        }
    }

    protected void setRoleWithActivation(int n, HMIModelApp hMIModelApp) {
        if (this.role != n) {
            CommandSetRole.schedule(this.wlanApplication, this.dsiWlan, hMIModelApp, n);
        } else if (!this.rfActive) {
            this.turnWlanOn(true, hMIModelApp);
        }
    }

    @Override
    public void updateSdisConnected(boolean bl) {
        this.log.log(1078071040, "AbstractWlanMode#updateSdisConnected(): isSdis connected %1", bl);
        if (bl) {
            this.setRoleOnly(1, null);
        }
        this.sdisConnected = bl;
        this.setClientModeActivation();
    }

    @Override
    public void updateRFActive(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1078071040, "AbstractWlanMode#updateRFActive(): %1", (long)n);
        this.rfActive = n == 1;
        this.setWlanMode(this.rfActive, this.role);
        this.setClientModeActivation();
    }

    @Override
    public void updateRole(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1078071040, "AbstractWlanMode#updateRole(): %1", (long)n);
        this.role = n;
        this.setWlanMode(this.rfActive, this.role);
    }

    protected abstract void setWlanMode(boolean bl, int n) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.activateHotspot.getID()) {
            this.log.log(1078071040, "AbstractWlanMode#keyTyped(): Activating Hotspot");
            this.setRoleWithTethering(1);
            this.activateHotspot.fireEvent(n3);
        } else if (n == this.activateTethering.getID()) {
            this.log.log(1078071040, "AbstractWlanMode#keyTyped(): Activating Tethering");
            this.setRoleWithTethering(4);
            this.activateTethering.fireEvent(n3);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void init() {
        super.init();
        this.clientModeChoice.setValue(1);
        this.activateHotspot.setButtonListener(this);
        this.activateTethering.setButtonListener(this);
        this.serviceRegistration1 = this.wlanApplication.getBundleContext().registerService((class$de$audi$atip$interapp$WlanService == null ? (class$de$audi$atip$interapp$WlanService = AbstractWlanMode.class$("de.audi.atip.interapp.WlanService")) : class$de$audi$atip$interapp$WlanService).getName(), (Object)this, null);
        this.serviceRegistration2 = this.wlanApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = AbstractWlanMode.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
        this.sdisConStateListenerRegistration = this.wlanApplication.getBundleContext().registerService((class$de$audi$atip$interapp$SDISConnectionStateListener == null ? (class$de$audi$atip$interapp$SDISConnectionStateListener = AbstractWlanMode.class$("de.audi.atip.interapp.SDISConnectionStateListener")) : class$de$audi$atip$interapp$SDISConnectionStateListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.activateTethering.resetListener();
        this.activateHotspot.resetListener();
        this.serviceRegistration1.unregister();
        this.serviceRegistration2.unregister();
        this.sdisConStateListenerRegistration.unregister();
        this.sdisConStateListenerRegistration = null;
        super.deinit();
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

