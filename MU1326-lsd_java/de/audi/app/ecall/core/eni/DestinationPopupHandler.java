/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.eni;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.eni.DestinationPopupHandler$DestinationButtonsListener;
import de.audi.app.ecall.core.eni.IEniDestination;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.GeoCoordinates;
import de.audi.atip.interapp.def.NullNaviService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DestinationPopupHandler
extends AbstractEcallComponent
implements IEniDestination,
ServiceTrackerCustomizer {
    private static final int DESTINATION_NAME_LABEL_ID;
    private static final int DESTINATION_STREET_LABEL_ID;
    private static final int DESTINATION_TOWN_LABEL_ID;
    private final int destinationPopupId;
    private final EcallServiceTracker naviTracker;
    private NaviService naviService = new NullNaviService(this.getLogger());
    private volatile GeoCoordinates geoCoordinates = GeoCoordinates.getInstance(0, 0);
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;

    DestinationPopupHandler(IEcallApplication iEcallApplication, String string, int n) {
        super(iEcallApplication, string);
        this.destinationPopupId = n;
        this.naviTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = DestinationPopupHandler.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName(), (ServiceTrackerCustomizer)this, this.log);
        DestinationPopupHandler$DestinationButtonsListener destinationPopupHandler$DestinationButtonsListener = new DestinationPopupHandler$DestinationButtonsListener(this, null);
        this.getStartNaviButton().setButtonListener(destinationPopupHandler$DestinationButtonsListener);
        this.getCancelNaviButton().setButtonListener(destinationPopupHandler$DestinationButtonsListener);
    }

    @Override
    public void init() {
        this.naviTracker.openTracker();
    }

    @Override
    public void deinit() {
        this.naviTracker.closeTracker();
    }

    private ButtonModelApp getStartNaviButton() {
        return this.getButtonModel(-1302711808);
    }

    private ButtonModelApp getCancelNaviButton() {
        return this.getButtonModel(-1269157376);
    }

    private void showDestinationPopup() {
        this.getHmiServiceApp().showPopup(this.destinationPopupId);
    }

    @Override
    public void updateDestination(Destination destination) {
        if (destination != null) {
            this.geoCoordinates = destination.getGeoCoordinates();
        }
        this.getLabelModel(-1336266240).setText(destination != null ? destination.getName() : "");
        this.getLabelModel(-1319489024).setText(destination != null && destination.getAddress() != null ? destination.getAddress().getStreet() : "");
        this.getLabelModel(-1285934592).setText(destination != null && destination.getAddress() != null ? destination.getAddress().getCity() : "");
        this.showDestinationPopup();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        this.log.log(-2137614336, "DestinationPopupHandler#addingService(): service %1 ", object);
        if (object instanceof NaviService) {
            this.naviService = (NaviService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
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

    static /* synthetic */ LogChannel access$100(DestinationPopupHandler destinationPopupHandler) {
        return destinationPopupHandler.log;
    }

    static /* synthetic */ ButtonModelApp access$200(DestinationPopupHandler destinationPopupHandler) {
        return destinationPopupHandler.getStartNaviButton();
    }

    static /* synthetic */ GeoCoordinates access$300(DestinationPopupHandler destinationPopupHandler) {
        return destinationPopupHandler.geoCoordinates;
    }

    static /* synthetic */ NaviService access$400(DestinationPopupHandler destinationPopupHandler) {
        return destinationPopupHandler.naviService;
    }

    static /* synthetic */ ButtonModelApp access$500(DestinationPopupHandler destinationPopupHandler) {
        return destinationPopupHandler.getCancelNaviButton();
    }
}

