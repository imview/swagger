package com.gene.api.controller;

import com.gene.common.Pagination;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
    public void addPaginationAttribute(Model model, Pagination pagination){
        model.addAttribute("iIndex", pagination.getPageIndex());
        model.addAttribute("iSize", pagination.getPageSize());
        model.addAttribute("iCount", pagination.getTotalCount());
    }
    public void addPaginationAttribute(ModelAndView model, Pagination pagination){
        model.addObject("iIndex", pagination.getPageIndex());
        model.addObject("iSize", pagination.getPageSize());
        model.addObject("iCount", pagination.getTotalCount());
    }
}
