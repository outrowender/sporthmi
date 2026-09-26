/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.intellicall.IntellicallFullMenuFocusHandler$IntellicallFullMenuFocusHandlerDiag;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class IntellicallFullMenuFocusHandler
extends AbstractPhoneComponent
implements MenuModelListener,
IActionProxyListener {
    private static final int ROW_IGNORE;
    private static final int MENU_ITEM_CALL_LIST;
    private static final int MENU_ITEM_DTMF;
    private static final int MENU_ITEM_SEARCH_FIELD;
    public static final int MENU_ITEM_MAILBOX;
    private static final int MENU_ITEM_CALLSTACK_LIST;
    private static final int MENU_ITEM_SPELLER_CONTENT;
    private static final int MENU_ITEM_SEARCH_RESULT_LIST;
    private volatile IGlobalTelephoneStateStruct telephoneState;

    private static String getMenuItemName(int n) {
        String string;
        switch (n) {
            case 300827: {
                string = "CALL_LIST";
                break;
            }
            case 300732: {
                string = "DTMF";
                break;
            }
            case 200: {
                string = "SEARCH_FIELD";
                break;
            }
            case 300627: {
                string = "MAILBOX";
                break;
            }
            case 300441: {
                string = "CALLSTACK_LIST";
                break;
            }
            case 300468: {
                string = "SPELLER_CONTENT";
                break;
            }
            case 300718: {
                string = "SEARCH_RESULT_LIST";
                break;
            }
            default: {
                string = "Unknown menu item";
            }
        }
        return string;
    }

    public IntellicallFullMenuFocusHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getMenuModel(-929692672).setListener(this);
        this.getResourceLocatorModel(177669120).setStatus(0);
        this.getApplication().addDiagnosisComponent(new IntellicallFullMenuFocusHandler$IntellicallFullMenuFocusHandlerDiag(this, null));
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(18, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getMenuModel(-929692672).resetListener();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(18, this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.log.log(-2137614336, "[IntellicallFullMenuFocusHandler#itemFocused] %1", (Object)IntellicallFullMenuFocusHandler.getMenuItemName(n));
        this.checkShowPicture(n, l);
    }

    protected void checkShowPicture(int n, long l) {
        if (n == -1718287360) {
            CallStackEntry callStackEntry = null;
            CallStackEntry[] callStackEntryArray = this.telephoneState.getCombinedCallStackEntries();
            for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
                if ((long)callStackEntryArray[i2].getClEntryID() != l) continue;
                callStackEntry = callStackEntryArray[i2];
                break;
            }
            if (callStackEntry != null) {
                this.setPictureModel(callStackEntry.getAdbPictureID());
            }
        } else if (n == -1365900288) {
            EvoListRow evoListRow = this.getBaseListModel(n).getRowByUniqueID(l);
            if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
                IntellicallCallStackSearchResultRow intellicallCallStackSearchResultRow = (IntellicallCallStackSearchResultRow)evoListRow;
                this.setPictureModel(intellicallCallStackSearchResultRow.getCallStackEntry().getAdbPictureID());
            } else if (evoListRow instanceof IntellicallADBSearchResultRow) {
                IntellicallADBSearchResultRow intellicallADBSearchResultRow = (IntellicallADBSearchResultRow)evoListRow;
                this.setPictureModel(intellicallADBSearchResultRow.getContactPicture());
            } else if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
                IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
                this.setPictureModel(intellicallADBEntryDetailsResultRow.getContactPicture());
            }
        } else {
            this.resetPictureModel();
        }
    }

    private void setPictureModel(ResourceLocator resourceLocator) {
        if (PhoneUtils.isPictureAvailable(resourceLocator)) {
            this.getResourceLocatorModel(177669120).setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            this.getResourceLocatorModel(177669120).setStatus(1);
        } else {
            this.resetPictureModel();
        }
    }

    private void resetPictureModel() {
        this.getResourceLocatorModel(177669120).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getResourceLocatorModel(177669120).setStatus(0);
    }

    private void focusMenuItem(int n, FocusAdvice focusAdvice) {
        this.focusMenuItem(n, focusAdvice, -1L);
    }

    private void focusMenuItem(int n, FocusAdvice focusAdvice, long l) {
        this.log.log(1078071040, "[IntellicallFullMenuFocusHandler#focusMenuItem] menuItemID=%2, focusAdvice=%1, rowUniqueID=%3", (Object)focusAdvice, (Object)IntellicallFullMenuFocusHandler.getMenuItemName(n), l);
        this.getMenuModel(-929692672).setFocusedItem(n, focusAdvice, l);
    }

    private void focusSearchField() {
        this.focusMenuItem(200, FocusAdvice.KEEP_POSITION);
    }

    public void focusSearchFieldTop() {
        this.focusMenuItem(200, FocusAdvice.VIEWPORT_FIRST_POSITION);
    }

    public void focusDtmf() {
        this.focusMenuItem(-1131019264, FocusAdvice.KEEP_POSITION);
    }

    void focusMailbox() {
        this.focusMenuItem(1402340352, FocusAdvice.KEEP_POSITION);
    }

    void focusSpellerContentLabel() {
        this.focusMenuItem(-1265302528, FocusAdvice.KEEP_POSITION);
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

    void focusCallList(int n) {
        this.focusMenuItem(462881792, FocusAdvice.KEEP_POSITION, n);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 18) {
            this.getMenuModel(-929692672).resetFocusedItem();
        }
    }

    static /* synthetic */ void access$100(IntellicallFullMenuFocusHandler intellicallFullMenuFocusHandler) {
        intellicallFullMenuFocusHandler.focusSearchField();
    }

    static /* synthetic */ void access$200(IntellicallFullMenuFocusHandler intellicallFullMenuFocusHandler, int n, FocusAdvice focusAdvice, long l) {
        intellicallFullMenuFocusHandler.focusMenuItem(n, focusAdvice, l);
    }
}

