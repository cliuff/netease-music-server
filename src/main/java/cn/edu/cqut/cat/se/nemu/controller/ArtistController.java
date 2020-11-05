package cn.edu.cqut.cat.se.nemu.controller;


import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/artist")
public class ArtistController {

  @Autowired
  public IArtistService iArtistService;


    @GetMapping(value="/count")
    public DataResponse getSortCounts(){
        return iArtistService.getSortCounts();
    }
    @GetMapping(value = "/countByMonth")
    public DataResponse getCountByMonth(){
      return iArtistService.getCountByMonth();
    }

    @GetMapping(value = "/countBySex")
  public DataResponse getCountBySex(){
      return iArtistService.getCountBySex();
    }


}

