/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.TelSDSHandler$SDSServiceTracker;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.atip.interapp.PhoneServiceListener;
import de.audi.atip.interapp.SDSService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TelSDSHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private volatile SDSService sdsService;
    protected volatile PhoneServiceListener sdsPhoneServiceListener;
    private volatile PhoneServiceTracker sdsPhoneServiceListenerTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$PhoneServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public TelSDSHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Audio");
        this.addSubPhoneComponent(new TelSDSHandler$SDSServiceTracker(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.sdsPhoneServiceListenerTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$PhoneServiceListener == null ? (class$de$audi$atip$interapp$PhoneServiceListener = TelSDSHandler.class$("de.audi.atip.interapp.PhoneServiceListener")) : class$de$audi$atip$interapp$PhoneServiceListener).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.sdsPhoneServiceListenerTracker.openTracker();
    }

    @Override
    public void deinit() {
        super.deinit();
        if (this.sdsPhoneServiceListenerTracker != null) {
            this.sdsPhoneServiceListenerTracker.closeTracker();
            this.sdsPhoneServiceListenerTracker = null;
        }
    }

    public void updateExternalSDSActive() {
        SDSService sDSService = this.sdsService;
        if (sDSService != null) {
            sDSService.updateExternalSDSActive();
        }
    }

    void checkPauseResumeSDS(CallStateStruct callStateStruct) {
        if (callStateStruct != null) {
            int n = callStateStruct.getMpCallState();
            if (n == 15 || n == 27) {
                this.log.log(1078071040, "TelSDSHandler#checkPauseResumeSDS(): mpCallState=%1, pausing SDS.", (long)n);
                this.pauseSDSAndBlockPTT();
            } else if (callStateStruct.isIdle()) {
                this.log.log(1078071040, "TelSDSHandler#checkPauseResumeSDS(): call state IDLE, resuming SDS");
                this.resumeSDSAndRemovePTTLock();
            } else {
                this.log.log(1078071040, "TelSDSHandler#checkPauseResumeSDS(): blocking PTT");
                this.blockPTT();
            }
        } else {
            this.log.log(-1601830656, "TelSDSHandler#checkPauseResumeSDS(): callState is null --> NOP!");
        }
    }

    private void pauseSDSAndBlockPTT() {
        this.pauseSDS();
        this.blockPTT();
    }

    void resumeSDSAndRemovePTTLock() {
        this.resumeSDS();
        this.unblockPTT();
    }

    private void pauseSDS() {
        PhoneServiceListener phoneServiceListener = this.sdsPhoneServiceListener;
        if (phoneServiceListener != null) {
            this.log.log(1078071040, "TelSDSHandler#pauseSDS(): called");
            phoneServiceListener.pauseSDS();
        } else {
            this.log.log(-1601830656, "TelSDSHandler#pauseSDS(): PhoneServiceListener is null --> NOP");
        }
    }

    private void blockPTT() {
        SDSService sDSService = this.sdsService;
        if (sDSService != null) {
            sDSService.disablePTT(true, false, (byte)3);
        } else {
            this.log.log(-1601830656, "TelSDSHandler#blockPTT(): SDSService is null --> NOP");
        }
    }

    private void resumeSDS() {
        PhoneServiceListener phoneServiceListener = this.sdsPhoneServiceListener;
        if (phoneServiceListener != null) {
            this.log.log(1078071040, "TelSDSHandler#resumeSDS(): ");
            phoneServiceListener.resumeSDS(true);
        } else {
            this.log.log(-1601830656, "TelSDSHandler#resumeSDS(): PhoneServiceListener is null --> NOP");
        }
    }

    private void unblockPTT() {
        SDSService sDSService = this.sdsService;
        if (sDSService != null) {
            sDSService.disablePTT(false, false, (byte)3);
        } else {
            this.log.log(-1601830656, "TelSDSHandler#unblockPTT(): SDSService is null --> NOP");
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "TelSDSHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "TelSDSHandler#addingService service is null");
            return null;
        }
        if (object instanceof PhoneServiceListener) {
            this.sdsPhoneServiceListener = (PhoneServiceListener)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "TelSDSHandler#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "TelSDSHandler#removedService service is null");
            return;
        }
        if (object instanceof PhoneServiceListener) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.sdsPhoneServiceListener = null;
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

    static /* synthetic */ SDSService access$002(TelSDSHandler telSDSHandler, SDSService sDSService) {
        telSDSHandler.sdsService = sDSService;
        return telSDSHandler.sdsService;
    }
}

