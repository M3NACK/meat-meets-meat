package Util.SQL.QueryFactory;

import Util.SQL.QueryStatements.InsertQueries.InsertIntoBeers;
import Util.SQL.QueryStatements.InsertQueries.InsertQuery;
import Util.SQL.QueryStatements.InsertQueries.InsertIntoUsers;
import Util.SQL.QueryStatements.InsertQueries.InsertIntoChoices;
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
        return null;
    }
}
