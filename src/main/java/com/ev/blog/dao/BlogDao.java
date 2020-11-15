package com.ev.blog.dao;

import com.ev.blog.pojo.Blog;
import com.ev.blog.pojo.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {

    Blog getBlog(Long id);  //后台展示博客

    Blog getDetailedBlog(@Param("id") Long id);  //博客详情

    List<Blog> getAllBlog();

    List<Blog> getByTypeId(Long typeId);  //根据类型id获取博客

    List<Blog> getByTagId(Long tagId);  //根据标签id获取博客

    List<Blog> getIndexBlog();  //主页博客展示

    List<Blog> getAllRecommendBlog();  //推荐博客展示

    List<Blog> getSearchBlog(String query);  //全局搜索博客

    List<Blog> searchAllBlog(Blog blog);  //后台根据标题、分类、推荐搜索博客

    @Select("select DATE_FORMAT(b.update_time, '%Y') from t_blog b order by b.update_time desc")
    List<String> findGroupYear();  //查询所有年份，返回一个集合

    List<Blog> findByYear(@Param("year") String year);  //按年份查询博客

    int saveBlog(Blog blog);

    int saveBlogAndTag(BlogAndTag blogAndTag);

    int updateBlog(Blog blog);

    void deleteBlog(Long id);

    //根据博客id查询出评论数量
    int getCommentCountById(Long id);


    void addViews(@Param("id") Long id);

    void deleteBlogAndTag(BlogAndTag blogAndTag);

    void deleteBlogAndTag2(@Param("id") Long id);
}
