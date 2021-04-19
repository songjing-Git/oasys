package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Reimbursement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Reimbursement)表服务接口
 *
 * @author songjing
 * @since 2021-04-18 14:34:15
 */
@Mapper
@Repository
public interface ReimbursementMapper extends BaseMapper<Reimbursement> {

}
