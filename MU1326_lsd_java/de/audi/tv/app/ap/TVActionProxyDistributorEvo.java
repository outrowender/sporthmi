/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.ap;

import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.TVActionProxy;

public class TVActionProxyDistributorEvo
implements TVActionProxy {
    protected TVActionProxy[] apListeners;
    protected final LogChannel lcHMI;

    public TVActionProxyDistributorEvo(LogChannel logChannel) {
        this.lcHMI = logChannel;
    }

    public void setApListeners(TVActionProxy[] tVActionProxyArray) {
        this.apListeners = tVActionProxyArray;
    }

    private void checkDuration(long l, String string) {
        long l2 = System.currentTimeMillis() - l;
        if (l2 > 0) {
            this.lcHMI.log(-1601830656, "[TVActionProxyDispatcher] Call '%1' took %2ms!", (Object)string, l2);
        }
    }

    public void avListEntered(int n) {
    }

    @Override
    public void hmiActivatedTV(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.hmiActivatedTV]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].hmiActivatedTV(n);
        }
        this.checkDuration(l, "hmiActivatedTV");
    }

    @Override
    public void hmiDeactivatedTV(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.hmiDeactivatedTV]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].hmiDeactivatedTV(n);
        }
        this.checkDuration(l, "hmiDeactivatedTV");
    }

    @Override
    public void tvDataBroadcastEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvDataBroadcastEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvDataBroadcastEntered(n);
        }
        this.checkDuration(l, "tvDataBroadcastEntered");
    }

    @Override
    public void tvVisualAudioEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvVisualAudioEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvVisualAudioEntered(n);
        }
        this.checkDuration(l, "tvVisualAudioEntered");
    }

    @Override
    public void tvCasDisclaimerEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvCasDisclaimerEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvCasDisclaimerEntered(n);
        }
        this.checkDuration(l, "tvCasDisclaimerEntered");
    }

    @Override
    public void terminalModeLeft(int n) {
    }

    @Override
    public void tvEPGEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvEPGEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvEPGEntered(n);
        }
        this.checkDuration(l, "tvEPGEntered");
    }

    @Override
    public void tvTeletextEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvTeletextEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvTeletextEntered(n);
        }
        this.checkDuration(l, "tvTeletextEntered");
    }

    @Override
    public void tvEngineeringEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvEngineeringEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvEngineeringEntered(n);
        }
        this.checkDuration(l, "tvEngineeringEntered");
    }

    @Override
    public void tvFullscreenEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvFullscreenEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvFullscreenEntered(n);
        }
        this.checkDuration(l, "tvFullscreenEntered");
    }

    @Override
    public void tvFullscreenLeft(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvFullscreenLeft]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvFullscreenLeft(n);
        }
        this.checkDuration(l, "tvFullscreenLeft");
    }

    @Override
    public void avFullscreenEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.avFullscreenEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].avFullscreenEntered(n);
        }
        this.checkDuration(l, "avFullscreenEntered");
    }

    @Override
    public void avFullscreenLeft(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.avFullscreenLeft]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].avFullscreenLeft(n);
        }
        this.checkDuration(l, "avFullscreenLeft");
    }

    @Override
    public void tvSeekModeLeft(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvSeekModeLeft]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvSeekModeLeft(n);
        }
        this.checkDuration(l, "tvSeekModeLeft");
    }

    @Override
    public void tvShowOsd(int n) {
    }

    @Override
    public void tvParentalRatingLeft(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvParentalRatingLeft]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvParentalRatingLeft(n);
        }
        this.checkDuration(l, "tvParentalRatingLeft");
    }

    @Override
    public void tvParentalRatingDisclaimerEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvParentalRatingDisclaimerEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvParentalRatingDisclaimerEntered(n);
        }
        this.checkDuration(l, "tvParentalRatingDisclaimerEntered");
    }

    @Override
    public void enterOptionScreen(int n) {
    }

    @Override
    public void leaveOptionScreen(int n) {
    }

    @Override
    public void tvEwsPopupClosed(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvEwsPopupClosed]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvEwsPopupClosed(n);
        }
        this.checkDuration(l, "tvEwsPopupClosed");
    }

    @Override
    public void tvTxtEntered(int n) {
        this.lcHMI.log(-2137614336, "[TVActionProxyEvo.tvTxtEntered]");
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.apListeners.length; ++i2) {
            this.apListeners[i2].tvTxtEntered(n);
        }
        this.checkDuration(l, "tvTxtEntered");
    }
}

