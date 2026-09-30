/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.smartphone.HardKeyDSIListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;

public class HardKeyListener
implements ButtonListener,
ITerminalModeComponent {
    private static final String LOGCLASS = "HardKeyListener";
    private final IContext context;
    private final LogChannel logger;

    public HardKeyListener(IContext iContext) {
        this.context = iContext;
        this.logger = iContext.getLogger().hmi();
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200031).setButtonListener(this);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200039).setButtonListener(this);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200052).setButtonListener(this);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200051).setButtonListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200031).setButtonListener(null);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200039).setButtonListener(null);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200052).setButtonListener(null);
        this.context.getFramework().getHmiServiceApp().getButtonModel(3200051).setButtonListener(null);
    }

    public void keyPressed(int n, int n2, int n3) {
        HardKeyDSIListener hardKeyDSIListener = this.getHKListener();
        if (hardKeyDSIListener == null) {
            this.logger.log(1000000, "[%1.keyPressed] No available HK listener. Ignore.", (Object)LOGCLASS);
            return;
        }
        switch (n) {
            case 3200031: 
            case 3200039: {
                hardKeyDSIListener.keyPressed(n, n2, n3);
                break;
            }
            case 3200051: 
            case 3200052: {
                if (this.isSkippingEnabled()) {
                    hardKeyDSIListener.keyPressed(n, n2, n3);
                    break;
                }
                this.logger.log(10000000, "[%1.keyPressed] Arrow key skipping deactivated.", (Object)LOGCLASS);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.keyPressed] Received unexpected key event for hard-key model '%2'.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    private HardKeyDSIListener getHKListener() {
        if (this.context.getFramework().getHmiServiceApp().getChoiceModel(409).getValue() != 0) {
            this.logger.log(1000000, "[%1.getHKListener] Blocked for TMC. Ignore.", (Object)LOGCLASS);
            return null;
        }
        if (this.context.getAudioManager().isStandbyMuted()) {
            this.logger.log(1000000, "[%1.getHKListener] StandBy muted. Ignore.", (Object)LOGCLASS);
            return null;
        }
        return this.context.getHardKeyDSIListener();
    }

    public void keyTyped(int n, int n2, int n3) {
        HardKeyDSIListener hardKeyDSIListener = this.getHKListener();
        if (hardKeyDSIListener == null) {
            return;
        }
        switch (n) {
            case 3200031: 
            case 3200039: {
                hardKeyDSIListener.keyTyped(n, n2, n3);
                break;
            }
            case 3200051: 
            case 3200052: {
                if (!this.isSkippingEnabled()) break;
                hardKeyDSIListener.keyTyped(n, n2, n3);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.keyTyped] Received unexpected key event for hard-key model '%2'.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
        HardKeyDSIListener hardKeyDSIListener = this.getHKListener();
        if (hardKeyDSIListener == null) {
            return;
        }
        switch (n) {
            case 3200031: 
            case 3200039: {
                hardKeyDSIListener.keyReleased(n, n2, n3);
                break;
            }
            case 3200051: 
            case 3200052: {
                if (!this.isSkippingEnabled()) break;
                hardKeyDSIListener.keyReleased(n, n2, n3);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.keyReleased] Received unexpected key event for hard-key model '%2'.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    private boolean isSkippingEnabled() {
        if (this.context.getFramework().getSysConstManager().getCarCoding().getCarBrand() != 5) {
            return true;
        }
        return 0 == this.context.getFramework().getHmiServiceApp().getChoiceModel(4304).getValue();
    }
}

