/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.LGIDataDispatcher$1;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;

public class LGIDataDispatcher {
    private final IFrameworkAccess fw;
    private final LogChannel logChannel;
    private final DSICarComfort dsiCarComfort;
    private static final String LGI_CAR_DISPATCHER;
    private final DispatcherBase dispatcher;
    private static final long LGI_UPDATE_DELAY;

    public LGIDataDispatcher(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, DSICarComfort dSICarComfort) {
        this.fw = iFrameworkAccess;
        this.logChannel = logChannel;
        this.dsiCarComfort = dSICarComfort;
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("LGICarDispatcher", new JobLogger(logChannel));
        this.dispatcher.start();
    }

    public void cleanUp() {
        this.logChannel.log(1078071040, "LGIDataDispatcher#cleanUp()");
        this.dispatcher.stop();
        this.fw.getDispatcherManager().destroyDispatcher("LGICarDispatcher");
    }

    public void updateRGSLocalHazardInformation(RGSLocalHazardInformation[] rGSLocalHazardInformationArray) {
        this.clearQueuedUpdates();
        for (int i2 = 0; i2 < rGSLocalHazardInformationArray.length; ++i2) {
            this.setRGSLocalHazardInformation(rGSLocalHazardInformationArray[i2]);
        }
    }

    private void clearQueuedUpdates() {
        this.dispatcher.suspend();
        int n = this.dispatcher.getQueue().length();
        if (0 < n) {
            this.logChannel.log(-1601830656, "LGIDataDispatcher#clearQueuedUpdates() - Deleted %1 remaining update(s) from dispatcher queue!", (long)n);
            this.dispatcher.getQueue().clear();
        }
        this.dispatcher.resume();
    }

    private void setRGSLocalHazardInformation(RGSLocalHazardInformation rGSLocalHazardInformation) {
        if (null == rGSLocalHazardInformation) {
            return;
        }
        try {
            this.dispatcher.execute(new LGIDataDispatcher$1(this, rGSLocalHazardInformation));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "LGIDataDispatcher#setRGSLocalHazardInformation() - %1", (Throwable)exception);
        }
    }

    static /* synthetic */ LogChannel access$000(LGIDataDispatcher lGIDataDispatcher) {
        return lGIDataDispatcher.logChannel;
    }

    static /* synthetic */ DSICarComfort access$100(LGIDataDispatcher lGIDataDispatcher) {
        return lGIDataDispatcher.dsiCarComfort;
    }
}

