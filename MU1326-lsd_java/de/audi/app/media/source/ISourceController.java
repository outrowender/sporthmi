/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceActivationExtension;
import de.audi.app.media.source.ISourceChangeListener;
import de.audi.app.media.source.ISourceListListener;
import de.audi.app.media.source.ISourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;

public interface ISourceController {
    public static final byte SOURCE_ACTIVATION_SUCCESSFUL;
    public static final byte SOURCE_ACTIVATION_ALREADY_ACTIVE;
    public static final byte SOURCE_ACTIVATION_FAILED_SOURCE_NOT_SUPPORTED;

    default public int activateSource(IActivationContext iActivationContext) {
    }

    default public IActivationContext getActivationContext() {
    }

    default public ISource getSource(int n) {
    }

    default public void setAutomaticSourceChange(int[] nArray) {
    }

    default public ISourceSlot getSelectedSlot() {
    }

    default public boolean isSelectedSource(ISource iSource) {
    }

    default public void addSourceListener(ISourceListener iSourceListener) {
    }

    default public void addSourceListListener(ISourceListListener iSourceListListener) {
    }

    default public void addSlotListener(IMultipleSourceSlotListener iMultipleSourceSlotListener) {
    }

    default public void addSourceSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener, boolean bl) {
    }

    default public void removeSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener) {
    }

    default public void addActiveSourceListener(IActiveSourceListener iActiveSourceListener) {
    }

    default public void addActiveSourceListenerAndNotifyState(IActiveSourceListener iActiveSourceListener) {
    }

    default public void removeActiveSourceListener(IActiveSourceListener iActiveSourceListener) {
    }

    default public void restorePreviousFilePlayerSource() {
    }

    default public void addSourceChangeListener(ISourceChangeListener iSourceChangeListener) {
    }

    default public void setSourceActivationExtension(ISourceActivationExtension iSourceActivationExtension) {
    }
}

