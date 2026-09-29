/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$13
implements ListenerIterator {
    private final /* synthetic */ RadioTextContainer val$radioTextProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$13(ExlapAbstractRadioService exlapAbstractRadioService, RadioTextContainer radioTextContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$radioTextProperty = radioTextContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateRadioText(this.val$radioTextProperty);
    }
}

