/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.intellicall.IntellicallReducedMenuFocusHandler$IntellicallReducedMenuFocusHandlerDiag;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.phone.IEcallState;
import java.util.Map;

public class IntellicallReducedMenuFocusHandler
extends AbstractPhoneComponent
implements MenuModelListener,
IActionProxyListener {
    private static final int ROW_IGNORE;
    private static final int MENU_ITEM_CALL_LIST;
    private static final int MENU_ITEM_DTMF;
    private volatile IGlobalTelephoneStateStruct telephoneState;

    private static String getMenuItemName(int n) {
        switch (n) {
            case 300828: {
                return "CALL_LIST";
            }
            case 300639: {
                return "DTMF";
            }
        }
        return "Unknown menu item";
    }

    public IntellicallReducedMenuFocusHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getMenuModel(-912915456).setListener(this);
        this.getApplication().addDiagnosisComponent(new IntellicallReducedMenuFocusHandler$IntellicallReducedMenuFocusHandlerDiag(this, null));
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(17, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getMenuModel(-912915456).resetListener();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.log.log(-2137614336, "[IntellicallReducedMenuFocusHandler#itemFocused] %1", (Object)IntellicallReducedMenuFocusHandler.getMenuItemName(n));
    }

    private void focusMenuItem(int n, FocusAdvice focusAdvice) {
        this.focusMenuItem(n, focusAdvice, -1L);
    }

    private void focusMenuItem(int n, FocusAdvice focusAdvice, long l) {
        this.log.log(1078071040, "[IntellicallReducedMenuFocusHandler#focusMenuItem] menuItemID=%2, focusAdvice=%1, rowUniqueID=%3", (Object)focusAdvice, (Object)IntellicallReducedMenuFocusHandler.getMenuItemName(n), l);
        this.getMenuModel(-912915456).setFocusedItem(n, focusAdvice, l);
    }

    void focusDtmf() {
        this.focusMenuItem(1603666944, FocusAdvice.VIEWPORT_LAST_POSITION);
    }

    void focusActiveCall() {
        AbstractPhoneCall abstractPhoneCall;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        AbstractPhoneCall abstractPhoneCall2 = abstractPhoneCall = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null ? iGlobalTelephoneStateStruct.getCallState().getActiveCall() : null;
        if (abstractPhoneCall != null) {
            this.focusCallList(abstractPhoneCall.getTelCallID());
        }
    }

    void focusHeldCall() {
        AbstractPhoneCall abstractPhoneCall;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        AbstractPhoneCall abstractPhoneCall2 = abstractPhoneCall = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null ? iGlobalTelephoneStateStruct.getCallState().getHeldCall() : null;
        if (abstractPhoneCall != null) {
            this.focusCallList(abstractPhoneCall.getTelCallID());
        }
    }

    void focusActiveOrDialingCall() {
        AbstractPhoneCall abstractPhoneCall;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        AbstractPhoneCall abstractPhoneCall2 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null ? iGlobalTelephoneStateStruct.getCallState().getActiveCall() : null;
        AbstractPhoneCall abstractPhoneCall3 = abstractPhoneCall = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null ? iGlobalTelephoneStateStruct.getCallState().getOutgoingCall() : null;
        if (abstractPhoneCall != null) {
            this.focusCallList(abstractPhoneCall.getTelCallID());
        } else if (abstractPhoneCall2 != null) {
            this.focusCallList(abstractPhoneCall2.getTelCallID());
        }
    }

    void focusDialingECall() {
        IEcallState iEcallState;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        IEcallState iEcallState2 = iEcallState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState() : null;
        if (iEcallState != null && iEcallState.isLowPrioritySOSEmergencyCallType() && iEcallState.getCall() != null) {
            this.focusCallList(iEcallState.getCall().getId());
        }
    }

    void focusCallList(int n) {
        this.focusMenuItem(479659008, FocusAdvice.VIEWPORT_LAST_POSITION, n);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 17) {
            this.getMenuModel(-912915456).resetFocusedItem();
        }
    }
}

