/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.EulaManager;
import de.audi.app.messaging.core.dictation.EulaManager$1;
import de.audi.app.messaging.core.settings.ISettingsManagerObserver;

class EulaManager$SettingsManagerObserver
implements ISettingsManagerObserver {
    private final /* synthetic */ EulaManager this$0;

    private EulaManager$SettingsManagerObserver(EulaManager eulaManager) {
        this.this$0 = eulaManager;
    }

    @Override
    public void indicateResetToFactorySettings() {
        EulaManager.access$400(this.this$0).log(-2137614336, "[EulaManager#indicateResetToFactorySettings]");
        EulaManager.access$500(this.this$0);
    }

    /* synthetic */ EulaManager$SettingsManagerObserver(EulaManager eulaManager, EulaManager$1 eulaManager$1) {
        this(eulaManager);
    }
}

