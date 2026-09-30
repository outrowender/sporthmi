/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.dsi2asi;

import de.audi.app.car.common.sdis.interapp.ISDISSportChronoAccess;
import de.audi.app.car.common.sdis.interapp.ISDISZeroEmissionAccess;
import de.audi.app.car.sdis.CarSportChronoASIProvider;
import de.audi.app.car.sdis.CarZeroEmissionASIProvider;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.dsi2asi.DsiAsiMainHandler;
import de.audi.atip.interapp.car.Car2XObjectCollection;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.global.CarViewOption;

public class GenericDsiAsiHandler {
    private ISDISFramework sdisBase;
    private LogChannel logChannel;
    private DsiAsiMainHandler dsiAsiMapper;

    public GenericDsiAsiHandler(ISDISFramework iSDISFramework) {
        this.sdisBase = iSDISFramework;
        this.logChannel = this.sdisBase.getLogChannel("App.CarSDIS.Base");
        this.dsiAsiMapper = new DsiAsiMainHandler(this.sdisBase);
    }

    public void updateValue(int n, Object object) {
        if (n < 4000) {
            this.handleViewOption(n, (CarViewOption)object);
        } else {
            this.handleValue(n, object);
        }
    }

    private void handleValue(int n, Object object) {
        switch (n) {
            case 4004: {
                this.dsiAsiMapper.updateKeyData((KeyData)object);
                break;
            }
            case 4000: {
                this.dsiAsiMapper.updateVinData(object.toString());
                break;
            }
            case 4001: {
                this.dsiAsiMapper.updateOilLevelData((OilLevelData)object);
                break;
            }
            case 4101: {
                ((CarSportChronoASIProvider)this.sdisBase.getASIDataUpdater().getSportChronoASI()).setSportChronoComponent((ISDISSportChronoAccess)object);
                break;
            }
            case 4103: {
                this.dsiAsiMapper.updateActiveRecord((SCHeader)object);
                break;
            }
            case 4104: {
                this.dsiAsiMapper.updateActiveRecordData((SCData)object);
                break;
            }
            case 4102: {
                this.dsiAsiMapper.updateRecordMode((Integer)object);
                break;
            }
            case 4105: {
                this.dsiAsiMapper.updateTrackList((SCHeader[])object);
                break;
            }
            case 4106: {
                this.dsiAsiMapper.updateTransferState((TransferState)object);
                break;
            }
            case 4200: {
                CarZeroEmissionASIProvider carZeroEmissionASIProvider = (CarZeroEmissionASIProvider)this.sdisBase.getASIDataUpdater().getZeroEmissionASI();
                if (null == carZeroEmissionASIProvider) break;
                carZeroEmissionASIProvider.setZeroEmissionAccess((ISDISZeroEmissionAccess)object);
                break;
            }
            case 4201: {
                Car2XObjectCollection.CarZeroEmissionEntry carZeroEmissionEntry;
                if (!(object instanceof Car2XObjectCollection.CarZeroEmissionEntry) || null == (carZeroEmissionEntry = (Car2XObjectCollection.CarZeroEmissionEntry)object)) break;
                ZeroEmissionEntry zeroEmissionEntry = new ZeroEmissionEntry();
                zeroEmissionEntry.setValues(carZeroEmissionEntry.getValues());
                zeroEmissionEntry.setState(carZeroEmissionEntry.getState());
                this.dsiAsiMapper.updateZECurrentBarGraph(zeroEmissionEntry);
                break;
            }
            case 4202: {
                Car2XObjectCollection.CarZeroEmissionEntry[] carZeroEmissionEntryArray;
                if (!(object instanceof Car2XObjectCollection.CarZeroEmissionEntry[]) || null == (carZeroEmissionEntryArray = (Car2XObjectCollection.CarZeroEmissionEntry[])object)) break;
                ZeroEmissionEntry[] zeroEmissionEntryArray = new ZeroEmissionEntry[carZeroEmissionEntryArray.length];
                for (int i2 = 0; i2 < zeroEmissionEntryArray.length; ++i2) {
                    zeroEmissionEntryArray[i2] = new ZeroEmissionEntry();
                    zeroEmissionEntryArray[i2].setValues(carZeroEmissionEntryArray[i2].getValues());
                    zeroEmissionEntryArray[i2].setState(carZeroEmissionEntryArray[i2].getState());
                }
                this.dsiAsiMapper.updateZEHistoryBarGraph(zeroEmissionEntryArray);
                break;
            }
            default: {
                this.logChannel.log(1000000, "updateValue: content of %1 not supported", (long)n);
            }
        }
    }

    private void handleViewOption(int n, CarViewOption carViewOption) {
        switch (n) {
            case 1: {
                this.dsiAsiMapper.updateOilLevelDataVisibilityState(carViewOption);
                break;
            }
            case 0: {
                this.dsiAsiMapper.updateVinDataVisibilityState(carViewOption);
                break;
            }
            case 4: {
                this.dsiAsiMapper.updateKeyDataVisibilityState(carViewOption);
                break;
            }
            case 3: {
                this.dsiAsiMapper.updateSIAOilInspectionVisibilityState(carViewOption);
                break;
            }
            case 101: {
                this.dsiAsiMapper.updateSCVisibilityState(carViewOption);
                break;
            }
            case 102: {
                this.dsiAsiMapper.updateZEVisibilityState(carViewOption);
                break;
            }
            default: {
                this.logChannel.log(1000000, "updateViewOption: content of %1 not supported", (long)n);
            }
        }
    }
}

