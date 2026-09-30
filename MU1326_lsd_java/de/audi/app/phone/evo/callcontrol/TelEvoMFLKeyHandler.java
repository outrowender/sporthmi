/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.callcontrol.AbstractTelMFLKeyHandler;
import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.screen.IPopupStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelEvoMFLKeyHandler
extends AbstractTelMFLKeyHandler
implements IPopupStateListener,
MenuModelListener {
    private static final int POPUP_REMOVED = 0;
    private static final int POPUP_HIDDEN = 1;
    private static final int POPUP_VISIBLE = 2;
    private volatile int callStackPopupStatus;
    private volatile long focusedUniqueListRowID;

    public TelEvoMFLKeyHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new TelEnteredListener(iTelApplication));
    }

    public void init() {
        this.getApplication().getPopupScreenStateDispatcher().addPopupStateListener(300019, this);
        this.getMenuModel(300818).setListener(this);
        super.init();
    }

    public void deinit() {
        this.getApplication().getPopupScreenStateDispatcher().removePopupStateListener(300019, this);
        this.getMenuModel(300818).resetListener();
        super.deinit();
    }

    protected void handleTelKeyTypedIdle(boolean bl) {
        this.log.log(1000000, "[TelEvoMFLKeyHandler#handleTelKeyTypedIdle] phoneReady=%1, popupVisible=%2", bl, (long)this.callStackPopupStatus);
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
        this.log.log(10000000, "[TelEvoMFLKeyHandler#handleTelKeyTypedIdlePopupNotVisible] showing POPUP_TEL_POPUP_MFL_ID");
        this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(300019);
    }

    public void notifyPopupVisible(int n) {
        if (n == 300019) {
            this.log.log(10000000, "[TelEvoMFLKeyHandler#notifyPopupVisible] id=%1", (long)n);
            this.callStackPopupStatus = 2;
        }
    }

    public void notifyPopupHidden(int n) {
        if (n == 300019) {
            this.log.log(10000000, "[TelEvoMFLKeyHandler#notifyPopupHidden] id=%1", (long)n);
            this.callStackPopupStatus = 1;
        }
    }

    public void notifyPopupRemoved(int n) {
        if (n == 300019) {
            this.log.log(10000000, "[TelEvoMFLKeyHandler#notifyPopupRemoved] id=%1", (long)n);
            this.callStackPopupStatus = 0;
        }
    }

    private void callFocusedEntry() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        if (iGlobalTelephoneStateStruct != null) {
            int n = (int)this.focusedUniqueListRowID;
            CallStackEntry callStackEntry = TelCallStacksUtils.getCallStackEntry(iGlobalTelephoneStateStruct.getCombinedCallStackEntries(), n);
            if (callStackEntry != null) {
                this.log.log(1000000, "[TelEvoMFLKeyHandler#callFocusedEntry] entry=%1", (Object)callStackEntry);
                this.getApplication().getTelephoneDSIAccess().dialNumberFromCallStackEntry(callStackEntry, 0, true, new TelDefaultDSIResponseListener(){

                    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                        if (n == 0) {
                            TelEvoMFLKeyHandler.this.triggerJumpToPhone();
                        }
                    }
                });
            } else {
                this.log.log(100000, "[TelEvoMFLKeyHandler#callFocusedEntry] no entry found for callStackID %1", (long)n);
            }
        } else {
            this.log.log(100000, "[TelEvoMFLKeyHandler#callFocusedEntry] telephone state is null --> NOP!");
        }
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        CallStackEntry[] callStackEntryArray;
        this.log.log(10000000, "[TelEvoMFLKeyHandler#itemFocused] %1", (Object)TelLoggingUtils.itemFocusedMenuModel(n, n2, l, n3));
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
            this.getResourceLocatorModel(300944).setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            this.getResourceLocatorModel(300944).setStatus(1);
        } else {
            this.resetPictureModel();
        }
    }

    private void resetPictureModel() {
        this.getResourceLocatorModel(300944).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getResourceLocatorModel(300944).setStatus(0);
    }

    private class TelEnteredListener
    extends AbstractTelActionProxyListener {
        public TelEnteredListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 15);
        }

        protected void actionProxyCalled(Map map) {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().removePopup(300019);
        }
    }
}

