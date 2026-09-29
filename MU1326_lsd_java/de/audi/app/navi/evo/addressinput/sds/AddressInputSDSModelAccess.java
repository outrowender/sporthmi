/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class AddressInputSDSModelAccess
implements IMatchspellerModelAccess {
    protected final NavigationEnv env;
    protected final IAddressInputForm addressInputForm;
    private final GuiModelAccessDetailsEvo detailModelAccess;
    private final LogChannel logChannel;
    private final IAddressInputFormModelAccessHelper modelAccessHelper;

    public AddressInputSDSModelAccess(NavigationEnv navigationEnv, IAddressInputForm iAddressInputForm, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.env = navigationEnv;
        this.addressInputForm = iAddressInputForm;
        this.detailModelAccess = guiModelAccessDetailsEvo;
        this.logChannel = navigationEnv.getSDSLogChannel();
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
    }

    @Override
    public void onRestore() {
    }

    @Override
    public void onInputChanged() {
    }

    @Override
    public void onStart(NavLocation navLocation) {
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "AddressInputSDSModelAccess#onElementSelected the given navLocation is null");
            return;
        }
        if (this.addressInputForm != null) {
            this.addressInputForm.setBackupLocation(navLocation);
        }
    }

    @Override
    public void onAmbiguousElementSelected() {
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, this.detailModelAccess, navLocation, map);
    }

    @Override
    public void unrequestItems(int n, int n2) {
    }

    @Override
    public void onSpellerStatusChanged(int n) {
    }
}

