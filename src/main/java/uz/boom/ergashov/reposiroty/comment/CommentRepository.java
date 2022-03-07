package uz.boom.ergashov.reposiroty.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.ergashov.entity.comment.Comment;
import uz.boom.ergashov.reposiroty.AbstractRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, AbstractRepository {
}
