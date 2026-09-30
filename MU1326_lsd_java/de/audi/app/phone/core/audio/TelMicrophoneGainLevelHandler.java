/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.TelAudiDSISoundDefaultHandler;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import java.util.Hashtable;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIBase;
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
    private final DSISSEListener dsiSSEListener;
    private volatile int lastMicGainLevel = Integer.MIN_VALUE;
    private volatile IGlobalTelephoneStateStruct lastStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSEListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSE;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;

    public TelMicrophoneGainLevelHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.dsiSSEListener = new TelMicrophoneGainLevelDSISSEListener();
        Hashtable hashtable = new Hashtable(8);
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$sse$DSISSEListener == null ? (class$org$dsi$ifc$sse$DSISSEListener = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.sse.DSISSEListener")) : class$org$dsi$ifc$sse$DSISSEListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.dsiSSEListenerServiceProvider = new PhoneServiceProvider((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.dsiSSEListener, hashtable, this.getApplication().getBundleContext(), this.log);
        this.dsiSSETracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$org$dsi$ifc$sse$DSISSE == null ? (class$org$dsi$ifc$sse$DSISSE = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.sse.DSISSE")) : class$org$dsi$ifc$sse$DSISSE).getName(), (ServiceTrackerCustomizer)this, this.log);
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.configureMicrophoneGainRangeModelLimits();
        this.getMicrophoneGainRangeModel().setRangeListener(this);
        TelMicrophoneGainLevelDSISoundListener telMicrophoneGainLevelDSISoundListener = new TelMicrophoneGainLevelDSISoundListener();
        TelMicrophoneGainLevelDSISoundClient telMicrophoneGainLevelDSISoundClient = new TelMicrophoneGainLevelDSISoundClient();
        this.dsiSoundActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = TelMicrophoneGainLevelHandler.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), new Integer(0), telMicrophoneGainLevelDSISoundListener, telMicrophoneGainLevelDSISoundClient);
        this.dsiSoundActivator.start(this.getApplication().getBundleContext());
        this.dsiSSEListenerServiceProvider.startService();
        this.dsiSSETracker.openTracker();
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getMicrophoneGainRangeModel().resetListener();
        if (this.dsiSoundActivator != null) {
            this.dsiSoundActivator.stop(this.getApplication().getBundleContext());
        }
        this.dsiSSETracker.closeTracker();
        this.dsiSSEListenerServiceProvider.stopService();
    }

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

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

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

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.lastStateStruct = iGlobalTelephoneStateStruct;
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && (n == 65565 || n == 131101)) {
            int n2 = iGlobalTelephoneStateStruct.getCallLeadingDevice().getMicGainLevel();
            if (this.lastMicGainLevel == Integer.MIN_VALUE) {
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
        return this.getRangeModel(300369);
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
            this.log.log(1000000, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSISoundViaDSITelephoneUpdate] micGainLevel=%1", (long)n);
            dSISound.setMicGainLevel(n);
        } else {
            this.log.log(10000, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSISoundViaDSITelephoneUpdate] dsiSound is null");
        }
    }

    private void setMicGainLevelDSISSEViaDSITelephoneUpdate(int n) {
        DSISSE dSISSE = this.dsiSSE;
        if (dSISSE != null) {
            this.log.log(1000000, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSISSEViaDSITelephoneUpdate] micGainLevel=%1", (long)n);
            dSISSE.requestSetMicGainLevel(n);
        }
    }

    private void setMicGainLevelDSITelephone(int n) {
        this.log.log(10000000, "[TelMicrophoneGainLevelHandler#setMicGainLevelDSITelephone] micGainLevel=%1 (lastMicGainLevel=%2)", (long)n, (long)this.lastMicGainLevel);
        this.getApplication().getTelephoneDSIAccess().requestSetMicGainLevel(n, 0);
        this.lastMicGainLevel = n;
    }

    private void increaseMicGainLevelDSITelephone(int n) {
        int n2 = this.lastMicGainLevel + n;
        this.log.log(1000000, "[TelMicrophoneGainLevelHandler#increaseMicGainLevelDSITelephone] steps=%1, newMicGainLevel=%2", (long)n, (long)n2);
        this.setMicGainLevelDSITelephone(n2);
    }

    private void decreaseMicGainLevelDSITelephone(int n) {
        int n2 = this.lastMicGainLevel - n;
        this.log.log(1000000, "[TelMicrophoneGainLevelHandler#decreaseMicGainLevelDSITelephone] steps=%1, newMicGainLevel=%2", (long)n, (long)n2);
        this.setMicGainLevelDSITelephone(n2);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == this.getMicrophoneGainRangeModel().getID()) {
            this.getMicrophoneGainRangeModel().fireEvent(n3);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void decrement(int n, int n2, int n3) {
        if (n == this.getMicrophoneGainRangeModel().getID()) {
            this.log.log(1000000, "[TelMicrophoneGainLevelHandler#decrement] steps=%1", (long)n2);
            this.decreaseMicGainLevelDSITelephone(n2);
        }
    }

    public void increment(int n, int n2, int n3) {
        if (n == this.getMicrophoneGainRangeModel().getID()) {
            this.log.log(1000000, "[TelMicrophoneGainLevelHandler#increment] steps=%1", (long)n2);
            this.increaseMicGainLevelDSITelephone(n2);
        }
    }

    private void setMicGainRangeModel(int n) {
        if (this.lastMicGainLevel == Integer.MIN_VALUE || this.lastMicGainLevel == n) {
            this.log.log(1000000, "[TelMicrophoneGainLevelHandler#setMicGainRangeModel] SET model lastMicGainLevel=%1, micGainLevel=%2", (long)this.lastMicGainLevel, (long)n);
            this.getMicrophoneGainRangeModel().setValue(n);
        } else {
            this.log.log(1000000, "[TelMicrophoneGainLevelHandler#setMicGainRangeModel] NO SET model lastMicGainLevel=%1, micGainLevel=%2", (long)this.lastMicGainLevel, (long)n);
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

    private class TelMicrophoneGainLevelDSISSEListener
    implements DSISSEListener {
        private TelMicrophoneGainLevelDSISSEListener() {
        }

        public void asyncException(int n, String string, int n2) {
            TelMicrophoneGainLevelHandler.this.log.log(100000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#asyncException] %1", (Object)TelLoggingUtils.asyncException(n, string, n2));
        }

        public void responseSetMode(int n) {
        }

        public void updateMode(int n, int n2) {
        }

        public void updateMicGainLevel(final int n, final int n2) {
            TelMicrophoneGainLevelHandler.this.getApplication().enqueueEvent(new AbstractTelDSIUpdateEvent("DSISSEListener#updateMicGainLevel"){

                public void run() {
                    if (n2 == 1) {
                        TelMicrophoneGainLevelHandler.this.log.log(1000000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#updateMicGainLevel] micGainLevel=%1", (long)n);
                        if (TelMicrophoneGainLevelHandler.this.lastStateStruct != null && TelMicrophoneGainLevelHandler.this.lastStateStruct.isPhoneReady()) {
                            TelMicrophoneGainLevelHandler.this.setMicGainRangeModel(n);
                        }
                    } else {
                        TelMicrophoneGainLevelHandler.this.log.log(1000000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#updateMicGainLevel] invalid update --> NOP!");
                    }
                }
            });
        }

        public void responseSetMicGainLevel(int n) {
            TelMicrophoneGainLevelHandler.this.log.log(1000000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#responseSetMicGainLevel] replyCode=%1", (long)n);
        }

        public void updateMicMuteState(int n, int n2) {
        }

        public void responseSetMicMuteState(int n) {
        }
    }

    private class TelMicrophoneGainLevelDSISoundClient
    implements IDSIClient {
        private TelMicrophoneGainLevelDSISoundClient() {
        }

        public void setDSI(DSIBase dSIBase) {
            if (dSIBase instanceof DSISound) {
                TelMicrophoneGainLevelHandler.this.log.log(1000000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#setDSI] DSISound available");
                TelMicrophoneGainLevelHandler.this.dsiSound = (DSISound)dSIBase;
            } else {
                TelMicrophoneGainLevelHandler.this.log.log(1000000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#setDSI] DSISound not available");
                TelMicrophoneGainLevelHandler.this.dsiSound = null;
            }
        }

        public int[] getAutoNotifications() {
            return new int[]{37};
        }
    }

    private class TelMicrophoneGainLevelDSISoundListener
    extends TelAudiDSISoundDefaultHandler {
        private TelMicrophoneGainLevelDSISoundListener() {
        }

        public void updateMicGainLevel(final int n, final int n2) {
            TelMicrophoneGainLevelHandler.this.getApplication().enqueueEvent(new AbstractTelDSIUpdateEvent("TelAudiDSISoundDefaultHandler#updateMicGainLevel"){

                public void run() {
                    if (n2 == 1) {
                        TelMicrophoneGainLevelHandler.this.log.log(1000000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#updateMicGainLevel] micGainLevel=%1", (long)n);
                        if (TelMicrophoneGainLevelHandler.this.lastStateStruct != null && TelMicrophoneGainLevelHandler.this.lastStateStruct.isPhoneReady()) {
                            TelMicrophoneGainLevelHandler.this.setMicGainRangeModel(n);
                        }
                    } else {
                        TelMicrophoneGainLevelHandler.this.log.log(1000000, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#updateMicGainLevel] invalid update --> NOP!");
                    }
                }
            });
        }
    }
}

