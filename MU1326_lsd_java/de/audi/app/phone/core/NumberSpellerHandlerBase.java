/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.SDSService;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class NumberSpellerHandlerBase
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer,
SpellerListener {
    public static final int MAX_LENGTH_TELEPHONE = 40;
    protected volatile SDSService sdsPhoneServiceListener;
    private volatile ServiceTracker sdsPhoneServiceListenerTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public NumberSpellerHandlerBase(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        super.init();
        this.getSpellerModel().setSpellerListener(this);
        this.getSpellerModel().setMaxLength(40);
        this.sdsPhoneServiceListenerTracker = new ServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = NumberSpellerHandlerBase.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)this);
        this.sdsPhoneServiceListenerTracker.open();
    }

    public void deinit() {
        super.deinit();
        this.getSpellerModel().resetListener();
        if (this.sdsPhoneServiceListenerTracker != null) {
            this.sdsPhoneServiceListenerTracker.close();
            this.sdsPhoneServiceListenerTracker = null;
        }
    }

    protected SpellerModelApp getSpellerModel() {
        return this.getSpellerModel(300205);
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "NumberSpellerHandlerBase#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "NumberSpellerHandlerBase#addingService service is null");
            return null;
        }
        if (object instanceof SDSService) {
            this.sdsPhoneServiceListener = (SDSService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object == null) {
            this.log.log(10000, "NumberSpellerHandlerBase#removedService service is null");
            return;
        }
        if (serviceReference == null) {
            this.log.log(10000, "NumberSpellerHandlerBase#removedService reference is null");
            return;
        }
        if (object instanceof SDSService) {
            this.sdsPhoneServiceListener = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[NumberSpellerHandlerBase#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        if (n == this.getSpellerModel().getID()) {
            SDSService sDSService = this.sdsPhoneServiceListener;
            if (sDSService != null) {
                if (string != null && string.length() > 0) {
                    this.log.log(1000000, "[NumberSpellerHandlerBase#textChanged] notifying SDS with matchTextWithNumberSequence: text=%1", (Object)string);
                    sDSService.textChanged(this.getSpellerModel().getID(), string, c2);
                } else {
                    this.log.log(1000000, "[NumberSpellerHandlerBase#textChanged] notifying SDS with clearNumberSequence: text=%1", (Object)string);
                    sDSService.textChanged(this.getSpellerModel().getID(), "", '\u0000');
                }
            } else {
                this.log.log(10000, "NumberSpellerHandlerBase#textChanged sdsPhoneServiceListener is null");
            }
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[NumberSpellerHandlerBase#keyTyped] model=%1, key=%2, terminal=%3", (long)n, (long)n2, (long)n3);
        if (n == this.getSpellerModel().getID()) {
            this.dialNumberInSpeller(n3);
        }
    }

    public void commandPressed(int n, int n2, int n3) {
        this.log.log(1000000, "[NumberSpellerHandlerBase#commandPressed] model=%1, index=%2, terminal=%3", (long)n, (long)n2, (long)n3);
    }

    protected void dialNumberInSpeller(int n) {
        SpellerModelApp spellerModelApp = this.getSpellerModel();
        String string = spellerModelApp.getText();
        if (string != null && string.length() > 0) {
            this.log.log(10000000, "[NumberSpellerHandlerBase#keyTyped] dialing number %1", (Object)string);
            this.getApplication().getTelephoneDSIAccess().dialNumber(string, n, true, new TelDefaultDSIResponseListener(){

                public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                    if (n2 != 0) {
                        NumberSpellerHandlerBase.this.clearSpellerContent();
                    }
                }
            });
        } else {
            this.log.log(10000000, "[NumberSpellerHandlerBase#keyTyped] no number entered --> NOP!");
        }
    }

    protected void clearSpellerContent() {
        SpellerModelApp spellerModelApp = this.getSpellerModel();
        spellerModelApp.clear();
        SDSService sDSService = this.sdsPhoneServiceListener;
        if (sDSService != null) {
            this.log.log(10000000, "[NumberSpellerHandlerBase#actionProxyCallPerformed] calling clearNumberSequence in SDS");
            sDSService.textChanged(this.getSpellerModel().getID(), "", '\u0000');
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

