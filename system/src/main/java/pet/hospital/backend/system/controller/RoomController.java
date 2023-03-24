/*
 * @Author: dafenqi-11 diaozehao.163.com
 * @Date: 2023-03-22 15:08:24
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 08:30:27
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\controller\RoomController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.system.service.RoomService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/room",
        produces = {"application/json;charset=UTF-8"})
public class RoomController {
    @Autowired
    RoomService roomService;

    @Operation(summary = "获取科室接口")
    @GetMapping(value = "/get")
    public JSONObject getRoom(
            @Parameter(description = "科室名称关键字，支持模糊查询") @RequestParam(required = false) String roomKeyword,
            @Parameter(description = "科室人员角色，NRAD顺序表示无权限、前台、医助、医师") @RequestParam(required = false) String roomRole)
            throws UnsupportedEncodingException {
        return roomService.getRoom(roomKeyword, roomRole);
    }

    @Operation(summary = "新增科室接口")
    @PostMapping(value = "/add")
    public JSONObject addRoom(
            @Parameter(description = "科室名") @RequestParam String roomName,
            @Parameter(description = "科室描述") @RequestParam String roomRole)
            throws UnsupportedEncodingException {
        return roomService.addRoom(
                URLDecoder.decode(roomName, Constants.UTF8), URLDecoder.decode(roomRole, Constants.UTF8));
    }

    @Operation(summary = "更改科室信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateRoom(
            @Parameter(description = "科室名") @RequestParam String roomName,
            @Parameter(description = "科室描述") @RequestParam String roomRole)
            throws UnsupportedEncodingException {
        return roomService.updateRoom(
                URLDecoder.decode(roomName, Constants.UTF8), URLDecoder.decode(roomRole, Constants.UTF8));
    }

    @Operation(summary = "删除科室接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteRoom(@Parameter(description = "科室名") @RequestParam String roomName)
            throws UnsupportedEncodingException {
        return roomService.deleteRoom(URLDecoder.decode(roomName, Constants.UTF8));
    }
}
