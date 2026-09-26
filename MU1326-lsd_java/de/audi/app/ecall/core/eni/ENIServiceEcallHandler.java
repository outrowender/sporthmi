/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.eni;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.eni.DestinationPopupHandler;
import de.audi.app.ecall.core.eni.ENIServiceEcallHandler$1;
import de.audi.app.ecall.core.eni.ENIServiceEcallHandler$EniDestinationDiagnosis;
import de.audi.app.ecall.core.eni.NullENIServiceEcall;
import de.audi.app.ecall.core.osgi.EcallServiceProvider;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.app.ecall.core.storage.ILicensePopupListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.eni.ENIServiceEcall;
import de.audi.atip.interapp.eni.ENIServiceEcallListener;
import de.audi.atip.log.LogChannel;
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
        this.getApplication().addDiagnosisComponent(new ENIServiceEcallHandler$EniDestinationDiagnosis(this, null));
    }

    @Override
    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        if (n == 3 && iEcallStateStruct.isServiceIDLE() && this.currentLicenceScreen != 0) {
            this.showLicenseScreen(this.currentLicenceScreen);
        }
    }

    @Override
    public void init() {
        this.eniDestination.init();
        ENIServiceEcallHandler$1 eNIServiceEcallHandler$1 = new ENIServiceEcallHandler$1(this);
        this.getExpiredButton().setButtonListener(eNIServiceEcallHandler$1);
        this.getExpireNoteOkButton().setButtonListener(eNIServiceEcallHandler$1);
        this.eniServiceEcallHandlerProvider.startService();
        this.eniEcallServiceTracker.openTracker();
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    private ButtonModelApp getExpiredButton() {
        return this.getButtonModel(-1218825728);
    }

    private ButtonModelApp getExpireNoteOkButton() {
        return this.getButtonModel(-1470483968);
    }

    @Override
    public void deinit() {
        this.eniDestination.deinit();
        this.getExpiredButton().resetListener();
        this.getExpireNoteOkButton().resetListener();
        this.eniServiceEcallHandlerProvider.stopService();
        this.eniEcallServiceTracker.closeTracker();
        this.getApplication().getEcallStateManager().removeListener(this);
    }

    @Override
    public void onError() {
        this.log.log(-1601830656, "ENIServiceEcallHandler#onError(): unhandled");
    }

    @Override
    public void onExpirationWarning(boolean bl, int n, boolean bl2) {
        this.getLabelModel(-1386597888).setText(String.valueOf(n));
        if (bl) {
            this.showLicenseScreen(17);
        } else {
            this.showLicenseScreen(16);
        }
    }

    @Override
    public void onLicenceExpired() {
        this.showLicenseScreen(15);
    }

    private void showLicenseScreen(int n) {
        this.log.log(-2137614336, "ENIServiceEcallHandler#showLicenseScreen(): licenseScreen %1", (long)n);
        this.currentLicenceScreen = n;
        this.licensePopupListener.onLicensePopupOpened(n);
        this.getApplication().getSOSPopupHandler().forceSOSScreenShowing(n);
    }

    @Override
    public void onDestination(Destination destination) {
        this.log.log(-2137614336, "ENIServiceEcallHandler#onDestination(): destination: %1", (Object)destination);
        this.eniDestination.updateDestination(destination);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        this.log.log(-2137614336, "ENIServiceEcallHandler#addingService(): service: %1", object);
        if (object instanceof ENIServiceEcall) {
            this.eniServiceEcall = (ENIServiceEcall)object;
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
        if (object instanceof ENIServiceEcall) {
            this.log.log(-2137614336, "ENIServiceEcallHandler#removedService(): removing ecall bap service");
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.eniServiceEcall = new NullENIServiceEcall(this.log);
        }
    }

    @Override
    public void setEcallPrivacyDisclaimerTextVisible(boolean bl) {
        this.getChoiceModel(-1151716864).setValue(bl ? 1 : 0);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ButtonModelApp access$100(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.getExpireNoteOkButton();
    }

    static /* synthetic */ LogChannel access$200(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.log;
    }

    static /* synthetic */ ENIServiceEcall access$300(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.eniServiceEcall;
    }

    static /* synthetic */ ButtonModelApp access$400(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.getExpiredButton();
    }

    static /* synthetic */ LogChannel access$500(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.log;
    }

    static /* synthetic */ int access$602(ENIServiceEcallHandler eNIServiceEcallHandler, int n) {
        eNIServiceEcallHandler.currentLicenceScreen = n;
        return eNIServiceEcallHandler.currentLicenceScreen;
    }

    static /* synthetic */ ILicensePopupListener access$700(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.licensePopupListener;
    }

    static /* synthetic */ int access$800(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.destinationPopupId;
    }

    static /* synthetic */ IFrameworkAccess access$900(ENIServiceEcallHandler eNIServiceEcallHandler) {
        return eNIServiceEcallHandler.getFrameworkAccess();
    }
}

