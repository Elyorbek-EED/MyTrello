package uz.boom.ergashov.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.boom.ergashov.entity.project.Project;
import uz.boom.ergashov.entity.task.Task;
import uz.boom.ergashov.reposiroty.AbstractRepository;

import java.util.List;

@Transactional
public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {

    @Query("from Task t where t.projectId=:project")
    List<Task> findAllByProject_id(
            @Param("project") Project project);

//
//    @Query(value = "call add_members(task_id =:taskId)", nativeQuery = true)
//    void addMembers(Param Long taskId, String members);
}