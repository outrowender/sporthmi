/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.NullITelServiceSDS;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.ISdarsAdvisoryListener;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler$ButtonListener;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler$SiriusCallSession;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.ifc.NullITelServiceListener;
import java.util.ArrayList;
import java.util.Iterator;

public class SDARSAdvisoryHandler {
    public static final int ADVISORY_NONE;
    public static final int ADVISORY_NONE_SER_ST3;
    public static final int ADVISORY_NONE_OK_BUTTON;
    public static final int ADVISORY_UPDATE_CH;
    public static final int ADVISORY_CALL_SXM;
    public static final int ADVISORY_CH_NOT_SUBSCRIBED;
    public static final int ADVISORY_UPDATE_SUBSCR;
    public static final int ADVISORY_ERROR;
    public static final int ADVISORY_ANTENNA;
    public static final int ADVISORY_UPDATE_SUBSCR_DONE;
    public static final int ADVISORY_CH_INVALID;
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
        SDARSAdvisoryHandler$ButtonListener sDARSAdvisoryHandler$ButtonListener = new SDARSAdvisoryHandler$ButtonListener(this, null);
        this.models.getButtonModel(1502085376).setButtonListener(sDARSAdvisoryHandler$ButtonListener);
        this.models.getButtonModel(-578354944).setButtonListener(sDARSAdvisoryHandler$ButtonListener);
        this.models.getButtonModel(176816384).setButtonListener(sDARSAdvisoryHandler$ButtonListener);
        this.models.getButtonModel(394854656).setButtonListener(sDARSAdvisoryHandler$ButtonListener);
        this.models.getVirtualButtonModel(193528064).setButtonListener(sDARSAdvisoryHandler$ButtonListener);
        this.models.getLabelModel(327745792).setText("+1-800-643-2112");
    }

    public void addAdvisoryListener(ISdarsAdvisoryListener iSdarsAdvisoryListener) {
        this.advisoryListeners.add(iSdarsAdvisoryListener);
        iSdarsAdvisoryListener.advisoryRequested(this.models.getChoiceModel(176750848).getValue());
    }

    void flushAdvisoryGroup() {
        if (this.models.getActiveTuner() == 7) {
            this.advisoryGroup.flush();
            this.models.getButtonModel(1602748672).fireEvent(0);
        }
    }

    private void showAdvisory(int n) {
        this.logger.sdarsDSI.log(-2137614336, "SDARSAdvisoryHandler#showAdvisory: type %1", (long)n);
        this.activeAdvisory = n;
        if (this.transactionRunning) {
            this.tuner.propagateUpdatedActiveInfoState(7);
            return;
        }
        ChoiceModelApp choiceModelApp = this.models.getChoiceModel(176750848);
        int n2 = choiceModelApp.getValue();
        choiceModelApp.setValue(n);
        if (n == 0) {
            boolean bl;
            this.models.getChoiceModel(1585971456).setValue(n);
            boolean bl2 = bl = n2 == 0;
            if (bl) {
                this.models.getButtonModel(1502085376).fireEvent(0);
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
        ButtonModelApp buttonModelApp = this.models.getButtonModel(-578354944);
        if (bl2) {
            String string;
            if (bl) {
                buttonModelApp.setStatus(0);
            }
            String string2 = string = this.models.getLabelModel(327745792).getText();
            string2 = Utilities.replaceDelimiter(string2, '-', "");
            string2 = Utilities.replaceDelimiter(string2, '/', "");
            string2 = Utilities.replaceDelimiter(string2, ' ', "");
            if (bl) {
                this.phone.dialNumber(new SDARSAdvisoryHandler$SiriusCallSession(this, string2), false);
            } else {
                this.phone.prepareDialing(string2, new NullITelServiceListener());
            }
        } else {
            buttonModelApp.fireEvent(n);
        }
    }

    private void onPhoneCallToSiriusFinished() {
        ButtonModelApp buttonModelApp = this.models.getButtonModel(-578354944);
        buttonModelApp.setStatus(1);
    }

    static /* synthetic */ void access$100(SDARSAdvisoryHandler sDARSAdvisoryHandler, int n, boolean bl) {
        sDARSAdvisoryHandler.onAdvisoryPhoneButtonTyped(n, bl);
    }

    static /* synthetic */ void access$200(SDARSAdvisoryHandler sDARSAdvisoryHandler) {
        sDARSAdvisoryHandler.onPhoneCallToSiriusFinished();
    }
}

