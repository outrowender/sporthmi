/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import org.dsi.ifc.navigation.LIValueList;

public class AddressDisambiguatorEvo
extends AddressDisambiguator {
    public AsyncNavLocationExtractor extractor;
    private final HomeAddressHandler homeAddressHandler;
    protected MatchspellerModelApp matchSpeller;
    protected TiledListModelApp tiledList;
    protected MenuModelApp menuModel;
    private final ADBInterAppService adbInterAppService;
    private final IAddressInputForm addressInputForm;
    private final IPreviewMap previewMap;

    public AddressDisambiguatorEvo(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, LogChannel logChannel, AsyncNavLocationExtractor asyncNavLocationExtractor, HomeAddressHandler homeAddressHandler, ADBInterAppService aDBInterAppService, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap) {
        super(navigationEnv, iCommandListFactory, logChannel);
        this.extractor = asyncNavLocationExtractor;
        this.homeAddressHandler = homeAddressHandler;
        this.adbInterAppService = aDBInterAppService;
        this.addressInputForm = iAddressInputForm;
        this.previewMap = iPreviewMap;
    }

    @Override
    protected void getBestPointAndNearestHNr() {
        LIValueList lIValueList = this.env.getContainer().getLispValueList();
        this.env.getLabelModel(-903870976).setText(lIValueList.list[0].data);
    }

    @Override
    protected void setListModels(int n) {
        switch (n) {
            case 5: {
                this.matchSpeller = this.env.getMatchSpellerModel(-1860172288);
                this.tiledList = this.env.getTiledListModel(-1390344704);
                this.menuModel = this.env.getMenuModel(-1356790272);
                break;
            }
            case 4: {
                this.matchSpeller = this.env.getMatchSpellerModel(-1256192512);
                this.tiledList = this.env.getTiledListModel(-1340013056);
                this.menuModel = this.env.getMenuModel(-1373567488);
                break;
            }
            default: {
                this.matchSpeller = this.env.getMatchSpellerModel(-1256192512);
                this.tiledList = this.env.getTiledListModel(-1340013056);
                this.menuModel = this.env.getMenuModel(-1373567488);
                this.logger.log(-1601830656, "AddressDisambiguatorEvo#fsetListModels no models implemented for parameter disambChoice=>>%1<<", (long)n);
            }
        }
        new AddressDisambiguatorHMIListener(this, this.env, this.homeAddressHandler, this.adbInterAppService, this.addressInputForm, this.previewMap);
        this.env.getChoiceModel(1042286080).setValue(n);
    }

    @Override
    protected void setSpellerInput(String string) {
        this.matchSpeller.setText(string);
    }

    @Override
    protected boolean fillRowsIn(LIValueList lIValueList) {
        if (null == this.matchSpeller) {
            this.logger.log(-1601830656, "AddressDisambiguatorEvo#fillRowsIn no match speller model set (setListModels(MatchspellerModelApp speller, BaseListModelApp list))");
            return false;
        }
        this.matchSpeller.setValidChars(this.env.getContainer().getLispValidCharacters());
        if (this.tiledList.getLength() > 0) {
            this.tiledList.clearAll();
            this.tiledList.setLength(0);
        }
        for (int i2 = 0; i2 < lIValueList.list.length; ++i2) {
            this.tiledList.append(new AddressInputLIValueListElementListRow(lIValueList.list[i2], 0, new int[0]));
        }
        return true;
    }
}

