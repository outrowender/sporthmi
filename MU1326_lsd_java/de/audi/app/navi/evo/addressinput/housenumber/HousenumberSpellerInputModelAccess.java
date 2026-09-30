/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.housenumber;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.housenumber.IHousenumberModelAccess;
import de.audi.tghu.navi.app.di.IBackupLocationHandler;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class HousenumberSpellerInputModelAccess
implements IHousenumberModelAccess {
    protected final NavigationEnv env;
    protected final SpellerModelApp spellerModelApp;
    protected final TiledListModelApp previewListModelApp;
    private final IBackupLocationHandler backupLocationHandler;
    private final IAddressInputFormModelAccessHelper modelAccessHelper;
    private final LogChannel logChannel;

    public HousenumberSpellerInputModelAccess(NavigationEnv navigationEnv, int n, int n2, IBackupLocationHandler iBackupLocationHandler, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.backupLocationHandler = iBackupLocationHandler;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.spellerModelApp = navigationEnv.getSpellerModel(n);
        this.previewListModelApp = navigationEnv.getTiledListModel(n2);
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
        this.spellerModelApp.setMaxLength(128);
    }

    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.spellerModelApp, 0);
        this.spellerModelApp.clear();
        this.spellerModelApp.setCountryAbbreviation(navLocation.getCountryAbbreviation());
        this.previewListModelApp.removeAll();
        this.env.getChoiceModel(400909).setValue(0);
    }

    public void updatePreviewHousenumber(String string) {
        this.spellerModelApp.setText(string);
        this.previewListModelApp.removeAll();
        if (!Util.isEmpty(string)) {
            LIValueListElement lIValueListElement = new LIValueListElement();
            lIValueListElement.data = string;
            EvoListRow evoListRow = this.buildListRow(string, lIValueListElement);
            this.previewListModelApp.setLength(1);
            this.previewListModelApp.setRows(-1, 0, new EvoListRow[]{evoListRow});
        }
    }

    private EvoListRow buildListRow(String string, LIValueListElement lIValueListElement) {
        AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = new AddressInputLIValueListElementListRow(lIValueListElement, 698976777, new int[0]);
        return addressInputLIValueListElementListRow;
    }

    public void onElementSelected(NavLocation navLocation) {
        if (navLocation == null) {
            this.env.getLogChannel().log(10000, "AbstractModelAccess#onElementSelected the given navLocation is null");
            return;
        }
        this.backupLocationHandler.setBackupLocation(navLocation);
    }

    public void onHousenumberValid() {
        this.env.getChoiceModel(400401).setValue(1);
        this.env.getChoiceModel(401799).setValue(0);
    }

    public void onHousenumberInvalid(String string) {
        this.env.getChoiceModel(400401).setValue(0);
        this.env.getTextfieldModel(400910).setText1(string);
        this.env.getChoiceModel(401799).setValue(2);
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }
}

