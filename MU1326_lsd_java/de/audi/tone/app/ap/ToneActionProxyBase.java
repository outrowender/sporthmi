/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.ap;

import de.audi.atip.log.LogChannel;
import de.audi.tone.app.ap.ActionProxyListener;

public class ToneActionProxyBase {
    protected final LogChannel lc;
    private final ActionProxyListener[] listeners;

    protected ToneActionProxyBase(LogChannel logChannel, ActionProxyListener[] actionProxyListenerArray) {
        this.lc = logChannel;
        this.listeners = actionProxyListenerArray;
    }

    public void volumeNavEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeNavEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeNavEntered();
        }
    }

    public void volumeNavExited(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeNavExited] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeNavExited();
        }
    }

    public void volumeSDSEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeSDSEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeSDSEntered();
        }
    }

    public void volumeSDSExited(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeSDSExited] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeSDSExited();
        }
    }

    public void volumeTelEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTelEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTelEntered();
        }
    }

    public void volumeTelExited(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTelExited] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTelExited();
        }
    }

    public void volumeTelMsgEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTelMsgEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTelMsgEntered();
        }
    }

    public void volumeTelMsgLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTelMsgLeft] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTelMsgLeft();
        }
    }

    public void volumeTPEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTPEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTPEntered();
        }
    }

    public void volumeTPExited(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTPExited] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTPExited();
        }
    }

    public void volumeTouchpadEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTouchpadEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTouchpadEntered();
        }
    }

    public void volumeTouchpadLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTouchpadLeft] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTouchpadLeft();
        }
    }

    public void volumeLoweredEntertainmentNaviEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeLoweredEntertainmentNaviEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeLoweredEntertainmentNaviEntered();
        }
    }

    public void volumeLoweredEntertainmentNaviLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeLoweredEntertainmentNaviLeft] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeLoweredEntertainmentNaviLeft();
        }
    }

    public void volumeLoweredEntertainmentAPSEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeLoweredEntertainmentAPSEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeLoweredEntertainmentAPSEntered();
        }
    }

    public void volumeLoweredEntertainmentAPSLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeLoweredEntertainmentAPSLeft] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeLoweredEntertainmentAPSLeft();
        }
    }

    public void volumeHeartbeatEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeHeartbeatEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeHeartbeatEntered();
        }
    }

    public void volumeHeartbeatLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeHeartbeatLeft] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeHeartbeatLeft();
        }
    }

    public void abortA2LS(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.abortA2LS] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].abortA2LS();
        }
    }

    public void demute(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.demute] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].demute();
        }
    }

    public void balanceFaderLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.balanceFaderLeft] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].balanceFaderLeft();
        }
    }

    public void balanceFaderEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.balanceFaderLeft] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].balanceFaderEntered();
        }
    }

    public void toneSettingsEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneSettingsEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneSettingsEntered();
        }
    }

    public void toneSettingsLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneSettingsLeft]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneSettingsLeft();
        }
    }

    public void tonePhoneEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.tonePhoneEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].tonePhoneEntered();
        }
    }

    public void toneNaviEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneNaviEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneNaviEntered();
        }
    }

    public void toneAnnouncementEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneAnnouncementEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneAnnouncementEntered();
        }
    }

    public void volumeTouchInitEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTouchInitEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTouchInitEntered();
        }
    }

    public void toneSpeechEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneSpeechEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneSpeechEntered();
        }
    }

    public void toneParkingEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneParkingEntered] HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneParkingEntered();
        }
    }

    public void toneEntered(int n, int n2) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneEntered] value:%2 HT:%1", (long)n, (long)n2);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneEntered(n2);
        }
    }

    public void toneEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.toneEntered]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].toneEntered();
        }
    }

    public void volumeRingtoneSelectionEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeRingtoneSelectionEntered]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeRingtoneSelectionEntered();
        }
    }

    public void volumeRingtoneSelectionLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeRingtoneSelectionLeft]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeRingtoneSelectionLeft();
        }
    }

    public void volumeTelMicEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTelMicEntered]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTelMicEntered();
        }
    }

    public void volumeTelMicLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeTelMicLeft]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeTelMicLeft();
        }
    }

    public void volumeWCEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeWCEntered]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeWCEntered();
        }
    }

    public void volumeWCLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeWCLeft]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeWCLeft();
        }
    }

    public void WCMenuEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.WCMenuEntered]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].WCMenuEntered();
        }
    }

    public void volumeInfoAnnouncementEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeInfoAnnouncementEntered]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeInfoAnnouncementEntered();
        }
    }

    public void volumeInfoAnnouncementLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.volumeInfoAnnouncementLeft]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].volumeInfoAnnouncementLeft();
        }
    }

    public void a2lsPopupMediaTunerAreaEntered(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.a2lsPopupMediaTunerAreaEntered]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].a2lsPopupMediaTunerAreaEntered();
        }
    }

    public void a2lsPopupMediaTunerAreaLeft(int n) {
        this.lc.log(10000000, "[ToneActionProxyBase.a2lsPopupMediaTunerAreaLeft]  HT:%1", (long)n);
        ActionProxyListener[] actionProxyListenerArray = this.getListeners(n);
        for (int i2 = 0; i2 < actionProxyListenerArray.length; ++i2) {
            actionProxyListenerArray[i2].a2lsPopupMediaTunerAreaLeft();
        }
    }

    public void volumeLoweredEntertainmentAPSExited(int n) {
    }

    protected ActionProxyListener[] getListeners(int n) {
        return this.listeners;
    }
}

