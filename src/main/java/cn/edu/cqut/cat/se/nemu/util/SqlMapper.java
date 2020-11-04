package cn.edu.cqut.cat.se.nemu.util;

public class SqlMapper {

    public String selectTrackInfo(String artistName,String trackName){

        StringBuffer sql = new StringBuffer("SELECT track_id,track_name,artist_name,album_name,track.length,track.cover,track.time,track.genre,track.region,track_desc,lyrics FROM `track`,artist,album\n" +
                "where track.album = album.album_id\n" +
                "and track.artist = artist.artist_id and 1=1");

        if(artistName!=null && (trackName==null||trackName=="")){
            sql.append(" and artist_name like '%"+artistName+"%'");

        }
        else if(trackName!=null &&(artistName==null||artistName=="")){
            sql.append(" and track_name like '%"+trackName+"%'");
        }
        else if(trackName!=null && artistName!=null){
            sql.append(" and (track_name like '%"+trackName+"%'" +
                    " or artist_name like '%"+artistName+"%'" +
                    ")");
        }
        return sql.toString();
    }
}
