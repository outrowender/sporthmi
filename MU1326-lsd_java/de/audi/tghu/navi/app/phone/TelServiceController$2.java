/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.phone;

import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.navi.app.phone.TelServiceController;
import de.audi.tghu.navi.app.phone.TelServiceController$IOperation;
import org.dsi.ifc.global.ResourceLocator;

class TelServiceController$2
implements TelServiceController$IOperation {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String val$number;
    private final /* synthetic */ short val$phoneType;
    private final /* synthetic */ short val$entryType;
    private final /* synthetic */ long val$entryID;
    private final /* synthetic */ ResourceLocator val$pictureLocator;
    private final /* synthetic */ int val$phoneNumberIndex;
    private final /* synthetic */ int val$phoneDataCount;
    private final /* synthetic */ ITelServiceListener val$responseListener;
    private final /* synthetic */ boolean val$jumpToPhone;
    private final /* synthetic */ TelServiceController this$0;

    TelServiceController$2(TelServiceController telServiceController, String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener, boolean bl) {
        this.this$0 = telServiceController;
        this.val$name = string;
        this.val$number = string2;
        this.val$phoneType = s;
        this.val$entryType = s2;
        this.val$entryID = l;
        this.val$pictureLocator = resourceLocator;
        this.val$phoneNumberIndex = n;
        this.val$phoneDataCount = n2;
        this.val$responseListener = iTelServiceListener;
        this.val$jumpToPhone = bl;
    }

    @Override
    public void execute(ITelService iTelService) {
        iTelService.dialNumberFromADBEntry(this.val$name, this.val$number, this.val$phoneType, this.val$entryType, this.val$entryID, this.val$pictureLocator, this.val$phoneNumberIndex, this.val$phoneDataCount, this.val$responseListener, this.val$jumpToPhone);
    }
}

