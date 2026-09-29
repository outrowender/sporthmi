/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class OPSTrackHoseUpdater
implements TimerListener {
    private static long minTimeBetweenUpdates = 0;
    private final BaseListModelApp trackHoseModel;
    private final Timer updateTimer;
    private long lastUpdateTime;
    private final LogChannel logChannel;
    private static final Object mutex = new Object();
    private EvoListRow updatedRow;

    protected OPSTrackHoseUpdater(BaseListModelApp baseListModelApp, LogChannel logChannel) {
        this.trackHoseModel = baseListModelApp;
        this.logChannel = logChannel;
        minTimeBetweenUpdates = Long.parseLong(System.getProperty("CarParkingHoseMinTimeBetweenUpdates", "300"));
        this.updateTimer = new Timer("OPSTrackHoseUpdater", minTimeBetweenUpdates, true, this);
        this.logChannel.log(1078071040, "OPSTrackHoseUpdater constructor MIN_TIME_BETWEEN_UPDATES: %1", minTimeBetweenUpdates);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void update(EvoListRow evoListRow) {
        Object object = mutex;
        synchronized (object) {
            this.updatedRow = evoListRow;
            long l = System.currentTimeMillis();
            if (l - this.lastUpdateTime >= minTimeBetweenUpdates) {
                this.updateTrackHoseModel(l);
            } else {
                this.updateTimer.setDelay(this.lastUpdateTime + minTimeBetweenUpdates - l);
                this.updateTimer.restart();
                if (this.logChannel.isInfo()) {
                    this.logChannel.log(1078071040, "[updateSteeringInformation: OPSTrackHoseUpdater#update] update deferred: model='%1' , row='%2'", (Object)this.trackHoseModel, (Object)this.updatedRow);
                }
            }
        }
    }

    private void updateTrackHoseModel(long l) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[updateSteeringInformation: OPSTrackHoseUpdater#updateTrackHoseModel] BaseListModel.setRow() : model='%1' , row='%2'", (Object)this.trackHoseModel, (Object)this.updatedRow);
        }
        this.trackHoseModel.setRow(this.trackHoseModel.getIndexForUniqueID(this.updatedRow.getUniqueID()), this.updatedRow);
        this.lastUpdateTime = l;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = mutex;
        synchronized (object) {
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[OPSTrackHoseUpdater#fireTimer]");
            }
            this.updateTrackHoseModel(System.currentTimeMillis());
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

