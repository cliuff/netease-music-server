package cn.edu.cqut.cat.se.nemu.dto;

public class CountDto {
    private Integer userCounts;
    private Integer albumCounts;
    private Integer trackCounts;
    private Integer artistCounts;
    private Integer month;
    private Integer maleCounts;
    private Integer femaleCounts;

    public Integer getMaleCounts() {
        return maleCounts;
    }

    public void setMaleCounts(Integer maleCounts) {
        this.maleCounts = maleCounts;
    }

    public Integer getFemaleCounts() {
        return femaleCounts;
    }

    public void setFemaleCounts(Integer femaleCounts) {
        this.femaleCounts = femaleCounts;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getUserCounts() {
        return userCounts;
    }

    public void setUserCounts(Integer userCounts) {
        this.userCounts = userCounts;
    }

    public Integer getAlbumCounts() {
        return albumCounts;
    }

    public void setAlbumCounts(Integer albumCounts) {
        this.albumCounts = albumCounts;
    }


    public Integer getTrackCounts() {
        return trackCounts;
    }

    public void setTrackCounts(Integer trackCounts) {
        this.trackCounts = trackCounts;
    }

    public Integer getArtistCounts() {
        return artistCounts;
    }

    public void setArtistCounts(Integer artistCounts) {
        this.artistCounts = artistCounts;
    }
}
