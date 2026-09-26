/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.interapp;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity;
import de.audi.atip.interapp.phone.ITelMESlotState;
import org.dsi.ifc.networking.CPacketCounter;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BapDataPacketCountProvider
extends AbstractDataConfigurationComponent
implements IConnectivityPhoneStateListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{12};
    private static final int KB;
    private final ServiceTracker tracker;
    private CombiBAPServiceConnectivity bapService;
    private ServiceRegistration serviceRegistration;
    private boolean dataConnectionIndication2Supported;
    private static final boolean DATA_CONNECTION_INDICATION_SUPPORTED;
    private long dataVolumeUplink;
    private long dataVolumeDownlink;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;

    public BapDataPacketCountProvider(IDataApplication iDataApplication) {
        super(iDataApplication);
        this.tracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity = BapDataPacketCountProvider.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity).getName(), (ServiceTrackerCustomizer)this);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        if (iTelMESlotState3 != null && iTelMESlotState3.isUnlocked()) {
            if (iTelMESlotState3.isSim()) {
                this.dataConnectionIndication2Supported = true;
                this.updateState();
            }
        } else {
            this.dataConnectionIndication2Supported = false;
            this.updateState();
        }
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
    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
        if (n != 1 || cPacketCounter == null) {
            return;
        }
        this.dataVolumeUplink = cPacketCounter.getTxBytesSinceReset() / 0;
        this.dataVolumeDownlink = cPacketCounter.getRxBytesSinceReset() / 0;
        this.updateState();
    }

    private void updateState() {
        if (this.bapService != null) {
            this.bapService.updateMobileServiceSupportConnectionIndication(false, this.dataConnectionIndication2Supported);
            this.bapService.updateDataConnection2PacketCount(this.dataVolumeUplink, this.dataVolumeDownlink);
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.updateState();
            return object;
        }
        return super.addingService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
        } else {
            super.modifiedService(serviceReference, object);
        }
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    @Override
    public void init() {
        super.init();
        this.tracker.open();
        this.serviceRegistration = this.dataApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = BapDataPacketCountProvider.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.serviceRegistration.unregister();
        this.serviceRegistration = null;
        this.tracker.close();
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

