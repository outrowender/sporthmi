/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractNaviMyAudiImportListener
implements BaseListModelListener,
ButtonListener,
SpellerListener {
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$tghu$navi$app$destinationimport$AbstractNaviMyAudiImportListener == null ? (class$de$audi$tghu$navi$app$destinationimport$AbstractNaviMyAudiImportListener = AbstractNaviMyAudiImportListener.class$("de.audi.tghu.navi.app.destinationimport.AbstractNaviMyAudiImportListener")) : class$de$audi$tghu$navi$app$destinationimport$AbstractNaviMyAudiImportListener);
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final NaviMyAudiImportImpl myAudiImporter;
    private ButtonModelApp importAllToAdbButton;
    protected BaseListModelApp contactsList;
    private SpellerModelApp speller;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$destinationimport$AbstractNaviMyAudiImportListener;

    public AbstractNaviMyAudiImportListener(NavigationEnv navigationEnv, NaviMyAudiImportImpl naviMyAudiImportImpl) {
        this.env = navigationEnv;
        this.myAudiImporter = naviMyAudiImportImpl;
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.initListeners();
    }

    private void initListeners() {
        this.importAllToAdbButton = this.env.getButtonModel(401843);
        this.importAllToAdbButton.setButtonListener(this);
        this.contactsList = this.env.getBaseListModel(401765);
        this.contactsList.setListener(this);
        this.speller = this.env.getSpellerModel(401887);
        this.speller.setSpellerListener(this);
    }

    public abstract void itemSelected(EvoListRow var1, int var2, int var3, int var4, int var5);

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(100000000, "%1#keyPressed - modelID=%2, keyID=%3", (Object)CLASS_NAME, (long)n, (long)n2);
        this.myAudiImporter.saveInAddressBook();
        this.env.fireModelEvent(n, n3);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "%1#textChanged - text=%2", (Object)CLASS_NAME, (Object)string);
        this.myAudiImporter.startSearch(string);
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

