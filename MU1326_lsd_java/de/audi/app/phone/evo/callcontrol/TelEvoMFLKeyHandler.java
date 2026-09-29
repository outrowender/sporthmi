/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callcontrol.AbstractTelMFLKeyHandler;
import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import de.audi.app.phone.core.screen.IPopupStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.callcontrol.TelEvoMFLKeyHandler$1;
import de.audi.app.phone.evo.callcontrol.TelEvoMFLKeyHandler$TelEnteredListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelEvoMFLKeyHandler
extends AbstractTelMFLKeyHandler
implements IPopupStateListener,
MenuModelListener {
    private static final int POPUP_REMOVED;
    private static final int POPUP_HIDDEN;
    private static final int POPUP_VISIBLE;
    private volatile int callStackPopupStatus;
    private volatile long focusedUniqueListRowID;

    public TelEvoMFLKeyHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new TelEvoMFLKeyHandler$TelEnteredListener(this, iTelApplication));
    }

    @Override
    public void init() {
        this.getApplication().getPopupScreenStateDispatcher().addPopupStateListener(-208468992, this);
        this.getMenuModel(311886848).setListener(this);
        super.init();
    }

    @Override
    public void deinit() {
        this.getApplication().getPopupScreenStateDispatcher().removePopupStateListener(-208468992, this);
        this.getMenuModel(311886848).resetListener();
        super.deinit();
    }

    @Override
    protected void handleTelKeyTypedIdle(boolean bl) {
        this.log.log(1078071040, "[TelEvoMFLKeyHandler#handleTelKeyTypedIdle] phoneReady=%1, popupVisible=%2", bl, (long)this.callStackPopupStatus);
        if (this.callStackPopupStatus == 2) {
            this.handleTelKeyTypedIdlePopupVisible(bl);
        } else {
            this.handleTelKeyTypedIdlePopupNotVisible();
        }
    }

    private void handleTelKeyTypedIdlePopupVisible(boolean bl) {
        if (bl) {
            this.callFocusedEntry();
        }
    }

    private void handleTelKeyTypedIdlePopupNotVisible() {
        this.log.log(-2137614336, "[TelEvoMFLKeyHandler#handleTelKeyTypedIdlePopupNotVisible] showing POPUP_TEL_POPUP_MFL_ID");
        this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(-208468992);
    }

    @Override
    public void notifyPopupVisible(int n) {
        if (n == -208468992) {
            this.log.log(-2137614336, "[TelEvoMFLKeyHandler#notifyPopupVisible] id=%1", (long)n);
            this.callStackPopupStatus = 2;
        }
    }

    @Override
    public void notifyPopupHidden(int n) {
        if (n == -208468992) {
            this.log.log(-2137614336, "[TelEvoMFLKeyHandler#notifyPopupHidden] id=%1", (long)n);
            this.callStackPopupStatus = 1;
        }
    }

    @Override
    public void notifyPopupRemoved(int n) {
        if (n == -208468992) {
            this.log.log(-2137614336, "[TelEvoMFLKeyHandler#notifyPopupRemoved] id=%1", (long)n);
            this.callStackPopupStatus = 0;
        }
    }

    private void callFocusedEntry() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        if (iGlobalTelephoneStateStruct != null) {
            int n = (int)this.focusedUniqueListRowID;
            CallStackEntry callStackEntry = TelCallStacksUtils.getCallStackEntry(iGlobalTelephoneStateStruct.getCombinedCallStackEntries(), n);
            if (callStackEntry != null) {
                this.log.log(1078071040, "[TelEvoMFLKeyHandler#callFocusedEntry] entry=%1", (Object)callStackEntry);
                this.getApplication().getTelephoneDSIAccess().dialNumberFromCallStackEntry(callStackEntry, 0, true, new TelEvoMFLKeyHandler$1(this));
            } else {
                this.log.log(-1601830656, "[TelEvoMFLKeyHandler#callFocusedEntry] no entry found for callStackID %1", (long)n);
            }
        } else {
            this.log.log(-1601830656, "[TelEvoMFLKeyHandler#callFocusedEntry] telephone state is null --> NOP!");
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        CallStackEntry[] callStackEntryArray;
        this.log.log(-2137614336, "[TelEvoMFLKeyHandler#itemFocused] %1", (Object)TelLoggingUtils.itemFocusedMenuModel(n, n2, l, n3));
        this.focusedUniqueListRowID = l;
        CallStackEntry callStackEntry = null;
        CallStackEntry[] callStackEntryArray2 = callStackEntryArray = this.telephoneState != null ? this.telephoneState.getCombinedCallStackEntries() : null;
        if (callStackEntryArray != null) {
            for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
                if (callStackEntryArray[i2] == null || (long)callStackEntryArray[i2].getClEntryID() != l) continue;
                callStackEntry = callStackEntryArray[i2];
                break;
            }
        }
        if (callStackEntry != null) {
            this.setPictureModel(callStackEntry.getAdbPictureID());
        } else {
            this.resetPictureModel();
        }
    }

    private void setPictureModel(ResourceLocator resourceLocator) {
        if (PhoneUtils.isPictureAvailable(resourceLocator)) {
            this.getResourceLocatorModel(-1869151232).setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            this.getResourceLocatorModel(-1869151232).setStatus(1);
        } else {
            this.resetPictureModel();
        }
    }

    private void resetPictureModel() {
        this.getResourceLocatorModel(-1869151232).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getResourceLocatorModel(-1869151232).setStatus(0);
    }

    static /* synthetic */ void access$000(TelEvoMFLKeyHandler telEvoMFLKeyHandler) {
        telEvoMFLKeyHandler.triggerJumpToPhone();
    }
}

