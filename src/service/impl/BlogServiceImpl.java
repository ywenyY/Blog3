package service.impl;

import dao.BlogDao;
import domain.Blog;
import domain.PageBean;
import service.BlogService;

import java.util.List;
import java.util.Map;

public class BlogServiceImpl implements BlogService {
    private BlogDao dao = new BlogDaoImpl();

    @Override
    public List<Blog> findAll() {
        return dao.findAll();
    }

    @Override
    public void addBlog(Blog blog) {
        dao.addBlog(blog);
    }

    @Override
    public void deleteBlog(String id) {
        dao.deleteBlog(Integer.parseInt(id));
    }

    @Override
    public PageBean<Blog> findBlogByPage(String currentPage_, String rows_) {
        int currentPage = Integer.parseInt(currentPage_);
        int rows = Integer.parseInt(rows_);

        if (currentPage <= 0){
            currentPage = 1;
        }
       //创建一个空的PageBean对象
        PageBean<Blog> pb = new PageBean<Blog>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //4.计算开始的记录索引
        int start = (currentPage - 1)*rows;
        //5.调用dao查询List集合
        List<Blog> list = dao.findByPage(start,rows);
        pb.setList(list);
        //6.计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<Blog> SearchBlogByPage(String currentPage_, String rows_, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(currentPage_);
        int rows = Integer.parseInt(rows_);

        if (currentPage <= 0){
            currentPage = 1;
        }
        //创建一个空的PageBean对象
        PageBean<Blog> pb = new PageBean<Blog>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用dao查询总记录数
        int totalCount = dao.SearchTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.计算开始的记录索引
        int start = (currentPage - 1)*rows;
        //5.调用dao查询List集合
        List<Blog> list = dao.searchByPage(start,rows,condition);
        pb.setList(list);
        //6.计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Blog findBlogById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateBlog(Blog blog) {
        dao.update(blog);
    }
}
