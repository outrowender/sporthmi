/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.TelDialNumberCmd;
import de.audi.app.phone.core.suppservices.ITelDialSuppServiceHandler;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class TelDialNumberFromADBEntryCmd
extends TelDialNumberCmd {
    private final long telDBEntryId;
    private final String telDBName;
    private final short telPhoneType;
    private final short telEntryType;
    private final ResourceLocator telDBPicture;
    private final int telDBPhoneNumberIndex;
    private final int adbPhoneDataCount;

    public TelDialNumberFromADBEntryCmd(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDialSuppServiceHandler iTelDialSuppServiceHandler) {
        super(string, iTelDSIMobileEquipmentRequestWrapper, logChannel, n3, iTelDSIResponseListener, iTelDialSuppServiceHandler);
        this.telDBEntryId = l;
        this.telDBName = string2;
        this.telPhoneType = s;
        this.telEntryType = s2;
        this.telDBPicture = resourceLocator;
        this.telDBPhoneNumberIndex = n;
        this.adbPhoneDataCount = n2;
    }

    @Override
    public void execute() {
        if (this.dsi != null) {
            if (this.logger.isInfo()) {
                Buffer buffer = new Buffer();
                buffer.append("telNumber=");
                buffer.append(this.telNumber);
                buffer.append(", ");
                buffer.append("telDBEntryId=");
                buffer.append(this.telDBEntryId);
                buffer.append(", ");
                buffer.append("telDBName=");
                buffer.append(this.telDBName);
                buffer.append(", ");
                buffer.append("telPhoneType=");
                buffer.append(this.telPhoneType);
                buffer.append(", ");
                buffer.append("telEntryType=");
                buffer.append(this.telEntryType);
                buffer.append(", ");
                buffer.append("telDBPicture=");
                buffer.append(this.telDBPicture);
                buffer.append(", ");
                buffer.append("telDBPhoneNumberIndex=");
                buffer.append(this.telDBPhoneNumberIndex);
                buffer.append(", ");
                buffer.append("adbPhoneDataCount=");
                buffer.append(this.adbPhoneDataCount);
                this.logger.log(1078071040, "[TelDialNumberFromADBEntryCmd#execute] %1", (Object)buffer);
            }
            if (this.isDSIAvailable()) {
                this.dsi.dialNumberFromDBEntry(this.telNumber, this.telDBEntryId, this.telDBName, this.telPhoneType, this.telEntryType, this.telDBPicture, this.telDBPhoneNumberIndex, this.adbPhoneDataCount);
            } else {
                this.logger.log(-1601830656, "[TelDialNumberFromADBEntryCmd#execute] dsi is null!");
                this.getCommandList().commandFinished();
            }
        }
    }
}

