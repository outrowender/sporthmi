/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractScreenAccess;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class PartialPopupScreenAccess
extends AbstractScreenAccess {
    private static final int MODEL_BUTTONS = 0;
    private static final int MODEL_TIMEOUT = 1;
    private static final int MODEL_MESSAGE = 2;
    private static final int MODEL_VISIBILITY_BUTTON_1 = 3;
    private static final int MODEL_LABEL_BUTTON_1 = 4;
    private static final int MODEL_VISIBILITY_BUTTON_2 = 5;
    private static final int MODEL_LABEL_BUTTON_2 = 6;
    private static final int MODEL_COUNT = 7;
    private AbstractScreenAccess.ModelData[] models = new AbstractScreenAccess.ModelData[7];
    private ModelGroup modelGroup;

    public PartialPopupScreenAccess(LogChannel logChannel, RemoteHMIService remoteHMIService, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, ChoiceModelApp choiceModelApp) {
        super(choiceModelApp, logChannel);
        this.models[0] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "buttons", 3, true, 2301011);
        this.models[1] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "timeout", 3, true, 2301010);
        this.models[2] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "message", 0, true, 2301009);
        this.models[3] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action1Button", 4, true, 2301004);
        this.models[4] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action1Label", 0, true, 2301005);
        this.models[5] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action2Button", 4, true, 2301006);
        this.models[6] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action2Label", 0, true, 2301007);
        this.modelGroup = modelGroup;
        this.refreshModelGroup(modelGroup, this.models);
    }

    public boolean isMainScreen() {
        return true;
    }

    public boolean switchScreen(boolean bl) {
        return false;
    }

    public int getIdButton1() {
        return this.models[3].getId(this.isMainScreen());
    }

    public int getIdButton2() {
        return this.models[5].getId(this.isMainScreen());
    }

    public ButtonModelApp getButton1() {
        return (ButtonModelApp)this.models[3].getModel(this.isMainScreen());
    }

    public LabelModelApp getLabelButton1() {
        return (LabelModelApp)this.models[4].getModel(this.isMainScreen());
    }

    public ButtonModelApp getButton2() {
        return (ButtonModelApp)this.models[5].getModel(this.isMainScreen());
    }

    public LabelModelApp getLabelButton2() {
        return (LabelModelApp)this.models[6].getModel(this.isMainScreen());
    }

    public ChoiceModelApp getTimeoutModel() {
        return (ChoiceModelApp)this.models[1].getModel(this.isMainScreen());
    }

    public ChoiceModelApp getButtonsModel() {
        return (ChoiceModelApp)this.models[0].getModel(this.isMainScreen());
    }

    public LabelModelApp getMessageModel() {
        return (LabelModelApp)this.models[2].getModel(this.isMainScreen());
    }

    public void flushModelGroup() {
        this.modelGroup.flush();
    }
}

