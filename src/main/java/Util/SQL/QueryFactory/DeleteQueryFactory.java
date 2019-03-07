package Util.SQL.QueryFactory;

import Util.SQL.QueryStatements.DeleteQueries.*;
import Models.Tables;

public class DeleteQueryFactory {
    public static DeleteQuery getQuery(Tables name) {
        if (name.equals(Tables.beer_choices)) {
            return new DeleteFromBeerChoices();
        }
        if (name.equals(Tables.matches))
        {
            return new DeleteFromMatches();
        }
        return null;
    }
}
