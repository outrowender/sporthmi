/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.lang;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.lang.ILanguageUpdateListener;

public abstract class AbstractTelLangaugeUpdateListener
extends AbstractPhoneComponent
implements ILanguageUpdateListener {
    public AbstractTelLangaugeUpdateListener(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getLanguageUpdateDispatcher().addLanguageUpdateListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getLanguageUpdateDispatcher().removeLanguageUpdateListener(this);
    }
}

