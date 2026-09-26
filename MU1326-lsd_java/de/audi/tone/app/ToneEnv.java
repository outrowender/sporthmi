/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.variant.IGUIVariantProvider;

public class ToneEnv {
    private final IFrameworkAccess framework;
    private final IHMIServiceApp hmiService;
    private final IGUIVariantProvider variantProvider;
    public LogChannel lcMain;
    public LogChannel lcHMI;
    public LogChannel lcDSI;

    public ToneEnv(IFrameworkAccess iFrameworkAccess, IGUIVariantProvider iGUIVariantProvider) {
        this.framework = iFrameworkAccess;
        this.hmiService = iFrameworkAccess.getHmiServiceApp();
        this.variantProvider = iGUIVariantProvider;
        this.lcDSI = iFrameworkAccess.getLogChannel("App.Tone.DSI");
        this.lcHMI = iFrameworkAccess.getLogChannel("App.Tone.HMI");
        this.lcMain = iFrameworkAccess.getLogChannel("App.Tone.Main");
    }

    public int getSysConst(int n) {
        return this.framework.getSysConst(n);
    }

    public boolean isFrontUnit() {
        return this.framework.isFrontMU();
    }

    public boolean isRearUnit() {
        return !this.framework.isFrontMU();
    }

    public boolean isAsia() {
        return this.framework.isAsia();
    }

    public boolean isHigh() {
        return this.framework.isEvoHigh();
    }

    public boolean isPorsche() {
        return this.framework.isPorsche();
    }

    public boolean isStd() {
        return this.framework.isEvoStd();
    }

    public HMIModelApp getModel(int n) {
        return this.hmiService.getModelApp(n);
    }

    HMIModelApp getModel(int n, int n2) {
        return this.hmiService.getModelApp(n, n2);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.hmiService.getChoiceModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n, int n2) {
        return this.hmiService.getChoiceModel(n, n2);
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.hmiService.getButtonModel(n);
    }

    public LabelModelApp getLabelModel(int n) {
        return this.hmiService.getLabelModel(n);
    }

    public RangeModelApp getRangeModel(int n) {
        return this.hmiService.getRangeModel(n);
    }

    public RangeModelApp getRangeModel(int n, int n2) {
        return this.hmiService.getRangeModel(n, n2);
    }

    public IStorageAccess getStorageAccess() {
        return this.framework.getStorageMgr();
    }

    public RangeModel2DApp getRangeModel2D(int n, int n2) {
        return (RangeModel2DApp)this.hmiService.getModelApp(n, n2);
    }

    public ChoiceModelApp getSystemChoiceModel(int n, int n2) {
        return this.getChoiceModel(n, n2);
    }

    public ChoiceModelApp getSystemChoiceModel(int n) {
        return this.getChoiceModel(n);
    }

    public RangeModelApp getSystemRangeModel(int n, int n2) {
        return this.getRangeModel(n, n2);
    }

    public RangeModelApp getSystemRangeModel(int n) {
        return this.getRangeModel(n);
    }

    public HMIModelApp getHMIServiceModel(int n) {
        return this.getModel(n);
    }

    public void showPopup(int n) {
        this.hmiService.showPopup(n);
    }

    public void showPartialPopup(int n) {
        this.hmiService.showPartialPopup(0, n);
    }

    public void removePopup(int n) {
        this.hmiService.removePopup(n);
    }

    public void removePartialPopup(int n) {
        this.hmiService.removePartialPopup(0, n);
    }

    public String getTranslatedText(int n, String string) {
        String string2;
        if (this.hmiService == null || this.variantProvider == null) {
            this.lcHMI.log(10000, "ToneEnv#getTranslatedText() - failed to translate text");
            return string;
        }
        int n2 = this.variantProvider.getTextConstantsMapper().mapToVariant(n);
        this.lcHMI.log(-2137614336, "ToneEnv#getTranslatedText() - mapped id %1 to %2", (long)n, (long)n2);
        if (n2 == -1) {
            this.lcHMI.log(-1601830656, "ToneEnv#getTranslatedText() - textID %1 is not variant-specific, use it directly!", (long)n);
            n2 = n;
        }
        if ((string2 = this.hmiService.getText(n2)) == null || string2.equals("")) {
            this.lcHMI.log(10000, "ToneEnv#getTranslatedText() - ID %1 could not be resolved! ", (long)n2);
            string2 = string;
        }
        return string2;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }
}

