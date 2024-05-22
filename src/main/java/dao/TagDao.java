package dao;

import domain.Tag;

import java.util.List;
import java.util.Set;

public interface TagDao {
    /**
     * 获取所有标签
     * @return
     */
    List<Tag> getAllTags();

    /**
     * 根据新闻编号获取标签集合
     * @param newsId
     * @return
     */
    Set<Tag> getTagsByNewsId(int newsId);


    /**
     * 新闻-标签组合是否存在
     * @param newsId
     * @param tagId
     * @return
     */
    boolean isNewsTagExisted(int newsId, int tagId);
    /**
     * 为新闻添加标签
     * @param newsId
     * @param tagId
     */
    void addTagForNews(int newsId, int tagId);


    /**
     * 删除新闻的所有标签
     * @param newsId
     */
    void deleteTagsForNews(int newsId);

    Tag getTagById(int tagId);
}
