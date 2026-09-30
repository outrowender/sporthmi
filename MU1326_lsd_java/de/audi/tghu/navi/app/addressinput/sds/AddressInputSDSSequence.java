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
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequenceSdsJpKr;
import de.audi.tghu.navi.app.addressinput.junction.JunctionInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.state.StateInputSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetRefinementByCityInputSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputSDSSequence {
    public static final String COMMANDLIST_KEY_INVALID = "[SDS_Command_List_Invalid]";
    protected final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    protected final SpellerStack spellerStack;
    protected final CityHistory cityHistory;
    protected final Monitor commandListsMonitor;
    protected final IPreviewMap previewMap;
    protected final IAddressInputForm addressInputService;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
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
        this.logChannel.log(10000000, this.CLASS_NAME + "#setHouseNumberByIndex() Currently this method is only available for Asia");
    }

    public void updateDetailScreenInfo(IMatchspellerModelAccess iMatchspellerModelAccess, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "%1#updateDetailScreenInfo()", (Object)this.CLASS_NAME);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(iMatchspellerModelAccess));
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)1);
            }
        });
        commandList.execute(this.CLASS_NAME + "#updateDetailScreenInfo()");
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
            this.logChannel.log(100000, "AddressInputSDSSequence#setOneShotDataEU( %1, %2, %3 ) - city is null!", (Object)string, (Object)string2, (Object)string3);
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
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                boolean bl = this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
                naviServiceListener.responseSetOneShotData(bl ? (byte)0 : 1);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetOneShotData((byte)1);
            }
        });
        commandList.execute("AddressInputSDSSequence#setOneShotDataEU");
    }

    public void setOneShotDataNAR() {
    }

    public void setOneShotDataCN(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, IMatchspellerModelAccess iMatchspellerModelAccess3, String string, String string2, String string3, String string4, String string5, String string6, NaviServiceListener naviServiceListener) {
        if (Util.isEmpty(string)) {
            this.logChannel.log(100000, "AddressInputSDSSequence#setOneShotDataCN( %1, %2, %3 ) - city is null!", (Object)string, (Object)string2, (Object)string3);
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
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                boolean bl = this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
                naviServiceListener.responseSetOneShotData(bl ? (byte)0 : 1);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetOneShotData((byte)1);
            }
        });
        commandList.execute("AddressInputSDSSequence#setOneShotDataCN");
    }

    public void setOneShotDataJP(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, final IMatchspellerModelAccess iMatchspellerModelAccess3, final IMatchspellerModelAccess iMatchspellerModelAccess4, IMatchspellerModelAccess iMatchspellerModelAccess5, final IMatchspellerModelAccess iMatchspellerModelAccess6, String string, String string2, final String string3, final String string4, final String string5, final String string6, String string7, String string8, final String string9, final String string10, final String string11, final String string12, final NaviServiceListener naviServiceListener) {
        if (Util.isEmpty(string)) {
            this.logChannel.log(100000, "AddressInputSDSSequence#setOneShotDataJP - prefecture is null!");
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
            commandList.add(new NavCommand(this.CLASS_NAME + "#Check if ward can be added"){

                public void execute() {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(152) && this.dsiResponseContainer.refinementCriterionAvailable(152) && !Util.isEmpty(string3)) {
                        WardInputSequence wardInputSequence = new WardInputSequence(iMatchspellerModelAccess3, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.addressInputService, AddressInputSDSSequence.this.previewMap, naviServiceListener);
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(wardInputSequence, string3, string9, false));
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.add(new NavCommand(this.CLASS_NAME + "#check if place name can be added "){

                public void execute() {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(147) && !Util.isEmpty(string4)) {
                        PlacenameInputSequence placenameInputSequence = new PlacenameInputSequence(iMatchspellerModelAccess4, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.addressInputService, AddressInputSDSSequence.this.previewMap);
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(placenameInputSequence, string4, string10, false));
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.add(new NavCommand(this.CLASS_NAME + "#check if chome can be added"){

                public void execute() {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(144) && !Util.isEmpty(string5)) {
                        ChomeInputSequence chomeInputSequence = new ChomeInputSequence(iMatchspellerModelAccess4, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.addressInputService, AddressInputSDSSequence.this.previewMap);
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(chomeInputSequence, string5, string11, false));
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.add(new NavCommand(this.CLASS_NAME + "#check if house number can be added"){

                public void execute() {
                    if (!Util.isEmpty(string6)) {
                        HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence = null;
                        if (this.dsiResponseContainer.selectionCriterionAvailable(154)) {
                            housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequenceSdsJpKr(iMatchspellerModelAccess6, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.previewMap, AddressInputSDSSequence.this.addressInputService);
                        } else if (this.dsiResponseContainer.selectionCriterionAvailable(5)) {
                            housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequence(iMatchspellerModelAccess6, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.previewMap, AddressInputSDSSequence.this.addressInputService);
                        }
                        if (housenumberMatchspellerInputSimpleSequence != null) {
                            this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(housenumberMatchspellerInputSimpleSequence, string6, string12, false));
                        } else {
                            this.getCommandList().commandFinished();
                        }
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
        }
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                boolean bl = this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
                naviServiceListener.responseSetOneShotData(bl ? (byte)0 : 1);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetOneShotData((byte)1);
            }
        });
        commandList.execute("AddressInputSDSSequence#setOneShotDataJP");
    }

    public void setOneShotDataKR(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, final IMatchspellerModelAccess iMatchspellerModelAccess3, final IMatchspellerModelAccess iMatchspellerModelAccess4, IMatchspellerModelAccess iMatchspellerModelAccess5, final IMatchspellerModelAccess iMatchspellerModelAccess6, String string, String string2, final String string3, final String string4, final String string5, final String string6, String string7, String string8, final String string9, final String string10, final String string11, final String string12, final NaviServiceListener naviServiceListener) {
        if (Util.isEmpty(string)) {
            this.logChannel.log(100000, "AddressInputSDSSequence#setOneShotDataKR - province is null!");
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
            commandList.add(new NavCommand(this.CLASS_NAME + "#Check if ward can be added"){

                public void execute() {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(152) && this.dsiResponseContainer.refinementCriterionAvailable(152) && !Util.isEmpty(string3)) {
                        WardInputSequence wardInputSequence = new WardInputSequence(iMatchspellerModelAccess3, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.addressInputService, AddressInputSDSSequence.this.previewMap, naviServiceListener);
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(wardInputSequence, string3, string9, false));
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.add(new NavCommand(this.CLASS_NAME + "#check if submunicipal town can be added "){

                public void execute() {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(150) && !Util.isEmpty(string4)) {
                        SubmunicipalTownOrStreetInputSequence submunicipalTownOrStreetInputSequence = new SubmunicipalTownOrStreetInputSequence(iMatchspellerModelAccess4, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.addressInputService, AddressInputSDSSequence.this.previewMap);
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(submunicipalTownOrStreetInputSequence, string4, string10, false));
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.add(new NavCommand(this.CLASS_NAME + "#check if village can be added"){

                public void execute() {
                    if (this.dsiResponseContainer.selectionCriterionAvailable(151) && this.dsiResponseContainer.refinementCriterionAvailable(151) && !Util.isEmpty(string5)) {
                        VillageAndStreetInputSequence villageAndStreetInputSequence = new VillageAndStreetInputSequence(iMatchspellerModelAccess4, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.addressInputService, AddressInputSDSSequence.this.previewMap);
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(villageAndStreetInputSequence, string5, string11, false));
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.add(new NavCommand(this.CLASS_NAME + "#check if house number can be added"){

                public void execute() {
                    if (!Util.isEmpty(string6)) {
                        HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence = null;
                        if (this.dsiResponseContainer.selectionCriterionAvailable(154)) {
                            housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequenceSdsJpKr(iMatchspellerModelAccess6, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.previewMap, AddressInputSDSSequence.this.addressInputService);
                        } else if (this.dsiResponseContainer.selectionCriterionAvailable(5)) {
                            housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequence(iMatchspellerModelAccess6, AddressInputSDSSequence.this.spellerStack, AddressInputSDSSequence.this.commandListFactory, AddressInputSDSSequence.this.previewMap, AddressInputSDSSequence.this.addressInputService);
                        }
                        if (housenumberMatchspellerInputSimpleSequence != null) {
                            this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSSequence.this.getSetInputCommandList(housenumberMatchspellerInputSimpleSequence, string6, string12, false));
                        } else {
                            this.getCommandList().commandFinished();
                        }
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
        }
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                boolean bl = this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
                naviServiceListener.responseSetOneShotData(bl ? (byte)0 : 1);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetOneShotData((byte)1);
            }
        });
        commandList.execute("AddressInputSDSSequence#setOneShotDataKR");
    }

    public void validateSpelledStreetName(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#validateSpelledStreetName( %1 )", (Object)string);
        StreetInputSequence streetInputSequence = new StreetInputSequence(iMatchspellerModelAccess, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetInputCommandList(streetInputSequence, string, null, false);
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                boolean bl = this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
                boolean bl2 = this.dsiResponseContainer.selectionCriterionAvailable(127);
                if (bl || bl2) {
                    if (bl2) {
                        naviServiceListener.responseValidateSpelledStreetName((byte)2);
                    } else {
                        naviServiceListener.responseValidateSpelledStreetName((byte)0);
                    }
                } else {
                    naviServiceListener.responseValidateSpelledStreetName((byte)1);
                }
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseValidateSpelledStreetName((byte)1);
            }
        });
        commandList.execute("AddressInputSDSSequence#validateSpelledStreetName()");
    }

    protected CommandList getSetSDSInputCommandList(IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, String string, String string2, NaviServiceListener naviServiceListener) {
        return this.getSetInputSDSCommandList(iMatchspellerInputSequenceExt, string, string2, naviServiceListener, false);
    }

    private CommandList getSetInputSDSCommandList(CountryInputSequence countryInputSequence, StateInputSequence stateInputSequence, String string, String string2, String string3, String string4, NaviServiceListener naviServiceListener, final boolean bl) {
        CommandList commandList = this.getSetInputCommandList(countryInputSequence, string, string2, true);
        if (!Util.isEmpty(string3)) {
            commandList.add(this.getSetInputCommandList(stateInputSequence, string3, string4, false));
        }
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                boolean bl4;
                boolean bl2 = bl4 = this.dsiResponseContainer.getLiCurrentLD() != null && this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
                if (AddressInputSDSSequence.this.logChannel.isDebug2()) {
                    this.logger.log(100000000, "AddressInputSDSSequence#getSetInputSDSCommandList#NotifyNaviServiceListenerCommand liCurrentLD valid = %1, isCountryOrStateSpeller = %2", bl4, bl);
                }
                boolean bl3 = bl4 || bl;
                naviServiceListener.responseSetLocationPart(bl3 ? (byte)0 : 1);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)1);
            }
        });
        return commandList;
    }

    protected CommandList getSetInputSDSCommandList(IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, String string, String string2, NaviServiceListener naviServiceListener, final boolean bl) {
        CommandList commandList = this.getSetInputCommandList(iMatchspellerInputSequenceExt, string, string2, true);
        commandList.put(COMMANDLIST_KEY_INVALID, new Boolean(false));
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                boolean bl5;
                boolean bl2 = bl5 = this.dsiResponseContainer.getLiCurrentLD() != null && this.dsiResponseContainer.getLiCurrentLD().isPositionValid();
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "AddressInputSDSSequence#getSetInputSDSCommandList#NotifyNaviServiceListenerCommand liCurrentLD valid = %1, isCountryOrStateSpeller = %2", bl5, bl);
                }
                boolean bl3 = bl5 || bl;
                Boolean bl4 = (Boolean)this.getCommandList().get(AddressInputSDSSequence.COMMANDLIST_KEY_INVALID);
                if (bl3 && bl4.booleanValue()) {
                    naviServiceListener.responseSetLocationPart((byte)3);
                } else {
                    naviServiceListener.responseSetLocationPart(bl3 ? (byte)0 : 1);
                }
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)1);
            }
        });
        return commandList;
    }

    protected CommandList getSetInputCommandList(final IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, final String string, String string2, boolean bl) {
        CommandList commandList = this.createCommandList();
        if (bl) {
            commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(112)));
        }
        commandList.add(iMatchspellerInputSequenceExt.createStartCommandList(false));
        if (Util.isEmpty(string2)) {
            commandList.add(new SetInputCommand(string));
            commandList.add(new NavCommand("SelectResult"){

                public void execute() {
                    if (this.dsiResponseContainer.getLispValueListCount() > 0L && this.dsiResponseContainer.getLispValueList() != null) {
                        LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
                        this.logger.log(10000000, "AddressInputSDSSequence#execute#liValueList() - select element ( %1 )", (Object)lIValueListElement.getData());
                        this.getCommandList().commandFinishedWithPostSequence(iMatchspellerInputSequenceExt.getSelectListElementCommandList(lIValueListElement, false));
                    } else {
                        this.logger.log(10000, "AddressInputSDSSequence#execute#liValueList() - no results found for input ( %1 )!", (Object)string);
                        this.getCommandList().commandAborted("no results found");
                    }
                }
            });
        } else {
            commandList.add(iMatchspellerInputSequenceExt.getSelectElementByIdentifierCommandList(string2));
        }
        commandList.add(new LISPCancelSpellerCommand());
        return commandList;
    }

    public void querySpelledCityResultList(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#querySpelledCityResultList( %1 )", (Object)string);
        CityZipInputSequence cityZipInputSequence = new CityZipInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingResultList(string, cityZipInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledCityResultList");
    }

    public void querySpelledStreetResultList(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#querySpelledStreetResultList( %1 )", (Object)string);
        StreetInputSequence streetInputSequence = new StreetInputSequence(iMatchspellerModelAccess, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingResultList(string, streetInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledStreetResultList");
    }

    public void querySpelledStreetResultList2(IMatchspellerModelAccess iMatchspellerModelAccess, String string, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "SDSHandlerImpl#querySpelledStreetResultList2()");
        StreetRefinementByCityInputSequence streetRefinementByCityInputSequence = new StreetRefinementByCityInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingResultList(string, streetRefinementByCityInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledStreetResultList2");
    }

    public void selectSpelledCityName(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#selectSpelledCityName( %1 )", bl);
        CityZipInputSequence cityZipInputSequence = new CityZipInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.cityHistory, 1, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingSelection(bl, object, cityZipInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#selectSpelledCityName");
    }

    public void selectSpelledStreetName(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#selectSpelledStreetName()");
        StreetInputSequence streetInputSequence = new StreetInputSequence(iMatchspellerModelAccess, null, this.spellerStack, this.commandListFactory, false, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingSelection(bl, object, streetInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#querySpelledStreetResultList");
    }

    public void selectSpelledStreetName2(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl, Object object, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#selectSpelledStreetName2()");
        StreetRefinementByCityInputSequence streetRefinementByCityInputSequence = new StreetRefinementByCityInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.performSDSSpellingSelection(bl, object, streetRefinementByCityInputSequence, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#selectSpelledStreetName2");
    }

    protected CommandList performSDSSpellingResultList(String string, IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#performSDSSpellingResultList( %1 )", (Object)string);
        CommandList commandList = this.createCommandList();
        commandList.add(iMatchspellerInputSequenceExt.createStartCommandList(true));
        if (!Util.isEmpty(string)) {
            commandList.add(new SetInputCommand(string));
        }
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand("PrepareSDSResult."){

            public void execute() {
                String[] stringArray = null;
                SpellingResult[] spellingResultArray = null;
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                if (Util.isListValid(lIValueList) && lIValueList.getList().length > 0) {
                    LIValueListElement[] lIValueListElementArray = lIValueList.getList();
                    this.logger.log(10000000, "AddressInputSDSSequence#PrepareSDSResult#execute - try to convert %1 entries", (long)lIValueListElementArray.length);
                    LISpellerData lISpellerData = this.dsiResponseContainer.getSpellerState();
                    stringArray = new String[lIValueListElementArray.length];
                    spellingResultArray = new SpellingResult[lIValueListElementArray.length];
                    for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                        stringArray[i2] = lIValueListElementArray[i2].getData();
                        spellingResultArray[i2] = new SpellingResult(lIValueListElementArray[i2], lISpellerData);
                    }
                }
                this.getCommandList().put("SPELLING_ENTRIES", stringArray);
                this.getCommandList().put("SPELLING_INDICES", spellingResultArray);
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                String[] stringArray = (String[])this.getCommandList().get("SPELLING_ENTRIES");
                Object[] objectArray = (Object[])this.getCommandList().get("SPELLING_INDICES");
                boolean bl = stringArray != null && objectArray != null;
                naviServiceListener.responseQuerySpelledLocationPartResultList(bl ? (byte)0 : 3, stringArray, objectArray);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseQuerySpelledLocationPartResultList((byte)1, null, null);
            }
        });
        return commandList;
    }

    protected CommandList performSDSSpellingSelection(boolean bl, Object object, final IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#performSDSSpellingSelection( %1 )", bl);
        CommandList commandList = this.createCommandList();
        if (bl) {
            final SpellingResult spellingResult = (SpellingResult)object;
            commandList.add(new LIRestoreStateCommand(spellingResult.getLiSpellerData()));
            commandList.add(new NavCommand("SelectEntryFromList"){

                public void execute() {
                    this.logger.log(10000000, "AddressInputSDSSequence#SelectEntryFromList#execute()");
                    LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                    LIValueListElement lIValueListElement = spellingResult.getElement();
                    int n = Util.getLIValueListElement(this.logger, lIValueList, lIValueListElement.getListIndex());
                    if (n >= 0) {
                        LIValueListElement lIValueListElement2 = lIValueList.getList()[n];
                        this.logger.log(10000000, "SelectEntryFromList#execute() - found element at index %2: %1", (Object)lIValueListElement2, (long)n);
                        this.getCommandList().commandFinishedWithPostSequence(iMatchspellerInputSequenceExt.getSelectListElementCommandList(lIValueListElement2, true));
                    } else {
                        this.logger.log(10000, "SelectEntryFromList#execute() - could not find selected entry in list!");
                        this.getCommandList().commandAborted("selected entry not found");
                    }
                }
            });
        } else {
            commandList.add(new LISPCancelSpellerCommand());
        }
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                naviServiceListener.responseSetSpelledLocationPart(navLocation.isPositionValid() ? (byte)0 : 2);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetSpelledLocationPart((byte)1);
            }
        });
        return commandList;
    }

    public void queryCityListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#queryCityListLength()");
        CommandList commandList = this.performGetListLength(2, true, true, true, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryCityListLength()");
    }

    public void queryZIPCodeListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#queryZIPCodeListLength()");
        CommandList commandList = this.performGetListLength(6, true, true, true, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryZIPCodeListLength()");
    }

    public void queryHouseNrListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#queryHouseNrListLength()");
        CommandList commandList = this.performGetListLength(5, false, false, false, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryHouseNrListLength()");
    }

    public void queryStreetListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#queryStreetListLength()");
        CommandList commandList = this.performGetListLength(3, false, false, true, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryStreetListLength()");
    }

    public void queryIntersectionListLength(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#queryIntersectionListLength()");
        CommandList commandList = this.performGetListLength(4, false, false, false, naviServiceListener);
        commandList.execute("AddressInputSDSSequence#queryIntersectionListLength()");
    }

    protected CommandList performGetListLength(int n, boolean bl, boolean bl2, boolean bl3, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "AddressInputSDSSequence#performGetListLength( %1 )", (long)n);
        CommandList commandList = this.createCommandList();
        commandList.add(new LIStartSpellerCommand(n, bl, bl2, bl3));
        commandList.add(new NavCommand("PrepareSDSResponse"){

            public void execute() {
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                long l = this.dsiResponseContainer.getLispValueListCount();
                String[] stringArray = null;
                if (Util.isListValid(lIValueList)) {
                    LIValueListElement[] lIValueListElementArray = lIValueList.getList();
                    stringArray = new String[lIValueListElementArray.length];
                    for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                        stringArray[i2] = lIValueListElementArray[i2].getData();
                    }
                }
                this.getCommandList().put("VDE_LIST_GET", stringArray);
                this.getCommandList().put("VDE_LIST_LENGTH_GET", new Long(l));
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                long l = (Long)this.getCommandList().get("VDE_LIST_LENGTH_GET");
                String[] stringArray = (String[])this.getCommandList().get("VDE_LIST_GET");
                naviServiceListener.responseQueryLocationPartListLength((byte)0, l, stringArray);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseQueryLocationPartListLength((byte)1, -1L, null);
            }
        });
        return commandList;
    }

    protected CommandList createCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.addMonitor(this.commandListsMonitor);
        return commandList;
    }

    protected class SpellingResult {
        private final LIValueListElement element;
        private final LISpellerData liSpellerData;

        public SpellingResult(LIValueListElement lIValueListElement, LISpellerData lISpellerData) {
            this.element = lIValueListElement;
            this.liSpellerData = lISpellerData;
        }

        public LIValueListElement getElement() {
            return this.element;
        }

        public LISpellerData getLiSpellerData() {
            return this.liSpellerData;
        }
    }
}

