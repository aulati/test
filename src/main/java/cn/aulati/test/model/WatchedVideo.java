package cn.aulati.test.model;

public class WatchedVideo implements Comparable<WatchedVideo> {

    /** 视频观看频率 */
    public int freq;

    /** 视频的名字 */
    public String videoId;

    public WatchedVideo() {
        this("", 0);
    }

    public WatchedVideo(String id, int freq) {
        this.videoId = id;
        this.freq = freq;
    }

    /**
     * 按观看视频排序，观看视频相同的，按视频名称字典顺序排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(WatchedVideo o) {
        int ret = this.freq - o.freq;
        if (ret != 0) {
            return ret;
        } else {
            return this.videoId.compareTo(o.videoId);
        }
    }
}
