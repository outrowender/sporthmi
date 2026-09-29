/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.calllist;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.calllist.SingleCall;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.telephoneng.CallInformation;

public class ConferenceCall
extends AbstractPhoneCall {
    private final ArrayList memberList = new ArrayList();
    private final Object memberListMutex = new Object();

    public ConferenceCall(CallInformation callInformation) {
        super(callInformation, true);
    }

    @Override
    public HMIResourceLocator getHMIResourceLocator() {
        return new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Conference Call\n");
        buffer.append(super.toString());
        buffer.append("\n------------------------\n");
        Object object = this.memberListMutex;
        synchronized (object) {
            Iterator iterator = this.memberList.iterator();
            while (iterator.hasNext()) {
                SingleCall singleCall = (SingleCall)iterator.next();
                buffer.append("Member: ");
                buffer.append(singleCall);
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getNrMembers() {
        Object object = this.memberListMutex;
        synchronized (object) {
            return this.memberList.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SingleCall getMember(int n) {
        Object object = this.memberListMutex;
        synchronized (object) {
            Iterator iterator = this.memberList.iterator();
            while (iterator.hasNext()) {
                SingleCall singleCall = (SingleCall)iterator.next();
                if (singleCall.getTelCallID() != n) continue;
                return singleCall;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SingleCall[] getMembers() {
        Object object = this.memberListMutex;
        synchronized (object) {
            return (SingleCall[])this.memberList.toArray(new SingleCall[this.memberList.size()]);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setHangupByUser() {
        super.setHangupByUser();
        Object object = this.memberListMutex;
        synchronized (object) {
            SingleCall[] singleCallArray = this.getMembers();
            for (int i2 = 0; i2 < singleCallArray.length; ++i2) {
                singleCallArray[i2].setHangupByUser();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addMember(SingleCall singleCall) {
        Object object = this.memberListMutex;
        synchronized (object) {
            if (!this.memberList.contains(singleCall)) {
                this.memberList.add(singleCall);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeMembers() {
        Object object = this.memberListMutex;
        synchronized (object) {
            this.memberList.clear();
        }
    }
}

