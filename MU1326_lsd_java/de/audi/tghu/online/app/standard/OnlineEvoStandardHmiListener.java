/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.auth.AbstractHMIListener;
import de.audi.tghu.online.app.osr.auth.AbstractModelManager;
import de.audi.tghu.online.app.standard.IStandardController;
import de.audi.tghu.online.app.standard.OnlineEvoStandardModelHandler;

public class OnlineEvoStandardHmiListener
extends AbstractHMIListener {
    IStandardController controller;

    public OnlineEvoStandardHmiListener(LogChannel logChannel, IStandardController iStandardController) {
        super(logChannel);
        this.controller = iStandardController;
    }

    public int[] getSpellerModels() {
        return new int[]{2301222, 2301220, 2301293, 2301292};
    }

    public int[] getChoiceModels() {
        return new int[]{2301198};
    }

    public int[] getButtonModels() {
        return new int[]{2301197, 2301216, 2301219, 2301344};
    }

    public int[] getListModels() {
        return new int[]{2301194, 2301213};
    }

    public int[] getTextFieldModel() {
        return new int[0];
    }

    public void setModelManager(AbstractModelManager abstractModelManager) {
        this.modelManager = abstractModelManager;
        this.init();
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#itemSelected given Index: %1", (long)n2);
        if (n == 2301213) {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#itemSelected model CONN_GATEWAY_USERS_BASE_LIST");
            if (n2 == 0) {
                ((OnlineEvoStandardModelHandler)this.modelManager).expandOrCollapseUserListModel();
            }
        } else if (n == 2301194) {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#itemSelected row %1", (Object)evoListRow);
            ((OnlineEvoStandardModelHandler)this.modelManager).selectService(n2);
        } else {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#itemSelected invalid model %1...ignoring call", (long)n);
        }
        this.modelManager.fireEvent(n, n4);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 2301198) {
            this.controller.changeApplicationState(this.modelManager.getChoiceModel(n).getValue() != 1);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == 2301197) {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#keyTyped Jump to context");
            this.controller.initiateHmiJump();
            this.modelManager.fireEvent(n, n3);
        } else if (n == 2301216) {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#keyTyped ResetMainUser");
            this.controller.resetMainUser();
            this.modelManager.fireEvent(n, n3);
        } else if (n == 2301219) {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#keyTyped login");
            String string = this.modelManager.getSpellerModel(2301222).getText();
            String string2 = this.modelManager.getSpellerModel(2301220).getText();
            this.controller.setMainUser(string, string2);
            this.modelManager.fireEvent(n, n3);
        } else if (n == 2301222 || n == 2301220) {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#keyTyped userNameSpeller");
            this.modelManager.fireEvent(n, n3);
        } else if (n == 2301344) {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#keyTyped ManuallUserList");
            this.modelManager.fireEvent(n, n3);
            this.controller.triggerUpdateUserlist();
        } else {
            this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#keyTyped invalid model. Ignore");
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(1000000, "OnlineEvoStandardHmiListener#textChanged: %1", (Object)string);
        if (n == 2301220 || n == 2301292) {
            this.handlePasswordSpellerInput(string, 2301218);
            this.updateSpellerText(2301220, string, n2);
            this.modelManager.setLabelModelText(2301768, string);
        } else if (n == 2301222 || n == 2301293) {
            this.modelManager.setTextFieldText(2301223, string);
            this.updateSpellerText(2301222, string, n2);
        }
        if (n == 2301293 || n == 2301292) {
            this.modelManager.fireEvent(n, n2);
        }
    }
}

