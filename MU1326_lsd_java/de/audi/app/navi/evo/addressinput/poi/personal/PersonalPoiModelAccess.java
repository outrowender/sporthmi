/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.personal;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.personal.IPersonalPoiModelAccess;

public class PersonalPoiModelAccess
implements IPersonalPoiModelAccess {
    private final NavigationEnv env;
    private static final int CHOICE_ENABLED = 1;
    private static final int CHOICE_DISABLED = 0;

    public PersonalPoiModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public void onUpdateDataBaseAvailable(boolean bl) {
        int n = bl ? 1 : 0;
        this.env.getLogChannel().log(10000000, "PersonalPOIModelAccess#setChoicePPOIDataBaseAvailable( %1 )", (long)n);
        this.env.getChoiceModel(401253).setValue(n);
    }

    public void onUpdateSearchStatus(int n) {
    }

    public boolean isPpoiavailable() {
        return this.env.getChoiceModel(401253).getValue() == 1;
    }

    public void onDatabaseDeleted(String[] stringArray) {
        this.env.getChoiceModel(401253).setValue(0);
    }
}

