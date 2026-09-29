/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ButtonListener;
import java.util.Map;

public class TelLeftDrawerContextHandler
extends AbstractPhoneComponent
implements IActionProxyListener,
ButtonListener {
    private static final int CONTEXT_INTELLICALL;
    private static final int CONTEXT_FAVORITES;
    private static final int CONTEXT_ADB;
    private static final int CONTEXT_NUMBER_SPELLER;
    private static final int CONTEXT_SMS;
    private static final int CONTEXT_AUDI_SERVICE;
    private static final int CONTEXT_AUDI_CONNECT_NAVIGATOR;

    public TelLeftDrawerContextHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(1, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(5, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(10, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(11, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(12, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(36, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(13, this);
        this.getButtonModel(613876736).setButtonListener(this);
        this.getButtonModel(630653952).setButtonListener(this);
        this.getButtonModel(647431168).setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(1, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(5, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(10, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(11, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(12, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(36, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(13, this);
        this.getButtonModel(613876736).resetListener();
        this.getButtonModel(630653952).resetListener();
        this.getButtonModel(647431168).resetListener();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x3000100) {
            int n2;
            int n3 = n2 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationState() != null ? iGlobalTelephoneStateStruct.getActivationState().getTelActivationState() : 1;
            if (n2 != 5 && n2 != 2) {
                this.getChoiceModel(-1399454720).setValue(0);
            }
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1: {
                this.log.log(-2137614336, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (speller)", (long)0);
                this.getChoiceModel(-1399454720).setValue(3);
                break;
            }
            case 12: {
                this.log.log(-2137614336, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (service)", (long)0);
                this.getChoiceModel(-1399454720).setValue(5);
                break;
            }
            case 36: {
                this.log.log(-2137614336, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (service)", (long)0);
                this.getChoiceModel(-1399454720).setValue(7);
                break;
            }
            case 4: 
            case 5: 
            case 15: {
                this.log.log(-2137614336, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (tellicall)", 0L);
                this.getChoiceModel(-1399454720).setValue(0);
                break;
            }
            case 11: {
                this.log.log(-2137614336, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (adb)", (long)0);
                this.getChoiceModel(-1399454720).setValue(2);
                break;
            }
            case 10: {
                this.log.log(-2137614336, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (favorites)", 1L);
                this.getChoiceModel(-1399454720).setValue(1);
                break;
            }
            case 13: {
                this.log.log(-2137614336, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (sms)", (long)0);
                this.getChoiceModel(-1399454720).setValue(4);
                break;
            }
            default: {
                this.log.log(-2137614336, "[TelLeftDrawerContextHandler#actionProxyCallPerformed] unhandled method id %1", (long)n);
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 300836: {
                this.log.log(1078071040, "TelLeftDrawerContextHandler#keyTyped(): CONTEXT_INTELLICALL");
                this.getChoiceModel(-1399454720).setValue(0);
                this.getButtonModel(613876736).fireEvent(n3);
                break;
            }
            case 300837: {
                this.log.log(1078071040, "TelLeftDrawerContextHandler#keyTyped(): CONTEXT_FAVORITES");
                this.getChoiceModel(-1399454720).setValue(1);
                this.getButtonModel(630653952).fireEvent(n3);
                break;
            }
            case 300838: {
                this.log.log(1078071040, "TelLeftDrawerContextHandler#keyTyped(): CONTEXT_NUMBER_SPELLER");
                this.getChoiceModel(-1399454720).setValue(3);
                this.getButtonModel(647431168).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(-2137614336, "[TelLeftDrawerContextHandler#keyTyped(): unhandled modelId %1, keyId %2, terminalId %3", (long)n, (long)n2, (long)n3);
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

