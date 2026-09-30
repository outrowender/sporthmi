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
    public static final byte SOURCE_ACTIVATION_SUCCESSFUL = 1;
    public static final byte SOURCE_ACTIVATION_ALREADY_ACTIVE = 2;
    public static final byte SOURCE_ACTIVATION_FAILED_SOURCE_NOT_SUPPORTED = 3;

    public int activateSource(IActivationContext var1);

    public IActivationContext getActivationContext();

    public ISource getSource(int var1);

    public void setAutomaticSourceChange(int[] var1);

    public ISourceSlot getSelectedSlot();

    public boolean isSelectedSource(ISource var1);

    public void addSourceListener(ISourceListener var1);

    public void addSourceListListener(ISourceListListener var1);

    public void addSlotListener(IMultipleSourceSlotListener var1);

    public void addSourceSlotListener(ISource var1, ISourceSlotListener var2, boolean var3);

    public void removeSlotListener(ISource var1, ISourceSlotListener var2);

    public void addActiveSourceListener(IActiveSourceListener var1);

    public void addActiveSourceListenerAndNotifyState(IActiveSourceListener var1);

    public void removeActiveSourceListener(IActiveSourceListener var1);

    public void restorePreviousFilePlayerSource();

    public void addSourceChangeListener(ISourceChangeListener var1);

    public void setSourceActivationExtension(ISourceActivationExtension var1);
}

