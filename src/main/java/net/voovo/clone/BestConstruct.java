package net.voovo.clone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @Author yml
 * @Date 2020/5/18
 */
public class BestConstruct {

    public static void main(String[] args) {
        StopWatch sw = StopWatch.createStarted();
        sw.reset();
        sw.start();

        for (int i = 0; i < 100000; i++) {
            new Song(i,"a");
        }
        sw.stop();
        System.out.println(sw.getTime());
    }

}


@ToString
@Setter
@Getter
class Song {
    private Integer id;
    private String name;

    public Song() {
    }

    public Song(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

@ToString
@Setter
@Getter
class music implements Cloneable{
    private Integer id;
    private String name;

    public music() {
    }

    public music(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
