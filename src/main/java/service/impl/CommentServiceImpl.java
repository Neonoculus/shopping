package service.impl;

import domain.Comment;
import service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
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
    public boolean deleteComment(long commentId) {
        return false;
    }

    @Override
    public boolean recoverComment(long commentId) {
        return false;
    }
}
