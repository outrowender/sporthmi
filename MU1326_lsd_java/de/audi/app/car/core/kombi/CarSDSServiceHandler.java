/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.core.kombi.CarSDSServiceHandler$1;
import de.audi.atip.interapp.car.CarSDSService;
import de.audi.atip.interapp.car.ICarRemainingRangeListener;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;

public class CarSDSServiceHandler
implements CarSDSService {
    private final CarServiceProvider serviceProvider;
    private final Object mutex = new Object();
    private final ICarApplication application;
    private final LogChannel logChannel;
    private volatile int vo = 1;
    private volatile boolean valid = false;
    private volatile int value = 0;
    private volatile int unit = 0;
    private final ArrayList listeners = new ArrayList(1);
    static /* synthetic */ Class class$de$audi$atip$interapp$car$CarSDSService;

    public CarSDSServiceHandler(ICarApplication iCarApplication, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
        this.serviceProvider = new CarServiceProvider((class$de$audi$atip$interapp$car$CarSDSService == null ? (class$de$audi$atip$interapp$car$CarSDSService = CarSDSServiceHandler.class$("de.audi.atip.interapp.car.CarSDSService")) : class$de$audi$atip$interapp$car$CarSDSService).getName(), this, null, iCarApplication.getBundleContext(), logChannel);
    }

    protected void init() {
        this.serviceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void deinit() {
        this.serviceProvider.stopService();
        Object object = this.mutex;
        synchronized (object) {
            this.listeners.clear();
        }
    }

    protected void updateRemainingRangeViewOption(int n) {
        this.logChannel.log(1078071040, "[CarSDSServiceHandler#updateRemainingRangeViewOption] vo='%1'", (long)n);
        this.vo = n;
        this.updateRemainingRange(this.valid, this.value, this.unit);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateRemainingRange(boolean bl, int n, int n2) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CarSDSServiceHandler#updateRemainingRange] valid='%1', value='%2', unit='%3'", (Object)Boolean.toString(bl), (long)n, (long)n2);
        }
        Object object = this.mutex;
        synchronized (object) {
            this.valid = bl;
            this.value = n;
            this.unit = n2;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ICarRemainingRangeListener iCarRemainingRangeListener = (ICarRemainingRangeListener)this.listeners.get(i2);
                try {
                    iCarRemainingRangeListener.updateRemainingRange(this.calculateRemainingRangeState(this.vo, this.valid), this.value, this.unit);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[CarSDSServiceHandler#updateRemainingRange] exception occured within the listener", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addRemainingRangeListener(ICarRemainingRangeListener iCarRemainingRangeListener) {
        this.logChannel.log(1078071040, "[CarSDSServiceHandler#addRemaningRangeListener]");
        Object object = this.mutex;
        synchronized (object) {
            if (!this.listeners.contains(iCarRemainingRangeListener)) {
                this.listeners.add(iCarRemainingRangeListener);
                this.application.getJobDispatcher().execute(new CarSDSServiceHandler$1(this, iCarRemainingRangeListener));
            } else {
                this.logChannel.log(-1601830656, "[CarSDSServiceHandler#addRemaningRangeListener] listener already registered");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeRemainingRangeListener(ICarRemainingRangeListener iCarRemainingRangeListener) {
        this.logChannel.log(1078071040, "[CarSDSServiceHandler#removeRemaningRangeListener]");
        Object object = this.mutex;
        synchronized (object) {
            this.listeners.remove(iCarRemainingRangeListener);
        }
    }

    private int calculateRemainingRangeState(int n, boolean bl) {
        switch (n) {
            case 1: {
                return 0;
            }
            case 0: {
                return bl ? 2 : 1;
            }
        }
        return 1;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ Object access$000(CarSDSServiceHandler carSDSServiceHandler) {
        return carSDSServiceHandler.mutex;
    }

    static /* synthetic */ int access$100(CarSDSServiceHandler carSDSServiceHandler) {
        return carSDSServiceHandler.vo;
    }

    static /* synthetic */ boolean access$200(CarSDSServiceHandler carSDSServiceHandler) {
        return carSDSServiceHandler.valid;
    }

    static /* synthetic */ int access$300(CarSDSServiceHandler carSDSServiceHandler, int n, boolean bl) {
        return carSDSServiceHandler.calculateRemainingRangeState(n, bl);
    }

    static /* synthetic */ int access$400(CarSDSServiceHandler carSDSServiceHandler) {
        return carSDSServiceHandler.value;
    }

    static /* synthetic */ int access$500(CarSDSServiceHandler carSDSServiceHandler) {
        return carSDSServiceHandler.unit;
    }

    static /* synthetic */ LogChannel access$600(CarSDSServiceHandler carSDSServiceHandler) {
        return carSDSServiceHandler.logChannel;
    }
}

