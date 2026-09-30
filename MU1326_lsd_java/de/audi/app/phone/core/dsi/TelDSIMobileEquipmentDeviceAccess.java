/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.AbstractTelDSIDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentRequestWrapper;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.command.CommandListManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;

public class TelDSIMobileEquipmentDeviceAccess
extends AbstractTelDSIDeviceAccess {
    private final DSIActivator dsiMobileEquipementActivator;
    private volatile DSIMobileEquipment dsiMobileEquipment;
    private final CommandListManager commandListManager;
    private final CommandListManager hangupCommandListManager;
    private final TelDSIMobileEquipmentListener dsiListener;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipment;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;

    public TelDSIMobileEquipmentDeviceAccess(ITelApplication iTelApplication, int n, int n2) {
        super(iTelApplication, n, n2);
        this.commandListManager = new CommandListManager(new StringBuffer().append("TelDSIMobileEquipmentDeviceAccess(").append(n).append(")").toString(), this.getApplication().getFrameworkAccess(), this.cmdListLogChannel, null, null);
        this.hangupCommandListManager = new CommandListManager(new StringBuffer().append("TelDSIMobileEquipmentDeviceAccess(").append(n).append(")Hangup").toString(), this.getApplication().getFrameworkAccess(), this.cmdListLogChannel, null, null);
        this.dsiListener = new TelDSIMobileEquipmentListener(iTelApplication, n, this.commandListManager, this.hangupCommandListManager, this.cmdListLogChannel);
        this.dsiMobileEquipementActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = TelDSIMobileEquipmentDeviceAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment).getName(), (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = TelDSIMobileEquipmentDeviceAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener).getName(), new Integer(n), this.dsiListener, new IDSIClient(){

            public void setDSI(DSIBase dSIBase) {
                TelDSIMobileEquipmentDeviceAccess.this.dsiMobileEquipment = (DSIMobileEquipment)dSIBase;
            }

            public int[] getAutoNotifications() {
                return DSIActivator.ATTR_ALL;
            }
        });
        this.addSubPhoneComponent(this.dsiListener);
    }

    public void init() {
        super.init();
        this.startCmdManager();
        this.dsiMobileEquipementActivator.start(this.getApplication().getBundleContext());
    }

    public void deinit() {
        super.deinit();
        this.stopCmdManager();
        this.dsiMobileEquipementActivator.stop(this.getApplication().getBundleContext());
    }

    public void setIsNadInstance(boolean bl) {
        super.setIsNadInstance(bl);
        this.dsiListener.setIsNadInstance(bl);
        this.updateNadUsageForRole();
    }

    public void setNotification() {
        if (this.dsiMobileEquipment != null) {
            this.dsiMobileEquipment.setNotification(this.dsiListener);
        }
    }

    public void setDeviceRole(int n) {
        super.setDeviceRole(n);
        this.dsiListener.setDeviceRole(n);
        this.updateNadUsageForRole();
        this.setNotification();
    }

    public void updateNadUsageForRole() {
        if (this.isNadInstance) {
            switch (this.deviceRole) {
                case 65536: {
                    this.getApplication().getGlobalTelephoneStateManager().setNadUsagePrimary();
                    break;
                }
                case 131072: {
                    this.getApplication().getGlobalTelephoneStateManager().setNadUsageAssociated();
                    break;
                }
                case 196608: {
                    this.getApplication().getGlobalTelephoneStateManager().setNadUsageData();
                    break;
                }
                default: {
                    this.getApplication().getGlobalTelephoneStateManager().setNadUsageUnknown();
                }
            }
        }
    }

    void startCmdManager() {
        this.commandListManager.start();
        this.hangupCommandListManager.start();
    }

    public TelDSIMobileEquipmentListener getDsiListener() {
        return this.dsiListener;
    }

    void stopCmdManager() {
        this.commandListManager.destroy();
        this.hangupCommandListManager.destroy();
    }

    void setDsiMobileEquipment(DSIMobileEquipment dSIMobileEquipment) {
        this.dsiMobileEquipment = dSIMobileEquipment;
    }

    protected CommandListManager getCmdListManager() {
        return this.commandListManager;
    }

    protected CommandListManager getHangupCmdListManager() {
        return this.hangupCommandListManager;
    }

    protected ITelDSIMobileEquipmentRequestWrapper getDSIRequestWrapper() {
        return new TelDSIMobileEquipmentRequestWrapper(this.dsiMobileEquipment, this.log);
    }

    protected String getName() {
        return "TelDSIMobileEquipmentDeviceAccess";
    }

    public ActivationStateStruct getActivationState() {
        return this.dsiListener.activationState;
    }

    public void updateGlobalTelephoneState(int n) {
        this.dsiListener.updateGlobalTelephoneState(n);
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

