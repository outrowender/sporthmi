/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueListElement;

public class PhonenumberScreenListener
implements TiledListModelListener,
MatchSpellerListener,
MenuModelListener,
ButtonListener {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IPreviewMap previewMap;
    private final PhonenumberInputSequence inputSequence;
    private final HomeAddressHandler homeAddressHandler;
    private static final int TILED_LIST_MODEL_ID = PoiScreensEvo.getDiAsiaTelephoneNumberScreenTiledListModel();
    private static final int MATCHSPELLER_MODEL_ID = PoiScreensEvo.getDiAsiaTelephoneNumberScreenMatchSpellerModel();
    private static final int MENU_MODEL_ID = PoiScreensEvo.getDiAsiaTelephoneNumberScreenMenuModel();
    private static final int DEST_OPT_METHODS_BUTTON_ID = DIScreensEvo.getDiOPTSelectTelephoneButton();
    private MenuModelApp menuModel;
    private MatchspellerModelApp matchSpellerModel;
    private TiledListModelApp listModel;
    private boolean isSpellerOpen = false;

    public PhonenumberScreenListener(NavigationEnv navigationEnv, LogChannel logChannel, IPreviewMap iPreviewMap, PhonenumberInputSequence phonenumberInputSequence, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.previewMap = iPreviewMap;
        this.inputSequence = phonenumberInputSequence;
        this.homeAddressHandler = homeAddressHandler;
        this.initListeners();
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    private void initListeners() {
        this.menuModel = this.env.getMenuModel(MENU_MODEL_ID);
        this.menuModel.setListener(this);
        this.matchSpellerModel = this.env.getMatchSpellerModel(MATCHSPELLER_MODEL_ID);
        this.matchSpellerModel.setSpellerListener(this);
        this.listModel = this.env.getTiledListModel(TILED_LIST_MODEL_ID);
        this.listModel.setListener(this);
        this.env.getButtonModel(DEST_OPT_METHODS_BUTTON_ID).setButtonListener(this);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#textChanged(%1, %2, %3, %4)").toString(), (Object)Integer.toString(n), (Object)string, (Object)Character.toString(c2), (Object)Integer.toString(n2));
        Util.setModelStatus(this.matchSpellerModel, 0);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2));
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        this.handleItemSelectedEvent(evoListRow, n, n4);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped() - model=%2, key=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.handleItemSelectedEvent(this.listModel.getRow(0), TILED_LIST_MODEL_ID, n3);
    }

    private void handleItemSelectedEvent(EvoListRow evoListRow, int n, int n2) {
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            LIValueListElement lIValueListElement = ((AddressInputLIValueListElementListRow)evoListRow).getElement();
            this.inputSequence.executeElementSelected(lIValueListElement, this.homeAddressHandler);
        } else {
            this.logChannel.log(10000, "%1#handleItemSelectedEvent - row is no instance of AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
        }
        this.env.fireModelEvent(n, n2);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused - TiledList item focused was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputSequence.showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused of menu model was called with menuItemID=%2 , model=%3, uniqueListRowID=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Long.toString(l));
        if (n == MATCHSPELLER_MODEL_ID) {
            if (this.isSpellerOpen) {
                this.inputSequence.hidePreviewMap(this.previewMap);
            } else {
                this.inputSequence.showPreviewMapAroundCCP(this.previewMap);
            }
        }
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#requestItems - was called with requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#unrequestItems - was called with startIndex = %2, length = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (long)n3);
        this.inputSequence.unrequestItems(n, n2);
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#commandPressed(%1, %2, %3)").toString(), (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        if (n == MATCHSPELLER_MODEL_ID) {
            this.isSpellerOpen = false;
            if (n2 == 4712) {
                int n4 = this.listModel.getLength();
                if (n4 == 0) {
                    this.inputSequence.showPreviewMapAroundCCP(this.previewMap);
                }
            } else if (n2 == 4711) {
                this.isSpellerOpen = true;
                this.inputSequence.hidePreviewMap(this.previewMap);
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyPressed - with modelId=%2 keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == DEST_OPT_METHODS_BUTTON_ID) {
            this.getStartCommandList().execute(new StringBuffer().append(this.CLASS_NAME).append("Start Phone Number Input").toString());
            this.env.fireModelEvent(n, n3);
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

