/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.LITryBestMatchCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.AdbEntryAsyncNavLocationExtractor$1;
import de.audi.tghu.navi.app.navlocationextractor.AdbEntryAsyncNavLocationExtractor$2;
import de.audi.tghu.navi.app.navlocationextractor.AdbEntryAsyncNavLocationExtractor$3;
import de.audi.tghu.navi.app.rows.AdbEntryListRow;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.organizer.AdbEntry;

public class AdbEntryAsyncNavLocationExtractor
extends AbstractAsyncNavLocationExtractor {
    private ICommandListFactory commandListFactory;

    public AdbEntryAsyncNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    protected CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
        this.checkArgument(evoListRow);
        AdbEntryListRow adbEntryListRow = (AdbEntryListRow)evoListRow;
        int n2 = adbEntryListRow.getAdbType();
        AdbEntry adbEntry = adbEntryListRow.getAdbEntry();
        if (n2 == 0 || n2 == 1) {
            return this.getCLForPostAddress(adbEntry, n2, n);
        }
        if (n2 == 2) {
            return this.getCLForNavAddress(adbEntry, 0, n);
        }
        if (n2 == 3) {
            return this.getCLForNavAddress(adbEntry, 1, n);
        }
        if (n2 == 4) {
            return this.getCLForGeoAddress(adbEntry, 0, n);
        }
        if (n2 == 5) {
            return this.getCLForGeoAddress(adbEntry, 1, n);
        }
        return null;
    }

    private void checkArgument(EvoListRow evoListRow) {
        if (!(evoListRow instanceof AdbEntryListRow)) {
            throw new IllegalArgumentException("this NavLocationExtractor works only with AdbEntryListRow objects");
        }
    }

    private CommandList getCLForPostAddress(AdbEntry adbEntry, int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(n2);
        commandList.add(new LITryBestMatchCommand(adbEntry, (short)n));
        commandList.add(new AdbEntryAsyncNavLocationExtractor$1(this));
        return commandList;
    }

    private CommandList getCLForNavAddress(AdbEntry adbEntry, int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(n2);
        commandList.add(new StreamToLocationCommand(adbEntry.addressData[n].navLocation));
        commandList.add(new AdbEntryAsyncNavLocationExtractor$2(this));
        return commandList;
    }

    private CommandList getCLForGeoAddress(AdbEntry adbEntry, int n, int n2) {
        String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[n].geoPosition);
        if (stringArray == null || stringArray.length < 2) {
            return null;
        }
        int n3 = Util.degreeStringToWgs84(stringArray[1]);
        int n4 = Util.degreeStringToWgs84(stringArray[0]);
        NavLocation navLocation = Util.getLocationFromGeoPos(n3, n4);
        CommandList commandList = this.commandListFactory.createCommandList(n2);
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
        commandList.add(new AdbEntryAsyncNavLocationExtractor$3(this));
        return commandList;
    }

    private NavLocation getNavLocationFromTryBestMatchResult(DSIResponseContainer dSIResponseContainer) {
        TryBestMatchResultData[] tryBestMatchResultDataArray = dSIResponseContainer.getTryBestMatchResultData();
        if (tryBestMatchResultDataArray == null || tryBestMatchResultDataArray.length == 0 || tryBestMatchResultDataArray[0].getLocation() == null) {
            return null;
        }
        return tryBestMatchResultDataArray[0].getLocation();
    }

    static /* synthetic */ NavLocation access$000(AdbEntryAsyncNavLocationExtractor adbEntryAsyncNavLocationExtractor, DSIResponseContainer dSIResponseContainer) {
        return adbEntryAsyncNavLocationExtractor.getNavLocationFromTryBestMatchResult(dSIResponseContainer);
    }
}

