//package com.example.java_ifortex_test_task.service;
//
//import com.example.java_ifortex_test_task.dto.SessionResponseDTO;
//import com.example.java_ifortex_test_task.entity.Session;
//import com.example.java_ifortex_test_task.mapper.SessionMapper;
//import com.example.java_ifortex_test_task.repository.SessionRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class SessionService {
//	private final SessionRepository sessionRepository;
//	private final SessionMapper sessionMapper;
//
//	public SessionResponseDTO getFirstDesktopSession() {
//		Session session = sessionRepository.getFirstDesktopSession();
//		return sessionMapper.toDto(session);
//	}
//
//	public List<SessionResponseDTO> getSessionsFromActiveUsersEndedBefore2025() {
//		List<Session> sessions = sessionRepository.getSessionsFromActiveUsersEndedBefore2025();
//
//		return sessions.stream().map(sessionMapper::toDto).collect(Collectors.toList());
//	}
//}

package com.example.java_ifortex_test_task.service;

import com.example.java_ifortex_test_task.dto.SessionResponseDTO;
import com.example.java_ifortex_test_task.entity.Session;
import com.example.java_ifortex_test_task.mapper.SessionMapper;
import com.example.java_ifortex_test_task.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    // Returns the first (earliest) desktop Session
    public SessionResponseDTO getFirstDesktopSession() {
        Session firstDesktopSession = sessionRepository.getFirstDesktopSession();
        return sessionMapper.toDto(firstDesktopSession);
    }

    // Returns only Sessions from Active users that were ended before 2025
    public List<SessionResponseDTO> getSessionsFromActiveUsersEndedBefore2025() {
        return sessionRepository.getSessionsFromActiveUsersEndedBefore2025()
                .stream()
                .map(sessionMapper::toDto)
                .toList();
    }
}
