/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.testsupport.ISDSSettingEnumStateListener;
import de.audi.app.sdsmanager.testsupport.SDSSettingsEnum;

class SDSModelAccess$1
implements ISDSSettingEnumStateListener {
    private final /* synthetic */ SDSModelAccess this$0;

    SDSModelAccess$1(SDSModelAccess sDSModelAccess) {
        this.this$0 = sDSModelAccess;
    }

    @Override
    public void updateSDSSettingsEnumState(SDSSettingsEnum sDSSettingsEnum) {
        SDSModelAccess.setNLUActiveModelValue(SDSSettingsEnum.NLU.isActive());
    }
}

