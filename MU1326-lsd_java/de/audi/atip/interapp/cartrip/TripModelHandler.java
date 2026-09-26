/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.cartrip;

import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.interapp.cartrip.ITripDataProvider;
import de.audi.atip.interapp.cartrip.ITripListener;
import de.audi.atip.metrics.AbstractMetrics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TripModelHandler {
    private ITripDataProvider dataProvider;
    private Map model2DataType;
    private ITripListener listener;

    public TripModelHandler(ITripDataProvider iTripDataProvider) {
        this.dataProvider = iTripDataProvider;
        this.model2DataType = new HashMap(4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerTripDataModel(int n, MetricsModelApp metricsModelApp) {
        Map map = this.model2DataType;
        synchronized (map) {
            this.model2DataType.put(metricsModelApp, new Integer(n));
        }
        metricsModelApp.setMetric(this.dataProvider.getTripDataValue(n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deregisterTripDataModel(MetricsModelApp metricsModelApp) {
        if (metricsModelApp != null) {
            metricsModelApp.setMetric(null);
            Map map = this.model2DataType;
            synchronized (map) {
                this.model2DataType.remove(metricsModelApp);
            }
        }
    }

    public void registerListener(ITripListener iTripListener) {
        this.listener = iTripListener;
    }

    public void resetListener() {
        this.listener = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMetricsModel(int n) {
        Map map = this.model2DataType;
        synchronized (map) {
            Iterator iterator = this.model2DataType.keySet().iterator();
            while (iterator.hasNext()) {
                MetricsModelApp metricsModelApp = (MetricsModelApp)iterator.next();
                int n2 = (Integer)this.model2DataType.get(metricsModelApp);
                if (n2 != n) continue;
                AbstractMetrics abstractMetrics = this.dataProvider.getTripDataValue(n);
                metricsModelApp.setMetric(abstractMetrics);
            }
        }
        if (this.listener != null) {
            this.listener.updateMetrics(n, this.dataProvider.getTripDataValue(n));
        }
    }
}

