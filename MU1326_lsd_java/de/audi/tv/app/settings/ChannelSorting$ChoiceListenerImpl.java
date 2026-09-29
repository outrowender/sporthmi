/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.ChannelSorting;
import de.audi.tv.app.settings.ChannelSorting$1;

class ChannelSorting$ChoiceListenerImpl
extends DefaultChoiceListener {
    private final /* synthetic */ ChannelSorting this$0;

    private ChannelSorting$ChoiceListenerImpl(ChannelSorting channelSorting) {
        this.this$0 = channelSorting;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        ChannelSorting.access$100((ChannelSorting)this.this$0).lcHMI.log(-2137614336, "[ChannelSorting.itemSelected] %1", (long)n2);
        ChannelSorting.access$200(this.this$0).updateStationListSorting(n2);
        ChannelSorting.access$300(this.this$0).setBrowserListSort(n2);
    }

    /* synthetic */ ChannelSorting$ChoiceListenerImpl(ChannelSorting channelSorting, ChannelSorting$1 channelSorting$1) {
        this(channelSorting);
    }
}

