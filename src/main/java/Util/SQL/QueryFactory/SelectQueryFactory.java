package Util.SQL.QueryFactory;

import Util.SQL.QueryStatements.SelectQueries.SelectFromUsers;
import Util.SQL.QueryStatements.SelectQueries.SelectQuery;
import Models.Tables;

public class SelectQueryFactory {

    public static SelectQuery getQuery(Tables name) {
        if (name.equals(Tables.users)) {
            return new SelectFromUsers();
        }
        return null;
    }

}
