/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingHandler;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingStatusIconHandler;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.suppservices.TelEvoCallForwardCallStackHandler;
import de.audi.app.phone.evo.suppservices.TelEvoCallForwardingStatusIconHandler;
import de.audi.app.phone.evo.suppservices.search.TelCallFowardSearchModelHandler;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelEvoCallForwardHandler
extends AbstractTelCallForwardingHandler
implements MenuModelListener {
    private static final int MENU_ITEM_CALLSTACK_LIST = 300772;
    private static final int MENU_ITEM_SEARCH_RESULT_LIST = 300766;
    private final TelEvoCallForwardCallStackHandler callStackHandler;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private final TelCallFowardSearchModelHandler searchHandler;

    public TelEvoCallForwardHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess) {
        super(iTelApplication);
        this.searchHandler = new TelCallFowardSearchModelHandler(iTelApplication, iTelDSISearchAccess, this);
        this.addSubPhoneComponent(this.searchHandler);
        this.callStackHandler = new TelEvoCallForwardCallStackHandler(iTelApplication, this);
    }

    protected AbstractTelCallForwardingStatusIconHandler createCallForawardingStatusIconHandler() {
        if (this.getApplication().getFrameworkAccess().isCn()) {
            return new TelEvoCallForwardingStatusIconHandler(this.log, this.getApplication().getFrameworkAccess().getHmiServiceApp());
        }
        return null;
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.callStackHandler.init();
        this.getMenuModel(300808).setListener(this);
        this.getResourceLocatorModel(300809).setStatus(0);
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.callStackHandler.deinit();
        this.getMenuModel(300808).resetListener();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.checkShowPicture(n, l);
    }

    protected void checkShowPicture(int n, long l) {
        if (n == 300772) {
            CallStackEntry callStackEntry = null;
            CallStackEntry[] callStackEntryArray = this.telephoneState != null ? this.telephoneState.getCombinedCallStackEntries() : new CallStackEntry[]{};
            for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
                if ((long)callStackEntryArray[i2].getClEntryID() != l) continue;
                callStackEntry = callStackEntryArray[i2];
                break;
            }
            if (callStackEntry != null) {
                this.setPictureModel(callStackEntry.getAdbPictureID());
            }
        } else if (n == 300766) {
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
            this.getResourceLocatorModel(300809).setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            this.getResourceLocatorModel(300809).setStatus(1);
        } else {
            this.resetPictureModel();
        }
    }

    private void resetPictureModel() {
        this.getResourceLocatorModel(300809).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getResourceLocatorModel(300809).setStatus(0);
    }
}

