/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.connectivity.core;

import de.audi.app.connectivity.core.IConnectivity;
import de.audi.app.connectivity.core.common.ClampStateHandler;
import de.audi.app.connectivity.core.common.IClampStateProvider;
import de.audi.app.connectivity.core.common.PhoneProxy;
import de.audi.atip.activator.AbstractActivator;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AbstractConnectivityActivator
extends AbstractActivator
implements IConnectivity {
    private ServiceRegistration serviceRegistration;
    private ConnectivityDiag diag;
    private PhoneProxy phone;
    private ClampStateHandler clampStateHandler;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.clampStateHandler = new ClampStateHandler(this.framework.getLogChannel("App.Connectivity.Main"), this.framework.getHmiServiceApp().getChoiceModel(-2044320256));
        this.serviceRegistration = this.bundleContext.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractConnectivityActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.clampStateHandler, null);
        this.diag = new ConnectivityDiag(bundleContext);
        this.diag.init();
        this.phone = new PhoneProxy(bundleContext, this.framework.getLogChannel("App.Connectivity.Main"));
        this.phone.init();
    }

    @Override
    public IClampStateProvider getClampStateProvider() {
        return this.clampStateHandler;
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.serviceRegistration != null) {
            this.serviceRegistration.unregister();
            this.serviceRegistration = null;
        }
        if (this.diag != null) {
            this.diag.deinit();
            this.diag = null;
        }
        if (this.phone != null) {
            this.phone.deinit();
            this.phone = null;
        }
        super.stop(bundleContext);
    }

    @Override
    public ConnectivityDiag getDiagnosis() {
        return this.diag;
    }

    @Override
    public PhoneProxy getPhone() {
        return this.phone;
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

