/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$ReceptionList_AutoUpdate
implements BAPEntity {
    public boolean onlineRadioReceptionListIsAutomaticallyUpdated;
    public boolean tvDvbReceptionListIsAutomaticallyUpdated;
    public boolean amSwReceptionListIsAutomaticallyUpdated;
    public boolean amLwReceptionListIsAutomaticallyUpdated;
    public boolean sdarsReceptionListIsAutomaticallyUpdated;
    public boolean dabReceptionListIsAutomaticallyUpdated;
    public boolean amReceptionListIsAutomaticallyUpdated;
    public boolean fmReceptionListIsAutomaticallyUpdated;
    private static final int RECEPTION_LIST_AUTO_UPDATE_BITSIZE;

    public FSG_Setup_Status$ReceptionList_AutoUpdate() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$ReceptionList_AutoUpdate(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineRadioReceptionListIsAutomaticallyUpdated = false;
        this.tvDvbReceptionListIsAutomaticallyUpdated = false;
        this.amSwReceptionListIsAutomaticallyUpdated = false;
        this.amLwReceptionListIsAutomaticallyUpdated = false;
        this.sdarsReceptionListIsAutomaticallyUpdated = false;
        this.dabReceptionListIsAutomaticallyUpdated = false;
        this.amReceptionListIsAutomaticallyUpdated = false;
        this.fmReceptionListIsAutomaticallyUpdated = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$ReceptionList_AutoUpdate fSG_Setup_Status$ReceptionList_AutoUpdate = (FSG_Setup_Status$ReceptionList_AutoUpdate)bAPEntity;
        return this.onlineRadioReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.onlineRadioReceptionListIsAutomaticallyUpdated && this.tvDvbReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated && this.amSwReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated && this.amLwReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated && this.sdarsReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated && this.dabReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated && this.amReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated && this.fmReceptionListIsAutomaticallyUpdated == fSG_Setup_Status$ReceptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReceptionList_AutoUpdate:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.onlineRadioReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (online radio reception list is automatically updated (DF4.1)");
        } else {
            stringBuffer.append("false  (online radio reception list is NOT automatically updated (DF4.1)");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.tvDvbReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (TV / DVB  reception list is automatically updated");
        } else {
            stringBuffer.append("false  (TV / DVB reception list is NOT automatically updated");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.amSwReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (AM-SW reception list is automatically updated");
        } else {
            stringBuffer.append("false  (AM-SW reception list is NOT automatically updated");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.amLwReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (AM-LW  reception list is automatically updated");
        } else {
            stringBuffer.append("false  (AM-LW reception list is NOT automatically updated");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.sdarsReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (SDARS reception list is automatically updated");
        } else {
            stringBuffer.append("false  (SDARS reception list is NOT automatically updated");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.dabReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (DAB reception list is automatically updated");
        } else {
            stringBuffer.append("false  (DAB reception list is NOT automatically updated");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.amReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (AM reception list is automatically updated");
        } else {
            stringBuffer.append("false  (AM reception list is NOT automatically updated");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.fmReceptionListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (FM reception list is automatically updated");
        } else {
            stringBuffer.append("false  (FM reception list is NOT automatically updated");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.onlineRadioReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.tvDvbReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.amSwReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.amLwReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.sdarsReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.dabReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.amReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.fmReceptionListIsAutomaticallyUpdated);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.onlineRadioReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.tvDvbReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.amSwReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.amLwReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.sdarsReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.dabReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.amReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.fmReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
    }
}

