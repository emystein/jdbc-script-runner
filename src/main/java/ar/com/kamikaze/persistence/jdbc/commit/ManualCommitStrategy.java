package ar.com.kamikaze.persistence.jdbc.commit;

import java.sql.SQLException;

public class ManualCommitStrategy implements CommitStrategy {
    @Override
    public boolean isManualCommit() {
        return true;
    }

    @Override
    public void commit() throws SQLException {
        // do nothing
    }
}