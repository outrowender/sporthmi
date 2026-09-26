/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractScreenAccess;
import de.audi.app.online.evo.AbstractScreenAccess$ModelData;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class HMIViewTextDisplayScreenAccess
extends AbstractScreenAccess {
    private static final int MODEL_SUBTITLE_LABEL;
    private static final int MODEL_BREADCRUMB_LABEL;
    private static final int MODEL_ACTION1_BUTTON;
    private static final int MODEL_ACTION1_LABEL;
    private static final int MODEL_ACTION2_BUTTON;
    private static final int MODEL_ACTION2_LABEL;
    private static final int MODEL_MESSAGE_LABEL;
    private static final int MODEL_COUNT;
    private AbstractScreenAccess$ModelData[] models = new AbstractScreenAccess$ModelData[7];

    public HMIViewTextDisplayScreenAccess(LogChannel logChannel, RemoteHMIService remoteHMIService, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, ChoiceModelApp choiceModelApp) {
        super(choiceModelApp, logChannel);
        this.models[0] = new AbstractScreenAccess$ModelData(onlineModelBankAccess, "subtitle", 0, true, onlineModelBankAccess.getViewTextDisplaySubTitle1LabelId(), 1914446592);
        this.models[1] = new AbstractScreenAccess$ModelData(onlineModelBankAccess, "breadCrumb", 0, true, onlineModelBankAccess.getViewTextDisplaySubTitle2LabelId(), 1897669376);
        this.models[2] = new AbstractScreenAccess$ModelData(onlineModelBankAccess, "action1Button", 4, true, onlineModelBankAccess.getViewTextDisplayAction1ButtonId(), 1830560512);
        this.models[3] = new AbstractScreenAccess$ModelData(onlineModelBankAccess, "action1Label", 0, true, onlineModelBankAccess.getViewTextDisplayAction1LabelId(), 1813783296);
        this.models[4] = new AbstractScreenAccess$ModelData(onlineModelBankAccess, "action2Button", 4, true, onlineModelBankAccess.getViewTextDisplayAction2ButtonId(), 1847337728);
        this.models[5] = new AbstractScreenAccess$ModelData(onlineModelBankAccess, "action2Label", 0, true, onlineModelBankAccess.getViewTextDisplayAction2LabelId(), 1864114944);
        this.models[6] = new AbstractScreenAccess$ModelData(onlineModelBankAccess, "message", 0, true, onlineModelBankAccess.getViewTextDisplayMsgLabelId(), 1880892160);
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

