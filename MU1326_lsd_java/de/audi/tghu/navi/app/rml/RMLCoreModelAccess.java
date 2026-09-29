/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rml.IRMLModelAccess;

public abstract class RMLCoreModelAccess
implements IRMLModelAccess {
    private NavigationEnv env;

    public RMLCoreModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    @Override
    public void onStart() {
        this.env.getChoiceModel(-1591867904).setValue(1);
    }

    @Override
    public void onStop() {
        this.env.getChoiceModel(-1591867904).setValue(0);
    }
}

