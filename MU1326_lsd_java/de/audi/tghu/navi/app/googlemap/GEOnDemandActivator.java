/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.googlemap;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.map.context.State;
import org.osgi.framework.BundleContext;

public class GEOnDemandActivator
extends AbstractActivator {
    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        LogChannel logChannel = this.getFramework().getLogChannel("App.Navi.GEOnDemand");
        try {
            IStorageAccess iStorageAccess = this.getFramework().getStorageMgr();
            logChannel.log(-1601830656, "GEOnDemandActivator: check if GoogleEarth Map is active");
            if (iStorageAccess != null) {
                boolean bl;
                State state = new State(iStorageAccess, logChannel, this.getFramework(), 900);
                state.readAndDeserialize();
                boolean bl2 = bl = this.framework.getSysConst(479) == 1;
                if (bl && state.getData().getMapRepresentation() == 1) {
                    logChannel.log(1078071040, "GEOnDemandActivator: request start of Google Earth now.");
                    try {
                        this.getFramework().getStartupMgr().requestAppStart(14);
                    }
                    catch (Exception exception) {
                        logChannel.log(10000, "GEOnDemandActivator: start Google Earth failed!", (Throwable)exception);
                    }
                } else {
                    logChannel.log(1078071040, "GEOnDemandActivator: Google Earth map not active, do nothing");
                }
            } else {
                logChannel.log(-1601830656, "GEOnDemandActivator: could not load persistent data, do nothing");
            }
        }
        catch (Exception exception) {
            logChannel.log(-1601830656, "GEOnDemandActivator: failed to start", (Throwable)exception);
        }
    }
}

