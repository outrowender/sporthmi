/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.auth.AbstractHMIListener;
import de.audi.tghu.online.app.osr.auth.AbstractModelManager;
import de.audi.tghu.online.app.osr.auth.AuthenticationModelManager;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;

public class AuthenticationHMIListener
extends AbstractHMIListener {
    private T2AuthenticationService controller;
    private String currentPassword;
    private static final int HINT_SPELLER_CLOSE_DISABLED = 1;

    public AuthenticationHMIListener(LogChannel logChannel, T2AuthenticationService t2AuthenticationService) {
        super(logChannel);
        this.controller = t2AuthenticationService;
    }

    public void setModelManager(AbstractModelManager abstractModelManager) {
        this.modelManager = abstractModelManager;
        this.init();
    }

    public void init() {
        super.init();
        this.modelManager.hmiService.getMenuModel(2301184).setListener(this);
        this.modelManager.hmiService.getSpellerModel(2300923).addHint(1);
    }

    public int[] getSpellerModels() {
        return new int[]{2300936, 2300931, 2300923, 2300979, 2301225, 2301226};
    }

    public int[] getChoiceModels() {
        return new int[]{2300932, 2300935, 2300928, 2300961, 2301597, 2301637, 2301595};
    }

    public int[] getTextFieldModel() {
        return new int[]{2301130, 2301129};
    }

    public int[] getButtonModels() {
        return new int[]{2300933, 2300934, 2300930, 2300981, 2301089, 2301133, 2301202, 2301594, 2301638};
    }

    public int[] getListModels() {
        return new int[]{2300937, 2300929};
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#keyTyped: model %1, key %2", (long)n, (long)n2);
        switch (n) {
            case 2300923: 
            case 2301133: {
                String string = this.modelManager.getSpellerModel(2300923).getText();
                this.controller.handlePairingCodeFromSpeller(string);
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2300930: {
                String string = this.modelManager.getSpellerModel(2300936).getText();
                String string2 = this.modelManager.getSpellerModel(2300931).getText();
                this.controller.handleCredentialsFromSpeller(string, string2);
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2300936: {
                this.modelManager.fireEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(100000, "AuthenticationHMIListener#keyTyped: Received unexpected key typed event model %1, key %2", (long)n, (long)n2);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 2300927 || n == 2300935 || n == 2300932 || n == 2300961) {
            this.modelManager.getChoiceModel(n).setValue(this.modelManager.getChoiceModel(n).getValue() ^ 1);
        }
        if (n == 2301595) {
            this.modelManager.getChoiceModel(2301595).setValue(1);
            this.modelManager.getChoiceModel(2301637).setValue(0);
            this.modelManager.getChoiceModel(2301597).setValue(0);
        } else if (n == 2301597) {
            this.modelManager.getChoiceModel(2301595).setValue(0);
            this.modelManager.getChoiceModel(2301637).setValue(0);
            this.modelManager.getChoiceModel(2301597).setValue(1);
        } else if (n == 2301637) {
            this.modelManager.getChoiceModel(2301595).setValue(0);
            this.modelManager.getChoiceModel(2301637).setValue(1);
            this.modelManager.getChoiceModel(2301597).setValue(0);
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#keyPressed: ");
        switch (n) {
            case 2300934: {
                this.controller.storePrivacySettings(false);
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2300933: {
                this.controller.storePrivacySettings(true);
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2300981: {
                String string = this.modelManager.getSpellerModel(2300979).getText();
                this.controller.startPortalRegistration(string);
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2301089: {
                this.controller.deleteFocusedUser();
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2301202: {
                this.controller.cancelActiveCommand();
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2301594: {
                this.storeSettings();
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2301638: {
                this.controller.deleteCurrentUser();
                break;
            }
            default: {
                this.logChannel.log(100000, "AuthenticationHMIListener#keyPressed: Received unexpected key pressed event model %1, key %2", (long)n, (long)n2);
            }
        }
    }

    private void storeSettings() {
        if (this.modelManager.getChoiceModel(2301595).getValue() == 1) {
            this.logChannel.log(1000000, "AuthenticationHMIListener#storeSettings: store bt devices");
            this.controller.storePrivacySettings(true);
        } else if (this.modelManager.getChoiceModel(2301597).getValue() == 1) {
            this.logChannel.log(1000000, "AuthenticationHMIListener#storeSettings: persist the pairing code");
            this.modelManager.getChoiceModel(2300932).setValue(1);
            this.controller.storePrivacySettings(false);
        } else if (this.modelManager.getChoiceModel(2301637).getValue() == 1) {
            this.logChannel.log(1000000, "AuthenticationHMIListener#storeSettings: store username");
            this.modelManager.getChoiceModel(2300935).setValue(1);
            this.controller.storePrivacySettings(false);
        }
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#itemSelected (model: %1, i: %2, c: %3): called", (long)n, (long)n2, (long)n3);
        if (n == 2300937) {
            ((AuthenticationModelManager)this.modelManager).checkCredentialsForSelectedUser(n2);
        } else if (n == 2300929) {
            evoListRow.setInteger(2, evoListRow.getInteger(2) ^ 1);
            this.modelManager.hmiService.getBaseListModel(2300929).setRow(n2, evoListRow);
        }
        this.modelManager.fireEvent(n, n4);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#keyReleased: ");
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#textChanged: %1", (Object)string);
        if (n == 2300931 || n == 2301226) {
            this.handlePasswordSpellerInput(string, 2301129);
            this.updateSpellerText(2300931, string, n2);
        } else if (n == 2300936 || n == 2301225) {
            this.modelManager.setTextFieldText(2301130, string);
            this.updateSpellerText(2300936, string, n2);
        } else if (n == 2300923) {
            this.updateSpellerText(n, string, n2);
        }
        if (n == 2301225 || n == 2301226) {
            this.modelManager.fireEvent(n, n2);
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#focusedCharacter: ");
    }

    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#commandPressed: ");
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "AuthenticationHMIListener#itemReleased: ");
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == 2300937) {
            ((AuthenticationModelManager)this.modelManager).setFocusedUser(n2);
        }
    }

    public void itemFocused(int n, int n2, long l, int n3) {
    }
}

