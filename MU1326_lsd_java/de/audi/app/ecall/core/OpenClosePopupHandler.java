/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.IContextStateListener;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IOpenClosePopupHandler;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.PopupKeyConsuptionStrategy;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class OpenClosePopupHandler
extends AbstractEcallComponent
implements IOpenClosePopupHandler,
IContextStateListener {
    private volatile boolean isInContext;
    private volatile boolean wasFirstShowingOutsidePhoneContext;
    protected volatile boolean isEcallActive;
    private volatile int currentScreen = 0;
    private final SimpleIntObjectMap strategyTypeStrategyMap;
    protected final int SCREENS_POPUP_ID;
    static /* synthetic */ Class class$de$audi$app$ecall$core$bap$EcallScreenNames;

    public OpenClosePopupHandler(IEcallApplication iEcallApplication, String string, int n) {
        super(iEcallApplication, string);
        this.SCREENS_POPUP_ID = n;
        this.strategyTypeStrategyMap = new SimpleIntObjectMap();
        PopupKeyConsuptionStrategy popupKeyConsuptionStrategy = new PopupKeyConsuptionStrategy(this.SCREENS_POPUP_ID);
        popupKeyConsuptionStrategy.setHKPressFilter(new int[]{15, 4});
        this.strategyTypeStrategyMap.add(2, popupKeyConsuptionStrategy);
        PopupKeyConsuptionStrategy popupKeyConsuptionStrategy2 = new PopupKeyConsuptionStrategy(this.SCREENS_POPUP_ID);
        popupKeyConsuptionStrategy2.setHKPressFilter(new int[]{4});
        this.strategyTypeStrategyMap.add(3, popupKeyConsuptionStrategy2);
        PopupKeyConsuptionStrategy popupKeyConsuptionStrategy3 = new PopupKeyConsuptionStrategy(this.SCREENS_POPUP_ID);
        popupKeyConsuptionStrategy3.setHKPressFilter(null);
        this.strategyTypeStrategyMap.add(1, popupKeyConsuptionStrategy3);
    }

    public void deinit() {
        this.strategyTypeStrategyMap.clear();
    }

    public void showScreen(int n) {
        this.log.log(10000000, "OpenClosePopupHandler#showScreen(): show ScreenId: %1 ", (long)n);
        EcallUtil.logStructFieldForDbg(this.log, class$de$audi$app$ecall$core$bap$EcallScreenNames == null ? (class$de$audi$app$ecall$core$bap$EcallScreenNames = OpenClosePopupHandler.class$("de.audi.app.ecall.core.bap.EcallScreenNames")) : class$de$audi$app$ecall$core$bap$EcallScreenNames, n);
        this.setValueForEcallPopupChoiceModel(n);
        this.resolveEcallPopupShowing(n);
    }

    private void resolveEcallPopupShowing(int n) {
        if (this.isInContext || !this.wasFirstShowingOutsidePhoneContext || n == 3) {
            this.wasFirstShowingOutsidePhoneContext = true;
            this.showEcallPopup();
        }
    }

    public void activateEcallSession() {
        this.log.log(10000000, "OpenClosePopupHandler#activateEcallSession(): called");
        this.isEcallActive = true;
        this.getChoiceModel(4371).setValue(1);
    }

    public void disactivateEcallSession() {
        this.log.log(10000000, "OpenClosePopupHandler#disactivateEcallSession(): called");
        this.getChoiceModel(4371).setValue(0);
        this.isEcallActive = false;
        this.wasFirstShowingOutsidePhoneContext = false;
        this.setValueForEcallPopupChoiceModel(0);
        this.setPopupConsumptionStrategy(this.getStrategyTypeForScreen(0));
        this.getHmiServiceApp().removePopup(this.SCREENS_POPUP_ID);
    }

    protected void showEcallPopup() {
        this.log.log(10000000, "OpenClosePopupHandler#showEcallPopup(): isEcallActive: %1", this.isEcallActive);
        if (this.isEcallActive) {
            this.getHmiServiceApp().showPopup(this.SCREENS_POPUP_ID);
            this.setPopupConsumptionStrategy(this.getStrategyTypeForScreen(this.currentScreen));
        }
    }

    protected void setValueForEcallPopupChoiceModel(int n) {
        this.currentScreen = n;
        this.getHmiServiceApp().getChoiceModel(3300006).setValue(n);
    }

    protected void setPopupConsumptionStrategy(int n) {
        this.log.log(10000000, "OpenClosePopupHandler#setPopupConsumptionStrategy(): strategyType=%1", (long)n);
        this.getHmiServiceApp().setPopupKeyConsuptionStrategy(this.getPopupConsumptionStrategy(n));
    }

    protected int getStrategyTypeForScreen(int n) {
        switch (n) {
            case 3: {
                return 3;
            }
            case 0: {
                return 1;
            }
        }
        return 2;
    }

    private IPopupKeyConsuptionStrategy getPopupConsumptionStrategy(int n) {
        return (IPopupKeyConsuptionStrategy)this.strategyTypeStrategyMap.get(n);
    }

    public void onContextLeft() {
        this.log.log(10000000, "OpenClosePopupHandler#onContextLeft (actionProxyCallPerformed): context left");
        this.isInContext = false;
        this.setPopupConsumptionStrategy(1);
    }

    public void onContextEntered() {
        this.log.log(10000000, "OpenClosePopupHandler#onContextEntered (actionProxyCallPerformed): context entered");
        this.isInContext = true;
        this.showEcallPopup();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private static class ConnectedGatewayState {
        private static final int INACTIVE = 0;
        private static final int ACTIVE = 1;

        private ConnectedGatewayState() {
        }
    }

    public static class ConsumptionStrategyType {
        public static final int UNBLOCKED = 1;
        public static final int BLOCKED = 2;
        public static final int BLOCKED_FOR_HK_TEL = 3;
    }
}

