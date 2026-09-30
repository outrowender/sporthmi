/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.calllist;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallInformation;

public class SingleCall
extends AbstractPhoneCall {
    public SingleCall(CallInformation callInformation) {
        super(callInformation, false);
    }

    public HMIResourceLocator getHMIResourceLocator() {
        ResourceLocator resourceLocator = this.getTelRemPictureId();
        if (PhoneUtils.isPictureAvailable(resourceLocator)) {
            return new HMIResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
        }
        return new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("SingleCall(");
        buffer.append(super.toString());
        buffer.append(")");
        return buffer.toString();
    }
}

