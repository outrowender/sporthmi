/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.personal;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.personal.IPersonalPoiModelAccess;

public class PersonalPoiModelAccess
implements IPersonalPoiModelAccess {
    private final NavigationEnv env;
    private static final int CHOICE_ENABLED;
    private static final int CHOICE_DISABLED;

    public PersonalPoiModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    @Override
    public void onUpdateDataBaseAvailable(boolean bl) {
        int n = bl ? 1 : 0;
        this.env.getLogChannel().log(-2137614336, "PersonalPOIModelAccess#setChoicePPOIDataBaseAvailable( %1 )", (long)n);
        this.env.getChoiceModel(1696531968).setValue(n);
    }

    @Override
    public void onUpdateSearchStatus(int n) {
    }

    @Override
    public boolean isPpoiavailable() {
        return this.env.getChoiceModel(1696531968).getValue() == 1;
    }

    @Override
    public void onDatabaseDeleted(String[] stringArray) {
        this.env.getChoiceModel(1696531968).setValue(0);
    }
}

