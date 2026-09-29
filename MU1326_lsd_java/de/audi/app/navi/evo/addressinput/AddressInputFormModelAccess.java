/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputFormModelAccess
implements IAddressInputModelAccess {
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final IAddressInputFormModelAccessHelper modelAccessHelper;

    public AddressInputFormModelAccess(NavigationEnv navigationEnv, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
    }

    @Override
    public void onStart(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "AddressInputFormModelAccess#onElementSelected the given navLocation is null");
            return;
        }
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }
}

