/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequenceExt;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.sds.SDSNaviPicklistRowCreator;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputSDSSequenceCN
extends AddressInputSDSSequence {
    public AddressInputSDSSequenceCN(NavigationEnv navigationEnv, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, CityHistory cityHistory, LogChannel logChannel, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(spellerStack, iCommandListFactory, cityHistory, logChannel, iPreviewMap, iAddressInputForm, navigationEnv);
    }

    public void setHouseNumber(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence = new HousenumberMatchspellerInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSHousenumberInputCommandList(housenumberMatchspellerInputSequence, string, string2, naviServiceListener);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setHouseNumber").toString());
    }

    public void setHouseNumberByIndex(IMatchspellerModelAccess iMatchspellerModelAccess, int n, NaviServiceListener naviServiceListener) {
        HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence = new HousenumberMatchspellerInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetHouseNumberByIdCommandList(housenumberMatchspellerInputSequence, Integer.toString(n), naviServiceListener);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setHouseNumberByIndex").toString());
    }

    private CommandList getSetSDSHousenumberInputCommandList(IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, String string, String string2, NaviServiceListener naviServiceListener) {
        CommandList commandList = this.createCommandList();
        commandList.add(iMatchspellerInputSequenceExt.createStartCommandList(true));
        if (Util.isEmpty(string2)) {
            commandList.add(new SetInputCommand(string));
            commandList.add(new NavCommand("Update SDS Pick List"){

                public void execute() {
                    if (this.dsiResponseContainer.getLispValueListCount() >= 1L && this.dsiResponseContainer.getLispValueList() != null) {
                        AddressInputSDSSequenceCN.this.updateSDSPickList(this.dsiResponseContainer.getLispValueList());
                        this.getCommandList().commandFinished();
                    } else {
                        this.logger.log(10000, "%1#execute#liValueList() - no results found for input ( %2 )!", (Object)this.CLASS_NAME, (Object)this.name);
                        this.getCommandList().commandAborted("no results found");
                    }
                }
            });
        } else {
            commandList.add(iMatchspellerInputSequenceExt.getSelectElementByIdentifierCommandList(string2));
        }
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)0);
            }
        });
        this.setErrorCommand(naviServiceListener, commandList);
        return commandList;
    }

    protected BaseListModelApp getHouseNumberPicklist() {
        return this.env.getBaseListModel(3869);
    }

    private void updateSDSPickList(LIValueList lIValueList) {
        BaseListModelApp baseListModelApp = this.getHouseNumberPicklist();
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            baseListModelApp2.append(SDSNaviPicklistRowCreator.createPickListRowByIndexAndName(lIValueListElementArray[i2].getListIndex(), lIValueListElementArray[i2].getData()));
        }
        this.env.getChoiceModel(305).setValue(lIValueListElementArray.length);
        if (lIValueListElementArray.length == 2) {
            this.env.getLabelModel(520).setText(lIValueListElementArray[0].getData());
            this.env.getLabelModel(521).setText(lIValueListElementArray[1].getData());
        } else if (lIValueListElementArray.length > 2) {
            this.env.getLabelModel(520).setText(lIValueListElementArray[0].getData());
        }
        baseListModelApp.update(baseListModelApp2);
        this.logChannel.log(10000000, "%1#updateSDSPickList - Pick List Length is %2", (Object)this.CLASS_NAME, (long)baseListModelApp.getLength());
    }

    private CommandList getSetHouseNumberByIdCommandList(HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence, String string, NaviServiceListener naviServiceListener) {
        boolean bl;
        CommandList commandList = this.createCommandList();
        if (!Util.isEmpty(string)) {
            commandList.add(housenumberMatchspellerInputSequence.getSelectElementByIndexCommandList(Integer.valueOf(string)));
            bl = true;
        } else {
            bl = false;
            this.logChannel.log(10000, "%1#getSetHouseNumberByIdCommandList receive an empty ID", (Object)this.CLASS_NAME);
        }
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart(bl ? (byte)0 : 1);
            }
        });
        this.setErrorCommand(naviServiceListener, commandList);
        return commandList;
    }

    private void setErrorCommand(NaviServiceListener naviServiceListener, CommandList commandList) {
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart((byte)1);
            }
        });
    }
}

