/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractMatchspellerModelAccess
implements IMatchspellerModelAccess {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final NavigationEnv env;
    protected final MatchspellerModelApp matchSpellerModelApp;
    protected final TiledListModelApp previewListModelApp;
    protected final LogChannel logChannel;
    protected final IAddressInputFormModelAccessHelper modelAccessHelper;

    protected AbstractMatchspellerModelAccess(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
        this.matchSpellerModelApp = navigationEnv.getMatchSpellerModel(n);
        this.matchSpellerModelApp.setMaxLength(128);
        this.previewListModelApp = navigationEnv.getTiledListModel(n2);
    }

    @Override
    public void onInputChanged() {
        this.previewListModelApp.removeAll();
    }

    @Override
    public void onStart(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#onStart was called with NavLocation %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        Util.setModelStatus(this.matchSpellerModelApp, 0);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
        if (navLocation != null) {
            this.matchSpellerModelApp.setCountryAbbreviation(navLocation.getCountryAbbreviation());
        }
        this.previewListModelApp.clearAll();
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        LIValueList lIValueList;
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onUpdateSpeller(%1, %2, %3, %4)").toString(), (Object)string, (Object)string2, (Object)new StringBuffer().append(bl).append("").toString(), (Object)new StringBuffer().append(bl2).append("").toString());
        this.logChannel.log(-2137614336, "%1#onUpdateSpeller() - spellerID = %2)", (Object)this.CLASS_NAME, (long)this.matchSpellerModelApp.getID());
        int n = bl2 ? 1 : 0;
        this.matchSpellerModelApp.setText(string2);
        this.matchSpellerModelApp.setValidChars(string, n);
        DSIResponseContainer dSIResponseContainer = this.env.getContainer();
        if (dSIResponseContainer != null && (lIValueList = dSIResponseContainer.getLispValueList()) != null) {
            LIValueListElement[] lIValueListElementArray = lIValueList.getList();
            if (bl && lIValueListElementArray != null && lIValueListElementArray.length > 0 && lIValueListElementArray[0] != null) {
                String string3 = this.getPhonemeTextFromElement(lIValueListElementArray[0]);
                this.logChannel.log(-2137614336, "%1#onUpdateSpeller(...) - Current Input is a full match currentInput = %2, phoneme for the fullmatch = %3", (Object)this.CLASS_NAME, (Object)string2, (Object)string3);
                this.matchSpellerModelApp.setPhonemeText(string3, this.getPhonemeTextAlphabet(lIValueListElementArray[0]));
            }
        }
        this.matchSpellerModelApp.setFullMatch(bl);
        Util.setModelStatus(this.matchSpellerModelApp, 1);
    }

    private String getPhonemeTextAlphabet(LIValueListElement lIValueListElement) {
        String string = null;
        LIExtData[] lIExtDataArray = lIValueListElement.getExtendedData();
        for (int i2 = 0; i2 < lIExtDataArray.length; ++i2) {
            if (lIExtDataArray[i2].type != 7) continue;
            string = lIExtDataArray[i2].getData();
        }
        return string;
    }

    private String getPhonemeTextFromElement(LIValueListElement lIValueListElement) {
        String string = null;
        LIExtData[] lIExtDataArray = lIValueListElement.getExtendedData();
        for (int i2 = 0; i2 < lIExtDataArray.length; ++i2) {
            if (lIExtDataArray[i2].type != 6) continue;
            string = lIExtDataArray[i2].getData();
        }
        return string;
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "%1#onElementSelected the given navLocation is null", (Object)this.CLASS_NAME);
            return;
        }
    }

    @Override
    public void onAmbiguousElementSelected() {
    }

    public MatchspellerModelApp getMatchspellerModelApp() {
        return this.matchSpellerModelApp;
    }

    public TiledListModelApp getPreviewListModelApp() {
        return this.previewListModelApp;
    }

    @Override
    public void unrequestItems(int n, int n2) {
        this.previewListModelApp.clearRows(n, n2);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    @Override
    public void onRestore() {
    }
}

