package in.zybernau.raja;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


@Repository
public class RajaDao {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void deleteTest() throws DataAccessException {
    jdbcTemplate.setDataSource(dataSource);
    NamedParameterJdbcTemplate naJbdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    String param = "2";

    Integer param1 = 2;

    // String query = "delete from test_table where name = ?";
    // String query = "delete from test_table where dob > '1983-01-01'"; -- error
    // String query = "delete from test_table where dob > '1983-01-01' ";
    // String query = "DELETE FROM test_table WHERE lupd > now() - ':day'::interval ";

    // String query = "DELETE FROM test_table WHERE lupd > DATE(now() - INTERVAL '? days') ";
    String query = "DELETE FROM test_table WHERE lupd > DATE(now() - ? * INTERVAL '1 days') ";
    // String queryConcat = String.format("DELETE FROM test_table WHERE lupd < DATE(now() - INTERVAL '%s days')", param);
    String queryConcat = String.format("DELETE FROM test_table WHERE lupd < DATE(CURRENT_TIMESTAMP - INTERVAL '%s days')", param);

    String selectQuery = "select DATE(now() - INTERVAL :day days ::interval)";
    String selectQuery1 = "select DATE(now() - INTERVAL 2 days ::interval)";

    try {
    // jdbcTemplate.update(query, param);
    jdbcTemplate.update(query, param1);
    jdbcTemplate.update(queryConcat);
    // MapSqlParameterSource paramSource = new MapSqlParameterSource();
    // paramSource.addValue("day", param);
    // SqlRowSet rs  = naJbdbcTemplate.query(selectQuery1, null);
    // Object res = jdbcTemplate.query(selectQuery1, null);
    // System.out.println(res);
    // SqlRowSet rs1  = naJbdbcTemplate.queryForRowSet(selectQuery, paramSource);
    // System.out.println(rs1);
    // naJbdbcTemplate.update(query, paramSource);

      // naJbdbcTemplate.update(query, paramSource);
    } catch (DataAccessException e) {
      // TODO: handle exception
      System.err.println(e.getStackTrace());
      System.out.println(e);
    } catch (Exception e) {
      System.err.println(e.getStackTrace());
      System.out.println(e);
    }
  }

}
