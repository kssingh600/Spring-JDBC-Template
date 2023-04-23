package com.kdacademy.springjdbcdemo1.dao;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kdacademy.springjdbcdemo1.model.Course;

@Component
public class CourseJdbcDAO implements DAO<Course>{

    private static final Logger log = LoggerFactory.getLogger(CourseJdbcDAO.class) ;
    
    private JdbcTemplate jdbcTemplate ;

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
        Course course = new Course() ;
        course.setCourseId(rs.getInt("courseId")) ;
        course.setTitle(rs.getString("courseTitle")) ;
        course.setDesciption(rs.getString("descr")) ;
        course.setLink(rs.getString("link")) ;
        return course ;
    } ;

    public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> list() {
        String sql = "SELECT courseId, courseTitle, descr, link from course" ;
        return jdbcTemplate.query(sql, rowMapper) ;
    }

    @Override
    public void create(Course course) {
       String sql = "insert into course(courseId, courseTitle, descr, link) values(?,?,?,?)" ;
       int insert = jdbcTemplate.update(sql, course.getCourseId(), course.getTitle(), course.getDesciption(), course.getLink()) ;
       if(insert == 1){
        log.info("New course created: "+ course.getTitle());
       }
    }

    @Override
    public Optional<Course> get(int id) {
        String sql = "select courseId, courseTitle, descr, link from course where courseId=?" ;
        Course course = null ;
        try{
            course = jdbcTemplate.queryForObject(sql, rowMapper, new Object[]{id}) ;
        }
        catch(DataAccessException ex){
           log.info("Course not found: "+id); 
        }
        return Optional.ofNullable(course) ;
    }

    @Override
    public void update(Course course, int id) {
        String sql = "update course set courseTitle=?, descr=?, link=? where courseId=?" ;
        int update = jdbcTemplate.update(sql, course.getTitle(), course.getDesciption(), course.getLink(), id) ;
        if(update == 1){
            log.info("course updated: "+ course.getTitle());
        }
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from course where courseId=?", new Object[]{id}) ;
    }
    
}
