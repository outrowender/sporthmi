/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.AuthenticationDiag
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.obex.core.authentication;

import de.audi.app.connectivity.core.AbstractApplicationComponent;
import de.audi.app.obex.core.IObexApplication;
import de.audi.app.obex.core.NullDSIObexAuthentication;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.mib.swdiagnosis.connectivity.AuthenticationDiag;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.bluetooth.DSIObexAuthentication;
import org.dsi.ifc.bluetooth.DSIObexAuthenticationListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractAuthentication
extends AbstractApplicationComponent
implements SpellerListener,
ButtonListener,
DSIObexAuthenticationListener,
ServiceTrackerCustomizer {
    private static final int MAX_LENGTH = 128;
    private static final int SPELLER_NOK = 0;
    private static final int SPELLER_OK = 1;
    private static final String EMPTY = "";
    private static final int AUTH_IDLE = 0;
    private static final int AUTH_ID = 1;
    private static final int AUTH_PWD = 2;
    private static final int AUTH_ERROR = -1;
    protected final IObexApplication application;
    private DSIObexAuthentication dsi;
    private ServiceTracker obexAuthenticationTracker;
    private final ChoiceModelApp authenticationState;
    private final LabelModelApp deviceNameLabel;
    private final ButtonModelApp acceptButton;
    private final ButtonModelApp rejectButton;
    private final SpellerModelApp userSpeller;
    private final SpellerModelApp passwordSpeller;
    private final LabelModelApp userNameLabel;
    private volatile int service;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthentication;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public AbstractAuthentication(IObexApplication iObexApplication) {
        super(iObexApplication);
        this.application = iObexApplication;
        this.authenticationState = this.getChoiceModel(0x26266F);
        this.deviceNameLabel = this.getLabelModel(2500208);
        this.acceptButton = this.getButtonModel(0x26266E);
        this.rejectButton = this.getButtonModel(0x262672);
        this.userSpeller = this.getSpellerModel(2500211);
        this.passwordSpeller = this.getSpellerModel(2500209);
        this.userNameLabel = this.getLabelModel(2500212);
        this.dsi = new NullDSIObexAuthentication(this.log);
    }

    public void authenticationRequired(int n, boolean bl, String string) {
        this.log.log(1000000, "AbstractAuthentication#authenticationRequired(): device name=%3, service =%1, ID required=%2", bl, (Object)String.valueOf(n), (Object)string);
        this.service = n;
        this.deviceNameLabel.setText(string == null ? EMPTY : string);
        this.initModels();
        this.authenticationState.setValue(bl ? 1 : 2);
        this.showPopup();
    }

    protected abstract void showPopup();

    private void initModels() {
        this.userSpeller.clear();
        this.passwordSpeller.clear();
        this.userSpeller.setStatus(0);
        this.passwordSpeller.setStatus(0);
        this.userNameLabel.setText(EMPTY);
    }

    public void indAuthentication(boolean bl) {
        this.log.log(1000000, "AbstractAuthentication#indAuthentication(): success=%1", bl);
        this.authenticationState.setValue(bl ? 0 : -1);
        this.authenticationState.setStatus(1);
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(100000, "AbstractAuthentication#asyncException(): errorCode %1, errorMsg %2, requestType %3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(10000000, "AbstractAuthentication#textChanged(): model=%2, text=%1", (Object)string, (long)n);
        if (n == this.userSpeller.getID()) {
            this.userNameLabel.setText(string);
        }
        this.getSpellerModel(n).setStatus(string.length() > 0 ? 1 : 0);
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == this.acceptButton.getID()) {
            this.log.log(1000000, "AbstractAuthentication#keyTyped(): Accepting authentication");
            this.authenticationState.setStatus(0);
            this.dsi.setAuthenticationInfo(this.service, this.userSpeller.getText(), this.passwordSpeller.getText());
            this.acceptButton.fireEvent(n3);
        } else if (n == this.rejectButton.getID()) {
            this.log.log(1000000, "AbstractAuthentication#keyTyped(): Rejecting authentication");
            this.dsi.setAuthenticationInfo(this.service, this.userSpeller.getText(), this.passwordSpeller.getText());
            this.rejectButton.fireEvent(n3);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void init() {
        this.registerDsiListener();
        this.obexAuthenticationTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$bluetooth$DSIObexAuthentication == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthentication = AbstractAuthentication.class$("org.dsi.ifc.bluetooth.DSIObexAuthentication")) : class$org$dsi$ifc$bluetooth$DSIObexAuthentication).getName()}, (ServiceTrackerCustomizer)this);
        this.obexAuthenticationTracker.open();
        this.acceptButton.setButtonListener(this);
        this.rejectButton.setButtonListener(this);
        this.userSpeller.setMaxLength(128);
        this.passwordSpeller.setMaxLength(128);
        this.userSpeller.setSpellerListener(this);
        this.passwordSpeller.setSpellerListener(this);
        this.application.getDiag().addDiagnosisComponent((IDiagComponent)new AuthenticationDiag(this));
    }

    private void registerDsiListener() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener = AbstractAuthentication.class$("org.dsi.ifc.bluetooth.DSIObexAuthenticationListener")) : class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractAuthentication.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this, (Dictionary)hashtable);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIObexAuthentication) {
            this.dsi = (DSIObexAuthentication)object;
            return object;
        }
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIObexAuthentication) {
            this.dsi = new NullDSIObexAuthentication(this.log);
        }
    }

    public void deinit() {
        this.obexAuthenticationTracker.close();
        this.obexAuthenticationTracker = null;
        this.acceptButton.resetListener();
        this.rejectButton.resetListener();
        this.userSpeller.resetListener();
        this.passwordSpeller.resetListener();
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

