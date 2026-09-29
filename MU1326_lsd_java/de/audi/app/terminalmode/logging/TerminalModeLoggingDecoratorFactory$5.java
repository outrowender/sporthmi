/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.AudioDrawerContextLoggingDecorator;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$Factory;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;

class TerminalModeLoggingDecoratorFactory$5
implements TerminalModeLoggingDecoratorFactory$Factory {
    private final /* synthetic */ TerminalModeLoggingDecoratorFactory this$0;

    TerminalModeLoggingDecoratorFactory$5(TerminalModeLoggingDecoratorFactory terminalModeLoggingDecoratorFactory) {
        this.this$0 = terminalModeLoggingDecoratorFactory;
    }

    @Override
    public Object wrap(Object object) {
        return new AudioDrawerContextLoggingDecorator((AudioDrawerContext)object, TerminalModeLoggingDecoratorFactory.access$000(this.this$0).main(), 1078071040);
    }
}

