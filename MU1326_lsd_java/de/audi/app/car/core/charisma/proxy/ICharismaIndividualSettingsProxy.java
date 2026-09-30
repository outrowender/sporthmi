/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma.proxy;

import de.audi.app.car.core.charisma.proxy.CharismaSetupTableEntryBuilder;
import de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsClient;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public interface ICharismaIndividualSettingsProxy {
    public boolean hasClients();

    public void registerClient(ICharismaIndividualSettingsClient var1);

    public void unregisterClient(ICharismaIndividualSettingsClient var1);

    public void setSetupTableEntry(CharismaSetupTableWithoutOptionMask var1);

    public void invokeSaveIndividualSettingsRequest();

    public CharismaSetupTableEntryBuilder createSetupTableEntryBuilder();
}

