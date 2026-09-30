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

public class HMIViewTextDisplayScreenAccess
extends AbstractScreenAccess {
    private static final int MODEL_SUBTITLE_LABEL = 0;
    private static final int MODEL_BREADCRUMB_LABEL = 1;
    private static final int MODEL_ACTION1_BUTTON = 2;
    private static final int MODEL_ACTION1_LABEL = 3;
    private static final int MODEL_ACTION2_BUTTON = 4;
    private static final int MODEL_ACTION2_LABEL = 5;
    private static final int MODEL_MESSAGE_LABEL = 6;
    private static final int MODEL_COUNT = 7;
    private AbstractScreenAccess.ModelData[] models = new AbstractScreenAccess.ModelData[7];

    public HMIViewTextDisplayScreenAccess(LogChannel logChannel, RemoteHMIService remoteHMIService, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, ChoiceModelApp choiceModelApp) {
        super(choiceModelApp, logChannel);
        this.models[0] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "subtitle", 0, true, onlineModelBankAccess.getViewTextDisplaySubTitle1LabelId(), 2301042);
        this.models[1] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "breadCrumb", 0, true, onlineModelBankAccess.getViewTextDisplaySubTitle2LabelId(), 2301041);
        this.models[2] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action1Button", 4, true, onlineModelBankAccess.getViewTextDisplayAction1ButtonId(), 2301037);
        this.models[3] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action1Label", 0, true, onlineModelBankAccess.getViewTextDisplayAction1LabelId(), 2301036);
        this.models[4] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action2Button", 4, true, onlineModelBankAccess.getViewTextDisplayAction2ButtonId(), 2301038);
        this.models[5] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "action2Label", 0, true, onlineModelBankAccess.getViewTextDisplayAction2LabelId(), 2301039);
        this.models[6] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "message", 0, true, onlineModelBankAccess.getViewTextDisplayMsgLabelId(), 2301040);
        this.refreshModelGroup(modelGroup, this.models);
    }

    public ButtonModelApp getAction1Button() {
        return (ButtonModelApp)this.models[2].getModel(this.isMainScreen());
    }

    public LabelModelApp getAction1Label() {
        return (LabelModelApp)this.models[3].getModel(this.isMainScreen());
    }

    public ButtonModelApp getAction2Button() {
        return (ButtonModelApp)this.models[4].getModel(this.isMainScreen());
    }

    public LabelModelApp getAction2Label() {
        return (LabelModelApp)this.models[5].getModel(this.isMainScreen());
    }

    public LabelModelApp getSubtitleModel() {
        return (LabelModelApp)this.models[0].getModel(this.isMainScreen());
    }

    public LabelModelApp getMessageModel() {
        return (LabelModelApp)this.models[6].getModel(this.isMainScreen());
    }

    public LabelModelApp getBreadCrumbModel() {
        return (LabelModelApp)this.models[1].getModel(this.isMainScreen());
    }
}

