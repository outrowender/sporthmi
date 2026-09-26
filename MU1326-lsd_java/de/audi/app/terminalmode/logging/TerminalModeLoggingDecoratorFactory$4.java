/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$Factory;
import de.audi.app.terminalmode.logging.ToneServiceLoggingDecorator;
import de.audi.atip.interapp.audio.ToneService;

class TerminalModeLoggingDecoratorFactory$4
implements TerminalModeLoggingDecoratorFactory$Factory {
    private final /* synthetic */ TerminalModeLoggingDecoratorFactory this$0;

    TerminalModeLoggingDecoratorFactory$4(TerminalModeLoggingDecoratorFactory terminalModeLoggingDecoratorFactory) {
        this.this$0 = terminalModeLoggingDecoratorFactory;
    }

    @Override
    public Object wrap(Object object) {
        return new ToneServiceLoggingDecorator((ToneService)object, TerminalModeLoggingDecoratorFactory.access$000(this.this$0).audio(), 1078071040);
    }
}

