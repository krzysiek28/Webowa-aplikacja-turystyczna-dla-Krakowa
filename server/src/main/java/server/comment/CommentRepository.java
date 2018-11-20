package server.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findCommentEntitiesByMonument(Integer monumentId);
    List<CommentEntity> findCommentEntitiesByUser(Integer userId);

    @Transactional
    long deleteCommentEntityByUser(Integer ownerId);

    @Transactional
    long deleteCommentEntityByMonument(Integer monumentId);

}
