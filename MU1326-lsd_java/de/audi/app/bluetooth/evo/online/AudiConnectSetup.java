/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.online;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.online.IConnectAppSetup;
import de.audi.app.bluetooth.core.security.AbstractPostPairingHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceRegistration;

public class AudiConnectSetup
extends AbstractPostPairingHandler
implements IConnectAppSetup {
    private static final int MESSAGING;
    private static final int NO_CHECK;
    private static final int PAIRED_HFP;
    private static final int PAIRED_SAP;
    private ServiceRegistration registration;
    private final ChoiceModelApp blueOfficeSetupChoice = this.getChoiceModel(1780884992);
    private boolean simInserted;
    private boolean tetheringConnected;
    private boolean eSimActive;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$online$IConnectAppSetup;

    public AudiConnectSetup(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected void handleNewDevice(TrustedDevice trustedDevice) {
        boolean bl = this.deviceSupportsOnlyHfp(trustedDevice);
        boolean bl2 = this.deviceSupportsSapAndMap(trustedDevice);
        boolean bl3 = this.isDataDeviceConnected();
        boolean bl4 = this.isTetheringCoded();
        this.log.log(1078071040, new StringBuffer().append("AudiConnectSetup#handleNewDevice(): hfp=%1, sap=%2, data=%3, tetheringAllowed=").append(bl4).toString(), bl, bl2, bl3);
        if (bl && !bl3 && bl4) {
            this.log.log(-2137614336, "AudiConnectSetup#handleNewDevice(): Paired HFP device");
            this.blueOfficeSetupChoice.setValue(1);
        } else if (bl2) {
            this.log.log(-2137614336, "AudiConnectSetup#handleNewDevice(): Paired SAP device");
            this.blueOfficeSetupChoice.setValue(2);
        } else {
            this.cleanupAfterPairing();
        }
    }

    private boolean isTetheringCoded() {
        return this.bluetoothApplication.getFramework().getSysConst(4442) == 1;
    }

    private boolean deviceSupportsSapAndMap(TrustedDevice trustedDevice) {
        return trustedDevice != null && (trustedDevice.getActiveServiceTypes() & 4) > 0 && (trustedDevice.getOfferedServiceTypes() & 0x6000) > 0;
    }

    private boolean isDataDeviceConnected() {
        return this.simInserted || this.tetheringConnected || this.eSimActive;
    }

    private boolean deviceSupportsOnlyHfp(TrustedDevice trustedDevice) {
        return trustedDevice != null && (trustedDevice.getActiveServiceTypes() & 2) > 0 && (trustedDevice.getOfferedServiceTypes() & 4) == 0;
    }

    @Override
    protected void cleanupAfterPairing() {
        this.log.log(-2137614336, "AudiConnectSetup#cleanupAfterPairing()");
        this.blueOfficeSetupChoice.setValue(0);
    }

    @Override
    public void updateSimState(boolean bl) {
        this.log.log(-2137614336, "AudiConnectSetup#updateSimState(): simInserted=%1", bl);
        this.simInserted = bl;
    }

    @Override
    public void updateESimState(boolean bl) {
        this.log.log(-2137614336, "AudiConnectSetup#updateESimState(): eSimActive=%1", bl);
        this.eSimActive = bl;
    }

    @Override
    public void updateWlanState(boolean bl) {
        this.log.log(1078071040, "AudiConnectSetup#updateWlanState(): tetheringConnected=%1", bl);
        this.tetheringConnected = bl;
    }

    @Override
    public void officeSetupLeft() {
        this.log.log(-2137614336, "AudiConnectSetup#officeSetupLeft(): Resetting office setup model");
        this.blueOfficeSetupChoice.setValue(0);
    }

    @Override
    public void init() {
        super.init();
        this.registration = this.bundleContext.registerService((class$de$audi$app$bluetooth$core$online$IConnectAppSetup == null ? (class$de$audi$app$bluetooth$core$online$IConnectAppSetup = AudiConnectSetup.class$("de.audi.app.bluetooth.core.online.IConnectAppSetup")) : class$de$audi$app$bluetooth$core$online$IConnectAppSetup).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.registration.unregister();
        this.registration = null;
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

