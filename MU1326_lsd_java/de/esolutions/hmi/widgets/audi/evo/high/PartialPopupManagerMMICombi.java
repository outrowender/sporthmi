/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.interapp.combi.bap.PartialPopupBAPService;
import de.audi.atip.interapp.combi.bap.PartialPopupBAPServiceListener;
import de.audi.atip.interapp.combi.bap.data.PartialPopupBAPContent;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupControllerMMICombi;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerEvoHigh;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class PartialPopupManagerMMICombi
extends PartialPopupManagerEvoHigh
implements IPartialPopupManager,
PartialPopupBAPServiceListener {
    private LogChannel logPPMMICombi = IWidgetLogChannel.logChannelPPMMICombi;
    PartialPopupBAPService bAPService;
    private int currentRequestedPPViaBAP = -1;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener;

    public PartialPopupManagerMMICombi(HMITerminalImpl hMITerminalImpl, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, boolean bl) {
        super(hMITerminalImpl, bundleContext, iFrameworkAccess);
    }

    public PartialPopupManagerMMICombi(HMITerminalImpl hMITerminalImpl, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this(hMITerminalImpl, bundleContext, iFrameworkAccess, true);
        this.logPPMMICombi = IWidgetLogChannel.logChannelPPMMICombi;
    }

    public void notifyPartialPopupVisible() {
        this.logPPMMICombi.log(1000000, "PartialPopupManagerMMICombi#notifyPartialPopupVisible received, last requested pp via BAP is: %1", (long)this.currentRequestedPPViaBAP);
    }

    public void notifyPartialPopupHidden() {
        this.logPPMMICombi.log(1000000, "PartialPopupManagerMMICombi#notifyPartialPopupHidden received, last requested pp via BAP is: %1", (long)this.currentRequestedPPViaBAP);
    }

    public void optionSelected(int n, int n2) {
        this.logPPMMICombi.log(1000000, "PartialPopupManagerMMICombi#optionSelected received, popupID: %1, option: %2", (long)n, (long)n2);
        IPartialPopupController iPartialPopupController = this.getPartialPopup(n);
        if (iPartialPopupController instanceof PartialPopupControllerMMICombi) {
            this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new OptionSelectedJob(n, n2)));
        } else {
            this.logPPMMICombi.log(10000, "PartialPopupManagerMMICombi#optionSelected received, but no popup with popupID: %1 registered", (long)n);
        }
    }

    public void cancelPopup(int n) {
        this.logPPMMICombi.log(1000000, "PartialPopupManagerMMICombi#cancelPopup received, last requested pp via BAP is: %1", (long)this.currentRequestedPPViaBAP);
        IPartialPopupController iPartialPopupController = this.getPartialPopup(n);
        if (iPartialPopupController instanceof PartialPopupControllerMMICombi) {
            this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new PopupCanceledJob(n)));
        } else {
            this.logPPMMICombi.log(10000, "PartialPopupManagerMMICombi#cancelPopup received, but no popup with popupID: %1 registered", (long)n);
        }
    }

    public int showPPViaBAP(int n, PartialPopupBAPContent partialPopupBAPContent) {
        this.logPPMMICombi.log(1000000, "PartialPopupManagerMMICombi#showPPViaBAP id: %2, content %1", (Object)partialPopupBAPContent, (long)n);
        if (this.bAPService != null) {
            this.bAPService.showPartialPopup(n, partialPopupBAPContent);
            this.currentRequestedPPViaBAP = n;
            return 1;
        }
        this.logPPMMICombi.log(10000, "PartialPopupManagerMMICombi#showPPViaBAP no BAPService available");
        return 3;
    }

    public int hidePPViaBAP(int n) {
        this.logPPMMICombi.log(1000000, "PartialPopupManagerMMICombi#hidePPViaBAP id: %1", (long)n);
        if (this.bAPService != null) {
            this.bAPService.hidePartialPopup(n);
        } else {
            this.logPPMMICombi.log(10000, "PartialPopupManagerMMICombi#showPPViaBAP no BAPService available");
        }
        return 0;
    }

    public void startTrackingServices() {
        this.initializeBAPServiceTracker();
        super.startTrackingServices();
    }

    private void initializeBAPServiceTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService == null ? (class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService = PartialPopupManagerMMICombi.class$("de.audi.atip.interapp.combi.bap.PartialPopupBAPService")) : class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                PartialPopupManagerMMICombi.this.bAPService = (PartialPopupBAPService)PartialPopupManagerMMICombi.this.bundleContext.getService(serviceReference);
                return PartialPopupManagerMMICombi.this.bAPService;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                PartialPopupManagerMMICombi.this.bAPService = null;
            }
        });
        serviceTracker.open();
    }

    public void registerServices() {
        this.bundleContext.registerService((class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener == null ? (class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener = PartialPopupManagerMMICombi.class$("de.audi.atip.interapp.combi.bap.PartialPopupBAPServiceListener")) : class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener).getName(), (Object)this, null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class PopupCanceledJob
    implements Runnable {
        private int popupID;

        private PopupCanceledJob(int n) {
            this.popupID = n;
        }

        public void run() {
            PartialPopupManagerMMICombi.this.hidePopup(this.popupID);
        }
    }

    private class OptionSelectedJob
    implements Runnable {
        private int popupID;
        private int optionID;

        private OptionSelectedJob(int n, int n2) {
            this.popupID = n;
            this.optionID = n2;
        }

        public void run() {
            if (PartialPopupManagerMMICombi.this.getPartialPopup(this.popupID) != null) {
                ((PartialPopupControllerMMICombi)PartialPopupManagerMMICombi.this.getPartialPopup(this.popupID)).optionSelected(this.optionID);
            }
        }
    }
}

