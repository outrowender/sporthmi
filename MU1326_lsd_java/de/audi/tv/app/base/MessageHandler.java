/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.tv.app.base.DefaultMessageListener;
import java.util.ArrayList;
import java.util.List;

public class MessageHandler
implements MsgListener {
    private final List msgListeners = new ArrayList(1);
    private final LogChannel log;

    MessageHandler(LogChannel logChannel) {
        this.log = logChannel;
    }

    void addMessageListener(DefaultMessageListener defaultMessageListener) {
        this.log.log(-2137614336, "[MessageHandler.addMessageListener] added message listener");
        this.msgListeners.add(defaultMessageListener);
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 27: {
                this.log.log(-2137614336, "[MessageHandler.processMsg] received settings reset request for TV");
                for (int i2 = 0; i2 < this.msgListeners.size(); ++i2) {
                    ((DefaultMessageListener)this.msgListeners.get(i2)).reset(true, true);
                }
                break;
            }
            case 204: {
                this.log.log(-2137614336, "[MessageHandler.processMsg] received personal settings reset request for TV");
                for (int i3 = 0; i3 < this.msgListeners.size(); ++i3) {
                    ((DefaultMessageListener)this.msgListeners.get(i3)).reset(false, true);
                }
                break;
            }
            case 201: {
                this.log.log(-2137614336, "[MessageHandler.processMsg] received DVD changer activation");
                for (int i4 = 0; i4 < this.msgListeners.size(); ++i4) {
                    ((DefaultMessageListener)this.msgListeners.get(i4)).sourceDvdActivated();
                }
                break;
            }
            case 200: {
                this.log.log(-2137614336, "[MessageHandler.processMsg] received deactivation of media source");
                for (int i5 = 0; i5 < this.msgListeners.size(); ++i5) {
                    ((DefaultMessageListener)this.msgListeners.get(i5)).sourceMediaDeactivated();
                }
                break;
            }
        }
    }
}

