/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiBrandsInputSequence
extends AbstractPoiSequence {
    private final PoiSearchArea searchArea;
    private final LIValueListElement selectedCategoryElement;
    private final IVehicle vehicle;
    private final boolean selectByUID;

    public PoiBrandsInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        this(iPoiSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, lIValueListElement, iVehicle, false, iDetailsScreen);
    }

    public PoiBrandsInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, boolean bl, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, navigationEnv, iDetailsScreen);
        this.selectedCategoryElement = lIValueListElement;
        this.searchArea = poiSearchArea;
        this.vehicle = iVehicle;
        this.selectByUID = bl;
    }

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiBrandsInputSequence#start() - categElementIndex: %1 ", (Object)this.selectedCategoryElement);
        CommandList commandList = this.createStartSequence();
        commandList.execute("PoiBrandsInputSequence#start()");
    }

    @Override
    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.currentInputSequence != null) {
            this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiBrandsInputSequence#startResultsSequence() - current input sequence: %1", (Object)this.currentInputSequence);
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiBrandsInputSequence#startResultsSequence() - starting sequence: searchArea: %2, selelectedBrandElement: %1", (Object)this.selectedElement, (Object)this.searchArea);
        if (this.selectedElement == null) {
            throw new IllegalArgumentException("There is no selected brand element.");
        }
        this.currentInputSequence = new PoiResultsGeneralInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, false, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    private CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiBrandsInputSequence$1(this));
        if (this.modelAccess != null) {
            commandList.add(new ModelStartCommand(this.modelAccess));
        }
        if (this.selectByUID) {
            commandList.add(new LispSelectByCategoryUidCommand(this.selectedCategoryElement.getPoiUniqueId()));
        } else {
            commandList.add(new LISPSelectListItemCommand(this.selectedCategoryElement.getListIndex()));
        }
        if (this.modelAccess != null) {
            commandList.add(new ModelOnElementSelectedCommand(this.modelAccess, this.selectedCategoryElement));
            commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiBrandsInputSequence$2(this));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    @Override
    protected int getSortOrder() {
        int n = 1;
        return n;
    }

    @Override
    protected String getStringId() {
        return "PoiBrandsInputSequence";
    }
}

