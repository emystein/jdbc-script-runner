package ar.com.flow.persistence.jdbc;

import ar.com.flow.persistence.jdbc.connection.Connection;
import ar.com.flow.persistence.jdbc.result.DefaultResultSet;
import ar.com.flow.persistence.jdbc.result.EmptyResultSet;
import ar.com.flow.persistence.jdbc.result.ResultSet;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class DefaultStatement implements Statement {
    private final Connection connection;

    public ResultSet execute(String command) throws SQLException {
        var statement = connection.createStatement();

        statement.execute(command);

        var resultSet = statement.getResultSet() == null ?
                new EmptyResultSet() :
                new DefaultResultSet(statement.getResultSet());

        return resultSet;
    }
}
