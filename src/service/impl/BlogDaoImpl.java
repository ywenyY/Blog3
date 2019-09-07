package service.impl;

import dao.BlogDao;
import domain.Blog;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BlogDaoImpl implements BlogDao {
private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Blog> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql = "select * from blog";
        List<Blog> blogs = template.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
        return blogs;
    }

    @Override
    public void addBlog(Blog blog) {
        //1.定义sql
        String sql = "insert into blog values(null,?,?,?,?)";
        //2.执行sql
        template.update(sql,blog.getTitle(),blog.getAuthor(),blog.getDate(),blog.getContent());
    }

    @Override
    public void deleteBlog(int id) {
        //1.定义sql
        System.out.println(id);
        String sql = "delete from blog where id = ?";
        template.update(sql,id);
    }

    @Override
    public int findTotalCount() {
           String sql = "select count(*) from blog";
           return template.queryForObject(sql,Integer.class);
    }

    @Override
    public int SearchTotalCount(Map<String, String[]> condition) {
        //定义初始化模板
        String sql = "select count(*) from blog where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> ketSet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : ketSet){
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and " + key + "  like ? ");
                params.add("%"+value+"%"); //?条件的值
            }
        }
        System.out.println(sb.toString());
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Blog> searchByPage(int start, int rows, Map<String, String[]> condition) {
        //定义初始化模板
        String sql = "select * from blog where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> ketSet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : ketSet){
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and " + key + "  like ? ");
                params.add("%"+value+"%"); //?条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,?");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(),new BeanPropertyRowMapper<Blog>(Blog.class),params.toArray());
    }

    @Override
    public List<Blog> findByPage(int start, int rows) {
        String sql = "select * from blog limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<Blog>(Blog.class),start,rows);
    }

    @Override
    public Blog findById(int id) {
        String sql = "select * from blog where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Blog>(Blog.class),id);
    }

    @Override
    public void update(Blog blog) {
        System.out.println("更新数据库前的blog ："+blog);
        String sql = "update blog set title = ? , author = ? ,date = ? where id = ?";
        template.update(sql,blog.getTitle(),blog.getAuthor(),blog.getDate(),blog.getId());
    }
}
