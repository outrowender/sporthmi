/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$2$1;
import de.audi.atip.phone.ITelServiceListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

class AbstractPhoneServiceImpl$2
extends AbstractTelInterappEvent {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String val$number;
    private final /* synthetic */ short val$phoneType;
    private final /* synthetic */ short val$entryType;
    private final /* synthetic */ long val$entryID;
    private final /* synthetic */ ResourceLocator val$pictureLocator;
    private final /* synthetic */ int val$phoneNumberIndex;
    private final /* synthetic */ int val$phoneDataCount;
    private final /* synthetic */ boolean val$jumpToPhone;
    private final /* synthetic */ ITelServiceListener val$listener;
    private final /* synthetic */ AbstractPhoneServiceImpl this$0;

    AbstractPhoneServiceImpl$2(AbstractPhoneServiceImpl abstractPhoneServiceImpl, String string, String string2, String string3, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, boolean bl, ITelServiceListener iTelServiceListener) {
        this.this$0 = abstractPhoneServiceImpl;
        this.val$name = string2;
        this.val$number = string3;
        this.val$phoneType = s;
        this.val$entryType = s2;
        this.val$entryID = l;
        this.val$pictureLocator = resourceLocator;
        this.val$phoneNumberIndex = n;
        this.val$phoneDataCount = n2;
        this.val$jumpToPhone = bl;
        this.val$listener = iTelServiceListener;
        super(string);
    }

    @Override
    public void run() {
        if (AbstractPhoneServiceImpl.access$1100(this.this$0).isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("name=");
            buffer.append(this.val$name);
            buffer.append(", ");
            buffer.append("number=");
            buffer.append(this.val$number);
            buffer.append(", ");
            buffer.append("phoneType=");
            buffer.append(this.val$phoneType);
            buffer.append(", ");
            buffer.append("entryType=");
            buffer.append(this.val$entryType);
            buffer.append(", ");
            buffer.append("entryID=");
            buffer.append(this.val$entryID);
            buffer.append(", ");
            buffer.append("pictureLocator=");
            buffer.append(this.val$pictureLocator);
            buffer.append(", ");
            buffer.append("phoneNumberIndex=");
            buffer.append(this.val$phoneNumberIndex);
            buffer.append(", ");
            buffer.append("phoneDataCount=");
            buffer.append(this.val$phoneDataCount);
            buffer.append("jumpToPhone=");
            buffer.append(this.val$jumpToPhone);
            AbstractPhoneServiceImpl.access$1200(this.this$0).log(1078071040, "[AbstractPhoneServiceImpl#dialNumberFromADBEntry] %1", (Object)buffer);
        }
        AbstractPhoneServiceImpl.access$2000(this.this$0).getTelephoneDSIAccess().dialNumberFromDBEntry(this.val$number, this.val$entryID, this.val$name, this.val$phoneType, this.val$entryType, this.val$pictureLocator, this.val$phoneNumberIndex, this.val$phoneDataCount, 0, true, new AbstractPhoneServiceImpl$2$1(this));
    }

    static /* synthetic */ ITelServiceListener access$1300(AbstractPhoneServiceImpl$2 abstractPhoneServiceImpl$2) {
        return abstractPhoneServiceImpl$2.val$listener;
    }

    static /* synthetic */ AbstractPhoneServiceImpl access$1400(AbstractPhoneServiceImpl$2 abstractPhoneServiceImpl$2) {
        return abstractPhoneServiceImpl$2.this$0;
    }

    static /* synthetic */ boolean access$1600(AbstractPhoneServiceImpl$2 abstractPhoneServiceImpl$2) {
        return abstractPhoneServiceImpl$2.val$jumpToPhone;
    }
}

