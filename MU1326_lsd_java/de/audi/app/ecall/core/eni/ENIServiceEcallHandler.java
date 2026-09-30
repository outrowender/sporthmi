/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.eni;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.eni.DestinationPopupHandler;
import de.audi.app.ecall.core.eni.NullENIServiceEcall;
import de.audi.app.ecall.core.osgi.EcallServiceProvider;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.app.ecall.core.storage.ILicensePopupListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.eni.ENIServiceEcall;
import de.audi.atip.interapp.eni.ENIServiceEcallListener;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ENIServiceEcallHandler
extends AbstractEcallComponent
implements ENIServiceEcallListener,
ServiceTrackerCustomizer,
IGlobalEcallStateListener {
    private final EcallServiceProvider eniServiceEcallHandlerProvider;
    private ENIServiceEcall eniServiceEcall = new NullENIServiceEcall(this.getLogger());
    private final EcallServiceTracker eniEcallServiceTracker;
    private final DestinationPopupHandler eniDestination;
    private final int destinationPopupId;
    private final ILicensePopupListener licensePopupListener;
    private int currentLicenceScreen = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceEcallListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceEcall;

    public ENIServiceEcallHandler(IEcallApplication iEcallApplication, int n, ILicensePopupListener iLicensePopupListener) {
        super(iEcallApplication, "App.Ecall.Main");
        this.destinationPopupId = n;
        this.licensePopupListener = iLicensePopupListener;
        this.eniServiceEcallHandlerProvider = new EcallServiceProvider((class$de$audi$atip$interapp$eni$ENIServiceEcallListener == null ? (class$de$audi$atip$interapp$eni$ENIServiceEcallListener = ENIServiceEcallHandler.class$("de.audi.atip.interapp.eni.ENIServiceEcallListener")) : class$de$audi$atip$interapp$eni$ENIServiceEcallListener).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.eniEcallServiceTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$eni$ENIServiceEcall == null ? (class$de$audi$atip$interapp$eni$ENIServiceEcall = ENIServiceEcallHandler.class$("de.audi.atip.interapp.eni.ENIServiceEcall")) : class$de$audi$atip$interapp$eni$ENIServiceEcall).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.eniDestination = new DestinationPopupHandler(iEcallApplication, "App.Ecall.Main", this.destinationPopupId);
        this.getApplication().addDiagnosisComponent(new EniDestinationDiagnosis());
    }

    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        if (n == 3 && iEcallStateStruct.isServiceIDLE() && this.currentLicenceScreen != 0) {
            this.showLicenseScreen(this.currentLicenceScreen);
        }
    }

    public void init() {
        this.eniDestination.init();
        DefaultButtonListener defaultButtonListener = new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                if (n == ENIServiceEcallHandler.this.getExpireNoteOkButton().getID()) {
                    ENIServiceEcallHandler.this.log.log(1000000, "ENIServiceEcallHandler.init().new DefaultButtonListener() {...}#keyTyped(): handling EXPIRE_NOTE_OK_BUTTON");
                    ENIServiceEcallHandler.this.eniServiceEcall.confirmExpirationWarning();
                } else if (n == ENIServiceEcallHandler.this.getExpiredButton().getID()) {
                    ENIServiceEcallHandler.this.log.log(1000000, "ENIServiceEcallHandler.init().new DefaultButtonListener() {...}#keyTyped(): handling EXPIRED_OK_BUTTON");
                    ENIServiceEcallHandler.this.eniServiceEcall.confirmEcallExpirated();
                }
                ENIServiceEcallHandler.this.currentLicenceScreen = 0;
                ENIServiceEcallHandler.this.licensePopupListener.onLicensePopupConfirmed();
                ENIServiceEcallHandler.this.getButtonModel(n).fireEvent(0);
            }
        };
        this.getExpiredButton().setButtonListener(defaultButtonListener);
        this.getExpireNoteOkButton().setButtonListener(defaultButtonListener);
        this.eniServiceEcallHandlerProvider.startService();
        this.eniEcallServiceTracker.openTracker();
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    private ButtonModelApp getExpiredButton() {
        return this.getButtonModel(3300023);
    }

    private ButtonModelApp getExpireNoteOkButton() {
        return this.getButtonModel(3300008);
    }

    public void deinit() {
        this.eniDestination.deinit();
        this.getExpiredButton().resetListener();
        this.getExpireNoteOkButton().resetListener();
        this.eniServiceEcallHandlerProvider.stopService();
        this.eniEcallServiceTracker.closeTracker();
        this.getApplication().getEcallStateManager().removeListener(this);
    }

    public void onError() {
        this.log.log(100000, "ENIServiceEcallHandler#onError(): unhandled");
    }

    public void onExpirationWarning(boolean bl, int n, boolean bl2) {
        this.getLabelModel(3300013).setText(String.valueOf(n));
        if (bl) {
            this.showLicenseScreen(17);
        } else {
            this.showLicenseScreen(16);
        }
    }

    public void onLicenceExpired() {
        this.showLicenseScreen(15);
    }

    private void showLicenseScreen(int n) {
        this.log.log(10000000, "ENIServiceEcallHandler#showLicenseScreen(): licenseScreen %1", (long)n);
        this.currentLicenceScreen = n;
        this.licensePopupListener.onLicensePopupOpened(n);
        this.getApplication().getSOSPopupHandler().forceSOSScreenShowing(n);
    }

    public void onDestination(Destination destination) {
        this.log.log(10000000, "ENIServiceEcallHandler#onDestination(): destination: %1", (Object)destination);
        this.eniDestination.updateDestination(destination);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        this.log.log(10000000, "ENIServiceEcallHandler#addingService(): service: %1", object);
        if (object instanceof ENIServiceEcall) {
            this.eniServiceEcall = (ENIServiceEcall)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ENIServiceEcall) {
            this.log.log(10000000, "ENIServiceEcallHandler#removedService(): removing ecall bap service");
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.eniServiceEcall = new NullENIServiceEcall(this.log);
        }
    }

    public void setEcallPrivacyDisclaimerTextVisible(boolean bl) {
        this.getChoiceModel(3300027).setValue(bl ? 1 : 0);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class EniDestinationDiagnosis
    implements IEcallDiagnosisComponent {
        private EniDestinationDiagnosis() {
        }

        public void cmdShowDestinationPopup() {
            ENIServiceEcallHandler.this.getFrameworkAccess().getHMIService().showPopup(ENIServiceEcallHandler.this.destinationPopupId);
        }

        public void cmdOnExpirationWarning(boolean bl, int n) {
            ENIServiceEcallHandler.this.onExpirationWarning(bl, n, false);
        }

        public void cmdOnLicenseExpired() {
            ENIServiceEcallHandler.this.onLicenceExpired();
        }

        public void cmdConfirmExpired() {
            ENIServiceEcallHandler.this.eniServiceEcall.confirmEcallExpirated();
        }
    }
}

