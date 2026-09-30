/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.NullITelServiceSDS;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.ISdarsAdvisoryListener;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.ifc.NullITelServiceListener;
import java.util.ArrayList;
import java.util.Iterator;

public class SDARSAdvisoryHandler {
    public static final int ADVISORY_NONE = 0;
    public static final int ADVISORY_NONE_SER_ST3 = 10;
    public static final int ADVISORY_NONE_OK_BUTTON = 11;
    public static final int ADVISORY_UPDATE_CH = 1;
    public static final int ADVISORY_CALL_SXM = 2;
    public static final int ADVISORY_CH_NOT_SUBSCRIBED = 3;
    public static final int ADVISORY_UPDATE_SUBSCR = 4;
    public static final int ADVISORY_ERROR = 5;
    public static final int ADVISORY_ANTENNA = 6;
    public static final int ADVISORY_UPDATE_SUBSCR_DONE = 7;
    public static final int ADVISORY_CH_INVALID = 8;
    private final ModelGroup advisoryGroup;
    private int activeAdvisory = 0;
    private boolean transactionRunning = false;
    private final Logger logger;
    private final TunerModels models;
    private final SDARSTuner tuner;
    private ITelService phone;
    private final ArrayList advisoryListeners = new ArrayList(1);

    SDARSAdvisoryHandler(TunerBasics tunerBasics, SDARSTuner sDARSTuner) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.tuner = sDARSTuner;
        this.phone = new NullITelServiceSDS(this.logger.sdarsDSI);
        this.models.getChoiceModel(417).forceUpdate(true);
        this.advisoryGroup = new ModelGroup();
        this.advisoryGroup.add(this.models.getLabelModel(418));
        this.advisoryGroup.add(this.models.getChoiceModel(417));
        ButtonListener buttonListener = new ButtonListener();
        this.models.getButtonModel(100441).setButtonListener(buttonListener);
        this.models.getButtonModel(100317).setButtonListener(buttonListener);
        this.models.getButtonModel(100874).setButtonListener(buttonListener);
        this.models.getButtonModel(100631).setButtonListener(buttonListener);
        this.models.getVirtualButtonModel(100619).setButtonListener(buttonListener);
        this.models.getLabelModel(100627).setText("+1-800-643-2112");
    }

    public void addAdvisoryListener(ISdarsAdvisoryListener iSdarsAdvisoryListener) {
        this.advisoryListeners.add(iSdarsAdvisoryListener);
        iSdarsAdvisoryListener.advisoryRequested(this.models.getChoiceModel(100618).getValue());
    }

    void flushAdvisoryGroup() {
        if (this.models.getActiveTuner() == 7) {
            this.advisoryGroup.flush();
            this.models.getButtonModel(100447).fireEvent(0);
        }
    }

    private void showAdvisory(int n) {
        this.logger.sdarsDSI.log(10000000, "SDARSAdvisoryHandler#showAdvisory: type %1", (long)n);
        this.activeAdvisory = n;
        if (this.transactionRunning) {
            this.tuner.propagateUpdatedActiveInfoState(7);
            return;
        }
        ChoiceModelApp choiceModelApp = this.models.getChoiceModel(100618);
        int n2 = choiceModelApp.getValue();
        choiceModelApp.setValue(n);
        if (n == 0) {
            boolean bl;
            this.models.getChoiceModel(100446).setValue(n);
            boolean bl2 = bl = n2 == 0;
            if (bl) {
                this.models.getButtonModel(100441).fireEvent(0);
            }
        }
        this.flushAdvisoryGroup();
        this.tuner.propagateUpdatedActiveInfoState(7);
    }

    public void requestAdvisory(int n) {
        if (n == 10) {
            switch (this.activeAdvisory) {
                case 2: 
                case 3: {
                    n = this.activeAdvisory;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else if (n == 11) {
            n = 0;
        } else {
            switch (this.activeAdvisory) {
                case 6: {
                    n = 6;
                    break;
                }
                case 5: {
                    if (n == 6) break;
                    n = 5;
                    break;
                }
            }
        }
        this.showAdvisory(n);
        Iterator iterator = this.advisoryListeners.iterator();
        while (iterator.hasNext()) {
            ((ISdarsAdvisoryListener)iterator.next()).advisoryRequested(n);
        }
    }

    void setPhoneService(ITelService iTelService) {
        if (iTelService == null) {
            iTelService = new NullITelServiceSDS(this.logger.sdarsDSI);
        }
        this.phone = iTelService;
    }

    public int getActiveAdvisory() {
        return this.activeAdvisory;
    }

    private void onAdvisoryPhoneButtonTyped(int n, boolean bl) {
        boolean bl2 = this.models.getChoiceModel(186).getValue() == 1;
        ButtonModelApp buttonModelApp = this.models.getButtonModel(100317);
        if (bl2) {
            String string;
            if (bl) {
                buttonModelApp.setStatus(0);
            }
            String string2 = string = this.models.getLabelModel(100627).getText();
            string2 = Utilities.replaceDelimiter(string2, '-', "");
            string2 = Utilities.replaceDelimiter(string2, '/', "");
            string2 = Utilities.replaceDelimiter(string2, ' ', "");
            if (bl) {
                this.phone.dialNumber(new SiriusCallSession(string2), false);
            } else {
                this.phone.prepareDialing(string2, new NullITelServiceListener());
            }
        } else {
            buttonModelApp.fireEvent(n);
        }
    }

    private void onPhoneCallToSiriusFinished() {
        ButtonModelApp buttonModelApp = this.models.getButtonModel(100317);
        buttonModelApp.setStatus(1);
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 100441: 
                case 100619: {
                    SDARSAdvisoryHandler.this.requestAdvisory(11);
                    break;
                }
                case 100631: {
                    SDARSAdvisoryHandler.this.requestAdvisory(2);
                    break;
                }
                case 100317: 
                case 100874: {
                    boolean bl = n == 100317;
                    SDARSAdvisoryHandler.this.onAdvisoryPhoneButtonTyped(n3, bl);
                    break;
                }
            }
        }
    }

    private class SiriusCallSession
    implements ITelCallSession {
        private final String siriusTelephoneNumber;

        public SiriusCallSession(String string) {
            this.siriusTelephoneNumber = string;
        }

        public int getCallType() {
            return 0;
        }

        public String getTelephoneNumber() {
            return this.siriusTelephoneNumber;
        }

        public void onActive(ITelCallControl iTelCallControl) {
        }

        public void onClose() {
            SDARSAdvisoryHandler.this.onPhoneCallToSiriusFinished();
        }

        public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
        }
    }
}

