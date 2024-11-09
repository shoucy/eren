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
    public Result<Page<Role>> getList(String roleName) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .where(ROLE.ROLE_NAME.like(roleName));
        Page<Role> roles = roleService.page(getPage(), queryWrapper);
        return Result.ok(roles);
    }

    @Operation(summary = "获取指定角色")
    @GetMapping("/{id}")
    public Result<Role> getById(@PathVariable String id) {
        Role role = roleService.getById(id);
        return Result.ok(role);
    }

    @Operation(summary = "添加角色")
    @PostMapping()
    public Result<?> save(@RequestBody Role role) {
        roleService.save(role);
        return Result.ok();
    }

    @Operation(summary = "修改指定角色")
    @PutMapping("/update")
    public Result<Object> update(Role role) {
        boolean isSuccess = roleService.updateById(role);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @Operation(summary = "删除指定角色")
    @DeleteMapping("/{id}")
    public Result<Object> deleteById(@PathVariable String id) {
        boolean isSuccess = roleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
