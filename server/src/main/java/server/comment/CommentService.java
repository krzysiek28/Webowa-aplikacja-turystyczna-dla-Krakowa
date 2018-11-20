package server.comment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentEntity getComment(Integer commentId){
        if (!commentRepository.exists(commentId)) {
            throw new IllegalArgumentException("Komentarz nie istnieje");
        }
        return commentRepository.findOne(commentId);
    }

    public List<CommentEntity> getAllCommentsByOwner(Integer userId){
        return commentRepository.findCommentEntitiesByUser(userId);
    }

    public List<CommentEntity> getAllCommentsByMonument(Integer monumentId){
        return commentRepository.findCommentEntitiesByMonument(monumentId);
    }

    public void addComment(CommentEntity comment){
        if(!comment.validate()){
            throw new IllegalArgumentException("Podano nieprawidowe dane");
        }
        commentRepository.save(comment);
    }

    public void updateComment(Integer commentId, CommentEntity comment){
        if(!commentRepository.exists(commentId)){
            throw new IllegalArgumentException("Komentarz nie istnieje!");
        }
        if(!comment.validate()){
            throw new IllegalArgumentException("Podano nieprawidowe dane");
        }
        CommentEntity dbComment = commentRepository.findOne(commentId);
        dbComment.setUser(comment.getUser());
        dbComment.setDescription(comment.getDescription());
        dbComment.setMonument(comment.getMonument());
        dbComment.setRate(comment.getRate());
        commentRepository.save(dbComment);
    }

    public void deleteComment(Integer commentId){
        if(!commentRepository.exists(commentId)){
            throw new IllegalArgumentException("Komentarz nie istnieje!");
        }
        commentRepository.delete(commentId);
    }
}
