package cn.edu.cqut.cat.se.nemu.controller;


import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Playlist> data = service.list();
        return new DataResponse().setDataList(data);
    }
}

