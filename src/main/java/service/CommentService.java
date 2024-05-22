package service;

import domain.*;

import java.util.List;

public interface CommentService {
    /**
     * 增加评论
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 根据新闻编号获取所有评论（包括对该评论的回复，并建立评论与回复的关联关系）
     * @param newsId
     * @return
     */
    List<Comment> getCommentsByNewsId(int newsId);

    /**
     * 更新点赞数
     * @param commentId 评论ID
     * @param like true:点赞 或 false:取消点赞
     * @return
     */
    int updateLikeNum(int commentId, boolean like);

    /**
     * 更新点踩数
     * @param commentId 评论ID
     * @param dislike true:点踩 或 false:取消点踩
     * @return
     */
    int updateDislikeNum(int commentId, boolean dislike);

    /**
     * 删除评论（假删除，只是隐藏）
     * @param commentId
     */
    boolean deleteComment(long commentId);

    /**
     * 恢复评论（假删除，只是隐藏）
     * @param commentId
     * @return
     */
    boolean recoverComment(long commentId);
}
