/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.androidauto2;

import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.androidauto2.DSIAndroidAuto2Proxy;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class DSIAndroidAuto2DSIController
extends AbstractDSIController {
    private volatile DSIAndroidAuto2Proxy dsiProxy;
    private final DSIAndroidAuto2Listener listener;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener;

    public DSIAndroidAuto2DSIController(IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, LogChannel logChannel, DSIAndroidAuto2Listener dSIAndroidAuto2Listener, DSIAndroidAuto2Proxy dSIAndroidAuto2Proxy) {
        super(0, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        this.listener = dSIAndroidAuto2Listener;
        this.dsiProxy = dSIAndroidAuto2Proxy;
    }

    public void init() {
        this.startDSI();
    }

    public void deinit() {
        this.stopDSI();
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 = DSIAndroidAuto2DSIController.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2;
    }

    protected DSIListener getDSIListener() {
        return this.listener;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener = DSIAndroidAuto2DSIController.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener;
    }

    protected synchronized void addDSIService(DSIBase dSIBase) {
        this.dsiProxy.addDSIService((DSIAndroidAuto2)dSIBase);
    }

    protected synchronized void removeDSIService() {
        this.dsiProxy.removeDSIService();
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

