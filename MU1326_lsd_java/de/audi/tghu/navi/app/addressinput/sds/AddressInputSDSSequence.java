/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequenceExt;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.ChomeInputSequence;
import de.audi.tghu.navi.app.addressinput.asia.PlacenameInputSequence;
import de.audi.tghu.navi.app.addressinput.asia.SubmunicipalTownOrStreetInputSequence;
import de.audi.tghu.navi.app.addressinput.asia.VillageAndStreetInputSequence;
import de.audi.tghu.navi.app.addressinput.asia.WardInputSequence;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSequence;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.CountryInputSequence;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.junction.JunctionInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$1;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$10;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$11;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$12;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$13;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$14;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$15;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$16;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$17;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$18;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$19;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$2;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$20;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$21;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$22;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$23;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$24;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$25;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$26;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$27;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$28;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$29;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$3;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$30;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$31;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$32;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$33;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$34;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$4;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$5;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$6;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$7;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$8;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$9;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$SpellingResult;
import de.audi.tghu.navi.app.addressinput.state.StateInputSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetRefinementByCityInputSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.Util;

public class AddressInputSDSSequence {
    public static final String COMMANDLIST_KEY_INVALID;
    protected final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    protected final SpellerStack spellerStack;
    protected final CityHistory cityHistory;
    protected final Monitor commandListsMonitor;
    protected final IPreviewMap previewMap;
    protected final IAddressInputForm addressInputService;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final NavigationEnv env;

    public AddressInputSDSSequence(SpellerStack spellerStack, ICommandListFactory iCommandListFactory, CityHistory cityHistory, LogChannel logChannel, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm, NavigationEnv navigationEnv) {
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.cityHistory = cityHistory;
        this.logChannel = logChannel;
        this.previewMap = iPreviewMap;
        this.addressInputService = iAddressInputForm;
        this.env = navigationEnv;
        this.commandListsMonitor = new Monitor(logChannel);
    }

