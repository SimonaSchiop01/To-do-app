package com.example.backend.Repositories;

import com.example.backend.Domains.User;
import com.example.backend.Domains.UserLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoginHistoryRepository  extends JpaRepository<UserLoginHistory, Long> {
 public Optional<UserLoginHistory> findByUser(User user);

 public Optional<UserLoginHistory> findByCurrentRefreshToken(String currentRefreshToken);
}
