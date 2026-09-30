/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.esolutions.fw.util.commons.Buffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface NaviOnlineService {
    public static final int STOPOVER_INDEX_NEXT_STOPOVER = -1;
    public static final int STOPOVER_INDEX_BEFORE_DESTINATION = -2;
    public static final int STOPOVER_INDEX_DEFAULT = -1;

    public void callRRDForListType(int var1);

    public void setPOIViewportData(POIOnlineData[] var1, int var2, NavLocationWgs84 var3, ChoiceModelApp var4);

    public void setMapOverlays(int var1, NaviOnlineMapOverlay[] var2, int var3, ChoiceModelApp var4);

    public int getPOIIndexFromUserFlags();

    public void prepareAddressForm();

    public String getDataCountryAbbreviation();

    public String getDataDayNightView();

    public double[] getDataDestination();

    public String getDataFallBackLanguage();

    public int getDataScreenWidth();

    public int getDataScreenHeight();

    public double[] getDataVehicleLocation();

    public String getDataVIN();

    public void setListener(NaviOnlineServiceListener var1);

    public NaviOnlineServiceListener getListener();

    public void setSearchAreaListener(NaviOnlineSearchAreaListener var1);

    public NaviOnlineSearchAreaListener getSearchAreaListener();

    public boolean getIsNaviFullyOperable();

    public void sendRemoteHMIAppsUpdateToNaviAndMap(List var1);

    public void sendMiniAppsDownloadError();

    public void setRRDListener(RRDListener var1);

    public RRDListener getRRDListener();

    public void updateRRDDistances(RrdCalculationInfo[] var1);

    public int[] getRequestedLatitudes();

    public int[] getRequestedLongitudes();

    public void triggerRRDRequest(ArrayList var1);

    public void updateDirectionAndAirDistance(int[] var1, int[] var2);

    public void exitRRD();

    public void startRouteGuidance(NavLocationWgs84 var1, String var2, ChoiceModelApp var3, String var4);

    public void insertAsStopover(NavLocationWgs84 var1, String var2, ChoiceModelApp var3, int var4, boolean var5);

    public void triggerADRequest(ArrayList var1);

    public void exitAD();

    public void swapModel(Object var1, Object var2, Object var3, int var4, int var5);

    public void setMapStateService(MapStateService var1);

    public MapStateService getMapStateService();

    public static class RrdData {
        private String id;
        private String rrdDistance;
        private String airDistance;
        private String roadTripTime;
        private Integer airDirection;
        private Integer latitude;
        private Integer longitude;
        private Integer rrdReferenceLatitude;
        private Integer rrdReferenceLongitude;
        private int idRangeStart = 0;
        private WeakReference modelContainer;
        private WeakReference model;

        public void setIdRangeStart(int n) {
            this.idRangeStart = n;
        }

        public int getIdRangeStart() {
            return this.idRangeStart;
        }

        public void setModelAndContainer(Object object, Object object2) {
            this.setModelContainer(object);
            this.setModel(object2);
        }

        public Object getModelContainer() {
            return this.modelContainer == null ? null : this.modelContainer.get();
        }

        public void setModelContainer(Object object) {
            this.modelContainer = new WeakReference(object);
        }

        public Object getModel() {
            return this.model == null ? null : this.model.get();
        }

        public void setModel(Object object) {
            this.model = new WeakReference(object);
        }

        public String getId() {
            return this.id;
        }

        public void setId(String string) {
            this.id = string;
        }

        public String getRrdDistance() {
            return this.rrdDistance;
        }

        public void setRrdDistance(String string) {
            this.rrdDistance = string;
        }

        public String getAirDistance() {
            return this.airDistance;
        }

        public void setAirDistance(String string) {
            this.airDistance = string;
        }

        public Integer getAirDirection() {
            return this.airDirection;
        }

        public void setAirDirection(Integer n) {
            this.airDirection = n;
        }

        public Integer getLatitude() {
            return this.latitude;
        }

        public void setLatitude(Integer n) {
            this.latitude = n;
        }

        public Integer getLongitude() {
            return this.longitude;
        }

        public void setLongitude(Integer n) {
            this.longitude = n;
        }

        public Integer getRrdReferenceLatitude() {
            return this.rrdReferenceLatitude;
        }

        public void setRrdReferenceLatitude(Integer n) {
            this.rrdReferenceLatitude = n;
        }

        public Integer getRrdReferenceLongitude() {
            return this.rrdReferenceLongitude;
        }

        public void setRrdReferenceLongitude(Integer n) {
            this.rrdReferenceLongitude = n;
        }

        public String getRoadTripTime() {
            return this.roadTripTime;
        }

        public void setRoadTripTime(String string) {
            this.roadTripTime = string;
        }
    }

    public static interface RRDListener {
        public void updateRrdItems(List var1);
    }

    public static class POIOnlineData {
        public int latitude;
        public int longitude;
        public String line0;
        public String line1;
        public String poiName;
        public String phoneNumber;
        public String street;
        public String country;
        public String housenumber;
        public String city;
        public String zipCode;

        public String toString() {
            Buffer buffer = new Buffer(100);
            buffer.append("POIOnlineData [latitude=").append(this.latitude);
            buffer.append(", longitude=").append(this.longitude);
            buffer.append(", line0=").append(this.line0).append(", line1=").append(this.line1);
            buffer.append(", poiName=").append(this.poiName);
            buffer.append(", phoneNumber=").append(this.phoneNumber);
            buffer.append(", street=").append(this.street);
            buffer.append(", country=").append(this.country);
            buffer.append(", housenumber=").append(this.housenumber);
            buffer.append(", city=").append(this.city);
            buffer.append(", zipCode=").append(this.zipCode);
            return buffer.toString();
        }
    }

    public static interface MapStateService {
        public void onDayNightViewChanged(boolean var1);
    }

    public static class NaviOnlineMapOverlay {
        public String path;
        public NavRectangle rectangle;
        public String description;
    }

    public static interface NaviOnlineServiceListener {
        public void indicateSelectedMapFlag(int var1);

        public void indicateRouteGuidanceFinished(NavLocation var1, String var2);
    }

    public static interface NaviOnlineSearchAreaListener {
        public void updateSearchLocation(IMyLocationAccessor var1);
    }
}

