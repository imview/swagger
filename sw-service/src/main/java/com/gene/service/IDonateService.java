package com.gene.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gene.common.ServiceResult;
import com.gene.dao.entity.Donate;

public interface IDonateService extends IService<Donate> {

    ServiceResult addDonate(Donate donate)throws Exception;

}
