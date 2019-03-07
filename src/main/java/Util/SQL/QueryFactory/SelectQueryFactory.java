package Util.SQL.QueryFactory;

import Util.SQL.QueryStatements.SelectQueries.*;
import Models.Tables;

public class SelectQueryFactory {

    public static SelectQuery getQuery(Tables name) {
        if (name.equals(Tables.users)) {
            return new SelectFromUsers();
        }
        if (name.equals(Tables.beer_choices)) {
            return new SelectFromBeerChoices();
        }
        if (name.equals(Tables.beers)) {
            return new SelectFromBeers();
        }
        if (name.equals(Tables.matches))
        {
            return new SelectFromMatches();
        }
        return null;
    }

}
