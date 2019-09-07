package dao;

import domain.Blog;

import java.util.List;
import java.util.Map;

public interface BlogDao {
    public List<Blog> findAll();
    public void addBlog(Blog blog);
    void deleteBlog(int id);

    /**
     * 查询总记录数
     * @return
     * @param
     */
    int findTotalCount();

    /**
     * 分页每页记录
     * @param start
     * @param rows
     * @return
     */
    List<Blog> findByPage(int start, int rows);

    /**
     * 查询总记录
     * */
    int SearchTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询后的每页记录
     */
    List<Blog> searchByPage(int start, int rows,Map<String, String[]> condition);
    /**
     * 回显，根据Id查询数据
     * @param id
     * @return
     */
    Blog findById(int id);
    void update(Blog blog);
}
