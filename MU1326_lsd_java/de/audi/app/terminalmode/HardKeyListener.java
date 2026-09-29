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
    private static final String LOGCLASS;
    private final IContext context;
    private final LogChannel logger;

    public HardKeyListener(IContext iContext) {
        this.context = iContext;
        this.logger = iContext.getLogger().hmi();
    }

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"HardKeyListener");
        this.context.getFramework().getHmiServiceApp().getButtonModel(533999616).setButtonListener(this);
        this.context.getFramework().getHmiServiceApp().getButtonModel(668217344).setButtonListener(this);
        this.context.getFramework().getHmiServiceApp().getButtonModel(886321152).setButtonListener(this);
        this.context.getFramework().getHmiServiceApp().getButtonModel(869543936).setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"HardKeyListener");
        this.context.getFramework().getHmiServiceApp().getButtonModel(533999616).setButtonListener(null);
        this.context.getFramework().getHmiServiceApp().getButtonModel(668217344).setButtonListener(null);
        this.context.getFramework().getHmiServiceApp().getButtonModel(886321152).setButtonListener(null);
        this.context.getFramework().getHmiServiceApp().getButtonModel(869543936).setButtonListener(null);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        HardKeyDSIListener hardKeyDSIListener = this.getHKListener();
        if (hardKeyDSIListener == null) {
            this.logger.log(1078071040, "[%1.keyPressed] No available HK listener. Ignore.", (Object)"HardKeyListener");
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
                this.logger.log(-2137614336, "[%1.keyPressed] Arrow key skipping deactivated.", (Object)"HardKeyListener");
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.keyPressed] Received unexpected key event for hard-key model '%2'.", (Object)"HardKeyListener", (long)n);
            }
        }
    }

    private HardKeyDSIListener getHKListener() {
        if (this.context.getFramework().getHmiServiceApp().getChoiceModel(409).getValue() != 0) {
            this.logger.log(1078071040, "[%1.getHKListener] Blocked for TMC. Ignore.", (Object)"HardKeyListener");
            return null;
        }
        if (this.context.getAudioManager().isStandbyMuted()) {
            this.logger.log(1078071040, "[%1.getHKListener] StandBy muted. Ignore.", (Object)"HardKeyListener");
            return null;
        }
        return this.context.getHardKeyDSIListener();
    }

    @Override
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
                this.logger.log(1078071040, "[%1.keyTyped] Received unexpected key event for hard-key model '%2'.", (Object)"HardKeyListener", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
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
                this.logger.log(1078071040, "[%1.keyReleased] Received unexpected key event for hard-key model '%2'.", (Object)"HardKeyListener", (long)n);
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

