/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import java.util.Iterator;

class SpellerController$1
implements ISpellerListener {
    private final /* synthetic */ SpellerController this$0;

    SpellerController$1(SpellerController spellerController) {
        this.this$0 = spellerController;
    }

    @Override
    public void characterPressed(String string, boolean bl, boolean bl2) {
        Iterator iterator = SpellerController.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((ISpellerListener)iterator.next()).characterPressed(string, bl, bl2);
        }
    }

    @Override
    public void focusChanged(SpellerController$ISpellerItem spellerController$ISpellerItem, int n) {
        Iterator iterator = SpellerController.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((ISpellerListener)iterator.next()).focusChanged(spellerController$ISpellerItem, n);
        }
    }

    @Override
    public void buttonReleased(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        Iterator iterator = SpellerController.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((ISpellerListener)iterator.next()).buttonReleased(spellerController$SpellerButtonType);
        }
    }

    @Override
    public void buttonPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType, SpellerButtonArgument spellerButtonArgument) {
        Iterator iterator = SpellerController.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((ISpellerListener)iterator.next()).buttonPressed(spellerController$SpellerButtonType, spellerButtonArgument);
        }
    }

    @Override
    public void buttonLongPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        Iterator iterator = SpellerController.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((ISpellerListener)iterator.next()).buttonLongPressed(spellerController$SpellerButtonType);
        }
    }

    @Override
    public void focusedCharacterChanged(String string) {
        Iterator iterator = SpellerController.access$600(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((ISpellerListener)iterator.next()).focusedCharacterChanged(string);
        }
    }
}

