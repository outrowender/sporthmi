/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviMsgDetails;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.metrics.DateMetric;
import java.util.Date;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class NaviGateway
extends AbstractMessagingComponent {
    private volatile NaviService naviService;
    private final ChoiceModelApp rgActive;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;

    public NaviGateway(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.rgActive = messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(2200487);
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$NaviServiceListener == null ? (class$de$audi$atip$interapp$NaviServiceListener = NaviGateway.class$("de.audi.atip.interapp.NaviServiceListener")) : class$de$audi$atip$interapp$NaviServiceListener).getName(), (Object)new NaviDefaultListener(), ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[NaviGateway#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = NaviGateway.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName());
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                if (object instanceof NaviService) {
                    NaviGateway.this.setNaviService((NaviService)object);
                }
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                if (object instanceof NaviService) {
                    NaviGateway.this.setNaviService(null);
                }
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    protected void setNaviService(NaviService naviService) {
        this.naviService = naviService;
    }

    public DateMetric getEta() {
        DateMetric dateMetric = null;
        if (this.naviService != null) {
            NaviMsgDetails naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
            dateMetric = new DateMetric(new Date(naviMsgDetails.eta), 1);
        }
        this.log.log(10000000, "[NaviGateway#getEta] ETA = %1", dateMetric);
        return dateMetric;
    }

    public DateMetric getDuration() {
        DateMetric dateMetric = null;
        if (this.naviService != null) {
            NaviMsgDetails naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
            Date date = new Date(naviMsgDetails.eta - this.framework.getKombiTime());
            dateMetric = new DateMetric(date, 5);
        }
        this.log.log(10000000, "[NaviGateway#getDuration] Duration = %1", dateMetric);
        return dateMetric;
    }

    public String getFormattedDestination() {
        String string = null;
        if (this.naviService != null) {
            NaviMsgDetails naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
            string = naviMsgDetails.formattedDestination;
        }
        this.log.log(10000000, "[NaviGateway#getDestination] Destination = %1", string);
        return string;
    }

    public String getFormattedCurrentPosition() {
        String string = null;
        if (this.naviService != null) {
            NaviMsgDetails naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
            string = naviMsgDetails.formattedCurrentPosition;
        }
        this.log.log(10000000, "[NaviGateway#getCurrentPosition] Current position = %1", string);
        return string;
    }

    public NaviMsgDetails getNaviDetails() {
        NaviMsgDetails naviMsgDetails = null;
        if (this.naviService != null) {
            naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
        }
        this.log.log(10000000, "[NaviGateway#getNaviDetails");
        return naviMsgDetails;
    }

    public void toggleRouteGuidance(boolean bl) {
        this.rgActive.setValue(bl ? 1 : 0);
        this.log.log(1000000, "[NaviGateway#toggleRouteGuidance] Route guidance active = %1", bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class NaviDefaultListener
    implements NaviServiceListener {
        private NaviDefaultListener() {
        }

        public void updateFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
        }

        public void updateLastDestinations(SDSListEntry[] sDSListEntryArray) {
        }

        public void updateDestinationCountryCode(String string, String string2) {
        }

        public void updateDestinationStateCode(String string, String string2) {
        }

        public void updateFullyOperableStateChanged(boolean bl) {
        }

        public void responseSetLocation(byte by) {
        }

        public void responseSetOneShotData(byte by) {
        }

        public void responseSetLocationPart(byte by) {
        }

        public void responseQueryLocationPartListLength(byte by, long l, String[] stringArray) {
        }

        public void responseQuerySpelledLocationPartResultList(byte by, String[] stringArray, Object[] objectArray) {
        }

        public void responseSetSpelledLocationPart(byte by) {
        }

        public void responseValidateSpelledStreetName(byte by) {
        }

        public void responseStartDestinationInput(byte by) {
        }

        public void responseTriggerAddressInputReturn(byte by) {
        }

        public void responseStartPoiSearchByName(byte by) {
        }

        public void responseFinishDestinationInput(byte by, byte by2) {
        }

        public void responsePrepareRouteGuidance(byte by, byte by2) {
        }

        public void responseCheckRouteGuidance(byte by) {
        }

        public void responseSetRouteOptionCalcType(byte by) {
        }

        public void responseSetDestination(byte by) {
        }

        public void responseSetRouteOptionDynamic(byte by) {
        }

        public void responseTriggerRouteGuidance(byte by) {
        }

        public void responseReduceRouteToFinalDestination(byte by) {
        }

        public void responseBlockRoute(byte by) {
        }

        public void responseUnblockRoute(byte by) {
        }

        public void responsePostCodeFormat(byte by, boolean bl) {
        }

        public void responseSelectPOI(byte by, NaviService.POISDSListEntry[] pOISDSListEntryArray) {
        }

        public void responseSelectPOIbyListIndex(byte by) {
        }

        public void responseSelectTopPOI(byte by) {
        }

        public void responseCurrentSpeedLimit(byte by, int n, byte by2) {
        }

        public void responseStopRouteGuidance(byte by) {
        }

        public void responseStartRouteGuidance(byte by) {
        }

        public void responseCalculateAlternativeRoutes(byte by) {
        }

        public void responseSelectAlternativeRoute(byte by) {
        }

        public void responseAddSelectedDestinationAtIndex(byte by) {
        }

        public void responseSetLastDestination(byte by) {
        }

        public void responseSetFavoriteDestination(byte by) {
        }

        public void responseIntelliDestination(byte by) {
        }

        public void updateResponseStartTrufflesSearch(byte by, int n, boolean bl, int n2) {
        }

        public void responseDialDetailsNumber(byte by) {
        }

        public void responseMapCodeResult(byte by) {
        }

        public void responseTelephoneNumberResult(byte by) {
        }

        public void updateTrafficSituation(boolean bl, DateMetric dateMetric, int n, long l, int n2) {
        }

        public void updateRgActive(boolean bl) {
            NaviGateway.this.toggleRouteGuidance(bl);
        }

        public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte by, boolean bl) {
        }
    }
}

