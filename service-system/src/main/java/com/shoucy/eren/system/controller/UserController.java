package com.shoucy.eren.system.controller;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.shoucy.eren.system.entity.User;
import com.shoucy.eren.system.service.UserService;
import com.shoucy.eren.common.controller.BaseController;
import com.shoucy.eren.common.entity.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.shoucy.eren.system.entity.table.UserTableDef.USER;


/**
 * 角色
 */
@Tag(name = "User", description = "系统用户")
@RestController
@RequestMapping("/sys/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @Operation(summary = "登录角色")
    @PostMapping("/login")
    public Result<Map<String, Object>> login() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "admin");
        map.put("role", "admin");
        map.put("roleId", "1");
        map.put("permissions", List.of("*.*.*"));
        return Result.ok(map);
    }

    @Operation(summary = "登录角色")
    @GetMapping("/info")
    public Result<Map<String, Object>> info() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("introduction", "我是你爸爸");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "daddy");
        return Result.ok(map);
    }

    @Operation(summary = "获取用户列表")
    @GetMapping()
    public Result<Page<User>> getList(String userName) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .where(USER.USERNAME.like(userName));
        Page<User> users = userService.page(getPage(), queryWrapper);
        return Result.ok(users);
    }

    @Operation(summary = "获取指定角色")
    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable String id) {
        User user = userService.getById(id);
        return Result.ok(user);
    }

    @Operation(summary = "添加或更新角色")
    @PostMapping()
    public Result<?> save(@RequestBody User user) {
        boolean isSuccess = userService.saveOrUpdate(user);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @Operation(summary = "删除指定角色")
    @DeleteMapping("/{id}")
    public Result<Object> deleteById(@PathVariable String id) {
        boolean isSuccess = userService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
