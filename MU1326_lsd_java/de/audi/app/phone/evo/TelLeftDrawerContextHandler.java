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
    private static final int CONTEXT_INTELLICALL = 0;
    private static final int CONTEXT_FAVORITES = 1;
    private static final int CONTEXT_ADB = 2;
    private static final int CONTEXT_NUMBER_SPELLER = 3;
    private static final int CONTEXT_SMS = 4;
    private static final int CONTEXT_AUDI_SERVICE = 5;
    private static final int CONTEXT_AUDI_CONNECT_NAVIGATOR = 7;

    public TelLeftDrawerContextHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(1, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(5, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(10, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(11, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(12, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(36, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(13, this);
        this.getButtonModel(300836).setButtonListener(this);
        this.getButtonModel(300837).setButtonListener(this);
        this.getButtonModel(300838).setButtonListener(this);
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(1, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(5, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(10, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(11, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(12, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(36, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(13, this);
        this.getButtonModel(300836).resetListener();
        this.getButtonModel(300837).resetListener();
        this.getButtonModel(300838).resetListener();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 65539) {
            int n2;
            int n3 = n2 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationState() != null ? iGlobalTelephoneStateStruct.getActivationState().getTelActivationState() : 1;
            if (n2 != 5 && n2 != 2) {
                this.getChoiceModel(300716).setValue(0);
            }
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1: {
                this.log.log(10000000, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (speller)", 3L);
                this.getChoiceModel(300716).setValue(3);
                break;
            }
            case 12: {
                this.log.log(10000000, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (service)", 5L);
                this.getChoiceModel(300716).setValue(5);
                break;
            }
            case 36: {
                this.log.log(10000000, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (service)", 7L);
                this.getChoiceModel(300716).setValue(7);
                break;
            }
            case 4: 
            case 5: 
            case 15: {
                this.log.log(10000000, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (tellicall)", 0L);
                this.getChoiceModel(300716).setValue(0);
                break;
            }
            case 11: {
                this.log.log(10000000, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (adb)", 2L);
                this.getChoiceModel(300716).setValue(2);
                break;
            }
            case 10: {
                this.log.log(10000000, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (favorites)", 1L);
                this.getChoiceModel(300716).setValue(1);
                break;
            }
            case 13: {
                this.log.log(10000000, "TelLeftDrawerContextHandler#actionProxyCallPerformed(): Setting active hmi context choice to %1 (sms)", 4L);
                this.getChoiceModel(300716).setValue(4);
                break;
            }
            default: {
                this.log.log(10000000, "[TelLeftDrawerContextHandler#actionProxyCallPerformed] unhandled method id %1", (long)n);
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 300836: {
                this.log.log(1000000, "TelLeftDrawerContextHandler#keyTyped(): CONTEXT_INTELLICALL");
                this.getChoiceModel(300716).setValue(0);
                this.getButtonModel(300836).fireEvent(n3);
                break;
            }
            case 300837: {
                this.log.log(1000000, "TelLeftDrawerContextHandler#keyTyped(): CONTEXT_FAVORITES");
                this.getChoiceModel(300716).setValue(1);
                this.getButtonModel(300837).fireEvent(n3);
                break;
            }
            case 300838: {
                this.log.log(1000000, "TelLeftDrawerContextHandler#keyTyped(): CONTEXT_NUMBER_SPELLER");
                this.getChoiceModel(300716).setValue(3);
                this.getButtonModel(300838).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000000, "[TelLeftDrawerContextHandler#keyTyped(): unhandled modelId %1, keyId %2, terminalId %3", (long)n, (long)n2, (long)n3);
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

