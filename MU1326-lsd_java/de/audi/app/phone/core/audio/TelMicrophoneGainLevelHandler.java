/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import java.util.Hashtable;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sse.DSISSE;
import org.dsi.ifc.sse.DSISSEListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelMicrophoneGainLevelHandler
extends AbstractPhoneComponent
implements RangeListener,
ServiceTrackerCustomizer {
    private DSIActivator dsiSoundActivator;
    private volatile DSISound dsiSound;
    private volatile DSISSE dsiSSE;
    private final PhoneServiceProvider dsiSSEListenerServiceProvider;
    private final PhoneServiceTracker dsiSSETracker;
    private final DSISSEListener dsiSSEListener = new TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener(this, null);
    private volatile int lastMicGainLevel = 128;
    private volatile IGlobalTelephoneStateStruct lastStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSEListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSE;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;

    public TelMicrophoneGainLevelHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        Hashtable hashtable = new Hashtable(8);
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$sse$DSISSEListener == null ? (class$org$dsi$ifc$sse$DSISSEListener = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.sse.DSISSEListener")) : class$org$dsi$ifc$sse$DSISSEListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.dsiSSEListenerServiceProvider = new PhoneServiceProvider((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.dsiSSEListener, hashtable, this.getApplication().getBundleContext(), this.log);
        this.dsiSSETracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$org$dsi$ifc$sse$DSISSE == null ? (class$org$dsi$ifc$sse$DSISSE = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.sse.DSISSE")) : class$org$dsi$ifc$sse$DSISSE).getName(), (ServiceTrackerCustomizer)this, this.log);
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.configureMicrophoneGainRangeModelLimits();
        this.getMicrophoneGainRangeModel().setRangeListener(this);
        TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener = new TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener(this, null);
        TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient = new TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient(this, null);
        this.dsiSoundActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), new Integer(0), telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener, telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient);
        this.dsiSoundActivator.start(this.getApplication().getBundleContext());
        this.dsiSSEListenerServiceProvider.startService();
        this.dsiSSETracker.openTracker();
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getMicrophoneGainRangeModel().resetListener();
        if (this.dsiSoundActivator != null) {
            this.dsiSoundActivator.stop(this.getApplication().getBundleContext());
        }
        this.dsiSSETracker.closeTracker();
        this.dsiSSEListenerServiceProvider.stopService();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "TelMicrophoneGainLevelHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "TelMicrophoneGainLevelHandler#addingService service is null");
            return null;
        }
        if (object instanceof DSISSE) {
            this.dsiSSE = (DSISSE)object;
            this.dsiSSE.setNotification(1, (DSIListener)this.dsiSSEListener);
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
            this.log.log(10000, "TelMicrophoneGainLevelHandler#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "TelMicrophoneGainLevelHandler#removedService service is null");
            return;
        }
        if (object instanceof DSISSE) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.dsiSSE = null;
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.lastStateStruct = iGlobalTelephoneStateStruct;
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && (n == 0x1D000100 || n == 486539776)) {
            int n2 = iGlobalTelephoneStateStruct.getCallLeadingDevice().getMicGainLevel();
            if (this.lastMicGainLevel == 128) {
                this.lastMicGainLevel = n2;
            }
            this.setMicGainRangeModel(n2);
            this.setMicGainLevel(n2);
        }
    }

    private boolean useDSISSE() {
        return this.dsiSSE != null;
    }

    protected RangeModelApp getMicrophoneGainRangeModel() {
        return this.getRangeModel(1368720384);
    }

    protected void configureMicrophoneGainRangeModelLimits() {
        this.getMicrophoneGainRangeModel().setLimits(-6, 6, 2);
    }

    private void setMicGainLevel(int n) {
        if (this.useDSISSE()) {
            this.setMicGainLevelDSISSEViaDSITelephoneUpdate(n);
        } else {
            this.setMicGainLevelDSISoundViaDSITelephoneUpdate(n);
        }
    }

    private void setMicGainLevelDSISoundViaDSITelephoneUpdate(int n) {
        DSISound dSISound = this.dsiSound;
        if (dSISound != null) {
            this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSISoundViaDSITelephoneUpdate] micGainLevel=%1", (long)n);
            dSISound.setMicGainLevel(n);
        } else {
            this.log.log(10000, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSISoundViaDSITelephoneUpdate] dsiSound is null");
        }
    }

    private void setMicGainLevelDSISSEViaDSITelephoneUpdate(int n) {
        DSISSE dSISSE = this.dsiSSE;
        if (dSISSE != null) {
            this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSISSEViaDSITelephoneUpdate] micGainLevel=%1", (long)n);
            dSISSE.requestSetMicGainLevel(n);
        }
    }

    private void setMicGainLevelDSITelephone(int n) {
        this.log.log(-2137614336, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSITelephone] micGainLevel=%1 (lastMicGainLevel=%2)", (long)n, (long)this.lastMicGainLevel);
        this.getApplication().getTelephoneDSIAccess().requestSetMicGainLevel(n, 0);
        this.lastMicGainLevel = n;
    }

    private void increaseMicGainLevelDSITelephone(int n) {
        int n2 = this.lastMicGainLevel + n;
        this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#increaseMicGainLevelDSITelephone] steps=%1, newMicGainLevel=%2", (long)n, (long)n2);
        this.setMicGainLevelDSITelephone(n2);
    }

    private void decreaseMicGainLevelDSITelephone(int n) {
        int n2 = this.lastMicGainLevel - n;
        this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#decreaseMicGainLevelDSITelephone] steps=%1, newMicGainLevel=%2", (long)n, (long)n2);
        this.setMicGainLevelDSITelephone(n2);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.getMicrophoneGainRangeModel().getID()) {
            this.getMicrophoneGainRangeModel().fireEvent(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        if (n == this.getMicrophoneGainRangeModel().getID()) {
            this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#decrement] steps=%1", (long)n2);
            this.decreaseMicGainLevelDSITelephone(n2);
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        if (n == this.getMicrophoneGainRangeModel().getID()) {
            this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#increment] steps=%1", (long)n2);
            this.increaseMicGainLevelDSITelephone(n2);
        }
    }

    private void setMicGainRangeModel(int n) {
        if (this.lastMicGainLevel == 128 || this.lastMicGainLevel == n) {
            this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#setMicGainRangeModel] SET model lastMicGainLevel=%1, micGainLevel=%2", (long)this.lastMicGainLevel, (long)n);
            this.getMicrophoneGainRangeModel().setValue(n);
        } else {
            this.log.log(1078071040, "[TelMicrophoneGainLevelHandler#setMicGainRangeModel] NO SET model lastMicGainLevel=%1, micGainLevel=%2", (long)this.lastMicGainLevel, (long)n);
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

    static /* synthetic */ LogChannel access$400(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$500(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.lastStateStruct;
    }

    static /* synthetic */ void access$600(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler, int n) {
        telMicrophoneGainLevelHandler.setMicGainRangeModel(n);
    }

    static /* synthetic */ LogChannel access$700(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }

    static /* synthetic */ ITelApplication access$800(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.getApplication();
    }

    static /* synthetic */ LogChannel access$900(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }

    static /* synthetic */ DSISound access$1002(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler, DSISound dSISound) {
        telMicrophoneGainLevelHandler.dsiSound = dSISound;
        return telMicrophoneGainLevelHandler.dsiSound;
    }

    static /* synthetic */ LogChannel access$1100(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }

    static /* synthetic */ LogChannel access$1200(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }

    static /* synthetic */ LogChannel access$1400(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }

    static /* synthetic */ LogChannel access$1500(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }

    static /* synthetic */ ITelApplication access$1600(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.getApplication();
    }

    static /* synthetic */ LogChannel access$1700(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        return telMicrophoneGainLevelHandler.log;
    }
}

