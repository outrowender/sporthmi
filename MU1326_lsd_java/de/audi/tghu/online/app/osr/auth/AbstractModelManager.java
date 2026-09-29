/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.tghu.online.app.osr.auth.AbstractHMIListener;

public class AbstractModelManager {
    protected IHMIServiceApp hmiService;

    public AbstractModelManager(HMIService hMIService) {
        this.hmiService = hMIService;
    }

    public void initSpellerModels(int[] nArray, AbstractHMIListener abstractHMIListener) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.hmiService.getSpellerModel(nArray[i2]).setSpellerListener(abstractHMIListener);
        }
    }

    public void initChoiceModels(int[] nArray, AbstractHMIListener abstractHMIListener) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.hmiService.getChoiceModel(nArray[i2]).setChoiceListener(abstractHMIListener);
        }
    }

    public void initButtonModels(int[] nArray, AbstractHMIListener abstractHMIListener) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.hmiService.getButtonModel(nArray[i2]).setButtonListener(abstractHMIListener);
        }
    }

    public void initListModels(int[] nArray, AbstractHMIListener abstractHMIListener) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.hmiService.getBaseListModel(nArray[i2]).setListener(abstractHMIListener);
        }
    }

    public void fireEvent(int n, int n2) {
        this.hmiService.getModelApp(n).fireEvent(n2);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return this.hmiService.getSpellerModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.hmiService.getChoiceModel(n);
    }

    public void updateSpellerText(int n, String string) {
        this.hmiService.getSpellerModel(n).setText(string);
    }

    public void setLabelModelText(int n, String string) {
        this.hmiService.getLabelModel(n).setText(string);
    }

    public void initTextFieldModels(int[] nArray, AbstractHMIListener abstractHMIListener) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.hmiService.getTextfieldModel(nArray[i2]).setButtonListener(abstractHMIListener);
        }
    }

    public void setTextFieldText(int n, String string) {
        this.hmiService.getTextfieldModel(n).setText1(string);
    }
}

