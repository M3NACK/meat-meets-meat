package Util.SQL.QueryFactory;

import Util.SQL.QueryStatements.SelectQueries.SelectFromBeerChoices;
import Util.SQL.QueryStatements.SelectQueries.SelectFromBeers;
import Util.SQL.QueryStatements.SelectQueries.SelectFromUsers;
import Util.SQL.QueryStatements.SelectQueries.SelectQuery;
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
        return null;
    }

}
