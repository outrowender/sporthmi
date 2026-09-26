/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.connectivity.core.common.CommandActivateNadModule;
import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.online.BaseOnlineComponent;
import de.audi.app.data.core.online.CommandAcceptDataRequest;
import de.audi.app.data.core.online.OnlineErrorState;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.ISdsConnectivityService;
import org.osgi.framework.ServiceRegistration;

public class BaseDataRequestHandler
extends AbstractDataConfigurationComponent
implements ISdsConnectivityService,
ButtonListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private final BaseOnlineComponent online;
    private ServiceRegistration serviceRegistrtation;
    private final ButtonModelApp disclaimerConfirmButton;
    private final ButtonModelApp connectionActivateButton;
    private final ButtonModelApp connectionRequestAcceptButton;
    private final ButtonModelApp connectionRequestDeclineButton;
    private final ButtonModelApp connectionRequestOnceButton;
    private final ButtonModelApp wlanConnectionRequestAcceptButton;
    private final ButtonModelApp wlanConnectionRequestDeclineButton;
    private final ButtonModelApp wlanConnectionRequestOnceButton;
    private final ButtonModelApp connectionRequestDeclineForeverButton;
    private final ButtonModelApp roamingActivateButton;
    private final ButtonModelApp roamingConfirmButton;
    private final ButtonModelApp roamingDeclineButton;
    private final ChoiceModelApp permissionChoice;
    private final ButtonModelApp nadActivateButton;
    private OnlineErrorState errorState;
    static /* synthetic */ Class class$de$audi$atip$interapp$ISdsConnectivityService;

    public BaseDataRequestHandler(IDataApplication iDataApplication, BaseOnlineComponent baseOnlineComponent) {
        super(iDataApplication);
        this.online = baseOnlineComponent;
        this.disclaimerConfirmButton = this.getButtonModel(723920384);
        this.connectionActivateButton = this.getButtonModel(673588736);
        this.connectionRequestAcceptButton = this.getButtonModel(1076241920);
        this.connectionRequestDeclineButton = this.getButtonModel(1093019136);
        this.connectionRequestOnceButton = this.getButtonModel(1109796352);
        this.connectionRequestDeclineForeverButton = this.getButtonModel(-1490672128);
        this.wlanConnectionRequestAcceptButton = this.getButtonModel(1227236864);
        this.wlanConnectionRequestDeclineButton = this.getButtonModel(1244014080);
        this.wlanConnectionRequestOnceButton = this.getButtonModel(1260791296);
        this.roamingActivateButton = this.getButtonModel(807806464);
        this.roamingConfirmButton = this.getButtonModel(824583680);
        this.roamingDeclineButton = this.getButtonModel(-1658444288);
        this.nadActivateButton = this.getButtonModel(-1792662016);
        this.permissionChoice = this.getChoiceModel(740697600);
    }

    @Override
    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void disclaimerAccept() {
        this.disclaimerAccept(0);
    }

    private void disclaimerAccept(int n) {
        this.log.log(1078071040, "BaseDataRequestHandler#disclaimerAccept(): disclaimer confirmed");
        this.errorState.updateConfirmationDisclaimer();
        this.disclaimerConfirmButton.fireEvent(n);
    }

    @Override
    public void activateNadModule() {
        this.log.log(1078071040, "BaseDataRequestHandler#activateNadModule(): User wants to activate the NAD module");
        CommandActivateNadModule.schedule(this.dataApplication, this.log, this.dataApplication.getConnectivity().getPhone());
    }

    @Override
    public void acceptOnce() {
        this.acceptOnce(0);
    }

    private void acceptOnce(int n) {
        this.log.log(1078071040, "BaseDataRequestHandler#acceptOnce(): Allowing connection");
        this.errorState.updateConfirmationAudiConnect();
        this.acceptDataRequestMmi(true);
        this.connectionRequestOnceButton.fireEvent(n);
    }

    protected void acceptOnceWlan() {
        this.log.log(1078071040, "BaseDataRequestHandler#acceptOnceWlan(): Allowing connection");
        this.errorState.updateConfirmationWlan();
        this.acceptDataRequestWlan(true);
    }

    @Override
    public void acceptAlways() {
        this.acceptAlways(0);
    }

    private void acceptAlways(int n) {
        this.log.log(1078071040, "BaseDataRequestHandler#acceptAlways(): Allowing connection, saving decision");
        this.errorState.updatePermissionGeneral(1);
        this.dataApplication.getDataSetup().setOnlinePermissionToAlways();
        this.connectionRequestAcceptButton.fireEvent(n);
    }

    protected void acceptAlwaysWlan() {
        this.log.log(1078071040, "BaseDataRequestHandler#acceptAlwaysWlan(): Allowing connection, saving decision");
        this.errorState.updatePermissionGeneral(1);
        this.dataApplication.getDataSetup().setOnlinePermissionToAlways();
    }

    @Override
    public void reject() {
        this.reject(0);
    }

    private void reject(int n) {
        this.log.log(1078071040, "BaseDataRequestHandler#reject(): Denying connection");
        this.acceptDataRequestMmi(false);
        this.connectionRequestDeclineButton.fireEvent(n);
    }

    protected void rejectWlan() {
        this.acceptDataRequestWlan(false);
    }

    @Override
    public void activateOnlineConnection() {
        this.log.log(1078071040, "BaseDataRequestHandler#activateOnlineConnection(): Activating data connection");
        this.dataApplication.getDataSetup().activateDataConnection();
        if (this.permissionChoice.getValue() == 1) {
            this.connectionActivateButton.fireEvent(0);
        }
        this.dataApplication.getDataSetup().activateDataConnection();
    }

    @Override
    public void deactivateOnlineConnection() {
        this.deactivateOnlineConnection(0);
    }

    private void deactivateOnlineConnection(int n) {
        this.log.log(1078071040, "BaseDataRequestHandler#deactivateOnlineConnection(): Deactivating data connection");
        this.dataApplication.getDataSetup().deactivateDataConnection();
        this.connectionRequestDeclineForeverButton.fireEvent(n);
    }

    @Override
    public void activateRoaming() {
        this.log.log(1078071040, "BaseDataRequestHandler#activateRoaming(): Activating data roaming");
        this.confirmRoaming();
        this.dataApplication.getDataSetup().activateRoamingPermission();
    }

    @Override
    public void confirmRoaming() {
        this.confirmRoaming(0);
    }

    private void confirmRoaming(int n) {
        this.log.log(1078071040, "BaseDataRequestHandler#confirmRoaming(): Roaming confirmed");
        this.errorState.updateConfirmationRoaming();
        this.roamingConfirmButton.fireEvent(n);
    }

    @Override
    public void declineRoaming() {
        this.declineRoaming(0);
    }

    private void declineRoaming(int n) {
        this.log.log(1078071040, "BaseDataRequestHandler#declineRoaming(): Roaming declined, deactivating setting");
        this.dataApplication.getDataSetup().deactivateRoamingPermission();
        this.roamingDeclineButton.fireEvent(n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.disclaimerConfirmButton.getID()) {
            this.disclaimerAccept(n3);
        } else if (n == this.connectionActivateButton.getID()) {
            this.activateOnlineConnection();
        } else if (n == this.connectionRequestAcceptButton.getID()) {
            this.acceptAlways(n3);
        } else if (n == this.connectionRequestOnceButton.getID()) {
            this.acceptOnce(n3);
        } else if (n == this.connectionRequestDeclineButton.getID()) {
            this.reject(n3);
        } else if (n == this.connectionRequestDeclineForeverButton.getID()) {
            this.deactivateOnlineConnection(n3);
        } else if (n == this.roamingActivateButton.getID()) {
            this.activateRoaming();
            this.roamingActivateButton.fireEvent(n3);
        } else if (n == this.roamingConfirmButton.getID()) {
            this.confirmRoaming(n3);
        } else if (n == this.roamingDeclineButton.getID()) {
            this.declineRoaming(n3);
        } else if (n == this.nadActivateButton.getID()) {
            this.activateNadModule();
            this.nadActivateButton.fireEvent(n3);
        } else if (n == this.wlanConnectionRequestAcceptButton.getID()) {
            this.acceptAlwaysWlan();
            this.wlanConnectionRequestAcceptButton.fireEvent(n3);
        } else if (n == this.wlanConnectionRequestOnceButton.getID()) {
            this.acceptOnceWlan();
            this.wlanConnectionRequestOnceButton.fireEvent(n3);
        } else if (n == this.wlanConnectionRequestDeclineButton.getID()) {
            this.rejectWlan();
            this.wlanConnectionRequestDeclineButton.fireEvent(n3);
        }
    }

    private void acceptDataRequestMmi(boolean bl) {
        CommandAcceptDataRequest.schedule(this.dataApplication, this.dsiDataConfiguration, 8, bl);
    }

    private void acceptDataRequestWlan(boolean bl) {
        this.log.log(1078071040, "BaseDataRequestHandler#acceptDataRequestWlan(): allow=%1", bl);
        CommandAcceptDataRequest.schedule(this.dataApplication, this.dsiDataConfiguration, 6, bl);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void init() {
        super.init();
        this.errorState = this.online.getErrorState();
        this.disclaimerConfirmButton.setButtonListener(this);
        this.connectionActivateButton.setButtonListener(this);
        this.connectionRequestAcceptButton.setButtonListener(this);
        this.connectionRequestDeclineButton.setButtonListener(this);
        this.connectionRequestOnceButton.setButtonListener(this);
        this.connectionRequestDeclineForeverButton.setButtonListener(this);
        this.wlanConnectionRequestAcceptButton.setButtonListener(this);
        this.wlanConnectionRequestDeclineButton.setButtonListener(this);
        this.wlanConnectionRequestOnceButton.setButtonListener(this);
        this.roamingActivateButton.setButtonListener(this);
        this.roamingConfirmButton.setButtonListener(this);
        this.roamingDeclineButton.setButtonListener(this);
        this.nadActivateButton.setButtonListener(this);
        this.serviceRegistrtation = this.dataApplication.getBundleContext().registerService((class$de$audi$atip$interapp$ISdsConnectivityService == null ? (class$de$audi$atip$interapp$ISdsConnectivityService = BaseDataRequestHandler.class$("de.audi.atip.interapp.ISdsConnectivityService")) : class$de$audi$atip$interapp$ISdsConnectivityService).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.serviceRegistrtation.unregister();
        this.disclaimerConfirmButton.resetListener();
        this.connectionActivateButton.resetListener();
        this.connectionRequestAcceptButton.resetListener();
        this.connectionRequestDeclineButton.resetListener();
        this.connectionRequestOnceButton.resetListener();
        this.connectionRequestDeclineForeverButton.resetListener();
        this.wlanConnectionRequestAcceptButton.resetListener();
        this.wlanConnectionRequestDeclineButton.resetListener();
        this.wlanConnectionRequestOnceButton.resetListener();
        this.roamingActivateButton.resetListener();
        this.roamingConfirmButton.resetListener();
        this.roamingDeclineButton.resetListener();
        this.nadActivateButton.resetListener();
        this.errorState = null;
        super.deinit();
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