    public void setHouseNumber(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence = new HousenumberMatchspellerInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(housenumberMatchspellerInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setHouseNumber");
    }

    public void setHouseNumberByIndex(IMatchspellerModelAccess iMatchspellerModelAccess, int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setHouseNumberByIndex() Currently this method is only available for Asia").toString());
    }

    public void updateDetailScreenInfo(IMatchspellerModelAccess iMatchspellerModelAccess, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#updateDetailScreenInfo()", (Object)this.CLASS_NAME);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(iMatchspellerModelAccess));
        commandList.add(new AddressInputSDSSequence$1(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$2(this, naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#updateDetailScreenInfo()").toString());
    }

    public void setJunction(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        JunctionInputSequence junctionInputSequence = new JunctionInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(junctionInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setJunction");
    }

    public void setCity(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        CityZipInputSequence cityZipInputSequence = new CityZipInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(cityZipInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setCity");
    }

    public void setZip(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        CityZipInputSequence cityZipInputSequence = new CityZipInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 2, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(cityZipInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setZip");
    }

    public void setCountry(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        CountryInputSequence countryInputSequence = new CountryInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.addressInputService, this.previewMap, this.env);
        CommandList commandList = this.getSetInputSDSCommandList(countryInputSequence, string, string2, naviServiceListener, true);
        commandList.execute("AddressInputSDSSequence#setCountry");
    }

    public void setStreet(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        StreetInputSequence streetInputSequence = new StreetInputSequence(iMatchspellerModelAccess, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(streetInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setStreet");
    }

    public void setState(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        StateInputSequence stateInputSequence = new StateInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetInputSDSCommandList(stateInputSequence, string, string2, naviServiceListener, true);
        commandList.execute("AddressInputSDSSequence#setState");
    }

    public void setCountryAndState(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, String string3, String string4, NaviServiceListener naviServiceListener) {
        CountryInputSequence countryInputSequence = new CountryInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.addressInputService, this.previewMap, this.env);
        StateInputSequence stateInputSequence = new StateInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetInputSDSCommandList(countryInputSequence, stateInputSequence, string, string2, string3, string4, naviServiceListener, true);
        commandList.execute("AddressInputSDSSequence#setCountryAndState");
    }

    public void setChome(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        ChomeInputSequence chomeInputSequence = new ChomeInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.addressInputService, this.previewMap);
        CommandList commandList = this.getSetSDSInputCommandList(chomeInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setChome");
    }

    public void setPlacename(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        PlacenameInputSequence placenameInputSequence = new PlacenameInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.addressInputService, this.previewMap);
        CommandList commandList = this.getSetSDSInputCommandList(placenameInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setPlacename");
    }

    public void setWard(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        WardInputSequence wardInputSequence = new WardInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.addressInputService, this.previewMap, naviServiceListener);
        CommandList commandList = this.getSetSDSInputCommandList(wardInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setWard");
    }

    public void setPrefecture(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        StateInputSequence stateInputSequence = new StateInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(stateInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setPrefecture");
    }

    public void setProvince(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        StateInputSequence stateInputSequence = new StateInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(stateInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setProvince");
    }

    public void setSubmunicipalTownOrStreet(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        SubmunicipalTownOrStreetInputSequence submunicipalTownOrStreetInputSequence = new SubmunicipalTownOrStreetInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.addressInputService, this.previewMap);
        CommandList commandList = this.getSetSDSInputCommandList(submunicipalTownOrStreetInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setSubmunicipalTownOrStreet");
    }

    public void setVillageAndStreet(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        VillageAndStreetInputSequence villageAndStreetInputSequence = new VillageAndStreetInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.addressInputService, this.previewMap);
        CommandList commandList = this.getSetSDSInputCommandList(villageAndStreetInputSequence, string, string2, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#setVillageAndStreet");
    }

    public void setOneShotDataEU(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, IMatchspellerModelAccess iMatchspellerModelAccess3, String string, String string2, String string3, String string4, String string5, String string6, NaviServiceListener naviServiceListener) {
        if (Util.isEmpty(string)) {
            this.logChannel.log(-1601830656, "AddressInputSDSSequence#setOneShotDataEU( %1, %2, %3 ) - city is null!", (Object)string, (Object)string2, (Object)string3);
            naviServiceListener.responseSetOneShotData((byte)1);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(112)));
        commandList.add(new LISPCancelSpellerCommand());
        CityZipInputSimpleSequence cityZipInputSimpleSequence = new CityZipInputSimpleSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
        commandList.add(this.getSetInputCommandList(cityZipInputSimpleSequence, string, string4, false));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        if (!Util.isEmpty(string2)) {
            StreetInputSimpleSequence streetInputSimpleSequence = new StreetInputSimpleSequence(iMatchspellerModelAccess2, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
            commandList.add(this.getSetInputCommandList(streetInputSimpleSequence, string2, string5, false));
            if (!Util.isEmpty(string3)) {
                HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequence(iMatchspellerModelAccess3, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
                commandList.add(this.getSetInputCommandList(housenumberMatchspellerInputSimpleSequence, string3, string6, false));
            }
        }
        commandList.add(new AddressInputSDSSequence$3(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$4(this, naviServiceListener));
        commandList.execute("AddressInputSDSSequence#setOneShotDataEU");
    }

    public void setOneShotDataNAR() {
    }

    public void setOneShotDataCN(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, IMatchspellerModelAccess iMatchspellerModelAccess3, String string, String string2, String string3, String string4, String string5, String string6, NaviServiceListener naviServiceListener) {
        if (Util.isEmpty(string)) {
            this.logChannel.log(-1601830656, "AddressInputSDSSequence#setOneShotDataCN( %1, %2, %3 ) - city is null!", (Object)string, (Object)string2, (Object)string3);
            naviServiceListener.responseSetOneShotData((byte)1);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(112)));
        commandList.add(new LISPCancelSpellerCommand());
        CityZipInputSimpleSequence cityZipInputSimpleSequence = new CityZipInputSimpleSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
        commandList.add(this.getSetInputCommandList(cityZipInputSimpleSequence, string, string4, false));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        if (!Util.isEmpty(string2)) {
            StreetInputSimpleSequence streetInputSimpleSequence = new StreetInputSimpleSequence(iMatchspellerModelAccess2, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
            commandList.add(this.getSetInputCommandList(streetInputSimpleSequence, string2, string5, false));
            if (!Util.isEmpty(string3)) {
                string6 = "";
                HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequence(iMatchspellerModelAccess3, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
                commandList.add(this.getSetInputCommandList(housenumberMatchspellerInputSimpleSequence, string3, string6, false));
            }
        }
        commandList.add(new AddressInputSDSSequence$5(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$6(this, naviServiceListener));
        commandList.execute("AddressInputSDSSequence#setOneShotDataCN");
    }

    public void setOneShotDataJP(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, IMatchspellerModelAccess iMatchspellerModelAccess3, IMatchspellerModelAccess iMatchspellerModelAccess4, IMatchspellerModelAccess iMatchspellerModelAccess5, IMatchspellerModelAccess iMatchspellerModelAccess6, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, NaviServiceListener naviServiceListener) {
        if (Util.isEmpty(string)) {
            this.logChannel.log(-1601830656, "AddressInputSDSSequence#setOneShotDataJP - prefecture is null!");
            naviServiceListener.responseSetOneShotData((byte)1);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(112)));
        commandList.add(new LISPCancelSpellerCommand());
        StateInputSequence stateInputSequence = new StateInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, this.previewMap, this.addressInputService);
        commandList.add(this.getSetInputCommandList(stateInputSequence, string, string7, false));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        if (!Util.isEmpty(string2)) {
            CityZipInputSimpleSequence cityZipInputSimpleSequence = new CityZipInputSimpleSequence(iMatchspellerModelAccess2, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
            commandList.add(this.getSetInputCommandList(cityZipInputSimpleSequence, string2, string8, false));
            if (this.previewMap != null) {
                commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
            }
            commandList.add(new AddressInputSDSSequence$7(this, new StringBuffer().append(this.CLASS_NAME).append("#Check if ward can be added").toString(), string3, iMatchspellerModelAccess3, naviServiceListener, string9));
            commandList.add(new AddressInputSDSSequence$8(this, new StringBuffer().append(this.CLASS_NAME).append("#check if place name can be added ").toString(), string4, iMatchspellerModelAccess4, string10));
            commandList.add(new AddressInputSDSSequence$9(this, new StringBuffer().append(this.CLASS_NAME).append("#check if chome can be added").toString(), string5, iMatchspellerModelAccess4, string11));
            commandList.add(new AddressInputSDSSequence$10(this, new StringBuffer().append(this.CLASS_NAME).append("#check if house number can be added").toString(), string6, iMatchspellerModelAccess6, string12));
        }
        commandList.add(new AddressInputSDSSequence$11(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$12(this, naviServiceListener));
        commandList.execute("AddressInputSDSSequence#setOneShotDataJP");
    }

    public void setOneShotDataKR(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, IMatchspellerModelAccess iMatchspellerModelAccess3, IMatchspellerModelAccess iMatchspellerModelAccess4, IMatchspellerModelAccess iMatchspellerModelAccess5, IMatchspellerModelAccess iMatchspellerModelAccess6, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, NaviServiceListener naviServiceListener) {
        if (Util.isEmpty(string)) {
            this.logChannel.log(-1601830656, "AddressInputSDSSequence#setOneShotDataKR - province is null!");
            naviServiceListener.responseSetOneShotData((byte)1);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(112)));
        commandList.add(new LISPCancelSpellerCommand());
        StateInputSequence stateInputSequence = new StateInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, this.previewMap, this.addressInputService);
        commandList.add(this.getSetInputCommandList(stateInputSequence, string, string7, false));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        if (!Util.isEmpty(string2)) {
            CityZipInputSimpleSequence cityZipInputSimpleSequence = new CityZipInputSimpleSequence(iMatchspellerModelAccess2, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
            commandList.add(this.getSetInputCommandList(cityZipInputSimpleSequence, string2, string8, false));
            if (this.previewMap != null) {
                commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
            }
            commandList.add(new AddressInputSDSSequence$13(this, new StringBuffer().append(this.CLASS_NAME).append("#Check if ward can be added").toString(), string3, iMatchspellerModelAccess3, naviServiceListener, string9));
            commandList.add(new AddressInputSDSSequence$14(this, new StringBuffer().append(this.CLASS_NAME).append("#check if submunicipal town can be added ").toString(), string4, iMatchspellerModelAccess4, string10));
            commandList.add(new AddressInputSDSSequence$15(this, new StringBuffer().append(this.CLASS_NAME).append("#check if village can be added").toString(), string5, iMatchspellerModelAccess4, string11));
            commandList.add(new AddressInputSDSSequence$16(this, new StringBuffer().append(this.CLASS_NAME).append("#check if house number can be added").toString(), string6, iMatchspellerModelAccess6, string12));
        }
        commandList.add(new AddressInputSDSSequence$17(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$18(this, naviServiceListener));
        commandList.execute("AddressInputSDSSequence#setOneShotDataKR");
    }

    public void validateSpelledStreetName(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#validateSpelledStreetName( %1 )", (Object)string);
        StreetInputSequence streetInputSequence = new StreetInputSequence(iMatchspellerModelAccess, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetInputCommandList(streetInputSequence, string, null, false);
        commandList.add(new AddressInputSDSSequence$19(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$20(this, naviServiceListener));
        commandList.execute("AddressInputSDSSequence#validateSpelledStreetName()");
    }

    protected CommandList getSetSDSInputCommandList(IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, String string, String string2, NaviServiceListener naviServiceListener) {
        return this.getSetInputSDSCommandList(iMatchspellerInputSequenceExt, string, string2, naviServiceListener, false);
    }

    private CommandList getSetInputSDSCommandList(CountryInputSequence countryInputSequence, StateInputSequence stateInputSequence, String string, String string2, String string3, String string4, NaviServiceListener naviServiceListener, boolean bl) {
        CommandList commandList = this.getSetInputCommandList(countryInputSequence, string, string2, true);
        if (!Util.isEmpty(string3)) {
            commandList.add(this.getSetInputCommandList(stateInputSequence, string3, string4, false));
        }
        commandList.add(new AddressInputSDSSequence$21(this, naviServiceListener, bl));
        commandList.setErrorCommand(new AddressInputSDSSequence$22(this, naviServiceListener));
        return commandList;
    }

    protected CommandList getSetInputSDSCommandList(IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, String string, String string2, NaviServiceListener naviServiceListener, boolean bl) {
        CommandList commandList = this.getSetInputCommandList(iMatchspellerInputSequenceExt, string, string2, true);
        commandList.put("[SDS_Command_List_Invalid]", new Boolean(false));
        commandList.add(new AddressInputSDSSequence$23(this, naviServiceListener, bl));
        commandList.setErrorCommand(new AddressInputSDSSequence$24(this, naviServiceListener));
        return commandList;
    }

    protected CommandList getSetInputCommandList(IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, String string, String string2, boolean bl) {
        CommandList commandList = this.createCommandList();
        if (bl) {
            commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(112)));
        }
        commandList.add(iMatchspellerInputSequenceExt.createStartCommandList(false));
        if (Util.isEmpty(string2)) {
            commandList.add(new SetInputCommand(string));
            commandList.add(new AddressInputSDSSequence$25(this, "SelectResult", iMatchspellerInputSequenceExt, string));
        } else {
            commandList.add(iMatchspellerInputSequenceExt.getSelectElementByIdentifierCommandList(string2));
        }
        commandList.add(new LISPCancelSpellerCommand());
        return commandList;
    }

    public void querySpelledCityResultList(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#querySpelledCityResultList( %1 )", (Object)string);
        CityZipInputSequence cityZipInputSequence = new CityZipInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingResultList(string, cityZipInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledCityResultList");
    }

    public void querySpelledStreetResultList(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#querySpelledStreetResultList( %1 )", (Object)string);
        StreetInputSequence streetInputSequence = new StreetInputSequence(iMatchspellerModelAccess, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingResultList(string, streetInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledStreetResultList");
    }

    public void querySpelledStreetResultList2(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#querySpelledStreetResultList2()");
        StreetRefinementByCityInputSequence streetRefinementByCityInputSequence = new StreetRefinementByCityInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingResultList(string, streetRefinementByCityInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledStreetResultList2");
    }

    public void selectSpelledCityName(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#selectSpelledCityName( %1 )", bl);
        CityZipInputSequence cityZipInputSequence = new CityZipInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingSelection(bl, object, cityZipInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#selectSpelledCityName");
    }

    public void selectSpelledStreetName(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#selectSpelledStreetName()");
        StreetInputSequence streetInputSequence = new StreetInputSequence(iMatchspellerModelAccess, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingSelection(bl, object, streetInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledStreetResultList");
    }

    public void selectSpelledStreetName2(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#selectSpelledStreetName2()");
        StreetRefinementByCityInputSequence streetRefinementByCityInputSequence = new StreetRefinementByCityInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingSelection(bl, object, streetRefinementByCityInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#selectSpelledStreetName2");
    }

    protected CommandList performSDSSpellingResultList(String string, IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#performSDSSpellingResultList( %1 )", (Object)string);
        CommandList commandList = this.createCommandList();
        commandList.add(iMatchspellerInputSequenceExt.createStartCommandList(true));
        if (!Util.isEmpty(string)) {
            commandList.add(new SetInputCommand(string));
        }
        commandList.add(new LiGetStateCommand());
        commandList.add(new AddressInputSDSSequence$26(this, "PrepareSDSResult."));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new AddressInputSDSSequence$27(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$28(this, naviServiceListener));
        return commandList;
    }

    protected CommandList performSDSSpellingSelection(boolean bl, Object object, IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#performSDSSpellingSelection( %1 )", bl);
        CommandList commandList = this.createCommandList();
        if (bl) {
            AddressInputSDSSequence$SpellingResult addressInputSDSSequence$SpellingResult = (AddressInputSDSSequence$SpellingResult)object;
            commandList.add(new LIRestoreStateCommand(addressInputSDSSequence$SpellingResult.getLiSpellerData()));
            commandList.add(new AddressInputSDSSequence$29(this, "SelectEntryFromList", addressInputSDSSequence$SpellingResult, iMatchspellerInputSequenceExt));
        } else {
            commandList.add(new LISPCancelSpellerCommand());
        }
        commandList.add(new AddressInputSDSSequence$30(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$31(this, naviServiceListener));
        return commandList;
    }

    public void queryCityListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#queryCityListLength()");
        CommandList commandList = this.performGetListLength(2, true, true, true, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryCityListLength()");
    }

    public void queryZIPCodeListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#queryZIPCodeListLength()");
        CommandList commandList = this.performGetListLength(6, true, true, true, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryZIPCodeListLength()");
    }

    public void queryHouseNrListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#queryHouseNrListLength()");
        CommandList commandList = this.performGetListLength(5, false, false, false, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryHouseNrListLength()");
    }

    public void queryStreetListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#queryStreetListLength()");
        CommandList commandList = this.performGetListLength(3, false, false, true, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryStreetListLength()");
    }

    public void queryIntersectionListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#queryIntersectionListLength()");
        CommandList commandList = this.performGetListLength(4, false, false, false, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryIntersectionListLength()");
    }

    protected CommandList performGetListLength(int n, boolean bl, boolean bl2, boolean bl3, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "AddressInputSDSSequence#performGetListLength( %1 )", (long)n);
        CommandList commandList = this.createCommandList();
        commandList.add(new LIStartSpellerCommand(n, bl, bl2, bl3));
        commandList.add(new AddressInputSDSSequence$32(this, "PrepareSDSResponse"));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new AddressInputSDSSequence$33(this, naviServiceListener));
        commandList.setErrorCommand(new AddressInputSDSSequence$34(this, naviServiceListener));
        return commandList;
    }

    protected CommandList createCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.addMonitor(this.commandListsMonitor);
        return commandList;
    }
}

