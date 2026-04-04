class VideoDownloader {
  public String downloadVideo(String url) {
    System.out.println("Download url - "+url);
    return "Video content - "+url;
  }
}
public class BeforeProxy {
    public static void main(String[] args) {
      VideoDownloader v1 = new VideoDownloader();
      String video1 = v1.downloadVideo("proxy-pattern");
      System.out.println(video1);

      VideoDownloader v2 = new VideoDownloader();
      String video1_1 = v2.downloadVideo("proxy-pattern");
      System.out.println(video1_1);
    }
}