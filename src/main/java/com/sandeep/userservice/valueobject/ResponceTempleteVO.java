package com.sandeep.userservice.valueobject;

import com.sandeep.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceTempleteVO {

  private User user;
  private Department department;
}
