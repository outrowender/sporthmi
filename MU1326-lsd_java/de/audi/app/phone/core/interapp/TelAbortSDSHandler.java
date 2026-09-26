/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.interapp.TelAbortSDSHandler$1;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.SDSService;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelAbortSDSHandler
extends AbstractPhoneComponent {
    private final PhoneServiceTracker sdsServiceTracker;
    private volatile SDSService sdsService;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public TelAbortSDSHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.sdsServiceTracker = new PhoneServiceTracker(iTelApplication.getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = TelAbortSDSHandler.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)new TelAbortSDSHandler$1(this), this.log);
    }

    @Override
    public void init() {
        super.init();
        this.sdsServiceTracker.openTracker();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(0x8000100, (IGlobalTelephoneStateListener)this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.sdsServiceTracker.closeTracker();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(0x8000100, (IGlobalTelephoneStateListener)this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        if (!(n != 0x8000100 && n != 0x8000200 && n != 0x8000300 || (iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice()) == null || iTelDSIMobileEquipmentDeviceState.getCallState() == null || iTelDSIMobileEquipmentDeviceState.getCallState().getTransition() != 2 && iGlobalTelephoneStateStruct.getCallState().getTransition() != 1)) {
            SDSService sDSService = this.sdsService;
            if (sDSService != null) {
                this.log.log(1078071040, "[TelAbortSDSHandler#updateGlobalTelephoneStateProperty] incoming call accepted. Aborting SDS!");
                sDSService.abortSDSSession(true, (byte)7);
            } else {
                this.log.log(-1601830656, "[TelAbortSDSHandler#updateGlobalTelephoneStateProperty] SDSService is null --> NOP!");
            }
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

    static /* synthetic */ ITelApplication access$000(TelAbortSDSHandler telAbortSDSHandler) {
        return telAbortSDSHandler.getApplication();
    }

    static /* synthetic */ SDSService access$102(TelAbortSDSHandler telAbortSDSHandler, SDSService sDSService) {
        telAbortSDSHandler.sdsService = sDSService;
        return telAbortSDSHandler.sdsService;
    }

    static /* synthetic */ ITelApplication access$200(TelAbortSDSHandler telAbortSDSHandler) {
        return telAbortSDSHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$300(TelAbortSDSHandler telAbortSDSHandler) {
        return telAbortSDSHandler.getApplication();
    }
}

