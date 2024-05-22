package dao.impl;

import dao.CommentDao;
import domain.Comment;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public List<Comment> getCommentsByNewsId(int newsId) {
        return null;
    }

    @Override
    public int updateLikeNum(int commentId, boolean like) {
        return 0;
    }

    @Override
    public int updateDislikeNum(int commentId, boolean dislike) {
        return 0;
    }

    @Override
    public void hiddenComment(long commentId, boolean hidden) {

    }
}
