/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.CombiBAPServiceTerminalModeLoggingDecorator;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$Factory;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;

class TerminalModeLoggingDecoratorFactory$8
implements TerminalModeLoggingDecoratorFactory$Factory {
    private final /* synthetic */ TerminalModeLoggingDecoratorFactory this$0;

    TerminalModeLoggingDecoratorFactory$8(TerminalModeLoggingDecoratorFactory terminalModeLoggingDecoratorFactory) {
        this.this$0 = terminalModeLoggingDecoratorFactory;
    }

    @Override
    public Object wrap(Object object) {
        return new CombiBAPServiceTerminalModeLoggingDecorator((CombiBAPServiceTerminalMode)object, TerminalModeLoggingDecoratorFactory.access$000(this.this$0).main(), 1078071040);
    }
}

