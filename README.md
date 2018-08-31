# ScriptRunner
This is a refactoring exercise which uses https://github.com/BenoitDuffez/ScriptRunner as initial code to refactor.

## Description
Allows to virtually use `source script.sql` with your JDBC 

## Example

Here is an example of a supported script:

```sql
drop procedure if exists RecordStep;

delimiter $$

CREATE PROCEDURE `p2` (in txt varchar(100))
LANGUAGE SQL
DETERMINISTIC
SQL SECURITY DEFINER
COMMENT 'A procedure'
BEGIN
    SELECT concat('Hello World: ', txt);
END$$

delimiter ;

call p2("test");
call p("this will work too");
```

## Usage

It is used pretty straightforwardly:

```java
try {
    Class.forName("com.mysql.jdbc.Driver");
    mConnection = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE + "?" + "user=" + USER + "&password=" + PASSWORD);
} catch (ClassNotFoundException e) {
    System.err.println("Unable to get mysql driver: " + e);
} catch (SQLException e) {
    System.err.println("Unable to connect to server: " + e);
}
ScriptRunner runner = new ScriptRunner(mConnection, false, false);
String file = "~/path/to/script.sql";
runner.runScript(new BufferedReader(new FileReader(file)));
```

