/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class HardKeyListener
extends AbstractMediaTerminalComponent
implements ButtonListener,
TimerListener {
    private static final String LOGCLASS;
    volatile Timer syncTimer;

    public HardKeyListener(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"HardKeyListener");
        this.getButtonModel(2131690240).setButtonListener(this);
        this.getButtonModel(-2146499840).setButtonListener(this);
        this.getButtonModel(974193408).setButtonListener(this);
        this.getButtonModel(990970624).setButtonListener(this);
        this.getButtonModel(2081358592).setButtonListener(this);
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"HardKeyListener");
        this.getButtonModel(2131690240).setButtonListener(null);
        this.getButtonModel(-2146499840).setButtonListener(null);
        this.getButtonModel(974193408).setButtonListener(null);
        this.getButtonModel(990970624).setButtonListener(null);
        this.getButtonModel(2081358592).setButtonListener(null);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 200575: 
            case 200576: 
            case 201018: 
            case 201019: {
                ButtonListener buttonListener = this.getHKListener();
                if (buttonListener == null) {
                    this.logger.hmi().log(1078071040, "[%1.keyPressed] No available HK listener. Ignore.", (Object)"HardKeyListener");
                    return;
                }
                buttonListener.keyPressed(n, n2, n3);
                break;
            }
            case 200572: {
                break;
            }
            default: {
                this.logger.hmi().log(1078071040, "[%1.keyPressed] Received unexpected key event for hard-key model '%2'.", (Object)"HardKeyListener", (long)n);
            }
        }
    }

    private ButtonListener getHKListener() {
        if (this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(409).getValue() != 0) {
            this.logger.hmi().log(1078071040, "[%1.getHKListener] Blocked for TMC. Ignore.", (Object)"HardKeyListener");
            return null;
        }
        if (this.getTerminal().getAudioManager().isStandbyMuted()) {
            this.logger.hmi().log(1078071040, "[%1.getHKListener] StandBy muted. Ignore.", (Object)"HardKeyListener");
            return null;
        }
        IContent iContent = this.getTerminal().getContentManager().getActiveContent();
        if (iContent == null) {
            this.logger.hmi().log(1078071040, "[%1.getHKListener] No content active. Ignore.", (Object)"HardKeyListener");
            return null;
        }
        return iContent.getHardKeyListener();
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200575: 
            case 200576: 
            case 201018: 
            case 201019: {
                ButtonListener buttonListener = this.getHKListener();
                if (buttonListener == null) {
                    return;
                }
                buttonListener.keyTyped(n, n2, n3);
                break;
            }
            case 200572: {
                break;
            }
            default: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] Received unexpected key event for hard-key model '%2'.", (Object)"HardKeyListener", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        block0 : switch (n) {
            case 200575: 
            case 200576: 
            case 201018: 
            case 201019: {
                ButtonListener buttonListener = this.getHKListener();
                if (buttonListener == null) {
                    return;
                }
                buttonListener.keyReleased(n, n2, n3);
                break;
            }
            case 200572: {
                int n4 = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(395).getValue();
                this.logger.hmi().log(-2137614336, "[%1.keyTyped] HK_JOKER_BUTTON (jokerKeyAction='%2').", (Object)"HardKeyListener", (long)n4);
                switch (n4) {
                    case 9: {
                        ButtonListener buttonListener = this.getHKListener();
                        if (buttonListener == null) {
                            return;
                        }
                        buttonListener.keyPressed(2131690240, n2, n3);
                        buttonListener.keyReleased(2131690240, n2, n3);
                        break block0;
                    }
                    case 14: {
                        ButtonListener buttonListener = this.getHKListener();
                        if (buttonListener == null) {
                            return;
                        }
                        buttonListener.keyPressed(-2146499840, n2, n3);
                        buttonListener.keyReleased(-2146499840, n2, n3);
                        break block0;
                    }
                    case 8: {
                        boolean bl;
                        if (this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
                            this.logger.hmi().log(1078071040, "[%1.keyTyped] Media already active.", (Object)"HardKeyListener");
                            return;
                        }
                        if (this.isTerminalModeActive()) {
                            this.logger.hmi().log(-1601830656, "[%1.keyTyped] TerminalMode is active. IGNORE. Tuner should be activated.", (Object)"HardKeyListener");
                            return;
                        }
                        int n5 = this.getChoiceModel(1376715520).getValue();
                        boolean bl2 = bl = this.getChoiceModel(11).getValue() == 2 && (8 == n5 || 7 == n5);
                        if (bl) {
                            this.logger.hmi().log(1078071040, "[%1.keyReleased] TV is active", (Object)"HardKeyListener");
                            return;
                        }
                        if (this.syncTimer == null) {
                            this.syncTimer = new Timer("MediaJokerKeySyncTimer", 5, null, new TimerSyncer(this), 1L, true);
                        }
                        this.logger.hmi().log(1078071040, "[%1.keyTyped] Start timer for media switch.", (Object)"HardKeyListener");
                        this.syncTimer.start();
                        break block0;
                    }
                }
                break;
            }
            default: {
                this.logger.hmi().log(1078071040, "[%1.keyReleased] Received unexpected key event for hard-key model '%2'.", (Object)"HardKeyListener", (long)n);
            }
        }
    }

    boolean isTerminalModeActive() {
        int n = this.getTerminal().getFramework().getLastmodeHandler().getLastmodeAudio(this.getTerminal().getTerminalID());
        return n == 43 || n == 48;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.hmi().log(1078071040, "[%1.fireTimer] Fire Media-Switch Sync timer. Switch to media.", (Object)"HardKeyListener");
        int n = this.getChoiceModel(1376715520).getValue();
        if (8 == n || 7 == n) {
            this.getTerminal().getAudioManager().switchAudioFocusToTV();
        } else {
            this.getTerminal().getAudioManager().requestAudioFocus();
        }
    }
}

