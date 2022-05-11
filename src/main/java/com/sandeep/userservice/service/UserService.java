package com.sandeep.userservice.service;

import com.sandeep.userservice.entity.User;
import com.sandeep.userservice.repository.UserRepository;
import com.sandeep.userservice.valueobject.Department;
import com.sandeep.userservice.valueobject.ResponceTempleteVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
  @Autowired private UserRepository userRepository;

  @Autowired private RestTemplate restTemplate;

  public User saveUser(User user) {
    log.info("save user inside userService");
    return userRepository.save(user);
  }

  public User findByuserId(Long userId) {
    return userRepository.findByuserId(userId);
  }

  public ResponceTempleteVO getUserWithDepartment(Long userId) {
    ResponceTempleteVO responceTempleteVO = new ResponceTempleteVO();
    User user = userRepository.findByuserId(userId);

    // http://localhost:8084/department/ is equals to http://DEPARTMENT-SERVICE/department/
    Department department =
        restTemplate.getForObject(
            "http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(), Department.class);
    responceTempleteVO.setDepartment(department);
    responceTempleteVO.setUser(user);
    return responceTempleteVO;
  }
}
