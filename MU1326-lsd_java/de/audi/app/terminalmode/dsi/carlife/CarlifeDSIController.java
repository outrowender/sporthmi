/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carlife;

import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.carlife.DSICarlifeProxy;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.DSICarlifeListener;

public class CarlifeDSIController
extends AbstractDSIController {
    private volatile DSICarlifeProxy dsiProxy;
    private final DSICarlifeListener listener;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlife;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlifeListener;

    public CarlifeDSIController(IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, LogChannel logChannel, DSICarlifeListener dSICarlifeListener, DSICarlifeProxy dSICarlifeProxy) {
        super(0, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        this.listener = dSICarlifeListener;
        this.dsiProxy = dSICarlifeProxy;
    }

    @Override
    public void init() {
        this.startDSI();
    }

    @Override
    public void deinit() {
        this.stopDSI();
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$carlife$DSICarlife == null ? (class$org$dsi$ifc$carlife$DSICarlife = CarlifeDSIController.class$("org.dsi.ifc.carlife.DSICarlife")) : class$org$dsi$ifc$carlife$DSICarlife;
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.listener;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$carlife$DSICarlifeListener == null ? (class$org$dsi$ifc$carlife$DSICarlifeListener = CarlifeDSIController.class$("org.dsi.ifc.carlife.DSICarlifeListener")) : class$org$dsi$ifc$carlife$DSICarlifeListener;
    }

    @Override
    protected void addDSIService(DSIBase dSIBase) {
        this.dsiProxy.addDSIService((DSICarlife)dSIBase);
    }

    @Override
    protected void removeDSIService() {
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

