package com.shoucy.eren.admin;

import com.mybatisflex.core.paginate.Page;
import com.shoucy.eren.admin.controller.RoleController;
import com.shoucy.eren.admin.entity.Role;
import com.shoucy.eren.admin.mapper.RoleMapper;
import com.shoucy.eren.common.entity.Result;
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
		role.setRoleName("测试角色");
		role.setRoleCode("testRole");
		int insert = roleMapper.insert(role);
		System.out.println(insert);
	}

}
