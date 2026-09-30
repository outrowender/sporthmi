/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class IntellicallFullMenuFocusHandler
extends AbstractPhoneComponent
implements MenuModelListener,
IActionProxyListener {
    private static final int ROW_IGNORE = -1;
    private static final int MENU_ITEM_CALL_LIST = 300827;
    private static final int MENU_ITEM_DTMF = 300732;
    private static final int MENU_ITEM_SEARCH_FIELD = 200;
    public static final int MENU_ITEM_MAILBOX = 300627;
    private static final int MENU_ITEM_CALLSTACK_LIST = 300441;
    private static final int MENU_ITEM_SPELLER_CONTENT = 300468;
    private static final int MENU_ITEM_SEARCH_RESULT_LIST = 300718;
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

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getMenuModel(300744).setListener(this);
        this.getResourceLocatorModel(300810).setStatus(0);
        this.getApplication().addDiagnosisComponent(new IntellicallFullMenuFocusHandlerDiag());
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(18, this);
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getMenuModel(300744).resetListener();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(18, this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.log.log(10000000, "[IntellicallFullMenuFocusHandler#itemFocused] %1", (Object)IntellicallFullMenuFocusHandler.getMenuItemName(n));
        this.checkShowPicture(n, l);
    }

    protected void checkShowPicture(int n, long l) {
        if (n == 300441) {
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
        } else if (n == 300718) {
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
            this.getResourceLocatorModel(300810).setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            this.getResourceLocatorModel(300810).setStatus(1);
        } else {
            this.resetPictureModel();
        }
    }

    private void resetPictureModel() {
        this.getResourceLocatorModel(300810).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getResourceLocatorModel(300810).setStatus(0);
    }

    private void focusMenuItem(int n, FocusAdvice focusAdvice) {
        this.focusMenuItem(n, focusAdvice, -1L);
    }

    private void focusMenuItem(int n, FocusAdvice focusAdvice, long l) {
        this.log.log(1000000, "[IntellicallFullMenuFocusHandler#focusMenuItem] menuItemID=%2, focusAdvice=%1, rowUniqueID=%3", (Object)focusAdvice, (Object)IntellicallFullMenuFocusHandler.getMenuItemName(n), l);
        this.getMenuModel(300744).setFocusedItem(n, focusAdvice, l);
    }

    private void focusSearchField() {
        this.focusMenuItem(200, FocusAdvice.KEEP_POSITION);
    }

    public void focusSearchFieldTop() {
        this.focusMenuItem(200, FocusAdvice.VIEWPORT_FIRST_POSITION);
    }

    public void focusDtmf() {
        this.focusMenuItem(300732, FocusAdvice.KEEP_POSITION);
    }

    void focusMailbox() {
        this.focusMenuItem(300627, FocusAdvice.KEEP_POSITION);
    }

    void focusSpellerContentLabel() {
        this.focusMenuItem(300468, FocusAdvice.KEEP_POSITION);
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
        this.focusMenuItem(300827, FocusAdvice.KEEP_POSITION, n);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 18) {
            this.getMenuModel(300744).resetFocusedItem();
        }
    }

    private class IntellicallFullMenuFocusHandlerDiag
    implements IPhoneDiagComponent {
        private IntellicallFullMenuFocusHandlerDiag() {
        }

        public void cmdIntellicallFullFocusCallList(int n) {
            IntellicallFullMenuFocusHandler.this.focusCallList(n);
        }

        public void cmdIntellicallFullFocusDTMF() {
            IntellicallFullMenuFocusHandler.this.focusDtmf();
        }

        public void cmdIntellicallFullFocusSearchField() {
            IntellicallFullMenuFocusHandler.this.focusSearchField();
        }

        public void cmdIntellicallFullFocusMailbox() {
            IntellicallFullMenuFocusHandler.this.focusMailbox();
        }

        public void cmdIntellicallFullFocusCallStackList(int n) {
            IntellicallFullMenuFocusHandler.this.focusMenuItem(300441, FocusAdvice.KEEP_POSITION, n);
        }

        public void cmdIntellicallFullFocusSpellerContent() {
            IntellicallFullMenuFocusHandler.this.focusSpellerContentLabel();
        }

        public void cmdIntellicallFullFocusSearchResultList(int n) {
            IntellicallFullMenuFocusHandler.this.focusMenuItem(300718, FocusAdvice.KEEP_POSITION, n);
        }

        public void cmdIntellicallFullFocusActiveCall() {
            IntellicallFullMenuFocusHandler.this.focusActiveCall();
        }

        public void cmdIntellicallFullFocusHeldCall() {
            IntellicallFullMenuFocusHandler.this.focusHeldCall();
        }
    }
}

