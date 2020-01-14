package com.gene.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gene.common.ServiceResult;
import com.gene.dao.entity.Donate;
import com.gene.dao.mapper.DonateMapper;
import com.gene.service.IDonateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DonateServiceImpl extends ServiceImpl<DonateMapper, Donate> implements IDonateService {

    @Transactional
    @Override
    public ServiceResult addDonate(Donate donate) throws Exception {
        ServiceResult result  = new ServiceResult();
        try{

            this.baseMapper.insert(donate);
            result.succeed();
        }catch (Exception e) {

//            logger.error("捐赠入库失败");
            result.failed("操作失败");
        }

        return result;
    }
}
