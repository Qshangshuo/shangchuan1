package com.qf.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDFSClient
{
    private TrackerServer trackerServer=null;
    private TrackerClient trackerClient=null;
    private StorageServer storageServer=null;
    private StorageClient storageClient=null;

    public FastDFSClient(String conf) throws Exception
    {

        String path=this.getClass().getResource("/").getPath();
        ClientGlobal.init(path+conf);
        trackerClient=new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageClient=new StorageClient(trackerServer,storageServer);
    }
    public String[] uploadFile(String fileName, String extName, NameValuePair[] metas) throws IOException, MyException {
        String[] strings = storageClient.upload_file(fileName, extName, metas);
        return strings;
    }

    public String[] uploadFile(String fileName,String extName) throws IOException, MyException {
        String[] strings = storageClient.upload_file(fileName, extName, null);
        return strings;
    }

    public String[] uploadFile(String fileName) throws IOException, MyException {
        String[] strings = storageClient.upload_file(fileName, null, null);
        return strings;
    }
    public String[] uploadFile(byte[] fileContent,String extName,NameValuePair[] metas) throws IOException, MyException {
        String[] strings = storageClient.upload_file(fileContent, extName, metas);
        return strings;
    }

    public String[] uploadFile(byte[] fileContent,String extName )throws IOException, MyException {
        String[] strings = storageClient.upload_file(fileContent, extName, null);
        return strings;
    }

    public String[] uploadFile(byte[] fileContent) throws IOException, MyException {
        String[] strings = storageClient.upload_file(fileContent, null, null);
        return strings;
    }
}
