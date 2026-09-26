/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListAsyncNavLocationExtractor$1;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public class LiValueListAsyncNavLocationExtractor
extends AbstractAsyncNavLocationExtractor {
    private ICommandListFactory commandListFactory;

    public LiValueListAsyncNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    protected CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
        this.checkArgument(evoListRow);
        LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
        CommandList commandList = this.commandListFactory.createCommandList(n);
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new LiValueListAsyncNavLocationExtractor$1(this));
        return commandList;
    }

    private void checkArgument(EvoListRow evoListRow) {
        if (evoListRow == null) {
            throw new IllegalArgumentException(" ListRow object is null,  expected: LiValueListRow");
        }
        if (!(evoListRow instanceof LiValueListRow)) {
            throw new IllegalArgumentException(new StringBuffer().append("Wrong ListRow object: ").append(super.getClass().getName()).append(". Expected: LiValueListRow").toString());
        }
    }
}

