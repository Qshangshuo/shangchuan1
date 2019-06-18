package com.qf.service;

import com.qf.pojo.TbItem;

import java.util.List;

public interface TbItemService
{
    public List<TbItem> findAll();

    public  boolean save(TbItem item);
}
