/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.sdis.ISDISConnector;
import de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;

public class SDISConnector
implements ISDISConnector,
CarServiceTrackerListener {
    private final LogChannel logChannel;
    private final CarServiceTracker sdisCarStatusTracker;
    private ISDISCarInfoDistributor statusDataDistributor;
    private HashMap storedValues;
    static /* synthetic */ Class class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor;

    public SDISConnector(ICarApplication iCarApplication, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.sdisCarStatusTracker = new CarServiceTracker(this, iCarApplication.getBundleContext(), logChannel);
        this.storedValues = new HashMap();
    }

    @Override
    public void init() {
        this.getLogChannel().log(1078071040, "[SDISConnector#init]");
        this.sdisCarStatusTracker.startTracking();
    }

    @Override
    public void deinit() {
        this.getLogChannel().log(1078071040, "[SDISConnector#deinit]");
        this.sdisCarStatusTracker.stopTracking();
    }

    @Override
    public ISDISCarInfoDistributor getSDISCarInfoDistributor() {
        return this.statusDataDistributor;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.getLogChannel().log(1078071040, "[SDISConnector#serviceAvailable] CAR SDIS service found");
        if (object instanceof ISDISCarInfoDistributor) {
            this.statusDataDistributor = (ISDISCarInfoDistributor)object;
            this.statusDataDistributor.init(this.storedValues);
        }
    }

    @Override
    public void serviceRemoved() {
        this.getLogChannel().log(1000, "[SDISConnector#serviceRemoved] service to CAR SDIS lost");
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor == null ? (class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor = SDISConnector.class$("de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor")) : class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor).getName()};
    }

    private LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public void storeValue(int n, Object object) {
        Integer n2 = new Integer(n);
        if (!this.storedValues.containsKey(n2)) {
            this.storedValues.put(n2, object);
        }
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

