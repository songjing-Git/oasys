package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Reimbursement;
import com.songjing.oasys.mapper.ReimbursementMapper;
import com.songjing.oasys.service.ReimbursementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (Reimbursement)表服务实现类
 *
 * @author songjing
 * @since 2021-04-18 14:34:15
 */
@Service
@Slf4j
public class ReimbursementServiceImpl extends ServiceImpl<ReimbursementMapper, Reimbursement> implements ReimbursementService {

}
