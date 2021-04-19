package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.Text;
import com.songjing.oasys.service.TextService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Text)表控制层
 *
 * @author songjing
 * @since 2021-04-16 14:49:13
 */
@RestController
@RequestMapping("text")
public class TextController extends ApiController {

    @Resource
    TextService textService;

    @ApiOperation("内推政策")
    @PostMapping("policyPush")
    public Text policyPush(){
        return textService.policyPush();
    }

}
