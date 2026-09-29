/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.view.IKeyBoardManager;
import de.audi.atip.interapp.ExternalKeyListener;
import de.audi.atip.interapp.IEjectHandler;
import de.audi.atip.interapp.RSESettingsEventListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.audio.SDISRangeListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IMMICombiViewSizeSync;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.power.PowerEventListener;
import de.audi.kbd.KeyMap;
import de.audi.kbd.dsi.ComboKeyDetector;
import de.audi.kbd.dsi.GestureStateMachine;
import de.audi.kbd.dsi.KbdHandler;
import de.audi.kbd.dsi.KbdListener$1;
import de.audi.kbd.dsi.KbdListener$VolumeLongPressTimer;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class KbdListener
implements ServiceTrackerCustomizer,
DSIKeyPanelListener,
ExternalKeyListener,
PowerEventListener,
RSESettingsEventListener,
MsgListener {
    private static final int A3_WORKAROUND_INACTIVE;
    private static final int ONE_FINGER;
    private static final boolean IS_OLD_KEYPANEL;
    private final IFrameworkAccess fwServices;
    private final LogChannel logChannelInput;
    private final LogChannel logChannelKeyEvent;
    private final IKeyBoardManager keyBoardManager;
    private final ComboKeyDetector comboKeyDetector;
    private volatile IMMICombiViewSizeSync iMMICombiViewSizeSync = null;
    private volatile SDSService sdsService = null;
    private volatile IEjectHandler ejectHandler = null;
    private volatile IViewSizeManager viewSizeManager = null;
    private final Object powerEventLock = new Object();
    private volatile boolean ejectPending = false;
    private boolean restrictFunctionUsage;
    private boolean childProtectionActivated;
    private boolean touchPad2Pressed = false;
    private volatile int currentKeyboardType = 0;
    private int[] powerState = new int[8];
    private volatile int previousSubClickCount;
    private boolean isHandsOnRing = false;
    private final boolean isRSE;
    private final boolean a3WorkaroundActive;
    private int currentViewSize = 2;
    private volatile boolean ignoreNextMutePressButtonFlag;
    private KbdHandler kbdHandler;
    private Job[] keyEventJobs = new Job[150];
    private static final int LONG_PRESS_TIME;
    private static final int DOUBLE_PRESS_TIME;
    private GestureStateMachine gestureIDcalculator;
    private final ServiceTracker tracker;
    private SDISRangeListener volumeChangerService = null;
    private final KbdListener$VolumeLongPressTimer volumeLongPressTimer = new KbdListener$VolumeLongPressTimer(this, null);
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$SDISRangeListener;

    public KbdListener(IFrameworkAccess iFrameworkAccess, IKeyBoardManager iKeyBoardManager) {
        this.fwServices = iFrameworkAccess;
        this.keyBoardManager = iKeyBoardManager;
        this.logChannelInput = this.fwServices.getLogChannel("Fw.Kbd.Input");
        this.logChannelKeyEvent = this.fwServices.getLogChannel("Fw.Kbd.KeyEvent");
        this.comboKeyDetector = new ComboKeyDetector(this.fwServices, this);
        this.gestureIDcalculator = new GestureStateMachine();
        this.isRSE = !this.fwServices.isFrontMU();
        this.a3WorkaroundActive = this.fwServices.getStorageMgr().getInt(262, 20, 0) != 0;
        this.tracker = new ServiceTracker(this.fwServices.getBundleCxt(), new String[]{(class$de$audi$atip$interapp$audio$SDISRangeListener == null ? (class$de$audi$atip$interapp$audio$SDISRangeListener = KbdListener.class$("de.audi.atip.interapp.audio.SDISRangeListener")) : class$de$audi$atip$interapp$audio$SDISRangeListener).getName()}, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    public void setKbdHandler(KbdHandler kbdHandler) {
        this.kbdHandler = kbdHandler;
    }

    private IFrameworkAccess getFramework() {
        return this.fwServices;
    }

    public int getCurrentKeyboardType() {
        return this.currentKeyboardType;
    }

    public void setIMMICombiViewSizeSync(IMMICombiViewSizeSync iMMICombiViewSizeSync) {
        this.iMMICombiViewSizeSync = iMMICombiViewSizeSync;
    }

    public void setSDSService(SDSService sDSService) {
        this.logChannelInput.log(1078071040, "KbdListener.setSDSService(%1)", (Object)sDSService);
        this.sdsService = sDSService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setEjectHandler(IEjectHandler iEjectHandler) {
        this.logChannelInput.log(1078071040, "KbdListener.setEjectHandler(%1)", (Object)iEjectHandler);
        boolean bl = false;
        KbdListener kbdListener = this;
        synchronized (kbdListener) {
            this.ejectHandler = iEjectHandler;
            if (iEjectHandler != null && this.ejectPending) {
                bl = true;
                this.ejectPending = false;
            }
        }
        if (bl) {
            this.logChannelInput.log(1078071040, "KbdListener.setEjectHandler: Forward pending eject command to eject handler (service=%1)", (Object)iEjectHandler);
            iEjectHandler.ejectCD();
        }
    }

    public void triggerHmiKeyPressedEvent(int n, int n2) {
        this.logChannelKeyEvent.log(-2137614336, "KbdListener.triggerHmiKeyPressedEvent(%1, %2)", (long)n, (long)n2);
        this.keyBoardManager.fireKeyEvent(10401, this.fwServices.getMonotonicTime(), n, n2);
    }

    public void triggerKeyPressedEvent(int n, int n2) {
        this.logChannelKeyEvent.log(-2137614336, "KbdListener.triggerKeyPressedEvent(%1, %2)", (long)n, (long)n2);
        this.fireKeyPressedEvent(n, n2);
    }

    public void triggerKeyReleasedEvent(int n, int n2) {
        this.logChannelKeyEvent.log(-2137614336, "KbdListener.triggerKeyReleasedEvent(%1, %2)", (long)n, (long)n2);
        this.fireKeyReleasedEvent(n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.logChannelInput.log(1078071040, "KbdListener.notifyPowerListenerOnEnterState(%1, %2)", (long)n, (long)n2);
        Object object = this.powerEventLock;
        synchronized (object) {
            this.powerState[n2] = n;
        }
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannelInput.log(1078071040, "KbdListener.updateClampState(clamp15=%1)", bl2);
    }

    @Override
    public void processAudioUsageRestriction(boolean bl) {
    }

    @Override
    public void processTunerUsageRestriction(boolean bl) {
    }

    @Override
    public void processTVUsageRestriction(boolean bl) {
    }

    @Override
    public void processCDCUsageRestriction(boolean bl) {
    }

    @Override
    public void processFunctionUsageRestriction(boolean bl) {
        this.logChannelInput.log(1078071040, "KbdListener.processFunctionUsageRestriction(%1)", bl);
        this.restrictFunctionUsage = bl;
    }

    @Override
    public void processChildProtection(boolean bl) {
        this.logChannelInput.log(1078071040, "KbdListener.processChildProtection(%1)", bl);
        this.childProtectionActivated = bl;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannelInput.log(10000, "KbdListener.asyncException(errorCode=%1, requestType=%2)", (long)n, (long)n2);
        this.logChannelInput.log(10000, "KbdListener.asyncException(errorMsg=%1)", (Object)string);
    }

    @Override
    public void updateKey2(int n, int n2, int n3, int n4, int n5) {
        this.logChannelInput.log(-1601830656, "KbdListener.updateKey2(keyboardID=%1, keyID=%2, keyState=%3)", (long)n, (long)n2, (long)n3);
        this.logChannelInput.log(-1601830656, "KbdListener.updateKey2(time=%1, validFlag=%2)", (long)n4, (long)n5);
        if (n5 != 1) {
            if (n == 13 && n5 == 2 && (n2 == 61 || n2 == 62 || n2 == 63 || n2 == 64 || n2 == 65 || n2 == 66 || n2 == 101 || n2 == 102)) {
                this.updateKeyInternal(n, n2, 7);
            }
            return;
        }
        if (n2 == 105) {
            if (n3 == 6) {
                this.isHandsOnRing = true;
            } else if (n3 == 7) {
                this.isHandsOnRing = false;
            }
            this.logChannelInput.log(-2137614336, "KbdListener.updateKey2(isHandsOnRing=%1)", this.isHandsOnRing);
        }
        this.updateKeyInternal(n, n2, n3);
    }

    @Override
    public void supplyExternalKey(int n, int n2, int n3, int n4) {
        this.logChannelInput.log(-1601830656, "KbdListener.supplyExternalKey(keyboardID=%1, keyID=%2, keyState=%3)", (long)n, (long)n2, (long)n3);
        this.logChannelInput.log(-1601830656, "KbdListener.supplyExternalKey(validFlag=%1)", (long)n4);
        if (n4 == 1) {
            this.updateKeyInternal(n, n2, n3);
        }
    }

    private void fireGestureEvent(int n, int n2, int n3, int n4, int n5, int n6, long l, int n7) {
        int n8 = KeyMap.getHmiGestureKeyCode(n);
        if (n8 == 10901) {
            this.logChannelKeyEvent.log(-1601830656, "KbdListener.fireGestureEvent: Ignore input key! (keyCode=%1)", (long)n);
            return;
        }
        this.keyBoardManager.fireGestureEvent(n8, n2, n3, n4, n5, n6, l, n7);
    }

    private void updateGesture(int n, int n2, int n3, int n4, int n5) {
        this.logChannelInput.log(-1601830656, "KbdListener.updateGesture(keyboardID=%1, gestureId=%2, validFlag=%3)", (long)n, (long)n2, (long)n5);
        this.logChannelInput.log(-1601830656, "KbdListener.updateGesture(x=%1, y=%2)", (long)n3, (long)n4);
        if (n5 == 1 && !this.getFramework().isPorsche()) {
            switch (n2) {
                case 1: {
                    this.fireTouchEvent(10906, 0, 0, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 2: {
                    this.fireTouchEvent(10907, 0, 0, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 4: {
                    this.fireTouchEvent(10904, n3, n4, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 3: {
                    this.fireTouchEvent(10905, n3, n4, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 8: 
                case 13: {
                    this.fireTouchEvent(10911, n3, n4, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 5: {
                    this.fireTouchEvent(10912, n3, n4, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 9: {
                    this.fireTouchEvent(10913, n3, n4, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 0: 
                case 12: {
                    this.fireTouchEvent(10914, n3, n4, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                case 6: {
                    break;
                }
                case 10: {
                    break;
                }
                case 7: {
                    break;
                }
                case 11: {
                    break;
                }
            }
        }
    }

    @Override
    public void updateDisplayTurnMechStatus(int n, int n2) {
        this.logChannelInput.log(-1601830656, "KbdListener.updateDisplayTurnMechStatus(displayTurnMechStatus=%1, validFlag=%2)", (long)n, (long)n2);
    }

    @Override
    public void updateRecognizerMode(int n, int n2, int n3) {
        this.logChannelInput.log(-2137614336, "KbdListener.updateRecognizerMode(keyboardID=%1, recognizerMode=%2, validFlag=%3)", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void updateProximity(int n, int n2, int n3) {
        this.logChannelInput.log(-1601830656, "KbdListener.updateProximity(keyboardID=%1, distance=%2, validFlag=%3)", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.fireProximityEvent(n2, KeyMap.kbdID2termID(n));
        }
    }

    @Override
    public void genericSettingResponse(int n, int n2, int n3) {
        this.logChannelInput.log(-2137614336, "KbdListener.genericSettingResponse(respKeyboardID=%1, respKey=%2, respValue=%3)", (long)n, (long)n2, (long)n3);
        this.kbdHandler.setGenericSettingResponse(n2, n3);
    }

    @Override
    public void lastKey(int n, int n2, int n3) {
    }

    @Override
    public void updateEncoder2(int n, int n2, int n3, int n4, int n5) {
        this.logChannelInput.log(-1601830656, "KbdListener.updateEncoder2(keyboardID=%1, keyID=%2, incCount=%3)", (long)n, (long)n2, (long)n3);
        this.logChannelInput.log(-1601830656, "KbdListener.updateEncoder2(time=%1, validFlag=%2)", (long)n4, (long)n5);
        if (n2 == 5) {
            byte by = (byte)n3;
            byte by2 = (byte)(n3 >> 8);
            this.logChannelInput.log(-1601830656, "KbdListener.updateEncoder2: hDDS event: mainClicks=%1 and subClicks=%2", (long)by, (long)by2);
            if (this.isHandsOnRing) {
                this.updateEncoderInternal(n, 16, by, by2, n5);
            } else if (by != 0) {
                this.logChannelInput.log(-1601830656, "KbdListener.updateEncoder2: Hands are not on ring - do not propagate sublicks");
                this.updateEncoderInternal(n, 16, by, 0, n5);
            } else {
                this.logChannelInput.log(-1601830656, "KbdListener.updateEncoder2: Ignore updateEncoder because it only has subClicks an hand is not on Ring");
            }
        } else {
            this.updateEncoderInternal(n, n2, n3, n5);
        }
    }

    @Override
    public void updateRecognizerLanguage2(int n, String string, int n2, int n3) {
        this.logChannelInput.log(-2137614336, "KbdListener.updateRecognizerLanguage2(keyboardID=%1, validFlag=%2)", (long)n, (long)n3);
        this.logChannelInput.log(-2137614336, "KbdListener.updateRecognizerLanguage2(language=%1, langCode=%2)", (Object)string, (long)n2);
    }

    @Override
    public void updateCharacterEvent2(int n, String[] stringArray, int[] nArray, int n2) {
        this.logChannelInput.log(-1601830656, "KbdListener.updateCharacterEvent2(keyboardID=%1, validFlag=%2)", (long)n, (long)n2);
        this.logChannelInput.log(-1601830656, "KbdListener.updateCharacterEvent2(recognizedCharacters=%1)", (Object)stringArray);
        this.logChannelInput.log(-1601830656, "KbdListener.updateCharacterEvent2(confidence=%1)", (Object)nArray);
        if (n2 != 1) {
            return;
        }
        if (this.getFramework().isPorsche()) {
            if (stringArray != null && nArray != null) {
                this.fireRecognizedGestureEvent(stringArray, nArray, KeyMap.kbdID2termID(n));
            } else {
                this.logChannelInput.log(-1601830656, "KbdListener.updateCharacterEvent2: recognizedCharacters or confidence are null - discard");
            }
        } else if (stringArray != null && nArray != null) {
            Buffer buffer = new Buffer(stringArray.length);
            int n3 = Math.min(stringArray.length, nArray.length);
            for (int i2 = 0; i2 < n3; ++i2) {
                String string = stringArray[i2];
                if (string == null) continue;
                if (string.length() == 1) {
                    buffer.append(string);
                    continue;
                }
                if (string.length() <= 1) continue;
                this.logChannelInput.log(-1601830656, "KbdListener.updateCharacterEvent2: The keypanel recognized multiple character result. They will be mapped. recognizedString=%1", (Object)string);
                char c2 = this.mapCharacter(string);
                buffer.append(c2);
            }
            if (buffer.length() == 0 && stringArray.length > 0 && stringArray[0] != null) {
                buffer.append(stringArray[0]);
            }
            int[] nArray2 = new int[buffer.length()];
            System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, buffer.length());
            this.fireRecognizedTouchEvent(buffer.toString(), nArray2, KeyMap.kbdID2termID(n));
        } else {
            this.logChannelInput.log(10000, "KbdListener.updateCharacterEvent2: recognizedCharacters or confidence are null - sending empty event");
            this.fireRecognizedTouchEvent("", null, KeyMap.kbdID2termID(n));
        }
    }

    private char mapCharacter(String string) {
        if (string.equals("\u0644\u0627")) {
            return '\ufbfe0000';
        }
        if (string.equals("\u0644\u0622")) {
            return '\uf5fe0000';
        }
        if (string.equals("\u0644\u0623")) {
            return '\uf7fe0000';
        }
        if (string.equals("\u0644\u0625")) {
            return '\uf9fe0000';
        }
        return string.charAt(0);
    }

    @Override
    public void updateGesture2(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7, int n8, int n9) {
        if (this.logChannelInput.isDebug()) {
            Buffer buffer = new Buffer(144);
            buffer.append("keyboardID=").append(n).append(' ');
            buffer.append("gestureID=").append(n2).append(' ');
            buffer.append("fingerCount=").append(n3).append(' ');
            buffer.append("palm=").append(bl).append(' ');
            buffer.append("x=").append(n4).append(' ');
            buffer.append("y=").append(n5).append(' ');
            buffer.append("param1(angle)=").append(n6).append(' ');
            buffer.append("param2(distance)=").append(n7).append(' ');
            buffer.append("time=").append(n8).append(' ');
            buffer.append("validFlag=").append(n9).append(' ');
            this.logChannelInput.log(-2137614336, "KbdListener.updateGesture2( %1)", (Object)buffer);
        }
        if (n9 != 1) {
            return;
        }
        int n10 = n6;
        int n11 = n7;
        if (this.getFramework().isPorsche()) {
            int n12 = KeyMap.kbdID2termID(n);
            if (this.powerstateNoDisplay(n12)) {
                this.reactivateDisplay(n, 33, n12);
            } else {
                this.fireGestureEvent(n2, n3, n4, n5, n6, n7, n8, KeyMap.kbdID2termID(n));
            }
        } else if (this.kbdHandler.getCurrentKeyboardType() == 15) {
            this.updateGesture(n, n2, n4, n5, n9);
        } else if (n == 9) {
            if (this.touchPad2Pressed) {
                if (n3 == 0) {
                    this.fireTouchEvent(10905, n4, n5, n3, bl, n10, n11, n8, KeyMap.kbdID2termID(n));
                    this.touchPad2Pressed = false;
                } else {
                    this.fireTouchEvent(10911, n4, n5, n3, bl, n10, n11, n8, KeyMap.kbdID2termID(n));
                }
            } else if (n3 > 0) {
                this.fireTouchEvent(10904, n4, n5, n3, bl, n10, n11, n8, KeyMap.kbdID2termID(n));
                this.touchPad2Pressed = true;
            }
        } else if (n == 13) {
            int n13 = this.gestureIDcalculator.calculateGestureID(n3, n4, n5);
            this.fireGestureEvent(n13, n3, n4, n5, n6, n7, n8, KeyMap.kbdID2termID(n));
        }
    }

    @Override
    public void updateKeyboardType(int n, int n2) {
        System.out.println(new StringBuffer().append("KbdListener.updateKeyboardType(keyboardType=").append(n).append(", validFlag=").append(n2).append(")").toString());
        this.logChannelInput.log(-2137614336, "KbdListener.updateKeyboardType(keyboardType=%1, validFlag=%2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.currentKeyboardType = n;
            this.kbdHandler.updateRecognizerConfig();
            try {
                ChoiceModel choiceModel = (ChoiceModel)this.getFramework().getHMIService().getModel(4076);
                if (choiceModel != null) {
                    choiceModel.setValue(this.currentKeyboardType);
                }
            }
            catch (Exception exception) {
                this.logChannelInput.log(10000, "KbdListener#updateKeyboardType exception=%1", (Object)exception.toString());
            }
        }
    }

    @Override
    public void updateTouchSensitiveArea(int n, int n2, int n3, int n4, int n5, int n6) {
        this.logChannelInput.log(1078071040, "KbdListener.updateTouchSensitiveArea( keybordID=%1, x=%2, y=%3 )", (long)n, (long)n2, (long)n3);
        this.logChannelInput.log(1078071040, "KbdListener.updateTouchSensitiveArea( width=%1, height=%2, validFlag=%3 )", (long)n4, (long)n5, (long)n6);
        this.keyBoardManager.fireGestureEvent(10914, 0, n2, n3, n4, n5, -1L, KeyMap.kbdID2termID(n));
    }

    @Override
    public void updateInputPanelReady(int n, int n2, int n3) {
        this.logChannelInput.log(1078071040, "KbdListener.updateInputPanelReady(keyboardID=%1, startupState=%2, validFlag=%3)", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            this.kbdHandler.updateRecognizerConfig();
        }
    }

    @Override
    public void getVersionInfo(int n, int n2, String string) {
        this.logChannelInput.log(1078071040, "KbdListener.getVersionInfo(keyboardID=%2, versionInfo=%3, version=%1)", (Object)string, (long)n, (long)n2);
    }

    private void handleSimulateMIB2JUpJDownViaSESW(int n, int n2, int n3, int n4) {
        if (n == 1 && n3 == 1) {
            if (n2 == 9) {
                this.fireJoystickEvent(28, n4);
            } else if (n2 == 12) {
                this.fireJoystickEvent(24, n4);
            }
        }
    }

    private synchronized void updateKeyInternal(int n, int n2, int n3) {
        if (KeyMap.isVolumeKey(n2) && this.ignoreNextMutePressButtonFlag) {
            this.ignoreNextMutePressButtonFlag = false;
            return;
        }
        int n4 = KeyMap.kbdID2termID(n);
        boolean bl = this.standBy(n4);
        if (IS_OLD_KEYPANEL && !bl) {
            this.handleSimulateMIB2JUpJDownViaSESW(n, n2, n3, n4);
        }
        if (this.checkMFWFilters(n, n2, bl)) {
            if (this.isMIB2HighMMICombi() && (n2 == 37 || n2 == 36)) {
                if (this.sdsService != null) {
                    this.logChannelInput.log(-1601830656, "KbdListener.updateKeyInternal: abort sds session upon arrow left/right");
                    this.sdsService.abortSDSSession(false, (byte)2);
                }
                if (this.viewSizeManager != null) {
                    long l = this.fwServices.getMonotonicTime();
                    RunnableEvent runnableEvent = new RunnableEvent(false, new KbdListener$1(this, n3, l));
                    this.fwServices.getHMIService().getEventDispatcher().postEvent(runnableEvent);
                }
            }
            return;
        }
        if (this.a3WorkaroundActive && this.isMIB2HighMMICombi()) {
            if (n2 == 14) {
                if (n3 == 1) {
                    this.toggleViewSize();
                }
                return;
            }
            if (n2 == 10) {
                n2 = 78;
            }
        }
        switch (n3) {
            case 1: {
                if (n2 == 33) {
                    this.fireKeyPressedEvent(n2, n4);
                    break;
                }
                if (n2 == 32) {
                    this.handleEject();
                    break;
                }
                if (n == 5 || n == 6 || n == 7) {
                    this.fireJoystickEvent(n2, n4);
                    break;
                }
                if (n == 9 && n2 >= 23 && n2 <= 31) {
                    this.fireJoystickEvent(n2, n4);
                    break;
                }
                if (n2 == 42) {
                    if (this.volumeChangerService != null) {
                        this.logChannelInput.log(-2137614336, "KbdListener#updateKeyInternal() - Changing (inc) volume via SDISRangeListener.");
                        this.volumeChangerService.increment(-1, 1, n4);
                        break;
                    }
                    this.logChannelInput.log(-1601830656, "KbdListener#updateKeyInternal() - No SDISRangeListener available, changing (inc) volume via Fallback Implementation.");
                    this.fireWheelButtonEvent(16, 0, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                if (n2 == 43) {
                    if (this.volumeChangerService != null) {
                        this.logChannelInput.log(-2137614336, "KbdListener#updateEncoderInternal() - Changing (inc) volume via SDISRangeListener.");
                        this.volumeChangerService.decrement(-1, 1, n4);
                        break;
                    }
                    this.logChannelInput.log(-1601830656, "KbdListener#updateEncoderInternal() - No SDISRangeListener available, changing (inc) volume via Fallback Implementation.");
                    this.fireWheelButtonEvent(16, 1, 1, KeyMap.kbdID2termID(n));
                    break;
                }
                if (bl) {
                    if (this.fwServices.isFrontMU() && KeyMap.isVolumeKey(n2)) {
                        this.logChannelInput.log(-1601830656, "KbdListener.updateKeyInternal: Ignore volume key on main unit during standby!");
                        break;
                    }
                } else if (this.powerstateNoDisplay(n4) && (n2 == 13 || n2 == 16)) {
                    this.logChannelInput.log(-1601830656, "KbdListener.updateKeyInternal: Ignore back key if power state is HMI_ON_NO_DISPLAY!");
                    break;
                }
                if (!bl && this.comboKeyDetector.keyPressedConsumed(n2, n4)) break;
                this.fireKeyPressedEvent(n2, n4);
                if (n2 != 50 || !this.fwServices.isPorsche()) break;
                Job job = this.keyEventJobs[n2];
                if (job != null) {
                    KeyEvent keyEvent = (KeyEvent)job.getPayload();
                    long l = keyEvent.getWhen() - 0;
                    if (this.fwServices.getMonotonicTime() - l < 0) {
                        this.fireKeyDoublePressedEvent(n2, n4);
                    }
                }
                this.keyEventJobs[n2] = job = this.fireKeyLongPressedEvent(n2, 0, n4);
                break;
            }
            case 0: {
                Job job;
                if (n2 == 42 || n2 == 43) {
                    KbdListener$VolumeLongPressTimer.access$200(this.volumeLongPressTimer);
                    break;
                }
                if (n == 5) {
                    this.fireJoystickEvent(n2, n4);
                    break;
                }
                if (this.comboKeyDetector.keyReleasedConsumed(n2, n4)) break;
                if (n2 == 50 && this.fwServices.isPorsche() && (job = this.keyEventJobs[n2]) != null) {
                    job.cancel();
                }
                this.fireKeyReleasedEvent(n2, n4);
                break;
            }
            case 3: {
                if (n2 == 42) {
                    KbdListener$VolumeLongPressTimer.access$300(this.volumeLongPressTimer, 0, n);
                } else if (n2 == 43) {
                    KbdListener$VolumeLongPressTimer.access$300(this.volumeLongPressTimer, 1, n);
                }
                this.fireKeyLongPressedEvent(n2, 0L, n4);
                break;
            }
            case 2: {
                if (n2 == 50) {
                    this.fireKeyDoublePressedEvent(n2, n4);
                    break;
                }
                this.fireKeyPressedEvent(n2, n4);
                break;
            }
            case 6: {
                if (n != 9 && n != 1 && n != 13) break;
                this.fireTouchEvent(10909, n2, 0, 0, 0, n4);
                break;
            }
            case 7: {
                if (n != 9 && n != 1 && n != 13) break;
                this.fireTouchEvent(10910, n2, 0, 0, 0, n4);
                break;
            }
        }
        if (this.checkPowerManagementTriggerDisplayButton(n2, n3)) {
            this.reactivateDisplay(n, n2, n4);
        }
        if (this.checkPowerManagementTriggerHardKey(n2, n3)) {
            this.triggerHK(n, n2, n4);
        }
        if (this.powerstateNoDisplay(n4) && this.checkPowerManagementTriggerSoftKey(n2, n3)) {
            this.triggerHK(n, n2, n4);
        }
    }

    private void updateEncoderInternal(int n, int n2, int n3, int n4) {
        this.updateEncoderInternal(n, n2, n3, 0, n4);
    }

    private void updateEncoderInternal(int n, int n2, int n3, int n4, int n5) {
        if (n5 != 1) {
            return;
        }
        if (this.restrictFunctionUsage && this.isRSE && !KeyMap.isVolumeKey(n2)) {
            this.logChannelInput.log(-1601830656, "KbdListener.updateEncoderInternal:  Function restriction is active! Ignore key event! (keyID=%1)", (long)n2);
            return;
        }
        int n6 = KeyMap.kbdID2termID(n);
        if (this.checkMFWFilters(n, n2, this.standBy(n6))) {
            return;
        }
        switch (n2) {
            case 16: {
                if (this.powerstateNoDisplay(n6)) {
                    this.logChannelInput.log(-2137614336, "KbdListener.updateEncoderInternal: Ignore DDS key if power state is HMI_ON_NO_DISPLAY!");
                    this.reactivateDisplay(n, n2, n6);
                    break;
                }
                if (n3 > 0) {
                    this.previousSubClickCount = n4;
                    this.fireWheelButtonEvent(17, 0, n3, n4, n6);
                    break;
                }
                if (n3 < 0) {
                    this.previousSubClickCount = n4;
                    this.fireWheelButtonEvent(17, 1, -1 * n3, n4, n6);
                    break;
                }
                boolean bl = this.previousSubClickCount < n4;
                this.previousSubClickCount = n4;
                int n7 = bl ? 0 : 1;
                this.fireWheelButtonEvent(17, n7, n3, n4, n6);
                break;
            }
            case 17: 
            case 44: 
            case 88: {
                if (n3 > 0) {
                    if (this.volumeChangerService != null) {
                        this.logChannelInput.log(-2137614336, "KbdListener#updateEncoderInternal() - Changing (inc) volume via SDISRangeListener.");
                        this.volumeChangerService.increment(-1, n3, n6);
                        break;
                    }
                    this.logChannelInput.log(-1601830656, "KbdListener#updateEncoderInternal() - No SDISRangeListener available, changing (inc) volume via Fallback Implementation.");
                    this.fireWheelButtonEvent(16, 0, n3, n6);
                    break;
                }
                if (this.volumeChangerService != null) {
                    this.logChannelInput.log(-2137614336, "KbdListener#updateEncoderInternal() - Changing (dec) volume via SDISRangeListener.");
                    this.volumeChangerService.decrement(-1, -n3, n6);
                    break;
                }
                this.logChannelInput.log(-1601830656, "KbdListener#updateEncoderInternal() - No SDISRangeListener available, changing (dec) volume via Fallback Implementation.");
                this.fireWheelButtonEvent(16, 1, -1 * n3, n6);
                break;
            }
            case 40: {
                if (n3 > 0) {
                    this.fireWheelButtonEvent(20, 1, n3, n6);
                    break;
                }
                this.fireWheelButtonEvent(20, 0, -1 * n3, n6);
                break;
            }
            case 76: {
                if (n3 > 127) {
                    this.fireWheelButtonEvent(64, 1, 256 - n3, KeyMap.kbdID2termID(n));
                    break;
                }
                this.fireWheelButtonEvent(64, 0, n3, KeyMap.kbdID2termID(n));
                break;
            }
            case 77: {
                if (n3 > 127) {
                    this.fireWheelButtonEvent(65, 1, 256 - n3, KeyMap.kbdID2termID(n));
                    break;
                }
                this.fireWheelButtonEvent(65, 0, n3, KeyMap.kbdID2termID(n));
                break;
            }
        }
    }

    private void toggleViewSize() {
        if (this.iMMICombiViewSizeSync != null) {
            this.currentViewSize = this.currentViewSize == 1 ? 2 : 1;
            this.logChannelInput.log(-2137614336, "KbdListener.toggleViewSize:  Trigger change of HMI view size! (size=%1)", (long)this.currentViewSize);
            this.iMMICombiViewSizeSync.requestViewSize(this.currentViewSize);
        } else {
            this.logChannelInput.log(-2137614336, "KbdListener.toggleViewSize:  No change of HMI view size possible! Service IMMICombiViewSizeSync is not available!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleEject() {
        IEjectHandler iEjectHandler;
        boolean bl = false;
        KbdListener kbdListener = this;
        synchronized (kbdListener) {
            iEjectHandler = this.ejectHandler;
            this.ejectPending = iEjectHandler == null;
            bl = !this.ejectPending;
        }
        if (bl) {
            this.logChannelInput.log(-2137614336, "KbdListener.handleEject: Forward eject command to eject handler! (service=%1)", (Object)iEjectHandler);
            iEjectHandler.ejectCD();
        }
    }

    private void reactivateDisplay(int n, int n2, int n3) {
        if (n == 1 || n == 10 || n == 2 || n == 3 || n == 13) {
            this.logChannelInput.log(-2137614336, "KbdListener.reactivateDisplay: Trigger power management! (terminal=%1, keyID=%2)", (long)n3, (long)n2);
            this.fwServices.getPowerMgr().displayButtonTyped(n3, n2);
        }
    }

    private void triggerHK(int n, int n2, int n3) {
        if (n == 1 || n == 10 || n == 2 || n == 3 || n == 13) {
            this.logChannelInput.log(-2137614336, "KbdListener.triggerHK: Trigger power management! (terminal=%1, keyID=%2)", (long)n3, (long)n2);
            this.fwServices.getPowerMgr().hardKeyTyped(n3, n2);
        }
    }

    private boolean standBy(int n) {
        if (n >= 0 && n < 8) {
            switch (this.getPowerState(n)) {
                case 2: {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean checkPowerManagementTriggerDisplayButton(int n, int n2) {
        boolean bl = false;
        if (n == 33 && n2 == 1) {
            bl = true;
        }
        return bl;
    }

    private boolean checkPowerManagementTriggerHardKey(int n, int n2) {
        boolean bl = false;
        if (n2 == 0) {
            switch (n) {
                case 7: {
                    bl = !this.fwServices.isPorsche();
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 15: 
                case 68: 
                case 78: 
                case 86: 
                case 103: 
                case 104: {
                    bl = true;
                    break;
                }
            }
        }
        return bl;
    }

    private boolean checkPowerManagementTriggerSoftKey(int n, int n2) {
        boolean bl = false;
        if (n2 == 0) {
            switch (n) {
                case 8: 
                case 9: 
                case 11: 
                case 12: 
                case 13: 
                case 16: 
                case 97: 
                case 98: {
                    bl = true;
                    break;
                }
            }
        }
        return bl;
    }

    private boolean powerstateNoDisplay(int n) {
        if (n >= 0 && n < 8) {
            switch (this.getPowerState(n)) {
                case 1: {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getPowerState(int n) {
        Object object = this.powerEventLock;
        synchronized (object) {
            return this.powerState[n];
        }
    }

    private void fireTouchEvent(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = KeyMap.getHmiKeyCode(n2);
        if (n7 == 0) {
            this.logChannelKeyEvent.log(-1601830656, "KbdListener.fireTouchEvent: Ignore input key! (keyCode=%1)", (long)n2);
            return;
        }
        this.keyBoardManager.fireTouchEvent(n, this.fwServices.getMonotonicTime(), n7, n3, n4, n5, n6);
    }

    private void fireTouchEvent(int n, int n2, int n3, int n4, int n5) {
        this.keyBoardManager.fireTouchEvent(n, this.fwServices.getMonotonicTime(), 0, n2, n3, n4, n5);
    }

    private void fireTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.keyBoardManager.fireTouchEvent(n, this.fwServices.getMonotonicTime(), 0, n2, n3, n4, n5, n6, n7, n8);
    }

    private void fireTouchEvent(int n, int n2, int n3, int n4, boolean bl, int n5, int n6, int n7, int n8) {
        this.keyBoardManager.fireTouchEvent(n, this.fwServices.getMonotonicTime(), 0, n2, n3, n4, bl, n5, n6, n7, n8);
    }

    private void fireRecognizedGestureEvent(String[] stringArray, int[] nArray, int n) {
        this.keyBoardManager.fireGestureEvent(10910, this.fwServices.getMonotonicTime(), 0, 0, stringArray, nArray, n);
    }

    private void fireRecognizedTouchEvent(String string, int[] nArray, int n) {
        this.keyBoardManager.fireTouchEvent(10908, this.fwServices.getMonotonicTime(), 0, 0, 0, string, nArray, n);
    }

    private void fireKeyPressedEvent(int n, int n2) {
        int n3 = KeyMap.getHmiKeyCode(n);
        if (n3 == 0) {
            this.logChannelKeyEvent.log(-1601830656, "KbdListener.fireKeyPressedEvent: Ignore input key! (keyCode=%1)", (long)n);
            return;
        }
        this.abortSDSsession(n3);
        if (n != 33) {
            this.keyBoardManager.fireKeyEvent(10401, this.fwServices.getMonotonicTime(), n3, n2);
        }
    }

    private Job fireKeyLongPressedEvent(int n, long l, int n2) {
        if (n == 50) {
            return this.keyBoardManager.fireKeyEvent(10401, this.fwServices.getMonotonicTime(), 23, l, n2);
        }
        if (KeyMap.getHmiKeyCode(n) == 50) {
            return this.keyBoardManager.fireKeyEvent(10401, this.fwServices.getMonotonicTime(), 81, n2);
        }
        return null;
    }

    private void fireKeyDoublePressedEvent(int n, int n2) {
        if (n == 50) {
            this.keyBoardManager.fireKeyEvent(10401, this.fwServices.getMonotonicTime(), 28, n2);
        }
    }

    private void fireKeyReleasedEvent(int n, int n2) {
        int n3 = KeyMap.getHmiKeyCode(n);
        if (n3 == 0) {
            this.logChannelKeyEvent.log(-1601830656, "KbdListener.fireKeyReleasedEvent: Ignore input key! (keyCode=%1)", (long)n);
            return;
        }
        this.keyBoardManager.fireKeyEvent(10402, this.fwServices.getMonotonicTime(), n3, n2);
    }

    private void fireWheelButtonEvent(int n, int n2, int n3, int n4, int n5) {
        this.keyBoardManager.fireWheelButtonEvent(10403, this.fwServices.getMonotonicTime(), n, n2, n3, n4, n5);
    }

    private void fireWheelButtonEvent(int n, int n2, int n3, int n4) {
        this.keyBoardManager.fireWheelButtonEvent(10403, this.fwServices.getMonotonicTime(), n, n2, n3, n4);
    }

    private void fireJoystickEvent(int n, int n2) {
        int n3 = KeyMap.joystickKey2EventID(n);
        this.keyBoardManager.fireJoyStickEvent(10404, this.fwServices.getMonotonicTime(), 22, n3, n2);
    }

    private void fireProximityEvent(int n, int n2) {
        this.keyBoardManager.fireProximityEvent(n, n2);
    }

    private void abortSDSsession(int n) {
        if (this.sdsService != null && KeyMap.isSdsAbortKey(n)) {
            this.logChannelInput.log(-2137614336, "KbdListener.abortSDSsession: Forward abort command! (service=%1)", (Object)this.sdsService);
            this.sdsService.abortSDSSession(false, (byte)2);
        }
    }

    private boolean checkMFWFilters(int n, int n2, boolean bl) {
        if (this.isMFWBoard(n) && bl) {
            this.logChannelInput.log(-1601830656, "KbdListener.checkMFWFilters: Ignore MFW keys during standby!");
            return true;
        }
        if (!(this.isMIB2HighMMICombi() || this.fwServices.isShowDDP2Combi() || n2 != 99 && n2 != 100 && n2 != 40)) {
            this.logChannelInput.log(-1601830656, "KbdListener.checkMFWFilters: Ignore MFW side menu keys and MFW left roller for all systems apart from MIB2HighMMICombi and DDP2Combi!");
            return true;
        }
        if (n2 == 37) {
            this.logChannelInput.log(-1601830656, "KbdListener.checkMFWFilters: Ignore MFW left arrow!");
            return true;
        }
        if (n2 == 36) {
            this.logChannelInput.log(-1601830656, "KbdListener.checkMFWFilters: Ignore MFW right arrow!");
            return true;
        }
        return false;
    }

    private boolean isMFWBoard(int n) {
        return n == 4 || n == 8;
    }

    private boolean isMIB2HighMMICombi() {
        return this.fwServices.getKombiType() == 4;
    }

    public void blinkInfo(String string) {
        this.getFramework().getHMIService().showVisualFeedback(0, string, 0);
    }

    public void blinkScreen() {
        this.getFramework().getHMIService().showVisualFeedback(0, null, 0);
    }

    public String getName() {
        return "KbdListener";
    }

    public String[] getData() {
        return new String[0];
    }

    public void setIgnoreNextMutePressButtonFlag() {
        this.logChannelInput.log(-2137614336, "KbdListener.setIgnoreNextMutePressButtonFlag()");
        this.ignoreNextMutePressButtonFlag = true;
    }

    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        this.viewSizeManager = iViewSizeManager;
    }

    @Override
    public void getProperty(int n, int n2, int n3, int n4, byte[] byArray) {
    }

    @Override
    public void updateAdvancedProximity(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 101: {
                ChoiceModel choiceModel = (ChoiceModel)this.getFramework().getHMIService().getModel(4076);
                if (choiceModel == null) break;
                choiceModel.setValue(this.currentKeyboardType);
                break;
            }
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.fwServices.getBundleCxt().getService(serviceReference);
        if (object instanceof SDISRangeListener) {
            this.logChannelInput.log(-2137614336, "KbdListener#addingService() - SDISRangeListener has been registered.");
            this.volumeChangerService = (SDISRangeListener)object;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.fwServices.getBundleCxt().ungetService(serviceReference);
        if (object instanceof SDISRangeListener) {
            this.logChannelInput.log(-2137614336, "KbdListener#removedService() - SDISRangeListener has been unregistered.");
            this.volumeChangerService = null;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IViewSizeManager access$100(KbdListener kbdListener) {
        return kbdListener.viewSizeManager;
    }

    static /* synthetic */ LogChannel access$400(KbdListener kbdListener) {
        return kbdListener.logChannelInput;
    }

    static /* synthetic */ void access$500(KbdListener kbdListener, int n, int n2, int n3, int n4) {
        kbdListener.fireWheelButtonEvent(n, n2, n3, n4);
    }

    static {
        IS_OLD_KEYPANEL = Boolean.valueOf(System.getProperty("de.audi.kbd.dsi.oldKeyPanel", "false"));
    }
}

