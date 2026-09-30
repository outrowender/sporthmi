/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;

public class AbstractScreenAccess {
    static final int MODEL_TYPE_LABEL = 0;
    static final int MODEL_TYPE_LIST = 1;
    static final int MODEL_TYPE_RESOURCE_LOCATOR = 2;
    static final int MODEL_TYPE_CHOICE = 3;
    static final int MODEL_TYPE_BUTTON = 4;
    private final ChoiceModelApp screenTypeChoice;
    private final LogChannel logChannel;

    protected AbstractScreenAccess(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.screenTypeChoice = choiceModelApp;
        this.logChannel = logChannel;
    }

    public boolean isMainScreen() {
        return this.screenTypeChoice.getValue() == 0;
    }

    public boolean switchScreen(boolean bl) {
        int n;
        this.logChannel.log(1000000, "AbstractScreenAccess#switchScreen: switch to '%1' screen", (Object)(bl ? "Main" : "Option"));
        int n2 = n = bl ? 0 : 1;
        if (this.screenTypeChoice.getValue() == n) {
            return false;
        }
        this.screenTypeChoice.setValue(n);
        return true;
    }

    public void refreshModelGroup(ModelGroup modelGroup, ModelData[] modelDataArray) {
        boolean bl = this.isMainScreen();
        int n = modelDataArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ModelData modelData = modelDataArray[i2];
            if (modelData == null || !modelData.isAddedToModelGroup()) continue;
            modelGroup.replaceOrAdd(modelData.getModel(!bl), modelData.getModel(bl));
        }
    }

    static final class ModelData {
        private final boolean isAddedToModelGroup;
        private final HMIModelApp mainModel;
        private final HMIModelApp optionModel;
        private final int modelType;
        private final String description;
        private final int mainModelId;
        private final int optionModelId;

        public ModelData(OnlineModelBankAccess onlineModelBankAccess, String string, int n, boolean bl, int n2) {
            this(onlineModelBankAccess, string, n, bl, n2, n2);
        }

        public ModelData(OnlineModelBankAccess onlineModelBankAccess, String string, int n, boolean bl, int n2, int n3) {
            this.description = string;
            this.modelType = n;
            this.isAddedToModelGroup = bl;
            this.mainModelId = n2;
            this.optionModelId = n3;
            this.mainModel = this.getModel(onlineModelBankAccess, n, n2);
            this.optionModel = n2 == n3 ? this.mainModel : this.getModel(onlineModelBankAccess, n, n3);
        }

        private HMIModelApp getModel(OnlineModelBankAccess onlineModelBankAccess, int n, int n2) {
            switch (n) {
                case 0: {
                    return onlineModelBankAccess.getLabelModel(n2);
                }
                case 1: {
                    return onlineModelBankAccess.getListModel(n2);
                }
                case 2: {
                    return onlineModelBankAccess.getResourceLocatorModel(n2);
                }
                case 3: {
                    return onlineModelBankAccess.getChoiceModel(n2);
                }
                case 4: {
                    return onlineModelBankAccess.getButtonModel(n2);
                }
            }
            throw new IllegalArgumentException("modelType = " + n + " is unknown! Add it to case-statement above!");
        }

        public HMIModelApp getModel(boolean bl) {
            return bl ? this.mainModel : this.optionModel;
        }

        public int getId(boolean bl) {
            return bl ? this.mainModelId : this.optionModelId;
        }

        public boolean isAddedToModelGroup() {
            return this.isAddedToModelGroup;
        }

        public String toString() {
            return "ModelData [description=" + this.description + ", modelType=" + this.modelType + ", isAddedToModelGroup=" + this.isAddedToModelGroup + ", mainModelId=" + this.mainModelId + ", optionModelId=" + this.optionModelId + ", mainModel=" + this.mainModel + ", optionModel=" + this.optionModel + "]";
        }
    }
}

