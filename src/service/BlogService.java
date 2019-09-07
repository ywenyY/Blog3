package service;

import domain.Blog;
import domain.PageBean;

import java.util.List;
import java.util.Map;

public interface BlogService {
    /**
     * 完成查询博客
     * @return
     */
    public List<Blog> findAll();

    /**
     * 保存博客
     */
    void addBlog(Blog blog);

    /**
     * 根据id删除blog
     */
    void deleteBlog(String id);

    /**
     * 分页查询
     */
    public PageBean<Blog> findBlogByPage(String currentPage, String rows);

    /**
     *
     */
    public PageBean<Blog> SearchBlogByPage(String currentPage, String rows, Map<String, String[]> condition);
    /**
     *根据ID查询，回显
     */
    Blog findBlogById(String id);

    /**
     * 修改用户信息
     */
    void updateBlog(Blog blog);
}
