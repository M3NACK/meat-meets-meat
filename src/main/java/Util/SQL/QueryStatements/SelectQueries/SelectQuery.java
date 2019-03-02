package Util.SQL.QueryStatements.SelectQueries;

import java.sql.ResultSet;

public interface SelectQuery {
    ResultSet execute(Object o);
}
