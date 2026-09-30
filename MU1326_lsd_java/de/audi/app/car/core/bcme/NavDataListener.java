/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.interapp.navcar.CarNavListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.CompassMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.GeoMetric;

public class NavDataListener
implements CarNavListener {
    private MetricsModelApp compass;
    private MetricsModelApp altitude;
    private MetricsModelApp gpsCoordinates;
    private final LogChannel logChannel;
    private static final int[] HEADING_TO_COMPASS_METRIC_ORIENTATION_MAPPING = new int[]{1, 9, 5, 13, 3, 15, 7, 11};

    public NavDataListener(MetricsModelApp metricsModelApp, MetricsModelApp metricsModelApp2, MetricsModelApp metricsModelApp3, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.compass = metricsModelApp;
        this.altitude = metricsModelApp2;
        this.gpsCoordinates = metricsModelApp3;
    }

    public void updateVehicleHeading(int n, int n2, boolean bl) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[NavDataListener#updateVehicleHeading] heading='%1', angle='%2', isValid='%3'", (Object)new Integer(n), (Object)new Integer(n2), (Object)bl);
        }
        if (bl) {
            this.compass.setMetric(this.createCompassMetric(n2, n));
            this.compass.formatChanged();
        }
    }

    public void updateVehicleHeight(int n, boolean bl) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[NavDataListener#updateVehicleHeight] height='%1', isValid='%2'", (Object)new Integer(n), (Object)bl);
        }
        if (bl) {
            Distance distance = new Distance(n, 5, 2);
            distance.setUseInstanceUnit(false);
            this.altitude.setMetric(distance);
            this.altitude.formatChanged();
        }
    }

    public void updateVehiclePosition(int n, int n2, boolean bl) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[NavDataListener#updateVehiclePosition] latitude='%1', longitude='%2' , isValid='%3'", (Object)new Integer(n), (Object)new Integer(n2), (Object)bl);
        }
        if (bl) {
            GeoMetric geoMetric = new GeoMetric(n, n2);
            geoMetric.setUseInstanceUnit(false);
            this.gpsCoordinates.setMetric(geoMetric);
            this.gpsCoordinates.formatChanged();
        }
    }

    public void updateVehiclePositionDescription(String string, String string2, String string3, String string4, String string5, boolean bl) {
    }

    private CompassMetric createCompassMetric(int n, int n2) {
        int n3 = this.mapHeadingToCompassMetricOrientation(n2);
        CompassMetric compassMetric = null;
        compassMetric = n3 == -1 ? new CompassMetric(0.0f, 1) : new CompassMetric(n, n3);
        compassMetric.setUseInstanceUnit(false);
        return compassMetric;
    }

    private int mapHeadingToCompassMetricOrientation(int n) {
        if (n >= 0 && n < HEADING_TO_COMPASS_METRIC_ORIENTATION_MAPPING.length) {
            return HEADING_TO_COMPASS_METRIC_ORIENTATION_MAPPING[n];
        }
        this.logChannel.log(100000, "[NavDataListener#mapHeadingToCompassMetricOrientation] received invalid heading value from Navi App: '%1'", (long)n);
        return -1;
    }
}

