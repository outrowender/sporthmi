/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.DSICarplayLoggingDecorator;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$Factory;
import org.dsi.ifc.carplay.DSICarplay;

class TerminalModeLoggingDecoratorFactory$2
implements TerminalModeLoggingDecoratorFactory$Factory {
    private final /* synthetic */ TerminalModeLoggingDecoratorFactory this$0;

    TerminalModeLoggingDecoratorFactory$2(TerminalModeLoggingDecoratorFactory terminalModeLoggingDecoratorFactory) {
        this.this$0 = terminalModeLoggingDecoratorFactory;
    }

    @Override
    public Object wrap(Object object) {
        return new DSICarplayLoggingDecorator((DSICarplay)object, TerminalModeLoggingDecoratorFactory.access$000(this.this$0).dsi(), 1078071040);
    }
}

