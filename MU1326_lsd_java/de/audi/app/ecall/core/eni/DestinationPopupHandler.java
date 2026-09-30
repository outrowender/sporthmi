/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.eni;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.eni.IEniDestination;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.GeoCoordinates;
import de.audi.atip.interapp.def.NullNaviService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DestinationPopupHandler
extends AbstractEcallComponent
implements IEniDestination,
ServiceTrackerCustomizer {
    private static final int DESTINATION_NAME_LABEL_ID = 3300016;
    private static final int DESTINATION_STREET_LABEL_ID = 3300017;
    private static final int DESTINATION_TOWN_LABEL_ID = 3300019;
    private final int destinationPopupId;
    private final EcallServiceTracker naviTracker;
    private NaviService naviService = new NullNaviService(this.getLogger());
    private volatile GeoCoordinates geoCoordinates = GeoCoordinates.getInstance(0, 0);
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;

    DestinationPopupHandler(IEcallApplication iEcallApplication, String string, int n) {
        super(iEcallApplication, string);
        this.destinationPopupId = n;
        this.naviTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = DestinationPopupHandler.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName(), (ServiceTrackerCustomizer)this, this.log);
        DestinationButtonsListener destinationButtonsListener = new DestinationButtonsListener();
        this.getStartNaviButton().setButtonListener(destinationButtonsListener);
        this.getCancelNaviButton().setButtonListener(destinationButtonsListener);
    }

    public void init() {
        this.naviTracker.openTracker();
    }

    public void deinit() {
        this.naviTracker.closeTracker();
    }

    private ButtonModelApp getStartNaviButton() {
        return this.getButtonModel(3300018);
    }

    private ButtonModelApp getCancelNaviButton() {
        return this.getButtonModel(3300020);
    }

    private void showDestinationPopup() {
        this.getHmiServiceApp().showPopup(this.destinationPopupId);
    }

    public void updateDestination(Destination destination) {
        if (destination != null) {
            this.geoCoordinates = destination.getGeoCoordinates();
        }
        this.getLabelModel(3300016).setText(destination != null ? destination.getName() : "");
        this.getLabelModel(3300017).setText(destination != null && destination.getAddress() != null ? destination.getAddress().getStreet() : "");
        this.getLabelModel(3300019).setText(destination != null && destination.getAddress() != null ? destination.getAddress().getCity() : "");
        this.showDestinationPopup();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        this.log.log(10000000, "DestinationPopupHandler#addingService(): service %1 ", object);
        if (object instanceof NaviService) {
            this.naviService = (NaviService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof NaviService) {
            this.naviService = new NullNaviService(this.log);
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

    private class DestinationButtonsListener
    extends DefaultButtonListener {
        private DestinationButtonsListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            DestinationPopupHandler.this.log.log(1000000, "DestinationPopupHandler.ButtonsListener#keyTyped(): modelId = %1", (long)n);
            if (n == DestinationPopupHandler.this.getStartNaviButton().getID()) {
                int n4 = NavigationUtilities.degreeToWgs84((double)DestinationPopupHandler.this.geoCoordinates.getLongitude() / 1000000.0);
                int n5 = NavigationUtilities.degreeToWgs84((double)DestinationPopupHandler.this.geoCoordinates.getLatitude() / 1000000.0);
                DestinationPopupHandler.this.naviService.startRouteGuidance(n4, n5);
                DestinationPopupHandler.this.getStartNaviButton().fireEvent(0);
            } else if (n == DestinationPopupHandler.this.getCancelNaviButton().getID()) {
                DestinationPopupHandler.this.getCancelNaviButton().fireEvent(0);
            }
        }
    }
}

