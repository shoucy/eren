package com.shoucy.eren.system.controller;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.shoucy.eren.common.controller.BaseController;
import com.shoucy.eren.common.entity.Result;
import com.shoucy.eren.system.entity.Role;
import com.shoucy.eren.system.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.shoucy.eren.system.entity.table.RoleTableDef.ROLE;

/**
 * 角色
 *
 * @author shoucy
 */
@Tag(name = "Role", description = "系统角色")
@RestController
@RequestMapping("/sys/role")
@RequiredArgsConstructor
public class RoleController extends BaseController {

    private final RoleService roleService;

    @Operation(summary = "获取角色列表")
    @GetMapping()
    public Result<Page<Role>> getList(String roleName, String roleCode, String status) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .where(ROLE.NAME.like(roleName)
                        .and(ROLE.CODE.like(roleCode))
                        .and(ROLE.STATUS.eq(status)));
        Page<Role> roles = roleService.page(getPage(), queryWrapper);
        return Result.ok(roles);
    }

    @Operation(summary = "获取指定角色")
    @GetMapping("/{id}")
    public Result<Role> getById(@PathVariable String id) {
        Role role = roleService.getById(id);
        return Result.ok(role);
    }

    @Operation(summary = "添加或更新角色")
    @PostMapping()
    public Result<?> save(@RequestBody Role role) {
        // 角色代码应该唯一
        QueryWrapper queryWrapper = QueryWrapper.create()
                .where(ROLE.CODE.eq(role.getCode()));
        long count = roleService.count(queryWrapper);
        if (count != 0) {
            return Result.fail("该角色代码已存在");
        }
        boolean isSuccess = roleService.saveOrUpdate(role);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @Operation(summary = "删除指定角色")
    @DeleteMapping("/{id}")
    public Result<Object> deleteById(@PathVariable String id) {
        boolean isSuccess = roleService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }
}
