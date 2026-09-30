/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.evo;

import de.audi.app.ecall.core.AbstractEcallApplication;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IOPROpenClosePopupHandler;
import de.audi.app.ecall.core.ISOSOpenClosePopupHandler;
import de.audi.app.ecall.core.eni.ENIServiceEcallHandler;
import de.audi.app.ecall.evo.EvoAppContextListenersDistributor;
import de.audi.app.ecall.evo.OPROpenClosePopupHandler;
import de.audi.app.ecall.evo.SOSOpenClosePopupHandler;
import de.audi.app.ecall.license.LicensePopupStateManager;
import de.audi.app.ecall.proxy.EcallActionProxyImpl;
import de.audi.app.ecall.proxy.EvoOprAutomaticHkBackActionProxyListenerImpl;
import de.audi.app.ecall.proxy.SendTestModeSignalToEcall;
import de.audi.atip.base.IFrameworkAccess;
import org.osgi.framework.BundleContext;

public class EcallApplicationEvo
extends AbstractEcallApplication {
    private final EcallActionProxyImpl actionProxy;
    private final EvoAppContextListenersDistributor contextListenersDistributor;
    private final LicensePopupStateManager licensePopupStateManager = new LicensePopupStateManager();
    private final SOSOpenClosePopupHandler sosPopupHandler;
    private final OPROpenClosePopupHandler oprPopupHandler;

    public EcallApplicationEvo(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        super(iFrameworkAccess, "App.Ecall.Main", bundleContext);
        this.contextListenersDistributor = this.isPhoneModulePresent() ? new EvoAppContextListenersDistributor(this, 2, 3) : new EvoAppContextListenersDistributor(this, 4, 5);
        this.sosPopupHandler = new SOSOpenClosePopupHandler((IEcallApplication)this, this.licensePopupStateManager);
        this.oprPopupHandler = new OPROpenClosePopupHandler(this);
        this.contextListenersDistributor.registerContextStateListener(this.sosPopupHandler);
        this.contextListenersDistributor.registerContextStateListener(this.oprPopupHandler);
        this.actionProxy = new EcallActionProxyImpl(bundleContext, this.actionProxyDispatcher);
    }

    public void init() {
        super.init();
        this.actionProxy.init();
    }

    public void deinit() {
        super.deinit();
        this.actionProxy.deinit();
    }

    protected void addComponents() {
        this.addEcallComponent(this.contextListenersDistributor);
        this.addEcallComponent(this.sosPopupHandler);
        this.addEcallComponent(this.oprPopupHandler);
        this.addEcallComponent(new EvoOprAutomaticHkBackActionProxyListenerImpl(this));
        this.addEcallComponent(new SendTestModeSignalToEcall(this));
    }

    protected void addEcallComponentPost() {
        this.addEcallComponent(new ENIServiceEcallHandler(this, 3300001, this.licensePopupStateManager));
    }

    public ISOSOpenClosePopupHandler getSOSPopupHandler() {
        return this.sosPopupHandler;
    }

    public IOPROpenClosePopupHandler getOPRPopupHandler() {
        return this.oprPopupHandler;
    }
}

