/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.kbd.KeyMap;
import de.audi.kbd.LangCodeMap;
import de.audi.kbd.dsi.KbdLightsState;
import de.audi.kbd.dsi.KbdListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.RingBuffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.keypanel.DSIKeyPanel;

public final class KbdHandler
implements KbdService,
DumpInfoProvider,
TimerListener,
PowerEventListener,
ChoiceListener {
    private static final int TIMEOUT_LATIN;
    private static final int ACCUMULATION_TIME;
    public static final int ILLUMINATION_OFF;
    public static final int ILLUMINATION_DELAY;
    private static final int GENERIC_SETTING_PRESET_LAYOUT_KEY;
    private final IFrameworkAccess framework;
    private final LogChannel logChannel;
    private final Timer illuminationTimer;
    private DSIKeyPanel dsiKeyPanel;
    private final KbdListener kbdListener;
    private volatile int hardkey = -1;
    private volatile int softkey = -1;
    private Map illumStateMap = new HashMap();
    private RingBuffer illuminationHistory = new RingBuffer(20);
    private int currentRecognizerMode = -1;
    private String currentRecognizerLanguage = "";
    private int currentRecognizerLanguageCode = 0;
    private int currentGenSettingAccumulationTime = -1;
    private KbdLightsState illuminationStateBeforeStandby;
    public volatile int genericSettingPresetLayout;
    private volatile int currentPowerState = -1;

    public KbdHandler(IFrameworkAccess iFrameworkAccess, KbdListener kbdListener) {
        this.framework = iFrameworkAccess;
        this.kbdListener = kbdListener;
        this.kbdListener.setKbdHandler(this);
        this.logChannel = iFrameworkAccess.getLogChannel("Fw.Kbd.Handler");
        this.illuminationTimer = new Timer("IlluminationStack", 0, true, this);
    }

    public synchronized void setDSIKeyPanel(DSIKeyPanel dSIKeyPanel) {
        this.logChannel.log(1078071040, "KbdHandler.setDSIKeyPanel(dsiKeyPanel=%1)", (Object)dSIKeyPanel);
        this.dsiKeyPanel = dSIKeyPanel;
        if (!this.framework.getStartupMgr().isRebootToDownload()) {
            this.setActiveHK(-1);
            this.setLightingHK(this.getActiveHK(), true);
        }
        if (this.dsiKeyPanel != null) {
            this.dsiKeyPanel.requestGenericSetting(1, 31);
        }
    }

    void setGenericSettingResponse(int n, int n2) {
        if (n == 31) {
            this.genericSettingPresetLayout = n2;
        }
    }

    @Override
    public int getGenericSettingPresetLayout() {
        return this.genericSettingPresetLayout;
    }

    @Override
    public synchronized void notifyPowerListenerOnEnterState(int n, int n2) {
        this.logChannel.log(1078071040, "KbdHandler.notifyPowerListenerOnEnterState(pwrevt=%1, terminalID=%2)", (long)n, (long)n2);
        if (n == 2) {
            this.illuminationStateBeforeStandby = new KbdLightsState();
            this.illuminationStateBeforeStandby.setActiveSK(this.getActiveSK());
            this.illuminationStateBeforeStandby.setActiveHK(this.getActiveHK());
            this.setLightingSK(this.getActiveSK(), false);
            this.setHKIlluminationOff();
            this.setRecognizerMode(0);
        } else if (n == 1) {
            this.setRecognizerMode(24);
        }
        this.currentPowerState = n;
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    @Override
    public synchronized KbdService getKbdService() {
        if (this.illuminationStateBeforeStandby != null) {
            return this.illuminationStateBeforeStandby;
        }
        KbdLightsState kbdLightsState = new KbdLightsState();
        kbdLightsState.setActiveSK(this.getActiveSK());
        kbdLightsState.setActiveHK(this.getActiveHK());
        this.logChannel.log(1078071040, "KbdHandler.getKbdServiceHandler: Created new instance of KbdLightsState! (instance=%1)", (Object)kbdLightsState);
        return kbdLightsState;
    }

    @Override
    public int getCurrentKeyboardType() {
        return this.kbdListener.getCurrentKeyboardType();
    }

    @Override
    public boolean isTouchKeypanel() {
        int n = this.getCurrentKeyboardType();
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.logChannel.log(-2137614336, "KbdHandler.isTouchKeypanel kbdType is no touch keypanel currentKeyboardType: %1 - return false", (long)n);
                return false;
            }
            case 0: {
                this.logChannel.log(-1601830656, "KbdHandler.isTouchKeypanel unknown kbdType - enable touch features");
            }
        }
        return true;
    }

    @Override
    public boolean isPanelWithJoystick() {
        int n = this.getCurrentKeyboardType();
        switch (n) {
            case 1: 
            case 2: {
                this.logChannel.log(-2137614336, "KbdHandler.isPanelWithJoystick kbdType is no joystick currentKeyboardType: %1 - return false", (long)n);
                return false;
            }
            case 0: {
                this.logChannel.log(-1601830656, "KbdHandler.isPanelWithJoystick unknown kbdType - enable touch features");
            }
        }
        return true;
    }

    @Override
    public synchronized void synchronizeSettings(KbdService kbdService) {
        this.logChannel.log(1078071040, "KbdHandler.setKbdServiceHandler(kbdServiceHandler=%1)", (Object)kbdService);
        if (kbdService instanceof KbdLightsState) {
            KbdLightsState kbdLightsState = (KbdLightsState)kbdService;
            this.setLightingHK(kbdLightsState.getActiveHK(), true);
            this.illuminationStateBeforeStandby = null;
        }
    }

    @Override
    public synchronized void setHKIlluminationExclusive(int n) {
        this.logChannel.log(1078071040, "KbdHandler.setHKIlluminationExclusive(keycode=%1)", (long)n);
        this.setLightingHK(n, true);
    }

    @Override
    public synchronized void setHKIlluminationOff() {
        this.logChannel.log(1078071040, "KbdHandler.setHKIlluminationOff()");
        this.setLightingHK(this.getActiveHK(), false);
    }

    @Override
    public synchronized void setSKIlluminationExclusive(int n) {
        this.logChannel.log(1078071040, "KbdHandler.setSKIlluminationExclusive: keycode=%1", (long)n);
        this.setLightingSK(n, true);
    }

    @Override
    public synchronized void setSKIlluminationOff() {
        this.logChannel.log(1078071040, "KbdHandler.setSKIlluminationOff()");
        this.setLightingSK(this.getActiveSK(), false);
    }

    @Override
    public boolean setRecognizerMode(int n) {
        return this.setRecognizerMode(n, false);
    }

    public boolean setRecognizerMode(int n, boolean bl) {
        this.logChannel.log(1078071040, "KbdHandler.setRecognizerMode(mode=%2, force=%1)", bl, (long)n);
        if (this.currentPowerState == 2 || this.currentPowerState == 1) {
            this.logChannel.log(1078071040, "KbdHandler.setRecognizerMode() <-- Returning with false. CurrentPowerState == HMI_STANDBY: %1 or CurrentPowerState == HMI_ON_NO_DISPLAY: %2", this.currentPowerState == 2, this.currentPowerState == 1);
            return false;
        }
        if (!bl && n == this.currentRecognizerMode) {
            this.logChannel.log(1078071040, "KbdHandler.setRecognizerMode() <-- Returning with false. force == false: %1 and mode == currentRecognizerMode: %2", bl, n == this.currentRecognizerMode);
            return false;
        }
        if (!this.isTouchKeypanel()) {
            this.logChannel.log(1078071040, "KbdHandler.setRecognizerMode() <-- Returning with false. isTouchKeyPanel == false: %1", this.isTouchKeypanel());
            return false;
        }
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 24: {
                n2 = 24;
                if (this.getCurrentKeyboardType() != 15) break;
                n2 = 0;
                break;
            }
            case 25: {
                n2 = 25;
                if (this.getCurrentKeyboardType() == 15) {
                    n2 = 6;
                }
                if (this.currentGenSettingAccumulationTime != -1) break;
                this.setGenericSetting(34, 3);
                break;
            }
            case 26: {
                n2 = 26;
                if (this.getCurrentKeyboardType() == 15) {
                    n2 = 13;
                    this.setGenericSetting(1, 30);
                }
                if (this.currentGenSettingAccumulationTime != -1) break;
                this.setGenericSetting(34, 3);
                break;
            }
            case 12: {
                n2 = 12;
                break;
            }
            case 23: {
                n2 = 23;
                break;
            }
            case 19: {
                n2 = 19;
                break;
            }
            case 22: {
                n2 = 22;
                break;
            }
            case 20: {
                n2 = 20;
                break;
            }
            case 21: {
                n2 = 21;
                break;
            }
        }
        if (n2 == -1) {
            this.logChannel.log(-1601830656, "KbdHandler.setRecognizerMode() <-- Returning with false. dsiMode == -1.");
            return false;
        }
        if (this.dsiKeyPanel == null) {
            this.logChannel.log(-1601830656, "KbdHandler.setRecognizerMode() <-- Returning with false. dsiKeyPanel == null.");
            return false;
        }
        this.logChannel.log(1078071040, "KbdHandler.setRecognizerMode() - Set new recognizer mode for touch pad! (dsiMode=%1)", (long)n2);
        this.dsiKeyPanel.setRecognizerMode(this.getTouchKeyboardId(), n2);
        this.currentRecognizerMode = n;
        return true;
    }

    public void updateRecognizerConfig() {
        this.logChannel.log(1078071040, "KbdHandler.updateRecognizerConfig(): currentRecognizerMode=%1", (long)this.currentRecognizerMode);
        this.currentGenSettingAccumulationTime = -1;
        if (this.currentRecognizerMode != -1) {
            this.setRecognizerMode(this.currentRecognizerMode, true);
        }
        if (this.currentRecognizerLanguageCode != -1 && this.currentRecognizerLanguage != null && this.currentRecognizerLanguage.length() > 0) {
            this.setRecognizerLanguage(this.currentRecognizerLanguage, this.currentRecognizerLanguageCode, true);
        }
        this.setRecognitionTimeoutAsia(750);
        if (this.framework.isEvoHigh() || this.framework.isEvoHighMMIKombi()) {
            this.setGenericSetting(192, 0);
        }
    }

    @Override
    public int getRecognizerMode() {
        return this.currentRecognizerMode;
    }

    @Override
    public void setRecognizerLanguage(String string, int n) {
        this.setRecognizerLanguage(string, n, false);
    }

    public void setRecognizerLanguage(String string, int n, boolean bl) {
        this.logChannel.log(1078071040, "KbdHandler.setRecognizerLanguage(language=%1, langCode=%3) currentRecognizerLanguage: %2", (Object)string, (Object)this.currentRecognizerLanguage, (long)n);
        int n2 = LangCodeMap.getDSILangCode(n);
        if (!bl && n2 == this.currentRecognizerLanguageCode && (string == null || string.equals("") || string.equals(this.currentRecognizerLanguage))) {
            return;
        }
        if (this.dsiKeyPanel != null) {
            this.logChannel.log(1078071040, "KbdHandler.setRecognizerLanguage: Set new recognizer language for touch pad! (language=%1, dsiLangCode=%2)", (Object)string, (long)n2);
            this.dsiKeyPanel.setRecognizerLanguage2(this.getTouchKeyboardId(), string, n2);
            this.currentRecognizerLanguage = string;
            this.currentRecognizerLanguageCode = n2;
        }
    }

    @Override
    public synchronized void fireTimer(Timer timer) {
        int n;
        Integer n2;
        this.logChannel.log(1078071040, "KbdHandler.fireTimer(timere=%1)", (Object)timer);
        LinkedList linkedList = new LinkedList();
        Iterator iterator = this.illumStateMap.keySet().iterator();
        while (iterator.hasNext()) {
            n2 = (Integer)iterator.next();
            n = n2;
            int n3 = (Integer)this.illumStateMap.get(n2);
            if (n3 == 0) {
                this.logChannel.log(1078071040, "KbdHandler.fireTimer: Switch off illumination! kbd_type=%1, dsi_key=%2", (long)this.getCurrentKeyboardType(), (long)n);
                this.illuminationHistory.put(new Buffer(20).append(this.framework.getMonotonicTime()).append(" - OFF - ").append(n));
                this.dsiKeyPanel.setIllumination(1, n, 0);
                continue;
            }
            linkedList.add(n2);
        }
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            n2 = (Integer)iterator.next();
            n = n2;
            this.logChannel.log(1078071040, "KbdHandler.fireTimer: Switch on illumination! kbd_type=%1, dsi_key=%2", (long)this.getCurrentKeyboardType(), (long)n);
            this.illuminationHistory.put(new Buffer(20).append(this.framework.getMonotonicTime()).append(" - ON - ").append(n));
            this.dsiKeyPanel.setIllumination(1, n, 1);
        }
        this.illumStateMap.clear();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public String getName() {
        return "KbdIllumunation";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        for (int i2 = 0; i2 < this.illuminationHistory.size(); ++i2) {
            printStream.print(this.illuminationHistory.get(i2));
            printStream.println();
        }
    }

    private void setLightingHK(int n, boolean bl) {
        int n2 = KeyMap.hkCode2DSIEvent(n);
        if (n2 == 0) {
            return;
        }
        if (bl) {
            if (this.getActiveHK() == n) {
                return;
            }
            this.setDSIIllumination(KeyMap.hkCode2DSIEvent(this.getActiveHK()), false);
            this.setActiveHK(n);
        } else {
            if (this.getActiveHK() != n) {
                return;
            }
            this.setActiveHK(-1);
        }
        this.setDSIIllumination(n2, bl);
    }

    private void setLightingSK(int n, boolean bl) {
        int n2 = KeyMap.skCode2DSIEvent(n);
        if (n2 == 0) {
            return;
        }
        if (bl) {
            if (this.getActiveSK() == n) {
                return;
            }
            this.setDSIIllumination(KeyMap.skCode2DSIEvent(this.getActiveSK()), false);
            this.setActiveSK(n);
        } else {
            if (this.getActiveSK() != n) {
                return;
            }
            this.setActiveSK(-1);
        }
        this.setDSIIllumination(n2, bl);
    }

    private void setDSIIllumination(int n, boolean bl) {
        if (this.dsiKeyPanel == null) {
            return;
        }
        int n2 = bl ? 1 : 0;
        this.logChannel.log(1078071040, "KbdHandler.setDSIIllumination: Update illumination! (key=%1, illuminationState=%2)", (long)n, (long)n2);
        this.illumStateMap.put(new Integer(n), new Integer(n2));
        this.illuminationTimer.restart();
    }

    @Override
    public void setGenericSetting(int n, int n2) {
        if (this.dsiKeyPanel != null) {
            this.logChannel.log(1078071040, "KbdHandler.setGenericSetting: Forward DSI request! (Touchpad, key=%1, value=%2)", (long)n, (long)n2);
            if (n == 34) {
                if (n2 != this.currentGenSettingAccumulationTime) {
                    this.dsiKeyPanel.setGenericSetting(9, n, n2);
                    this.currentGenSettingAccumulationTime = n2;
                } else {
                    this.logChannel.log(1078071040, "KbdHandler.setGenericSetting: new value equals old value, DSI method is not called. generic setting: %1, value: %2", (long)n, (long)n2);
                }
            } else {
                this.dsiKeyPanel.setGenericSetting(this.getTouchKeyboardId(), n, n2);
            }
        }
    }

    private int getActiveHK() {
        return this.hardkey;
    }

    private int getActiveSK() {
        return this.softkey;
    }

    private void setActiveHK(int n) {
        this.hardkey = n;
    }

    private void setActiveSK(int n) {
        this.softkey = n;
    }

    @Override
    public void setTouchSensitiveArea(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "KbdHandler.setTouchSensitiveArea(x=%1, y=%2)", (long)n, (long)n2);
        this.logChannel.log(1078071040, "KbdHandler.setTouchSensitiveArea(width=%1, height=%2)", (long)n3, (long)n4);
        if (this.dsiKeyPanel != null) {
            this.dsiKeyPanel.setTouchSensitiveArea(this.getTouchKeyboardId(), n, n2, n3, n4);
        } else {
            this.logChannel.log(10000, "KbdHandler.setTouchSensitiveArea: no dsiKeyPanel available!");
        }
    }

    private int getTouchKeyboardId() {
        return this.framework.isPorsche() || this.framework.isPGen2() ? 13 : 9;
    }

    @Override
    public void setIgnoreNextMutePressButtonFlag() {
        this.kbdListener.setIgnoreNextMutePressButtonFlag();
    }

    @Override
    public void setRecognitionTimeoutAsia(int n) {
        try {
            if (this.framework.isAsia()) {
                this.setGenericSetting(2, n / 10);
            }
        }
        catch (FrameworkException frameworkException) {
            this.logChannel.log(10000, "KbdHandler#setRecognitionTimeoutAsia: Frameworkexception when calling isAsia. Maybe the Sysconsts are not initialized. Set the timeout anyway!");
            this.setGenericSetting(2, n / 10);
        }
    }

    public void initializeAsiaRecognizerTimeoutModel() {
        ChoiceModelApp choiceModelApp = this.framework.getHMIService().getChoiceModel(4188);
        choiceModelApp.setValue(1);
        choiceModelApp.setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "KbdHandler#itemSelected: modelID=%1, itemID=%2", (long)n, (long)n2);
        ChoiceModelApp choiceModelApp = this.framework.getHMIService().getChoiceModel(n);
        if (choiceModelApp != null && n == 4188) {
            switch (n2) {
                case 0: {
                    this.setRecognitionTimeoutAsia(1000);
                    choiceModelApp.setValue(n2);
                    break;
                }
                case 1: {
                    this.setRecognitionTimeoutAsia(750);
                    choiceModelApp.setValue(n2);
                    break;
                }
                case 2: {
                    this.setRecognitionTimeoutAsia(500);
                    choiceModelApp.setValue(n2);
                    break;
                }
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void setAdditionHKIllumination(int n, boolean bl) {
        int n2 = KeyMap.hkCode2DSIEvent(n);
        if (n2 == 0) {
            return;
        }
        this.setDSIIllumination(n2, bl);
    }

    @Override
    public void clearRecognizer() {
        this.logChannel.log(1078071040, "KbdHandler.clearRecognizer()");
        if (this.dsiKeyPanel != null) {
            this.logChannel.log(1078071040, "KbdHandler.clearRecognizer: Clear Recognizer keyboardID = %1", (long)this.getTouchKeyboardId());
            this.dsiKeyPanel.clearRecognizer(this.getTouchKeyboardId());
        }
    }
}

