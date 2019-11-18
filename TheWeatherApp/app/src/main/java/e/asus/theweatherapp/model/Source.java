
package e.asus.theweatherapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Source {

    @SerializedName("crawl_rate")
    private Long crawlRate;
    @Expose
    private String slug;
    @Expose
    private String title;
    @Expose
    private String url;

    public Long getCrawlRate() {
        return crawlRate;
    }

    public void setCrawlRate(Long crawlRate) {
        this.crawlRate = crawlRate;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
