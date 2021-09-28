package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Text;
import com.songjing.oasys.mapper.TextMapper;
import com.songjing.oasys.service.TextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (Text)表服务实现类
 *
 * @author songjing
 * @since 2021-04-16 14:49:13
 */
@Service
@Slf4j
public class TextServiceImpl extends ServiceImpl<TextMapper, Text> implements TextService {

    @Resource
    TextMapper textMapper;

    @Override
    public Text policyPush() {
        String textType = "内推政策";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        return textMapper.policyPush(textType, format);
    }
}
