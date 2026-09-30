/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public interface DSITollCollectReply {
    public static final String IPL_COMM_UUID = "0eacb804-7004-5d94-8156-35b75f566f12";
    public static final String IPL_COMM_INTERFACE_KEY = "feda581a-b809-50c5-a988-b0dcfaa40fb5";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public void updateCardState(int var1, int var2) throws MethodException;

    public void updateCardError(TCCardError var1, int var2) throws MethodException;

    public void updateCardDateInformation(TCCardDateInformation var1, int var2) throws MethodException;

    public void updateHardwareInformation(TCHardwareInformation[] var1, int var2) throws MethodException;

    public void updateCurrentTollPayment(NavPriceInfo var1, int var2) throws MethodException;

    public void requestPaymentHistoryListResult(TCPaymentInfo[] var1) throws MethodException;

    public void requestPaymentHistoryDetailsResult(int var1, TCPaymentInfoDetails var2) throws MethodException;

    public void setLanguageResponse(boolean var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

