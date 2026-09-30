/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.IResetSettingsListener;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.radio.IGracenoteService;
import de.audi.atip.interapp.radio.IGracenoteServiceListener;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class GracenoteManager
extends AbstractMediaTerminalComponent
implements IGracenoteServiceListener,
ServiceTrackerCustomizer,
ChoiceListener,
IResetSettingsListener {
    private static final String LOGCLASS = "GracenoteManager";
    private final LogChannel logger;
    private volatile ServiceRegistration registerService;
    private volatile IServiceTracker gracenoteServiceTracker;
    private final Object mutex = new Object();
    private boolean gracenoteEnabled;
    private IGracenoteService gracenoteService;
    private boolean waitForFirstUpdate;
    static /* synthetic */ Class class$de$audi$atip$interapp$radio$IGracenoteServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$radio$IGracenoteService;

    public GracenoteManager(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.logger = iMediaTerminal.getLogger().main();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.registerService = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$radio$IGracenoteServiceListener == null ? (class$de$audi$atip$interapp$radio$IGracenoteServiceListener = GracenoteManager.class$("de.audi.atip.interapp.radio.IGracenoteServiceListener")) : class$de$audi$atip$interapp$radio$IGracenoteServiceListener, this, new Hashtable());
        this.getChoiceModel(201046).setChoiceListener(this);
        Object object = this.mutex;
        synchronized (object) {
            this.waitForFirstUpdate = true;
        }
        this.gracenoteServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$radio$IGracenoteService == null ? (class$de$audi$atip$interapp$radio$IGracenoteService = GracenoteManager.class$("de.audi.atip.interapp.radio.IGracenoteService")) : class$de$audi$atip$interapp$radio$IGracenoteService, this);
        this.gracenoteServiceTracker.open();
        this.getTerminal().addResetSettingsListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getTerminal().getServiceManager().unregisterService(this.registerService);
        this.getChoiceModel(201046).setChoiceListener(null);
        this.gracenoteServiceTracker.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateOnlineLookupStatus(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.updateOnlineLookupStatus]", (Object)LOGCLASS);
            if (this.waitForFirstUpdate) {
                this.waitForFirstUpdate = false;
            }
            this.gracenoteEnabled = 1 == n;
            this.updateGracenoteAvailibility();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.mutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.addingService]", (Object)LOGCLASS);
            this.gracenoteService = (IGracenoteService)this.getTerminal().getServiceManager().getService(serviceReference);
            if (this.waitForFirstUpdate) {
                return this.gracenoteService;
            }
            if (this.gracenoteEnabled) {
                this.gracenoteService.enableOnlineLookup();
            } else {
                this.gracenoteService.disableOnlineLookup();
            }
            return this.gracenoteService;
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.logger.log(1000000, "[%1.removedService]", (Object)LOGCLASS);
            this.gracenoteService = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateGracenoteAvailibility() {
        this.logger.log(1000000, "[%1.updateGracenoteModel]", (Object)LOGCLASS);
        ChoiceModelApp choiceModelApp = this.getChoiceModel(201046);
        Object object = this.mutex;
        synchronized (object) {
            if (this.gracenoteEnabled) {
                choiceModelApp.setValue(1);
            } else {
                choiceModelApp.setValue(0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (201046 == n) {
            this.logger.log(1000000, "[%1.itemSelected]", (Object)LOGCLASS);
            Object object = this.mutex;
            synchronized (object) {
                if (null == this.gracenoteService) {
                    this.gracenoteEnabled = this.getChoiceModel(n).getValue() == 0;
                } else if (this.gracenoteEnabled) {
                    this.gracenoteService.disableOnlineLookup();
                } else {
                    this.gracenoteService.enableOnlineLookup();
                }
            }
        }
        this.getModel(n).fireEvent(n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onResetSettings(int n) {
        this.logger.log(1000000, "[%1.onResetSettings]", (Object)LOGCLASS);
        Object object = this.mutex;
        synchronized (object) {
            this.gracenoteEnabled = false;
            if (null != this.gracenoteService) {
                this.gracenoteService.disableOnlineLookup();
            } else {
                this.getChoiceModel(201046).setValue(0);
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
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

