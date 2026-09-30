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

    public void onStart() {
        this.env.getChoiceModel(401057).setValue(1);
    }

    public void onStop() {
        this.env.getChoiceModel(401057).setValue(0);
    }
}

