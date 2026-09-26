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
    private static final int HINT_SPELLER_CLOSE_DISABLED;

    public AuthenticationHMIListener(LogChannel logChannel, T2AuthenticationService t2AuthenticationService) {
        super(logChannel);
        this.controller = t2AuthenticationService;
    }

    @Override
    public void setModelManager(AbstractModelManager abstractModelManager) {
        this.modelManager = abstractModelManager;
        this.init();
    }

    @Override
    public void init() {
        super.init();
        this.modelManager.hmiService.getMenuModel(1909504).setListener(this);
        this.modelManager.hmiService.getSpellerModel(-82107648).addHint(1);
    }

    @Override
    public int[] getSpellerModels() {
        return new int[]{136061696, 52175616, -82107648, 857481984, 689775360, 706552576};
    }

    @Override
    public int[] getChoiceModels() {
        return new int[]{68952832, 119284480, 1843968, 555492096, -1658969344, -987880704, -1692523776};
    }

    @Override
    public int[] getTextFieldModel() {
        return new int[]{-904125696, -920902912};
    }

    @Override
    public int[] getButtonModels() {
        return new int[]{85730048, 102507264, 35398400, 891036416, -1591991552, -853794048, 303899392, -1709300992, -971103488};
    }

    @Override
    public int[] getListModels() {
        return new int[]{152838912, 18621184};
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#keyTyped: model %1, key %2", (long)n, (long)n2);
        switch (n) {
            case 2300923: 
            case 2301133: {
                String string = this.modelManager.getSpellerModel(-82107648).getText();
                this.controller.handlePairingCodeFromSpeller(string);
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2300930: {
                String string = this.modelManager.getSpellerModel(136061696).getText();
                String string2 = this.modelManager.getSpellerModel(52175616).getText();
                this.controller.handleCredentialsFromSpeller(string, string2);
                this.modelManager.fireEvent(n, n3);
                break;
            }
            case 2300936: {
                this.modelManager.fireEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "AuthenticationHMIListener#keyTyped: Received unexpected key typed event model %1, key %2", (long)n, (long)n2);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == -14998784 || n == 119284480 || n == 68952832 || n == 555492096) {
            this.modelManager.getChoiceModel(n).setValue(this.modelManager.getChoiceModel(n).getValue() ^ 1);
        }
        if (n == -1692523776) {
            this.modelManager.getChoiceModel(-1692523776).setValue(1);
            this.modelManager.getChoiceModel(-987880704).setValue(0);
            this.modelManager.getChoiceModel(-1658969344).setValue(0);
        } else if (n == -1658969344) {
            this.modelManager.getChoiceModel(-1692523776).setValue(0);
            this.modelManager.getChoiceModel(-987880704).setValue(0);
            this.modelManager.getChoiceModel(-1658969344).setValue(1);
        } else if (n == -987880704) {
            this.modelManager.getChoiceModel(-1692523776).setValue(0);
            this.modelManager.getChoiceModel(-987880704).setValue(1);
            this.modelManager.getChoiceModel(-1658969344).setValue(0);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#keyPressed: ");
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
                String string = this.modelManager.getSpellerModel(857481984).getText();
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
                this.logChannel.log(-1601830656, "AuthenticationHMIListener#keyPressed: Received unexpected key pressed event model %1, key %2", (long)n, (long)n2);
            }
        }
    }

    private void storeSettings() {
        if (this.modelManager.getChoiceModel(-1692523776).getValue() == 1) {
            this.logChannel.log(1078071040, "AuthenticationHMIListener#storeSettings: store bt devices");
            this.controller.storePrivacySettings(true);
        } else if (this.modelManager.getChoiceModel(-1658969344).getValue() == 1) {
            this.logChannel.log(1078071040, "AuthenticationHMIListener#storeSettings: persist the pairing code");
            this.modelManager.getChoiceModel(68952832).setValue(1);
            this.controller.storePrivacySettings(false);
        } else if (this.modelManager.getChoiceModel(-987880704).getValue() == 1) {
            this.logChannel.log(1078071040, "AuthenticationHMIListener#storeSettings: store username");
            this.modelManager.getChoiceModel(119284480).setValue(1);
            this.controller.storePrivacySettings(false);
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#itemSelected (model: %1, i: %2, c: %3): called", (long)n, (long)n2, (long)n3);
        if (n == 152838912) {
            ((AuthenticationModelManager)this.modelManager).checkCredentialsForSelectedUser(n2);
        } else if (n == 18621184) {
            evoListRow.setInteger(2, evoListRow.getInteger(2) ^ 1);
            this.modelManager.hmiService.getBaseListModel(18621184).setRow(n2, evoListRow);
        }
        this.modelManager.fireEvent(n, n4);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#keyReleased: ");
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#textChanged: %1", (Object)string);
        if (n == 52175616 || n == 706552576) {
            this.handlePasswordSpellerInput(string, -920902912);
            this.updateSpellerText(52175616, string, n2);
        } else if (n == 136061696 || n == 689775360) {
            this.modelManager.setTextFieldText(-904125696, string);
            this.updateSpellerText(136061696, string, n2);
        } else if (n == -82107648) {
            this.updateSpellerText(n, string, n2);
        }
        if (n == 689775360 || n == 706552576) {
            this.modelManager.fireEvent(n, n2);
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#focusedCharacter: ");
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#commandPressed: ");
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "AuthenticationHMIListener#itemReleased: ");
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == 152838912) {
            ((AuthenticationModelManager)this.modelManager).setFocusedUser(n2);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
    }
}

