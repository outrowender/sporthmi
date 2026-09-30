/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.MessageDetails;

public class ConcatenatedSMS {
    public static String checkEllipsis(MessageDetails messageDetails, LogChannel logChannel) {
        logChannel.log(1000000, "[ConcatenatedSMS#checkEllipsis]");
        int[] nArray = messageDetails.getSegmentLengths();
        String string = messageDetails.getBody();
        if (nArray == null || nArray.length <= 1) {
            return string;
        }
        try {
            int n = 0;
            int n2 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] == -1) {
                    stringBuffer.append("(...)");
                    continue;
                }
                stringBuffer.append(string.substring(n, n2 += nArray[i2]));
                n = n2;
            }
            return stringBuffer.toString();
        }
        catch (Exception exception) {
            logChannel.log(100000, "[ConcatenatedSMS#checkEllipsis] Modification of the bodytext failed. Return original body!");
            return string;
        }
    }
}

