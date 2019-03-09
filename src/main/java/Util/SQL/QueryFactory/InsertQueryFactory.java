package Util.SQL.QueryFactory;

import Util.SQL.QueryStatements.InsertQueries.*;
import Models.Tables;

public class InsertQueryFactory {
    public static InsertQuery getQuery(Tables name) {
        if (name.equals(Tables.users)) {
            return new InsertIntoUsers();
        }
        if (name.equals(Tables.beers)) {
            return new InsertIntoBeers();
        }
        if (name.equals(Tables.beer_choices))
        {
            return new InsertIntoChoices();
        }
        if (name.equals(Tables.matches))
        {
            return new InsertIntoMatches();
        }
        return null;
    }
}
