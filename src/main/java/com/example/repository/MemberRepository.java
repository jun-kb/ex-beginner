package com.example.repository;

import com.example.domain.Member;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    private final NamedParameterJdbcTemplate template;
    private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
        Member member = new Member();
        member.setId(rs.getInt("id"));
        member.setName(rs.getString("name"));
        member.setAge((Integer) rs.getObject("age"));
        member.setDepId((Integer) rs.getObject("dep_id"));
        return member;
    };

    public MemberRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Member> findByName(String name) {
        String sql = """
                SELECT id, name, age, dep_id
                FROM members
                WHERE name LIKE :name
                ORDER BY id ASC;
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");
        return template.query(sql, param, MEMBER_ROW_MAPPER);
    }
}
