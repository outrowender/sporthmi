/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.HMIAudioServiceLoggingDecorator;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$Factory;
import de.audi.atip.audio.HMIAudioService;

class TerminalModeLoggingDecoratorFactory$3
implements TerminalModeLoggingDecoratorFactory$Factory {
    private final /* synthetic */ TerminalModeLoggingDecoratorFactory this$0;

    TerminalModeLoggingDecoratorFactory$3(TerminalModeLoggingDecoratorFactory terminalModeLoggingDecoratorFactory) {
        this.this$0 = terminalModeLoggingDecoratorFactory;
    }

    @Override
    public Object wrap(Object object) {
        return new HMIAudioServiceLoggingDecorator((HMIAudioService)object, TerminalModeLoggingDecoratorFactory.access$000(this.this$0).audio(), 1078071040);
    }
}

