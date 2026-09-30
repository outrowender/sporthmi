/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.car;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.osgi.EcallServiceProvider;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.navcar.CarNavListener;
import de.audi.atip.metrics.GeoMetric;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;
import java.util.Hashtable;

public class BreakdownCallCarPositionHandler
extends AbstractEcallComponent
implements CarNavListener {
    private final EcallServiceProvider carNavListenerProvider;
    private volatile GeoPair currentGeoPair;
    private final Object geoMutex = new Object();
    private final boolean isGPSShowingAllowed;
    static /* synthetic */ Class class$de$audi$atip$interapp$navcar$CarNavListener;

    public BreakdownCallCarPositionHandler(IEcallApplication iEcallApplication, boolean bl) {
        super(iEcallApplication, "App.Ecall.Main");
        this.isGPSShowingAllowed = bl;
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$navcar$CarNavListener == null ? (class$de$audi$atip$interapp$navcar$CarNavListener = BreakdownCallCarPositionHandler.class$("de.audi.atip.interapp.navcar.CarNavListener")) : class$de$audi$atip$interapp$navcar$CarNavListener).getName());
        this.carNavListenerProvider = new EcallServiceProvider((class$de$audi$atip$interapp$navcar$CarNavListener == null ? (class$de$audi$atip$interapp$navcar$CarNavListener = BreakdownCallCarPositionHandler.class$("de.audi.atip.interapp.navcar.CarNavListener")) : class$de$audi$atip$interapp$navcar$CarNavListener).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.getApplication().addDiagnosisComponent(new EcallCurrentPositionDiagnosisComponent());
    }

    public void init() {
        this.carNavListenerProvider.startService();
    }

    public void deinit() {
        this.carNavListenerProvider.stopService();
    }

    public void updateVehicleHeading(int n, int n2, boolean bl) {
    }

    public void updateVehicleHeight(int n, boolean bl) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateVehiclePosition(int n, int n2, boolean bl) {
        if (!this.isGPSShowingAllowed) {
            this.log.log(1000000, "BreakdownCallCarPositionHandler#updateVehiclePosition(): GPS is not allowed NOP");
            return;
        }
        this.log.log(10000000, "BreakdownCallCarPositionHandler#updateVehiclePosition(): latitude=%1, lognitude=%2, isValid=%3", (long)n, (long)n2, bl);
        Object object = this.geoMutex;
        synchronized (object) {
            if (bl) {
                this.currentGeoPair = new GeoPair(n, n2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateVehiclePositionDescription(String string, String string2, String string3, String string4, String string5, boolean bl) {
        this.log.log(10000000, "BreakdownCallCarPositionHandler#updateVehiclePositionDescription(): city=%1, street=%2, isValid=%3", (Object)string2, (Object)string4, (Object)String.valueOf(bl));
        Object object = this.geoMutex;
        synchronized (object) {
            String string6 = this.getFormatedGeoCoding(string2, string4, bl);
            this.getCurrentPositionLabelModel().setText(string6);
        }
    }

    private String getFormatedGeoCoding(String string, String string2, boolean bl) {
        String string3 = bl && EcallUtil.isStringNotNullOrEmpty(string) && EcallUtil.isStringNotNullOrEmpty(string2) ? new Buffer(string2).append(", ").append(string).toString() : (this.currentGeoPair == null ? "" : this.formatToMinuteOfArc(new GeoMetric(this.currentGeoPair.lat, this.currentGeoPair.lng)));
        return string3;
    }

    private LabelModelApp getCurrentPositionLabelModel() {
        return this.getLabelModel(3300005);
    }

    private String formatToMinuteOfArc(GeoMetric geoMetric) {
        Buffer buffer = new Buffer();
        buffer.append(geoMetric.formatLatitude()).append(" ").append(geoMetric.formatLongitude());
        return buffer.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private static class GeoPair {
        public final int lat;
        public final int lng;

        public GeoPair(int n, int n2) {
            this.lat = n;
            this.lng = n2;
        }

        public String toString() {
            return new Buffer("GeoPair [lat=").append(this.lat).append(", lng=").append(this.lng).append("]").toString();
        }
    }

    private class EcallCurrentPositionDiagnosisComponent
    implements IEcallDiagnosisComponent {
        private EcallCurrentPositionDiagnosisComponent() {
        }

        public void cmdUpdateGeoPosition(int n, int n2) {
            BreakdownCallCarPositionHandler.this.updateVehiclePosition(n, n2, true);
        }

        public void cmdSetStreetAndCityForCurrentPosition(String string, String string2) {
            BreakdownCallCarPositionHandler.this.updateVehiclePositionDescription(null, string2, null, string, null, true);
        }

        public void cmdSetCurrentPositionStr(String string) {
            BreakdownCallCarPositionHandler.this.getCurrentPositionLabelModel().setText(string);
        }
    }
}

