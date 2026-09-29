/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.I18NTextComponent;

class I18NTextComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ I18NTextComponent this$0;

    I18NTextComponent$1(I18NTextComponent i18NTextComponent, String string) {
        this.this$0 = i18NTextComponent;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.this$0.refresh();
    }
}

