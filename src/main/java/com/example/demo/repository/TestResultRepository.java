package com.example.demo.repository;

import com.example.demo.model.TestResult;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TestResultRepository {

    private final JdbcTemplate jdbcTemplate;

    public TestResultRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(TestResult result){

        String sql = "INSERT INTO test_results(test_name,status,execution_time) VALUES (?,?,?)";

        jdbcTemplate.update(sql,
                result.getTestName(),
                result.getStatus(),
                result.getExecutionTime());

    }
    public List<TestResult> findAll(){

        String sql = "SELECT * FROM test_results";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new TestResult(
                        rs.getString("test_name"),
                        rs.getString("status"),
                        rs.getDouble("execution_time")
                )
        );
    }

    public TestResult findById(int id){

        String sql = "SELECT * FROM test_results WHERE id=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new TestResult(
                        rs.getString("test_name"),
                        rs.getString("status"),
                        rs.getDouble("execution_time")
                )
        );
    }

}