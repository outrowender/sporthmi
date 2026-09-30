/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.AbstractEntertainmentDrawerElement;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.AbstractButtonEntertainmentDrawerElement;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemAcceptCallCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemAcceptCallNCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemHangupCallCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemHoldCallCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemHoldConferenceCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemMicMuteOnOffCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemMuteRingtoneCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemRejectCallCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemRejectCallNCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemReplaceCallCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemResponseAndHoldCallCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemResumeCallCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemResumeConferenceCLD;
import de.audi.app.phone.evo.entertainmentdrawer.buttonelements.EntDrwElemSwapCallsCLD;
import de.audi.app.phone.evo.entertainmentdrawer.dataelements.AbstractDataEntertainmentDrawerElement;
import de.audi.app.phone.evo.entertainmentdrawer.dataelements.EntertainmentDrawerElementActiveCallDataModels;
import de.audi.app.phone.evo.entertainmentdrawer.dataelements.EntertainmentDrawerElementIncomingCallDataModels;
import de.audi.atip.hmi.model.ModelGroup;
import java.util.LinkedList;
import java.util.List;

public class EntertainmentDrawerModelHandler
extends AbstractPhoneComponent {
    private List entDrwButtonsModels;
    private List entDrwDataModels;
    public static final int MODELGROUP_INCOMING_CALL_MODELS = 0;
    public static final int MODELGROUP_ACTIVE_CALL_MODELS = 1;

    public EntertainmentDrawerModelHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.EntertainmentDrawer");
    }

    public void init() {
        super.init();
        this.initButtonComponents();
        this.initDataComponenets();
    }

    public void deinit() {
        super.deinit();
        this.deinitButtonComponents();
        this.deinitDataComponenets();
    }

    public ModelGroup[] getEntertainmentDrawerModels(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        AbstractEntertainmentDrawerElement abstractEntertainmentDrawerElement;
        int n;
        ModelGroup[] modelGroupArray = new ModelGroup[2];
        ModelGroup modelGroup = new TelModelGroup("INCOMING_MG", this.log);
        ModelGroup modelGroup2 = new TelModelGroup("ACTIVE_MG", this.log);
        block8: for (n = 0; n < this.entDrwDataModels.size(); ++n) {
            abstractEntertainmentDrawerElement = (AbstractDataEntertainmentDrawerElement)this.entDrwDataModels.get(n);
            switch (((AbstractDataEntertainmentDrawerElement)abstractEntertainmentDrawerElement).getModelGroupType()) {
                case 0: {
                    modelGroup = ((AbstractDataEntertainmentDrawerElement)abstractEntertainmentDrawerElement).updateInternalModelValues(modelGroup, iGlobalTelephoneStateStruct);
                    continue block8;
                }
                case 1: {
                    modelGroup2 = ((AbstractDataEntertainmentDrawerElement)abstractEntertainmentDrawerElement).updateInternalModelValues(modelGroup2, iGlobalTelephoneStateStruct);
                    continue block8;
                }
            }
        }
        block9: for (n = 0; n < this.entDrwButtonsModels.size(); ++n) {
            abstractEntertainmentDrawerElement = (AbstractButtonEntertainmentDrawerElement)this.entDrwButtonsModels.get(n);
            switch (((AbstractButtonEntertainmentDrawerElement)abstractEntertainmentDrawerElement).getModelGroupType()) {
                case 0: {
                    modelGroup = ((AbstractButtonEntertainmentDrawerElement)abstractEntertainmentDrawerElement).updateInternalModelValues(modelGroup, iGlobalTelephoneStateStruct);
                    continue block9;
                }
                case 1: {
                    modelGroup2 = ((AbstractButtonEntertainmentDrawerElement)abstractEntertainmentDrawerElement).updateInternalModelValues(modelGroup2, iGlobalTelephoneStateStruct);
                    continue block9;
                }
            }
        }
        modelGroupArray[0] = modelGroup;
        modelGroupArray[1] = modelGroup2;
        return modelGroupArray;
    }

    private void initDataComponenets() {
        this.entDrwDataModels = new LinkedList();
        this.entDrwDataModels.add(new EntertainmentDrawerElementIncomingCallDataModels(this.getApplication()));
        this.entDrwDataModels.add(new EntertainmentDrawerElementActiveCallDataModels(this.getApplication()));
    }

    private void initButtonComponents() {
        this.entDrwButtonsModels = new LinkedList();
        this.entDrwButtonsModels.add(new EntDrwElemAcceptCallCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemMuteRingtoneCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemRejectCallCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemAcceptCallNCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemReplaceCallCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemRejectCallNCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemResponseAndHoldCallCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemHangupCallCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemHoldCallCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemResumeCallCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemHoldConferenceCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemResumeConferenceCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemMicMuteOnOffCLD(this.getApplication()));
        this.entDrwButtonsModels.add(new EntDrwElemSwapCallsCLD(this.getApplication()));
    }

    private void deinitDataComponenets() {
        this.entDrwDataModels.clear();
        this.entDrwDataModels = null;
    }

    private void deinitButtonComponents() {
        this.entDrwButtonsModels.clear();
        this.entDrwButtonsModels = null;
    }

    public List getEntertainmentDrawerButtonsModelsList() {
        return this.entDrwButtonsModels;
    }

    public List getEntertainmentDrawerDataModelsList() {
        return this.entDrwDataModels;
    }
}

