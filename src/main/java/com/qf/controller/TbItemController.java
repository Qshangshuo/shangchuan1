package com.qf.controller;


import com.qf.pojo.TbItem;
import com.qf.service.TbItemService;
import com.qf.utils.FastDFSClient;
import com.qf.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Controller
public class TbItemController
{
    @Resource
    private TbItemService tbItemService;

    @ResponseBody
    @RequestMapping("/findAll")
    public R findAll()
    {
        List<TbItem> all = tbItemService.findAll();
        return R.ok().put("tbItems",all);
    }


    @RequestMapping("/uploader.do")
    @ResponseBody
    public R upload(@RequestParam MultipartFile file)
    {
        StringBuilder sb=new StringBuilder("http://192.168.111.100/");
        try{
//            //拿到文件名
//            String filename=file.getOriginalFilename();
//            //截取后缀
//            String suffix = filename.substring(filename.lastIndexOf(".") + 1);
            //上传图片
//            FastDFSClient client = new FastDFSClient("client.conf");
//            String[] s=client.uploadFile(file.getBytes(),suffix);
//            for (int i = 0; i <s.length ; i++)
//            {
//                sb.append(s[i]);
//                if (i==0)
//                {
//                    sb.append(File.separator);
//                }
//            }
//            System.out.println("成功"+sb);
//            return R.ok("上传成功").put("path",sb.toString());
            String filename = file.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf(".") + 1);
            FastDFSClient client=new FastDFSClient("client.conf");
            String[] s = client.uploadFile(file.getBytes(), suffix);
            for (int i = 0; i < s.length; i++) {
                sb.append(s[i]);
                if (i==0)
                {
                    sb.append(File.separator);
                }
            }
            System.out.println("成功"+sb);
            return R.ok("上传成功").put("path",sb.toString());

        }catch (Exception e)
        {
            e.printStackTrace();
            return R.ok("上传失败");
        }
    }
    //新增商品
    @ResponseBody
    @RequestMapping("/doAddTbItem.do")
    public R addItem(TbItem item)
    {
        boolean f=tbItemService.save(item);
        if (f)
        {
            return R.ok("新增成功");
        }
        return R.error("新增失败");
    }



}
