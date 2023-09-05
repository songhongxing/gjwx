package cn.yuxi.gjwx.controller;

import cn.yuxi.gjwx.config.BaseController;
import cn.yuxi.gjwx.util.HjDict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/zhuce")
    private HjDict zhuce(){
        return null;
    }
}
