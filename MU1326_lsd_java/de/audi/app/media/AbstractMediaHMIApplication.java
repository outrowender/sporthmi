/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.MediaCore;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractMediaHMIApplication
implements HMIApplication {
    private static final String LOGCLASS;
    protected final IFrameworkAccess framework;
    protected final MediaCore mediaCore;
    private ServiceRegistration registration;
    protected final LogChannel logger;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    public AbstractMediaHMIApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        this.framework = iFrameworkAccess;
        this.mediaCore = new MediaCore(iFrameworkAccess, bundleContext);
        this.logger = this.mediaCore.getLogger().main();
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init] ++++++++++++++++++ Init core ++++++++++++++++++", (Object)"AbstractMediaHMIApplication");
        this.mediaCore.init();
        this.logger.log(1078071040, "[%1.init] ++++++++++++++ Init core finished +++++++++++++", (Object)"AbstractMediaHMIApplication");
        Hashtable hashtable = new Hashtable(3);
        hashtable.put("moduleID", new Integer(2));
        hashtable.put("ApplicationName", "Media");
        this.registration = this.mediaCore.getServiceManager().registerService(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractMediaHMIApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication, this, hashtable);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"AbstractMediaHMIApplication");
        if (this.registration != null) {
            this.mediaCore.getServiceManager().unregisterService(this.registration);
        }
        this.mediaCore.deinit();
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        switch (n) {
            case 53: {
                return this.framework.getHmiServiceApp().getButtonModel(974193408);
            }
            case 1: {
                return this.framework.getHmiServiceApp().getButtonModel(2131690240);
            }
            case 52: {
                return this.framework.getHmiServiceApp().getButtonModel(990970624);
            }
            case 0: {
                return this.framework.getHmiServiceApp().getButtonModel(-2146499840);
            }
            case 13: {
                return this.framework.getHmiServiceApp().getButtonModel(2081358592);
            }
        }
        return null;
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void popupVisible(int n, int n2) {
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    @Override
    public void popupRemoved(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
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

