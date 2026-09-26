/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.online.OnlineDiag
 */
package de.audi.app.online;

import de.audi.app.online.AbstractOnlineEvoActivator;
import de.audi.app.online.evo.OnlineActionProxyStd;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.variant.IIDMapper;
import de.audi.tghu.online.app.AbstractOnlineActivator;
import de.audi.tghu.online.app.OnlineTextConstantsImpl;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IStandardController;
import de.audi.tghu.online.app.standard.OnlineEvoStandardController;
import de.mib.swdiagnosis.online.OnlineDiag;
import org.osgi.framework.BundleContext;

public class OnlineStandardActivator
extends AbstractOnlineEvoActivator {
    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logChannel.log(1078071040, "OnlineStandardActivator#start() - starting AppOnline Bundle ...");
        this.finalizeStart();
    }

    @Override
    protected final void registerServicesVariant() {
    }

    @Override
    protected RemoteHMIService createRemoteHMIService() {
        return null;
    }

    @Override
    protected final IIDMapper createTextConstants() {
        return new OnlineTextConstantsImpl();
    }

    @Override
    protected IIDMapper createSmEventConstantsMapper() {
        return null;
    }

    @Override
    public int getDrawerCategory() {
        return -1;
    }

    @Override
    protected OnlineActionProxy createOnlineActionProxy() {
        return new OnlineActionProxyStd(this.logChannel, this.framework.getHMIService());
    }

    @Override
    protected OnlineDiag createOnlineDiag() {
        return new OnlineDiag(this.framework, (AbstractOnlineActivator)this);
    }

    @Override
    protected IStandardController createStandardController(HMIService hMIService) {
        return new OnlineEvoStandardController(this.logChannel, hMIService, this.getShutdownPopupId(), this.getTextConstantsConverter(), this.getFramework());
    }

    @Override
    protected void initOSRApplicationVariant() {
    }
}

