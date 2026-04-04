import java.util.HashMap;
import java.util.Map;
interface VideoDownloaderPP {
  public String downloadVideo(String url);
}

class RealVideoDownloader implements VideoDownloaderPP {
  @Override
  public String downloadVideo(String url) {
    System.out.println("Download Video - "+url);
    return "Video Content - "+url;
  }
}

class ProxyVideoDownloader implements VideoDownloaderPP {
  private VideoDownloaderPP videoDownload;
  private Map<String, String> cache;
  public ProxyVideoDownloader(VideoDownloaderPP videoDownload) {
    this.videoDownload = videoDownload;
    cache = new HashMap<>();
  }

  @Override
  public String downloadVideo(String url) {
    if(cache.containsKey(url)) {
      System.out.println("Return video from cache - "+url);
      return cache.get(url);
    }
    String video = videoDownload.downloadVideo(url);
    cache.put(url, video);
    return video;
  }
}
class AfterProxy {
    public static void main(String[] args) {
      VideoDownloaderPP pvd = new ProxyVideoDownloader(new RealVideoDownloader());
      System.out.println(pvd.downloadVideo("proxy-pattern"));
      System.out.println(pvd.downloadVideo("proxy-pattern"));
    }
}