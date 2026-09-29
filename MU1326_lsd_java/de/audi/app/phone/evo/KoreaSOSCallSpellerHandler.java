/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.NumberSpellerHandlerBase;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.state.NullEcallState;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler$KoreaClearNumberSpellerListener;
import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler$KoreaSOSDiag;
import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler$TelEcallServiceTracker;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.phone.ITelEcallService;
import java.util.ArrayList;
import java.util.List;

public class KoreaSOSCallSpellerHandler
extends NumberSpellerHandlerBase
implements ButtonListener {
    private volatile ITelEcallService telEcallService;
    private final KoreaSOSCallSpellerHandler$TelEcallServiceTracker telEcallServiceTracker;
    private IEcallState state;
    private List sosNumbersList;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallService;

    public KoreaSOSCallSpellerHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication);
        this.addSubPhoneComponent(new KoreaSOSCallSpellerHandler$KoreaClearNumberSpellerListener(this, iTelEvoApplication));
        this.telEcallServiceTracker = new KoreaSOSCallSpellerHandler$TelEcallServiceTracker(this, iTelEvoApplication);
        this.sosNumbersList = new ArrayList();
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(0xC000400, (IGlobalTelephoneStateListener)this);
        this.getButtonModel(-1365769216).setButtonListener(this);
        this.getButtonModel(-1365769216).setStatus(0);
        this.telEcallServiceTracker.init();
        this.getApplication().addDiagnosisComponent(new KoreaSOSCallSpellerHandler$KoreaSOSDiag(this, null));
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(0xC000400, (IGlobalTelephoneStateListener)this);
        this.getButtonModel(-1365769216).resetListener();
        this.telEcallServiceTracker.deinit();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.state = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState() : new NullEcallState();
        this.sosNumbersList = this.convertArrayToList(this.state != null ? this.state.getAllowedEmergencyNumbers() : null);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if ((n == this.getSpellerModel().getID() || n == -1365769216) && this.sosNumberValid(this.getSpellerModel().getText())) {
            this.dialSOSNumberInSpeller(n3);
        } else {
            this.getButtonModel(-1365769216).setStatus(0);
            this.getButtonModel(-1365769216).fireEvent(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
        this.getButtonModel(-1365769216).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    @Override
    protected SpellerModelApp getSpellerModel() {
        return this.getSpellerModel(-1382546432);
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
        this.log.log(1078071040, "[KoreaSOSCallSpellerHandler#isEnteredEmergencyNumberValid] enteredSOSNumber=%1, enteredEmergencyNumberValid=%2", (Object)string, (Object)(bl3 ? "true" : "false"));
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
            this.log.log(-2137614336, "[KoreaSOSCallSpellerHandler#dialSOSNumberInSpeller] dialing SOS number %1", (Object)string);
            this.getTelEcallService().dialLowPrioritySOSCall(string);
        } else {
            this.log.log(-2137614336, "[KoreaSOSCallSpellerHandler#dialSOSNumberInSpeller] no number entered --> NOP!");
        }
    }

    @Override
    protected void clearSpellerContent() {
        super.clearSpellerContent();
        this.getButtonModel(-1365769216).setStatus(0);
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

    static /* synthetic */ ITelEcallService access$102(KoreaSOSCallSpellerHandler koreaSOSCallSpellerHandler, ITelEcallService iTelEcallService) {
        koreaSOSCallSpellerHandler.telEcallService = iTelEcallService;
        return koreaSOSCallSpellerHandler.telEcallService;
    }
}

