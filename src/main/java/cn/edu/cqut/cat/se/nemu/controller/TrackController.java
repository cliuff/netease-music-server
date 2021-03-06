package cn.edu.cqut.cat.se.nemu.controller;


import cn.edu.cqut.cat.se.nemu.dto.TrackDto;
import cn.edu.cqut.cat.se.nemu.dto.TrackInfoDto;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@CrossOrigin
@RequestMapping("/track")
public class TrackController {
    @Autowired
    public ITrackService iTrackService;


    @PostMapping(value = "/")
    public DataResponse getTrackList(Integer page,Integer limit,String artistName,String trackName){

        return iTrackService.getTrackList(page,limit,artistName,trackName);

    }
    @DeleteMapping(value="/delete" ,consumes = "application/json")
    public DataResponse delete(@RequestBody String ids){

        return iTrackService.delete(ids);


    }
    @PutMapping(value="/")
    public DataResponse update(TrackInfoDto trackInfoDto){
        return iTrackService.updateTrack(trackInfoDto);
    }

    @PostMapping(value = "/add")
    public DataResponse add(TrackInfoDto trackInfoDto){

        return iTrackService.add(trackInfoDto);
    }

    @RequestMapping(value = "select1",method = RequestMethod.GET)
    public DataResponse trackAndlyric(){
        return  iTrackService.trackAndlyric();
    }
    @PutMapping(value="/update")
    public DataResponse update1(TrackInfoDto trackInfoDto){
        return iTrackService.updateTrack1(trackInfoDto);
    }

    @DeleteMapping(value = "select2",consumes = "application/json")
    public DataResponse trackAndlyric1(@RequestBody String trackId){
        System.out.println("!!!!!!!!!!!!!!"+trackId);
        return  iTrackService.trackAndlyric1(trackId);
    }

}

