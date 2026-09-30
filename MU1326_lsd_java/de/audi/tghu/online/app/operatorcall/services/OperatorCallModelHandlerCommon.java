/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.services;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractBaseModelHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;

public class OperatorCallModelHandlerCommon
extends AbstractBaseModelHandler {
    private TelephoneHandler telHandler;
    public static final int MIC_NOT_MUTED = 0;
    public static final int MIC_MUTED = 1;

    public OperatorCallModelHandlerCommon(HMIService hMIService, TelephoneHandler telephoneHandler) {
        super(hMIService);
        this.telHandler = telephoneHandler;
        if (telephoneHandler != null) {
            this.telHandler.setHmiService(hMIService);
        }
    }

    protected int[] getButtonIdsToRegister() {
        return new int[]{2301262, 2301263};
    }

    protected int[] getTiledListIdsToRegister() {
        return null;
    }

    protected void buttonKeyPressed(int n) {
        if (this.telHandler == null) {
            this.logChannel.log(10000, "OperatorCallModelHandlerCommon#keyPressed: telHandler is null!");
        } else {
            switch (n) {
                case 2301262: {
                    this.logChannel.log(1000000, "OperatorCallModelHandlerCommon#keyPressed: mute button pressed", (long)n);
                    this.setModelName("OPERATOR_MUTE_BUTTON");
                    this.telHandler.muteMicrophone(true);
                    this.logChannel.log(1000000, "OperatorCallModelHandlerCommon#keyPressed: set unmute button visible");
                    this.hmiService.getChoiceModel(2301761).setValue(1);
                    break;
                }
                case 2301263: {
                    this.logChannel.log(1000000, "OperatorCallModelHandlerCommon#keyPressed: unmute button pressed", (long)n);
                    this.setModelName("OPERATOR_UNMUTE_BUTTON");
                    this.telHandler.muteMicrophone(false);
                    this.logChannel.log(1000000, "OperatorCallModelHandlerCommon#keyPressed: set mute button visible");
                    this.hmiService.getChoiceModel(2301761).setValue(0);
                    break;
                }
                default: {
                    this.logChannel.log(100000, "OperatorCallModelHandlerCommon#keyPressed: unknown button (%1) pressed", (long)n);
                }
            }
        }
    }

    protected void listItemSelected(EvoListRow evoListRow, int n, int n2) {
    }

    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
    }

    public void showPopup(int n) {
    }

    public void setCurrentServiceType(int n) {
        this.setChoiceStatus(5535, "OPERATOR_MODE_CHOICE", 1);
        this.setChoiceValue(5535, "OPERATOR_MODE_CHOICE", n);
    }

    public void deleteCurrentServiceType() {
        this.setChoiceStatus(5535, "OPERATOR_MODE_CHOICE", 0);
    }

    public int getCurrentServiceType() {
        return this.getChoiceValue(5535);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    protected void optionKeyPressed(int n, int n2, int n3) {
    }

    protected void registerMiniApps() {
    }

    protected void menuModelItemFocused(int n, long l, int n2) {
    }

    protected int[] getMenuModelIdsToRegister() {
        return new int[0];
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    protected int[] getChoiceIdsToRegister() {
        return new int[0];
    }

    protected void choiceModelItemSelected(int n, int n2, int n3) {
    }

    public void setTerminalMode(boolean bl) {
        if (bl) {
            this.setChoiceValue(2301741, "OPERATOR_CALL_TERMINAL_MODE", 1);
        } else {
            this.setChoiceValue(2301741, "OPERATOR_CALL_TERMINAL_MODE", 0);
        }
    }
}

