/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;

public class OnlineModelBankAccess {
    private final HMIService hmiService;

    public static int getUpdatingIconChoiceId() {
        return 1494950656;
    }

    public int getViewTextDisplayAction1ButtonId() {
        return 605692672;
    }

    public int getViewTextDisplayAction1LabelId() {
        return 622469888;
    }

    public int getViewTextDisplayAction2ButtonId() {
        return 639247104;
    }

    public int getViewTextDisplayAction2LabelId() {
        return 656024320;
    }

    public int getViewTextDisplayMsgLabelId() {
        return 672801536;
    }

    public int getViewTextDisplaySubTitle1LabelId() {
        return 840573696;
    }

    public int getViewTextDisplaySubTitle2LabelId() {
        return 857350912;
    }

    public int getCurrentViewChoiceId() {
        return -1508367616;
    }

    public OnlineModelBankAccess(HMIService hMIService) {
        this.hmiService = hMIService;
    }

    public ListModelApp getListModel(int n) {
        return this.hmiService.getListModel(n);
    }

    public BaseListModelApp getBaseListModel(int n) {
        return this.hmiService.getBaseListModel(n);
    }

    public LabelModelApp getLabelModel(int n) {
        return this.hmiService.getLabelModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.hmiService.getChoiceModel(n);
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.hmiService.getButtonModel(n);
    }

    public VirtualButtonModelApp getVirtualButtonModel(int n) {
        return this.hmiService.getVirtualButtonModel(n);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return this.hmiService.getSpellerModel(n);
    }

    public ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return this.hmiService.getResourceLocatorModel(n);
    }

    public HMIModelApp getModelApp(int n) {
        return this.hmiService.getModelApp(n);
    }

    public RangeModelApp getRangeModel(int n) {
        return this.hmiService.getRangeModel(n);
    }

    public HMIModel getModel(int n, int n2) {
        return this.hmiService.getModel(n, n2);
    }

    public HMIModel getModel(int n) {
        return this.hmiService.getModel(n);
    }
}

