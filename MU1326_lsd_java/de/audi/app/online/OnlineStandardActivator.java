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
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logChannel.log(1000000, "OnlineStandardActivator#start() - starting AppOnline Bundle ...");
        this.finalizeStart();
    }

    protected final void registerServicesVariant() {
    }

    protected RemoteHMIService createRemoteHMIService() {
        return null;
    }

    protected final IIDMapper createTextConstants() {
        return new OnlineTextConstantsImpl();
    }

    protected IIDMapper createSmEventConstantsMapper() {
        return null;
    }

    public int getDrawerCategory() {
        return -1;
    }

    protected OnlineActionProxy createOnlineActionProxy() {
        return new OnlineActionProxyStd(this.logChannel, this.framework.getHMIService());
    }

    protected OnlineDiag createOnlineDiag() {
        return new OnlineDiag(this.framework, (AbstractOnlineActivator)this);
    }

    protected IStandardController createStandardController(HMIService hMIService) {
        return new OnlineEvoStandardController(this.logChannel, hMIService, this.getShutdownPopupId(), this.getTextConstantsConverter(), this.getFramework());
    }

    protected void initOSRApplicationVariant() {
    }
}

