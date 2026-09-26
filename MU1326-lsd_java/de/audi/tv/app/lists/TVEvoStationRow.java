/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.interapp.ITVRowFactory;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IRowProperties;
import de.audi.tv.app.lists.StationStatus;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVEvoStationRow
extends AbstractTVStationRow {
    private static final int EVO_COL_COUNT;
    private static final int COL_PROPERTIES;
    private static final int COL_ERROR_ICON;
    private static final int COL_STATION_ICON;
    private static final int COL_IS_FAVORITE;
    private static final int COL_CLASSIFICATION;
    private static final int COL_RECORD_SET;
    private static final int DESIGN_WITHOUT_CLASSIFICATION;
    private static final int DESIGN_WITH_CLASSIFICATION;
    private IRowProperties properties;
    private StationStatus status = new StationStatus(0, 0);

    protected TVEvoStationRow(long l, ServiceInfo serviceInfo, int n, ITVRowFactory iTVRowFactory) {
        super(l, serviceInfo, 7);
        this.initColumns(serviceInfo, n, iTVRowFactory);
    }

    public TVEvoStationRow(long l, ServiceInfo serviceInfo, int n, boolean bl, ITVRowFactory iTVRowFactory) {
        super(l, serviceInfo, bl, 7);
        this.initColumns(serviceInfo, n, iTVRowFactory);
    }

    private void initColumns(ServiceInfo serviceInfo, int n, ITVRowFactory iTVRowFactory) {
        this.properties = iTVRowFactory.createProperties(serviceInfo);
        this.setDefaultProperties();
        this.setInteger(2, 0);
        this.setInteger(3, TVUtil.getChannelType(serviceInfo.sType));
        this.setInteger(4, 0);
        this.setInteger(5, TVEvoStationRow.getServiceClassification(serviceInfo.getContentGroup()));
        this.setInteger(6, n == 0 ? 0 : 1);
    }

    public TVEvoStationRow(TVEvoStationRow tVEvoStationRow) {
        super(tVEvoStationRow);
        this.properties = tVEvoStationRow.properties;
        this.status = tVEvoStationRow.getState();
    }

    @Override
    public EvoListRow copy() {
        return new TVEvoStationRow(this);
    }

    @Override
    public synchronized void makeFavorite(boolean bl) {
        this.setInteger(4, bl ? 1 : 0);
        this.properties.setElementIsFavorite(bl);
        this.setPropertyCell(1, new PropertyListCell(this.properties.getCategory(), this.properties.toArray()));
    }

    @Override
    public synchronized void evaluateProgramInfo(ProgramInfo programInfo) {
        this.properties.setDatabroadcastIsCheckingOrUnavailable(programInfo.variantDatabroadcastFlag == 0);
        this.properties.setDatabroadcastIsLoading(programInfo.variantDatabroadcastFlag == 1);
        this.properties.setDatabroadcastIsAvailable(programInfo.variantDatabroadcastFlag == 2);
        this.properties.setVisualAudioIsUnavailable(programInfo.visAudioFlag == 0);
        this.properties.setVisualAudioIsLoading(programInfo.visAudioFlag == 1);
        this.properties.setVisualAudioIsAvailable(programInfo.visAudioFlag == 2);
        this.properties.setTeletextIsUnavailable(programInfo.teletextFlag == 0);
        this.properties.setTeletextIsLoading(programInfo.teletextFlag == 1);
        this.properties.setTeletextIsAvailable(programInfo.teletextFlag == 2);
        this.setPropertyCell(1, new PropertyListCell(this.properties.getCategory(), this.properties.toArray()));
    }

    @Override
    public void resetProgramInfo() {
        this.setDefaultProperties();
    }

    public void setDefaultProperties() {
        this.properties.setDatabroadcastIsCheckingOrUnavailable(true);
        this.properties.setDatabroadcastIsLoading(false);
        this.properties.setDatabroadcastIsAvailable(false);
        this.properties.setVisualAudioIsUnavailable(true);
        this.properties.setVisualAudioIsLoading(false);
        this.properties.setVisualAudioIsAvailable(false);
        this.properties.setTeletextIsUnavailable(true);
        this.properties.setTeletextIsLoading(false);
        this.properties.setTeletextIsAvailable(false);
        this.setPropertyCell(1, new PropertyListCell(this.properties.getCategory(), this.properties.toArray()));
    }

    @Override
    public PropertyListCell getProperties() {
        return (PropertyListCell)this.getCell(1);
    }

    @Override
    public synchronized void setStationStatus(StationStatus stationStatus) {
        this.status = stationStatus;
        int n = TVUtil.getCasStatus(stationStatus.casState);
        if (n == 6 && TVUtil.isCmmbService(this.service)) {
            n = 0;
            this.setInteger(3, 11);
        }
        if (n == 0) {
            n = TVUtil.getMuteStatus(stationStatus.muteState);
            if (TVUtil.isCmmbService(this.service)) {
                this.setInteger(3, TVUtil.getChannelType(this.service.getSType()));
            }
        }
        this.setInteger(2, n);
    }

    @Override
    public synchronized StationStatus getState() {
        return this.status;
    }

    @Override
    public void updateLogo(ResourceLocator resourceLocator) {
    }
}

