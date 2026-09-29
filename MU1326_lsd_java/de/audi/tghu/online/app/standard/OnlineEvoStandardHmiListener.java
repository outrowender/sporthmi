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

    @Override
    public int[] getSpellerModels() {
        return new int[]{639443712, 605889280, 1830626048, 1813848832};
    }

    @Override
    public int[] getChoiceModels() {
        return new int[]{236790528};
    }

    @Override
    public int[] getButtonModels() {
        return new int[]{220013312, 538780416, 589112064, -1608703232};
    }

    @Override
    public int[] getListModels() {
        return new int[]{169681664, 488448768};
    }

    @Override
    public int[] getTextFieldModel() {
        return new int[0];
    }

    @Override
    public void setModelManager(AbstractModelManager abstractModelManager) {
        this.modelManager = abstractModelManager;
        this.init();
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#itemSelected given Index: %1", (long)n2);
        if (n == 488448768) {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#itemSelected model CONN_GATEWAY_USERS_BASE_LIST");
            if (n2 == 0) {
                ((OnlineEvoStandardModelHandler)this.modelManager).expandOrCollapseUserListModel();
            }
        } else if (n == 169681664) {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#itemSelected row %1", (Object)evoListRow);
            ((OnlineEvoStandardModelHandler)this.modelManager).selectService(n2);
        } else {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#itemSelected invalid model %1...ignoring call", (long)n);
        }
        this.modelManager.fireEvent(n, n4);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 236790528) {
            this.controller.changeApplicationState(this.modelManager.getChoiceModel(n).getValue() != 1);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 220013312) {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#keyTyped Jump to context");
            this.controller.initiateHmiJump();
            this.modelManager.fireEvent(n, n3);
        } else if (n == 538780416) {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#keyTyped ResetMainUser");
            this.controller.resetMainUser();
            this.modelManager.fireEvent(n, n3);
        } else if (n == 589112064) {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#keyTyped login");
            String string = this.modelManager.getSpellerModel(639443712).getText();
            String string2 = this.modelManager.getSpellerModel(605889280).getText();
            this.controller.setMainUser(string, string2);
            this.modelManager.fireEvent(n, n3);
        } else if (n == 639443712 || n == 605889280) {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#keyTyped userNameSpeller");
            this.modelManager.fireEvent(n, n3);
        } else if (n == -1608703232) {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#keyTyped ManuallUserList");
            this.modelManager.fireEvent(n, n3);
            this.controller.triggerUpdateUserlist();
        } else {
            this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#keyTyped invalid model. Ignore");
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(1078071040, "OnlineEvoStandardHmiListener#textChanged: %1", (Object)string);
        if (n == 605889280 || n == 1813848832) {
            this.handlePasswordSpellerInput(string, 572334848);
            this.updateSpellerText(605889280, string, n2);
            this.modelManager.setLabelModelText(1210000128, string);
        } else if (n == 639443712 || n == 1830626048) {
            this.modelManager.setTextFieldText(656220928, string);
            this.updateSpellerText(639443712, string, n2);
        }
        if (n == 1830626048 || n == 1813848832) {
            this.modelManager.fireEvent(n, n2);
        }
    }
}

