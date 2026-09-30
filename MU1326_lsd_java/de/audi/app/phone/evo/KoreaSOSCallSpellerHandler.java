/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.NumberSpellerHandlerBase;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.state.NullEcallState;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.interapp.phone.NullTelEcallService;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KoreaSOSCallSpellerHandler
extends NumberSpellerHandlerBase
implements ButtonListener {
    private volatile ITelEcallService telEcallService;
    private final TelEcallServiceTracker telEcallServiceTracker;
    private IEcallState state;
    private List sosNumbersList;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallService;

    public KoreaSOSCallSpellerHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication);
        this.addSubPhoneComponent(new KoreaClearNumberSpellerListener(iTelEvoApplication));
        this.telEcallServiceTracker = new TelEcallServiceTracker(iTelEvoApplication);
        this.sosNumbersList = new ArrayList();
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(262156, (IGlobalTelephoneStateListener)this);
        this.getButtonModel(301230).setButtonListener(this);
        this.getButtonModel(301230).setStatus(0);
        this.telEcallServiceTracker.init();
        this.getApplication().addDiagnosisComponent(new KoreaSOSDiag());
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(262156, (IGlobalTelephoneStateListener)this);
        this.getButtonModel(301230).resetListener();
        this.telEcallServiceTracker.deinit();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.state = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState() : new NullEcallState();
        this.sosNumbersList = this.convertArrayToList(this.state != null ? this.state.getAllowedEmergencyNumbers() : null);
    }

    public void keyTyped(int n, int n2, int n3) {
        if ((n == this.getSpellerModel().getID() || n == 301230) && this.sosNumberValid(this.getSpellerModel().getText())) {
            this.dialSOSNumberInSpeller(n3);
        } else {
            this.getButtonModel(301230).setStatus(0);
            this.getButtonModel(301230).fireEvent(n3);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
        this.getButtonModel(301230).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    protected SpellerModelApp getSpellerModel() {
        return this.getSpellerModel(301229);
    }

    private List convertArrayToList(EmergencyNumber[] emergencyNumberArray) {
        ArrayList arrayList = new ArrayList();
        if (emergencyNumberArray != null) {
            for (int i2 = 0; i2 < emergencyNumberArray.length; ++i2) {
                arrayList.add(emergencyNumberArray[i2].getTelNumber());
            }
        }
        return arrayList;
    }

    private boolean sosNumberValid(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        boolean bl = this.isEmergencyCallSupported(this.state);
        boolean bl2 = !this.sosNumbersList.isEmpty();
        boolean bl3 = this.isValidNumber(this.sosNumbersList, string);
        this.log.log(1000000, "[KoreaSOSCallSpellerHandler#isEnteredEmergencyNumberValid] enteredSOSNumber=%1, enteredEmergencyNumberValid=%2", (Object)string, (Object)(bl3 ? "true" : "false"));
        return bl && bl2 && bl3;
    }

    private boolean isEmergencyCallSupported(IEcallState iEcallState) {
        return !(iEcallState instanceof NullEcallState);
    }

    private boolean isValidNumber(List list, String string) {
        return list != null && list.contains(string);
    }

    private void dialSOSNumberInSpeller(int n) {
        SpellerModelApp spellerModelApp = this.getSpellerModel();
        String string = spellerModelApp.getText();
        if (string != null && string.length() > 0) {
            this.log.log(10000000, "[KoreaSOSCallSpellerHandler#dialSOSNumberInSpeller] dialing SOS number %1", (Object)string);
            this.getTelEcallService().dialLowPrioritySOSCall(string);
        } else {
            this.log.log(10000000, "[KoreaSOSCallSpellerHandler#dialSOSNumberInSpeller] no number entered --> NOP!");
        }
    }

    protected void clearSpellerContent() {
        super.clearSpellerContent();
        this.getButtonModel(301230).setStatus(0);
    }

    protected ITelEcallService getTelEcallService() {
        return this.telEcallService;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class KoreaSOSDiag
    implements IPhoneDiagComponent {
        private KoreaSOSDiag() {
        }

        public void cmdDialKoreaSOSNumber(String string) {
            KoreaSOSCallSpellerHandler.this.getTelEcallService().dialLowPrioritySOSCall(string);
        }
    }

    private class TelEcallServiceTracker
    extends AbstractTelServiceTracker {
        public TelEcallServiceTracker(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", class$de$audi$atip$interapp$phone$ITelEcallService == null ? (class$de$audi$atip$interapp$phone$ITelEcallService = KoreaSOSCallSpellerHandler.class$("de.audi.atip.interapp.phone.ITelEcallService")) : class$de$audi$atip$interapp$phone$ITelEcallService);
        }

        protected void serviceAvailable(Object object) {
            this.log.log(1000000, "KoreaSOSCallSpellerHandler.TelServiceListenerTracker#serviceAvailable(): %1", object);
            KoreaSOSCallSpellerHandler.this.telEcallService = (ITelEcallService)object;
        }

        protected void serviceRemoved(Object object) {
            this.log.log(1000000, "KoreaSOSCallSpellerHandler.TelServiceListenerTracker#serviceRemoved(): %1", object);
            KoreaSOSCallSpellerHandler.this.telEcallService = new NullTelEcallService(this.log);
        }
    }

    private class KoreaClearNumberSpellerListener
    extends AbstractTelActionProxyListener {
        public KoreaClearNumberSpellerListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 33);
        }

        protected void actionProxyCalled(Map map) {
            KoreaSOSCallSpellerHandler.this.clearSpellerContent();
        }
    }
}

