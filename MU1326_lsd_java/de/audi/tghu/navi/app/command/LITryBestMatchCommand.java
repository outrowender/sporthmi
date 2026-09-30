/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.NavPhoneData;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.organizer.AdbEntry;

public class LITryBestMatchCommand
extends NavCommand {
    private AdbEntry entry;
    private short adrIndex;
    private TryBestMatchData tbmData = null;

    public LITryBestMatchCommand(AdbEntry adbEntry, short s) {
        this.entry = adbEntry;
        this.adrIndex = s;
    }

    public LITryBestMatchCommand(TryBestMatchData tryBestMatchData) {
        this.tbmData = tryBestMatchData;
    }

    public void execute() {
        this.logger.log(10000000, "LITryBestMatchCommand#execute() - calling liTryBestMatch()");
        if (this.entry != null) {
            this.tbmData = new TryBestMatchData();
            this.tbmData.country = this.entry.addressData[this.adrIndex].country;
            this.tbmData.locality = this.entry.addressData[this.adrIndex].locality;
            this.tbmData.streedAndOrHouseNumber = this.entry.addressData[this.adrIndex].street;
            this.tbmData.region = this.entry.addressData[this.adrIndex].region;
            this.tbmData.postalCode = this.entry.addressData[this.adrIndex].postalCode;
            this.tbmData.phoneNumbers = new NavPhoneData[this.entry.phoneData.length];
            for (int i2 = 0; i2 < this.entry.phoneData.length; ++i2) {
                if (this.entry.phoneData[i2] == null) continue;
                this.tbmData.phoneNumbers[i2] = new NavPhoneData();
                this.tbmData.phoneNumbers[i2].number = this.entry.phoneData[i2].number;
                this.tbmData.phoneNumbers[i2].numberType = this.entry.phoneData[i2].numberType;
            }
        }
        this.logger.log(10000000, "LITryBestMatchCommand#execute() - calling liTryBestMatch() with tbmData=%1", (Object)this.tbmData);
        this.getDSINavigation().liTryBestMatch(this.tbmData);
    }

    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.logger.log(10000000, "LITryBestMatchCommand#liTryBestMatchResult() ");
        this.dsiResponseContainer.setTryBestMatchResultData(tryBestMatchResultDataArray);
        this.getCommandList().commandFinished();
    }
}

