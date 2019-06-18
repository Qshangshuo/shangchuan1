package com.qf.service.impl;

import com.qf.mapper.TbItemMapper;
import com.qf.pojo.TbItem;
import com.qf.service.TbItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TbItemServiceImpl implements TbItemService {
    @Resource
    private TbItemMapper tbItemMapper;

    public List<TbItem> findAll() {
        List<TbItem> list = tbItemMapper.findAll();


        return list;
    }

    public boolean save(TbItem item) {
        int i = tbItemMapper.saveItem(item);

        return i>0;
    }
}
