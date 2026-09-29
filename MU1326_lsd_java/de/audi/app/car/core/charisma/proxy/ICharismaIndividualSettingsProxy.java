/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma.proxy;

import de.audi.app.car.core.charisma.proxy.CharismaSetupTableEntryBuilder;
import de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsClient;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public interface ICharismaIndividualSettingsProxy {
    default public boolean hasClients() {
    }

    default public void registerClient(ICharismaIndividualSettingsClient iCharismaIndividualSettingsClient) {
    }

    default public void unregisterClient(ICharismaIndividualSettingsClient iCharismaIndividualSettingsClient) {
    }

    default public void setSetupTableEntry(CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask) {
    }

    default public void invokeSaveIndividualSettingsRequest() {
    }

    default public CharismaSetupTableEntryBuilder createSetupTableEntryBuilder() {
    }
}

