/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListPoiNavLocationExtractor$1;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListPoiNavLocationExtractor$2;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListPoiNavLocationExtractor$GetNavLocationCommand;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class LiValueListPoiNavLocationExtractor
implements NavLocationExctractor {
    private static final int TIMEOUT_FOR_EXTRACT_LOCATION;
    private ICommandListFactory commandListFactory;

    public LiValueListPoiNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    public NavLocation extractNavLocationFromRow(EvoListRow evoListRow) {
        LIValueListElement lIValueListElement = this.getLiValueListElementFromRow(evoListRow);
        return this.extractNavLocationFromLiValueListElementForPOIs(lIValueListElement);
    }

    protected abstract LIValueListElement getLiValueListElementFromRow(EvoListRow evoListRow) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private NavLocation extractNavLocationFromLiValueListElementForPOIs(LIValueListElement lIValueListElement) {
        Object object = new Object();
        LiValueListPoiNavLocationExtractor$GetNavLocationCommand liValueListPoiNavLocationExtractor$GetNavLocationCommand = new LiValueListPoiNavLocationExtractor$GetNavLocationCommand(this, object);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new LiValueListPoiNavLocationExtractor$1(this));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(liValueListPoiNavLocationExtractor$GetNavLocationCommand);
        commandList.add(new LiValueListPoiNavLocationExtractor$2(this));
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("PoiInputHMIListener#saveAsFavorite");
            try {
                object.wait(0);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        return liValueListPoiNavLocationExtractor$GetNavLocationCommand.getResult();
    }
}

