/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.keyhandling.IKeyEventDistributor;
import de.audi.atip.keyhandling.IVirtualGUIManager;
import de.audi.atip.log.LogChannel;

public abstract class AbstractKeyEventDistributor
implements IKeyEventDistributor {
    protected final IFrameworkAccess fw;
    protected final LogChannel log;
    protected IVirtualGUIManager hardkeyListeners;
    protected SDSService sdsService;
    protected int terminalID;

    public AbstractKeyEventDistributor(int n, IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.terminalID = n;
        this.log = this.fw.getLogChannel("Fw.Kbd.KeyEventDistributor");
    }

    public void setSDSService(SDSService sDSService) {
        this.sdsService = sDSService;
    }

    protected void informHardKeyListeners(KeyEvent keyEvent) {
        switch (keyEvent.getID()) {
            case 10401: {
                this.log.log(10000000, "KeyEventDistributor: Sending %1 to hard key listener!", (Object)keyEvent);
                this.hardkeyListeners.keyPressed(keyEvent);
                break;
            }
            case 10402: {
                this.log.log(10000000, "KeyEventDistributor: Sending %1 to hard key listener!", (Object)keyEvent);
                this.hardkeyListeners.keyReleased(keyEvent);
                break;
            }
        }
    }

    protected void informHardKeyListeners(WheelButtonEvent wheelButtonEvent) {
        this.log.log(10000000, "KeyEventDistributor: Sending %1 to hard key listener!", (Object)wheelButtonEvent);
        this.hardkeyListeners.keyTurned(wheelButtonEvent);
    }

    protected void informHardKeyListeners(JoystickEvent joystickEvent) {
        this.log.log(10000000, "KeyEventDistributor: Sending %1 to hard key listener!", (Object)joystickEvent);
        this.hardkeyListeners.keyMoved(joystickEvent);
    }

    protected void sendMessagesOnKeyPress(int n) {
        if (n == 18) {
            this.fw.getPowerMgr().keyPTTPressed();
            this.fw.getMsgDistrib().sendMessage(58);
        } else if (n == 49) {
            this.fw.getMsgDistrib().sendMessage(59);
        }
    }

    public void setHardkeyListeners(IVirtualGUIManager iVirtualGUIManager) {
        this.hardkeyListeners = iVirtualGUIManager;
    }
}

