/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IFuelWarningModelAccess;
import de.audi.tghu.navi.app.util.Util;

public class FuelWarningModelAccess
implements IFuelWarningModelAccess,
TimerListener {
    private static final long CLOSE_DELAY;
    private static final int FUEL_TYPE_CHOICE_MODEL_DEFAULT;
    private static final int FUEL_TYPE_CHOICE_MODEL_CNG;
    private static final int FUEL_TYPE_CHOICE_MODEL_DIESEL;
    private static final int terminalId;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final LogChannel logger;
    private final Timer closePopupTimer;
    private boolean ignoreFireTimer;
    private final NavigationEnv env;
    private boolean fuelWarningPopupIsCurrentlyShown;

    public FuelWarningModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logger = navigationEnv.getLogChannel();
        this.closePopupTimer = new Timer("ClosePopupTimer", 0, true, this);
        this.ignoreFireTimer = true;
        this.fuelWarningPopupIsCurrentlyShown = false;
    }

    @Override
    public void setFuelWarningActive(boolean bl) {
        this.logger.log(-2137614336, "%1#setFuelWarningActive - active=%2", (Object)this.CLASS_NAME, (Object)bl);
        this.fuelWarningPopupIsCurrentlyShown = bl;
    }

    @Override
    public boolean isFuelWarningActive() {
        return this.fuelWarningPopupIsCurrentlyShown;
    }

    @Override
    public void onStartSequence(boolean bl) {
        int n = bl ? 2 : 1;
        this.env.getChoiceModel(-14940672).setValue(n);
    }

    @Override
    public void showPopUp(int n) {
        int n2 = this.determineChoiceModel(n);
        this.logger.log(-1601830656, new StringBuffer().append(this.CLASS_NAME).append("#showPopUp() - poiCategory=%1; fuelTypeChoice=%2; fuelWarningPopupIsCurrentlyShown=%3").toString(), (long)n, (long)n2, this.fuelWarningPopupIsCurrentlyShown);
        if (this.fuelWarningPopupIsCurrentlyShown) {
            this.logger.log(-2137614336, "%1#showPopUp - fuel warning is active -> not showing popup.", (Object)this.CLASS_NAME);
            return;
        }
        this.env.getChoiceModel(-2028075520).setValue(n2);
        this.setIgnoreCloseTimer(false);
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, -417724928);
    }

    @Override
    public void hidePopUp() {
        this.logger.log(-1601830656, "%1#hidePopUp()", (Object)this.CLASS_NAME);
        this.env.getFramework().getHmiServiceApp().removePartialPopup(0, -417724928);
    }

    @Override
    public void cleanup() {
        this.closePopupTimer.cancel();
    }

    public void setIgnoreCloseTimer(boolean bl) {
        this.ignoreFireTimer = bl;
    }

    @Override
    public void setFuelWarningChoiceModel(boolean bl) {
        this.env.getChoiceModel(-233110016).setValue(bl ? 1 : 0);
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.log(1078071040, "%1#fireTimer() - Timer: %2", (Object)this.CLASS_NAME, (Object)timer);
        if (!this.ignoreFireTimer) {
            this.hidePopUp();
        } else {
            this.logger.log(1078071040, "%1#fireTimer() - Timer ignored! ", (Object)this.CLASS_NAME);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.logger.log(1078071040, "%1#cancelTimer() - Timer: %2", (Object)this.CLASS_NAME, (Object)timer);
    }

    @Override
    public void popupVisible(int n, int n2) {
        if (n != -417724928) {
            return;
        }
        this.logger.log(-2137614336, "%1#popupVisible() ", (Object)this.CLASS_NAME);
        if (this.closePopupTimer.isRunning()) {
            this.closePopupTimer.cancel();
        }
        this.closePopupTimer.restart();
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    private int determineChoiceModel(int n) {
        int n2 = 0;
        if (n == 135) {
            n2 = 1;
        } else if (n == 121) {
            n2 = 2;
        }
        this.logger.log(-2137614336, "%1#determineChoiceModel - poiCategory=%2; choiceModelVal=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        return n2;
    }
}

