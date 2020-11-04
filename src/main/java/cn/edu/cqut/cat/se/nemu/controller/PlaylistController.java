package cn.edu.cqut.cat.se.nemu.controller;


import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.IPlaylistService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final IPlaylistService service;

    @Autowired
    public PlaylistController(IPlaylistService service) {
        this.service = service;
    }

    @GetMapping("/")
    public DataResponse getPlaylists() {

        return service.getPlaylists();
    }
    @GetMapping(value = "/lunbo")
    public DataResponse getLunbo(){

      return service.getLunbo();

    }
    @GetMapping(value="/categary")
    public DataResponse getCategary()
    {
        return service.getCategary();
    }

    @PostMapping(value = "/play")
    public DataResponse getPlaylist(Integer page,Integer limit){


           return service.getPlaylist(page,limit);



    }

    @PostMapping(value="/playlistByGenre")
    public DataResponse getPlaylistByGenre(Integer page,Integer limit,String genre){

        return  service.getPlaylistByGenre(page,limit,genre);

    }

    @GetMapping(value = "/playlistByAuthor")
    public DataResponse getPlaylistByAuthor(String author){

        return service.getPlaylistByAuthor(author);
    }

    @GetMapping(value = "/tracksByPlaylistId")
    public DataResponse getTracksByPlaylistId(String playlistId){

        return service.getTracksByPlaylistId(playlistId);
    }
    @GetMapping(value="/allPlaylistInfo")
    public DataResponse getAllPlaylistInfo(){
        return service.getAllPlaylistInfo();
    }

}

