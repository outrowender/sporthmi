/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public interface DSITollCollectListener
extends DSIListener {
    public void updateCardState(int var1, int var2);

    public void updateCardError(TCCardError var1, int var2);

    public void updateCardDateInformation(TCCardDateInformation var1, int var2);

    public void updateHardwareInformation(TCHardwareInformation[] var1, int var2);

    public void updateCurrentTollPayment(NavPriceInfo var1, int var2);

    public void requestPaymentHistoryListResult(TCPaymentInfo[] var1);

    public void requestPaymentHistoryDetailsResult(int var1, TCPaymentInfoDetails var2);

    public void setLanguageResponse(boolean var1);
}

