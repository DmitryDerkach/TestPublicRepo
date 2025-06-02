package com.example.java_ifortex_test_task.repository;

import com.example.java_ifortex_test_task.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
	@Query(value = "SELECT s.id, s.user_id, s.started_at_utc, s.ended_at_utc, (s.device_type - 1) AS device_type FROM sessions s WHERE s.device_type = 2 ORDER BY s.started_at_utc ASC LIMIT 1", nativeQuery = true)
	Session getFirstDesktopSession();

	@Query(value = "SELECT s.id, s.user_id, s.started_at_utc, s.ended_at_utc, (s.device_type - 1) AS device_type "
	        + "FROM sessions s "
			+ "INNER JOIN users u ON s.user_id = u.id " + "WHERE u.deleted = false "
			+ "AND s.ended_at_utc IS NOT NULL " 
			+ "AND s.ended_at_utc < TIMESTAMP '2025-01-01' "
			+ "ORDER BY s.started_at_utc DESC", nativeQuery = true)
	List<Session> getSessionsFromActiveUsersEndedBefore2025();
}