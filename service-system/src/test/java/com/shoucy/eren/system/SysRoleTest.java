package com.shoucy.eren.system;

import com.shoucy.eren.system.controller.RoleController;
import com.shoucy.eren.system.entity.Role;
import com.shoucy.eren.system.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysRoleTest {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RoleController roleController;

	@Test
	public void testList() {
//		Result<Page<Role>> list = roleController.getList();
//		System.out.println(list);
	}

	@Test
	public void testAdd() {
		Role role = new Role();
		role.setName("测试角色");
		role.setCode("testRole");
		int insert = roleMapper.insert(role);
		System.out.println(insert);
	}

}
