/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.search.LastDestProducer;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.SearchResult;

class LastDestProducer$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ AbstractSearch val$abstractSearch;
    private final /* synthetic */ LastDestProducer this$0;

    LastDestProducer$1(LastDestProducer lastDestProducer, String string, NavLocation navLocation, AbstractSearch abstractSearch) {
        this.this$0 = lastDestProducer;
        this.val$navLocation = navLocation;
        this.val$abstractSearch = abstractSearch;
        super(string);
    }

    @Override
    public void execute() {
        NavPosition navPosition;
        if (this.val$navLocation == null || !this.val$navLocation.isPositionValid()) {
            this.getCommandList().commandFinished();
            return;
        }
        LastDestProducer.access$002(this.this$0, Util.getLocationAccessor(this.val$navLocation));
        SearchResult searchResult = new SearchResult();
        searchResult.applicationData = (byte[])this.getCommandList().get("LOCATION_STREAM");
        if (searchResult.applicationData == null) {
            this.logger.log(10000, "LastDestProducer#createLastDestination(): sertialization failed, bytestream is null");
            this.getCommandList().commandFinished();
            return;
        }
        searchResult.source = 16;
        searchResult.entryType = LastDestProducer.access$100(this.this$0, this.val$navLocation, LastDestProducer.access$000(this.this$0));
        searchResult.poiType = LastDestProducer.access$000(this.this$0).getPoiCategoryNumber();
        searchResult.position = navPosition = new NavPosition((float)NavigationUtilities.wgs84ToDegree(this.val$navLocation.getLatitude()), (float)NavigationUtilities.wgs84ToDegree(this.val$navLocation.getLongitude()));
        Country country = new Country();
        country.name = LocationFormatter.formatCountry(this.val$navLocation);
        country.code = LocationFormatter.formatCountryAbbreviation(this.val$navLocation);
        country.stateName = LocationFormatter.formatState(this.val$navLocation);
        country.stateAbbreviation = LocationFormatter.formatStateAbbreviation(this.val$navLocation);
        searchResult.country = country;
        searchResult.tokens = LastDestProducer.access$200(this.this$0, this.val$navLocation, searchResult);
        this.val$abstractSearch.addToHistory(searchResult);
        this.getCommandList().commandFinished();
    }
}

