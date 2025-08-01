
package com.skillsync.skillsync_backend.repository;

import com.skillsync.skillsync_backend.model.LearningGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningGoalRepository extends JpaRepository<LearningGoal, Long> {
    List<LearningGoal> findByUserId(Long userId);
}
