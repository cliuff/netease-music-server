package cn.edu.cqut.cat.se.nemu.controller;


import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    public ITrackService iTrackService;


    @PostMapping(value = "/")
    public DataResponse getTrackList(Integer page,Integer limit,String artistName,String trackName){

        return iTrackService.getTrackList(page,limit,artistName,trackName);

    }


}

