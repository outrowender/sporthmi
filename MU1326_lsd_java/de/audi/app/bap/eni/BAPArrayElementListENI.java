/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.fw.functiontypes.AbstractBAPArrayElementListASG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_Data;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_Data;

public final class BAPArrayElementListENI
extends AbstractBAPArrayElementListASG {
    public BAPArrayElementListENI(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public boolean isDeleted(BAPArrayElement bAPArrayElement) {
        return bAPArrayElement instanceof DestinationsList_Data && ((DestinationsList_Data)bAPArrayElement).name.isEmptyString();
    }

    @Override
    public void handleFoundElement(BAPArrayElement bAPArrayElement, int n) {
        if (this.isDeleted(bAPArrayElement)) {
            this.list.remove(n);
        } else if (bAPArrayElement.getArrayHeader().getRecordAddress() == 2) {
            ((ServiceList_Data)this.list.get((int)n)).userSettings.serviceActivatedAllowedByDriver = ((ServiceList_Data)bAPArrayElement).userSettings.serviceActivatedAllowedByDriver;
            ((ServiceList_Data)this.list.get((int)n)).serviceId.setContent(((ServiceList_Data)bAPArrayElement).serviceId);
        } else {
            this.list.set(n, bAPArrayElement);
        }
    }
}

