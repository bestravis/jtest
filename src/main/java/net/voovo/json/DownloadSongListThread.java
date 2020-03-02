package net.voovo.json;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import net.voovo.json.entity.SongList;

import java.io.File;

public class DownloadSongListThread implements Runnable{

    final static String basePath= "e:"+File.separator+"音频数据";

    SongList songList;

    public SongList getSongList() {
        return songList;
    }

    public void setSongList(SongList songList) {
        this.songList = songList;
    }

    public static void main(String[] args) {
        System.out.println(basePath);
    }

    @Override
    public void run() {
        String groupName=null;
        JSONArray songs = songList.getSongs();
        String imgUrl,imgUrl2;
        for (int i = 0; i < songs.size(); i++) {
            JSONObject json=(JSONObject)songs.get(i);
            json.toJSONString();
            groupName=json.getString("groupName");
            JSONArray array=json.getJSONArray("list");

//            imgUrl=basePath+File.separator+songList.getSongListName()+File.separator+"listImg.png";
//            HttpUtil.downloadFile(songList.getListImg(),imgUrl);
//            System.out.println(songList.getListImg());
//            imgUrl2=basePath+File.separator+songList.getSongListName()+File.separator+"publicImg.png";
//            System.out.println(songList.getPublicImg());
//            HttpUtil.downloadFile(songList.getPublicImg(),imgUrl2);

            for (Object song:array){
                JSONObject j=(JSONObject)song;
                System.out.println(j);
                String path=basePath+File.separator+songList.getSongListName()+File.separator+groupName+File.separator;
                if(j.getString("fileUrl").lastIndexOf("mp3")==-1){
                    System.out.println("error:"+j.getString("fileUrl"));
                }
                String name=j.getString("name");

                path=path+j.getString("name")+".mp3";

                try {
                    HttpUtil.downloadFile(j.getString("fileUrl"),path);
                }catch (Exception e){
                    System.out.println("error:"+j.getString("name")+JSONObject.toJSONString(songList));
                }
            }
        }
        //HttpUtil.downloadFile("http://……",basePath+File.separator+songList.getSongListName()+File.separator+groupName+File.separator+"songs");

    }
}
