/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractAddressInputFormModelAccessHelper
implements IAddressInputFormModelAccessHelper {
    private static final int IS_STATE;
    private static final int IS_COUNTRY;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final INavigationInputModeManager inputModeManager;
    protected static final String EMPTY_COUNTRY_STRING;
    protected final ChoiceModelApp countryStateModeChoiceModel;

    public AbstractAddressInputFormModelAccessHelper(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.countryStateModeChoiceModel = navigationEnv.getChoiceModel(941360640);
    }

    protected boolean getValueFromMap(Map map, String string) {
        Object object = map.get(string);
        if (object != null && object instanceof Boolean) {
            return (Boolean)object;
        }
        this.logChannel.log(10000, "%1#getValueFromMap - found no mapping for key=%2", (Object)this.CLASS_NAME, (Object)string);
        return false;
    }

    protected String createCountryOrStateText(NavLocation navLocation) {
        String string;
        String string2 = navLocation.getCountry();
        String string3 = LocationFormatter.formatCountryCode(navLocation);
        if (string3.equalsIgnoreCase("USA") && !Util.isEmpty(string = LocationFormatter.formatState(navLocation))) {
            string2 = string;
        }
        return string2;
    }

    protected void notifySDSForStateOrCountry(NavigationEnv navigationEnv, NavLocation navLocation) {
        String string = LocationFormatter.formatCountryCode(navLocation);
        if (string.equalsIgnoreCase("USA")) {
            String string2 = LocationFormatter.formatState(navLocation);
            this.countryStateModeChoiceModel.setValue(Util.isEmpty(string2) ? 0 : 1);
        } else {
            this.countryStateModeChoiceModel.setValue(0);
        }
    }
}

