package Util.SQL.QueryFactory;

import Util.SQL.QueryStatements.InsertQueries.InsertQuery;
import Util.SQL.QueryStatements.InsertQueries.InsertIntoUsers;
import Models.Tables;

public class InsertQueryFactory {
    public static InsertQuery getQuery(Tables name) {
        if (name.equals(Tables.users)) {
            return new InsertIntoUsers();
        }
        return null;
    }
}
