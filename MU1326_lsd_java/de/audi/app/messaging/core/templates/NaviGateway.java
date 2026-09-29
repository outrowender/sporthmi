/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.templates.NaviGateway$1;
import de.audi.app.messaging.core.templates.NaviGateway$NaviDefaultListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviMsgDetails;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.metrics.DateMetric;
import java.util.Date;
import org.osgi.framework.Filter;
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
        this.rgActive = messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(-1483529984);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$NaviServiceListener == null ? (class$de$audi$atip$interapp$NaviServiceListener = NaviGateway.class$("de.audi.atip.interapp.NaviServiceListener")) : class$de$audi$atip$interapp$NaviServiceListener).getName(), (Object)new NaviGateway$NaviDefaultListener(this, null), ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[NaviGateway#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = NaviGateway.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName());
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        NaviGateway$1 naviGateway$1 = new NaviGateway$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)naviGateway$1);
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
        this.log.log(-2137614336, "[NaviGateway#getEta] ETA = %1", dateMetric);
        return dateMetric;
    }

    public DateMetric getDuration() {
        DateMetric dateMetric = null;
        if (this.naviService != null) {
            NaviMsgDetails naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
            Date date = new Date(naviMsgDetails.eta - this.framework.getKombiTime());
            dateMetric = new DateMetric(date, 5);
        }
        this.log.log(-2137614336, "[NaviGateway#getDuration] Duration = %1", dateMetric);
        return dateMetric;
    }

    public String getFormattedDestination() {
        String string = null;
        if (this.naviService != null) {
            NaviMsgDetails naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
            string = naviMsgDetails.formattedDestination;
        }
        this.log.log(-2137614336, "[NaviGateway#getDestination] Destination = %1", string);
        return string;
    }

    public String getFormattedCurrentPosition() {
        String string = null;
        if (this.naviService != null) {
            NaviMsgDetails naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
            string = naviMsgDetails.formattedCurrentPosition;
        }
        this.log.log(-2137614336, "[NaviGateway#getCurrentPosition] Current position = %1", string);
        return string;
    }

    public NaviMsgDetails getNaviDetails() {
        NaviMsgDetails naviMsgDetails = null;
        if (this.naviService != null) {
            naviMsgDetails = this.naviService.requestCurrentNaviDataforMessage();
        }
        this.log.log(-2137614336, "[NaviGateway#getNaviDetails");
        return naviMsgDetails;
    }

    public void toggleRouteGuidance(boolean bl) {
        this.rgActive.setValue(bl ? 1 : 0);
        this.log.log(1078071040, "[NaviGateway#toggleRouteGuidance] Route guidance active = %1", bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

