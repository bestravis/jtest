package net.voovo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.voovo.json.entity.Song;
import net.voovo.json.entity.SongList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ParseJSONData {

    public static void main(String[] args) {
        final Executor executor = Executors.newCachedThreadPool();//启用多线程
        File folder=new File("E:\\音頻json");
        System.out.println(folder.isDirectory());
        File[] files=folder.listFiles();
        String tmp;
        JSONObject json;
        JSONArray songsJson;
        for (int i = 0; i < files.length; i++) {
            tmp=txt2String(files[i]);
            json= JSONObject.parseObject(tmp);
            songsJson=json.getJSONObject("data").getJSONArray("songList");
            json=json.getJSONObject("data").getJSONObject("songListInfo");
            SongList songList=SongList.builder()
                    .songListId(json.getInteger("id"))
                    .songListName(json.getString("name"))
                    .listImg(json.getString("listImg"))
                    .publicImg(json.getString("publicImg")).build();
            songList.setSongs(songsJson);
            DownloadSongListThread thread=new DownloadSongListThread();
            thread.setSongList(songList);

            executor.execute(thread);
            //Song song= Song.builder().groupName().songName().fileUrl().build()
            //System.out.println(JSONObject.toJSONString(songList));
        }
    }

    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
