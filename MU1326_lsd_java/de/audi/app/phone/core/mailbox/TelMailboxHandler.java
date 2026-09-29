/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.mailbox;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.SDSService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelMailboxHandler
extends AbstractPhoneComponent
implements SpellerListener,
ButtonListener,
ServiceTrackerCustomizer {
    private volatile SDSService sdsPhoneServiceListener;
    private final int SPELLER_MAX_LENGTH;
    private volatile ServiceTracker sdsPhoneServiceListenerTracker;
    private volatile IGlobalTelephoneStateStruct state;
    private final Object stateMutex = new Object();
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public TelMailboxHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.SPELLER_MAX_LENGTH = 40;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getSpellerModel(1687684096).setSpellerListener(this);
        this.getSpellerModel(1687684096).setMaxLength(40);
        this.getButtonModel(1402340352).setButtonListener(this);
        this.getButtonModel(-2104163328).setButtonListener(this);
        this.getButtonModel(-2104163328).setStatus(0);
        this.sdsPhoneServiceListenerTracker = new ServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = TelMailboxHandler.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)this);
        this.sdsPhoneServiceListenerTracker.open();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getSpellerModel(1687684096).resetListener();
        this.getButtonModel(1402340352).resetListener();
        this.getButtonModel(-2104163328).resetListener();
        if (this.sdsPhoneServiceListenerTracker != null) {
            this.sdsPhoneServiceListenerTracker.close();
            this.sdsPhoneServiceListenerTracker = null;
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof SDSService) {
            this.sdsPhoneServiceListener = (SDSService)object;
            this.updateSDSMailboxSpellerContent(this.getSpellerModel(1687684096).getText());
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
        if (object instanceof SDSService) {
            this.sdsPhoneServiceListener = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.state = iGlobalTelephoneStateStruct;
            if (n == 0x10000100) {
                this.setMailboxSpellerWithCurrentMailboxNumber();
                this.updateSDSMailboxSpellerContent(iGlobalTelephoneStateStruct.getMailboxNumber());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void dialMailboxNumber(int n) {
        Object object = this.stateMutex;
        synchronized (object) {
            String string = this.state.getMailboxNumber();
            this.log.log(-2137614336, "[TelMailboxHandler#dialMailboxNumber] dialing %1", (Object)string);
            this.getApplication().getTelephoneDSIAccess().dialNumber(string, n);
        }
    }

    protected void deleteMailboxNumber(int n) {
        this.log.log(-2137614336, "[TelMailboxHandler#deleteMailboxNumber]");
        this.setMailboxNumber("", n);
    }

    protected void setMailboxNumber(String string, int n) {
        this.log.log(-2137614336, "[TelMailboxHandler#setMailboxNumber] setting mailbox number to %1", (Object)string);
        this.getApplication().getTelephoneDSIAccess().requestSetMailboxNumber(string, n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelMailboxHandler#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 301156: {
                SpellerModelApp spellerModelApp = this.getSpellerModel(n);
                this.setMailboxNumber(spellerModelApp.getText(), n3);
                spellerModelApp.fireEvent(n3);
                break;
            }
            case 300627: {
                this.handleDialMailboxRequest(n, n3);
                break;
            }
            case 300418: {
                this.setMailboxNumber(this.getSpellerModel(1687684096).getText(), n3);
                this.getButtonModel(n).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(-2137614336, "[TelMailboxHandler#keyTyped] no handling for model %1", (long)n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean handleDialMailboxRequest(int n, int n2) {
        boolean bl = false;
        Object object = this.stateMutex;
        synchronized (object) {
            if (this.state.isMailboxNumberAvailable()) {
                bl = true;
                this.dialMailboxNumber(n2);
            } else {
                bl = false;
                this.enterDefineMailboxNumber(n, n2);
            }
        }
        return bl;
    }

    protected void enterDefineMailboxNumber(int n, int n2) {
        this.log.log(-2137614336, "[TelMailboxHandler#enterDefineMailboxNumber]");
        this.getButtonModel(n).fireEvent(n2);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelMailboxHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        if (n == 1687684096) {
            this.getSpellerModel(n).setText(string);
            if (string != null && string.length() > 0) {
                this.getButtonModel(-2104163328).setStatus(1);
            } else {
                this.getButtonModel(-2104163328).setStatus(0);
            }
            this.updateSDSMailboxSpellerContent(string);
        }
    }

    private void updateSDSMailboxSpellerContent(String string) {
        SDSService sDSService = this.sdsPhoneServiceListener;
        if (sDSService != null) {
            if (string != null && string.length() > 0) {
                this.log.log(1078071040, "[TelMailboxHandler#textChanged] notifying SDS with matchTextWithMailboxSequence: text=%1", (Object)string);
                sDSService.textChanged(1687684096, string, '\u0000');
            } else {
                this.log.log(1078071040, "[TelMailboxHandler#textChanged] notifying SDS with clearMailboxSequence: text=%1", (Object)string);
                sDSService.textChanged(1687684096, "", '\u0000');
            }
        } else {
            this.log.log(1078071040, "[TelMailboxHandler#updateSDSMailboxSpellerContent] PhoneServiceListener not available!");
        }
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    protected int getDialMailboxButtonId() {
        return this.getButtonModel(1402340352).getID();
    }

    protected void setMailboxSpellerWithCurrentMailboxNumber() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.state;
        if (iGlobalTelephoneStateStruct != null) {
            String string = iGlobalTelephoneStateStruct.getMailboxNumber();
            if (string != null && string.length() > 0) {
                this.getButtonModel(-2104163328).setStatus(1);
                this.getSpellerModel(1687684096).setText(string);
            } else {
                this.getButtonModel(-2104163328).setStatus(0);
                this.getSpellerModel(1687684096).setText("");
            }
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
}

