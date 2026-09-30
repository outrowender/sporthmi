/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.AbstractAddressInputListenerEvo;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;

public abstract class AbstractAddressInputListenerEU
extends AbstractAddressInputListenerEvo {
    public AbstractAddressInputListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
    }

    protected abstract void initListeners();
}

