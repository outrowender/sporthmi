/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.search.TrufflesRangeSelect;

public class TrufflesRangeSelectEvo
extends TrufflesRangeSelect {
    private final ChoiceModelApp countryIconVisible;
    private final ChoiceModelApp countryIconID;
    private static final int COUNTRY_ICON_INVISIBLE = 0;
    private static final int COUNTRY_ICON_VISIBLE = 1;
    private static final int COUNTRY_NO_ICON_INDEX = -1;
    private final IconHandler iconHandler;

    public TrufflesRangeSelectEvo(BaseListModelApp baseListModelApp, NavigationEnv navigationEnv, LogChannel logChannel, IconHandler iconHandler) {
        super(baseListModelApp, navigationEnv, logChannel);
        this.iconHandler = iconHandler;
        this.countryIconVisible = navigationEnv.getChoiceModel(401886);
        this.countryIconID = navigationEnv.getChoiceModel(401885);
        this.countryIconID.setValue(-1);
    }

    public void savePersistentState() {
        super.savePersistentState();
        this.updateCountryIcon();
    }

    public void loadPersistentState() {
        super.loadPersistentState();
        this.updateCountryIcon();
    }

    public void updateCountryIcon() {
        if (this.lastSelectedCountry.equals("XX")) {
            this.countryIconVisible.setValue(0);
            this.countryIconID.setValue(-1);
        } else {
            int n = this.iconHandler.resolveCountryIconResourceID(this.lastSelectedCountryIconId);
            this.countryIconVisible.setValue(1);
            this.countryIconID.setValue(n);
        }
    }
}

