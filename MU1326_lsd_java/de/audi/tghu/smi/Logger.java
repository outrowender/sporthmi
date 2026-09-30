/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.log.NullLogChannel;
import de.audi.tghu.smi.StateMachine;
import de.esolutions.fw.util.commons.Buffer;

class Logger {
    public static final LogChannel DEFAULT_LOG_CHANNEL = NullLogChannel.getInstance();
    private LogChannelFactory logChFactory;
    private static final String LOG_CH_SMI = "Fw.SMI";
    private static final String LOG_CH_EVENT = "Fw.ATIPEvent";
    private static final String LOG_CH_PRESETS = "Fw.Presets";
    public LogChannel smi;
    public LogChannel[][] sm = new LogChannel[8][4];
    public LogChannel event;
    public LogChannel presets;

    Logger(LogChannelFactory logChannelFactory) {
        this.logChFactory = logChannelFactory;
        this.initLogChannels();
    }

    private void initLogChannels() {
        this.smi = this.logChFactory.getLogChannel(LOG_CH_SMI);
        for (int i2 = 0; i2 < 8; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                this.sm[i2][i3] = DEFAULT_LOG_CHANNEL;
            }
        }
        this.event = this.logChFactory.getLogChannel(LOG_CH_EVENT);
        this.presets = this.logChFactory.getLogChannel(LOG_CH_PRESETS);
    }

    public void createLogChannel(StateMachine stateMachine) {
        int n = stateMachine.getTerminalID();
        int n2 = stateMachine.getSubterminalID();
        this.sm[n][n2] = this.logChFactory.getLogChannel(new Buffer(30).append("SM.sm-").append(n).append('-').append(n2).append('-').append(stateMachine.getTerminalName()).toString());
    }
}

