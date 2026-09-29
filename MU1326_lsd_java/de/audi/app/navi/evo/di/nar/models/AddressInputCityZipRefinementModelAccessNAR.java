/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.models;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.nar.models.AbstractAddressInputModelAccessNAR;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityZipRefinementModelAccessNAR
extends AbstractAddressInputModelAccessNAR {
    private final NavigationEnv env;
    private final TiledListModelApp tiledListModel;
    private final LogChannel logChannel;

    public AddressInputCityZipRefinementModelAccessNAR(NavigationEnv navigationEnv, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, int n) {
        super(iAddressInputFormModelAccessHelper);
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.tiledListModel = navigationEnv.getTiledListModel(n);
    }

    @Override
    public void onStart(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#onStart(%2)", (Object)this.CLASS_NAME, (Object)navLocation);
        }
        this.tiledListModel.removeAll();
    }

    @Override
    public void onInputChanged() {
        this.tiledListModel.removeAll();
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        this.tiledListModel.setLength((int)l);
        EvoListRow[] evoListRowArray = this.createUpdateArray(lIValueListElementArray, string);
        if (evoListRowArray.length == 0) {
            this.tiledListModel.removeAll();
        } else {
            this.tiledListModel.setRows(n, n2, evoListRowArray);
        }
    }

    protected AddressInputLIValueListElementListRow[] createUpdateArray(LIValueListElement[] lIValueListElementArray, String string) {
        AddressInputLIValueListElementListRow[] addressInputLIValueListElementListRowArray = new AddressInputLIValueListElementListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            addressInputLIValueListElementListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], 160082217);
        }
        return addressInputLIValueListElementListRowArray;
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        this.tiledListModel.setLength((int)l);
        EvoListRow[] evoListRowArray = this.createUpdateArray(lIValueListElementArray, string);
        if (evoListRowArray.length == 0) {
            this.tiledListModel.removeAll();
        } else {
            this.tiledListModel.setRows(-1, 0, evoListRowArray);
        }
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
    }

    @Override
    public void onAmbiguousElementSelected() {
    }

    @Override
    public void unrequestItems(int n, int n2) {
    }

    @Override
    public void onRestore() {
    }
}

