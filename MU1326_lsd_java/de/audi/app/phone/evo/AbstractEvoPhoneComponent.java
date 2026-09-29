/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.evo.ITelEvoApplication;

public class AbstractEvoPhoneComponent
extends AbstractPhoneComponent {
    public AbstractEvoPhoneComponent(ITelEvoApplication iTelEvoApplication, String string) {
        super(iTelEvoApplication, string);
    }

    protected ITelEvoApplication getEvoApplication() {
        return (ITelEvoApplication)this.getApplication();
    }
}

