/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.tone.app.msg.DefaultMsgListener;

public final class MsgListenerDistributor
implements MsgListener {
    private final DefaultMsgListener[] listener;
    private final LogChannel lc;

    public MsgListenerDistributor(LogChannel logChannel, DefaultMsgListener[] defaultMsgListenerArray) {
        this.lc = logChannel;
        this.listener = defaultMsgListenerArray;
    }

    @Override
    public void processMsg(int n) {
        this.lc.log(1078071040, "[MsgListenerDistributor.processMsg] message:%1", (long)n);
        switch (n) {
            case 28: {
                for (int i2 = 0; i2 < this.listener.length; ++i2) {
                    this.listener[i2].resetPhoneSettings();
                }
                break;
            }
            case 26: {
                for (int i3 = 0; i3 < this.listener.length; ++i3) {
                    this.listener[i3].resetSoundSettings();
                }
                break;
            }
            case 24: {
                for (int i4 = 0; i4 < this.listener.length; ++i4) {
                    this.listener[i4].resetNavSettings();
                }
                break;
            }
            case 35: {
                for (int i5 = 0; i5 < this.listener.length; ++i5) {
                    this.listener[i5].resetMessagingSettings();
                }
                break;
            }
            case 25: {
                for (int i6 = 0; i6 < this.listener.length; ++i6) {
                    this.listener[i6].resetSpeechSettings();
                }
                break;
            }
            case 83: {
                for (int i7 = 0; i7 < this.listener.length; ++i7) {
                    this.listener[i7].playHeartbeat();
                }
                break;
            }
            case 100: {
                for (int i8 = 0; i8 < this.listener.length; ++i8) {
                    this.listener[i8].playTouchSound();
                }
                break;
            }
            case 103: {
                for (int i9 = 0; i9 < this.listener.length; ++i9) {
                    this.listener[i9].playWirelessChargingReminder();
                }
                break;
            }
        }
    }
}

