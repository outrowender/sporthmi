/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;

final class AbstractScreenAccess$ModelData {
    private final boolean isAddedToModelGroup;
    private final HMIModelApp mainModel;
    private final HMIModelApp optionModel;
    private final int modelType;
    private final String description;
    private final int mainModelId;
    private final int optionModelId;

    public AbstractScreenAccess$ModelData(OnlineModelBankAccess onlineModelBankAccess, String string, int n, boolean bl, int n2) {
        this(onlineModelBankAccess, string, n, bl, n2, n2);
    }

    public AbstractScreenAccess$ModelData(OnlineModelBankAccess onlineModelBankAccess, String string, int n, boolean bl, int n2, int n3) {
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
        throw new IllegalArgumentException(new StringBuffer().append("modelType = ").append(n).append(" is unknown! Add it to case-statement above!").toString());
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
        return new StringBuffer().append("ModelData [description=").append(this.description).append(", modelType=").append(this.modelType).append(", isAddedToModelGroup=").append(this.isAddedToModelGroup).append(", mainModelId=").append(this.mainModelId).append(", optionModelId=").append(this.optionModelId).append(", mainModel=").append(this.mainModel).append(", optionModel=").append(this.optionModel).append("]").toString();
    }
}

