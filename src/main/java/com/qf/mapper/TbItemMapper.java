package com.qf.mapper;

import com.qf.pojo.TbItem;

import java.util.List;

public interface TbItemMapper
{
    public int saveItem(TbItem tbItem);


    public List<TbItem> findAll();
}
