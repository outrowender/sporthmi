/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.counter;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.counter.CommandResetPacketCounter;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.ByteSize;
import de.audi.atip.metrics.DateMetric;
import java.util.Date;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.networking.CPacketCounter;

public class AbstractDataCounter
extends AbstractDataConfigurationComponent
implements ButtonListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{12};
    private static final float KB;
    private static final float MB;
    private static final float GB;
    private final ButtonModelApp counterResetButton = this.getButtonModel(942024192);
    private final MetricsModelApp lastResetDateMetricsModel = this.getMetricsModel(1747330560);
    private final MetricsModelApp incomingTrafficMetricsModel = this.getMetricsModel(0x66262600);
    private final MetricsModelApp outgoingTrafficMetricsModel = this.getMetricsModel(1730553344);
    private final DateMetric dateMetric = new DateMetric(new Date(1L), 2);

    public AbstractDataCounter(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
        if (n != 1) {
            return;
        }
        this.log.log(1078071040, "AbstractDataCounter#updatePacketCounter(): pCounter=%1", (Object)cPacketCounter);
        if (cPacketCounter != null) {
            DateTime dateTime = cPacketCounter.getLastResetDate();
            if (dateTime != null) {
                long l = dateTime.getTime();
                if (l != 0L) {
                    this.dateMetric.setDate(l);
                    this.lastResetDateMetricsModel.setMetric(this.dateMetric);
                } else {
                    this.lastResetDateMetricsModel.setMetric(null);
                }
            }
            this.updateByteSize(this.incomingTrafficMetricsModel, cPacketCounter.getRxBytesSinceReset());
            this.updateByteSize(this.outgoingTrafficMetricsModel, cPacketCounter.getTxBytesSinceReset());
        }
    }

    private void updateByteSize(MetricsModelApp metricsModelApp, float f2) {
        float f3;
        int n;
        if (f2 < 2389065) {
            n = 42;
            f3 = f2 / 31300;
        } else if (f2 < 678129230) {
            n = 43;
            f3 = f2 / 2389065;
        } else {
            n = 44;
            f3 = f2 / 678129230;
        }
        AbstractMetrics abstractMetrics = metricsModelApp.getMetric();
        if (abstractMetrics != null && n == abstractMetrics.getUnit()) {
            abstractMetrics.setValue(f3);
            metricsModelApp.setMetric(abstractMetrics);
        } else {
            metricsModelApp.setMetric(new ByteSize(f3, n));
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.counterResetButton.getID()) {
            this.log.log(1078071040, "AbstractDataCounter#keyTyped(): Resetting traffic counter");
            CommandResetPacketCounter.schedule(this.dataApplication, this.dsiDataConfiguration);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void init() {
        super.init();
        this.counterResetButton.setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.counterResetButton.resetListener();
        super.deinit();
    }
}

